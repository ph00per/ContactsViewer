package com.ph00.contactsviewer.domain.repository

import android.util.SparseArray
import com.ph00.contactsviewer.presentation.models.Contact
import com.ph00.contactsviewer.presentation.models.ContactPreview
import io.reactivex.rxjava3.core.Single

interface ContactsRepository {

    fun getContactList(): Single<List<ContactPreview>>
    fun getContactDetails(contactId : Int): Single<Contact>
}