package com.rzt.carshopping.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rzt.carshopping.R;
import com.rzt.carshopping.model.Carro;
import com.squareup.picasso.Picasso;

public class DetalhesCarroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_carro);

        Intent intent = getIntent();
        if(intent.hasExtra("carro")) {

            Carro carro = (Carro) intent.getSerializableExtra("carro");

            ImageView campoFoto = findViewById(R.id.iv_imagem_detahe_carro);
            TextView campoNome = findViewById(R.id.tv_nome_detalhe_carro);
            TextView campoMarca = findViewById(R.id.tv_marca_detalhe_carro);
            TextView campoPreco = findViewById(R.id.tv_preco_detalhe_carro);
            TextView campoDescricao = findViewById(R.id.tv_descricao_detalhe_carro);
            TextView campoQuantidade = findViewById(R.id.tv_quantidade_detalhe_carro);

            Picasso.with(this)
                    .load(carro.getImagem())
                    .error(R.drawable.img_unvailable)
                    .fit()
                    .centerCrop()
                    .into(campoFoto);

            campoNome.setText(carro.getNome());
            campoMarca.setText(carro.getMarca());
            campoPreco.setText(Integer.toString(carro.getPreco()));
            campoDescricao.setText(carro.getDescricao());
            campoQuantidade.setText(Integer.toString(carro.getQuantidade()));
        }

    }
}
