package com.example.apiproject

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apiproject.model.HoroscopeModel
import com.example.apiproject.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private  var repository: Repository) : ViewModel(){

    val myResponse2: MutableLiveData<Response<HoroscopeModel>> = MutableLiveData()

    fun getPost(horoscopes:String,day:String){

        viewModelScope.launch {

            val response:Response<HoroscopeModel> =repository.getPost(horoscopes,day)
            myResponse2.value=response
        }



    }

}