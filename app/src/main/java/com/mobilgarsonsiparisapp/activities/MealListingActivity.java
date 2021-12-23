package com.mobilgarsonsiparisapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.mobilgarsonsiparisapp.R;
import com.mobilgarsonsiparisapp.data.Constanst;
import com.mobilgarsonsiparisapp.model.Category;
import com.mobilgarsonsiparisapp.model.Meal;

public class MealListingActivity extends AppCompatActivity {

    RecyclerView rcv_meals;
    TextView txt_getCategoryName;
    Query query;
    private FirebaseRecyclerOptions<Meal> options;
    private FirebaseRecyclerAdapter<Meal, MealViewHolder> adapter;
    ProgressDialog progressDialog;
    private GridLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_listing);
        //init fonk calistir
        init();
    }

    private void init(){
        rcv_meals = findViewById(R.id.rcv_meals);
        txt_getCategoryName = findViewById(R.id.txt_getCategoryName);
        txt_getCategoryName.setText(Constanst.categoryName);
        progressDialog = new ProgressDialog(MealListingActivity.this);
        progressDialog.setMessage("Lütfen Bekleyiniz...");
        progressDialog.show();
        //listing fonksiyonu calistir
        listing();
    }

    public void listing(){
        query = FirebaseDatabase.getInstance().getReference("Meals").orderByChild("Category").equalTo(Constanst.categoryName);
        rcv_meals.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(this, 2);
        rcv_meals.setLayoutManager(layoutManager);
        //rcv_meals.setLayoutManager(new LinearLayoutManager(this));

        options = new FirebaseRecyclerOptions.Builder<Meal>().setQuery(query,Meal.class).build();
        adapter = new FirebaseRecyclerAdapter<Meal, MealViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull MealViewHolder holder, int position, @NonNull Meal meal) {
                final String key = getRef(position).getKey();
                holder.txt_card_view_mealName.setText(meal.getName());
                byte[] bytes = Base64.decode(meal.getImgURL(),Base64.DEFAULT);
                Bitmap bitmap2= BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                holder.img_card_view_mealImage.setImageBitmap(bitmap2);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Constanst.buyItem = key;
                        //sonraki DetailActivity olacak
                        Intent nextPageActivity=new Intent(getApplicationContext(),DetailActivity.class);
                        //onu calistiracak
                        startActivity(nextPageActivity);
                    }
                });
                progressDialog.dismiss();
            }

            @NonNull
            @Override
            public MealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v =  LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_meal,parent,false);
                return new MealViewHolder(v);
            }
        };

        adapter.startListening();
        rcv_meals.setAdapter(adapter);
    }
}
