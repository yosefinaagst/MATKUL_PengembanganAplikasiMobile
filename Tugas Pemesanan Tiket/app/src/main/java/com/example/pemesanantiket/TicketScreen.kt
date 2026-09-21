package com.example.ticketapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.NumberFormat
import java.util.Locale

@Composable
fun TicketScreen() {

    val hargaTiket = 25000

    var jumlahTiket by remember {
        mutableStateOf(1)
    }

    val totalBayar = hargaTiket * jumlahTiket

    val formatRupiah = NumberFormat.getNumberInstance(
        Locale("id", "ID")
    )

    val blue = Color(0xFF4F86F7)
    val green = Color(0xFF34834A)
    val red = Color(0xFFE34F43)
    val darkText = Color(0xFF17213A)
    val lightBackground = Color(0xFFF5F7FA)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(blue)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 55.dp,
                    bottom = 30.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "🎟",
                fontSize = 42.sp
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            Text(
                text = "Pemesanan Tiket",
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            Text(
                text = "Pesan tiket dengan mudah!",
                color = Color.White.copy(alpha = 0.8f),
                fontSize = 16.sp
            )
        }


        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = lightBackground,
                    shape = RoundedCornerShape(
                        topStart = 28.dp,
                        topEnd = 28.dp
                    )
                )
                .padding(18.dp)
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {

                Column(
                    modifier = Modifier.padding(18.dp)
                ) {

                    Text(
                        text = "Harga Tiket",
                        color = darkText,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier = Modifier.height(6.dp)
                    )

                    Text(
                        text = "Rp${formatRupiah.format(hargaTiket)}",
                        color = blue,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "per tiket",
                        color = Color.Gray,
                        fontSize = 15.sp
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Column(
                    modifier = Modifier.padding(18.dp)
                ) {
                    Text(
                        text = "Jumlah Tiket",
                        color = darkText,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier = Modifier.height(15.dp)
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Button(
                            onClick = {
                                if (jumlahTiket > 1) {
                                    jumlahTiket--
                                }
                            },
                            modifier = Modifier.size(58.dp),
                            shape = CircleShape,
                            contentPadding = PaddingValues(0.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = blue
                            )
                        ) {
                            Text(
                                text = "−",
                                color = Color.White,
                                fontSize = 30.sp
                            )
                        }

                        Box(
                            modifier = Modifier
                                .width(120.dp)
                                .height(60.dp)
                                .background(
                                    color = Color(0xFFF0F2F5),
                                    shape = RoundedCornerShape(15.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {

                            Text(
                                text = "$jumlahTiket",
                                color = darkText,
                                fontSize = 32.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Button(
                            onClick = {
                                jumlahTiket++
                            },
                            modifier = Modifier.size(58.dp),
                            shape = CircleShape,
                            contentPadding = PaddingValues(0.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = blue
                            )
                        ) {
                            Text(
                                text = "+",
                                color = Color.White,
                                fontSize = 30.sp
                            )
                        }
                    }
                }
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {

                Column(
                    modifier = Modifier.padding(18.dp)
                ) {

                    Text(
                        text = "Total",
                        color = darkText,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier = Modifier.height(6.dp)
                    )

                    Text(
                        text = "Rp${formatRupiah.format(totalBayar)}",
                        color = green,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Button(
                onClick = {
                    jumlahTiket = 1
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(58.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = red
                )
            ) {

                Text(
                    text = "↻  RESET",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}