package com.yangholee.hnproject_compose.di

import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build.VERSION_CODES
import androidx.annotation.RequiresApi
import okhttp3.Interceptor
import okhttp3.Interceptor.Chain
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class NetworkConnectionInterceptor(private val mContext: Context) :
    Interceptor {
    @RequiresApi(VERSION_CODES.M)
    @Throws(IOException::class)
    override fun intercept(chain: Chain): Response {
        val builder: Request.Builder = chain.request().newBuilder()
        return chain.proceed(builder.build())
    }

}

class NoConnectivityException : IOException() {
    // You can send any message whatever you want from here.
    override val message: String
        get() = "No Internet Connection"
    // You can send any message whatever you want from here.
}