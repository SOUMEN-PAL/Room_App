package com.example.quotetify_room

import android.content.Context
import androidx.compose.runtime.LaunchedEffect
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Database(entities = [Quote::class] , version = 1)
abstract class QuoteDatabase : RoomDatabase() {
    abstract fun quoteDao() : QuoteDAO

    companion object{
        @Volatile
        private var INSTANCE : QuoteDatabase? = null

        fun getDatabase(context: Context): QuoteDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    QuoteDatabase::class.java,
                    "quote_database"
                ).createFromAsset("quotes.db").build()
                INSTANCE = instance
                instance
            }
        }
    }
}