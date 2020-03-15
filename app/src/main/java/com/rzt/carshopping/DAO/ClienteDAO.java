package com.rzt.carshopping.DAO;

import android.content.Context;
import android.widget.Toast;

import com.rzt.carshopping.callback.CarroCallback;
import com.rzt.carshopping.model.Carro;
import com.rzt.carshopping.network.api.Api;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClienteDAO {

    private Api api;
    private Context context;

    public ClienteDAO(Context context) {
        this.api = new Api();
        this.context = context;
    }

    public void todos(CarroCallback callback) {

        Call<List<Carro>> call = api.getCarService().listar();

        call.enqueue(new Callback<List<Carro>>() {
            @Override
            public void onResponse(Call<List<Carro>> call, Response<List<Carro>> response) {

                callback.onCarroReceived(response.body());

            }

            @Override
            public void onFailure(Call<List<Carro>> call, Throwable t) {

                Toast.makeText(context,
                        "Informação mal sucedida: " + t.getMessage(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
