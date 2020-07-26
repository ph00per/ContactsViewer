package com.ph00.contactsviewer.data.utils

import android.content.ContentResolver
import android.provider.ContactsContract
import com.ph00.contactsviewer.presentation.models.ContactPreview


fun getPhoneByContactId(contactId: Int, contentResolver: ContentResolver): String? {
    return try {
        val uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI
        val projection = arrayOf(ContactsContract.CommonDataKinds.Phone.NUMBER)
        val selection = ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?"
        val selectionArgs = arrayOf(contactId.toString())

        val cursor = contentResolver.query(uri, projection, selection, selectionArgs, null)

        cursor?.moveToFirst()

        cursor?.getStringValue(ContactsContract.CommonDataKinds.Phone.NUMBER)
            .also { cursor?.close() }

    } catch (e: Exception) {
        null
    }
}

fun getEmailByContactId(contactId: Int, contentResolver: ContentResolver): String? {
    return try {
        val uri = ContactsContract.CommonDataKinds.Email.CONTENT_URI
        val projection = arrayOf(ContactsContract.CommonDataKinds.Email.DATA)
        val selection = ContactsContract.CommonDataKinds.Email.CONTACT_ID + " = ?"
        val selectionArgs = arrayOf(contactId.toString())

        val cursor =
            contentResolver.query(uri, projection, selection, selectionArgs, null)

        cursor?.moveToFirst()

        cursor?.getStringValue(ContactsContract.CommonDataKinds.Email.DATA).also { cursor?.close() }
    } catch (e: Exception) {
        null
    }
}

fun getUserMainDataById(contactId: Int, contentResolver: ContentResolver): ContactPreview? {
    return try {
        val uri = ContactsContract.Contacts.CONTENT_URI
        val projection = arrayOf(
            ContactsContract.Contacts.DISPLAY_NAME,
            ContactsContract.Contacts.Photo.PHOTO_URI
        )
        val selection = ContactsContract.Contacts._ID + " = ?"
        val selectionArgs = arrayOf(contactId.toString())

        val cursor =
            contentResolver.query(uri, projection, selection, selectionArgs, null)

        cursor?.moveToFirst()

        val name =
            cursor?.getStringValue(ContactsContract.Contacts.DISPLAY_NAME)

        val imgUri =
            cursor?.getStringValue(ContactsContract.Contacts.Photo.PHOTO_URI)

        ContactPreview(contactId, name, imgUri).also { cursor?.close() }

    } catch (e: Exception) {
        null
    }

}