package com.example.ravikiranpathade.bakingapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.ravikiranpathade.bakingapp.R;
import com.example.ravikiranpathade.bakingapp.singleList.Ingredients;
import com.example.ravikiranpathade.bakingapp.singleList.StepForRecipe;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ravikiranpathade on 10/22/17.
 */

public class RecipeStepsAdapter extends RecyclerView.Adapter<RecipeStepsAdapter.RecipeStepsViewHolder> {

    List<StepForRecipe> stepForRecipe;

    Context context;

    //TODO CLICKLISTENER
    public interface RecipeStepAdapterOnClick {
        void onClick(int position);
    }

    public RecipeStepAdapterOnClick mClickHandler;

    public RecipeStepsAdapter(List<StepForRecipe> recipeSteps, Context mContext, RecipeStepAdapterOnClick mOnClick) {
        stepForRecipe = recipeSteps;
        context = mContext;
        mClickHandler = mOnClick;

    }


    @Override
    public RecipeStepsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutId = R.layout.steps_list_item;
        context = parent.getContext();

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        boolean shouldAttach = false;
        View view = layoutInflater.inflate(layoutId, parent, shouldAttach);
        ButterKnife.bind(this, view);

        RecipeStepsViewHolder stepsViewHolder = new RecipeStepsViewHolder(view);

        return stepsViewHolder;
    }

    @Override
    public void onBindViewHolder(RecipeStepsViewHolder holder, int position) {

        holder.bind(position);

    }

    @Override
    public int getItemCount() {
        return stepForRecipe.size();
    }

    public void setData(List<StepForRecipe> steps) {
        stepForRecipe = steps;
        notifyDataSetChanged();
    }

    public List<StepForRecipe> getDataRecipes() {
        return stepForRecipe;
    }

    class RecipeStepsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.stepsListButton)
        Button stepsListButton;

        Context mHolderContext;


        public RecipeStepsViewHolder(View itemView) {
            super(itemView);
            mHolderContext = itemView.getContext();
            ButterKnife.bind(this, itemView);

            stepsListButton.setOnClickListener(this);
        }

        public void bind(final int position) {
            if (position == 0) {

                stepsListButton.setText("Check All the Ingredients");


            } else {

                stepsListButton.setText(getDataRecipes().get(position - 1).getShortDesc());
            }

        }

        //TODO CLICKLISTENER
        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            mClickHandler.onClick(position);
            //Toast.makeText(context,"From Adapter",Toast.LENGTH_SHORT).show();
            Log.d("Here"," is");
        }
    }
}
