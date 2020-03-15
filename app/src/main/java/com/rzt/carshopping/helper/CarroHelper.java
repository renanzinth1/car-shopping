package com.rzt.carshopping.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.rzt.carshopping.DAO.ClienteDAO;
import com.rzt.carshopping.R;
import com.rzt.carshopping.callback.CarroCallback;
import com.rzt.carshopping.model.Carro;
import com.rzt.carshopping.ui.activity.DetalhesCarroActivity;
import com.rzt.carshopping.ui.activity.ListaCarrosActivity;
import com.rzt.carshopping.ui.recyclerview.adapter.ListaCarrosAdapter;

import java.util.List;

public class CarroHelper extends AppCompatActivity {

    private Context context;
    private ListaCarrosActivity activity;
    public ListaCarrosAdapter adapter;

    RecyclerView rvListaCarros;

    public CarroHelper(Context context, ListaCarrosActivity listarCarrosActivity) {
        this.context = context;
        this.activity = listarCarrosActivity;
        rvListaCarros = activity.findViewById(R.id.rv_lista_carros);
    }

    public void listarCarros(CarroCallback callback) {

        new ClienteDAO(context).todos(callback);

//        new ClienteDAO(context).todos(new CarroCallback() {
//            @Override
//            public void onCarroReceived(List<Carro> carros) {
//
//                adapter = new ListaCarrosAdapter(context, carros);
//                rvListaCarros.setAdapter(adapter);
//
//                adapter.setOnItemClickListener(new ListaCarrosAdapter.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(Carro carro) {
//                        Intent intent = new Intent(context, DetalhesCarroActivity.class);
//                        intent.putExtra("carro", carro);
//                        startActivity(intent);
//                    }
//                });
//            }
//        });
    }
}
