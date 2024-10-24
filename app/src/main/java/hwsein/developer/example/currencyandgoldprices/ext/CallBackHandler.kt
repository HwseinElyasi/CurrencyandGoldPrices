package hwsein.developer.example.currencyandgoldprices.ext

import hwsein.developer.example.currencyandgoldprices.Remote.Model.Currencies

interface CallBackHandler {

    fun onSuccess(data : Currencies)

    fun onNotSuccess(message : String)

    fun onError(message: String)


}