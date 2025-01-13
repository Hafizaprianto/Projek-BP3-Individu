package com.example.projectbp3individu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    private ImageView detailImage, shareButton;
    private TextView detailName, detailDescription, detailPrice, itemCount;
    private Button minusButton, plusButton, orderButton;

    private int count = 1; // Default jumlah item
    private int price; // Harga per item

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detailImage = findViewById(R.id.detailImage);
        shareButton = findViewById(R.id.share);
        detailName = findViewById(R.id.detailName);
        detailDescription = findViewById(R.id.detailDescription);
        detailPrice = findViewById(R.id.detailPrice);
        itemCount = findViewById(R.id.itemCount);
        minusButton = findViewById(R.id.minusButton);
        plusButton = findViewById(R.id.plusButton);
        orderButton = findViewById(R.id.orderButton);

        // Ambil data dari MainActivity
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String image = intent.getStringExtra("image");
        price = intent.getIntExtra("price", 0);
        String description = intent.getStringExtra("description");

        detailName.setText(name);
        detailDescription.setText(description);
        detailPrice.setText("Rp " + price);
        detailImage.setImageResource(getResources().getIdentifier(image, "drawable", getPackageName()));

        // Tambah dan kurangi jumlah item
        minusButton.setOnClickListener(v -> {
            if (count > 1) {
                count--;
                itemCount.setText(String.valueOf(count));
            }
        });

        plusButton.setOnClickListener(v -> {
            count++;
            itemCount.setText(String.valueOf(count));
        });

        // Tombol pesan
        orderButton.setOnClickListener(v -> {
            Intent cartIntent = new Intent(DetailActivity.this, CartActivity.class);
            cartIntent.putExtra("name", name);
            cartIntent.putExtra("image", image);
            cartIntent.putExtra("price", price);
            cartIntent.putExtra("count", count);
            startActivity(cartIntent);
        });

        // Tombol share
        shareButton.setOnClickListener(v -> {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Bagikan Menu");
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Cek menu ini: " + name + "\nDeskripsi: " + description);
            startActivity(Intent.createChooser(shareIntent, "Bagikan via"));
        });
    }
}