package com.saavatech.mealzapp.models

import com.saavatech.mealzapp.models.api.MealsWebService
import com.saavatech.mealzapp.models.responses.MealsCategoriesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealsRepository(private val webService: MealsWebService = MealsWebService() ) {
//    fun getMeals(successCallback: (response: MealsCategoriesResponse?)->Unit){
//
//        return webService.getMeals().enqueue(object: Callback<MealsCategoriesResponse>{
//            override fun onResponse(
//                call: Call<MealsCategoriesResponse>,
//                response: Response<MealsCategoriesResponse>
//            ) {
//                if (response.isSuccessful)
//              successCallback(response.body())
//            }
//
//            override fun onFailure(call: Call<MealsCategoriesResponse>, t: Throwable) {         }
//        })
//
//        return
//    }

    suspend fun getMeals(): MealsCategoriesResponse{
        return webService.getMeals()
    }
}