package com.example.bryan.recipies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class RecipeView extends AppCompatActivity {

    private HashMap<String,Recipe> recipes;
    public RecipeView()
    {
        recipes = new HashMap<String,Recipe>();
        ArrayList<String> parts1 = new ArrayList<String>();
        parts1.add("1 bunch of asparagus");
        parts1.add("3 tablespoons of olive oil");
        parts1.add("1 clove of garlic");
        parts1.add("1 teaspon of sea salt");
        ArrayList<String> parts2 = new ArrayList<String>();
        parts2.add("1 Box of Pasta");
        parts2.add("One jar of sauce");
        ArrayList<String> parts3 = new ArrayList<String>();
        parts3.add("One Bag of Popcorn");
        recipes.put("Roasted Asparagus", new Recipe("Mix asparagus, olive oil salt, and garlic. Place on a sheet and place in 425 degree oven",parts1,12));
        recipes.put("Pasta",new Recipe("Boil pasta, then add sauce",parts2,10));
        recipes.put("Popcorn",new Recipe("Place popcorn bag in microwave and use microwave to pop",parts3,4.02));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_view);

        TextView list = (TextView)findViewById(R.id.ingredients);
        TextView instructions = (TextView)findViewById(R.id.steps);
        TextView time = (TextView)findViewById(R.id.time);
        TextView name = (TextView)findViewById(R.id.name);
        String nameString = "";
        Recipe r = null; //CODEHERE
        String ingredients = "";
        for(String ingredient: r.getIngredients()){
            ingredients += ingredient + " ";
        }
        list.setText(ingredients);
        instructions.setText(r.getInstructions());
        time.setText(Double.toString(r.getTime()));
        name.setText(nameString);


    }
}
