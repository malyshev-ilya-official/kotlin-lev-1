package com.example.viewexample

import android.os.Bundle
import android.os.PersistableBundle
import android.service.controls.actions.FloatAction
import android.widget.AbsListView.RecyclerListener
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val movies = generateMovieList().toMutableList()

        val rv1: RecyclerView = findViewById(R.id.activity_main__rv1)
        val adapter: MainAdapter = MainAdapter(movies)
        rv1.adapter = adapter
        rv1.layoutManager = LinearLayoutManager(this)

        val fab: FloatingActionButton = findViewById(R.id.activity_main__fab)
        fab.setOnClickListener {
            movies.add(
                Movie("new film", "new film description", 0 )
            )
            adapter.notifyDataSetChanged()
        }

    }

    private fun generateMovieList(): List<Movie> {
        return listOf(
            Movie("film 1", "description 1", R.drawable.movie_1),
            Movie("film 2", "description 2", R.drawable.movie_2),
            Movie("film 3", "description 3", R.drawable.movie_3),
            Movie("film 4", "description 4", R.drawable.movie_4),
            Movie("film 5", "description 5", R.drawable.movie_5),
            Movie("film 6", "description 6", R.drawable.movie_6),
            Movie("film 7", "description 7", R.drawable.movie_7)
        )
    }

}