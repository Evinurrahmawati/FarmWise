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

class HamaActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FarmWiseTheme {
                Scaffold(topBar = {
                    TopAppBar(title = { Text("Hama") }, navigationIcon = {
                        IconButton(onClick = { onBackPressedDispatcher.onBackPressed() }) {
                            Icon(
                                Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Kembali"
                            )
                        }
                    })
                }, content = { innerPadding ->
                    HamaContent(
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
fun HamaContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        HamaInfo(
            title = "Tikus Sawah", imageResId = R.drawable.tukus, description = """
                Pengendalian hama tikus sawah (Rattus argentiventer) dapat dilakukan melalui beberapa metode efektif yang dapat diterapkan secara bersamaan. Sanitasi lahan adalah langkah awal yang penting, yaitu dengan membersihkan area sekitar sawah dari semak-semak, gulma, dan sisa-sisa tanaman untuk mengurangi tempat persembunyian tikus. Penggunaan jebakan hidup atau jebakan mati juga efektif, dengan penempatan di sepanjang pematang sawah dan tempat strategis lainnya untuk menangkap tikus secara langsung. Penggunaan rodentisida atau racun tikus, jika digunakan dengan hati-hati sesuai petunjuk, dapat membantu mengurangi populasi tikus. Selain itu, mendorong kehadiran pemangsa alami seperti burung hantu, ular, dan kucing juga bisa menjadi solusi alami dalam mengendalikan populasi tikus. Penanaman serempak dan rotasi tanaman juga dapat diterapkan untuk mengurangi sumber makanan tikus dan mengganggu siklus hidup mereka. Dengan kombinasi metode ini, populasi tikus sawah dapat dikendalikan secara efektif, sehingga meningkatkan hasil panen padi.
            """.trimIndent()
        )

        Spacer(modifier = Modifier.height(16.dp))

        HamaInfo(
            title = "Ulat Grayak", imageResId = R.drawable.ulat_grayak, description = """
                Pengendalian hama ulat grayak (Spodoptera frugiperda) dapat dilakukan dengan beberapa metode yang efektif. Salah satu metode pengendalian adalah dengan melakukan pengendalian hayati menggunakan musuh alami dari ulat grayak, seperti parasitoid atau predator alami. Penggunaan insektisida yang sesuai juga dapat menjadi solusi, namun harus dilakukan dengan hati-hati dan sesuai petunjuk penggunaan untuk menghindari dampak negatif terhadap lingkungan dan kesehatan manusia. Selain itu, penanaman varietas jagung yang tahan terhadap serangan ulat grayak juga dapat menjadi langkah preventif yang efektif. Praktik budidaya yang baik, seperti sanitasi lahan dan rotasi tanaman, juga dapat membantu mengurangi risiko serangan ulat grayak. Dengan kombinasi metode yang tepat, serangan ulat grayak dapat dikendalikan secara efektif, sehingga mengurangi kerugian yang ditimbulkan pada tanaman jagung.
            """.trimIndent()
        )

        Spacer(modifier = Modifier.height(16.dp))

        HamaInfo(
            title = "Tungau Merah", imageResId = R.drawable.tungau_merah, description = """
                Pengendalian hama tungau merah (Tetranychus urticae) dapat dilakukan dengan beberapa metode. Salah satunya adalah penggunaan insektisida atau akarisida yang efektif untuk mengendalikan populasi tungau merah. Penggunaan insektisida harus dilakukan sesuai dengan dosis yang tepat dan jadwal aplikasi yang direkomendasikan untuk menghindari resistensi dan dampak negatif pada lingkungan. Selain itu, pengendalian hayati juga dapat dilakukan dengan memperkenalkan musuh alami tungau, seperti predator atau parasitoid yang dapat membantu mengurangi populasi tungau merah secara alami. Pemeliharaan tanaman yang sehat juga penting dalam mengurangi serangan tungau merah, termasuk pemantauan rutin dan pemberian nutrisi yang cukup. Dengan kombinasi metode pengendalian yang tepat, serangan tungau merah pada tanaman singkong dapat dikendalikan secara efektif.
            """.trimIndent()
        )

        Spacer(modifier = Modifier.height(16.dp))

        HamaInfo(
            title = "Wereng", imageResId = R.drawable.wereng, description = """
                Pengendalian hama wereng dapat dilakukan dengan menggunakan insektisida yang aman, memanfaatkan musuh alami wereng, memilih varietas padi yang tahan terhadap wereng, serta menerapkan praktik budidaya yang baik seperti pemantauan rutin dan penanaman serempak.
            """.trimIndent()
        )
    }
}

@Composable
fun HamaInfo(title: String, imageResId: Int, description: String) {
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

        Spacer(modifier = Modifier.height(8.dp))

        Image(
            painter = painterResource(id = imageResId),
            contentDescription = title,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = description, style = MaterialTheme.typography.bodyLarge)
    }
}

@Preview(showBackground = true)
@Composable
fun HamaContentPreview() {
    FarmWiseTheme {
        HamaContent()
    }
}
