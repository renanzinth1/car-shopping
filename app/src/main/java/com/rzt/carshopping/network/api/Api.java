package com.rzt.carshopping.network.api;

import com.rzt.carshopping.network.service.CarService;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class Api {

    private Retrofit retrofit;

    public Api() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://desafiobrq.herokuapp.com/v1/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public CarService getCarService() {
        return retrofit.create(CarService.class);
    }
}
