package com.ph00.contactsviewer.presentation.di

import com.squareup.picasso.Picasso
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val networkModule = module {

    single { Picasso.Builder(androidContext()).build() }

}