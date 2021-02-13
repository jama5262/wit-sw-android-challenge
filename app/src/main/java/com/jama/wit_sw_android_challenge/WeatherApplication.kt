package com.jama.wit_sw_android_challenge

import android.app.Application
import android.util.Log
import com.jama.wit_sw_android_challenge.di.networkModule
import com.jama.wit_sw_android_challenge.di.remoteDataSourceModule
import com.jama.wit_sw_android_challenge.di.useCaseModule
import com.jama.wit_sw_android_challenge.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class WeatherApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@WeatherApplication)
            modules(
                networkModule,
                remoteDataSourceModule,
                useCaseModule,
                viewModelModule
            )
        }
    }
}