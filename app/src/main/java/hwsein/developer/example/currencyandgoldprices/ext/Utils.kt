package hwsein.developer.example.currencyandgoldprices.ext

import androidx.fragment.app.Fragment
import hwsein.developer.example.currencyandgoldprices.Remote.Model.Detail

interface Utils {

    fun finished(){}

    fun setFragment(fragment: Fragment){}

    fun setRecyclerData(data : ArrayList<Detail>){}

}