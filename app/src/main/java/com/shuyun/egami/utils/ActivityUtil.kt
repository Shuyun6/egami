package com.shuyun.egami.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

import androidx.core.util.Preconditions.checkNotNull

object ActivityUtil {

    fun addFragment2Activity(fragmentManager: FragmentManager, fragment: Fragment, frameId: Int) {
        checkNotNull(fragmentManager)
        checkNotNull(fragment)
        val transaction = fragmentManager.beginTransaction()
        transaction.add(frameId, fragment)
        transaction.commit()
    }

}
