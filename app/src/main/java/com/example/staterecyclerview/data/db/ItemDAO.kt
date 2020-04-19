package com.example.staterecyclerview.data.db

import androidx.room.*
import com.example.staterecyclerview.data.Item

@Dao
interface ItemDAO {

    @Query("SELECT*FROM item")
    fun getItemsList(): List<Item>

    @Update
    fun updateItem(item: Item)

    @Insert
    fun insertAll(vararg items: Item)

    @Insert
    fun insertItem(item: Item)

    @Delete
    fun deleteItem(item: Item)
}