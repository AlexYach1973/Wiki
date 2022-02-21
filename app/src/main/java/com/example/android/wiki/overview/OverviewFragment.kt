package com.example.android.wiki.overview

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.android.wiki.MyApplication
import com.example.android.wiki.databinding.OverviewFragmentBinding
import javax.inject.Inject

class OverviewFragment : Fragment() {

    /** Dagger */
    @Inject
    lateinit var viewModelOverview: OverviewViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as MyApplication).appComponent.inject(this)
    }
    /** ****** */

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Потому-что Dagger
//        val viewModelOverview = ViewModelProvider(this)[OverviewViewModel::class.java]

        val binding = OverviewFragmentBinding.inflate(inflater)

        // Позволяет связывать данные для наблюдения LiveData с
        // жизненным циклом этого фрагмента
        binding.lifecycleOwner = this

        // Предоставление доступа привязки к OverviewViewModel
        binding.viewModelOverview = viewModelOverview

        // Связь recyclerview с адаптером (передаем нажатие на элемент)
        binding.recyclerview.adapter = MyAdapter(MyAdapter.OnClickListener {
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