package com.ben.retrofit2_demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ben.retrofit2_demo.utils.replaceFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFragment()
    }

    private fun initFragment() {
        replaceFragment(MainFragment(), R.id.flMain)
    }
}
