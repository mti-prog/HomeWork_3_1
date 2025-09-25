package com.geeks.homework_3_1.ui.main

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.geeks.homework_3_1.App
import com.geeks.homework_3_1.R
import com.geeks.homework_3_1.data.model.NoteModel
import com.geeks.homework_3_1.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    private val noteAdapter = NoteAdapter()
    private lateinit var binding: FragmentMainBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        setupListener()
        loadData()

    }

    private fun loadData() {
        val list : List<NoteModel> =  App.db.noteDao().getAllItems()
        noteAdapter.addList(list)
    }
    fun setupListener() {
        binding.fabAdd.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_addItemFragment)
        }
    }

    fun init() {
        binding.rvCar.adapter = noteAdapter
    }





}