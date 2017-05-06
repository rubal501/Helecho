package com.example.jcasas.helecho;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.jcasas.helecho.fragment.CategoryFragment;
import com.example.jcasas.helecho.fragment.HomeFragment;
import com.example.jcasas.helecho.fragment.ProfileFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private NavigationView navView;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buildUi();
    }

    private void buildUi() {
        toolbar = (Toolbar) findViewById(R.id.mainToolbar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navView = (NavigationView) findViewById(R.id.nvView);
        setupNavContent(navView);
        FragmentManager fm = getSupportFragmentManager();
        try {
            fm.beginTransaction().add(R.id.flContent, HomeFragment.class.newInstance()).commit();
            setTitle("Inicio");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupNavContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectDrawerItem(item);
                return true;
            }
        });
    }

    private void selectDrawerItem(MenuItem item) {
        Fragment f = null;
        Class fragmentClass = HomeFragment.class;
        switch (item.getItemId()) {
            case R.id.navHome:
                fragmentClass = HomeFragment.class;
                break;
            case R.id.navCategory:
                fragmentClass = CategoryFragment.class;
                break;
            case R.id.navProfile:
                fragmentClass = ProfileFragment.class;
                break;
            case R.id.navPurchases:
                Toast.makeText(this, "Aún no implementado", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navSells:
                Toast.makeText(this, "Aún no implementado", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navLogout:
                startActivity(new Intent(this, LoginActivity.class));
                finish();
                break;
            case R.id.navAbout:
                showInfoAlert();
                break;
            default: fragmentClass = HomeFragment.class;
        }
        try {
            f = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, f).commit();

        item.setChecked(true);
        setTitle(item.getTitle());
        drawerLayout.closeDrawers();
    }

    private void showInfoAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Acerca de Helecho");
        builder.setIcon(R.drawable.logo);
        builder.setMessage("Helecho alpha preview\nTodos los derechos reservados, 2017");
        builder.setNegativeButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
