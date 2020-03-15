package com.rzt.carshopping.ui.recyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rzt.carshopping.R;
import com.rzt.carshopping.model.Carro;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListaCarrosAdapter extends RecyclerView.Adapter<ListaCarrosAdapter.ViewHolder> {

    private List<Carro> carros;
    private Context context;
    private OnItemClickListener onItemClickListener;

    public ListaCarrosAdapter(Context context, List<Carro> carros) {
        this.context = context;
        this.carros = carros;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.carro_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Carro carro = pegaCarroPorPosicao(position);
        holder.vincula(carro);
    }

    private Carro pegaCarroPorPosicao(int position) {
        return this.carros.get(position);
    }

    @Override
    public int getItemCount() {
        return this.carros.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView campoNome;
        private TextView campoPreco;
        private ImageView campoFoto;
        private Carro carro;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            campoNome = itemView.findViewById(R.id.tv_nome_carro);
            campoPreco = itemView.findViewById(R.id.tv_preco_carro);
            campoFoto = itemView.findViewById(R.id.label_foto_carro);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(carro);
                }
            });
        }

        public void vincula(Carro carro) {
            this.carro = carro;
            campoNome.setText(carro.getNome());
            campoPreco.setText(Integer.toString(carro.getPreco()));

            Picasso.with(context)
                    .load(carro.getImagem())
                    .error(R.drawable.img_unvailable)
                    .fit()
                    .centerInside()
                    .into(campoFoto);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Carro carro);
    }
}
