package com.mobilgarsonsiparisapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import com.mobilgarsonsiparisapp.AlertDialogUtil;
import com.mobilgarsonsiparisapp.R;
import com.mobilgarsonsiparisapp.utils.NetworkUtil;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //timer fonk calistiracak
        timer();
    }

    //kontrol yapacak(internet var mi)
    public void timer(){
        CountDownTimer countDownTimer =new
                CountDownTimer(3000,1000) {
                    @Override
                    public void onTick(long l) {
                    }
                    @Override
                    public void onFinish() {

                        //var ise sonraki sayfaya gecer
                        if(NetworkUtil.internetControl(getApplicationContext())) {
                            nextPage();
                        }
                        else {
                            //yok ise uyari verir
                            AlertDialogUtil.alertDialogShow(SplashActivity.this, "İnternet Yok",
                                    "Program için internet gerekli!",
                                    "Ayarlara git",
                                    "Kapat",
                                    "SplashActivity");
                        }
                    }
                };
        countDownTimer.start();
    }

    public void nextPage(){
        //sonraki LoginActivity olacak
        Intent nextPageActivity=new Intent(getApplicationContext(),LoginActivity.class);
        //onu acacak
        startActivity(nextPageActivity);
        finish();
    }

}
