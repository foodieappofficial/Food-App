package com.example.foodapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.CategoryAdapter
import com.example.foodapp.Model
import com.example.foodapp.R
import com.example.foodapp.databinding.FragmentHomeBinding
import com.recyclerviewapp.RecomItemAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var foodList :ArrayList<Model>
    lateinit var imageId : Array<Int>
    lateinit var titleId : Array<String>

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        homeViewModel.text.observe(viewLifecycleOwner) {

        }


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageId = arrayOf(
            R.drawable.coffe,
            R.drawable.coffe,
            R.drawable.coffe,
            R.drawable.coffe,
            R.drawable.coffe,
            R.drawable.coffe,
            R.drawable.coffe

            )
        titleId = arrayOf(
            "Caffe",
            "Caffe",
            "Caffe",
            "Caffe",
            "Caffe",
            "Caffe",
            "Caffe"
        )
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        binding.recyclerView.setHasFixedSize(true)
        foodList = arrayListOf<Model>()
        getUserdata()



        // set the layout manager for recommendation recycler
        recom_recycler_view_items.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false )

        // adapter class initialized and list passed in it
        val itemAdapter = RecomItemAdapter(requireContext(), getItemsList())

        recom_recycler_view_items.adapter = itemAdapter




    }

    private fun getUserdata() {
       for (i in imageId.indices){
           val food = Model(imageId[i],titleId[i])
           foodList.add(food)
       }
        binding.recyclerView.adapter = CategoryAdapter(foodList)
    }


    // setting list for recomm recycler
    private fun getItemsList(): ArrayList<String>{

        val list = ArrayList<String>()

        for (i in 1..15 ){
            list.add("item $i")
        }

        return list

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}