package com.example.yummlyteam.app.search;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.yummlyteam.app.api.ApiClient;
import com.example.yummlyteam.app.api.ApiInterface;
import com.example.yummlyteam.app.model.DialogInfo;
import com.example.yummlyteam.app.model.Match;
import com.example.yummlyteam.app.model.RecipeSearchList;
import com.example.yummlyteam.yummly_project.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipeViewModel extends ViewModel {
    private static final String ACCESS_KEY = "955296fc681db8f8b82e0698d02a50c0";
    private static final String APP_ID = "62407325";
    private static final Integer ITEM_PER_PAGE = 18;

    private MutableLiveData<RecipeSearchList> searchList = new MutableLiveData<>();
    private MutableLiveData<Integer> currentSearchPage = new MutableLiveData<>();
    private MutableLiveData<String> query = new MutableLiveData<>();
    private MutableLiveData displayDialog = new MutableLiveData<DialogInfo>();
    public MutableLiveData<Boolean> displayLoading = new MutableLiveData<>();

    public MutableLiveData<DialogInfo> getDialogInfo() { return displayDialog; }

    public MutableLiveData<RecipeSearchList> getSearchList() {
        return searchList;
    }

    private String lastQueryValue = "";

    public void clearSearchList() {
        lastQueryValue = "";
        RecipeSearchList recipeSearchList = new RecipeSearchList();
        searchList.setValue(recipeSearchList);
    }

    private MutableLiveData<Integer> getCurrentSearchPage() {
        return currentSearchPage;
    }

    private void setCurrentSearchPage(int page) {
        currentSearchPage.setValue(page);
    }

    public void setSearchQuery(String q) {
        query.setValue(q);
    }

    public LiveData<String> getSearchQuery() {
        return query;
    }

    public void fetchRecipeSearchList() {
        if (query.getValue() == null || query.getValue().isEmpty()) {
            return;
        }

        // Allows user to edit the search value without selecting the clear button.
        if (query.getValue() != lastQueryValue) {
            clearSearchList();
            getCurrentSearchPage().setValue(null);
            lastQueryValue = query.getValue();
        }

        if (getCurrentSearchPage().getValue() == null) {
            displayLoading.postValue(true);
        }

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        Call<RecipeSearchList> call = apiService.getRecipeList(APP_ID, ACCESS_KEY, query.getValue(), ITEM_PER_PAGE
                , getCurrentSearchPage().getValue() == null ? 0 : getCurrentSearchPage().getValue());

        call.enqueue(new Callback<RecipeSearchList>() {
            @Override
            public void onResponse(Call<RecipeSearchList> call, Response<RecipeSearchList> response) {
                int statusCode = response.code();
                if (statusCode != 200 && getCurrentSearchPage().getValue() == null) {
                    displayDialog.setValue(
                            new DialogInfo(
                                    R.string.no_results_title,
                                    R.string.no_results_description,
                                    R.string.no_results_positive,
                                    query.getValue()
                            ));
                } else {
                    displayLoading.postValue(false);
                    if (response.body().getMatches().size() == 0 && getCurrentSearchPage().getValue() == null) {
                        displayDialog.setValue(
                                new DialogInfo(
                                        R.string.no_results_title,
                                        R.string.no_results_description,
                                        R.string.no_results_positive,
                                        query.getValue()
                                ));
                    } else {
                        searchList.setValue(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<RecipeSearchList> call, Throwable t) {
                displayLoading.postValue(false);
                displayDialog.setValue(
                        new DialogInfo(
                                R.string.no_results_title,
                                R.string.no_results_description,
                                R.string.no_results_positive,
                                query.getValue()
                        ));
                preSearchPage();
            }
        });
    }

    public void nextSearchPage() {
        int newPageNumber = currentSearchPage.getValue() == null ? 0 : currentSearchPage.getValue() + ITEM_PER_PAGE;
        setCurrentSearchPage(newPageNumber);
        fetchRecipeSearchList();
    }

    private void preSearchPage() {
        if (currentSearchPage.getValue() == null) return;

        int newPageNumber = currentSearchPage.getValue() == 0 ? 0 : currentSearchPage.getValue() - ITEM_PER_PAGE;
        setCurrentSearchPage(newPageNumber);
    }

    public void getRecipeDetails(Match recipe) {
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        Call<Match> getRecipeCall = apiService.getRecipe(recipe.getId());

        getRecipeCall.enqueue(new Callback<Match>() {
            @Override
            public void onResponse(Call<Match> call, Response<Match> response) {

            }

            @Override
            public void onFailure(Call<Match> call, Throwable t) {

            }
        });

    }
}
