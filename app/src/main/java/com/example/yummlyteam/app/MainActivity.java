package com.example.yummlyteam.app;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;

import com.example.yummlyteam.app.search.RecipeFragment;
import com.example.yummlyteam.app.search.RecipeViewModel;
import com.example.yummlyteam.yummly_project.R;

public class MainActivity extends AppCompatActivity {
  private RecipeViewModel mViewModel;
  private SearchView searchView;


  @Override
  protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mViewModel = ViewModelProviders.of(this).get(RecipeViewModel.class);

    searchView = findViewById(R.id.recipeSearchBar);
    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
      @Override
      public boolean onQueryTextSubmit(String s) {
        mViewModel.setSearchQuery(s);
        return false;
      }

      @Override
      public boolean onQueryTextChange(String s) {
        if (s.isEmpty()) {
          mViewModel.clearSearchList();
        }
        return false;
      }
    });

    final Observer<String> queryObserver = new Observer<String>() {
      @Override
      public void onChanged(@Nullable String s) {
        mViewModel.fetchRecipeSearchList();
      }
    };

    mViewModel.getSearchQuery().observe(this, queryObserver);

    if (findViewById(R.id.fragment_container) != null) {
      if (savedInstanceState != null) {
        return;
      }

      RecipeFragment firstFragment = new RecipeFragment();
      firstFragment.setArguments(getIntent().getExtras());
      getSupportFragmentManager().beginTransaction()
              .add(R.id.fragment_container, firstFragment).commit();
    }
  }
}
