package com.ph00.contactsviewer.presentation.di

import com.ph00.contactsviewer.domain.usecases.GetContactDetailsUseCase
import com.ph00.contactsviewer.domain.usecases.GetContactListUseCase
import org.koin.dsl.module

val useCaseModule = module {

    single { GetContactListUseCase(get()) }
    single { GetContactDetailsUseCase(get()) }

}