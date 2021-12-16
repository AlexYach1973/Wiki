package com.example.android.wiki

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.android.wiki.databinding.FragmentStartBinding

class StartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentStartBinding.inflate(inflater)

        binding.lifecycleOwner = viewLifecycleOwner

    // Click Start Button. Goto OverviewFragment
        binding.buttonStart.setOnClickListener{
            findNavController().navigate(StartFragmentDirections
                .actionStartFragmentToOverviewFragment()
            )
        }

        return binding.root
    }

}