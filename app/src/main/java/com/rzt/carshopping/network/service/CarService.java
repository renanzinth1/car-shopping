package com.rzt.carshopping.network.service;

import com.rzt.carshopping.model.Carro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CarService {

    @GET("carro")
    Call<List<Carro>> listar();

    @GET("carro/{id}")
    Call<Carro> buscaPorId(@Path("id") Long id);
}
