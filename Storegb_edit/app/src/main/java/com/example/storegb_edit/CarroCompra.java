package com.example.storegb_edit;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CarroCompra extends AppCompatActivity {

    List<Productos> carroCompras;

    AdaptadorCarroCompras adaptador;

    RecyclerView productoscomprados;
    TextView Total_Compra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carro_compra);

        carroCompras = (List<Productos>) getIntent().getSerializableExtra("CarroCompras");

        productoscomprados = findViewById(R.id.productoscomprados);
        productoscomprados.setLayoutManager(new GridLayoutManager(CarroCompra.this, 1));
        Total_Compra = findViewById(R.id.Total_Compra);

        adaptador = new AdaptadorCarroCompras(CarroCompra.this, carroCompras, Total_Compra);
        productoscomprados.setAdapter(adaptador);
    }
}
