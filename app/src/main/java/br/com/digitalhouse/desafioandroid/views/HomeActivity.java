package br.com.digitalhouse.desafioandroid.views;



import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;


import br.com.digitalhouse.desafioandroid.R;
import br.com.digitalhouse.desafioandroid.adpater.RestaurantAdapter;
import br.com.digitalhouse.desafioandroid.interfaces.RestaurantOnCLick;
import br.com.digitalhouse.desafioandroid.models.Recipe;
import br.com.digitalhouse.desafioandroid.models.Restaurant;



public class HomeActivity extends AppCompatActivity implements RestaurantOnCLick {

    public static final String RESTAURANT = "Restaurante";

    private RecyclerView recyclerViewRestaurant;
    private RestaurantAdapter restaurantAdapter;
    private List<Restaurant> listRestaurants = new ArrayList<>();
    private List<Recipe> listRecipes = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerViewRestaurant = findViewById(R.id.recycler_view_home);
        restaurantAdapter = new RestaurantAdapter(addlistRestaurant(), this);
        recyclerViewRestaurant.setAdapter(restaurantAdapter);
        recyclerViewRestaurant.setLayoutManager(new LinearLayoutManager(this));
    }

    public List<Restaurant> addlistRestaurant(){
        listRestaurants.add(new Restaurant(R.drawable.photo_restaurant_one,"Tony´s Roma","Av. Lavandisca, 717 - Indianópolis, São Paulo","Fecha às 22h",addListRecipes()));
        listRestaurants.add(new Restaurant(R.drawable.photo_restaurant_one,"Tony´s Roma","Av. Lavandisca, 717 - Indianópolis, São Paulo","Fecha às 22h",addListRecipes()));
        listRestaurants.add(new Restaurant(R.drawable.photo_restaurant_one,"Tony´s Roma","Av. Lavandisca, 717 - Indianópolis, São Paulo","Fecha às 22h",addListRecipes()));
        listRestaurants.add(new Restaurant(R.drawable.photo_restaurant_one,"Tony´s Roma","Av. Lavandisca, 717 - Indianópolis, São Paulo","Fecha às 22h",addListRecipes()));
        return listRestaurants;
    }

    public List<Recipe> addListRecipes() {

        listRecipes.add(new Recipe("Salada com molho de gengibre",R.drawable.photo_recipes_one,"asdasdsadsadsadsadsadsadsadsadsadsadsadsadsadsadasdsa"));
        listRecipes.add(new Recipe("Salada com molho de gengibre",R.drawable.photo_recipes_one,"asdasdsadsadsadsadsadsadsadsadsadsadsadsadsadsadasdsa"));
        listRecipes.add(new Recipe("Salada com molho de gengibre",R.drawable.photo_recipes_one,"asdasdsadsadsadsadsadsadsadsadsadsadsadsadsadsadasdsa"));
        listRecipes.add(new Recipe("Salada com molho de gengibre",R.drawable.photo_recipes_one,"asdasdsadsadsadsadsadsadsadsadsadsadsadsadsadsadasdsa"));
        return listRecipes;
    }


    @Override
    public void onClick(Restaurant restaurant) {
        Intent intent = new Intent(HomeActivity.this, RestaurantActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(RESTAURANT, restaurant);
        intent.putExtras(bundle);
        startActivity(intent);

    }


}
