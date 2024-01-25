package com.saavatech.mealzapp.ui.meals

import android.util.Log
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saavatech.mealzapp.models.MealsRepository
import com.saavatech.mealzapp.models.responses.MealResponse
import com.saavatech.mealzapp.models.responses.MealsCategoriesResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository()): ViewModel() {
    private val mealsJob = Job()

    init {
            viewModelScope.launch(Dispatchers.IO){
                val meals = getMeals()
                mealsState.value = meals
            }
    }

    val mealsState: MutableState<List<MealResponse>> =
        mutableStateOf(emptyList<MealResponse>())

  private suspend fun getMeals(): List<MealResponse>{
       return repository.getMeals().categories
    }
}