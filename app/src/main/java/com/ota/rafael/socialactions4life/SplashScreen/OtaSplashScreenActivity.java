package com.ota.rafael.socialactions4life.SplashScreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ota.rafael.socialactions4life.R;
import com.ota.rafael.socialactions4life.SocialActionsList.SocialActionsListActivity;

public class OtaSplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ota_splash_screen);

        Thread timer= new Thread() {
            public void run() {
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally{
                    openSplash();
                }
            }
        };
        timer.start();
    }

    protected void openSplash(){
        Intent intentMain = new Intent(OtaSplashScreenActivity.this, SplashScreenActivity.class);
        startActivity(intentMain);
    }

    @Override
    protected void onPause(){
        super.onPause();
        finish();
    }
}
