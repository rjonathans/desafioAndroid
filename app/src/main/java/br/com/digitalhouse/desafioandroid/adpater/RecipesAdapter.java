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
import br.com.digitalhouse.desafioandroid.interfaces.RecipesOnClick;
import br.com.digitalhouse.desafioandroid.models.Recipe;

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.ViewHolder> {

    private List<Recipe> listRecipes;
    private RecipesOnClick listner;

    public RecipesAdapter(List<Recipe> listRecipes, RecipesOnClick listner) {
        this.listRecipes = listRecipes;
        this.listner = listner;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plate,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final Recipe recipe = listRecipes.get(position);
        holder.onBind(recipe);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listner.onClick(recipe);

            }
        });

    }

    @Override
    public int getItemCount() {
        return listRecipes.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView namePlate;
        private ImageView photoPlate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            namePlate = itemView.findViewById(R.id.name_plate);
            photoPlate = itemView.findViewById(R.id.photo_plate);

        }

        public void onBind(Recipe recipe) {

            Drawable drawable = itemView.getResources().getDrawable(recipe.getPhotoPlate());
            photoPlate.setImageDrawable(drawable);
            namePlate.setText(recipe.getNamePlate());


        }
    }
}
