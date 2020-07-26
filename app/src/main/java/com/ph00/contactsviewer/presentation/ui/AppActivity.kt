package com.ph00.contactsviewer.presentation.ui

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.ph00.contactsviewer.R
import com.ph00.contactsviewer.presentation.ui.global.BaseFragment
import com.ph00.contactsviewer.presentation.ui.utils.Constants.Companion.REQUEST_CODE
import com.ph00.contactsviewer.presentation.ui.utils.Screens
import com.ph00.contactsviewer.presentation.ui.utils.setLaunchScreen
import moxy.MvpAppCompatActivity
import org.koin.android.ext.android.inject
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator


class AppActivity : MvpAppCompatActivity() {

    private val navigatorHolder: NavigatorHolder by inject()

    private val currentFragment: BaseFragment?
        get() = supportFragmentManager.findFragmentById(R.id.main_container) as? BaseFragment

    private val navigator: Navigator =
        SupportAppNavigator(this, supportFragmentManager, R.id.main_container)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkPermissions()
    }

    override fun onBackPressed() {
        currentFragment?.onBackPressed() ?: super.onBackPressed()
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            navigator.setLaunchScreen(Screens.ContactsList)
        }
    }

    private fun checkPermissions() {
        if (
            ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_CONTACTS)
            != PackageManager.PERMISSION_GRANTED
        )
            requireReadContactsPermission()
        else
            navigator.setLaunchScreen(Screens.ContactsList)
    }

    private fun requireReadContactsPermission() {
        requestPermissions(
            arrayOf(android.Manifest.permission.READ_CONTACTS),
            REQUEST_CODE
        )
    }
}