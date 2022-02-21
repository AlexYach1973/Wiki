package com.example.android.wiki.detail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android.wiki.MyApplication
import com.example.android.wiki.databinding.DetailFragmentBinding
import javax.inject.Inject


class DetailFragment : Fragment() {

   /** Dagger */
    @Inject
    lateinit var detailViewModel: DetailViewModel

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
//        val detailViewModel = ViewModelProvider(this)[DetailViewModel::class.java]

        val binding = DetailFragmentBinding.inflate(inflater)

        // Позволяет связывать данные для наблюдения LiveData с
        // жизненным циклом этого фрагмента
        binding.lifecycleOwner = this

        // Получаем выбраный объект из OverviewFragment
        val mProperty = DetailFragmentArgs.fromBundle(requireArguments())
            .selectedProperty

        detailViewModel.setProperty(mProperty)

        binding.viewModelDetail = detailViewModel

        return binding.root
    }

}
