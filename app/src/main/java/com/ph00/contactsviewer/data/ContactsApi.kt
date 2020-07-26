package com.ph00.contactsviewer.data

import android.content.ContentResolver
import android.provider.ContactsContract
import com.ph00.contactsviewer.data.utils.*
import com.ph00.contactsviewer.presentation.models.Contact
import com.ph00.contactsviewer.presentation.models.ContactPreview

class ContactsApi(private val contentResolver: ContentResolver) {

    fun getContactPreview(): List<ContactPreview> {
        val contactList = mutableListOf<ContactPreview>()
        val uri = ContactsContract.Contacts.CONTENT_URI
        val projection = arrayOf(
            ContactsContract.Contacts._ID,
            ContactsContract.Contacts.DISPLAY_NAME,
            ContactsContract.Contacts.Photo.PHOTO_URI
        )
        val orderBy = ContactsContract.Contacts.DISPLAY_NAME + " ASC"

        val cursor = contentResolver.query(uri, projection, null, null, orderBy)

        if (cursor != null && cursor.count > 0) {
            while (cursor.moveToNext()) {
                val id =
                    cursor.getIntValue(ContactsContract.Contacts._ID)

                val name =
                    cursor.getStringValue(ContactsContract.Contacts.DISPLAY_NAME)

                val imgUri =
                    cursor.getStringValue(ContactsContract.Contacts.Photo.PHOTO_URI)

                contactList.add(ContactPreview(id, name, imgUri))
            }
        } else {
            return emptyList()
        }
        cursor.close()
        return contactList
    }

    fun getContactDetails(contactId: Int): Contact {
        getUserMainDataById(contactId, contentResolver).let { contactPreview ->
            val name = contactPreview?.name

            val imgUri = contactPreview?.imageUri

            val email =
                getEmailByContactId(contactId, contentResolver)

            val phone = getPhoneByContactId(contactId, contentResolver)

            return Contact(contactId, name, email, phone, imgUri)
        }
    }
}