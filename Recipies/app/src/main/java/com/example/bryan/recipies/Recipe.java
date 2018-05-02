package com.example.bryan.recipies;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class Recipe {
    private ArrayList<String> ingredients;
    private String instructions;
    private double time;

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public Recipe(String instructions, ArrayList<String> ingredients, double time){
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.time = time;

    }
}
