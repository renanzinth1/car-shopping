package com.rzt.carshopping.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.rzt.carshopping.R;
import com.rzt.carshopping.callback.CarroCallback;
import com.rzt.carshopping.helper.CarroHelper;
import com.rzt.carshopping.model.Carro;
import com.rzt.carshopping.network.api.Api;
import com.rzt.carshopping.ui.recyclerview.adapter.ListaCarrosAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaCarrosActivity extends AppCompatActivity {

    private RecyclerView rvListaCarros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_carros);

        rvListaCarros = findViewById(R.id.rv_lista_carros);

        CarroHelper carrHelp = new CarroHelper(this, ListaCarrosActivity.this);

        carrHelp.listarCarros(new CarroCallback() {
            @Override
            public void onCarroReceived(List<Carro> carros) {

                ListaCarrosAdapter adapter = new ListaCarrosAdapter(getApplicationContext(), carros);
                rvListaCarros.setAdapter(adapter);

                adapter.setOnItemClickListener(new ListaCarrosAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(Carro carro) {
                        Intent intent = new Intent(ListaCarrosActivity.this, DetalhesCarroActivity.class);
                        intent.putExtra("carro", carro);
                        startActivity(intent);
                    }
                });
            }
        });

    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_carrinho, menu);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.menu_formulario_carrinho:
                Intent intent = new Intent(this, CarrinhoCompra.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
