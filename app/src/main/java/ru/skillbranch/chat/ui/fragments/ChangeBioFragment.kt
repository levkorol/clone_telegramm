package ru.skillbranch.chat.ui.fragments

import kotlinx.android.synthetic.main.fragment_change_bio.*
import ru.skillbranch.chat.R
import ru.skillbranch.chat.database.*
import ru.skillbranch.chat.utilits.*

class ChangeBioFragment : BaseChangeFragment(R.layout.fragment_change_bio) {

    override fun onResume() {
        super.onResume()
        settings_input_bio.setText(USER.bio)
    }

    override fun change() {
        super.change()
        val newBio = settings_input_bio.text.toString()
        setBioToDatabase(newBio)
    }
}