package com.example.staterecyclerview.utils

import java.text.SimpleDateFormat
import java.util.*

object DateUtil {

    var calendar: Calendar = Calendar.getInstance()

    fun getCurrentDay(): String? =
        calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault())

    fun getDate(): String? {
        val dateFormat = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())
        return dateFormat.format(calendar.time)
    }

}