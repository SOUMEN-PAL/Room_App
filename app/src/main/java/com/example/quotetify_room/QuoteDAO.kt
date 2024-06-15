package com.example.quotetify_room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface QuoteDAO {

    @Query("SELECT * FROM quote")
    fun getQUotes() : List<Quote>

    @Insert
    suspend fun insertQuote(quote: Quote)
}