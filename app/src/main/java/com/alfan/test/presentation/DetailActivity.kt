package com.alfan.test.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.alfan.test.utils.view.viewBinding
import com.alfan.test.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity() {
    private val binding by viewBinding(ActivityDetailBinding::inflate)
    private var url: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        handleIntent()
        initView()
    }

    private fun handleIntent() {
        val data = intent.extras
        url = data?.getString("url")
    }

    private fun initView() {
        binding.webView.webViewClient = WebViewClient()
        binding.webView.loadUrl(url.orEmpty())
        val webSettings: WebSettings = binding.webView.settings
        webSettings.domStorageEnabled = true
        binding.webView.settings.setSupportZoom(true)
    }


    companion object {
        private const val EXTRA_URL = "url"
        fun start(context: Context, url: String) {
            context.startActivity(
                Intent(context, DetailActivity::class.java).putExtra(EXTRA_URL, url)
            )
        }
    }
}