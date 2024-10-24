package hwsein.developer.example.currencyandgoldprices.Remote.Api


import hwsein.developer.example.currencyandgoldprices.Remote.Model.Currencies
import hwsein.developer.example.currencyandgoldprices.Remote.Model.DateAll
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("currencies")
    fun getProduct(): Call<Currencies>


    @GET("date/now")
    fun getDate(
        @Query("short") short: Boolean
    ): Call<DateAll>


}