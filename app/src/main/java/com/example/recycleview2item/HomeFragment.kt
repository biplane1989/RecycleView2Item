package com.example.recycleview2item

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.recycleview2item.databinding.FragmentHomeBinding
import java.util.*

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val homeViewmodel: HomeViewmodel by viewModels()

    private val adapter: Adapter by lazy {
        Adapter(this::onItemClicked)
    }

    private val dataObserver = Observer<List<DataItem>> {
        adapter.submitList(it)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.viewmodel = homeViewmodel
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rv.adapter = adapter
        homeViewmodel.listData.observe(viewLifecycleOwner, dataObserver)

        binding.orange.setOnClickListener {
            homeViewmodel.changeData()
        }
    }

    fun onItemClicked(dataItem: DataItem){
        homeViewmodel.filterTypeFolder(dataItem)
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment().apply {}
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}