package hwsein.developer.example.currencyandgoldprices.Fragment

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialog
import hwsein.developer.example.currencyandgoldprices.databinding.BottomSheetDialogBinding
import hwsein.developer.example.currencyandgoldprices.databinding.SplashFragmentBinding
import hwsein.developer.example.currencyandgoldprices.ext.Utils

class SplashFragment(
    private val utils: Utils
) : Fragment() {

    private lateinit var binding: SplashFragmentBinding
    private lateinit var bottomSheet: BottomSheetDialog
    private lateinit var networkReceiver: ConnectivityReceiver

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = SplashFragmentBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (isInternetAvailable(requireContext()))
            handler()

       showBottom()

        networkReceiver = ConnectivityReceiver()

    }

    private fun showBottom() {

        val view = BottomSheetDialogBinding.inflate(layoutInflater)

        bottomSheet = BottomSheetDialog(requireContext())

        view.viewMobileInternet.setOnClickListener {
            startActivity(Intent(Settings.ACTION_DATA_ROAMING_SETTINGS))
        }

        view.viewWifi.setOnClickListener {
            startActivity(Intent(Settings.ACTION_WIFI_SETTINGS))
        }


        bottomSheet.setContentView(view.root)
        bottomSheet.setCancelable(false)
        bottomSheet.show()

    }

    fun isInternetAvailable(context: Context): Boolean {

        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val network = connectivityManager.activeNetwork ?: return false
            val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false
            return when {
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                else -> false
            }
        } else {
            val networkInfo = connectivityManager.activeNetworkInfo ?: return false
            return networkInfo.isConnected
        }
    }

    private fun handler() {

        Handler(Looper.getMainLooper()).postDelayed({

            utils.setFragment(HomeFragment())

        }, 5000)


    }

    override fun onResume() {
        super.onResume()

        context?.registerReceiver(
            networkReceiver,
            IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        )


    }

    override fun onPause() {
        super.onPause()

        context?.unregisterReceiver(networkReceiver)

    }

    inner class ConnectivityReceiver : BroadcastReceiver() {

        override fun onReceive(context: Context?, intent: Intent?) {

            if (isInternetAvailable(context!!)) {
                if (bottomSheet.isShowing) {
                    bottomSheet.dismiss()
                    handler()
                }

            } else {

                if (!isInternetAvailable(context)) {
                    bottomSheet.show()
                }
            }


        }


    }


}
