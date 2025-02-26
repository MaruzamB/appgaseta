package com.maruzamjunior.appgaseta.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.maruzamjunior.appgaseta.R;
import com.maruzamjunior.appgaseta.database.GasetaDB;

public class SplashActivity extends AppCompatActivity {

    public static final int Time_OUT_SPLASH = 6000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        cumutarTelaSplash();

    }

    private void cumutarTelaSplash() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                GasetaDB db = new GasetaDB(SplashActivity.this);

                Intent telaPrincipal = new Intent(SplashActivity.this, GasEtaActivity.class);
                startActivity(telaPrincipal);
                finish();
            }
        },Time_OUT_SPLASH);
    }
}