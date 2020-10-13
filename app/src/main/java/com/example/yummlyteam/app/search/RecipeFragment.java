package com.example.yummlyteam.app.search;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.yummlyteam.app.adapter.RecipeListAdapter;
import com.example.yummlyteam.app.model.DialogInfo;
import com.example.yummlyteam.app.model.Match;
import com.example.yummlyteam.app.model.RecipeSearchList;
import com.example.yummlyteam.yummly_project.R;

import java.util.ArrayList;


public class RecipeFragment extends Fragment {
    private static final String TAG = RecipeFragment.class.getSimpleName();
    private RecyclerView recyclerView;
    private RecipeViewModel mViewModel;
    private ProgressBar mProgressBar;

    public static RecipeFragment newInstance() {
        return new RecipeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.recipe_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        try {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mViewModel = ViewModelProviders.of(getActivity()).get(RecipeViewModel.class);
                }
            });
        } catch (NullPointerException npe) {
            Log.e(TAG, "Error retrieving view model.");
        }

        mProgressBar = getView().findViewById(R.id.listLoading);
        recyclerView = getView().findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new RecipeListAdapter(mViewModel, new ArrayList<Match>()));
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (!recyclerView.canScrollVertically(1)) {
                    mViewModel.nextSearchPage();
                }
            }
        });

        // Create the observer which updates the UI.
        final Observer<RecipeSearchList> searchListObserver = new Observer<RecipeSearchList>() {
            @Override
            public void onChanged(@Nullable final RecipeSearchList searchList) {
                // Update the UI
                if (searchList == null || searchList.getMatches() == null) { // clear the list
                    ((RecipeListAdapter) recyclerView.getAdapter()).clearList();
                } else {
                    recyclerView.setVisibility(View.VISIBLE);
                    ((RecipeListAdapter) recyclerView.getAdapter()).addItems(searchList.getMatches());
                }
            }
        };
        // attach the observer
        mViewModel.getSearchList().observe(this, searchListObserver);
        // Create the observer to display any dialogs.
        final Observer<DialogInfo> dialogObserver = new Observer<DialogInfo>() {
            @Override
            public void onChanged(@Nullable final DialogInfo dialogInfo) {
                displayDialog(dialogInfo);
            }
        };

        mViewModel.getDialogInfo().observe(this, dialogObserver);
        mViewModel.displayLoading.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean displayLoading) {
                mProgressBar.setVisibility(displayLoading ? View.VISIBLE : View.GONE);
            }
        });
    }

    private void displayDialog(DialogInfo dialogInfo) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext());
        String notification = getContext().getString(dialogInfo.getNotification());
        if (dialogInfo.getAdditionalDialogInfo() != null && !dialogInfo.getAdditionalDialogInfo().isEmpty()) {
            notification = getContext().getString(dialogInfo.getNotification(), dialogInfo.getAdditionalDialogInfo());
        }

        dialogBuilder.setMessage(notification)
                .setCancelable(false)
                .setPositiveButton(dialogInfo.getPositiveText(), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        AlertDialog dialog = dialogBuilder.create();
        dialog.setTitle(dialogInfo.getTitle());
        dialog.show();
    }
}
