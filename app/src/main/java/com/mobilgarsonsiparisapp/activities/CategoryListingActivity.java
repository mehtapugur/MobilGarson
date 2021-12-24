package com.mobilgarsonsiparisapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.mobilgarsonsiparisapp.R;
import com.mobilgarsonsiparisapp.data.Constanst;
import com.mobilgarsonsiparisapp.model.Category;

public class CategoryListingActivity extends AppCompatActivity {
    RecyclerView rcv_categorys;
    Query query;
    private FirebaseRecyclerOptions<Category> options;
    private FirebaseRecyclerAdapter<Category, CategoryViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_listing);
        //init calistiracaktir
        init();
    }
    private void init(){
        rcv_categorys = findViewById(R.id.rcv_categorys);
        //listing fonk calistiracaktir
        listing();
    }

    public void listing(){
        //firebasten Category alacak onunla calisacaktir
        query = FirebaseDatabase.getInstance().getReference().child("Category");
        rcv_categorys.setHasFixedSize(true);
        rcv_categorys.setLayoutManager(new LinearLayoutManager(this));

        //Firebase veritabanından ‘Category’ referansına göre genel menüyü oluşturuyor.
        //‘Çorbalar’, ’Salatalar’, ‘Yemekler’, ‘Tatlılar’ ve ‘İçecekler’ kategorileri veritabanımızda mevcut.
        options = new FirebaseRecyclerOptions.Builder<Category>().setQuery(query,Category.class).build();
        adapter = new FirebaseRecyclerAdapter<Category, CategoryViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull CategoryViewHolder holder, int position, @NonNull Category category) {
                final String key = getRef(position).getKey();
                //resimler URL olarak alir
                byte[] bytes = Base64.decode(category.getCategoryImageUrl(),Base64.DEFAULT);
                Bitmap bitmap2= BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                holder.img_card_view_category.setImageBitmap(bitmap2);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Constanst.categoryName = category.getCategoryName();
                        //sonraki MealListingActivity olacak
                        Intent nextPageActivity=new Intent(getApplicationContext(),MealListingActivity.class);
                        //onu calistiracak
                        startActivity(nextPageActivity);
                    }
                });
            }

            @NonNull
            @Override
            public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v =  LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_category,parent,false);
                return new CategoryViewHolder(v);
            }
        };

        adapter.startListening();
        rcv_categorys.setAdapter(adapter);
    }
}