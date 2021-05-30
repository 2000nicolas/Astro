package com.example.astra.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.astra.presentation.Singletons
import com.example.astra.presentation.api.PlanetListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlanetListViewModel : ViewModel(){
    val planetList: MutableLiveData<PlanetModel> = MutableLiveData()

    init {
        callApi()
    }

    private fun callApi() {
        planetList.value = PlanetLoader

        Singletons.planetApi.getPlanetList().enqueue(object: Callback<PlanetListResponse> {
            override fun onFailure(call: Call<PlanetListResponse>, t: Throwable) {
                planetList.value = PlanetError
            }

            override fun onResponse(call: Call<PlanetListResponse>, response: Response<PlanetListResponse>) {
                if(response.isSuccessful && response.body() != null){
                    val planetListResponse = response.body()!!
                    planetList.value = PlanetSuccess(planetListResponse.bodies)
                }else{
                    planetList.value = PlanetError
                }
            }

        })
    }
}