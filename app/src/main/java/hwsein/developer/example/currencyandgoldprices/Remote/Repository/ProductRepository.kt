package hwsein.developer.example.currencyandgoldprices.Remote.Repository

import hwsein.developer.example.currencyandgoldprices.Remote.Model.Currencies
import hwsein.developer.example.currencyandgoldprices.Remote.RetrofitService.RetrofitService
import hwsein.developer.example.currencyandgoldprices.ext.CallBackHandler
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductRepository private constructor(){

    companion object {

        private var apiRepository: ProductRepository? = null

        val instance: ProductRepository
            get() {

                if (apiRepository == null) apiRepository = ProductRepository()

                return apiRepository!!
            }

    }

        fun getDetail(
            request : CallBackHandler
        ){

            RetrofitService.apiService.getProduct().enqueue(

                object : Callback<Currencies>{

                    override fun onResponse(
                        call: Call<Currencies>,
                        response: Response<Currencies>
                    ) {

                        if (response.isSuccessful){

                            val data = response.body() as Currencies

                            request.onSuccess(data)

                        }else

                            request.onNotSuccess("اتصال به سرور با مشکل مواجه شده است! ")

                    }

                    override fun onFailure(call: Call<Currencies>, t: Throwable) {

                        request.onError("Error : ${t.message}")

                    }


                }

            )



        }


    }

