package com.droid.jetpacktutorial.navigation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.droid.jetpacktutorial.R


/**
 * Add the below dependencies in Project build.gradle
 * classpath "android.arch.navigation:navigation-safe-args-gradle-plugin:1.0.0-alpha01"
 * Add the below dependencies in app build.gradle
 * apply plugin: 'androidx.navigation.safeargs'
 * implementation "androidx.navigation:navigation-fragment-ktx:${navigationVersion}"
 * implementation "androidx.navigation:navigation-ui-ktx:${navigationVersion}"
 */
class NavigationActivity : AppCompatActivity() {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.navigation_activity)

        initNavController()
    }

    private fun initNavController() {
        navController = Navigation.findNavController(this, R.id.fragment)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, null)
    }
}