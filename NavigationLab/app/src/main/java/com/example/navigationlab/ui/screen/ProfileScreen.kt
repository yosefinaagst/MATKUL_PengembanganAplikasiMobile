package com.example.navigationlab.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ProfileScreen(
    onBack: () -> Unit
) {
    Column() {
        Text("Profile Mahasiswa")

        Text("Navigation Compose Lab")

        Button(onClick = onBack) {
            Text("Kembali")
        }
    }
}