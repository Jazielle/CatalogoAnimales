package com.example.catalogoanimales.model;

public class AveRapaz extends Ave {
    private double velocidadVuelo;
    private String tipoPresa;

    public AveRapaz(String especie, String nombreCientifico, String habitat,
                    double pesoPromedio, String estadoConservacion, int imageResourceId,
                    double envergaduraAlas, String colorPlumaje, String tipoPico,
                    double velocidadVuelo, String tipoPresa) {
        super(especie, nombreCientifico, habitat, pesoPromedio, estadoConservacion, 
              imageResourceId, envergaduraAlas, colorPlumaje, tipoPico);
        this.velocidadVuelo = velocidadVuelo;
        this.tipoPresa = tipoPresa;
    }

    // Getters
    public double getVelocidadVuelo() { return velocidadVuelo; }
    public String getTipoPresa() { return tipoPresa; }

    // Setters
    public void setVelocidadVuelo(double velocidadVuelo) { this.velocidadVuelo = velocidadVuelo; }
    public void setTipoPresa(String tipoPresa) { this.tipoPresa = tipoPresa; }
} 