package com.example.parking.api

import com.example.parking.api.data.AVL_001_Rs
import com.example.parking.api.data.DESC_001_Rs
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.util.*

interface JsonService {
    //    ● 台北市政府開放資料 - 臺北市停車場資訊V2
    //    ○ https://tcgbusfs.blob.core.windows.net/blobtcmsv/TCMSV_alldesc.json
    //    ● 台北市政府開放資料 - 剩餘停車位數V2
    //    ○ https://tcgbusfs.blob.core.windows.net/blobtcmsv/TCMSV_allavailable.json
    @GET("blobtcmsv/TCMSV_alldesc.json")
    suspend fun getParkingDesc(): DESC_001_Rs

    @GET("blobtcmsv/TCMSV_allavailable.json")
    suspend fun getParkingAvailable(): AVL_001_Rs
}