package com.saavatech.mealzapp.ui.meals

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.saavatech.mealzapp.models.MealsRepository
import com.saavatech.mealzapp.models.responses.MealResponse

class MealDetailsViewModel(
    private val savedStateHandle: SavedStateHandle,

): ViewModel() {
    private val repository: MealsRepository = MealsRepository.getInstance()
    var mealState = mutableStateOf<MealResponse?>(null)

    init {
        val mealId = savedStateHandle.get<String>("meal_category_id")?: ""
        mealState.value = repository.getMeal(mealId)
    }
}