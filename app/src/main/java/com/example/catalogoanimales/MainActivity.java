package com.example.catalogoanimales;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.catalogoanimales.adapter.AnimalAdapter;
import com.example.catalogoanimales.model.Animal;
import com.example.catalogoanimales.model.Ave;
import com.example.catalogoanimales.model.AveRapaz;
import com.example.catalogoanimales.model.Mamifero;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<Animal> animales;
    private RecyclerView recyclerView;
    private AnimalAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnVerCatalogo = findViewById(R.id.btnVerCatalogo);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        initializeAnimalList();
        adapter = new AnimalAdapter(this, animales);
        recyclerView.setAdapter(adapter);

        btnVerCatalogo.setOnClickListener(v -> {
            recyclerView.setVisibility(View.VISIBLE);
        });
    }

    private void initializeAnimalList() {
        animales = new ArrayList<>();

        // Mamíferos
        animales.add(new Mamifero(
            "León", "Panthera leo", "Sabana africana",
            190.0, "Vulnerable", R.drawable.leon,
            37.5, 110, "Carnívoro"
        ));

        animales.add(new Mamifero(
            "Elefante africano", "Loxodonta africana", "Sabana y bosques africanos",
            5000.0, "Vulnerable", R.drawable.elefante,
            37.0, 660, "Herbívoro"
        ));

        animales.add(new Mamifero(
            "Oso pardo", "Ursus arctos", "Bosques y montañas",
            300.0, "Preocupación menor", R.drawable.oso,
            37.0, 180, "Omnívoro"
        ));

        // Aves
        animales.add(new Ave(
            "Tucán", "Ramphastidae", "Selvas tropicales",
            0.5, "Preocupación menor", R.drawable.tucan,
            0.4, "Negro y amarillo", "Grande y curvo"
        ));

        animales.add(new Ave(
            "Loro gris africano", "Psittacus erithacus", "Selvas tropicales",
            0.4, "En peligro", R.drawable.loro,
            0.5, "Gris y rojo", "Ganchudo y fuerte"
        ));

        // Aves rapaces
        animales.add(new AveRapaz(
            "Águila real", "Aquila chrysaetos", "Montañas y bosques",
            4.5, "Preocupación menor", R.drawable.aguila,
            2.3, "Marrón dorado", "Ganchudo",
            320.0, "Mamíferos pequeños y aves"
        ));

        animales.add(new AveRapaz(
            "Halcón peregrino", "Falco peregrinus", "Diversos hábitats",
            1.0, "Preocupación menor", R.drawable.halcon,
            1.1, "Gris azulado", "Ganchudo",
            390.0, "Aves medianas"
        ));

        // Nueva ave rapaz
        animales.add(new AveRapaz(
            "Búho real", "Bubo bubo", "Bosques y montañas",
            2.5, "Preocupación menor", R.drawable.buho,
            1.8, "Marrón y gris", "Ganchudo",
            80.0, "Pequeños mamíferos y aves"
        ));
    }
}