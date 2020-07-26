package com.ph00.contactsviewer.domain.usecases

import com.ph00.contactsviewer.domain.repository.ContactsRepository

class GetContactListUseCase(private val repository: ContactsRepository) {

    fun execute() = repository.getContactList()

}