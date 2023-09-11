package com.example.individual8_m6.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.individual8_m6.databinding.FragmentDetailDogBinding

private const val ARG_PARAM1 = "id"
class DetailDogFragment : Fragment() {
    lateinit var binding: FragmentDetailDogBinding
    private val razaViewModel: ViewModel by activityViewModels()



    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailDogBinding.inflate(layoutInflater, container, false)
        initAdapter()
        razaViewModel.getDetallePerroVM(param1.toString())
        return binding.root
    }

    private fun initAdapter() {
        val adapter = DetailAdapter()
        binding.recyclerViewDetalle.adapter = adapter
        razaViewModel.detalleLiveData(param1.toString()).observe(viewLifecycleOwner) {
            adapter.setDataDetalle(it)
        }
    }
}