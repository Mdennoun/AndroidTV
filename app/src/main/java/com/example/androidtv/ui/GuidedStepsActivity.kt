package com.example.androidtv.ui

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.leanback.app.GuidedStepSupportFragment
import com.example.androidtv.ui.GuidedStepsFragment

class GuidedStepsActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        GuidedStepSupportFragment.addAsRoot(this, GuidedStepsFragment(), android.R.id.content)
    }
}