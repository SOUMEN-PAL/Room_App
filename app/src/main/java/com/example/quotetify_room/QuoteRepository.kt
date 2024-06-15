package com.example.quotetify_room

class QuoteRepository(val quoteDAO: QuoteDAO) {

    fun getQuotes() : List<Quote>{
        return quoteDAO.getQUotes()
    }


    suspend fun insertQuote(quote: Quote){
        quoteDAO.insertQuote(quote)
    }
}