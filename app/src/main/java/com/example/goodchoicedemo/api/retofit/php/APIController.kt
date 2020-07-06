package com.example.goodchoicedemo.api.retofit.php

import com.example.goodchoicedemo.api.retofit.php.bases.BaseAPIController
import com.example.goodchoicedemo.model.MainListResponse
import com.example.goodchoicedemo.model.ResProductListModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class APIController : BaseAPIController() {

    fun requestMainList(page: Int): Observable<ResProductListModel> {
        return getService().requestMainList(page)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
    }


    private object Holder {
        val INSTANCE = APIController()
    }

    companion object {
        val instance: APIController by lazy { Holder.INSTANCE }
    }
}