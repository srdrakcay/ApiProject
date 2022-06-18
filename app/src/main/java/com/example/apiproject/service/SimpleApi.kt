package com.example.apiproject.service

import com.example.apiproject.model.HoroscopeModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SimpleApi {


    @GET("?sign={horoscopes}&day={day}")

    suspend fun getApi(

        @Query("horoscopes") horoscopes: String,
        @Query("day") day:String ) :Response<HoroscopeModel>





}


