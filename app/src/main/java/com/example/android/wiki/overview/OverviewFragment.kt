package com.example.android.wiki.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.android.wiki.databinding.OverviewFragmentBinding

class OverviewFragment : Fragment() {


//    private val viewModelOverview: OverviewViewModel by viewModels()
    private val viewModelOverview : OverviewViewModel by lazy {
    ViewModelProvider(this)[OverviewViewModel::class.java]
}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = OverviewFragmentBinding.inflate(inflater)

        // Позволяет связывать данные для наблюдения LiveData с
        // жизненным циклом этого фрагмента
        binding.lifecycleOwner = this

        // Предоставление доступа привязки к OverviewViewModel
        binding.viewModelOverview = viewModelOverview

        // Связь recyclerview с адаптером
        binding.recyclerview.adapter = MyAdapter(MyAdapter.OnClickListener{
            viewModelOverview.displayPropertyDetails(it)
        })

        // Наблюдатель для навигации
        viewModelOverview.navigateToSelectedProperty.observe(viewLifecycleOwner) {
            if (null != it) {
                this.findNavController().navigate(
                    OverviewFragmentDirections.actionOverviewFragmentToDetailFragment(it)
                )
            }
        }

        return binding.root
    }

}