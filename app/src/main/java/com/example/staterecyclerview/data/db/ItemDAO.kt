package com.example.staterecyclerview.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.staterecyclerview.data.Item

@Dao
interface ItemDAO {

    @Query("SELECT*FROM item")
    fun getItemsList(): List<Item>

    @Insert
    fun insertAll(vararg items: Item)

    @Insert
    fun insertItem(item: Item)

    @Delete
    fun deleteItem(item: Item)
}