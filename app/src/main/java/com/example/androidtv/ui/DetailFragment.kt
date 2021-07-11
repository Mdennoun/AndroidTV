package com.example.androidtv.ui;

import android.os.Bundle
import android.util.Log
import androidx.leanback.app.DetailsSupportFragment
import com.example.androidtv.R


import android.content.Intent
import android.net.Uri
import android.support.v4.media.session.PlaybackStateCompat.ACTION_PLAY
import android.util.DisplayMetrics
import androidx.core.content.ContextCompat
import androidx.leanback.widget.*
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class DetailsFragment : DetailsSupportFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val selectedMovieData = DetailActivity.movie

        selectedMovieData.let {
            Log.d("LE FILM SELECTIONNER", selectedMovieData.toString())
        }


        val detailRow = DetailsOverviewRow(DetailActivity.movie)

        val detailsPresenter = FullWidthDetailsOverviewRowPresenter(
            DetailsPresenter()
        )


        detailsPresenter.setBackgroundColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.colorBack
            )
        )

        detailsPresenter.setInitialState(FullWidthDetailsOverviewRowPresenter.STATE_FULL)

        val ps = ClassPresenterSelector()
        ps.addClassPresenter(DetailsOverviewRow::class.java, detailsPresenter)
        ps.addClassPresenter(ListRow::class.java, ListRowPresenter())

        adapter = ArrayObjectAdapter(ps).apply { add(detailRow) }

        val sparseAdapter = SparseArrayObjectAdapter()
        sparseAdapter[ACTION_PLAY.toInt()] = Action(
            ACTION_PLAY, "Voir le trailer"
        )

        detailRow.actionsAdapter = sparseAdapter

        detailsPresenter.onActionClickedListener = OnActionClickedListener { action ->
            if (action.id == ACTION_PLAY) {
                val intent = Intent()
                intent.action = Intent.ACTION_VIEW
                intent.data = Uri.parse(
                    selectedMovieData?.trailerURL
                        ?: "https://assets.prestashop2.com/sites/default/files/styles/blog_750x320/public/blog/2019/10/banner_error_404.jpg?itok=eAS4swln"
                )
                requireContext().startActivity(intent)
            }
        }


        lifecycleScope.launch(Dispatchers.IO) {
            val bitmap = Glide.with(requireActivity())
                .asBitmap()
                .load(
                    selectedMovieData?.posterURL
                        ?: "https://plakatsalg.dk/wp-content/uploads/2021/04/404-poster-not-found-plakat.png"
                )
                .apply(RequestOptions().apply { centerCrop() })
                .submit(250, 250)
                .get()
            detailRow.setImageBitmap(requireContext(), bitmap)
        }

        lifecycleScope.launch(Dispatchers.IO) {
            val metrics = DisplayMetrics()
            requireActivity().windowManager.defaultDisplay.getMetrics(metrics)

            val drawable = Glide.with(requireActivity())
                .asDrawable()
                .load(
                    selectedMovieData?.posterURL
                        ?: "https://plakatsalg.dk/wp-content/uploads/2021/04/404-poster-not-found-plakat.png"
                )
                .apply(RequestOptions().apply { centerCrop() })
                .submit()
                .get()

            withContext(Dispatchers.Main) {
                requireActivity().window.decorView.background = drawable
            }
        }
    }

}
