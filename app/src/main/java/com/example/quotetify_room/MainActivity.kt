package com.example.quotetify_room

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quotetify_room.ui.theme.Quotetify_roomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val dao = QuoteDatabase.getDatabase(applicationContext).quoteDao()

            val repository = QuoteRepository(dao)

            val mainViewModel : MainViewModel = viewModel(factory = MainViewModelFactory(repository))

            Quotetify_roomTheme {
                Column(modifier = Modifier.fillMaxSize().padding(top = 20.dp)) {
                    HomeScreen(viewModel = mainViewModel)
                }
            }
        }
    }
}
