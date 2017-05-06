package com.example.jcasas.helecho;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.example.jcasas.helecho.adapter.ProductsListAdapter;
import com.example.jcasas.helecho.model.Producto;

import java.util.ArrayList;
import java.util.List;

public class ProductsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ArrayList<Producto> productos;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        toolbar = (Toolbar) findViewById(R.id.productsToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.toolbar_products);
        productos = new ArrayList<>();
        productos.add(new Producto("1","Traste de plástico reciclado",100, 499.99, "Traste de plástico para usos varios (no se use para alimetación)","contenedores"));
        productos.add(new Producto("2", "Silla de cartón reciclado", 20, 1200.00,"Silla de cartón reciclado", "muebles"));
        productos.add(new Producto("3", "Luminaria de material reciclado",30, 200.0,"Luminaria de material reciclado", "iluminacion"));
        listView = (ListView) findViewById(R.id.productsList);
        listView.setAdapter(new ProductsListAdapter(this, productos));
    }
}
