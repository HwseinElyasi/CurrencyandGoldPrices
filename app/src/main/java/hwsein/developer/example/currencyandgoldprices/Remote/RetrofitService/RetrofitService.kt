package hwsein.developer.example.currencyandgoldprices.Remote.RetrofitService

import hwsein.developer.example.currencyandgoldprices.Remote.Api.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    private const val url = "https://tools.daneshjooyar.com/api/v1/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)

}