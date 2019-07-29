package com.ben.retrofit2_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ben.retrofit2_demo.utils.addFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFragment()
    }

    private fun initFragment() {
        addFragment(MainFragment(), R.id.flMain)
    }
}
