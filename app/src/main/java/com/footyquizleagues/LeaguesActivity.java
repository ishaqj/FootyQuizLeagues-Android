package com.footyquizleagues;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class LeaguesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leagues);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        Intent svc=new Intent(this, BackgroundMusicService.class);
        startService(svc);

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        BackgroundMusicService.onRestart();

    }

    @Override
    public void onPause() {
        super.onPause();
        BackgroundMusicService.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent bgMusic=new Intent(this, BackgroundMusicService.class);
        BackgroundMusicService.player.stop();
        stopService(bgMusic);
    }



    public void btnEPLClicked(View view) {
        Intent intent = new Intent(LeaguesActivity.this, EplActivity.class);
        startActivity(intent);
    }

    public void btnLaLigaClicked(View view) {
        Intent intent = new Intent(LeaguesActivity.this, LaligaActivity.class);
        startActivity(intent);

    }

    public void btnSerieAClicked(View view) {
        Intent intent = new Intent(LeaguesActivity.this, SerieaActivity.class);
        startActivity(intent);

    }
}
