package com.example.apiproject.repository

import com.example.apiproject.model.HoroscopeModel
import com.example.apiproject.service.RetrofitInstance
import retrofit2.Response

class Repository {


    suspend fun getPost(horoscopes:String,day:String):Response<HoroscopeModel>{
        return RetrofitInstance.api.getApi(horoscopes,day)
    }


}