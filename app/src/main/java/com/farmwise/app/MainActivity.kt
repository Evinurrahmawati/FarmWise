package com.farmwise.app

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.farmwise.app.ui.theme.DarkGreen
import com.farmwise.app.ui.theme.FarmWiseTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FarmWiseTheme {
                Scaffold(topBar = {
                    TopAppBar(title = { Text("FarmWise") })
                }) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp, 64.dp, 16.dp, 16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        NavigateCard(
                            text = "Tanaman",
                            imagePainter = painterResource(id = R.drawable.kebun),
                            destinationActivity = TanamanActivity::class.java
                        )

                        NavigateCard(
                            text = "Pupuk",
                            imagePainter = painterResource(id = R.drawable.pupuk),
                            destinationActivity = PupukActivity::class.java
                        )

                        NavigateCard(
                            text = "Hama",
                            imagePainter = painterResource(id = R.drawable.tukus),
                            destinationActivity = HamaActivity::class.java
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun NavigateCard(text: String, imagePainter: Painter, destinationActivity: Class<*>) {
    val context = LocalContext.current

    Card(
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = imagePainter,
                contentDescription = null,
                modifier = Modifier
                    .height(120.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = text, color = Color.Black, style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = {
                    val intent = Intent(context, destinationActivity)
                    context.startActivity(intent)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(35.dp),
                colors = ButtonDefaults.buttonColors(DarkGreen)
            ) {
                Text(text = "Lihat", color = Color.White)
            }
        }
    }
}
