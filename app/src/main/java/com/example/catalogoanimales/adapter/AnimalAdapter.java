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
import com.example.catalogoanimales.model.Ave;
import com.example.catalogoanimales.model.AveRapaz;
import com.example.catalogoanimales.model.Mamifero;

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
        holder.ivAnimal.setImageResource(animal.getImageResourceId());

        // Configurar el color de fondo según el tipo de animal
        if (animal instanceof AveRapaz) {
            holder.cardView.setCardBackgroundColor(context.getResources().getColor(R.color.colorAveRapaz));
        } else if (animal instanceof Ave) {
            holder.cardView.setCardBackgroundColor(context.getResources().getColor(R.color.colorAve));
        } else if (animal instanceof Mamifero) {
            holder.cardView.setCardBackgroundColor(context.getResources().getColor(R.color.colorMamifero));
        } else {
            holder.cardView.setCardBackgroundColor(context.getResources().getColor(R.color.colorDefault));
        }

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("position", position);
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