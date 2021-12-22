package com.mobilgarsonsiparisapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mobilgarsonsiparisapp.R;
import com.mobilgarsonsiparisapp.model.User;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID;

    private FirebaseAuth mAuth;
    private Button btn_login;
    private TextView txt_register, txt_resetPassword;
    private EditText edt_userLoginEmail, edt_userLoginPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    private void init(){
        mAuth = FirebaseAuth.getInstance();
        btn_login = findViewById(R.id.btn_girisYap);
        txt_register = findViewById(R.id.txt_kayitOl);
        txt_resetPassword = findViewById(R.id.txt_sifremiUnuttum);
        edt_userLoginEmail = findViewById(R.id.edt_kullaniciAdiGirisYap);
        edt_userLoginPassword = findViewById(R.id.edt_sifreGirisYap);

        btn_login.setOnClickListener(this);
        txt_register.setOnClickListener(this);
        txt_resetPassword.setOnClickListener(this);

    }

    public void login(){
        String email = edt_userLoginEmail.getText().toString().trim();
        String password = edt_userLoginPassword.getText().toString().trim();

        if (email.isEmpty()){
            edt_userLoginEmail.setError("Email boş bırakılamaz");
            edt_userLoginEmail.requestFocus();
            return;
        }
        if (password.isEmpty()){
            edt_userLoginPassword.setError("Parola boş bırakılamaz");
            edt_userLoginPassword.requestFocus();
            return;
        }
        if (password.length() <6){
            edt_userLoginPassword.setError("Parola 6 haneden uzun olmalıdır");
            edt_userLoginPassword.requestFocus();
            return;
        }

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    user = FirebaseAuth.getInstance().getCurrentUser();
                    reference= FirebaseDatabase.getInstance().getReference("Users");
                    userID = user.getUid();
                    reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            User userPID = snapshot.getValue(User.class);
                            if(userPID != null){
                                Intent nextPageActivity=new Intent(getApplicationContext(),CategoryListingActivity.class);
                                startActivity(nextPageActivity);
                                finish();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
                else{
                    Toast.makeText(LoginActivity.this, "Giriş yapılamadı", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void resetPassword(){
        Intent nextPageActivity=new Intent(getApplicationContext(),ResetPasswordActivity.class);
        startActivity(nextPageActivity);
        finish();
    }
    public void register(){
        Intent nextPageActivity=new Intent(getApplicationContext(),RegisterActivity.class);
        startActivity(nextPageActivity);
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_girisYap:
                login();
                break;
            case R.id.txt_kayitOl:
                register();
                break;
            case R.id.txt_sifremiUnuttum:
                resetPassword();
        }
    }
}