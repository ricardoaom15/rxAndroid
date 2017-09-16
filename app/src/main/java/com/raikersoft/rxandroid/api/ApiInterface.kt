package com.raikersoft.rxandroid.api

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by RicardoAndrés on 15/09/2017.
 */
interface ApiInterface {
    @GET("{section}.json")
    fun getArticlesList(@Path("section") section: String, @Query("api-key") apiKey: String): Observable<ArticleResponse>
}