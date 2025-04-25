package com.example.catalogoanimales.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Animal implements Serializable {
    @SerializedName("id")
    private int id;

    @SerializedName("especie")
    private String especie;

    @SerializedName("nombreCientifico")  // <-- este nombre debe coincidir con el JSON
    private String nombreCientifico;

    @SerializedName("habitat")
    private String habitat;

    @SerializedName("pesoPromedio")  // <-- corregido
    private double pesoPromedio;

    @SerializedName("estadoConservacion")  // <-- corregido
    private String estadoConservacion;

    @SerializedName("img")
    private String img;

    @SerializedName("tipo")
    private String tipoAnimal;

    @SerializedName("temperaturaCorporal")
    private double temperaturaCorporal;

    @SerializedName("tiempoGestacion")
    private int tiempoGestacion;

    @SerializedName("alimentacion")
    private String alimentacion;

    public int getId() { return id; }
    public String getEspecie() { return especie; }
    public String getNombreCientifico() { return nombreCientifico; }
    public String getHabitat() { return habitat; }
    public double getPesoPromedio() { return pesoPromedio; }
    public String getEstadoConservacion() { return estadoConservacion; }
    public String getImg() { return img; }
    public String getTipoAnimal() { return tipoAnimal; }
    public double getTemperaturaCorporal() { return temperaturaCorporal; }
    public int getTiempoGestacion() { return tiempoGestacion; }
    public String getAlimentacion() { return alimentacion; }
}
