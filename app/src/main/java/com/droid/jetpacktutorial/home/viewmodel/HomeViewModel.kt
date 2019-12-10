package com.droid.jetpacktutorial.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    val topics = listOf("Security", "Navigation", "Paging", "Room", "Workmanager", "CameraX", "Notifications", "Permissions", "Preferences", "Sharing", "Palette")

    private var selectedtopic : MutableLiveData<String> = MutableLiveData()

    fun getSelectedTopic() : MutableLiveData<String> = selectedtopic

    fun onTopicClicked(name: String) {
        selectedtopic.postValue(name)
    }

}