package com.example.survivalassistant

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_compass.*

class CompassActivity : AppCompatActivity(), SensorEventListener {

    var manager : SensorManager? = null
    var currentDegree : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val  w : Window = window
        w.decorView.setSystemUiVisibility(
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // скрываем нижнюю панель навигации
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY) //появляется поверх активити и исчезает
        setContentView(R.layout.activity_compass)
        manager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }

    override fun onResume() {
        super.onResume()
        val  w : Window = window
        w.decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // скрываем нижнюю панель навигации
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY) //появляется поверх активити и исчезает
        manager?.registerListener(this, manager?.getDefaultSensor(Sensor.TYPE_ORIENTATION),
            SensorManager.SENSOR_DELAY_GAME)
    }

    override fun onPause() {
        super.onPause()
        manager?.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        val degree : Int = event?.values?.get(0)?.toInt()!!
        tvDegrees.text = degree.toString()
        val rotateAnim = RotateAnimation(currentDegree.toFloat(), (-degree).toFloat(),
            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
        rotateAnim.duration = 210
        rotateAnim.fillAfter = true
        currentDegree = -degree
        ivCompass.startAnimation(rotateAnim)

        if(degree == 22){
            tvSide.text = "NNE"
        }else if(degree == 45){
            tvSide.text = "NE"
        }else if(degree == 67){
            tvSide.text = "ENE"
        }else if(degree == 90){
            tvSide.text = "E"
        }else if(degree == 112){
            tvSide.text = "ESE"
        }else if(degree == 135){
            tvSide.text = "SE"
        }else if(degree == 157){
            tvSide.text = "SSE"
        }else if(degree == 180){
            tvSide.text = "S"
        }else if(degree == 202){
            tvSide.text = "SSW"
        }else if(degree == 225){
            tvSide.text = "SW"
        }else if(degree == 247){
            tvSide.text = "WSW"
        }else if(degree == 270){
            tvSide.text = "W"
        }else if(degree == 292){
            tvSide.text = "WNW"
        }else if(degree == 315){
            tvSide.text = "NW"
        }else if(degree == 337){
            tvSide.text = "NNW"
        }else if(degree == 0){
            tvSide.text = "N"
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }
}