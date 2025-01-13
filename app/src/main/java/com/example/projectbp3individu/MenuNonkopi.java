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

public class MenuNonkopi extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MenuAdapter menuAdapter;
    private List<MenuItem> menuList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_nonkopi);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        // Data Menu
        menuList = new ArrayList<>();
        menuList.add(new MenuItem("matcha_latte", "Green Tea", 30000, getString(R.string.deskripsi_green_tea_latte)));
        menuList.add(new MenuItem("red_velvet", "Red Velvet", 25000, getString(R.string.deskripsi_red_velvet_latte)));
        menuList.add(new MenuItem("coklat_hazelnut", "Chocolate Hazelnut", 28000, getString(R.string.deskripsi_chocolate_hazelnut)));
        menuList.add(new MenuItem("strawberry_milkshake", "Strawberry Milk", 23000, getString(R.string.deskripsi_strawberry_milkshake)));
        menuList.add(new MenuItem("strawberry_milkshake", "Strawberry Milk", 20000, getString(R.string.deskripsi_strawberry_milkshake)));
        menuList.add(new MenuItem("coklat_hazelnut", "Chocolate Hazelnut", 22000, getString(R.string.deskripsi_chocolate_hazelnut)));

        // Adapter
        menuAdapter = new MenuAdapter(this, menuList, new MenuAdapter.OnMenuClickListener() {
            @Override
            public void onMenuClick(MenuItem menuItem) {
                // Kirim data ke DetailActivity
                Intent intent = new Intent(MenuNonkopi.this, DetailActivity.class);
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

        Button btnMakanan = findViewById(R.id.btnmakanan);
        btnMakanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToActivity(MenuMakanan.class);
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
        Intent intent = new Intent(MenuNonkopi.this, targetActivity);
        startActivity(intent);
    }
}