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

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {
    private Context context;
    private List<MenuItem> menuList;
    private OnMenuClickListener listener;

    public interface OnMenuClickListener {
        void onMenuClick(MenuItem menuItem);
    }

    public MenuAdapter(Context context, List<MenuItem> menuList, OnMenuClickListener listener) {
        this.context = context;
        this.menuList = menuList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.menu_item, parent, false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        MenuItem menuItem = menuList.get(position);
        // Set data ke view
        holder.imageView.setImageResource(context.getResources().getIdentifier(menuItem.getImage(), "drawable", context.getPackageName()));
        holder.nameText.setText(menuItem.getName());
        holder.priceText.setText("Rp " + menuItem.getPrice());
        holder.orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onMenuClick(menuItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    static class MenuViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView nameText, priceText;
        Button orderButton;

        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.menuImage);
            nameText = itemView.findViewById(R.id.menuName);
            priceText = itemView.findViewById(R.id.menuPrice);
            orderButton = itemView.findViewById(R.id.orderButton);
        }
    }
}
