package com.example.catalogoanimales.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.catalogoanimales.DetailActivity;
import com.example.catalogoanimales.R;
import com.example.catalogoanimales.model.Animal;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.ViewHolder> {

    private final List<Animal> animales;
    private final Context context;

    public AnimalAdapter(Context context, List<Animal> animales) {
        this.context = context;
        this.animales = animales;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_animal, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Animal animal = animales.get(position);

        holder.tvEspecie.setText(animal.getEspecie());
        holder.tvNombreCientifico.setText(animal.getNombreCientifico());
        holder.tvHabitat.setText(animal.getHabitat());

        // Cargar imagen usando Picasso sin placeholder ni imagen de error
        if (animal.getImg() != null && !animal.getImg().isEmpty()) {
            Picasso.get()
                    .load(animal.getImg())
                    .into(holder.ivAnimal);
        }


        // Configurar el color de fondo según el tipo de animal (verificación segura)
        int colorResId = R.color.colorDefault;
        String tipo = animal.getTipoAnimal();

        if (tipo != null) {
            if (tipo.equalsIgnoreCase("ave rapaz")) {
                colorResId = R.color.colorAveRapaz;
            } else if (tipo.equalsIgnoreCase("ave")) {
                colorResId = R.color.colorAve;
            } else if (tipo.equalsIgnoreCase("mamifero")) {
                colorResId = R.color.colorMamifero;
            }
        }

        holder.cardView.setCardBackgroundColor(context.getResources().getColor(colorResId));

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("animal", animal);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return animales.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        final CardView cardView;
        final ImageView ivAnimal;
        final TextView tvEspecie;
        final TextView tvNombreCientifico;
        final TextView tvHabitat;

        ViewHolder(View view) {
            super(view);
            cardView = view.findViewById(R.id.cardView);
            ivAnimal = view.findViewById(R.id.ivAnimal);
            tvEspecie = view.findViewById(R.id.tvEspecie);
            tvNombreCientifico = view.findViewById(R.id.tvNombreCientifico);
            tvHabitat = view.findViewById(R.id.tvHabitat);
        }
    }
}
