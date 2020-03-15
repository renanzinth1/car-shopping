package com.rzt.carshopping.callback;

import com.rzt.carshopping.model.Carro;

import java.util.List;

public interface CarroCallback {

    void onCarroReceived(List<Carro> carros);
}
