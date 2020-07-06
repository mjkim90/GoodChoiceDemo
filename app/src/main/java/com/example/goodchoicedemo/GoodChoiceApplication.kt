package com.example.goodchoicedemo

import android.app.Application
import com.example.goodchoicedemo.api.retofit.php.APIController
import com.example.goodchoicedemo.architecture.HomeViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class GoodChoiceApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        //API컨트롤러에 사용한 Context 초기화
        APIController.instance.init(applicationContext)

        startKoin {
            androidLogger()
            androidContext(this@GoodChoiceApplication)
            modules(
                listOf(
                    module { viewModel { HomeViewModel() } }
                )
            )
        }
    }
}