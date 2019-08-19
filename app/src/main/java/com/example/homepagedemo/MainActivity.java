package com.example.homepagedemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.google.android.material.bottomnavigation.BottomNavigationView;


import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawer;

    RecyclerView rvList;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BottomNavigationView bottomNav =  findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        drawer = findViewById(R.id.drawer_layout);
        ImageView img = findViewById(R.id.navIcon);



//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        toggle.setDrawerIndicatorEnabled(false);
//        toolbar.setNavigationIcon(R.drawable.ic_menu);
//
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(GravityCompat.START);
            }
        });

        rvList = findViewById(R.id.drawer_recycler);
        adapter = new Adapter(this);
        rvList.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rvList.setAdapter(adapter);
        adapter.setData(getList());

    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public ArrayList<Model> getList() {

        ArrayList<Model> models = new ArrayList<>();

        Model model1_3 = new Model("Shop", 1);

        Model model1_1 = new Model("Flash Discount Offer", 1 );
        Model model1_1_1 = new Model("20% Discount", 2);
        Model model1_1_2 = new Model("30% Discount", 2);
        Model model1_1_3 = new Model("50% Discount", 2);

        model1_1.models.add(model1_1_1);
        model1_1.models.add(model1_1_2);
        model1_1.models.add(model1_1_3);

        Model model1_2 = new Model("Kids & Mom", 1);
        Model model1_2_1 = new Model("Infants", 2);



        Model model1_2_1_1 = new Model("Baby Walker", 3);
        Model model1_2_1_2 = new Model("Baby Feeder", 3);
        Model model1_2_1_3 = new Model("Bottle Cleaning Brush", 3);
        Model model1_2_1_4 = new Model("Cap", 3);
        Model model1_2_1_5 = new Model("Dress", 3);
        model1_2_1.models.add(model1_2_1_1);
        model1_2_1.models.add(model1_2_1_2);
        model1_2_1.models.add(model1_2_1_3);
        model1_2_1.models.add(model1_2_1_4);
        model1_2_1.models.add(model1_2_1_5);


        Model model1_2_2 = new Model("Kids", 2);
        Model model1_2_2_1 = new Model("Baby Gear", 3);
        Model model1_2_2_2 = new Model("Baby Hair Decoration", 3);
        Model model1_2_2_3 = new Model("Baby Socks", 3);
        Model model1_2_2_4 = new Model("Children Cycle", 3);

        model1_2_2.models.add(model1_2_2_1);
        model1_2_2.models.add(model1_2_2_2);
        model1_2_2.models.add(model1_2_2_3);
        model1_2_2.models.add(model1_2_2_4);

        model1_2.models.add(model1_2_1);
        model1_2.models.add(model1_2_2);


        Model model1_4 = new Model("Home Decor", 1);
        Model model1_4_1 = new Model("Home Textile", 2);
        Model model1_4_1_1 = new Model("Floor Mat", 3);
        Model model1_4_1_2 = new Model("Bed Sheet", 3);
        Model model1_4_1_3 = new Model("Pillow & Cushion", 3);
        Model model1_4_1_4 = new Model("Blanket", 3);
        Model model1_4_1_5 = new Model("Curtains", 3);

        model1_4_1.models.add(model1_4_1_1);
        model1_4_1.models.add(model1_4_1_2);
        model1_4_1.models.add(model1_4_1_3);
        model1_4_1.models.add(model1_4_1_4);
        model1_4_1.models.add(model1_4_1_5);

        Model model1_4_2 = new Model("Furniture", 2);
        Model model1_4_3 = new Model("Wall Decor", 2);
        model1_4.models.add(model1_4_1);
        model1_4.models.add(model1_4_2);
        model1_4.models.add(model1_4_3);

        models.add(model1_3);
        models.add(model1_1);
        models.add(model1_2);
        models.add(model1_4);

        return models;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    switch (menuItem.getItemId()) {
                        case R.id.bottom_nav_acc :
                            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                            startActivity(intent);
                            break;
                    }

                    return true;
                }
            };
}
