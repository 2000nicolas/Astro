package com.example.astra.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.astra.R
import com.example.astra.presentation.api.PlanetApi
import com.example.astra.presentation.api.PlanetResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class PlanetListFragment : Fragment() {

    private lateinit var recyclerView:RecyclerView

    private val adapter = PlanetAdapter(listOf(), ::onClickedPlanet)


    private val layoutManager = LinearLayoutManager(context)

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_planet_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.country_recyclerview)

        recyclerView.apply {
            layoutManager = this@PlanetListFragment.layoutManager
            adapter = this@PlanetListFragment.adapter
        }


        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.le-systeme-solaire.net/rest/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val planetApi: PlanetApi = retrofit.create(PlanetApi::class.java)

        planetApi.getCountryList().enqueue(object: Callback<PlanetResponse>{
            override fun onFailure(call: Call<PlanetResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<PlanetResponse>, response: Response<PlanetResponse>) {
                if(response.isSuccessful && response.body() != null){
                    val countryResponse = response.body()!!
                    adapter.updateList(countryResponse.bodies)
                }
            }

        })

        /*val countryList = arrayListOf<Country>().apply {
            add(Country("France"))
            add(Country("Roumanie"))
            add(Country("Russie"))
            add(Country("Test"))
        }*/


    }
    private fun onClickedPlanet(planet: Planet) {
        findNavController().navigate(R.id.navigateToPlanetDetailFragment)
    }
}