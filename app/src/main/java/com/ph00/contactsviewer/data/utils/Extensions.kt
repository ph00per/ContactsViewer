package com.ph00.contactsviewer.data.utils

import android.database.Cursor

fun Cursor.getStringValue(key: String) = getString(getColumnIndex(key))

fun Cursor.getIntValue(key: String) = getInt(getColumnIndex(key))