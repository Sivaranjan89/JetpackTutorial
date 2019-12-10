package com.droid.jetpacktutorial.dagger

import android.app.Application
import com.droid.jetpacktutorial.home.adapter.TopicsAdapter
import com.droid.jetpacktutorial.home.viewmodel.HomeViewModel
import dagger.Module
import dagger.Provides

@Module
class HomeModule {

    @Provides
    fun bindHomeViewModel() : HomeViewModel = HomeViewModel()

    @Provides
    fun bindAdapter(application: Application) : TopicsAdapter = TopicsAdapter(application)
}