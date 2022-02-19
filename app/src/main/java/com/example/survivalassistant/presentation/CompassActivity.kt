package com.example.survivalassistant.presentation

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
import androidx.lifecycle.ViewModelProvider
import com.example.survivalassistant.R
import kotlinx.android.synthetic.main.activity_compass.*

class CompassActivity : AppCompatActivity(), SensorEventListener {

    var manager : SensorManager? = null
    var currentDegree : Int = 0
    lateinit var vm : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val  w : Window = window
        w.decorView.setSystemUiVisibility(
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // скрываем нижнюю панель навигации
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY) //появляется поверх активити и исчезает
        setContentView(R.layout.activity_compass)

        vm = ViewModelProvider(this)[MainViewModel::class.java]

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
            tvSide.text = getString(R.string.nne)
        }else if(degree == 45){
            tvSide.text = getString(R.string.ne)
        }else if(degree == 67){
            tvSide.text = getString(R.string.ene)
        }else if(degree == 90){
            tvSide.text = "E"
        }else if(degree == 112){
            tvSide.text = getString(R.string.ese)
        }else if(degree == 135){
            tvSide.text = getString(R.string.se)
        }else if(degree == 157){
            tvSide.text = getString(R.string.sse)
        }else if(degree == 180){
            tvSide.text = "S"
        }else if(degree == 202){
            tvSide.text = getString(R.string.ssw)
        }else if(degree == 225){
            tvSide.text = getString(R.string.sw)
        }else if(degree == 247){
            tvSide.text = getString(R.string.wsw)
        }else if(degree == 270){
            tvSide.text = "W"
        }else if(degree == 292){
            tvSide.text = getString(R.string.wnw)
        }else if(degree == 315){
            tvSide.text = getString(R.string.nw)
        }else if(degree == 337){
            tvSide.text = getString(R.string.nnw)
        }else if(degree == 0){
            tvSide.text = "N"
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }
}