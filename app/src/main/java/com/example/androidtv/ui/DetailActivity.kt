package com.example.androidtv.ui;

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentActivity
import com.example.androidtv.data.network.model.Movie


class DetailActivity: FragmentActivity() {


    companion object {
        lateinit var movie:Movie

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("fragmentMovie", movie.toString())
        supportFragmentManager
            .beginTransaction()
            .replace(android.R.id.content, DetailsFragment())
            .commitAllowingStateLoss()





    }
}
val instance = DetailActivity.Companion