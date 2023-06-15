package net.harutiro.piddisplaylightphone.View

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import net.harutiro.piddisplaylightphone.R
import net.harutiro.piddisplaylightphone.ViewModel.SensorViewModel


class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    val sensorViewModel = SensorViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var lightValue = 1.0f

        sensorViewModel.addSensor(context = this)

        findViewById<Button>(R.id.dark_button).setOnClickListener {
            if(lightValue < 0){
                lightValue -= 0.1f
            }

            val lp = window.attributes
            lp.screenBrightness = lightValue
            window.attributes = lp

            Log.d(TAG,lightValue.toString())


        }

        findViewById<Button>(R.id.light_button).setOnClickListener {
            if(lightValue > 0){
                lightValue += 0.1f
            }

            val lp = window.attributes
            lp.screenBrightness = 1.0f
            window.attributes = lp

            Log.d(TAG,lightValue.toString())

        }

        findViewById<Switch>(R.id.sensing_switch).setOnCheckedChangeListener{ _ , isChanged ->

            if(isChanged){
                sensorViewModel.sensorStart("",sensorViewModel.targetSensors)
            }else{
                sensorViewModel.sensorStop(sensorViewModel.targetSensors)
            }

        }


    }

    override fun onPause() {
        super.onPause()
        sensorViewModel.sensorStop(sensorViewModel.targetSensors)

    }
}