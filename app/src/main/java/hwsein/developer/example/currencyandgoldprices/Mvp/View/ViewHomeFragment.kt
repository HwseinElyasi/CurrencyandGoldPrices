package hwsein.developer.example.currencyandgoldprices.Mvp.View

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import hwsein.developer.example.currencyandgoldprices.Adapter.ProductRecycler
import hwsein.developer.example.currencyandgoldprices.R
import hwsein.developer.example.currencyandgoldprices.Remote.Model.Currencies
import hwsein.developer.example.currencyandgoldprices.Remote.Model.DateAll
import hwsein.developer.example.currencyandgoldprices.Remote.Model.Detail
import hwsein.developer.example.currencyandgoldprices.Remote.Repository.ProductRepository
import hwsein.developer.example.currencyandgoldprices.Remote.Repository.TimeApiRepository
import hwsein.developer.example.currencyandgoldprices.databinding.HomeFragmentBinding
import hwsein.developer.example.currencyandgoldprices.ext.CallBackHandler
import hwsein.developer.example.currencyandgoldprices.ext.RequestTime

class ViewHomeFragment(
    private val context: Context?
) {

    private var gold = ArrayList<Detail>()
    private var currenci = ArrayList<Detail>()


    val binding = HomeFragmentBinding.inflate(LayoutInflater.from(context))


    fun onClickHandler() {

        setData()

        binding.textGold.setOnClickListener {

            binding.textGold.setTextColor(ContextCompat.getColor(context!!, R.color.gold_text))
            binding.textCurrency.setTextColor(ContextCompat.getColor(context, R.color.white_text))
            initRecycler(gold)

        }

        binding.textCurrency.setOnClickListener {

            binding.textGold.setTextColor(ContextCompat.getColor(context!!, R.color.white_text))
            binding.textCurrency.setTextColor(ContextCompat.getColor(context, R.color.gold_text))
            initRecycler(currenci)

        }

    }

    private fun initRecycler(data: ArrayList<Detail>) {

        binding.recyclerView.layoutManager = LinearLayoutManager(
            context,
            RecyclerView.VERTICAL,
            false
        )

        binding.recyclerView.adapter = ProductRecycler(data)

    }

    private fun setData() {

        ProductRepository.instance.getDetail(

            object : CallBackHandler {

                override fun onSuccess(data: Currencies) {

                    binding.progressBar.visibility = View.INVISIBLE
                    gold.addAll(data.data.golds)
                    currenci.addAll(data.data.currencies)
                    initRecycler(gold)

                }

                override fun onNotSuccess(message: String) {

                    showToast(message)

                }

                override fun onError(message: String) {

                    Log.e("SERVER_ERROR", message)

                }


            }
        )


    }

    fun setDateToTextView() {

        TimeApiRepository.instance.getDate(true,
            object : RequestTime {
                @SuppressLint("SetTextI18n")
                override fun onSuccess(data: DateAll) {

                    binding.progressBar2.visibility = View.INVISIBLE

                    val day = data.date.weekDay
                    val date = data.date.date
                    val month = data.date.month
                    val year = data.date.year

                    binding.textDate.text = "$day $date $month $year"

                }

                override fun onNotSuccess(message: String) {

                    showToast(message)

                }

                override fun onError(message: String) {

                    Log.e("SERVER_ERROR", message)

                }


            })


    }

    private fun showToast(text: String) {

        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()

    }

}