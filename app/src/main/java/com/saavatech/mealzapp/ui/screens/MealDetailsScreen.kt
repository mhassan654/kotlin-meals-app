package com.saavatech.mealzapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.saavatech.mealzapp.models.responses.MealResponse

@Composable
fun MealDetailsScreen(meal: MealResponse){
    Column {
        Row {
            Card {
                Image(
                    painter = rememberAsyncImagePainter(meal.imageUrl),                    
                    contentDescription =null ,
                    modifier = Modifier.size(200.dp)
                )
            }
            Text(meal.name)
        }
        Button(onClick = { /*TODO*/ }) {
            Text("Change state of meal profile picture")
            
        }
    }
}