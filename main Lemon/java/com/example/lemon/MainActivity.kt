package com.example.lemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemon.ui.theme.LemonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonTheme {
                LemonApp()
            }
        }
    }
}

@Preview
@Composable
fun LemonApp() {
    LemonImageAndText(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun LemonImageAndText(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }
    var needCount: Int = (2..4).random()
    var count: Int = 0
    val imageResource = when (result) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    var textResource: String = when (result) {
        1 -> stringResource(R.string.cook1)
        2 -> stringResource(R.string.cook2)
        3 -> stringResource(R.string.cook3)
        else -> stringResource(R.string.cook4)
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = imageResource),
            contentDescription = result.toString(),
            modifier = Modifier.clickable {
                count++
                if(count == needCount){
                    if(result != 4)
                        result++
                    else
                        result = 1
                }
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = textResource,
            fontSize = 16.sp)
    }
}