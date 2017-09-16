package com.raikersoft.rxandroid.models

/**
 * Created by RicardoAndrés on 15/09/2017.
 */

data class Article(val section: String, val title: String, val multimedia: List<Multimedia>)
data class Multimedia(val url: String)