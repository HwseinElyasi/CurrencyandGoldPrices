package hwsein.developer.example.currencyandgoldprices.ext

import hwsein.developer.example.currencyandgoldprices.Remote.Model.Currencies
import hwsein.developer.example.currencyandgoldprices.Remote.Model.DateAll

interface RequestTime {


    fun onSuccess(data : DateAll)

    fun onNotSuccess(message : String)

    fun onError(message: String)




}