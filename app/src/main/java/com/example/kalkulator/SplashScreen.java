package com.example.kalkulator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);
        // cek apakah sharedprefrence tadi sudah ada apa belum ?
        // kalau sudah inten ke main menu
        // kalau kosong, inten ke login
        // kita add loading screen fake
        new Handler().postDelayed(() -> {
            // Task to execute after delay
            SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
            String username = pref.getString("username", "kosong"); // getting String
            if (username.equals("kosong")){
                // ini ke login
                Intent in = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(in);
            }else{
                Intent in = new Intent(SplashScreen.this, Calculator.class);
                startActivity(in);
            }
        }, 3000); // Delay in milliseconds (3000 ms = 3 seconds)
        finish();

    }
}