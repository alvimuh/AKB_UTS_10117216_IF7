package com.example.akb_uts_10117216_if7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.akb_uts_10117216_if7.R;
import com.example.akb_uts_10117216_if7.database.DbHelper;

public class SplashScreen extends AppCompatActivity {

    DbHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        helper = new DbHelper(this);

        Thread thread = new Thread(){
            public void run() {
                try {
                    sleep(2500); //detik
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(intent);

                    finish();
                }
            }
        };
        thread.start();
    }
}



// 10 mei 2020
// 10117216 - Adi Prayoga - IF7