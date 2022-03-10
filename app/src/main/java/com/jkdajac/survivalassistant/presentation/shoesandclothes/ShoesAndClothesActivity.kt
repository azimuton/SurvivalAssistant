package com.jkdajac.survivalassistant.presentation.shoesandclothes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.google.android.material.tabs.TabLayout
import com.jkdajac.survivalassistant.R
import com.jkdajac.survivalassistant.presentation.shoesandclothes.shoesandclothesfragments.ClothesFragment
import com.jkdajac.survivalassistant.presentation.shoesandclothes.shoesandclothesfragments.ShoesFragment
import kotlinx.android.synthetic.main.activity_shoes_and_clothes.*

class ShoesAndClothesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val  w : Window = window
        w.decorView.setSystemUiVisibility(
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // скрываем нижнюю панель навигации
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY) //появляется поверх активити и исчезает
        setContentView(R.layout.activity_shoes_and_clothes)

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab?.position){
                    0 ->  {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.flShoesAndClothes, ClothesFragment.newInstance("a","aa"))
                            .commit()
                        animate()
                    }
                    1 ->  {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.flShoesAndClothes, ShoesFragment.newInstance("a","aa"))
                            .commit()
                        animate()
                    }
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
    }

    fun animate(){
        val animation: Animation = AnimationUtils.loadAnimation(this, R.anim.alfaperehod)
        flShoesAndClothes.startAnimation(animation)
    }

    override fun onResume() {
        super.onResume()
        val  w : Window = window
        w.decorView.setSystemUiVisibility(
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // скрываем нижнюю панель навигации
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY) //появляется поверх активити и исчезает
    }
}