package com.footyquizleagues;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class HighScoreActivity extends AppCompatActivity {
    TextView Epl;
    TextView La_liga;
    TextView Serie_a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        DbProvider db=new DbProvider(this);

        Epl = (TextView) findViewById(R.id.epl_stats);
        La_liga = (TextView) findViewById(R.id.laliga_stats);
        Serie_a = (TextView) findViewById(R.id.seriea_stats);

        //Percentage
        int epl_percentage = db.getHighScores(1) * 100 / 10;
        int laliga_percentage = db.getHighScores(2) * 100 / 10;
        int seriea_percentage = db.getHighScores(3) * 100 / 10;

        Epl.setText("Answered " + String.valueOf(db.getHighScores(1)) + " of 10 questions correctly." + "\n" + epl_percentage + "%");
        La_liga.setText("Answered " + String.valueOf(db.getHighScores(2)) + " of 10 questions correctly." + "\n" + laliga_percentage + "%");
        Serie_a.setText("Answered " + String.valueOf(db.getHighScores(3)) + " of 10 questions correctly." + "\n" + seriea_percentage + "%");

    }

}
