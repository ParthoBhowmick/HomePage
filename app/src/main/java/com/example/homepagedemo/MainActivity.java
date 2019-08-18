package com.example.homepagedemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

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

        Model model1_1 = new Model("Carmelita Badura", 1 );
        Model model1_1_1 = new Model("Elisha Pickert", 2);
        Model model1_1_2 = new Model("Patricia Netherton", 2);
        Model model1_1_3 = new Model("Christeen Petrey", 2);
        Model model1_1_4 = new Model("Lolita Moreman", 2);
        model1_1.models.add(model1_1_1);
        model1_1.models.add(model1_1_2);
        model1_1.models.add(model1_1_3);
        model1_1.models.add(model1_1_4);

        Model model1_2 = new Model("Manuela Kass", 1);
        Model model1_2_1 = new Model("Roseanna Branham", 2);

        Model model1_2_1_1 = new Model("Dennise Lasso", 3);
        Model model1_2_1_2 = new Model("Sabrina Shively", 3);
        Model model1_2_1_3 = new Model("Jin Haecker", 3);
        Model model1_2_1_4 = new Model("Season Parrett  ", 3);
        model1_2_1.models.add(model1_2_1_1);
        model1_2_1.models.add(model1_2_1_2);
        model1_2_1.models.add(model1_2_1_3);
        model1_2_1.models.add(model1_2_1_4);

        Model model1_2_2 = new Model("Vicky Parkhurst", 2);
        Model model1_2_3 = new Model("Taisha Dragoo", 2);
        Model model1_2_4 = new Model("Abbey Ballance", 2);
        model1_2.models.add(model1_2_1);
        model1_2.models.add(model1_2_2);
        model1_2.models.add(model1_2_3);
        model1_2.models.add(model1_2_4);



        Model model1_3 = new Model("Arlinda Fogal", 1);

        Model model1_4 = new Model("Stephen Cabe", 1);
        Model model1_4_1 = new Model("Cherilyn Lehn", 2);
        Model model1_4_2 = new Model("Lashay Baumer", 2);
        Model model1_4_3 = new Model("Abbie Kilmer", 2);
        Model model1_4_4 = new Model("Clinton Boyers", 2);
        model1_4.models.add(model1_4_1);
        model1_4.models.add(model1_4_2);
        model1_4.models.add(model1_4_3);
        model1_4.models.add(model1_4_4);

        models.add(model1_1);
        models.add(model1_2);
        models.add(model1_3);
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
