package by.khryshchanovich.androidapplication.weather_widget.widget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.View
import android.widget.RemoteViews
import android.widget.Toast
import androidx.annotation.RequiresApi
import by.khryshchanovich.androidapplication.R
import by.khryshchanovich.androidapplication.weather_widget.MainWidgetActivity
import by.khryshchanovich.androidapplication.weather_widget.dto.WeatherResponse
import by.khryshchanovich.androidapplication.weather_widget.mappers.WeatherMapper
import by.khryshchanovich.androidapplication.weather_widget.networking.API_ID
import by.khryshchanovich.androidapplication.weather_widget.networking.CITY
import by.khryshchanovich.androidapplication.weather_widget.networking.UNITS
import by.khryshchanovich.androidapplication.weather_widget.networking.WeatherApi
import by.khryshchanovich.androidapplication.weather_widget.retrofit.RetrofitFactory
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.internal.format
import retrofit2.Response
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

private const val REQUEST_HOME = 111
private const val REQUEST_UPDATE = 222

class WeatherAppWidget : AppWidgetProvider() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }

        val remoteViews = RemoteViews(context.packageName, R.layout.weather_app_widget)

        val homeIntent = PendingIntent.getActivity(
            context,
            REQUEST_HOME,
            Intent(context, MainWidgetActivity::class.java),
            PendingIntent.FLAG_UPDATE_CURRENT
        )
        remoteViews.setOnClickPendingIntent(R.id.home_widget, homeIntent)

        val actionUpdateIntent = Intent()
        actionUpdateIntent.action = AppWidgetManager.ACTION_APPWIDGET_UPDATE
        actionUpdateIntent.putExtra("key", appWidgetIds)

        val updateIntent = PendingIntent.getBroadcast(
            context,
            REQUEST_UPDATE,
            actionUpdateIntent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
        remoteViews.setOnClickPendingIntent(R.id.update_widget, updateIntent)

        val retrofit: WeatherApi = RetrofitFactory().getRetrofit()
        val formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd.MM.YYYY")

        CoroutineScope(Dispatchers.IO).launch {
            val response: Response<WeatherResponse> =
                retrofit.getWeatherAsync(CITY, API_ID, UNITS).await()

            if (response.isSuccessful) {
                val weatherResponse = response.body().let {
                    WeatherMapper().map(it)
                }
                val dt = weatherResponse.dt
                val city = weatherResponse.city
                val temp = weatherResponse.temperature
                val desc = weatherResponse.description
                val icon = weatherResponse.icon
                val iconPicasso = Picasso.get()
                    .load("https://openweathermap.org/img/wn/${icon}@2x.png")
                val time = Instant.ofEpochSecond(dt.toLong()).atZone(ZoneId.systemDefault())
                    .toLocalDateTime().format(formatter).toString()

                remoteViews.setTextViewText(R.id.time_text_view, time)
                remoteViews.setTextViewText(R.id.city_text_view, city)
                remoteViews.setTextViewText(
                    R.id.temperature_text_view,
                    format("%.0f", temp) + "\u00b0" + "C"
                )
                remoteViews.setTextViewText(R.id.condition_text_view, desc)
                remoteViews.setImageViewBitmap(R.id.icon_image_view, iconPicasso.get())
                appWidgetManager.updateAppWidget(appWidgetIds, remoteViews)
            } else {
                remoteViews.setViewVisibility(R.id.progress_bar, View.VISIBLE)
                appWidgetManager.updateAppWidget(appWidgetIds, remoteViews)
            }
        }
    }

    override fun onDeleted(context: Context, appWidgetIds: IntArray) {
        // When the user deletes the widget, delete the preference associated with it.
        for (appWidgetId in appWidgetIds) {
            deleteTitlePref(context, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onReceive(context: Context, intent: Intent?) {
        super.onReceive(context, intent)

        if (intent?.action == AppWidgetManager.ACTION_APPWIDGET_UPDATE) {
            val appWidgetManager = AppWidgetManager.getInstance(context)
            val appWidgetIds = intent.extras?.getIntArray("key")
            if (appWidgetIds != null) {
                onUpdate(context, appWidgetManager, appWidgetIds)
            }
        }
    }
}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {
    val widgetText = loadTitlePref(context, appWidgetId)
    // Construct the RemoteViews object
    val views = RemoteViews(context.packageName, R.layout.weather_app_widget)
    views.setTextViewText(R.id.appwidget_text, widgetText)

    // Instruct the widget manager to update the widget
    appWidgetManager.updateAppWidget(appWidgetId, views)
}