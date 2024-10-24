package hwsein.developer.example.currencyandgoldprices.Mvp.Presenter

import hwsein.developer.example.currencyandgoldprices.Mvp.Model.ModelHomeFragment
import hwsein.developer.example.currencyandgoldprices.Mvp.View.ViewHomeFragment

class PresenterHomeFragment(
    private val view : ViewHomeFragment ,
    private val model : ModelHomeFragment
) {

    fun onCreate(){

        onClickText()
        setDate()

    }

    private fun onClickText(){

        view.onClickHandler()

    }

    private fun setDate(){

        view.setDateToTextView()

    }


}