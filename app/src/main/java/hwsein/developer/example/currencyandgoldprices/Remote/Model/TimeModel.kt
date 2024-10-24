package hwsein.developer.example.currencyandgoldprices.Remote.Model

import com.google.gson.annotations.SerializedName

data class DateAll(
    val success : Int ,
    val message : String ,
    val help : String ,
    val date :DateNow
)

data class DateNow(
   @SerializedName("Y") val year : String ,
    @SerializedName("F") val month : String ,
    @SerializedName("j") val date : String ,
   @SerializedName("l") val weekDay : String ,
)