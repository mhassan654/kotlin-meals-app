package com.saavatech.mealzapp.ui.screens

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.saavatech.mealzapp.models.responses.MealResponse
import kotlin.math.min

@Composable
fun MealDetailsScreen(meal: MealResponse?){
    val scrollState = rememberLazyListState()
    val offSet = min(1f, 1 - (scrollState.firstVisibleItemScrollOffset / 600f +
            scrollState.firstVisibleItemIndex))
    val size by animateDpAsState(targetValue = max(100.dp, 200.dp * offSet), label = "")

    Surface(color = MaterialTheme.colorScheme.background) {
        Column {
            Surface(shadowElevation = 4.dp) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Card {
                        Image(
                            painter = rememberAsyncImagePainter(meal?.imageUrl),
                            contentDescription =null ,
                            modifier = Modifier
                                .size(size)
                        )
                    }
                    Text(
                        meal?.name?: "default name",
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.CenterVertically)
                    )
                }
            }

            val dummyContentList = (0..100).map { it.toString() }
            LazyColumn(state = scrollState) {
                items(dummyContentList){
                    dummyItem -> Text(text = dummyItem, modifier = Modifier.padding(8.dp))
                }

            }

        }
    }

}
