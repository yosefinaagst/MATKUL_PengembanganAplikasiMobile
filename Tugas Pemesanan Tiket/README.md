# 🎟️ Aplikasi Pemesanan Tiket

Aplikasi ini dibuat menggunakan **Kotlin** dan **Jetpack Compose** sebagai bagian dari tugas praktikum Pemrograman Aplikasi Perangkat Bergerak.

### 📄 Jawaban Praktikum
Keseluruhan jawaban modul dapat dilihat pada file berikut:
[📄 Jawaban Praktikum](Jawaban-Praktikum.pdf)

## Pengimpelemntasian Harga Tiket

Harga satu tiket ditetapkan sebesar: 
**Rp25.000 / tiket**

Total pembayaran dihitung berdasarkan:

```text
Total Bayar = Harga Tiket × Jumlah Tiket
```

Contoh:

```text
1 tiket = Rp25.000
2 tiket = Rp50.000
3 tiket = Rp75.000
```

## 🛠️ Teknologi yang Digunakan

- Kotlin
- Android Studio
- Jetpack Compose
- Material 3
- 
## 🧠 Implementasi State
Jumlah tiket disimpan menggunakan state Jetpack Compose:

```kotlin
var jumlahTiket by remember {
    mutableStateOf(1)
}
```

Ketika tombol `+` atau `-` ditekan, nilai `jumlahTiket` akan berubah dan Jetpack Compose melakukan **recomposition**, sehingga jumlah tiket dan total pembayaran pada UI ikut diperbarui.

Total pembayaran dihitung menggunakan:

```kotlin
val totalBayar = hargaTiket * jumlahTiket
```