package com.example.pam4_modul

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pam4_modul.ui.theme.PAM4_ModulTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PAM4_ModulTheme {
                var number by rememberSaveable { mutableStateOf(1) }

                val snackbarHostState = remember { SnackbarHostState() }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    snackbarHost = {
                        SnackbarHost(hostState = snackbarHostState)
                    }
                ) { innerPadding ->

                    CounterScreen(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(32.dp),
                        number = number,
                        label = "Double",
                        onButtonClick = { number *= 2 }
                    )

                    LaunchedEffect(number) {
                        snackbarHostState.showSnackbar(
                            "Number $number is shown!"
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CounterScreen(
    modifier: Modifier,
    number: Int,
    label: String,
    onButtonClick: () -> Unit
) {
    Column(modifier) {
        Text(text = "$number", fontSize = 72.sp)

        Button(onClick = onButtonClick) {
            Text(text = label)
        }
    }
}

