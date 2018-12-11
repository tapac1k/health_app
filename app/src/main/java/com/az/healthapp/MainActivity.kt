package com.az.healthapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val MAX_WEIGHT = 150
    val MIN_WEIGHT = 30

    val MAX_HEIGHT = 220
    val MIN_HEIGHT = 100

    val MAX_AGE = 120
    val MIN_AGE = 16


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupButtons()
        setupLabels()
        setupSeekbars()

    }

    fun startNextActivity() {
        val i = Intent(this, DayActivity::class.java)
        startActivity(i)
    }


    fun setupButtons() {
        btnContinue.setOnClickListener{ startNextActivity()}
    }

    fun setupLabels() {
        textAge.text = "$MIN_AGE"
        textWeight.text = "${MIN_WEIGHT.toFloat()} кг"
        textHeight.text = "$MIN_HEIGHT см"
    }


    fun setupSeekbars() {
        sbWeight.max = ( (MAX_WEIGHT - MIN_WEIGHT) * 10 ) //тому ще мінімальний завжди 0, *10 -щоб була частина від цілого
        sbHeight.max = ( (MAX_HEIGHT - MIN_HEIGHT) )
        sbAge.max = ( (MAX_AGE - MIN_AGE) )

        sbWeight.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                textWeight.text = "${MIN_WEIGHT + p1.toFloat() / 10} кг"
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}

            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })

        sbHeight.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                textHeight.text = "${MIN_HEIGHT + p1} см"
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}

            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })

        sbAge.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                textAge.text = "${MIN_AGE + p1}"
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}

            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })
    }
}
