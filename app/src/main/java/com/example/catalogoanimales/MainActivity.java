package com.example.catalogoanimales;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.catalogoanimales.adapter.AnimalAdapter;
import com.example.catalogoanimales.api.AnimalService;
import com.example.catalogoanimales.api.RetrofitClient;
import com.example.catalogoanimales.model.Animal;
import com.example.catalogoanimales.api.AnimalResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private List<Animal> animales;
    private RecyclerView recyclerView;
    private AnimalAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnVerCatalogo = findViewById(R.id.btnVerCatalogo);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        animales = new ArrayList<>();
        adapter = new AnimalAdapter(this, animales);
        recyclerView.setAdapter(adapter);

        btnVerCatalogo.setOnClickListener(v -> {
            loadAnimales();
            recyclerView.setVisibility(View.VISIBLE);
        });
    }

    private void loadAnimales() {
        AnimalService service = RetrofitClient.getInstance().create(AnimalService.class);
        Call<AnimalResponse> call = service.getAnimales();

        call.enqueue(new Callback<AnimalResponse>() {
            @Override
            public void onResponse(Call<AnimalResponse> call, Response<AnimalResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    animales.clear();
                    animales.addAll(response.body().getAnimales());
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(MainActivity.this, "Error al cargar los animales", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AnimalResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error de conexión: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}