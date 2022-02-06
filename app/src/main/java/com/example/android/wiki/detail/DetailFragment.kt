package com.example.android.wiki.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.android.wiki.databinding.DetailFragmentBinding

class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val application = requireNotNull(activity).application

        val binding = DetailFragmentBinding.inflate(inflater)

        // Позволяет связывать данные для наблюдения LiveData с
        // жизненным циклом этого фрагмента
        binding.lifecycleOwner = this

        // Получаем выбраный объект из OverviewFragment
        val mProperty = DetailFragmentArgs.fromBundle(requireArguments())
            .selectedProperty

        // ViewModelFactory
        val viewModelFactory = DetailViewModelFactory(mProperty, application)

        // ViewModel
        binding.viewModelDetail =
            ViewModelProvider(this, viewModelFactory)[DetailViewModel::class.java]


        return binding.root
    }

}
