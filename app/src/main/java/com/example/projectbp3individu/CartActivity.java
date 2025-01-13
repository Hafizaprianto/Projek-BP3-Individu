package com.example.projectbp3individu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {
    private RecyclerView cartRecyclerView;
    private TextView totalPriceText;
    private Button payButton;

    private List<CartItem> cartList;
    private CartAdapter cartAdapter;
    private int totalPrice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartRecyclerView = findViewById(R.id.cartRecyclerView);
        totalPriceText = findViewById(R.id.totalPriceText);
        payButton = findViewById(R.id.payButton);

        // Data pesanan
        cartList = new ArrayList<>();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String name = extras.getString("name");
            String image = extras.getString("image");
            int price = extras.getInt("price");
            int count = extras.getInt("count");

            cartList.add(new CartItem(image, name, price, count));
            totalPrice = price * count;
        }

        cartAdapter = new CartAdapter(this, cartList, updatedPrice -> {
            totalPrice = updatedPrice;
            totalPriceText.setText("Total Harga: Rp " + totalPrice);
        });

        cartRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        cartRecyclerView.setAdapter(cartAdapter);

        totalPriceText.setText("Total Harga: Rp " + totalPrice);



        // Inisialisasi button
        Button mulaiButton = findViewById(R.id.payButton);

        // Set onClickListener
        mulaiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pindah ke LoginActivity
                Intent intent = new Intent(CartActivity.this, Pembayaran.class);
                startActivity(intent);
            }
        });
    }


}