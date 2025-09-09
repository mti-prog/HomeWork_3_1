package com.geeks.homework_3_1.recycles_parameters.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geeks.homework_3_1.databinding.CarItemBinding
import com.geeks.homework_3_1.recycles_parameters.data_model.CarModel
import com.geeks.homework_3_1.recycles_parameters.ext.loadImg

class CarAdapter(
    var data: ArrayList<CarModel>, val onClick: (model : CarModel) -> Unit
) : RecyclerView.Adapter<CarAdapter.CarViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CarViewHolder {
        return CarViewHolder(
            CarItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: CarViewHolder,
        position: Int
    ) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

    inner class CarViewHolder(private val binding: CarItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CarModel) {
            binding.ivCar.loadImg(item.img)
            binding.tvName.text = item.name
            binding.tvPrice.text = item.price
            binding.tvCarType.text = item.carType
            binding.tvSet.text = item.set
            binding.tvSnowflake.text = item.snowflake
            binding.root.setOnClickListener {
                onClick(item)
            }
        }
    }
}