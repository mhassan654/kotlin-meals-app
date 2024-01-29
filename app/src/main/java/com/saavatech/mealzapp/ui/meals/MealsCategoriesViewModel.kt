package com.saavatech.mealzapp.ui.meals

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saavatech.mealzapp.models.MealsRepository
import com.saavatech.mealzapp.models.responses.MealResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository.getInstance()): ViewModel() {
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