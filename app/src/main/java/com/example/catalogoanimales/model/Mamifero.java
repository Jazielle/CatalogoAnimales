package com.example.catalogoanimales.model;

public class Mamifero extends Animal {
    private double temperaturaCorporal;
    private int tiempoGestacion;
    private String alimentacion;

    public Mamifero(String especie, String nombreCientifico, String habitat,
                    double pesoPromedio, String estadoConservacion, int imageResourceId,
                    double temperaturaCorporal, int tiempoGestacion, String alimentacion) {
        super(especie, nombreCientifico, habitat, pesoPromedio, estadoConservacion, imageResourceId);
        this.temperaturaCorporal = temperaturaCorporal;
        this.tiempoGestacion = tiempoGestacion;
        this.alimentacion = alimentacion;
    }

    // Getters
    public double getTemperaturaCorporal() { return temperaturaCorporal; }
    public int getTiempoGestacion() { return tiempoGestacion; }
    public String getAlimentacion() { return alimentacion; }

    // Setters
    public void setTemperaturaCorporal(double temperaturaCorporal) { this.temperaturaCorporal = temperaturaCorporal; }
    public void setTiempoGestacion(int tiempoGestacion) { this.tiempoGestacion = tiempoGestacion; }
    public void setAlimentacion(String alimentacion) { this.alimentacion = alimentacion; }
} 