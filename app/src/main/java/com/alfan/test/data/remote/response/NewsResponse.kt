package com.alfan.test.data.remote.response

import com.alfan.test.domain.model.ArticlesItem

data class NewsResponse(
	var totalResults: Int? = null,
	var articles: List<ArticlesItem>? = null,
	var status: String? = null
)


