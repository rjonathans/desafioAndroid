package br.com.digitalhouse.desafioandroid.views;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.appbar.CollapsingToolbarLayout;

import br.com.digitalhouse.desafioandroid.R;
import br.com.digitalhouse.desafioandroid.models.Recipe;

import static br.com.digitalhouse.desafioandroid.views.RestaurantActivity.RECIPE;

public class RecipeActivity extends AppCompatActivity {
    private CollapsingToolbarLayout toolbarLayout;
    private ImageView photoRecipe;
    private TextView detailRecipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        toolbarLayout = findViewById(R.id.toolbar_layout);
        photoRecipe = findViewById(R.id.photo_recipe);
        detailRecipe = findViewById(R.id.recipe_content);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        if (getIntent() != null && getIntent().getExtras() != null) {
            Recipe recipe = getIntent().getExtras().getParcelable(RECIPE);
            Drawable drawable = getResources().getDrawable(recipe.getPhotoPlate());

            toolbarLayout.setTitle(recipe.getNamePlate());
            photoRecipe.setImageDrawable(drawable);
            detailRecipe.setText(recipe.getDetailPlate());
        }


    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

}
