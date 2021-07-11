package com.example.androidtv.ui

import androidx.leanback.preference.LeanbackSettingsFragmentCompat
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceScreen


class SettingsFragment : LeanbackSettingsFragmentCompat() {
    override fun onPreferenceStartInitialScreen() {
        // TODO
        startPreferenceFragment(PreferencesFragment())
    }

    override fun onPreferenceStartScreen(
        caller: PreferenceFragmentCompat?,
        pref: PreferenceScreen?
    ): Boolean {
        return true
    }

    override fun onPreferenceStartFragment(
        caller: PreferenceFragmentCompat?,
        pref: Preference?
    ): Boolean {
        return true
    }


}
