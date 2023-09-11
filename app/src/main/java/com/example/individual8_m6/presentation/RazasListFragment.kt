package com.example.individual8_m6.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.individual8_m6.databinding.FragmentRazasListBinding


class RazasListFragment : Fragment() {
    lateinit var binding: FragmentRazasListBinding
    private val razaViewModel: ViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRazasListBinding.inflate(layoutInflater, container, false)
        initAdapter()
        razaViewModel.getAllRazas()
        return binding.root
    }

    private fun initAdapter() {
        val adapter = RazasAdapter()

        binding.recyclerView.adapter = adapter
        razaViewModel.razaLiveData().observe(viewLifecycleOwner){
            adapter.setData(it)
        }
    }

}