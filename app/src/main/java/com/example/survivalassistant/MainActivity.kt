package com.example.survivalassistant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Toast
import androidx.core.view.GravityCompat
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
                R.id.shelter -> {
                    finishAffinity()
                    Toast.makeText(this@MainActivity, "Выход", Toast.LENGTH_SHORT).show()

                }
                R.id.compass -> {
                    val intent = Intent(this, CompassActivity ::class.java)
                    startActivity(intent)
                    //Toast.makeText(this@MainActivity, "Выход", Toast.LENGTH_SHORT).show()

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