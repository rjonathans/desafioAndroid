package br.com.digitalhouse.desafioandroid.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.desafioandroid.R;
import br.com.digitalhouse.desafioandroid.adpater.RecipesAdapter;
import br.com.digitalhouse.desafioandroid.interfaces.RecipesOnClick;
import br.com.digitalhouse.desafioandroid.models.Recipe;
import br.com.digitalhouse.desafioandroid.models.Restaurant;

import static br.com.digitalhouse.desafioandroid.views.HomeActivity.RESTAURANT;

public class RestaurantActivity extends AppCompatActivity implements RecipesOnClick {



    private CollapsingToolbarLayout toolbarLayout;
    private ImageView photoRestaurant;
    private RecyclerView recyclerPlates;
    private RecipesAdapter recipesAdapter;
    private List<Recipe> recipesList = new ArrayList<>();
    private Restaurant restaurant;

    public static final String RECIPE = "Recipe";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbarLayout = findViewById(R.id.toolbar_layout);
        photoRestaurant = findViewById(R.id.photo_restaurant);


        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        if (getIntent() != null && getIntent().getExtras()!= null){
            restaurant = getIntent().getExtras().getParcelable(RESTAURANT);
            Drawable drawable = getResources().getDrawable(restaurant.getPhotoRestaurant());

            toolbarLayout.setTitle(restaurant.getNameRestaurant());
            photoRestaurant.setImageDrawable(drawable);
            recipesList = restaurant.getListRecipe();
        }

        recyclerPlates = findViewById(R.id.recipes_recyclerView);

        recipesAdapter = new RecipesAdapter(recipesList,this);
        recyclerPlates.setAdapter(recipesAdapter);
        ViewCompat.setNestedScrollingEnabled(recyclerPlates,false);
        recyclerPlates.setLayoutManager(new GridLayoutManager(this,2));

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public void onClick(Recipe recipe) {
        Intent intent = new Intent(RestaurantActivity.this, RecipeActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(RECIPE, recipe);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}
