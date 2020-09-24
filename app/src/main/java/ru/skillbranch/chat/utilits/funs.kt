package ru.skillbranch.chat.utilits

import android.Manifest
import android.content.Context
import android.content.Intent
import android.provider.ContactsContract
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import ru.skillbranch.chat.MainActivity
import ru.skillbranch.chat.R
import ru.skillbranch.chat.database.updatePhonesToDatabase
import ru.skillbranch.chat.models.CommonModel
import java.text.SimpleDateFormat
import java.util.*

fun showToast(message: String) {
    Toast.makeText(APP_ACTIVITY, message, Toast.LENGTH_LONG).show()
}

//открыть активити
//fun AppCompatActivity.replaceActivity(activity: AppCompatActivity) {
//    val intent = Intent(this, activity::class.java)
//    startActivity(intent)
//    this.finish()
//}
fun restartActivity() {
    val intent = Intent(APP_ACTIVITY, MainActivity::class.java)
    APP_ACTIVITY.startActivity(intent)
    APP_ACTIVITY.finish()
}

fun replaceFragment(fragment: Fragment, addStack: Boolean = true) {
    if (addStack) {
        APP_ACTIVITY.supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.data_container, fragment).commit()
    } else {
        APP_ACTIVITY.supportFragmentManager.beginTransaction()
            .replace(R.id.data_container, fragment).commit()
    }
}

//из активити в фрагмент
//fun AppCompatActivity.replaceFragment(fragment: Fragment, addStack: Boolean = true) {
//    if (addStack) {
//        supportFragmentManager.beginTransaction()
//            .addToBackStack(null)
//            .replace(R.id.data_container, fragment).commit()
//    } else {
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.data_container, fragment).commit()
//    }
//
//}

// во фрагментах
//fun Fragment.replaceFragment(fragment: Fragment) {
//    this.fragmentManager?.beginTransaction()
//        ?.addToBackStack(null)
//        ?.replace(R.id.data_container, fragment)?.commit()
//}


fun hideKeyboard() {
    val imm: InputMethodManager =
        APP_ACTIVITY.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(APP_ACTIVITY.window.decorView.windowToken, 0)
}

fun ImageView.downloadAndSetImage(url: String) {
    Picasso.get()
        .load(url)
        .fit()
        .placeholder(R.drawable.default_photo)
        .into(this)
}

fun initContacts() {
    if (checkPermission(Manifest.permission.READ_CONTACTS)) {
        val arrayContacts = arrayListOf<CommonModel>()
        val cursor = APP_ACTIVITY.contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            null,
            null,
            null,
            null
        )
        cursor?.let {
            while (it.moveToNext()) {
                val fullname =
                    it.getString(it.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
                val phone =
                    it.getString(it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
                val newModel = CommonModel()
                newModel.fullname = fullname
                newModel.phone = phone.replace(Regex("[\\s,-]"), "")
                arrayContacts.add(newModel)
            }
        }
        cursor?.close()
        updatePhonesToDatabase(arrayContacts)
    }
}


fun String.asTime(): String {
    val time = Date(this.toLong())
    val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
    return timeFormat.format(time)
}

