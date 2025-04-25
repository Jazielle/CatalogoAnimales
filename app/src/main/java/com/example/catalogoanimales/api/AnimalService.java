package com.example.catalogoanimales.api;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AnimalService {
    @GET("animales.json")
    Call<AnimalResponse> getAnimales();
}
