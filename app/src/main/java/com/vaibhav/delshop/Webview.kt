package com.vaibhav.delshop

import Dataclasses.Hit
import Dataclasses.Recipe
import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import java.io.Serializable

class Webview : Fragment() {
    lateinit var webView: WebView
    private lateinit var cont: Serializable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            cont = it.getSerializable("cont")!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_webview, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        webView = view.findViewById(R.id.webview)

        var mWebView: WebView? = null
        mWebView = view?.findViewById(R.id.webview) as WebView?
        cont.let { mWebView?.loadUrl(it as String) }

        val webSettings = mWebView?.getSettings()
        webSettings?.setJavaScriptEnabled(true)
        webSettings?.safeBrowsingEnabled = false

        mWebView?.webViewClient = WebViewClient()

        mWebView?.canGoBack()
        mWebView?.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_BACK && event.action == MotionEvent.ACTION_UP && mWebView.canGoBack()) {
                mWebView.goBack()
                return@OnKeyListener true
            }
            false
        })
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Webview().apply {
                arguments = Bundle().apply {

                }
            }
    }
}