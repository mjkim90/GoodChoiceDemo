package com.example.goodchoicedemo.api.retofit.php

import com.example.goodchoicedemo.model.MainListResponse
import com.example.goodchoicedemo.model.ResProductListModel
import io.reactivex.Observable
import retrofit2.http.*
import kotlin.collections.ArrayList

interface APIService {

    // 메인리스트 조회
    @GET("App/json/{page}.json")
    fun requestMainList(@Path("page") page: Int): Observable<ResProductListModel>
}