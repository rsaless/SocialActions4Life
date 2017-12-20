package com.ota.rafael.socialactions4life.SplashScreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ota.rafael.socialactions4life.R;
import com.ota.rafael.socialactions4life.SocialActionsList.SocialActionsListActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        Thread timer= new Thread() {
            public void run() {
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally{
                    openMain();
                }
            }
        };
        timer.start();
//testing
    }

    protected void openMain(){
        Intent intentMain = new Intent(SplashScreenActivity.this, SocialActionsListActivity.class);
        startActivity(intentMain);
    }

    @Override
    protected void onPause(){
        super.onPause();
        finish();
    }
}
