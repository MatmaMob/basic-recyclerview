package com.example.staterecyclerview.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.staterecyclerview.Constants

@Entity
data class Item(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = Constants.COLUMN_TITLE) val title: String,
    @ColumnInfo(name = Constants.COLUMN_DESCRIPTION) val description: String,
    @ColumnInfo(name = Constants.COLUMN_PRIORITY) val priority: String
)