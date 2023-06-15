package net.harutiro.piddisplaylightphone.ViewModel.Sensor

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager

abstract class SensorBase(val context: Context): SensorEventListener {
    private lateinit var sensorManager: SensorManager
    private var PreSensor: Sensor? = null
    val queue: ArrayDeque<String> = ArrayDeque(listOf())

    abstract val sensorType:Int
    abstract val sensorName:String

    fun init() {
        sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        PreSensor = sensorManager.getDefaultSensor(sensorType)

    }

    fun start(filename: String) {
        queue.clear()
        sensorManager.registerListener(
            this,
            PreSensor,
            SensorManager.SENSOR_DELAY_UI
        )
    }

    fun stop(){
        sensorManager.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent) {
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }
}