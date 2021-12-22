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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.mobilgarsonsiparisapp.R;
import com.mobilgarsonsiparisapp.model.User;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_KayitOl;
    private EditText edt_AdiKayitOl, edt_soyadiKayitOl,edt_emailKayitOl,edt_sifreKayitOl;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
    }

    private void init(){
        mAuth = FirebaseAuth.getInstance();
        btn_KayitOl = findViewById(R.id.btn_KayitOl);
        edt_AdiKayitOl = findViewById(R.id.edt_adiKayitOl);
        edt_soyadiKayitOl = findViewById(R.id.edt_soyadiKayitOl);
        edt_emailKayitOl = findViewById(R.id.edt_mailKayitOl);
        edt_sifreKayitOl = findViewById(R.id.edt_sifreKayitOl);
        btn_KayitOl.setOnClickListener(this);
    }

    public void kayitYap(){
        String adi = edt_AdiKayitOl.getText().toString().trim();
        String soyadi = edt_soyadiKayitOl.getText().toString().trim();
        String email = edt_emailKayitOl.getText().toString().trim();
        String sifre = edt_sifreKayitOl.getText().toString().trim();

        if (adi.isEmpty()){
            edt_AdiKayitOl.setError("Adi boş bırakılamaz");
            edt_AdiKayitOl.requestFocus();
            return;
        }
        if (soyadi.isEmpty()){
            edt_soyadiKayitOl.setError("Soyadi boş bırakılamaz");
            edt_soyadiKayitOl.requestFocus();
            return;
        }
        if (email.isEmpty()){
            edt_emailKayitOl.setError("Email boş bırakılamaz");
            edt_emailKayitOl.requestFocus();
            return;
        }
        if (sifre.isEmpty()){
            edt_sifreKayitOl.setError("Sifre boş bırakılamaz");
            edt_sifreKayitOl.requestFocus();
            return;
        }
        if (sifre.length() <6){
            edt_sifreKayitOl.setError("Parola 6 haneden uzun olmalıdır");
            edt_sifreKayitOl.requestFocus();
            return;
        }
        mAuth.createUserWithEmailAndPassword(email, sifre)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            User user = new User(adi,soyadi,email);
                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){
                                        Toast.makeText(RegisterActivity.this, "Kullanıcı başarılı bir şekilde eklendi", Toast.LENGTH_SHORT).show();
                                    }
                                    else{
                                        Toast.makeText(RegisterActivity.this, "Kullanıcı Eklenemedi", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }else{
                            Toast.makeText(RegisterActivity.this, "Kullanıcı Eklenemedi", Toast.LENGTH_SHORT).show();

                        }
                    }
                });

        Intent nextPageActivity=new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(nextPageActivity);
        finish();


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_KayitOl:
                kayitYap();
                break;
        }
    }
}