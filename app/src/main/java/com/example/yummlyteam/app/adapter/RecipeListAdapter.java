package com.example.yummlyteam.app.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.yummlyteam.app.api.ApiClient;
import com.example.yummlyteam.app.api.ApiInterface;
import com.example.yummlyteam.app.search.RecipeViewModel;
import com.example.yummlyteam.yummly_project.R;
import com.example.yummlyteam.app.Util;
import com.example.yummlyteam.app.model.Match;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder> {

    private List<Match> recipeList;
    private RecipeViewModel mViewModel;

    public RecipeListAdapter(RecipeViewModel viewModel, List<Match> recipeList) {
        this.recipeList = recipeList;
        mViewModel = viewModel;
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.recipe_row, parent, false);
        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder recipeViewHolder, int position) {

        final Match recipe = recipeList.get(position);

        recipeViewHolder.recipeName.setText(recipe.getRecipeName() != null ? recipe.getRecipeName() : " ");
        recipeViewHolder.totalTime.setText(recipe.getTotalTimeInSeconds() != null ?
                Util.timeFormatter(recipe.getTotalTimeInSeconds()) : " ");
        recipeViewHolder.totalCalories.setText("--");
        recipeViewHolder.ingredients.setText(recipe.getIngredients() != null ? "" + recipe.getIngredients().size() : " ");

        if (recipe.getSmallImageUrls() != null) {
            Picasso.with(recipeViewHolder.itemView.getContext())
                    .load(recipe.getSmallImageUrls().get(0))
                    .networkPolicy(
                            Util.isNetworkConnectionAvailable(recipeViewHolder.itemView.getContext()) ?
                                    NetworkPolicy.NO_CACHE : NetworkPolicy.OFFLINE)
                    .into(recipeViewHolder.recipeImageView);
        }

        if (recipe.getFlavors() != null && recipe.getFlavors().getBitter() != null && recipe.getFlavors().getBitter().equals(1f)) {
            recipeViewHolder.recipeBitternessIndicator.setVisibility(View.VISIBLE);
        }

        recipeViewHolder.itemLayout.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              mViewModel.getRecipeDetails(recipe);
          }
        });
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    public boolean addItems(List<Match> newItems) {
        if (recipeList != null) {
            recipeList.addAll(newItems);
            notifyDataSetChanged();
            return true;
        }
        return false;
    }

    public void clearList() {
        if (recipeList != null) {
            recipeList.clear();
        }
        notifyDataSetChanged();
    }


    public static class RecipeViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout itemLayout;
        TextView ingredients, recipeName, totalCalories, totalTime, recipeBitternessIndicator;
        ImageView recipeImageView;

        public RecipeViewHolder(@NonNull View itemView) {
            super(itemView);
            itemLayout = itemView.findViewById(R.id.member_layout);
            recipeName = itemView.findViewById(R.id.recipeName);
            ingredients = itemView.findViewById(R.id.ingredients);
            totalCalories = itemView.findViewById(R.id.totalCalories);
            totalTime = itemView.findViewById(R.id.totalTime);
            recipeImageView = itemView.findViewById(R.id.recipeImageView);
            recipeBitternessIndicator = itemView.findViewById(R.id.bitter_label);
        }
    }

}
