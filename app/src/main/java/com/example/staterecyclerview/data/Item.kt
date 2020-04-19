package com.example.staterecyclerview.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.staterecyclerview.Constants

@Entity
data class Item(
    @ColumnInfo(name = Constants.COLUMN_TITLE) var title: String,
    @ColumnInfo(name = Constants.COLUMN_DESCRIPTION) var description: String,
    @ColumnInfo(name = Constants.COLUMN_PRIORITY) var priority: String,
    @ColumnInfo(name = Constants.COLUMN_DONE) var isDone: Boolean = false
) {
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
}