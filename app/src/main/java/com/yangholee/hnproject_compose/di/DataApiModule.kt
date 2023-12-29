package com.yangholee.hnproject_compose.di

import android.content.Context
import com.yangholee.hnproject_compose.data.api.ApiConstants
import com.yangholee.hnproject_compose.data.api.HistoryApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Call
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataApiModule {

    @Provides
    @Singleton
    fun provideApi(builder: Retrofit.Builder): HistoryApi {
        return builder
            .build()
            .create(HistoryApi::class.java)

    }

    /**
     * Create retrofit object
     */
    @Provides
    @Singleton
    fun provideRetrofit(okHttpCallFactory: Call.Factory, ): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
//            .addConverterFactory(MoshiConverterFactory.create())
            .callFactory(okHttpCallFactory)
            .addConverterFactory(MoshiConverterFactory.create())
//            .addConverterFactory(
//                networkJson.asConverterFactory("application/json".toMediaType()),
//            )
    }

    @Provides
    @Singleton
    fun okHttpCallFactory(
        @ApplicationContext context: Context
    ): Call.Factory = OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor()
                .apply {
                    setLevel(HttpLoggingInterceptor.Level.BODY)
                },
        )
        .addInterceptor(NetworkConnectionInterceptor(context))
        .build()


//    @Provides
//    @Singleton
//    fun providesNetworkJson(): Json = Json {
//        ignoreUnknownKeys = true
//    }

}