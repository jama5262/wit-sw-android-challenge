package com.jama.wit_sw_android_challenge.helpers

import android.webkit.WebView
import android.webkit.WebViewClient

class LeafletWebViewClient(
    private val webView: WebView,
    private val lat: String,
    private val lng: String
) :
    WebViewClient() {

    override fun onPageFinished(view: WebView?, url: String?) {
        webView.loadUrl("javascript:initializeMap($lat, $lng)")
    }
}