package com.example.country.presentation.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.country.R

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class CountryListFragment : Fragment() {

    private lateinit var recyclerView:RecyclerView

    private val adapter = CountryAdapter(listOf())
    private val layoutManager = LinearLayoutManager(context)

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_country_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.country_recyclerview)

        recyclerView.apply {
            layoutManager = this@CountryListFragment.layoutManager
            adapter = this@CountryListFragment.adapter
        }

        val countryList = arrayListOf<Country>().apply {
            add(Country("France"))
            add(Country("Roumanie"))
            add(Country("Russie"))
            add(Country("Test"))
        }

        adapter.updateList(countryList)
    }
}