package ru.skillbranch.chat

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.skillbranch.chat.database.AUTH
import ru.skillbranch.chat.database.initFirebase
import ru.skillbranch.chat.database.initUser
import ru.skillbranch.chat.databinding.ActivityMainBinding
import ru.skillbranch.chat.ui.fragments.MainFragment
import ru.skillbranch.chat.ui.fragments.register.EnterPhoneNumberFragment
import ru.skillbranch.chat.ui.objects.AppDrawer
import ru.skillbranch.chat.utilits.*

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    lateinit var mAppDrawer: AppDrawer
    lateinit var mToolbar: Toolbar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        APP_ACTIVITY = this
        initFirebase()

        initUser {
            initFields()
            initFunc()
            CoroutineScope(Dispatchers.IO).launch {
                initContacts()
            }
        }
    }

    private fun initFunc() {
        setSupportActionBar(mToolbar)

        if (AUTH.currentUser != null) {
            mAppDrawer.create()
            replaceFragment(MainFragment(), false)
        } else {
           // replaceActivity(RegisterActivity())
            replaceFragment(EnterPhoneNumberFragment(), false)
        }
    }

    private fun initFields() {
        mToolbar = mBinding.mainToolbar
        mAppDrawer = AppDrawer()
    }

    override fun onStart() {
        super.onStart()
        AppStates.updateState(AppStates.ONLINE)
    }

    override fun onStop() {
        super.onStop()
        AppStates.updateState(AppStates.OFFLINE)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(ContextCompat.checkSelfPermission(APP_ACTIVITY, READ_CONTACT) == PackageManager.PERMISSION_GRANTED) {
            initContacts()
        }
    }
}