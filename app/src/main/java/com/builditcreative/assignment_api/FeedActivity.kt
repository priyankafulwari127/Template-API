package com.builditcreative.assignment_api

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.builditcreative.newsapp.api.EverythingRequest
import com.builditcreative.newsapp.api.NewsApiClient
import com.builditcreative.newsapp.models.ArticleResponse
import com.google.android.material.button.MaterialButton

class FeedActivity : AppCompatActivity() {

    private lateinit var newsApiClient: NewsApiClient

    private var sortBy = "publishedAt"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feedback_activity)

        val latestButton = findViewById<MaterialButton>(R.id.latestText)
        val popularButton = findViewById<MaterialButton>(R.id.olderText)

        latestButton.setOnClickListener {
            sortBy = "publishedAt"
            doMySearch("Android")
        }

        popularButton.setOnClickListener {
            sortBy = "popularity"
            doMySearch("Android")
        }

        newsApiClient = NewsApiClient("a50cd99ec4f64caeacaab74924149e38")
        doMySearch("Android")

        val searchText = findViewById<EditText>(R.id.searchText)

        searchText.setOnEditorActionListener { v, actionId, event ->
            doMySearch(searchText.text.toString())
            true
        }

    }

    private fun doMySearch(query: String?) {
        val listNews: RecyclerView = findViewById(R.id.recyclerview)
        listNews.setHasFixedSize(true)
        listNews.setItemViewCacheSize(100)
        listNews.layoutManager = LinearLayoutManager(applicationContext)
        newsApiClient.getEverything(
            EverythingRequest.Builder()
                .q(query)
                .language("en")
                .sortBy(sortBy) //publishedAt, relevancy,popularity
                .build(),
            object : NewsApiClient.ArticlesResponseCallback {
                override fun onSuccess(response: ArticleResponse?) {
                    if (response != null) {
                        listNews.adapter = NewsAdapter(applicationContext, response,listNews)
                    }
                }

                override fun onFailure(throwable: Throwable?) {

                }
            }
        )
    }

}