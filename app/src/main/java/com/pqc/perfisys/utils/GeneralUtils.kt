package com.example.newbasicstructure.util.extensionFunction

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.content.res.Resources
import android.graphics.Color
import android.os.Build
import android.util.TypedValue
import android.view.View
import android.view.Window
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.annotation.IdRes
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.MutableLiveData

/**
 * Created by Jeetesh surana.
 */

/**
 * Add replace fragment
 *
 * @param container
 * @param fragment
 * @param addFragment
 * @param addToBackStack
 */
fun FragmentActivity.addReplaceFragment(
    @IdRes container: Int,
    fragment: Fragment,
    addFragment: Boolean,
    addToBackStack: Boolean
) {
    val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
    if (addFragment) {
        transaction.add(
            container,
            fragment,
            fragment.javaClass.simpleName
        )
    } else {
        transaction.replace(
            container,
            fragment,
            fragment.javaClass.simpleName
        )
    }
    if (addToBackStack) {
        transaction.addToBackStack(fragment.tag)
    }
    hideKeyboard()
    if (!supportFragmentManager.isDestroyed) {
        transaction.commit()
    }
}

/**
 * Add replace fragment
 *
 * @param container
 * @param fragment
 * @param addFragment
 * @param addToBackStack
 */
fun FragmentActivity.addReplaceFragmentWithSharedElement(
    @IdRes container: Int,
    fragment: Fragment,
    addFragment: Boolean,
    addToBackStack: Boolean,
    sharedView: View? = null,
    sharedName: String? = null
) {
    val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
    if (addFragment) {
        transaction.add(
            container,
            fragment,
            fragment.javaClass.simpleName
        )
    } else {
        transaction.replace(
            container,
            fragment,
            fragment.javaClass.simpleName
        )
    }
    if (addToBackStack) {
        transaction.addToBackStack(fragment.tag)
    }

    if (sharedView != null && !sharedName.isNullOrEmpty()) {
        transaction.setReorderingAllowed(true)
        transaction.addSharedElement(sharedView, sharedName)
    }
    hideKeyboard()
    if (!supportFragmentManager.isDestroyed) {
        transaction.commit()
    }
}

/**
 * Add replace fragment
 *
 * @param container
 * @param fragment
 * @param addFragment
 * @param addToBackStack
 */
fun FragmentActivity.addReplaceFragmentWithAnimation(
    @IdRes container: Int,
    fragment: Fragment,
    addFragment: Boolean,
    addToBackStack: Boolean,
    enterAnimation: Int,
    exitAnimation: Int
) {
    val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
    transaction.setCustomAnimations(
        enterAnimation,
        exitAnimation
    )
    if (addFragment) {
        transaction.add(
            container,
            fragment,
            fragment.javaClass.simpleName
        )
    } else {
        transaction.replace(
            container,
            fragment,
            fragment.javaClass.simpleName
        )
    }
    if (addToBackStack) {
        transaction.addToBackStack(fragment.tag)
    }
    hideKeyboard()
    if (!supportFragmentManager.isDestroyed) {
        transaction.commit()
    }
}


//hide the keyboard
fun Activity.hideKeyboard() {
    val imm: InputMethodManager =
        getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    var view = currentFocus
    if (view == null) view = View(this)
    imm.hideSoftInputFromWindow(
        view.windowToken,
        0
    )
}



fun Fragment.gotoBack() {
    activity?.supportFragmentManager?.popBackStack()
}


fun <T> mutableLiveData(defaultValue: T? = null): MutableLiveData<T> {
    val data = MutableLiveData<T>()
    defaultValue?.let { data.value = it }
    return data
}
