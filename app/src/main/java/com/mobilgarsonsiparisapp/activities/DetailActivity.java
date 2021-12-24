package com.mobilgarsonsiparisapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mobilgarsonsiparisapp.R;
import com.mobilgarsonsiparisapp.data.Constanst;
import com.mobilgarsonsiparisapp.model.Meal;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener{

    DatabaseReference ref;
    ImageView img_detailMealImage;
    TextView txt_detailMealName;
    //satit al butonu
    Button btn_buy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        //init fonksiyonu calsitir
        init();
    }

    private void init(){
        txt_detailMealName = findViewById(R.id.txt_detailMealName);
        img_detailMealImage = findViewById(R.id.img_detailMealImage);
        btn_buy = findViewById(R.id.btn_buy);
        btn_buy.setOnClickListener(this);
        //getDetail fonk calsitir
        getDetail();
    }

    public void getDetail(){
        //firebaseteki Meals ile calisacak
        ref = FirebaseDatabase.getInstance().getReference().child("Meals");

        ref.child(Constanst.buyItem).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Meal mealkey = snapshot.getValue(Meal.class);
                txt_detailMealName.setText(mealkey.getName());
                byte[] bytes = Base64.decode(mealkey.getDetailImgURL(),Base64.DEFAULT);
                Bitmap bitmap2= BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                img_detailMealImage.setImageBitmap(bitmap2);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    //satin alma fonksiyonu
    public void buyItem(){
        //sonraki OrderActivity olacak
        Intent nextPageActivity=new Intent(getApplicationContext(),OrderActivity.class);
        //onu calistir
        startActivity(nextPageActivity);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //satin al butonu bastiginizda buyItem fonk calistiracak
            case R.id.btn_buy:
                buyItem();
                break;
        }
    }
}