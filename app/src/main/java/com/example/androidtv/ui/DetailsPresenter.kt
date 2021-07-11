package com.example.androidtv.ui

import android.content.Intent
import android.net.Uri
import android.support.v4.media.session.PlaybackStateCompat.ACTION_PLAY
import android.util.Log
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.leanback.widget.AbstractDetailsDescriptionPresenter
import androidx.leanback.widget.ImageCardView
import androidx.leanback.widget.OnActionClickedListener
import androidx.leanback.widget.OnItemViewClickedListener
import androidx.leanback.widget.Presenter
import com.example.androidtv.data.network.model.Movie
import kotlin.math.round

class DetailsPresenter() : AbstractDetailsDescriptionPresenter() {

    override fun onBindDescription(viewHolder: ViewHolder, item: Any?) {
        val movie: Movie? = item as Movie

        if (movie != null) {
            // TODO C'est à vous !
            viewHolder.title.text = item.name
            viewHolder.subtitle.text = item.actors?.joinToString() ?: "Content missing"
            viewHolder.body.text = item.overview ?: "Content missing"
        }
    }


}