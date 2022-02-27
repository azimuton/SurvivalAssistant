package com.jkdajac.survivalassistant.presentation

import android.os.CountDownTimer
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    //private lateinit var binding : ActivityTimerBinding
private var timer : CountDownTimer? = null

//fun startTimer(timeMillis : Long){
//   val binding : ActivityTimerBinding? = null
//    timer?.cancel()
//    timer = object : CountDownTimer(timeMillis, 1){
//        override fun onTick(seconds: Long) {
//           binding?.tvShowTimer?.text = seconds.toString()
//        }
//
//        override fun onFinish() {
//            binding?.tvShowTimer?.text = "Finish"
//        }
//
//    }.start()
//}
}