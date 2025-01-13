package com.example.projectbp3individu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_about_us);

        // Atur padding untuk sistem bar
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Tombol untuk panggilan telepon
        Button buttonPanggil = findViewById(R.id.buttonpanggil);
        buttonPanggil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent untuk membuka aplikasi telepon dengan nomor tertentu
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:0812345679"));
                startActivity(intent);
            }
        });

        setupImageNavigation();
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
        ImageView imageUser = findViewById(R.id.imageHome);
        imageUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToActivity(Beranda.class);
            }
        });
    }

    /**
     * Metode untuk navigasi ke aktivitas lain
     * @param targetActivity Kelas aktivitas tujuan
     */
    private void navigateToActivity(Class<?> targetActivity) {
        Intent intent = new Intent(AboutUs.this, targetActivity);
        startActivity(intent);
    }
}
