package com.mobilgarsonsiparisapp.activities;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobilgarsonsiparisapp.R;

public class CategoryViewHolder extends RecyclerView.ViewHolder{

    View view;
    ImageView img_card_view_category;
    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);
        img_card_view_category = itemView.findViewById(R.id.img_card_view_category);
        view = itemView;
    }
}

