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

public class MenuKopi extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MenuAdapter menuAdapter;
    private List<MenuItem> menuList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_kopi);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        // Data Menu
        menuList = new ArrayList<>();
        menuList.add(new MenuItem("espresso", "Espresso", 30000, getString(R.string.deskripsi_espresso)));
        menuList.add(new MenuItem("americano", "Americano", 25000, getString(R.string.deskripsi_americano)));
        menuList.add(new MenuItem("cappucino", "Cappuccino", 28000, getString(R.string.deskripsi_cappuccino)));
        menuList.add(new MenuItem("latte", "Latte", 23000, getString(R.string.deskripsi_latte)));
        menuList.add(new MenuItem("mocha", "Mocha", 20000, getString(R.string.deskripsi_mocha)));
        menuList.add(new MenuItem("machiato", "Macchiato", 22000, getString(R.string.deskripsi_macchiato)));

        // Adapter
        menuAdapter = new MenuAdapter(this, menuList, new MenuAdapter.OnMenuClickListener() {
            @Override
            public void onMenuClick(MenuItem menuItem) {
                // Kirim data ke DetailActivity
                Intent intent = new Intent(MenuKopi.this, DetailActivity.class);
                intent.putExtra("name", menuItem.getName());
                intent.putExtra("image", menuItem.getImage());
                intent.putExtra("price", menuItem.getPrice());
                intent.putExtra("description", menuItem.getDescription());
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(menuAdapter);

        // Setup tombol navigasi
        setupButtonNavigation();
        setupImageNavigation(); // Tambahkan navigasi untuk ImageView
    }

    /**
     * Metode untuk menangani tombol navigasi
     */
    private void setupButtonNavigation() {
        Button btnMakanan = findViewById(R.id.btnmakanan);
        btnMakanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToActivity(MenuMakanan.class);
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
        Intent intent = new Intent(MenuKopi.this, targetActivity);
        startActivity(intent);
    }
}