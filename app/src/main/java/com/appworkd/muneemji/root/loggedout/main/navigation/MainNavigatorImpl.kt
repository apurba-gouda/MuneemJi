package com.appworkd.muneemji.root.loggedout.main.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.appworkd.muneemji.root.loggedout.main.view.MainActivity

class MainNavigatorImpl(private val activity: MainActivity) : MainNavigator {

    private val fragmentManager: FragmentManager = getFragmentManager()

    private fun getFragmentManager(): FragmentManager = activity.supportFragmentManager

    override fun navigateToSplash(containerId: Int, fragment: Fragment) {
        fragmentManager.beginTransaction()
            .add(containerId, fragment)
            .commit()
    }
}