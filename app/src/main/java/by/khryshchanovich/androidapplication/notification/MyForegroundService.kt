package by.khryshchanovich.androidapplication.notification

import android.app.Notification
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.graphics.drawable.Icon
import android.os.Build
import android.os.IBinder
import by.khryshchanovich.androidapplication.R

class MyForegroundService : Service() {
    override fun onCreate() {
        super.onCreate()

        val broadcastIntent = Intent(this, MainNotificationActivity::class.java)

        val pendingIntent = PendingIntent.getActivity(
            this,
            1,
            broadcastIntent,
            PendingIntent.FLAG_CANCEL_CURRENT
        )

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notification = Notification.Builder(this, NOTIFICATION_CHANNEL_ID)
                .setContentTitle("Timer notification")
                .setContentText("Time is over")
                .setSmallIcon(R.drawable.ic_baseline_timer_off_24)
                .addAction(
                    Notification.Action.Builder(
                        Icon.createWithResource(this, R.drawable.ic_launcher_foreground),
                        "Back",
                        pendingIntent
                    ).build()
                )
                .build()
            startForeground(1, notification)
        }
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}