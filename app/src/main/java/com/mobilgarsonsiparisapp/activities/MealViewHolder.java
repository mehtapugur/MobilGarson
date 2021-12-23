package com.mobilgarsonsiparisapp.activities;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobilgarsonsiparisapp.R;

public class MealViewHolder extends RecyclerView.ViewHolder{

    View view;
    ImageView img_card_view_mealImage;
    TextView txt_card_view_mealName;
    public MealViewHolder(@NonNull View itemView) {
        super(itemView);
        img_card_view_mealImage = itemView.findViewById(R.id.img_card_view_mealImage);
        txt_card_view_mealName = itemView.findViewById(R.id.txt_card_view_mealName);
        view = itemView;
    }
}

