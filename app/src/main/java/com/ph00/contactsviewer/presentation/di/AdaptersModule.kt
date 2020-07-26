package com.ph00.contactsviewer.presentation.di

import com.ph00.contactsviewer.presentation.ui.global.adapters.ContactPreviewAdapter
import org.koin.dsl.module

val adaptersModule = module {
    factory { ContactPreviewAdapter(get()) }
}