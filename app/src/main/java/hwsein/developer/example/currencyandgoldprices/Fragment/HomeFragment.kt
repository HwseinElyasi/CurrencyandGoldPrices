package hwsein.developer.example.currencyandgoldprices.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import hwsein.developer.example.currencyandgoldprices.Mvp.Model.ModelHomeFragment
import hwsein.developer.example.currencyandgoldprices.Mvp.Presenter.PresenterHomeFragment
import hwsein.developer.example.currencyandgoldprices.Mvp.View.ViewHomeFragment

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = ViewHomeFragment(context)
        val presenter = PresenterHomeFragment(view , ModelHomeFragment())
        presenter.onCreate()

        return view.binding.root

    }


}