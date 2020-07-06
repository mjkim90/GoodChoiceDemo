package com.example.goodchoicedemo.util

import android.content.Context
import android.content.pm.PackageManager
import android.util.TypedValue

class Util {

    /**
     * 앱의 버전을 가져온다
     */
    fun getAppVersion(context: Context): String? {
        var deviceVersion: String
        try {
            deviceVersion =
                context.packageManager.getPackageInfo(context.packageName, 0).versionName
        } catch (e: PackageManager.NameNotFoundException) {
            deviceVersion = ""
            e.printStackTrace()
        }
        val subVersionIdx = deviceVersion.indexOf("_")
        return if (subVersionIdx == -1) {
            deviceVersion
        } else {
            // 2.16.0_test 를 통과시키기 위해서 _test 를 자른다.
            deviceVersion.substring(0, subVersionIdx)
        }
    }

    /**
     * DP를 pixel로 환산
     */
    fun dpToPixel(context: Context, dp: Float): Float {
        val r = context.resources
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.displayMetrics)
    }

    private object Holder {
        val instance = Util()
    }

    companion object {
        val instance: Util by lazy { Holder.instance }
    }
}