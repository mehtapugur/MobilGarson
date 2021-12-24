package com.mobilgarsonsiparisapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.mobilgarsonsiparisapp.R;

public class ResetPasswordActivity extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth mAuth;
    private Button btn_sifreYenile;
    private EditText edt_mailSifreYenile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        //init fonk calistiracaktir
        init();
    }

    private void init(){
        mAuth = FirebaseAuth.getInstance();
        btn_sifreYenile = findViewById(R.id.btn_sifreYenile);
        edt_mailSifreYenile = findViewById(R.id.edt_mailSifreYenile);
        btn_sifreYenile.setOnClickListener(this);

    }

    //yeni sifre almak icin fonksyonu
    public void resetPassword(){

        //kullanicidan mail al
        String email = edt_mailSifreYenile.getText().toString().trim();

        //mail bos ise
        if (email.isEmpty()){
            //uyari ver
            edt_mailSifreYenile.setError("Email girmeniz gerekli");
            edt_mailSifreYenile.requestFocus();
            return;
        }

        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    //basarili ise uyari verir - Mail adresinize girdikten sonra uygulama size mail attigini goreceksiniz
                    Toast.makeText(ResetPasswordActivity.this, "Mail adresinizi kontrol edin", Toast.LENGTH_SHORT).show();
                }
                else {
                    //basarisiz ise
                    Toast.makeText(ResetPasswordActivity.this, "Opps Bir şeyler yanlış gitti!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //sonraki LoginActivity olacak
        Intent nextPageActivity=new Intent(getApplicationContext(),LoginActivity.class);
        //onu calistir
        startActivity(nextPageActivity);
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //yeni sifre almak icin resetPassword calistiracak
            case R.id.btn_sifreYenile:
                resetPassword();
                break;

        }
    }
}