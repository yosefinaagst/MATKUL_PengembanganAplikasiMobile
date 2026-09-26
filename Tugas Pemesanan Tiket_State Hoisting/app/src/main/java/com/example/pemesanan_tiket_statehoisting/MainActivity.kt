package com.example.pemesanan_tiket_statehoisting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import java.text.NumberFormat
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme(
                colorScheme = lightColorScheme(
                    primary = Color(0xFF3E5CBD)
                )
            ) {
                TiketParent()
            }
        }
    }
}

@Composable
fun TiketParent() {
    val hargaTiket by rememberSaveable {
        mutableStateOf(50000L)
    }

    var jumlahTiket by rememberSaveable {
        mutableStateOf(1)
    }

    var namaPembeli by rememberSaveable {
        mutableStateOf("")
    }

    var status by rememberSaveable {
        mutableStateOf("Silakan pesan tiket")
    }

    var sedangMemproses by rememberSaveable {
        mutableStateOf(false)
    }

    var permintaanPesan by rememberSaveable {
        mutableStateOf(false)
    }

    var namaError by rememberSaveable {
        mutableStateOf(false)
    }

    // Menyimpan waktu selesai agar rotasi tidak mengulang
    // waktu tunggu dari awal.
    var waktuSelesai by rememberSaveable {
        mutableStateOf(0L)
    }

    LaunchedEffect(permintaanPesan) {
        if (permintaanPesan) {
            if (namaPembeli.isBlank()) {
                namaError = true
                status = "Nama Masih Kosong"
            } else {
                namaError = false
                sedangMemproses = true
                status = "Memproses pesanan..."

                if (waktuSelesai == 0L) {
                    waktuSelesai = System.currentTimeMillis() + 5000L
                }

                val sisaWaktu =
                    (waktuSelesai - System.currentTimeMillis())
                        .coerceAtLeast(0L)

                delay(sisaWaktu)

                status = "Tiket telah dipesan"
                sedangMemproses = false
                waktuSelesai = 0L
            }

            permintaanPesan = false
        }
    }

    TiketContent(
        hargaTiket = hargaTiket,
        jumlahTiket = jumlahTiket,
        namaPembeli = namaPembeli,
        status = status,
        namaError = namaError,
        sedangMemproses = sedangMemproses,
        inputAktif = !permintaanPesan && !sedangMemproses,

        onNamaChange = {
            namaPembeli = it
            namaError = false
            status = "Silakan pesan tiket"
        },

        onTambah = {
            jumlahTiket++
            status = "Silakan pesan tiket"
        },

        onKurang = {
            if (jumlahTiket > 1) {
                jumlahTiket--
                status = "Silakan pesan tiket"
            }
        },

        onPesan = {
            permintaanPesan = true
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TiketContent(
    hargaTiket: Long,
    jumlahTiket: Int,
    namaPembeli: String,
    status: String,
    namaError: Boolean,
    sedangMemproses: Boolean,
    inputAktif: Boolean,
    onNamaChange: (String) -> Unit,
    onTambah: () -> Unit,
    onKurang: () -> Unit,
    onPesan: () -> Unit
) {
    val totalHarga = hargaTiket * jumlahTiket

    val warnaStatus = when {
        namaError -> Color(0xFFFFEBEE)
        sedangMemproses -> Color(0xFFE8EFFF)
        status == "Tiket telah dipesan" -> Color(0xFFE8F5E9)
        else -> Color(0xFFF1F3F8)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Pemesanan Tiket") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .imePadding()
                .verticalScroll(rememberScrollState())
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Text(
                text = "Isi Data Pemesanan",
                style = MaterialTheme.typography.titleLarge
            )

            OutlinedTextField(
                value = namaPembeli,
                onValueChange = onNamaChange,
                label = { Text("Nama Pembeli") },
                placeholder = { Text("Masukkan nama Anda") },
                singleLine = true,
                enabled = inputAktif,
                isError = namaError,
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                text = "Harga Tiket: ${formatRupiah(hargaTiket)}",
                style = MaterialTheme.typography.titleMedium
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Jumlah Tiket",
                    style = MaterialTheme.typography.titleMedium
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    FilledTonalButton(
                        onClick = onKurang,
                        enabled = inputAktif && jumlahTiket > 1
                    ) {
                        Text("−")
                    }

                    Text(
                        text = jumlahTiket.toString(),
                        style = MaterialTheme.typography.headlineSmall
                    )

                    FilledTonalButton(
                        onClick = onTambah,
                        enabled = inputAktif
                    ) {
                        Text("+")
                    }
                }
            }

            HorizontalDivider()

            Text(
                text = "Total: ${formatRupiah(totalHarga)}",
                style = MaterialTheme.typography.titleLarge
            )

            Button(
                onClick = onPesan,
                enabled = inputAktif,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(
                    if (sedangMemproses) "Memproses..."
                    else "Pesan Tiket"
                )
            }

            Surface(
                color = warnaStatus,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    if (sedangMemproses) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(20.dp),
                            strokeWidth = 2.dp
                        )
                    }

                    Text(text = "Status: $status")
                }
            }
        }
    }
}

fun formatRupiah(nilai: Long): String {
    return NumberFormat.getCurrencyInstance(
        Locale("id", "ID")
    ).apply {
        maximumFractionDigits = 0
    }.format(nilai)
}