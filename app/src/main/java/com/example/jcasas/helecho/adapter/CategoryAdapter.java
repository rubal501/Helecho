package com.example.jcasas.helecho.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.jcasas.helecho.R;

import java.util.ArrayList;

/**
 * Created by jcasas on 5/6/17.
 */

public class CategoryAdapter extends BaseAdapter {

    private ArrayList<String> categorias;
    private Context context;

    public CategoryAdapter(ArrayList<String> categorias, Context context) {
        this.categorias = categorias;
        this.context = context;
    }

    @Override
    public int getCount() {
        return categorias.size();
    }

    @Override
    public Object getItem(int position) {
        return categorias.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = LayoutInflater
                .from(this.context)
                .inflate(R.layout.item_category, parent, false);
        ((TextView) v.findViewById(R.id.categoryItem)).setText(categorias.get(position));
        return v;
    }
}
