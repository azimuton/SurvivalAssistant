package com.jkdajac.survivalassistant.presentation

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.jkdajac.survivalassistant.R
import kotlinx.android.synthetic.main.activity_timer.*

class TimerActivity : AppCompatActivity() {
    private var  vm = MainViewModel()
    private var countDownTimer : CountDownTimer? = null
    private var seconds: Long? = null
    private var minutes: Long? = null
    private var hours: Long? = null
    private var days: Long? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val  w : Window = window
        w.decorView.setSystemUiVisibility(
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // скрываем нижнюю панель навигации
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY) //появляется поверх активити и исчезает
        setContentView(R.layout.activity_timer)

        vm = ViewModelProvider(this)[MainViewModel::class.java]
        btStartTimer.setOnClickListener {

            val seconds : Long = etTimerInputSeconds.text.toString().toLong() * 1000
//            val minutes : Long = etTimerInputMinutes.text.toString().toLong() * 60000
//            val hours : Long = etTimerInputHours.text.toString().toLong() * 3600000
//            val days : Long = etTimerInputDays.text.toString().toLong() * 86400000
            printDifferenceDateForHours(seconds)
        }

    }

    fun printDifferenceDateForHours(millis : Long) {
        countDownTimer = object : CountDownTimer(millis, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                val progress = (millisUntilFinished / 1000).toInt()
                progressBar.progress = progressBar.max - progress
                var diff = millisUntilFinished
                val secondsInMilli: Long = 1000
                val minutesInMilli = secondsInMilli * 60
                val hoursInMilli = minutesInMilli * 60
                val daysInMilli = hoursInMilli * 24

                val elapsedDays = diff / daysInMilli
                diff %= daysInMilli

                val elapsedHours = diff / hoursInMilli
                diff %= hoursInMilli

                val elapsedMinutes = diff / minutesInMilli
                diff %= minutesInMilli

                val elapsedSeconds = diff / secondsInMilli

            tvShowTimerSeconds.text = "$elapsedDays : $elapsedHours : $elapsedMinutes : $elapsedSeconds"




            }

            override fun onFinish() {
                tvShowTimerSeconds.text = "Finish!"
            }
        }.start()
    }



    //    fun startTimer(timeMillis : Long){
//        //val binding : ActivityTimerBinding? = null
//        timer?.cancel()
//        timer = object : CountDownTimer(timeMillis, 1){
//            override fun onTick(seconds: Long) {
//                binding.tvShowTimer.text = seconds.toString()
//            }
//
//            override fun onFinish() {
//                binding.tvShowTimer.text = "Finish"
//            }
//
//        }.start()
//    }
    override fun onResume() {
        super.onResume()
        val  w : Window = window
        w.decorView.setSystemUiVisibility(
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // скрываем нижнюю панель навигации
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY) //появляется поверх активити и исчезает
    }
}