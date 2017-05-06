package com.example.jcasas.helecho.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.jcasas.helecho.ProductsActivity;
import com.example.jcasas.helecho.R;
import com.example.jcasas.helecho.adapter.CategoryAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {

    ListView list;
    View mainView;

    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mainView = inflater.inflate(R.layout.fragment_category, container, false);
        buildUi();
        return mainView;
    }

    private void buildUi() {
        list = (ListView) mainView.findViewById(R.id.categoryList);
        ArrayList<String> categories = new ArrayList<>();
        categories.add(getResources().getString(R.string.category_sofa));
        categories.add(getResources().getString(R.string.category_room));
        categories.add(getResources().getString(R.string.category_containers));
        categories.add(getResources().getString(R.string.category_tables));
        categories.add(getResources().getString(R.string.category_illumination));
        categories.add(getResources().getString(R.string.category_accessory));
        list.setDivider(null);
        list.setDividerHeight(0);
        list.setAdapter(new CategoryAdapter(categories, getActivity()));
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getActivity(), ProductsActivity.class));

            }
        });
    }



}
