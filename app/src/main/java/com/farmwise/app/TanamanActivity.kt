package com.farmwise.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.farmwise.app.ui.theme.FarmWiseTheme

class TanamanActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FarmWiseTheme {
                Scaffold(topBar = {
                    TopAppBar(title = { Text("Tanaman") }, navigationIcon = {
                        IconButton(onClick = { onBackPressedDispatcher.onBackPressed() }) {
                            Icon(
                                Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Kembali"
                            )
                        }
                    })
                }, content = { innerPadding ->
                    TanamanContent(
                        modifier = Modifier
                            .padding(innerPadding)
                            .verticalScroll(rememberScrollState())
                    )
                })
            }
        }
    }
}

@Composable
fun TanamanContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        PlantInfo("Padi", R.drawable.padi, getPadiSteps())
        Spacer(modifier = Modifier.height(16.dp))
        PlantInfo("Singkong", R.drawable.singkong, getSingkongSteps())
        Spacer(modifier = Modifier.height(16.dp))
        PlantInfo("Jagung", R.drawable.jagung, getJagungSteps())
        Spacer(modifier = Modifier.height(16.dp))
        PlantInfo("Pisang", R.drawable.pisang, getPisangSteps())
    }
}

@Composable
fun PlantInfo(title: String, imageResId: Int, steps: List<Pair<String, List<String>>>) {
    Column {
        Box(
            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(8.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = imageResId),
            contentDescription = "Gambar $title",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Berikut adalah langkah-langkah dasar untuk budi daya tanaman $title :")

        Spacer(modifier = Modifier.height(8.dp))

        steps.forEach { (step, details) ->
            TanamanStepText(step = step, details = details)
        }
    }
}

@Composable
fun TanamanStepText(step: String, details: List<String>, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(bottom = 16.dp)) {
        Text(text = step, style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(4.dp))
        details.forEach { detail ->
            Text(text = detail, style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}

fun getPadiSteps(): List<Pair<String, List<String>>> {
    return listOf(
        "Persiapan Lahan" to listOf(
            "Pengolahan Tanah: Cangkul atau bajak lahan untuk membalik dan melonggarkan tanah. Lakukan pencangkulan atau pembajakan sebanyak 2-3 kali.",
            "Pemupukan Dasar: Tambahkan pupuk organik atau pupuk kandang untuk meningkatkan kesuburan tanah."
        ), "Persemaian Benih" to listOf(
            "Pemilihan Benih: Pilih benih padi berkualitas tinggi dan bebas dari hama serta penyakit.",
            "Perendaman dan Pemeraman: Rendam benih dalam air selama 24-48 jam, kemudian peram dalam karung basah selama 48 jam hingga benih berkecambah.",
            "Penyemaian: Sebarkan benih yang telah berkecambah di bedengan persemaian yang telah dipersiapkan sebelumnya."
        ), "Penanaman" to listOf(
            "Penanaman Bibit: Setelah bibit berusia sekitar 20-25 hari, pindahkan bibit ke lahan tanam dengan jarak tanam sekitar 25x25 cm.",
            "Penanaman Jajar Legowo: Metode ini meningkatkan jumlah tanaman per satuan luas dan memberikan ruang lebih banyak untuk cahaya dan udara."
        ), "Pemeliharaan" to listOf(
            "Penyulaman: Ganti bibit yang tidak tumbuh dengan bibit baru untuk memastikan populasi tanaman tetap optimal.",
            "Penyiangan: Lakukan penyiangan gulma secara teratur untuk menghindari persaingan dengan tanaman padi.",
            "Pemupukan Susulan: Tambahkan pupuk tambahan sesuai tahap pertumbuhan tanaman, biasanya NPK."
        ), "Pengendalian Hama dan Penyakit" to listOf(
            "Pengamatan Rutin: Periksa tanaman secara rutin untuk mendeteksi adanya hama atau penyakit.",
            "Penggunaan Pestisida: Jika diperlukan, gunakan pestisida sesuai rekomendasi dan dosis yang tepat untuk mengendalikan hama dan penyakit."
        ), "Pemanenan" to listOf(
            "Waktu Pemanenan: Panen dilakukan saat 90-95% butir padi telah menguning, biasanya sekitar 30-35 hari setelah berbunga.",
            "Metode Pemanenan: Potong batang padi sekitar 15 cm dari pangkal dan kumpulkan dalam ikatan untuk dijemur atau dirontokkan."
        ), "Pasca Panen" to listOf(
            "Penjemuran: Jemur padi di bawah sinar matahari hingga kadar air turun menjadi sekitar 14%.",
            "Penggilingan: Proses penggilingan untuk memisahkan butir padi dari sekam."
        )
    )
}

fun getSingkongSteps(): List<Pair<String, List<String>>> {
    return listOf(
        "Persiapan Lahan" to listOf(
            "Pemilihan Lokasi: Pilih lahan dengan tanah yang subur, gembur, dan memiliki drainase yang baik. Singkong tumbuh baik pada tanah lempung berpasir dengan pH 5,5 - 7,5.",
            "Pengolahan Tanah: Cangkul atau bajak tanah sedalam 20-30 cm untuk menggemburkan tanah. Buat bedengan atau guludan untuk meningkatkan drainase, terutama di lahan yang mudah tergenang air.",
            "Pemupukan Dasar: Tambahkan pupuk kandang atau kompos sebanyak 10-20 ton per hektar untuk meningkatkan kesuburan tanah."
        ), "Pemilihan dan Persiapan Bibit" to listOf(
            "Pemilihan Bibit: Pilih batang singkong yang sehat dan bebas dari hama serta penyakit. Potong batang dengan panjang sekitar 20-30 cm dengan 5-7 ruas.",
            "Penyimpanan Bibit: Simpan bibit di tempat yang teduh selama beberapa hari sebelum penanaman untuk mengurangi kadar air dan mencegah pembusukan."
        ), "Penanaman" to listOf(
            "Waktu Penanaman: Tanam bibit pada awal musim hujan untuk memastikan ketersediaan air yang cukup.",
            "Jarak Tanam: Tanam bibit dengan jarak tanam sekitar 100 x 100 cm atau 80 x 120 cm tergantung varietas dan kondisi lahan.",
            "Penanaman Bibit: Tanam bibit secara tegak atau miring dengan kedalaman sekitar 5-10 cm, pastikan 2-3 ruas tertanam di dalam tanah."
        ), "Pemeliharaan" to listOf(
            "Penyulaman: Ganti bibit yang tidak tumbuh atau mati dengan bibit baru sekitar 2-3 minggu setelah penanaman.",
            "Penyiangan: Lakukan penyiangan secara teratur untuk menghilangkan gulma yang bersaing dengan tanaman singkong.",
            "Pembumbunan: Tambahkan tanah di sekitar pangkal batang singkong untuk memperkuat tanaman dan mencegah rebah.",
            "Pemupukan Susulan: Tambahkan pupuk NPK dengan dosis 200 kg Urea, 100 kg TSP, dan 100 kg KCl per hektar pada umur 1-2 bulan dan 4-5 bulan setelah tanam."
        ), "Pengendalian Hama dan Penyakit" to listOf(
            "Pengamatan Rutin: Lakukan pengamatan secara rutin untuk mendeteksi adanya hama dan penyakit.",
            "Pengendalian Hama: Gunakan pestisida organik atau kimia jika diperlukan sesuai dengan dosis yang dianjurkan.",
            "Pengendalian Penyakit: Pastikan sirkulasi udara yang baik dan hindari kelembaban yang berlebihan untuk mencegah serangan penyakit."
        ), "Pemanenan" to listOf(
            "Waktu Pemanenan: Singkong dapat dipanen setelah 8-12 bulan tergantung varietas dan kondisi pertumbuhan.",
            "Metode Pemanenan: Cabut tanaman dengan hati-hati untuk menghindari kerusakan umbi. Gunakan cangkul atau alat bantu lainnya jika diperlukan."
        ), "Pasca Panen" to listOf(
            "Pembersihan: Bersihkan umbi dari tanah dan kotoran.",
            "Pengolahan: Umbi singkong dapat diolah lebih lanjut atau disimpan untuk keperluan konsumsi maupun dijual."
        )
    )
}

fun getJagungSteps(): List<Pair<String, List<String>>> {
    return listOf(
        "Persiapan Lahan" to listOf(
            "Pemilihan Lokasi: Pilih lahan dengan tanah subur, gembur, dan memiliki drainase yang baik. Jagung tumbuh optimal pada tanah dengan pH 5,5 - 7,0.",
            "Pengolahan Tanah: Bajak atau cangkul tanah sedalam 20-30 cm untuk menggemburkannya. Buat bedengan atau guludan jika perlu untuk meningkatkan drainase.",
            "Pemupukan Dasar: Berikan pupuk kandang atau kompos sebanyak 10-20 ton per hektar untuk meningkatkan kesuburan tanah."
        ), "Pemilihan dan Persiapan Benih" to listOf(
            "Pemilihan Benih: Pilih benih jagung berkualitas tinggi yang bebas dari hama dan penyakit. Benih hibrida biasanya memberikan hasil yang lebih baik.",
            "Perendaman Benih: Rendam benih dalam air selama 12-24 jam sebelum ditanam untuk mempercepat proses perkecambahan."
        ), "Penanaman" to listOf(
            "Waktu Penanaman: Tanam jagung pada awal musim hujan atau saat ketersediaan air cukup.",
            "Jarak Tanam: Tanam benih dengan jarak 75 x 25 cm atau 70 x 20 cm. Setiap lubang tanam dapat diisi 1-2 benih.",
            "Penanaman Benih: Tanam benih pada kedalaman sekitar 3-5 cm, kemudian tutup dengan tanah."
        ), "Pemeliharaan" to listOf(
            "Penyulaman: Ganti benih yang tidak tumbuh atau mati dengan benih baru sekitar 1-2 minggu setelah penanaman.",
            "Penyiangan: Lakukan penyiangan secara rutin untuk menghilangkan gulma yang bersaing dengan tanaman jagung.",
            "Pembumbunan: Tambahkan tanah di sekitar pangkal batang jagung untuk memperkuat tanaman dan mencegah rebah.",
            "Pemupukan Susulan: Tambahkan pupuk NPK sesuai dosis anjuran pada tahap pertumbuhan vegetatif dan generatif."
        ), "Pengendalian Hama dan Penyakit" to listOf(
            "Pengamatan Rutin: Periksa tanaman secara rutin untuk mendeteksi adanya hama dan penyakit.",
            "Pengendalian Hama: Gunakan pestisida organik atau kimia jika diperlukan sesuai dengan dosis yang dianjurkan.",
            "Pengendalian Penyakit: Pastikan sirkulasi udara yang baik dan hindari kelembaban yang berlebihan untuk mencegah serangan penyakit."
        ), "Pemanenan" to listOf(
            "Waktu Pemanenan: Jagung biasanya siap dipanen setelah 3-4 bulan tergantung varietas dan kondisi pertumbuhan.",
            "Ciri-ciri Jagung Siap Panen: Rambut jagung berubah kecoklatan, biji jagung sudah keras, dan kulit jagung mengering.",
            "Metode Pemanenan: Petik tongkol jagung dengan hati-hati agar tidak merusak tanaman dan tongkol lainnya."
        ), "Pasca Panen" to listOf(
            "Pengeringan: Jemur jagung di bawah sinar matahari hingga kadar air turun sekitar 15-20% untuk mencegah pembusukan.",
            "Penyimpanan: Simpan jagung yang telah dikeringkan di tempat yang kering dan berventilasi baik."
        )
    )
}

fun getPisangSteps(): List<Pair<String, List<String>>> {
    return listOf(
        "Persiapan Lahan" to listOf(
            "Pemilihan Lokasi: Pilih lahan dengan tanah subur, gembur, dan memiliki drainase yang baik. Pisang tumbuh optimal pada tanah dengan pH 5,5 - 7,5 dan di daerah dengan curah hujan 1.500-2.500 mm per tahun.",
            "Pengolahan Tanah: Bajak atau cangkul tanah sedalam 30-40 cm untuk menggemburkannya. Bersihkan lahan dari gulma, batu, dan sisa tanaman lain.",
            "Pembuatan Lubang Tanam: Buat lubang tanam dengan ukuran 50x50x50 cm, dan biarkan lubang terbuka selama 1-2 minggu sebelum penanaman untuk mengurangi patogen."
        ), "Pemilihan dan Persiapan Bibit" to listOf(
            "Pemilihan Bibit: Gunakan bibit dari anakan pisang yang sehat, bebas dari hama dan penyakit. Pilih anakan yang berumur 4-6 bulan dengan tinggi sekitar 1-1,5 meter.",
            "Perendaman Bibit: Rendam bibit dalam larutan fungisida atau insektisida sesuai dosis anjuran selama 15-30 menit untuk mencegah infeksi."
        ), "Penanaman" to listOf(
            "Waktu Penanaman: Tanam pisang pada awal musim hujan atau ketika ketersediaan air cukup.",
            "Jarak Tanam: Tanam bibit dengan jarak tanam sekitar 3x3 meter atau 2,5x2,5 meter tergantung varietas dan kondisi lahan.",
            "Penanaman Bibit: Masukkan bibit ke dalam lubang tanam, kemudian tutup dengan tanah gembur sampai pangkal batang tertutup rapat. Padatkan tanah di sekitar bibit untuk mengurangi rongga udara."
        ), "Pemeliharaan" to listOf(
            "Penyiraman: Lakukan penyiraman secara rutin terutama pada musim kemarau untuk menjaga kelembaban tanah.",
            "Pemupukan: Tambahkan pupuk organik atau kompos setiap 2-3 bulan. Pada tahun pertama, berikan pupuk NPK dengan dosis 200 gram per tanaman setiap 3-4 bulan.",
            "Penyiangan: Lakukan penyiangan secara teratur untuk menghilangkan gulma yang bersaing dengan tanaman pisang.",
            "Pemangkasan: Pangkas daun-daun tua atau rusak untuk meningkatkan sirkulasi udara dan mengurangi serangan penyakit.",
            "Pemupukan Susulan: Berikan pupuk tambahan pada fase pertumbuhan vegetatif dan generatif sesuai kebutuhan."
        ), "Pengendalian Hama dan Penyakit" to listOf(
            "Pengamatan Rutin: Periksa tanaman secara rutin untuk mendeteksi adanya hama dan penyakit.",
            "Pengendalian Hama: Gunakan pestisida organik atau kimia jika diperlukan sesuai dengan dosis yang dianjurkan.",
            "Pengendalian Penyakit: Gunakan fungisida dan insektisida sesuai kebutuhan dan pastikan sirkulasi udara yang baik di sekitar tanaman."
        ), "Pemanenan" to listOf(
            "Waktu Pemanenan: Pisang biasanya siap dipanen setelah 9-12 bulan tergantung varietas dan kondisi pertumbuhan.",
            "Ciri-ciri Pisang Siap Panen: Buah telah mencapai ukuran maksimal, kulit buah mulai menguning, dan jantung pisang telah berhenti tumbuh.",
            "Metode Pemanenan: Potong tandan pisang dengan hati-hati menggunakan pisau tajam untuk menghindari kerusakan buah dan tanaman."
        ), "Pasca Panen" to listOf(
            "Pembersihan: Bersihkan buah pisang dari kotoran dan sisa tanaman.",
            "Penyimpanan: Simpan pisang di tempat yang kering dan berventilasi baik untuk mencegah pembusukan."
        )
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FarmWiseTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            TanamanContent(
                modifier = Modifier
                    .padding(innerPadding)
                    .verticalScroll(rememberScrollState())
            )
        }
    }
}
