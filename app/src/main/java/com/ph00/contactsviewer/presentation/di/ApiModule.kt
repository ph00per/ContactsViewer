package com.ph00.contactsviewer.presentation.di

import com.ph00.contactsviewer.data.ContactsApi
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val apiModule = module {
    single { androidContext().contentResolver }
    single { ContactsApi(get()) }
}