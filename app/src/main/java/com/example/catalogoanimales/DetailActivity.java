package com.example.catalogoanimales;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.catalogoanimales.model.Animal;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Obtener el animal de los extras
        Animal animal = (Animal) getIntent().getSerializableExtra("animal");
        if (animal == null) {
            finish();
            return;
        }

        // Inicializar vistas
        ImageView ivAnimal = findViewById(R.id.ivAnimal);
        TextView tvEspecie = findViewById(R.id.tvEspecie);
        TextView tvNombreCientifico = findViewById(R.id.tvNombreCientifico);
        TextView tvHabitat = findViewById(R.id.tvHabitat);
        TextView tvPesoPromedio = findViewById(R.id.tvPesoPromedio);
        TextView tvEstadoConservacion = findViewById(R.id.tvEstadoConservacion);
        TextView tvTipoAnimal = findViewById(R.id.tvTipoAnimal);
        TextView tvTemperatura = findViewById(R.id.tvTemperatura);
        TextView tvGestacion = findViewById(R.id.tvGestacion);
        TextView tvAlimentacion = findViewById(R.id.tvAlimentacion);

        // Cargar imagen usando Picasso
        if (animal.getImg() != null && !animal.getImg().isEmpty()) {
            Picasso.get()
                    .load(animal.getImg())
                    .into(ivAnimal);
        }

        // Establecer los datos en las vistas
        tvEspecie.setText("Especie: " + animal.getEspecie());
        tvNombreCientifico.setText("Nombre científico: " + animal.getNombreCientifico());
        tvHabitat.setText("Hábitat: " + animal.getHabitat());
        tvPesoPromedio.setText(String.format("Peso promedio: %.2f kg", animal.getPesoPromedio()));
        tvEstadoConservacion.setText("Estado de conservación: " + animal.getEstadoConservacion());
        tvTipoAnimal.setText("Tipo: " + animal.getTipoAnimal());
        tvTemperatura.setText(String.format("Temperatura corporal: %.1f °C", animal.getTemperaturaCorporal()));
        tvGestacion.setText("Tiempo de gestación: " + animal.getTiempoGestacion() + " días");
        tvAlimentacion.setText("Alimentación: " + animal.getAlimentacion());
    }
}
