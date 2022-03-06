package com.lolozianas.amphibiansapp.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


/**
 * Property for the base url
 * */
private const val BASE_URL =
    "https://developer.android.com/courses/pathways/android-basics-kotlin-unit-4-pathway-2/"

/**
 * Property for the get list amphibians list
 * */
private const val GET_AMPHIBIANS_LIST = "android-basics-kotlin-unit-4-pathway-2-project-api.json"

/**
 * Build the Moshi object  with Kotlin  adapter factory that retrofit will be using.
 * */
private val moshi = Moshi
    .Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

/**
 * The retrofit object with the Moshi builder
 */
private val retrofit = Retrofit
    .Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

/** A public interface that expose the methods that */
interface AmphibianApiService {

    /**
     * Returns [List] of [Amphibian] and this method can be  called from a Coroutine
     * */
    @GET(GET_AMPHIBIANS_LIST)
    suspend fun getAmphibians(): List<Amphibian>
}

/**
 * A public API object that exposes the lazy-initialized Retrofit service
 * */
object AmphibianAPI {
    val retrofitService: AmphibianApiService by lazy {
        retrofit.create(AmphibianApiService::class.java)
    }
}