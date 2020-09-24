package ru.skillbranch.chat.ui.fragments


import androidx.fragment.app.Fragment
import ru.skillbranch.chat.utilits.APP_ACTIVITY

open class BaseFragment(val layout: Int) : Fragment(layout) {

    override fun onStart() {
        super.onStart()
        APP_ACTIVITY.mAppDrawer.disableDrawer()
    }
}