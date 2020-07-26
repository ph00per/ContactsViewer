package com.ph00.contactsviewer.domain.usecases

import com.ph00.contactsviewer.domain.repository.ContactsRepository

class GetContactDetailsUseCase(private val repository: ContactsRepository) {

    fun execute(contactId: Int) = repository.getContactDetails(contactId)

}