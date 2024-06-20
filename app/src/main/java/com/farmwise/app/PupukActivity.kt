package com.farmwise.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.farmwise.app.ui.theme.FarmWiseTheme

class PupukActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FarmWiseTheme {
                Scaffold(topBar = {
                    TopAppBar(title = { Text("Pupuk") }, navigationIcon = {
                        IconButton(onClick = { onBackPressedDispatcher.onBackPressed() }) {
                            Icon(
                                Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Kembali"
                            )
                        }
                    })
                }, content = { innerPadding ->
                    PupukContent(
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
fun PupukContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.pupuk),
            contentDescription = "Gambar Pupuk",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Panduan Pemupukan", style = MaterialTheme.typography.headlineLarge)

        Spacer(modifier = Modifier.height(16.dp))

        PupukInfo(
            title = "Pemupukan Padi", steps = listOf(
                "Tahap Persiapan Lahan" to listOf(
                    "Pupuk Organik: Tambahkan 2-3 ton pupuk kandang atau kompos per hektar saat pengolahan tanah.",
                    "Pupuk Dasar: Berikan pupuk NPK dengan dosis 100 kg Urea, 50 kg SP-36, dan 50 kg KCl per hektar."
                ), "Tahap Pertumbuhan" to listOf(
                    "Pemupukan Susulan Pertama: 21 hari setelah tanam (HST), tambahkan 100 kg Urea per hektar.",
                    "Pemupukan Susulan Kedua: 42 HST, tambahkan 100 kg Urea dan 50 kg KCl per hektar."
                )
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        PupukInfo(
            title = "Pemupukan Singkong", steps = listOf(
                "Tahap Persiapan Lahan" to listOf(
                    "Pupuk Organik: Berikan 10-20 ton pupuk kandang atau kompos per hektar saat pengolahan tanah."
                ), "Tahap Pertumbuhan" to listOf(
                    "Pemupukan Susulan Pertama: 1-2 bulan setelah tanam, berikan 200 kg Urea, 100 kg TSP, dan 100 kg KCl per hektar.",
                    "Pemupukan Susulan Kedua: 4-5 bulan setelah tanam, berikan 200 kg Urea dan 100 kg KCl per hektar."
                )
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        PupukInfo(
            title = "Pemupukan Jagung", steps = listOf(
                "Tahap Persiapan Lahan" to listOf(
                    "Pupuk Organik: Berikan 10-20 ton pupuk kandang atau kompos per hektar saat pengolahan tanah.",
                    "Pupuk Dasar: Berikan 100 kg Urea, 100 kg SP-36, dan 100 kg KCl per hektar."
                ), "Tahap Pertumbuhan" to listOf(
                    "Pemupukan Susulan Pertama: 4 minggu setelah tanam, tambahkan 100 kg Urea per hektar.",
                    "Pemupukan Susulan Kedua: 8 minggu setelah tanam, tambahkan 100 kg Urea per hektar."
                )
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        PupukInfo(
            title = "Pemupukan Pisang", steps = listOf(
                "Tahap Persiapan Lahan" to listOf(
                    "Pupuk Organik: Berikan 10-20 kg pupuk kandang atau kompos per lubang tanam, dicampur dengan tanah galian."
                ), "Tahap Pertumbuhan" to listOf(
                    "Pemupukan Susulan Pertama: 2 bulan setelah tanam, berikan 200-300 gram Urea, 100-200 gram SP-36, dan 200-300 gram KCl per tanaman.",
                    "Pemupukan Susulan Kedua: 4 bulan setelah tanam, berikan 200-300 gram Urea, 100-200 gram SP-36, dan 200-300 gram KCl per tanaman.",
                    "Pemupukan Susulan Ketiga: 6 bulan setelah tanam, berikan 200-300 gram Urea, 100-200 gram SP-36, dan 200-300 gram KCl per tanaman."
                )
            )
        )
    }
}

@Composable
fun PupukInfo(title: String, steps: List<Pair<String, List<String>>>) {
    Column {
        Text(text = title, style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(8.dp))

        steps.forEach { (step, details) ->
            PupukStepText(step = step, details = details)
        }
    }
}

@Composable
fun PupukStepText(step: String, details: List<String>, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(bottom = 16.dp)) {
        Text(text = step, style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(4.dp))
        details.forEach { detail ->
            Text(text = detail, style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}
