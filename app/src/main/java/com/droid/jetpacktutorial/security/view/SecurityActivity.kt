package com.droid.jetpacktutorial.security.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.droid.jetpacktutorial.R
import com.droid.jetpacktutorial.utils.readSecureStringPreference
import com.droid.jetpacktutorial.utils.saveSecureStringPreference
import kotlinx.android.synthetic.main.security_activity.*

class SecurityActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.security_activity)

        refreshEditText()

        value_save.setOnClickListener {
            saveSecureStringPreference("jetpack", value_edit.text.toString())
        }
    }

    private fun refreshEditText() {
        value_edit.setText(readSecureStringPreference("jetpack"))
    }
}