package com.nicco.myarchexample.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nicco.myarchexample.R

class InvActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inv)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.container,
                    InvFragment.newInstance()
                )
                .commitNow()
        }
    }
}
