package com.example.store_gb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    ImageButton comprar;
    RecyclerView productos;
    AdaptadorProductos adaptador;

    List<Productos> ListaProd = new ArrayList<>();
    List<Productos> carroCompras = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        comprar = findViewById(R.id.btnbuy);
        productos = findViewById(R.id.productos);
        productos.setLayoutManager(new GridLayoutManager(MainActivity2.this,1));


        ListaProd.add(new Productos("001","BLUSA","Talla:M    Color:Negro", 100));
        ListaProd.add(new Productos("002","FALDA","Talla:S    Color:Negro", 100));
        ListaProd.add(new Productos("003","CAMISA","Talla:L    Color:Negro", 100));
        ListaProd.add(new Productos("004","VESTIDO","Talla:M    Color:Negro", 100));
        ListaProd.add(new Productos("005","PLAYERA","Talla:XS    Color:Negro", 100));
        ListaProd.add(new Productos("006","SUETER","Talla:L    Color:Negro", 100));
        ListaProd.add(new Productos("007","CHAQUETA","Talla:XL    Color:Negro", 100));
        ListaProd.add(new Productos("008","BOTAS","Talla:23-25    Color:Negro", 100));
        ListaProd.add(new Productos("009","PANTALON","Talla:32    Color:Negro", 100));


        adaptador = new AdaptadorProductos(MainActivity2.this,comprar,ListaProd,carroCompras);
        productos.setAdapter(adaptador);

    }

    public void showMenu(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_menu);
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item){
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(this,"Mujeres Seleccionado", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                Toast.makeText(this,"Hombres Seleccionado", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }
    }
}