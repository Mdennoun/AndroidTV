package com.example.androidtv.ui;

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.example.androidtv.R
import com.example.androidtv.ui.GuidedStepsActivity

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      /* Test PopUp
       AlertDialog.Builder(this)
            .setTitle("Mon titre")
            .setMessage("Mon message")
            .setPositiveButton(android.R.string.ok, null)
            .show()
       */


        // Etape 9
        //val intent = Intent(this, GuidedStepsActivity::class.java)

        // Etape 10
        val intent = Intent(this, PreferencesActivity::class.java)

        startActivity(intent)


    }

}