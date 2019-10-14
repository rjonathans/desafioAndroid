package br.com.digitalhouse.desafioandroid.adpater;


import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.digitalhouse.desafioandroid.R;
import br.com.digitalhouse.desafioandroid.interfaces.RestaurantOnCLick;
import br.com.digitalhouse.desafioandroid.models.Restaurant;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder> {

    private List<Restaurant> listRestaurants;
    private RestaurantOnCLick listner;


    public RestaurantAdapter(List<Restaurant> listRestaurants, RestaurantOnCLick listner) {
        this.listRestaurants = listRestaurants;
        this.listner = listner;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_restaurant,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Restaurant restaurant = listRestaurants.get(position);
        holder.bind(restaurant);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listner.onClick(restaurant);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listRestaurants.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView nameRestaurant;
        private TextView addressRestaurant;
        private TextView hour;
        private ImageView photoRestaurant;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nameRestaurant = itemView.findViewById(R.id.name_restaurant);
            addressRestaurant = itemView.findViewById(R.id.address_restaurant);
            hour = itemView.findViewById(R.id.hour_operation);
            photoRestaurant = itemView.findViewById(R.id.photo_restaurant);

        }

        public void bind(Restaurant restaurant) {
            Drawable drawable = itemView.getResources().getDrawable(restaurant.getPhotoRestaurant());

            nameRestaurant.setText(restaurant.getNameRestaurant());
            addressRestaurant.setText(restaurant.getAddress());
            hour.setText(restaurant.getHour());
            photoRestaurant.setImageDrawable(drawable);
        }
    }
}
