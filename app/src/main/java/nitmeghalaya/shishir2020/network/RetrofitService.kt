package nitmeghalaya.shishir2020.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by Devansh on 8/3/20
 */

private const val BASE_URL = "https://graph.facebook.com/v6.0/347129762068773/"

object RetrofitService {

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    fun <T> createService(serviceClass: Class<T>): T = retrofit.create(serviceClass)

}