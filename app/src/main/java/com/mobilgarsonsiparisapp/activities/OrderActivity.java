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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mobilgarsonsiparisapp.R;
import com.mobilgarsonsiparisapp.data.Constanst;
import com.mobilgarsonsiparisapp.model.Meal;

public class OrderActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView img_detailImage;
    TextView txt_detailName,txt_detailPrice;
    Button btn_islemiTamamla;
    EditText edt_detailAdres;
    //database
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        //init fonksiyonu calistiracak
        init();
    }

    private void init(){
        img_detailImage = findViewById(R.id.img_detailImage);
        txt_detailName = findViewById(R.id.txt_detailName);
        txt_detailPrice = findViewById(R.id.txt_detailPrice);
        edt_detailAdres = findViewById(R.id.edt_detailAdres);
        btn_islemiTamamla = findViewById(R.id.btn_islemiTamamla);
        edt_detailAdres = findViewById(R.id.edt_detailAdres);
        btn_islemiTamamla.setOnClickListener(this);

        //firebase teki Meals ile calisacak
        ref = FirebaseDatabase.getInstance().getReference().child("Meals");

        ref.child(Constanst.buyItem).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Meal mealkey = snapshot.getValue(Meal.class);
                txt_detailName.setText(mealkey.getName());
                txt_detailPrice.setText(mealkey.getPrice());
                byte[] bytes = Base64.decode(mealkey.getImgURL(),Base64.DEFAULT);
                Bitmap bitmap2= BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                img_detailImage.setImageBitmap(bitmap2);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    //Satin alma fonksiyonu
    public void order(){
        //uyari yap
        Toast.makeText(OrderActivity.this, "Satın Alma İşlemi Tamamlandı", Toast.LENGTH_SHORT).show();
        //sonraki CategoryListingActivity olacak
        Intent nextPageActivity=new Intent(getApplicationContext(),CategoryListingActivity.class);
        //onu calisitracak
        startActivity(nextPageActivity);
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //order fonk calistiracak
            case R.id.btn_islemiTamamla:
                order();
                break;
        }
    }
}