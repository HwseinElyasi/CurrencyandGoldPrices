package hwsein.developer.example.currencyandgoldprices.Mvp.Presenter

import hwsein.developer.example.currencyandgoldprices.Mvp.Model.ModelMainActivity
import hwsein.developer.example.currencyandgoldprices.Mvp.View.ViewMainActivity

class PresenterMainActivity(
    private val view : ViewMainActivity,
    private val model : ModelMainActivity
) {


    fun onCreate(){

        splashScreen()

    }

    private fun splashScreen(){

        view.setSplashScreen(model.replaceSplashFragment())

    }



}