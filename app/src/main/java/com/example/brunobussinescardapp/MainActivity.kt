package com.example.brunobussinescardapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.brunobussinescardapp.ui.theme.BrunoBussinesCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BrunoBussinesCardAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Image(
                        painter = painterResource(id = R.drawable.background),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                    BusinessCardContent(
                        name = "Bruno Accorsi Bergoli",
                        title = "Software Developer",
                        email = "b.bergoli@gmail.com",
                        phone = "+1 (403) 399-1753",
                        github = "BrunoAccorsi",
                        githubUri = "https://github.com/BrunoAccorsi",
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun BusinessCardContent(
    name: String,
    title: String,
    email: String,
    phone: String,
    github: String,
    githubUri: String,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(0.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding()
                .offset(y = (-28).dp)
                .graphicsLayer {
                    rotationZ = 45f  // Rotate 45 degrees
                }
        ) {
            Text(
                text = name,
                fontSize = 32.sp,
                fontFamily = FontFamily.SansSerif,
                textAlign = TextAlign.Center,
                color = Color.White,
            )
            Text(
                text = title,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color = Color.Gray
            )
            Text(
                text = email,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                color = Color.Black
            )
            Text(
                text = phone,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                color = Color.Black
            )
        }
        Row(
            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding()
                .offset(y = 300.dp)
                .graphicsLayer {
                    rotationZ = -45f  // Rotate -45 degrees
                }
        ) {
            Box(
                Modifier.clickable {
                    // Open GitHub link on click
                    val intent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(githubUri)
                    )
                    context.startActivity(intent)
                }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.github),
                    contentDescription = "GitHub Logo",
                    modifier = Modifier.size(32.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = github,
                    fontSize = 32.sp,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                )
            }

        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BrunoBussinesCardAppTheme {
        BusinessCardContent(
            name = "Bruno Accorsi Bergoli",
            title = "Software Developer",
            email = "b.bergoli@gmail.com",
            phone = "+1 (403) 399-1753",
            github = "BrunoAccorsi",
            githubUri = "https://github.com/BrunoAccorsi",
        )
    }
}