package com.appworkd.muneemji.root.loggedout.main.navigation

import androidx.fragment.app.Fragment

interface MainNavigator {
    fun navigateToSplash(containerId : Int, fragment: Fragment)
}