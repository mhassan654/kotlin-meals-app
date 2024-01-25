package com.saavatech.mealzapp.models

import com.saavatech.mealzapp.models.api.MealsWebService
import com.saavatech.mealzapp.models.responses.MealsCategoriesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealsRepository(private val webService: MealsWebService = MealsWebService() ) {
    suspend fun getMeals(): MealsCategoriesResponse{
        return webService.getMeals()
    }
}