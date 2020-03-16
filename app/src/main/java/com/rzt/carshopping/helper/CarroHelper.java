package com.rzt.carshopping.helper;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.rzt.carshopping.DAO.CarroDAO;
import com.rzt.carshopping.R;
import com.rzt.carshopping.callback.CarroCallback;
import com.rzt.carshopping.model.Carro;
import com.rzt.carshopping.ui.recyclerview.adapter.ListaCarrosAdapter;
import com.rzt.carshopping.util.PicassoUtil;

public class CarroHelper {

    private Context context;
    private Activity activity;
    public ListaCarrosAdapter adapter;

    RecyclerView rvListaCarros;
    ImageView campoFoto;
    TextView campoNome;
    TextView campoMarca;
    TextView campoPreco;
    TextView campoDescricao;
    TextView campoQuantidade;

    public CarroHelper(Context context, Activity activity) {
        this.context = context;
        this.activity = activity;

        rvListaCarros = activity.findViewById(R.id.rv_lista_carros);
        campoFoto = activity.findViewById(R.id.iv_imagem_detahe_carro);
        campoNome = activity.findViewById(R.id.tv_nome_detalhe_carro);
        campoMarca = activity.findViewById(R.id.tv_marca_detalhe_carro);
        campoPreco = activity.findViewById(R.id.tv_preco_detalhe_carro);
        campoDescricao = activity.findViewById(R.id.tv_descricao_detalhe_carro);
        campoQuantidade = activity.findViewById(R.id.tv_quantidade_detalhe_carro);
    }

    public void listarCarros(CarroCallback callback) {

        new CarroDAO(context).todos(callback);

    }

    public void mostrarInformacao(Carro carro) {

        new PicassoUtil(context, campoFoto).carregarImagemCarro(carro);

        campoNome.setText(carro.getNome());
        campoMarca.setText(carro.getMarca());
        campoPreco.setText(Integer.toString(carro.getPreco()));
        campoDescricao.setText(carro.getDescricao());
        campoQuantidade.setText(Integer.toString(carro.getQuantidade()));
    }
}
