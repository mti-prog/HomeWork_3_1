package com.geeks.homework_3_1.ui.add_item

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.geeks.homework_3_1.App
import com.geeks.homework_3_1.R
import com.geeks.homework_3_1.data.model.NoteModel
import com.geeks.homework_3_1.databinding.FragmentAddItemBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class AddItemFragment : Fragment() {
    private lateinit var binding: FragmentAddItemBinding
    private lateinit var car : NoteModel
    private val args: AddItemFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddItemBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnAdd.setOnClickListener {
            setupListener()
        }
    }

    private fun setupListener() {

        val title : String = binding.etTitle.text.toString()
        val text : String = binding.etText.text.toString()
        val date : String = getCurrentTime()
        App.db.noteDao().insertItem(NoteModel(title = title, text = text, date = date))
        findNavController().navigateUp()

    }

    fun getCurrentTime(): String {
        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("dd MMM HH:mm", Locale.getDefault())
        return dateFormat.format(calendar.time)
    }

}