package com.example.store_gb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaptadorCarroCompras extends RecyclerView.Adapter<AdaptadorCarroCompras.ProductosViewHolder> {

    Context context;
    TextView Total_Compra;
    double total=0;
    List<Productos>carroCompras;

    public AdaptadorCarroCompras(Context context, List<Productos> carroCompras, TextView total_compra) {
        this.context = context;
        this.carroCompras = carroCompras;
        this.Total_Compra = total_compra;

        for (int i = 0; i < carroCompras.size(); i++) {
            total = total + Double.parseDouble(""+carroCompras.get(i).getPrecioproducto());
        }

        Total_Compra.setText("$"+total);
    }


    @NonNull
    @Override
    public ProductosViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_carro_compras,null,false);
        return new AdaptadorCarroCompras.ProductosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductosViewHolder holder, int i) {
        holder.NomProducto.setText(carroCompras.get(i).getNomproducto());
        holder.DesProducto.setText(carroCompras.get(i).getDesproducto());
        holder.PrecioProducto.setText("$"+carroCompras.get(i).getPrecioproducto());
    }

    @Override
    public int getItemCount() {
        return carroCompras.size();
    }

    public class ProductosViewHolder extends RecyclerView.ViewHolder {
        TextView NomProducto, DesProducto, PrecioProducto;

        public ProductosViewHolder(@NonNull View itemView) {
            super(itemView);

            NomProducto = itemView.findViewById(R.id.NomProducto);
            DesProducto = itemView.findViewById(R.id.DesProducto);
            PrecioProducto = itemView.findViewById(R.id.PrecioProducto);
        }
    }
}
