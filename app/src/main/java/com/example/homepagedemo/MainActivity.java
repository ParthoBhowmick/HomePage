package com.example.homepagedemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Gravity;
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

        drawer = findViewById(R.id.drawer_layout);
        ImageView img = findViewById(R.id.navIcon);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);

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

        Model model1_1 = new Model("Carmelita Badura", 1 , "Chief Executive Officer");
        Model model1_1_1 = new Model("Elisha Pickert", 2,"Accounts Manager");
        Model model1_1_2 = new Model("Patricia Netherton", 2,"Recruitment Manager");
        Model model1_1_3 = new Model("Christeen Petrey", 2,"Technology Manager ");
        Model model1_1_4 = new Model("Lolita Moreman", 2,"Store Manager");
        model1_1.models.add(model1_1_1);
        model1_1.models.add(model1_1_2);
        model1_1.models.add(model1_1_3);
        model1_1.models.add(model1_1_4);

        Model model1_2 = new Model("Manuela Kass", 1,"Chief Operating Officer");
        Model model1_2_1 = new Model("Roseanna Branham", 2,"Regional Managers");

        Model model1_2_1_1 = new Model("Dennise Lasso", 3,"Functional Managers");
        Model model1_2_1_2 = new Model("Sabrina Shively", 3,"Departmental Manager");
        Model model1_2_1_3 = new Model("Jin Haecker", 3,"Compensation and Benefits Manager");
        Model model1_2_1_4 = new Model("Season Parrett  ", 3,"General Manager");
        model1_2_1.models.add(model1_2_1_1);
        model1_2_1.models.add(model1_2_1_2);
        model1_2_1.models.add(model1_2_1_3);
        model1_2_1.models.add(model1_2_1_4);

        Model model1_2_2 = new Model("Vicky Parkhurst", 2,"IT Manager");
        Model model1_2_3 = new Model("Taisha Dragoo", 2,"Food Service Manager");
        Model model1_2_4 = new Model("Abbey Ballance", 2,"Medical Services Manager");
        model1_2.models.add(model1_2_1);
        model1_2.models.add(model1_2_2);
        model1_2.models.add(model1_2_3);
        model1_2.models.add(model1_2_4);

//        model1_2.models.add(model1_2_1);
//        model1_2.models.add(model1_2_2);
//        model1_1.models.add(model1_2_3);
//        model1_1.models.add(model1_2_4);


        Model model1_3 = new Model("Arlinda Fogal", 1,"Chief Financial Officer");

        Model model1_4 = new Model("Stephen Cabe", 1,"Chief Technology Officer");
        Model model1_4_1 = new Model("Cherilyn Lehn", 2,"Advertising Manager");
        Model model1_4_2 = new Model("Lashay Baumer", 2,"Affiliate Management Associate");
        Model model1_4_3 = new Model("Abbie Kilmer", 2,"Branch Manager");
        Model model1_4_4 = new Model("Clinton Boyers", 2,"Budget Manager");
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
}
