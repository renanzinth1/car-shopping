package com.rzt.carshopping.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.rzt.carshopping.R;

public class MainActivity extends AppCompatActivity {

    private Button btnListarCarros;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnListarCarros = findViewById(R.id.btn_listar_carros);

        listarCarrosAction();
    }

    private void listarCarrosAction() {

        btnListarCarros.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ListaCarrosActivity.class);
            startActivity(intent);
        });
    }
}
