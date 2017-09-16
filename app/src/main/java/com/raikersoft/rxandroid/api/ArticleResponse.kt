package com.raikersoft.rxandroid.api

import com.google.gson.annotations.SerializedName
import com.raikersoft.rxandroid.models.Article

/**
 * Created by RicardoAndrés on 15/09/2017.
 */
class ArticleResponse{

    @SerializedName("status")
    var  status: String? = null

    @SerializedName("num_results")
    var numResult: Int? = null

    @SerializedName("results")
    var articleList: List<Article> = emptyList()
}