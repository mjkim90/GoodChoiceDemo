package com.example.goodchoicedemo.api.retofit.php

object APIConsts {
    // Version 3
    private const val V3_BASE_URL = "/v3/"

    // V3 PHP Base Url
    //private const val V3_PHP_BASE_URL = "${BaseAPIConsts.PHP_BASE_URL}/v3/"

    // Push
    const val FCM_URL = "${V3_BASE_URL}fcm/"                    // FCM 푸시 토큰 등록

    // App Version Check
    const val APP_VERSION_URL = "${V3_BASE_URL}app-version/"     // 서버 상태

    // Notice
    const val WAUGDAY_URL = "${V3_BASE_URL}notice/"

    const val TERMS_URL = "${V3_BASE_URL}terms/"
    const val PRIVACY_URL = "${V3_BASE_URL}privacy/"

    // Event
    const val EVENT_URL = "${V3_BASE_URL}event/"

    // Order
    private const val ORDER_URL = "${V3_BASE_URL}order/"
    const val ORDER_2_1_URL = "${ORDER_URL}2.1/"
    private const val ORDER_SUCCESS_URL = "${ORDER_URL}success/"
    const val ORDER_SUCCESS_NEW_URL = "${ORDER_SUCCESS_URL}new/"
    private const val ORDER_INFO_URL = "${ORDER_URL}info/"
    const val ORDER_INFO_2_URL = "${ORDER_INFO_URL}2.0/"

    //Coupon
    private const val ORDER_COUPON_URL = "${ORDER_URL}coupon/"
    const val ORDER_COUPON_2_URL = "${ORDER_COUPON_URL}2.0/"

    // Creadits
    const val CREDITS_URL = "${V3_BASE_URL}credits/"

    // My Page
    private const val MYPAGE_URL = "${V3_BASE_URL}mypage/"
    const val MYPAGE_INFO_URL = "${MYPAGE_URL}new/"
    private const val MYPAGE_ORDER_URL = "${MYPAGE_URL}order/"
    const val MYPAGE_ORDER_NEW_URL = "${MYPAGE_ORDER_URL}new/"
}