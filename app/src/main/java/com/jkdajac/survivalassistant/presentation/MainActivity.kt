package com.jkdajac.survivalassistant.presentation

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.jkdajac.survivalassistant.R
import com.jkdajac.survivalassistant.presentation.dictaphone.DictaphoneActivity
import com.jkdajac.survivalassistant.presentation.stopwatch.StopwatchActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val  w : Window = window
        w.decorView.setSystemUiVisibility(
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // скрываем нижнюю панель навигации
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY) //появляется поверх активити и исчезает
        setContentView(R.layout.activity_main)

        btMainMenu.setOnClickListener {
            dlDrawer.openDrawer(GravityCompat.START)
        }

        nvMenuNavigationView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.orientation -> {
                    //val intent = Intent(this, ClientsActivity ::class.java)
                    startActivity(intent)
                    Toast.makeText(this@MainActivity, "Клиенты", Toast.LENGTH_SHORT).show()
                }
                R.id.water -> {
                    Toast.makeText(this@MainActivity, "Шаблоны", Toast.LENGTH_SHORT).show()
                    //val intent = Intent(this, TamplatesActivity ::class.java)
                    startActivity(intent)
                }
                R.id.food -> {
                    //val intent = Intent(this, ManualActivity ::class.java)
                    startActivity(intent)
                    Toast.makeText(this@MainActivity, "Справочник", Toast.LENGTH_SHORT).show()
                }
                R.id.fire -> {
                    Toast.makeText(this@MainActivity, "О приложении", Toast.LENGTH_SHORT).show()
                    //val intent = Intent(this, AboutActivity ::class.java)
                    startActivity(intent)
                }
                R.id.tracking -> {
                    val intent = Intent(this, SledActivity ::class.java)
                    startActivity(intent)
                }
                R.id.compass -> {
                    val intent = Intent(this, CompassActivity ::class.java)
                    startActivity(intent)
                }
                R.id.note -> {
                    val intent = Intent(this, NoteActivity ::class.java)
                    startActivity(intent)
                }
                R.id.timer -> {
                    val intent = Intent(this, TimerActivity ::class.java)
                    startActivity(intent)
                }
                R.id.stopwatch -> {
                    val intent = Intent(this, StopwatchActivity ::class.java)
                    startActivity(intent)
                }
                R.id.dictaphone -> {
                    val intent = Intent(this, DictaphoneActivity ::class.java)
                    startActivity(intent)
                }
            }
            dlDrawer.closeDrawer(GravityCompat.START)
            true
        }
    }

    override fun onResume() {
        super.onResume()
        val  w : Window = window
        w.decorView.setSystemUiVisibility(
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // скрываем нижнюю панель навигации
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY) //появляется поверх активити и исчезает
    }
}