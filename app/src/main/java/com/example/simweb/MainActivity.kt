package com.example.simweb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {

    private lateinit var myWebView: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Hide ActionBar
        supportActionBar?.hide();

        // Create WebView
        myWebView = WebView(this)
        setContentView(myWebView)

        // Enable JS and set URL handler
        myWebView.settings.javaScriptEnabled = true
        myWebView.webViewClient = WebViewClient()

        // Load website
        myWebView.loadUrl("https://example.org")
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && myWebView.canGoBack()) {
            myWebView.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}