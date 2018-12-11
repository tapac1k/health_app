package com.az.healthapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class DayActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_day)
    }

    fun startNextActivity() {
        val i = Intent(this, Main2Activity::class.java)
        startActivity(i)
    }

    fun setupButtons() {
        btnContinue.setOnClickListener{ startNextActivity()}
    }

    fun setupLabels() {

    }
}