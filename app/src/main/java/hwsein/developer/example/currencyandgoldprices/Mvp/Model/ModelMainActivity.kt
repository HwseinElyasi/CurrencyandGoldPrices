package hwsein.developer.example.currencyandgoldprices.Mvp.Model

import hwsein.developer.example.currencyandgoldprices.Fragment.SplashFragment
import hwsein.developer.example.currencyandgoldprices.ext.Utils

class ModelMainActivity(
   private val utils: Utils
) {

   fun replaceSplashFragment() = SplashFragment(utils)

}