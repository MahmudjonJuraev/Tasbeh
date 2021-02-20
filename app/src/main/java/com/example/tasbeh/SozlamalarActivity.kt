package com.example.tasbeh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu.*
import kotlinx.android.synthetic.main.activity_menu.YaqinMasjidlar
import kotlinx.android.synthetic.main.activity_sozlamalar.*
import kotlinx.android.synthetic.main.toolbarformenu.*

class SozlamalarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sozlamalar)
        setSupportActionBar(toolbarformenu)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ""
        toolbarformenu.setNavigationOnClickListener {
            onBackPressed()
        }
        Hududlanlash.setOnClickListener {
            val intent1 = Intent(this, HududlarActivity::class.java)
            startActivity(intent1)
            overridePendingTransition(R.anim.enter, R.anim.exit)

        }
        Tilnlash.setOnClickListener {
            val intent1 = Intent(this, TilActivity::class.java)
            startActivity(intent1)
            overridePendingTransition(R.anim.enter, R.anim.exit)

        }

    }
    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.animation, R.anim.animationexit)

    }
}