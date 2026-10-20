package tw.edu.pu.csim.tcyang.rolldice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import tw.edu.pu.csim.tcyang.rolldice.ui.theme.ROLLDICETheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ROLLDICETheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Dice(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Dice(modifier: Modifier = Modifier) {

    var diceNumber by remember { mutableStateOf(0) }


    val diceImages = arrayOf(
        R.drawable.dice0,
        R.drawable.dice1,
        R.drawable.dice2,
        R.drawable.dice3,
        R.drawable.dice4,
        R.drawable.dice5,
        R.drawable.dice6
    )

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {

        Text(
            text = "請點擊圖片隨機丟骰子\n作者：魏仁楷"
        )
        Image(
            painter = painterResource(id = diceImages[diceNumber]),
            contentDescription = "Dice",
            modifier = Modifier
                .pointerInput(Unit) {
                    detectTapGestures(
                        onTap = {
                            diceNumber = (1..6).random() // 點擊：隨機 1-6 點
                        },
                        onDoubleTap = {
                            diceNumber = 0 // 雙擊：歸零 (dice0)
                        },
                        onLongPress = {
                            diceNumber = 6 // 長按：設為 6 點 (dice6)
                        }
                    )
                }
        )
    }
}