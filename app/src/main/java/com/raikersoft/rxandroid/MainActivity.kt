package com.raikersoft.rxandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.raikersoft.rxandroid.adapters.ArticleAdapter
import com.raikersoft.rxandroid.viewmodels.MainViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    var adapter: ArticleAdapter = ArticleAdapter()
    var subscription: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        subscription.addAll(
                viewModel.getArticles("home")
                        .subscribeBy(
                                onNext = {adapter.items = it},
                                onError = { Log.e("ERROR", "Error de Conexion")}
                        ),

                        adapter.articleSelected.flatMap {
                    viewModel.getArticles("world")
                }.subscribe()
        )

    }
}
