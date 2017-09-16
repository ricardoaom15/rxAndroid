package com.raikersoft.rxandroid.viewmodels

import com.raikersoft.rxandroid.api.ApiClient
import com.raikersoft.rxandroid.api.ApiInterface
import com.raikersoft.rxandroid.models.Article
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers

/**
 * Created by RicardoAndrés on 15/09/2017.
 */
class MainViewModel {
    var apiClient: ApiInterface = ApiClient.getInstance()

    fun getArticles(section: String): Observable<List<Article>>{
        return apiClient
                .getArticlesList(section, "ca5d91425486485f8ba8fe62ed9a307d")
                .map { it.articleList }
                .observeOn(AndroidSchedulers.mainThread())
    }
}