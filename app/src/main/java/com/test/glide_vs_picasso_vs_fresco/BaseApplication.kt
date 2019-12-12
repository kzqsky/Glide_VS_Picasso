package com.test.glide_vs_picasso_vs_fresco

import android.app.Application
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import okhttp3.OkHttpClient
import okhttp3.Protocol
import java.security.cert.X509Certificate
import java.util.*
import javax.net.ssl.*


class BaseApplication :Application(){
    override fun onCreate() {
        super.onCreate()
        initOkhttp()
    }
    fun initOkhttp(){
         val client =  getUnsafeOkHttpClient()
         val picasso =  Picasso.Builder(this)
            .downloader(OkHttp3Downloader(client))
            .build()
        Picasso.setSingletonInstance(picasso)
    }
    fun getUnsafeOkHttpClient(): OkHttpClient {
        try {
            // Create a trust manager that does not validate certificate chains
            val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
                override fun getAcceptedIssuers(): Array<X509Certificate> {
                 return emptyArray()
                }

                override fun checkClientTrusted(
                    chain: Array<java.security.cert.X509Certificate>,
                    authType: String
                ) {
                }

                override fun checkServerTrusted(
                    chain: Array<java.security.cert.X509Certificate>,
                    authType: String
                ) {
                }
            })

            // Install the all-trusting trust manager
            val sslContext = SSLContext.getInstance("SSL")
            sslContext.init(
                null, trustAllCerts,
                java.security.SecureRandom()
            )
            // Create an ssl socket factory with our all-trusting manager
            val sslSocketFactory = sslContext
                .getSocketFactory()

            return OkHttpClient()
                .newBuilder()
                .sslSocketFactory(sslSocketFactory)
                .hostnameVerifier(object : HostnameVerifier {
                    override fun verify(hostname: String, session: SSLSession): Boolean {
                        return true

                    }
                })
                .build()
        } catch (e: Exception) {
            throw RuntimeException(e)
        }

    }

}