package com.example.goodchoicedemo.model.bases

open class BaseResponseModel<T> {

    var msg = ""
    var data: T? = null
    var code = 0
}