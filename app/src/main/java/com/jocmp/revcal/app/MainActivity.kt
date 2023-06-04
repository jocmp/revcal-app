package com.jocmp.revcal.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jocmp.revcal.app.ui.theme.RevCalTheme
import com.jocmp.revcal.lib.RevDate
import java.time.LocalDate

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RevCalTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Today()
                }
            }
        }
    }
}

@Composable
fun Today() {
    Text(text = "${RevDate.fromGregorian(LocalDate.now())}")
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RevCalTheme {
        Today()
    }
}
