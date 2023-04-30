package com.example.weathersecurity.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.weathersecurity.databinding.FragmentMainLayoutBinding


class MainFragment : Fragment() {

    private var binding: FragmentMainLayoutBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainLayoutBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }


    companion object {
        var POSITION_ARG = "position_arg"

        @JvmStatic
        fun newInstance(position: Int) = MainFragment().apply {
            arguments = Bundle().apply {
                putInt(POSITION_ARG, position)
            }
        }

    }
}