package com.footyquizleagues;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class HomeActivity extends AppCompatActivity {
    BackgroundMusicService m = new BackgroundMusicService();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent bgMusic=new Intent(this, BackgroundMusicService.class);
        startService(bgMusic);

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);


    }



    @Override
    protected void onRestart() {
        BackgroundMusicService.onRestart();
        super.onRestart();


    }


    @Override
    public void onPause() {
        BackgroundMusicService.onPause();
        super.onPause();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent bgMusic=new Intent(this, BackgroundMusicService.class);
        stopService(bgMusic);
    }


    public void btnPlayClicked(View view) {
        Intent intent = new Intent(HomeActivity.this, LeaguesActivity.class);
        startActivity(intent);
    }

    public void btnHSClicked(View view) {
        Intent intent = new Intent(HomeActivity.this, HighScoreActivity.class);
        startActivity(intent);

    }

}
