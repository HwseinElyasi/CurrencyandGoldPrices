package hwsein.developer.example.currencyandgoldprices.Ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import hwsein.developer.example.currencyandgoldprices.Mvp.Model.ModelMainActivity
import hwsein.developer.example.currencyandgoldprices.Mvp.Presenter.PresenterMainActivity
import hwsein.developer.example.currencyandgoldprices.Mvp.View.ViewMainActivity
import hwsein.developer.example.currencyandgoldprices.R
import hwsein.developer.example.currencyandgoldprices.ext.Utils

class MainActivity : AppCompatActivity(), Utils {
    private lateinit var view: ViewMainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = ViewMainActivity(this, this)
        setContentView(view.binding.root)

        val presenter = PresenterMainActivity(view, ModelMainActivity(this))
        presenter.onCreate()

    }

    override fun finished() {

        finish()
    }

    override fun setFragment(fragment: Fragment) {

        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, fragment)
            .commit()

    }

}