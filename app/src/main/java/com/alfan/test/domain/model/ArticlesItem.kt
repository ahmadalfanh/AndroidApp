package com.alfan.test.domain.model

data class ArticlesItem(
    var publishedAt: String? = null,
    var author: String? = null,
    var urlToImage: Any? = null,
    var description: String? = null,
    var source: Source? = null,
    var title: String? = null,
    var url: String? = null,
    var content: Any? = null
)