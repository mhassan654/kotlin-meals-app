package com.saavatech.mealzapp.ui.meals

import androidx.lifecycle.ViewModel
import com.saavatech.mealzapp.models.MealsRepository
import com.saavatech.mealzapp.models.responses.MealResponse
import com.saavatech.mealzapp.models.responses.MealsCategoriesResponse

class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository()): ViewModel() {
    fun getMeals(successCallback: (response: MealsCategoriesResponse?)-> Unit){
       repository.getMeals{ response -> successCallback(response)  }
    }
}