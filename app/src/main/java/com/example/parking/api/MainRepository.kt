package com.example.parking.api

import android.util.Log
import com.example.parking.api.data.LOGIN_001_Rq
import com.example.parking.api.data.LOGIN_001_Rs
import com.example.parking.api.model.BaseCallBack
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Named

class MainRepository @Inject constructor(@Named("Login") private val service: Retrofit) {
    private val serviceApi = service.create(ApiService::class.java)

    fun sendLoginRequest(login: LOGIN_001_Rq, callback: BaseCallBack<LOGIN_001_Rs>) {
        callback.lifecycleScope.launch(Dispatchers.IO) {
            try {
                withContext(Dispatchers.Main) {
                    val request = serviceApi.doLogin(login.user, login.pwd)
                    Log.e("request", "$request")
                    callback.getResponse(request)
                }
            } catch (ex: Exception) {
                Log.e("error", "sendAppRequest fail: ${Log.getStackTraceString(ex)}")
                callback.onFailure()
            }
        }
    }
}
