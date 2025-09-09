package com.geeks.homework_3_1.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import androidx.navigation.fragment.findNavController
import com.geeks.homework_3_1.R
import com.geeks.homework_3_1.databinding.FragmentMainBinding
import com.geeks.homework_3_1.keys.Keys
import com.geeks.homework_3_1.recycles_parameters.adapters.CarAdapter
import com.geeks.homework_3_1.recycles_parameters.data_model.CarModel

class MainFragment : Fragment() {
    private var data = arrayListOf<CarModel>()
    private lateinit var carAdapter : CarAdapter
    private lateinit var binding: FragmentMainBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        loadData()
    }

    private fun loadData() {
        carAdapter = CarAdapter(data, ::onClick)
        binding.rvCar.adapter = carAdapter
    }
    fun onClick(model : CarModel) {
        val action = MainFragmentDirections.actionMainFragmentToDetailFragment(model)
        findNavController().navigate(action)
    }

    fun init() {
        data = arrayListOf<CarModel>(
            CarModel(
                "BMW 5S",
                "$76",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRUvspjWAN2byVrrvOr5p4fexsN9vzG8JTsbQ&s",
                "Luxury",
                "Transition",
                "No"
            ),
            CarModel(
                "BMW 5S",
                "$76",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRUvspjWAN2byVrrvOr5p4fexsN9vzG8JTsbQ&s",
                "Luxury",
                "Transition",
                "No"
            ),
            CarModel(
                "BMW 5S",
                "$76",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRUvspjWAN2byVrrvOr5p4fexsN9vzG8JTsbQ&s",
                "Luxury",
                "Transition",
                "No"
            ),
            CarModel(
                "BMW 5S",
                "$76",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRUvspjWAN2byVrrvOr5p4fexsN9vzG8JTsbQ&s",
                "Luxury",
                "Transition",
                "No"
            ),
            CarModel(
                "BMW 5S",
                "$76",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRUvspjWAN2byVrrvOr5p4fexsN9vzG8JTsbQ&s",
                "Luxury",
                "Transition",
                "No"
            )
        )
    }


}