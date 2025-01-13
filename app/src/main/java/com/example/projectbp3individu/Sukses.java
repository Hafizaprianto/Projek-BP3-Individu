package com.example.projectbp3individu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Sukses extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sukses);

        // Inisialisasi button
        Button mulaiButton = findViewById(R.id.btnsukses);

        // Set onClickListener
        mulaiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pindah ke LoginActivity
                Intent intent = new Intent(Sukses.this, Beranda.class);
                startActivity(intent);
            }
        });
    }
}