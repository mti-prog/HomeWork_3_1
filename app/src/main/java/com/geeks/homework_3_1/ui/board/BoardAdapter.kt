package com.geeks.homework_3_1.ui.board

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geeks.homework_3_1.R
import com.geeks.homework_3_1.data.model.CarModel
import com.geeks.homework_3_1.databinding.BoardItemBinding
import com.geeks.homework_3_1.ext.loadGif
import com.geeks.homework_3_1.ext.loadImg
import com.geeks.homework_3_1.ui.board.BoardAdapter.BoardViewHolder

class BoardAdapter(var board: ArrayList<BoardModel>, val onStart: () -> Unit, val onSkip:()-> Unit) : RecyclerView.Adapter<BoardViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BoardViewHolder {
        return BoardViewHolder(BoardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(
        holder: BoardViewHolder,
        position: Int
    ) {
        holder.bind(board[position])
    }

    override fun getItemCount(): Int {
        return board.size
    }

    inner class BoardViewHolder(private var binding: BoardItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(model: BoardModel) {
            binding.lottieView.setImageResource(model.lottie)
            binding.tvTitle.text = model.title
            binding.tvDes.text = model.desc

            if (absoluteAdapterPosition != board.size-1){
                binding.tvSkip.visibility = View.VISIBLE
                binding.btnStart.visibility = View.GONE
                binding.tvSkip.setOnClickListener {
                    onSkip()
                }
            }else{
                binding.btnStart.visibility = View.VISIBLE
                binding.btnStart.setOnClickListener {
                    onStart()
                }
                binding.tvSkip.visibility = View.GONE
            }
        }
    }
}