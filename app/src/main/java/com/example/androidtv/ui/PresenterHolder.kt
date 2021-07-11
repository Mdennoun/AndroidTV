package com.example.androidtv.ui;

import android.util.Log
import android.view.ViewGroup
import androidx.leanback.widget.AbstractDetailsDescriptionPresenter
import androidx.leanback.widget.ImageCardView
import androidx.leanback.widget.Presenter
import com.example.androidtv.data.network.model.Movie
import kotlin.math.pow

class PresenterHolder: Presenter() {
    override fun onCreateViewHolder(parent: ViewGroup?): ViewHolder {
        return CardViewHolder(ImageCardView(parent?.context))
    }


    override fun onBindViewHolder(viewHolder: ViewHolder?, item: Any?) {
        // On récupère l'objet de la requête
        val movie = item as Movie


        // On récupère le ViewHolder et l'ImageCardView

        val holder = viewHolder as CardViewHolder
        val img = holder.card


        // TODO Remplir le contenu de la carte à partir de l'objet Movie

        if (movie != null) {
            // TODO C'est à vous !
            holder.card.titleText = movie.name
            if (movie.posterURL != null)
                holder.card.contentText = movie.rating.toString() ?: "Content missing"
            if (movie.posterURL != null)
                holder.loadImage(movie.posterURL)
        }





    }


    override fun onUnbindViewHolder(viewHolder: ViewHolder?) {
        TODO("Not yet implemented")
        Log.d("click", "here")

    }
}