package com.example.survivalassistant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btMainMenu.setOnClickListener {
            dlDrawer.openDrawer(GravityCompat.START)
        }

        nvMenuNavigationView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.clients -> {
                    //val intent = Intent(this, ClientsActivity ::class.java)
                    startActivity(intent)
                    Toast.makeText(this@MainActivity, "Клиенты", Toast.LENGTH_SHORT).show()
                }
                R.id.templates -> {
                    Toast.makeText(this@MainActivity, "Шаблоны", Toast.LENGTH_SHORT).show()
                    //val intent = Intent(this, TamplatesActivity ::class.java)
                    startActivity(intent)
                }
                R.id.manual -> {
                    //val intent = Intent(this, ManualActivity ::class.java)
                    startActivity(intent)
                    Toast.makeText(this@MainActivity, "Справочник", Toast.LENGTH_SHORT).show()
                }
                R.id.about -> {
                    Toast.makeText(this@MainActivity, "О приложении", Toast.LENGTH_SHORT).show()
                    //val intent = Intent(this, AboutActivity ::class.java)
                    startActivity(intent)
                }
                R.id.exit -> {
                    finishAffinity()
                    Toast.makeText(this@MainActivity, "Выход", Toast.LENGTH_SHORT).show()

                }
            }
            dlDrawer.closeDrawer(GravityCompat.START)
            true
        }
    }
}