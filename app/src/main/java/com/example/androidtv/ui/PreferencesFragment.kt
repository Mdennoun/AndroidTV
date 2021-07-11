package com.example.androidtv.ui

import android.os.Bundle
import androidx.leanback.preference.LeanbackPreferenceFragmentCompat
import com.example.androidtv.R


class PreferencesFragment : LeanbackPreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.preferences)
    }

}
