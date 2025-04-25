package com.example.catalogoanimales.api;


import java.util.List;
import com.example.catalogoanimales.model.Animal;


public class AnimalResponse {
    private int page;
    private int total;
    private String status;
    private List<Animal> animales;

    public List<Animal> getAnimales() {
        return animales;
    }
}

