package com.example.androidtv.ui

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.androidtv.R

class PreferencesActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.content, SettingsFragment())
            .commit()
    }
}