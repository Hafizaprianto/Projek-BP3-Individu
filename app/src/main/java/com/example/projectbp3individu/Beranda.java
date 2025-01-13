package com.example.projectbp3individu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Beranda extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MenuAdapter menuAdapter;
    private List<MenuItem> menuList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);

        recyclerView = findViewById(R.id.recyclerView);
        // Gunakan LinearLayoutManager dengan orientasi horizontal
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

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
                Intent intent = new Intent(Beranda.this, DetailActivity.class);
                intent.putExtra("name", menuItem.getName());
                intent.putExtra("image", menuItem.getImage());
                intent.putExtra("price", menuItem.getPrice());
                intent.putExtra("description", menuItem.getDescription());
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(menuAdapter);

        setupImageNavigation();

        // Inisialisasi button
        Button btnMenu = findViewById(R.id.button_menu_lainnya);

        // Set onClickListener untuk button Daftar
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Beranda.this, MenuKopi.class);
                startActivity(intent);
            }
        });

        // Inisialisasi button favorit
        Button buttonFavorit = findViewById(R.id.buttonfavorit);

// Set onClickListener untuk button Pesan
        buttonFavorit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kirim data spesifik ke DetailActivity
                Intent intent = new Intent(Beranda.this, DetailActivity.class);
                intent.putExtra("name", "Cappucino");
                intent.putExtra("image", "drawable/cappucino"); // Ganti dengan resource yang sesuai
                intent.putExtra("price", 28000);
                intent.putExtra("description", getString(R.string.deskripsi_cappuccino));
                startActivity(intent);
            }
        });

    }

    private void setupImageNavigation() {
        // Navigasi ke Beranda
        ImageView imageHome = findViewById(R.id.imageMenu);
        imageHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToActivity(MenuKopi.class);
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
        Intent intent = new Intent(Beranda.this, targetActivity);
        startActivity(intent);
    }
}
