package com.geeks.homework_3_1.ui.board

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.geeks.homework_3_1.R
import com.geeks.homework_3_1.data.pref.onBoardSharedPreferences
import com.geeks.homework_3_1.databinding.FragmentBoardBinding
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator


class BoardFragment : Fragment() {
    private var board = arrayListOf<BoardModel>()
    private lateinit var binding: FragmentBoardBinding
    private lateinit var boardAdapter: BoardAdapter



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        loadOnBoardData()
    }

    private fun init() {
        boardAdapter = BoardAdapter(loadOnBoardData(), ::onStartClick, ::onSkip)
        binding.viewPager.adapter = boardAdapter
        binding.wormDotsIndicator.attachTo(binding.viewPager)

    }
    fun onSkip(){
        binding.viewPager.setCurrentItem(2, true)
    }
    fun onStartClick(){
        val navOptions = NavOptions.Builder()
            .setPopUpTo(R.id.boardFragment, true) // Pop up to fragmentA and include it
            .build()
            val pref = onBoardSharedPreferences(requireContext())
            pref.entered()
        findNavController().navigate(R.id.action_boardFragment_to_mainFragment, null, navOptions)
    }

    fun loadOnBoardData() : ArrayList<BoardModel>{
        return arrayListOf(
            BoardModel(R.raw.second_lottie, "Удобство", "Создавайте заметки в два клика! Записывайте мысли, идеи и важные задачи мгновенно."),
            BoardModel(R.raw.second_lottie, "Организация", "Организуйте заметки по папкам и тегам. Легко находите нужную информацию в любое время."),
            BoardModel(R.raw.second_lottie, "Синхронизация", "Синхронизация на всех устройствах. Доступ к записям в любое время и в любом месте.")
        )
    }
}