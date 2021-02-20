package com.example.tasbeh

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionManager
import android.view.View
import com.r0adkll.slidr.Slidr
import com.r0adkll.slidr.model.SlidrConfig
import com.r0adkll.slidr.model.SlidrInterface
import com.r0adkll.slidr.model.SlidrListener
import com.r0adkll.slidr.model.SlidrPosition
import kotlinx.android.synthetic.main.activity_menu.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.android.synthetic.main.toolbarformenu.*

class MenuActivity : AppCompatActivity() {
    lateinit var slidr: SlidrInterface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        slidr = Slidr.attach(this)
        setSupportActionBar(toolbarformenu)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbarformenu.setNavigationOnClickListener {
            onBackPressed()
        }
        Sozlamalar.setOnClickListener {
            val intent = Intent(this, SozlamalarActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.enter, R.anim.exit)

        }
        YaqinMasjidlar.setOnClickListener {
            val intent1 = Intent(this, YaqinMasjidActivity::class.java)
            startActivity(intent1)
            overridePendingTransition(R.anim.enter, R.anim.exit)

        }
        Qibla.setOnClickListener {
            val intent2 = Intent(this, QiblaActivity::class.java)
            startActivity(intent2)
            overridePendingTransition(R.anim.enter, R.anim.exit)

        }
        Tasbeh.setOnClickListener {
            val intent3 = Intent(this, SozlamalarActivity::class.java)
            startActivity(intent3)
            overridePendingTransition(R.anim.enter, R.anim.exit)

        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.animation, R.anim.animationexit)

    }
    fun lock(){
        slidr.lock()

    }
    fun unlock(){
        slidr.unlock()

    }
}