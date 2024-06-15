package com.example.quotetify_room

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class MainViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {
    fun getQuotes(): List<Quote> = runBlocking { // Use runBlocking for simplicity here
        withContext(Dispatchers.IO) {
            quoteRepository.quoteDAO.getQUotes() // Assuming you have a getAllQuotes() function in your DAO
        }
    }

    fun insertQuote(quote: Quote){
        viewModelScope.launch(Dispatchers.IO) {
            quoteRepository.insertQuote(quote)
        }

    }

}