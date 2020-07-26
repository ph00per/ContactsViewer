package com.ph00.contactsviewer.data

import com.ph00.contactsviewer.domain.repository.ContactsRepository
import com.ph00.contactsviewer.presentation.models.Contact
import com.ph00.contactsviewer.presentation.models.ContactPreview
import io.reactivex.rxjava3.core.Single

class ContactsRepositoryImpl(private val contactsApi: ContactsApi) :
    ContactsRepository {

    override fun getContactList(): Single<List<ContactPreview>> =
        Single.just(contactsApi.getContactPreview())

    override fun getContactDetails(contactId: Int): Single<Contact> =
        Single.just(contactsApi.getContactDetails(contactId))

}
