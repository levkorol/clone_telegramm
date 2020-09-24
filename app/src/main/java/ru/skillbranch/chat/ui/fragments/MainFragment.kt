package ru.skillbranch.chat.ui.fragments

import androidx.fragment.app.Fragment
import ru.skillbranch.chat.R
import ru.skillbranch.chat.utilits.APP_ACTIVITY
import ru.skillbranch.chat.utilits.hideKeyboard

class MainFragment : Fragment(R.layout.fragment_chat) {
    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.title = "Chatio"
        APP_ACTIVITY.mAppDrawer.enableDrawer()
        hideKeyboard()
    }
}