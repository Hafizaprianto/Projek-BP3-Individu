package com.example.projectbp3individu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private Context context;
    private List<CartItem> cartItems;
    private OnPriceChangeListener onPriceChangeListener;

    public CartAdapter(Context context, List<CartItem> cartItems, OnPriceChangeListener onPriceChangeListener) {
        this.context = context;
        this.cartItems = cartItems;
        this.onPriceChangeListener = onPriceChangeListener;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_cart, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        CartItem item = cartItems.get(position);

        holder.itemImage.setImageResource(context.getResources().getIdentifier(item.getImage(), "drawable", context.getPackageName()));
        holder.itemName.setText(item.getName());
        holder.itemPrice.setText("Rp " + item.getPrice());
        holder.itemCount.setText(String.valueOf(item.getCount()));

        // Update total harga di CartActivity saat item dihapus atau diperbarui
        holder.deleteButton.setOnClickListener(v -> {
            cartItems.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, cartItems.size());
            updateTotalPrice();
        });

        holder.minusButton.setOnClickListener(v -> {
            if (item.getCount() > 1) {
                item.setCount(item.getCount() - 1);
                holder.itemCount.setText(String.valueOf(item.getCount()));
                updateTotalPrice();
            }
        });

        holder.plusButton.setOnClickListener(v -> {
            item.setCount(item.getCount() + 1);
            holder.itemCount.setText(String.valueOf(item.getCount()));
            updateTotalPrice();
        });
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    private void updateTotalPrice() {
        int totalPrice = 0;
        for (CartItem item : cartItems) {
            totalPrice += item.getPrice() * item.getCount();
        }
        onPriceChangeListener.onPriceChanged(totalPrice);
    }

    public static class CartViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView itemName, itemPrice, itemCount;
        Button minusButton, plusButton, deleteButton;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.cartItemImage);
            itemName = itemView.findViewById(R.id.cartItemName);
            itemPrice = itemView.findViewById(R.id.cartItemPrice);
            itemCount = itemView.findViewById(R.id.cartItemCount);
            minusButton = itemView.findViewById(R.id.cartMinusButton);
            plusButton = itemView.findViewById(R.id.cartPlusButton);
            deleteButton = itemView.findViewById(R.id.cartDeleteButton);
        }
    }

    public interface OnPriceChangeListener {
        void onPriceChanged(int totalPrice);
    }
}

