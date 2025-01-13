package com.example.projectbp3individu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MenuMakanan extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MenuAdapter menuAdapter;
    private List<MenuItem> menuList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_makanan);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        // Data Menu
        menuList = new ArrayList<>();
        menuList.add(new MenuItem("beef_teriyaki", "Beef Teriyaki", 30000, getString(R.string.deskripsi_beef_teriyaki)));
        menuList.add(new MenuItem("spaghetti", "Spaghetti", 25000, getString(R.string.deskripsi_spaghetti)));
        menuList.add(new MenuItem("chicken_steak", "Chicken Steak", 28000, getString(R.string.deskripsi_chicken_steak)));
        menuList.add(new MenuItem("chicken_katsu", "Chicken Katsu", 23000, getString(R.string.deskripsi_chicken_katsu)));
        menuList.add(new MenuItem("nasi_goreng", "Nasi Goreng", 20000, getString(R.string.deskripsi_nasi_goreng)));
        menuList.add(new MenuItem("ayam_penyet", "Ayam Penyet", 22000, getString(R.string.deskripsi_ayam_penyet)));

        // Adapter
        menuAdapter = new MenuAdapter(this, menuList, new MenuAdapter.OnMenuClickListener() {
            @Override
            public void onMenuClick(MenuItem menuItem) {
                // Kirim data ke DetailActivity
                Intent intent = new Intent(MenuMakanan.this, DetailActivity.class);
                intent.putExtra("name", menuItem.getName());
                intent.putExtra("image", menuItem.getImage());
                intent.putExtra("price", menuItem.getPrice());
                intent.putExtra("description", menuItem.getDescription());
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(menuAdapter);

        setupButtonNavigation();
        setupImageNavigation();
    }

    /**
     * Metode untuk menangani tombol navigasi
     */
    private void setupButtonNavigation() {
        Button btnKopi = findViewById(R.id.btnkopi);
        btnKopi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToActivity(MenuKopi.class);
            }
        });

        Button btnNon = findViewById(R.id.btnnon);
        btnNon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToActivity(MenuNonkopi.class);
            }
        });

        // Tombol kembali ke Beranda
        ImageView imageBack = findViewById(R.id.imageBack);
        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToActivity(Beranda.class);
                finish(); // Akhiri aktivitas saat ini
            }
        });
    }

    /**
     * Metode untuk menangani navigasi dengan ImageView
     */
    private void setupImageNavigation() {
        // Navigasi ke Beranda
        ImageView imageHome = findViewById(R.id.imageHome);
        imageHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToActivity(Beranda.class);
            }
        });

        // Navigasi ke About Us
        ImageView imageUser = findViewById(R.id.imageUser);
        imageUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToActivity(AboutUs.class);
            }
        });
    }

    /**
     * Metode untuk navigasi ke aktivitas lain
     * @param targetActivity Kelas aktivitas tujuan
     */
    private void navigateToActivity(Class<?> targetActivity) {
        Intent intent = new Intent(MenuMakanan.this, targetActivity);
        startActivity(intent);
    }
}