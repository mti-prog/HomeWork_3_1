package com.geeks.homework_3_1.ui.main

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geeks.homework_3_1.App

import com.geeks.homework_3_1.data.model.NoteModel
import com.geeks.homework_3_1.databinding.NoteItemBinding

class NoteAdapter() : RecyclerView.Adapter<NoteAdapter.CarViewHolder>() {

    private var data: ArrayList<NoteModel> = arrayListOf()

    fun addList(list: List<NoteModel>){
        data.clear()
        data.addAll(list) }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CarViewHolder {
        return CarViewHolder(
            NoteItemBinding.inflate(
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

    inner class CarViewHolder(private val binding: NoteItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: NoteModel) {
            binding.tvTitle.text = item.title
            binding.tvText.text = item.text
            binding.tvDate.text = item.date
            binding.root.setOnLongClickListener {
                val builder = AlertDialog.Builder(itemView.context)
                builder.setTitle("Delete Item")
                builder.setMessage("Are you sure you want to delete this item?")
                builder.setPositiveButton("Delete") { dialog, which ->
                    App.db.noteDao().deleteItem(NoteModel(item.id, item.title, item.text, item.date))
                    data.removeAt(bindingAdapterPosition)
                    notifyItemRemoved(bindingAdapterPosition)
                    dialog.dismiss()
                }
                builder.setNegativeButton("Cancel") { dialog, which ->
                    dialog.dismiss()
                }
                val dialog: AlertDialog = builder.create()
                dialog.show()
                true
            }
        }
    }
}