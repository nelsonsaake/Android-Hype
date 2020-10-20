package com.gadscommunityproject.hype.landing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.gadscommunityproject.hype.MainActivity
import com.gadscommunityproject.hype.R

class HypeLandingActivity : AppCompatActivity() {
    private lateinit var viewModel: HypeLandingViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hype_landing)

        viewModel = ViewModelProvider(this).get(HypeLandingViewModel::class.java)

        viewModel.eventEnd.observe(this, Observer { hasFinished ->
            if (hasFinished){
                nextActivity()
            }
        })

    }

    private fun nextActivity(){
        startActivity(Intent(this, MainActivity::class.java))
    }
}