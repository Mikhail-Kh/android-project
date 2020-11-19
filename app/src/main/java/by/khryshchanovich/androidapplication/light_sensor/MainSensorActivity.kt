package by.khryshchanovich.androidapplication.light_sensor

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import by.khryshchanovich.androidapplication.R
import kotlinx.android.synthetic.main.activity_main_sensor.*

class MainSensorActivity : AppCompatActivity(), SensorEventListener {

    lateinit var sensorManager: SensorManager
    lateinit var sensorLight: Sensor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_sensor)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensorLight = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
    }

    override fun onResume() {
        super.onResume()
        sensorManager.registerListener(this, sensorLight, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onSensorChanged(event: SensorEvent?) {
        if (event?.sensor?.type == Sensor.TYPE_LIGHT) {
            getLightSensor(event)
        }
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun getLightSensor(event: SensorEvent?) {
        sensor_recycler.layoutManager = LinearLayoutManager(this)
        val light = ArrayList<LightSensor>()
        light.add(LightSensor("Light level, lx ", event?.values?.get(0).toString()))
        light.add(LightSensor("Name ", sensorLight.name))
        light.add(LightSensor("Vendor ", sensorLight.vendor))
        light.add(LightSensor("Version", sensorLight.version.toString()))
        light.add(LightSensor("Resolution, Sen.U ", sensorLight.resolution.toString()))
        light.add(LightSensor("Power, mA ", sensorLight.power.toString()))
        light.add(LightSensor("Max range, Sen.U ", sensorLight.maximumRange.toString()))
        light.add(LightSensor("Max delay, µs ", sensorLight.maxDelay.toString()))
        light.add(LightSensor("Min delay, µs ", sensorLight.minDelay.toString()))
        sensor_recycler.adapter = LightSensorAdapter(light)
        sensor_recycler.hasFixedSize()
    }
}