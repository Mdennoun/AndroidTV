package com.example.androidtv.ui;

import android.os.Bundle
import android.util.Log
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.*
import androidx.lifecycle.lifecycleScope
import com.example.androidtv.data.network.NetworkManager
import com.example.androidtv.data.network.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import android.content.Intent



class MainFragment : BrowseSupportFragment() {



    override  fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fragmentAdapter = ArrayObjectAdapter(ListRowPresenter())
        adapter = fragmentAdapter

        val boxOfficeAdapter = ArrayObjectAdapter(PresenterHolder())
        val anticipateOfficeAdapter = ArrayObjectAdapter(PresenterHolder())
        fragmentAdapter.add(ListRow(HeaderItem(0 , "Les sorties"), boxOfficeAdapter))
        fragmentAdapter.add(ListRow(HeaderItem(1 , "Les plus attendus"), anticipateOfficeAdapter))



        prepareEntranceTransition()
        onItemViewClickedListener =
            OnItemViewClickedListener { itemViewHolder, item, rowViewHolder, row ->
                val movie = item as Movie
                DetailActivity.movie = item

                Log.d("TAGText", DetailActivity.movie.toString())
                val intent = Intent(context, DetailActivity::class.java)
                startActivity(intent)



            }
        lifecycleScope.launch(Dispatchers.IO) {
            val boxOffices = NetworkManager.getBoxOffice()
            val anticipateBoxOffice =NetworkManager.getAnticipatedMovies()
            launch(Dispatchers.Main) {

                val boxOffice = async(Dispatchers.IO) {
                    NetworkManager.getBoxOffice()
                }
                val anticipatedMovies = async(Dispatchers.IO) {
                    NetworkManager.getAnticipatedMovies()
                }

                boxOffice.await().forEach { movie ->
                    boxOfficeAdapter.add(movie)
                }

                anticipatedMovies.await().apply {
                    forEach { movie ->
                        anticipateOfficeAdapter.add(movie)
                    }
                }
                startEntranceTransition()

            }




        }

    }

    override fun startEntranceTransition() {
        super.startEntranceTransition()
    }

}

