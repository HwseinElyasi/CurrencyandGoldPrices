package hwsein.developer.example.currencyandgoldprices.Remote.Repository

import hwsein.developer.example.currencyandgoldprices.Remote.Model.DateAll
import hwsein.developer.example.currencyandgoldprices.Remote.RetrofitService.RetrofitService
import hwsein.developer.example.currencyandgoldprices.ext.RequestTime
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TimeApiRepository private constructor() {


    companion object {

        private var timeApiService: TimeApiRepository? = null

        val instance: TimeApiRepository
            get() {
                if (timeApiService == null) timeApiService = TimeApiRepository()

                return timeApiService!!
            }
    }

    fun getDate(
        short: Boolean,
        request: RequestTime
    ) {

        RetrofitService.apiService.getDate(short).enqueue(

            object : Callback<DateAll> {

                override fun onResponse(call: Call<DateAll>, response: Response<DateAll>) {

                    if (response.isSuccessful) {

                        val date = response.body() as DateAll

                        request.onSuccess(date)

                    } else

                        request.onNotSuccess("اتصال به سرور با مشکل مواجه شده است! ")

                }

                override fun onFailure(call: Call<DateAll>, t: Throwable) {

                    request.onError("Error : ${t.message}")

                }


            }

        )


    }


}
