package com.example.catalogoanimales;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.catalogoanimales.model.Animal;
import com.example.catalogoanimales.model.Ave;
import com.example.catalogoanimales.model.AveRapaz;
import com.example.catalogoanimales.model.Mamifero;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        int position = getIntent().getIntExtra("position", 0);
        Animal animal = MainActivity.animales.get(position);

        ImageView ivAnimalDetail = findViewById(R.id.ivAnimalDetail);
        TextView tvEspecieDetail = findViewById(R.id.tvEspecieDetail);
        TextView tvNombreCientificoDetail = findViewById(R.id.tvNombreCientificoDetail);
        TextView tvHabitatDetail = findViewById(R.id.tvHabitatDetail);
        TextView tvPesoPromedioDetail = findViewById(R.id.tvPesoPromedioDetail);
        TextView tvEstadoConservacionDetail = findViewById(R.id.tvEstadoConservacionDetail);
        TextView tvAtributoEspecifico1 = findViewById(R.id.tvAtributoEspecifico1);
        TextView tvAtributoEspecifico2 = findViewById(R.id.tvAtributoEspecifico2);
        TextView tvAtributoEspecifico3 = findViewById(R.id.tvAtributoEspecifico3);

        ivAnimalDetail.setImageResource(animal.getImageResourceId());
        tvEspecieDetail.setText(animal.getEspecie());
        tvNombreCientificoDetail.setText(animal.getNombreCientifico());
        tvHabitatDetail.setText(getString(R.string.habitat_format, animal.getHabitat()));
        tvPesoPromedioDetail.setText(getString(R.string.peso_promedio_format, animal.getPesoPromedio()));
        tvEstadoConservacionDetail.setText(getString(R.string.estado_conservacion_format, animal.getEstadoConservacion()));

        if (animal instanceof Mamifero) {
            Mamifero mamifero = (Mamifero) animal;
            tvAtributoEspecifico1.setVisibility(View.VISIBLE);
            tvAtributoEspecifico2.setVisibility(View.VISIBLE);
            tvAtributoEspecifico3.setVisibility(View.VISIBLE);

            tvAtributoEspecifico1.setText(getString(R.string.temperatura_corporal_format, mamifero.getTemperaturaCorporal()));
            tvAtributoEspecifico2.setText(getString(R.string.tiempo_gestacion_format, mamifero.getTiempoGestacion()));
            tvAtributoEspecifico3.setText(getString(R.string.alimentacion_format, mamifero.getAlimentacion()));
        } else if (animal instanceof AveRapaz) {
            AveRapaz aveRapaz = (AveRapaz) animal;
            Ave ave = (Ave) animal;
            
            tvAtributoEspecifico1.setVisibility(View.VISIBLE);
            tvAtributoEspecifico2.setVisibility(View.VISIBLE);
            tvAtributoEspecifico3.setVisibility(View.VISIBLE);

            tvAtributoEspecifico1.setText(getString(R.string.envergadura_alas_format, ave.getEnvergaduraAlas()));
            tvAtributoEspecifico2.setText(getString(R.string.velocidad_vuelo_format, aveRapaz.getVelocidadVuelo()));
            tvAtributoEspecifico3.setText(getString(R.string.tipo_presa_format, aveRapaz.getTipoPresa()));
        } else if (animal instanceof Ave) {
            Ave ave = (Ave) animal;
            tvAtributoEspecifico1.setVisibility(View.VISIBLE);
            tvAtributoEspecifico2.setVisibility(View.VISIBLE);
            tvAtributoEspecifico3.setVisibility(View.VISIBLE);

            tvAtributoEspecifico1.setText(getString(R.string.envergadura_alas_format, ave.getEnvergaduraAlas()));
            tvAtributoEspecifico2.setText(getString(R.string.color_plumaje_format, ave.getColorPlumaje()));
            tvAtributoEspecifico3.setText(getString(R.string.tipo_pico_format, ave.getTipoPico()));
        }
    }
} 