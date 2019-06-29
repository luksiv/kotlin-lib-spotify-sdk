package com.luksiv.lib.spotify.retrofit

import com.google.gson.FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES
import com.google.gson.GsonBuilder
import com.luksiv.lib.spotify.clients.SpotifyApiClient
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIFactory(private val accessToken: String) {

    fun createClient(
        baseUrl: String = "https://api.spotify.com/"
    ): APIClient {
        return createRetrofitClient(baseUrl)
    }

    private fun createRetrofitClient(baseUrl: String): APIClient {
        return createRetrofit(baseUrl)
            .create(APIClient::class.java)
    }

    private fun createRetrofit(baseUrl: String) = with(Retrofit.Builder()) {
        baseUrl(baseUrl)
        addConverterFactory(createGsonConverterFactory())
        client(createOkHttpClient())
        build()
    }

    private fun createOkHttpClient() = with(OkHttpClient().newBuilder()) {
        addInterceptor { chain ->
            val originalRequest = chain.request()
            val builder =
                originalRequest.newBuilder().header("Authorization", "Bearer $accessToken")
                    .header("Accept", "application/json")
                    .header("Content-Type", "application/json")
            val modifiedRequest = builder.build()
            chain.proceed(modifiedRequest)
        }
        addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        build()
    }

    private fun createGsonConverterFactory(): GsonConverterFactory {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setFieldNamingPolicy(LOWER_CASE_WITH_UNDERSCORES)
        return GsonConverterFactory.create(gsonBuilder.create())
    }
}