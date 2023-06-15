package net.harutiro.piddisplaylightphone.ViewModel

import android.content.Context
import android.util.Log
import net.harutiro.piddisplaylightphone.ViewModel.Sensor.LightSensor
import net.harutiro.piddisplaylightphone.ViewModel.Sensor.SensorBase

class SensorViewModel {

    val TAG = "SensorRepository"

    var targetSensors: MutableList<SensorBase> = mutableListOf()

    var sensorStartFlag = false

    // 読み込みたいセンサーデータを保存
    fun addSensor(context: Context){
        targetSensors.add(LightSensor(context))
    }

    fun sensorStart(fileName:String,sensors: MutableList<SensorBase>) {
        sensorStartFlag = true

        for (sensor in sensors) {
            sensor.init()
            sensor.start(fileName)
            Log.d(TAG, "fileName = ${fileName}")
        }
    }

    fun sensorStop(sensors: MutableList<SensorBase>) {
        sensorStartFlag = false

        sensors.map { sensor ->
            sensor.stop()
        }
    }

}