package com.example.captaintreasure

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
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
import androidx.compose.ui.tooling.preview.Preview
import com.example.captaintreasure.ui.theme.CaptainTreasureTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaptainTreasureTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CaptainTreasure()
                }
            }
        }
    }
}
@Composable
    fun CaptainTreasure(){
    var treasureFound by remember { mutableStateOf(0)}
    var direction by remember { mutableStateOf("North") }
    var stormOrTreasure by remember { mutableStateOf("") }
        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            Text(text = "Treasure found: ${treasureFound}")
            Text(text = "Current Direction: ${direction}")

            Button(onClick = {
                direction= "East"
                if(Random.nextBoolean()){
                    treasureFound+=1
                    stormOrTreasure = "Found a treasure"
                }
                else{
                    stormOrTreasure = "Storm Ahead"
                }
            }) {
                Text(text = "Sail East")
            }
            Button(onClick = {
                direction = "West"
                if(Random.nextBoolean()){
                    treasureFound+=1
                }
            })
            {
                Text(text = "Sail West")
            }
            Button(onClick = {
                direction= "North"
                if(Random.nextBoolean()){
                    treasureFound+=1
                    stormOrTreasure = "Found a treasure"
                }
                else{
                    stormOrTreasure= "Storm Ahead"
                }
            })
            {
                Text(text = "Sail North")
            }
            Button(onClick = {
                direction  = "South"
                if(Random.nextBoolean()){
                    treasureFound+=1
                    stormOrTreasure = "Found a treasure"
                }
                else{
                    stormOrTreasure = "Storm Ahead"
                }
            })
            {
                Text(text = "Sail South")
            }
            Text(text = stormOrTreasure)
        }
    }