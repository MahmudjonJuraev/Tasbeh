package com.example.tasbeh

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.location.Location
import android.location.LocationListener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import kotlinx.android.synthetic.main.activity_qibla.*
import kotlinx.android.synthetic.main.toolbarformenu.*
import kotlin.math.roundToInt

class QiblaActivity : AppCompatActivity(), SensorEventListener, LocationListener {
    private lateinit var sensorManager: SensorManager
    private var mLight: Sensor? = null
    var current:Float= 242.0f



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qibla)
        setSupportActionBar(toolbarformenu)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ""
        toolbarformenu.setNavigationOnClickListener {
            onBackPressed()
        }



        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        mLight = sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION)



    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.animation, R.anim.animationexit)

    }

    override fun onResume() {
        super.onResume()
        mLight?.also { light ->
            sensorManager.registerListener(this, light, SensorManager.SENSOR_DELAY_GAME)

        }
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent) {

        val degree: Float = event.values[0].roundToInt().toFloat()
        Toast.makeText(this, "degree $degree", Toast.LENGTH_SHORT).show()

        val animation: RotateAnimation = RotateAnimation(current, degree, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f)
        animation.duration = 100
        animation.fillAfter = true
        compass.startAnimation(animation)
        current = degree

    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    override fun onLocationChanged(location: Location) {

    }
}