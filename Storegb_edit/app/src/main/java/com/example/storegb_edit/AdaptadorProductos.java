package com.example.storegb_edit;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.List;

public class AdaptadorProductos extends RecyclerView.Adapter<AdaptadorProductos.ProductosViewHolder> {

    Context context;
    ImageButton comprar;

    List<Productos>ListaProd;
    List<Productos>carroCompras;

    public AdaptadorProductos(Context context, ImageButton comprar, List<Productos> listaProd, List<Productos> carroCompras) {
        this.context = context;
        this.comprar = comprar;
        this.ListaProd = listaProd;
        this.carroCompras = carroCompras;
    }

    @NonNull
    @Override
    public ProductosViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_tv_productos,null,false);
        return new AdaptadorProductos.ProductosViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ProductosViewHolder holder, final int i) {
        holder.ropa.setText(ListaProd.get(i).getRopa());
        holder.descri.setText(ListaProd.get(i).getDescri());
        holder.PrecioProducto.setText("$"+ListaProd.get(i).getPrecioproducto());

        holder.cbBuy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(holder.cbBuy.isChecked()==true){
                    carroCompras.add(ListaProd.get(i));
                } else if(holder.cbBuy.isChecked()==false) {
                    carroCompras.remove(ListaProd.get(i));
                }
            }
        });

        comprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,CarroCompra.class);
                intent.putExtra("CarroCompras", (Serializable) carroCompras);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {

        return ListaProd.size();
    }

    public class ProductosViewHolder extends RecyclerView.ViewHolder {

        TextView ropa, descri, PrecioProducto;
        CheckBox cbBuy;

        public ProductosViewHolder(@NonNull View itemView) {
            super(itemView);

            ropa = itemView.findViewById(R.id.NomProducto);
            descri = itemView.findViewById(R.id.DesProducto);
            PrecioProducto = itemView.findViewById(R.id.PrecioProducto);

            cbBuy = itemView.findViewById(R.id.cbBuy);
        }
    }
}
