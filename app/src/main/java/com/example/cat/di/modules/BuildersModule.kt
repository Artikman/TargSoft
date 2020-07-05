package com.example.cat.di.modules

import com.example.cat.listcats.ui.ListCatsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuildersModule {
    @ContributesAndroidInjector
    abstract fun contibuteListCatActivity(): ListCatsActivity
}