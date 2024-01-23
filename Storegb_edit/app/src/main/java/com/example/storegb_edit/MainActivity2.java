package com.example.storegb_edit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    ImageButton comprar;
    RecyclerView productos;
    AdaptadorProductos adaptador;

    List<Productos> ListaProd = new ArrayList<>();
    List<Productos> carroCompras = new ArrayList<>();


    String[] ropa = {"BLUSA", "PANTALON", "CAMISA", "CHAQUETA", "VESTIDO", "FALDA", "SUETER", "BOTAS", "PLAYERA"};
    String[] descri = {"Talla:M   Color:Negro","Talla:XS   Color:Rojo","Talla:XL   Color:Blanco","Talla:S   Color:Gris", "Talla:L   Color:Negro"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        comprar = findViewById(R.id.btnbuy);
        productos = findViewById(R.id.productos);
        productos.setLayoutManager(new GridLayoutManager(MainActivity2.this,1));


        Random rnd = new Random();
        DecimalFormat df = new DecimalFormat("###.##");
        for(int i=0; ListaProd.size() <= 50; i++) {
            int rop = (int) (rnd.nextDouble() * 9);
            int des= (int) (rnd.nextDouble() * 5);
            double pre= rnd.nextDouble()*1000;
            ListaProd.add(new Productos(ropa[rop], descri[des], Double.parseDouble(df.format(pre))));
        }


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