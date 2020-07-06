package com.example.goodchoicedemo.architecture

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.goodchoicedemo.api.retofit.php.APIController
import com.example.goodchoicedemo.architecture.bases.BaseViewModel
import com.example.goodchoicedemo.model.MainListResponse
import com.example.goodchoicedemo.model.ResProductListModel
import com.example.goodchoicedemo.util.WLog

class HomeViewModel : BaseViewModel() {

    val homeListLiveData = MutableLiveData<ResProductListModel>()

    @SuppressLint("CheckResult")
    fun requestMainList(page: Int) {
        APIController.instance.requestMainList(page).subscribe({
            homeListLiveData.value = it
        }) { e ->
            APIController.instance.onCommonError(e).subscribe {
            }
        }
    }
}