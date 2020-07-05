package com.example.cat

import android.app.Activity
import android.app.Application
import com.example.cat.di.components.DaggerAppComponent
import com.example.cat.di.modules.AppModule
import com.example.cat.di.modules.NetModule
import com.example.cat.util.Constants
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class CatApplication: Application(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .netModule(NetModule( Constants.BASE_URL))
            .build().inject(this)
    }
    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

}