package com.example.catalogoanimales.model;

public class Ave extends Animal {
    private double envergaduraAlas;
    private String colorPlumaje;
    private String tipoPico;

    public Ave(String especie, String nombreCientifico, String habitat,
               double pesoPromedio, String estadoConservacion, int imageResourceId,
               double envergaduraAlas, String colorPlumaje, String tipoPico) {
        super(especie, nombreCientifico, habitat, pesoPromedio, estadoConservacion, imageResourceId);
        this.envergaduraAlas = envergaduraAlas;
        this.colorPlumaje = colorPlumaje;
        this.tipoPico = tipoPico;
    }

    // Getters
    public double getEnvergaduraAlas() { return envergaduraAlas; }
    public String getColorPlumaje() { return colorPlumaje; }
    public String getTipoPico() { return tipoPico; }

    // Setters
    public void setEnvergaduraAlas(double envergaduraAlas) { this.envergaduraAlas = envergaduraAlas; }
    public void setColorPlumaje(String colorPlumaje) { this.colorPlumaje = colorPlumaje; }
    public void setTipoPico(String tipoPico) { this.tipoPico = tipoPico; }
} 