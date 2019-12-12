package com.test.glide_vs_picasso_vs_fresco

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main3.*

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        btn1.setOnClickListener { toActivity(MainActivity().javaClass) }
        btn2.setOnClickListener { toActivity(Main2Activity().javaClass) }
        btn3.setOnClickListener { toActivity(Main4Activity().javaClass) }
    }

    private fun toActivity(activity:Class<Any>){
        val intent=Intent(this,activity)
        startActivity(intent)
    }
}
