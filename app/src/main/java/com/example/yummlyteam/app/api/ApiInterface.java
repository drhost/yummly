package com.example.yummlyteam.app.api;

import com.example.yummlyteam.app.model.Match;
import com.example.yummlyteam.app.model.RecipeSearchList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiInterface {
    @GET("recipes")
    Call<RecipeSearchList> getRecipeList(@Query("_app_id") String _app_id,
                                         @Query("_app_key") String _app_key,
                                         @Query("q") String searchQuery,
                                         @Query("maxResult") int item_per_page,
                                         @Query("start") int start);


    @GET("recipe/{id}")
    Call<Match> getRecipe(@Path("id") String recipeId);
}
