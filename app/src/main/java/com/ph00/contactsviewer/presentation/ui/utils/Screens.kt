package com.ph00.contactsviewer.presentation.ui.utils

import com.ph00.contactsviewer.presentation.ui.contact_details.ContactDetailsFragment
import com.ph00.contactsviewer.presentation.ui.contact_list.ContactListFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {

    object ContactsList : SupportAppScreen() {
        override fun getFragment() =
            ContactListFragment()
    }

    data class ContactDetails(val contactId: Int) : SupportAppScreen() {
        override fun getFragment() =
            ContactDetailsFragment.create(contactId)
    }

}