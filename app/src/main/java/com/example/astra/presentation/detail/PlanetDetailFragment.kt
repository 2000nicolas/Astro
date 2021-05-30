package com.example.astra.presentation.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.astra.R
import com.example.astra.presentation.Singletons
import com.example.astra.presentation.api.PlanetDetailResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PlanetDetailFragment : Fragment() {
    private lateinit var textViewName:TextView
    private lateinit var textViewEnglishName:TextView
    private lateinit var textViewisPlanet:TextView
    private lateinit var textViewmassValue:TextView
    private lateinit var textViewmassExponent:TextView
    private lateinit var textViewdensity:TextView
    private lateinit var textViewgravity:TextView



    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_planet_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewName = view.findViewById(R.id.planet_detail_name)
        textViewEnglishName = view.findViewById(R.id.planet_detail_englishName)
        textViewisPlanet = view.findViewById(R.id.planet_detail_isPlanet)
        textViewmassExponent = view.findViewById(R.id.planet_detail_massExponent)
        textViewmassValue = view.findViewById(R.id.planet_detail_massValue)
        textViewdensity = view.findViewById(R.id.planet_detail_density)
        textViewgravity = view.findViewById(R.id.planet_detail_gravity)
        callApi()
        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.navigateToPlanetListFragment)
        }



    }
    private fun callApi(){
        val id=arguments?.getString("planetId") ?: -1
        Singletons.planetApi.getPlanetDetail(id as String).enqueue(object : Callback<PlanetDetailResponse>{
            override fun onFailure(call: Call<PlanetDetailResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<PlanetDetailResponse>, response: Response<PlanetDetailResponse>) {
                if(response.isSuccessful && response.body() != null) {
                    textViewName.text = response.body()!!.name
                    textViewEnglishName.text = "English Name : " + response.body()!!.englishName
                    textViewisPlanet.text = "Est elle une planete ? " + response.body()!!.isPlanet
                    textViewmassExponent.text = "Exposant de masse : " + response.body()!!.mass.massExponent
                    textViewmassValue.text = "Masse : " + response.body()!!.mass.massValue
                    textViewdensity.text = "densité : " + response.body()!!.density
                    textViewgravity.text = "indice gravitationnel : " + response.body()!!.gravity


                }
            }

        })
    }
}