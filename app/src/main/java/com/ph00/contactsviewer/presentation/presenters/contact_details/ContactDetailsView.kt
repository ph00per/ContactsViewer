package com.ph00.contactsviewer.presentation.presenters.contact_details

import com.ph00.contactsviewer.presentation.models.Contact
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface ContactDetailsView : MvpView {

    @AddToEndSingle
    fun setContact(contact : Contact)

}