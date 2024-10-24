package hwsein.developer.example.currencyandgoldprices.Adapter

import android.icu.text.DecimalFormat
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import hwsein.developer.example.currencyandgoldprices.Remote.Model.Detail
import hwsein.developer.example.currencyandgoldprices.databinding.ListItemBinding

class ProductRecycler(
    private val allData: ArrayList<Detail>
) : RecyclerView.Adapter<ProductRecycler.ProductViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ProductViewHolder(
            ListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount() = allData.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.setData(allData[position])
    }


    inner class ProductViewHolder(
        private val binding: ListItemBinding
    ) : ViewHolder(binding.root) {


        fun setData(data: Detail) {

            binding.txtLabel.text = data.label

            val df = DecimalFormat("0,000")
            val format = df.format(data.price)
            binding.txtPrice.text = format

        }


    }


}