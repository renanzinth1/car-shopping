package com.rzt.carshopping.util;

import android.content.Context;
import android.widget.ImageView;

import com.rzt.carshopping.R;
import com.rzt.carshopping.model.Carro;
import com.squareup.picasso.Picasso;

public class PicassoUtil {

    private Context context;
    private ImageView campoFoto;

    public PicassoUtil() {
    }

    public PicassoUtil(Context context, ImageView campoFoto) {
        this.context = context;
        this.campoFoto = campoFoto;
    }

    public void carregarImagemCarro(Carro carro) {
        Picasso.with(context)
                .load(carro.getImagem())
                .error(R.drawable.img_unvailable)
                .fit()
                .centerInside()
                .into(campoFoto);
    }
}

