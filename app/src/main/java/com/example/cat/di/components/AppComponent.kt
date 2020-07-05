package com.example.cat.di.components

import com.example.cat.CatApplication
import com.example.cat.di.modules.AppModule
import com.example.cat.di.modules.BuildersModule
import com.example.cat.di.modules.NetModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidInjectionModule::class, BuildersModule::class, AppModule::class, NetModule::class]
)
interface AppComponent {

 fun inject(app: CatApplication)
}