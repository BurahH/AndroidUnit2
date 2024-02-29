package com.example.art

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.art.ui.theme.ArtTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtTheme {
                ArtApp()
            }
        }
    }
}

@Preview
@Composable
fun ArtApp() {
    ArtImageAndText(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun ArtImageAndText(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }
    val imageResource = when (result) {
        1 -> R.drawable.paint1
        2 -> R.drawable.paint2
        3 -> R.drawable.paint3
        4 -> R.drawable.paint4
        5 -> R.drawable.paint5
        else -> R.drawable.paint6
    }
    var artist: String = when (result) {
        1 -> stringResource(R.string.art1_artist)
        2 -> stringResource(R.string.art2_artist)
        3 -> stringResource(R.string.art3_artist)
        4 -> stringResource(R.string.art4_artist)
        5 -> stringResource(R.string.art5_artist)
        else -> stringResource(R.string.art6_artist)
    }
    var namePaint: String = when (result) {
        1 -> stringResource(R.string.art1)
        2 -> stringResource(R.string.art2)
        3 -> stringResource(R.string.art3)
        4 -> stringResource(R.string.art4)
        5 -> stringResource(R.string.art5)
        else -> stringResource(R.string.art6)
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            ElevatedCard(modifier = Modifier.padding(40.dp).height(250.dp).width(500.dp)) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Image(
                        painter = painterResource(id = imageResource),
                        contentDescription = result.toString(),
                        modifier = Modifier.padding(30.dp)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(70.dp))
        ElevatedCard(modifier = Modifier.padding(30.dp).height(120.dp).width(500.dp)) {
            Text(
                text = namePaint,
                textAlign = TextAlign.Left,
                modifier = Modifier.height(80.dp).width(500.dp),
                fontSize = 30.sp
            )
            Text(
                text = artist,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Left,
                modifier = Modifier.height(40.dp).width(500.dp),
                fontSize = 15.sp
            )
        }
        Row () {
            ElevatedCard(modifier = Modifier.padding(30.dp).height(30.dp).width(130.dp))
            {
                Text(
                    text = "Предыдущий",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.clickable {
                        if(result == 1)
                            result = 6
                        else
                            result--

                    }
                )
            }
            ElevatedCard(modifier = Modifier.padding(30.dp).height(30.dp).width(130.dp)) {
                Text(
                    text = "Следующий",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.clickable {
                        if(result == 6)
                            result = 1
                        else
                            result++

                    }
                )
            }
        }
    }
}