package com.ph00.contactsviewer.presentation.models

data class Contact(
    var id: Int,
    var name: String? = null,
    var email: String? = null,
    var phone: String? = null,
    var imgUri: String? = null
)