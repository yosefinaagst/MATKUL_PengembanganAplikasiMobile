package com.example.pemesanantiket

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TicketScreen() {

    val hargaTiket = 25000

    var jumlahTiket by remember {
        mutableStateOf(1)
    }

    val totalBayar = hargaTiket * jumlahTiket

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Pemesanan Tiket",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text("Harga Tiket")
        Text(
            text = "Rp$hargaTiket",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text("Jumlah Tiket")

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            Button(
                onClick = {
                    if (jumlahTiket > 1) {
                        jumlahTiket--
                    }
                }
            ) {
                Text("-")
            }

            Text(
                text = "$jumlahTiket",
                style = MaterialTheme.typography.headlineMedium
            )

            Button(
                onClick = {
                    jumlahTiket++
                }
            ) {
                Text("+")
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text("Total Bayar")

        Text(
            text = "Rp$totalBayar",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                jumlahTiket = 1
            }
        ) {
            Text("Reset")
        }
    }
}