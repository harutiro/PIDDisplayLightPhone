package net.harutiro.piddisplaylightphone.ViewModel.Sensor

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.util.Log
import net.harutiro.piddisplaylightphone.Utlis.DateUtils

class LightSensor(context: Context): SensorBase(context) {
    override val sensorType = Sensor.TYPE_LIGHT
    override val sensorName = "light"

    val TAG = "LightSensor"

    override fun onSensorChanged(event: SensorEvent) {
        val lux = event.values[0]
        queue.add("${DateUtils.getTimeStamp()},${lux}")

        Log.d(TAG,"${DateUtils.getTimeStamp()},${lux}")
    }
}