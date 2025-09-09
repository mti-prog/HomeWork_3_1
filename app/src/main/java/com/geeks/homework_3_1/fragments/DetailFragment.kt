package com.geeks.homework_3_1.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.geeks.homework_3_1.databinding.FragmentDetailBinding
import com.geeks.homework_3_1.recycles_parameters.data_model.CarModel
import com.geeks.homework_3_1.recycles_parameters.ext.loadImg

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private lateinit var car : CarModel
    private val args: DetailFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val car = args.model
        binding.ivCar.loadImg(car.img)
        binding.tvName.text = car.name
        binding.tvType.text = car.carType
    }

}