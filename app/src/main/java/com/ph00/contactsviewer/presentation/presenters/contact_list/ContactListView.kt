package com.ph00.contactsviewer.presentation.presenters.contact_list

import com.ph00.contactsviewer.presentation.models.ContactPreview
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface ContactListView : MvpView {

    @AddToEndSingle
    fun setContacts(list: List<ContactPreview>)

}