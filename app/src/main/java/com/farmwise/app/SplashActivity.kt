package com.farmwise.app

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.farmwise.app.ui.theme.DarkGreen
import com.farmwise.app.ui.theme.FarmWiseTheme

@SuppressLint("CustomSplashScreen")
class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FarmWiseTheme {
                Surface(
                    color = DarkGreen, modifier = Modifier.fillMaxSize()
                ) {
                    SplashScreenContent()
                }
            }
        }
    }
}

@Composable
fun SplashScreenContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.aspectRatio(1.5f)
        ) {
            Image(
                painter = painterResource(id = R.drawable.farmer),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(shape = RoundedCornerShape(16.dp))
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "FarmWise",
            color = Color.White,
            fontSize = 30.sp,
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.wrapContentSize(Alignment.Center)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Petani Cerdas, Hasil Melimpah.",
            color = Color.White,
            fontSize = 20.sp,
            modifier = Modifier.wrapContentSize(Alignment.Center)
        )

        Spacer(modifier = Modifier.height(16.dp))

        NavigateButton2(
            text = "Lanjut", context = LocalContext.current
        )
    }
}

@Composable
fun NavigateButton2(
    text: String, context: Context
) {
    Button(
        onClick = {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        },
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(Color.White),
        contentPadding = ButtonDefaults.ContentPadding,
    ) {
        Text(
            text = text, color = DarkGreen,
            style = MaterialTheme.typography.labelMedium
        )
    }
}
