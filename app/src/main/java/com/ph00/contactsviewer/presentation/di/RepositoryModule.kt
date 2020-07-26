package com.ph00.contactsviewer.presentation.di

import com.ph00.contactsviewer.data.ContactsRepositoryImpl
import com.ph00.contactsviewer.domain.repository.ContactsRepository
import org.koin.dsl.module

val repositoryModule = module {

    single<ContactsRepository> { ContactsRepositoryImpl(get()) }

}