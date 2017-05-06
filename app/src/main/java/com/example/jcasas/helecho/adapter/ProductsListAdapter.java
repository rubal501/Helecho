package com.example.jcasas.helecho.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jcasas.helecho.R;
import com.example.jcasas.helecho.model.Producto;

import java.util.ArrayList;

/**
 * Created by jcasas on 5/6/17.
 */

public class ProductsListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Producto> productos;
    private int[] images = {R.drawable.g2, R.drawable.j2, R.drawable.j1};

    public ProductsListAdapter(Context context, ArrayList<Producto> productos) {
        this.context = context;
        this.productos = productos;
    }
    @Override
    public int getCount() {
        return productos.size();
    }

    @Override
    public Object getItem(int position) {
        return productos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(context).inflate(R.layout.product_item,parent,false);
        Producto p = productos.get(position);
        ImageView imagen = (ImageView) v.findViewById(R.id.productItemImage);
        TextView precio = (TextView) v.findViewById(R.id.productItemPrice);
        TextView titulo = (TextView) v.findViewById(R.id.productItemTitle);
        TextView descripcion = (TextView) v.findViewById(R.id.productItemDescription);
        imagen.setImageDrawable(context.getResources().getDrawable(images[position]));
        precio.setText("$" + String.format("%2.2f ",new Double(p.getPrecio())));
        titulo.setText(p.getNombre());
        descripcion.setText(p.getDescripcion());
        return v;
    }
}
