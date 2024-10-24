package hwsein.developer.example.currencyandgoldprices.Remote.Model

data class Currencies(
    val success : Int,
    val message : String,
    val last_update : String,
    val source : String,
    val data : ContentModel
)

data class ContentModel(
    val golds : List<Detail>,
    val currencies : List<Detail>
)

data class Detail(
    val label : String ,
    val price : Int
)


