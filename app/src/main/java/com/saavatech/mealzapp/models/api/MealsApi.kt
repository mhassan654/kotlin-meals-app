package com.saavatech.mealzapp.models.api

import com.saavatech.mealzapp.models.responses.MealsCategoriesResponse
import com.saavatech.mealzapp.utils.BASE_URL
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


class MealsWebService {
    private lateinit var  api: MealsApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(MealsApi::class.java)
    }

    suspend fun getMeals(): MealsCategoriesResponse{
        return api.getMeals()
    }

    interface  MealsApi{
        @GET("categories.php")
       suspend fun getMeals(): MealsCategoriesResponse
    }
}