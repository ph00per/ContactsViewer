package com.ph00.contactsviewer.presentation.di

import com.ph00.contactsviewer.presentation.presenters.contact_details.ContactDetailsPresenter
import com.ph00.contactsviewer.presentation.presenters.contact_list.ContactListPresenter
import org.koin.dsl.module

val presenterModule = module {
    factory {
        ContactListPresenter(get(), get())
    }
    factory { (contactId: Int) ->
        ContactDetailsPresenter(contactId, get(), get())
    }
}