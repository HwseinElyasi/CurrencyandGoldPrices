package hwsein.developer.example.currencyandgoldprices.Mvp.View

import android.content.Context
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import hwsein.developer.example.currencyandgoldprices.databinding.ActivityMainBinding
import hwsein.developer.example.currencyandgoldprices.ext.Utils

class ViewMainActivity(
    private val contextInstance: Context,
    private val utils: Utils
) {

    val binding = ActivityMainBinding.inflate(LayoutInflater.from(contextInstance))

    fun setSplashScreen(fragment: Fragment) {

        utils.setFragment(fragment)

    }

}