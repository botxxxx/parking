package com.example.parking.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.parking.api.NetworkService
import com.example.parking.api.model.BaseCallBack
import com.example.parking.api.model.BaseModel
import com.example.parking.api.model.LOGIN_001_Rq
import com.example.parking.api.model.LOGIN_001_Rs
import com.example.parking.callback.BaseViewInterface
import com.example.parking.utils.Loading

class MainViewModel : ViewModel() {
    val userLiveData: MutableLiveData<LOGIN_001_Rs?> = MutableLiveData()
    val onFailureLiveData: MutableLiveData<BaseModel?> = MutableLiveData()

    fun clearResponse() {
        userLiveData.value = null
        onFailureLiveData.value = null
    }

    fun getServiceStateList(baseViewInterface: BaseViewInterface, login: LOGIN_001_Rq) {
        clearResponse()
        Loading.show(baseViewInterface.getRootView())
        NetworkService.sendLoginRequest(login, object : BaseCallBack<LOGIN_001_Rs>(baseViewInterface) {
            override fun onResponse(response: LOGIN_001_Rs) {
                Log.e("response", "success")
                userLiveData.postValue(response)
                Loading.hide()
            }

            override fun onFailure() {
                Log.e("response", "fail")
                onFailureLiveData.postValue(BaseModel())
                Loading.hide()
            }
        })
    }
}