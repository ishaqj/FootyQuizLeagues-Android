package com.footyquizleagues;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    Button leagueBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        //get score result
        TextView scoreResult =(TextView)findViewById(R.id.resultScore);
        //get text result
        TextView text =(TextView)findViewById(R.id.textResult);

        //Premiere league get score
        Bundle bundle = getIntent().getExtras();
        int eplCurrentScore  = bundle.getInt("eplTotalScore");
        //Boolean for epl score
       boolean eplScore = getIntent().getExtras().getBoolean("eplScore");


        //LaligaActivity get score
        int LaligaScore = bundle.getInt("LaligaScore");
        //Boolean for LaligaActivity score
        boolean laLiga = getIntent().getExtras().getBoolean("laLigaTotalScore");

        //SerieaActivity get score
        int serieAScore = bundle.getInt("serieAScore");
        //Boolean for serieaActivity score
        boolean serieA = getIntent().getExtras().getBoolean("serieATotalScore");

        leagueBtn = (Button) findViewById(R.id.btnLeagues);

        //display level 1 score
        if(eplScore) {
            scoreResult.setText("You scored " + eplCurrentScore + " of 10");

            switch (eplCurrentScore)
            {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    text.setText("Your knowledge: Bad!");
                    leagueBtn.setVisibility(View.VISIBLE);
                    break;
                case 6:
                case 7:
                    text.setText("Your knowledge: Good!");
                    leagueBtn.setVisibility(View.VISIBLE);
                    break;
                case 8:
                case 9:
                    text.setText("Your knowledge: Very Good!");
                    leagueBtn.setVisibility(View.VISIBLE);
                    break;
                case 10: text.setText("Your knowledge: Excellent!");
                    leagueBtn.setVisibility(View.VISIBLE);
                    break;
            }
        }

        //display La Liga scores
        else if(laLiga) {
            scoreResult.setText("You scored " + LaligaScore + " of 10");

            switch (LaligaScore)
            {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    text.setText("Your knowledge: Bad!");
                    leagueBtn.setVisibility(View.VISIBLE);
                    break;
                case 6:
                case 7:
                    text.setText("Your knowledge: Good!");
                    leagueBtn.setVisibility(View.VISIBLE);
                    break;
                case 8:
                case 9:
                    text.setText("Your knowledge: Very Good!");
                    leagueBtn.setVisibility(View.VISIBLE);
                    break;
                case 10: text.setText("Your knowledge: Excellent!");
                    leagueBtn.setVisibility(View.VISIBLE);
                    break;
            }


        }

        //display La Liga scores
        else if(serieA) {
            scoreResult.setText("You scored " + serieAScore + " of 10");

            switch (serieAScore)
            {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    text.setText("Your knowledge: Bad!");
                    leagueBtn.setVisibility(View.VISIBLE);
                    break;
                case 6:
                case 7:
                    text.setText("Your knowledge: Good!");
                    leagueBtn.setVisibility(View.VISIBLE);
                    break;
                case 8:
                case 9:
                    text.setText("Your knowledge: Very Good!");
                    leagueBtn.setVisibility(View.VISIBLE);
                    break;
                case 10: text.setText("Your knowledge: Excellent!");
                    leagueBtn.setVisibility(View.VISIBLE);
                    break;
            }


        }

    }




    public void btnMainMenuClicked(View view) {
        Intent intent = new Intent(ResultActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    public void btnNewRoundClicked(View view) {
        Intent intent = new Intent(ResultActivity.this, LeaguesActivity.class);
        startActivity(intent);
        finish();
    }
}
