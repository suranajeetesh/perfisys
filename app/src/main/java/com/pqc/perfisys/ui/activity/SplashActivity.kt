package com.pqc.perfisys.ui.activity

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.activity.enableEdgeToEdge
import com.pqc.perfisys.core.ui.BaseActivity
import com.pqc.perfisys.databinding.ActivitySplashBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * SplashActivity: Displays a splash screen before navigating to the main activity.
 * Created by Jeetesh Surana.
 */
@Suppress("UNUSED_EXPRESSION")
@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity : BaseActivity() {

    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val content = findViewById<View>(android.R.id.content)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            content.viewTreeObserver.addOnDrawListener { false }
        }
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        move()
    }

    // Initiates the move to the main activity after a delay.
    private fun move() {
        Handler(this.mainLooper).postDelayed({
            moveMainActivity()
        }, 1500)
    }
}