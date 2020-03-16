package com.rzt.carshopping.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rzt.carshopping.R;
import com.rzt.carshopping.helper.CarroHelper;
import com.rzt.carshopping.model.Carro;
import com.squareup.picasso.Picasso;

public class DetalhesCarroActivity extends AppCompatActivity {

    CarroHelper carrHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_carro);

        Intent intent = getIntent();

        if(intent.hasExtra("carro")) {

            Carro carro = (Carro) intent.getSerializableExtra("carro");

            carrHelp = new CarroHelper(this, this);

            carrHelp.mostrarInformacao(carro);
        }
    }
}
