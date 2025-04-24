package com.example.catalogoanimales.model;

public class Animal {
    private String especie;
    private String nombreCientifico;
    private String habitat;
    private double pesoPromedio;
    private String estadoConservacion;
    private int imageResourceId;

    public Animal(String especie, String nombreCientifico, String habitat, 
                 double pesoPromedio, String estadoConservacion, int imageResourceId) {
        this.especie = especie;
        this.nombreCientifico = nombreCientifico;
        this.habitat = habitat;
        this.pesoPromedio = pesoPromedio;
        this.estadoConservacion = estadoConservacion;
        this.imageResourceId = imageResourceId;
    }

    // Getters
    public String getEspecie() { return especie; }
    public String getNombreCientifico() { return nombreCientifico; }
    public String getHabitat() { return habitat; }
    public double getPesoPromedio() { return pesoPromedio; }
    public String getEstadoConservacion() { return estadoConservacion; }
    public int getImageResourceId() { return imageResourceId; }

    // Setters
    public void setEspecie(String especie) { this.especie = especie; }
    public void setNombreCientifico(String nombreCientifico) { this.nombreCientifico = nombreCientifico; }
    public void setHabitat(String habitat) { this.habitat = habitat; }
    public void setPesoPromedio(double pesoPromedio) { this.pesoPromedio = pesoPromedio; }
    public void setEstadoConservacion(String estadoConservacion) { this.estadoConservacion = estadoConservacion; }
    public void setImageResourceId(int imageResourceId) { this.imageResourceId = imageResourceId; }
} 