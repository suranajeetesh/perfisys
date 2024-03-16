package com.pqc.perfisys.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by Jeetesh Surana.
 */

fun AppCompatActivity.moveMainActivity() {
    startActivity(Intent(this, MainActivity::class.java))
    this.finish()
}