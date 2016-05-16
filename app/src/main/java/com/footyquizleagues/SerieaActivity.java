package com.footyquizleagues;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

public class SerieaActivity extends AppCompatActivity {

    List<Question> questionList;
    int score=0;
    int questionId=0;
    int progress = 1;
    Question currentQuestion;
    TextView txtQuestion;
    TextView highScores;
    TextView scores;
    TextView game_time;
    TextView nrOfQ;
    RadioButton radio1Btn, radio2Btn, radio3Btn,radio4Btn;
    ImageView iv;
    ImageView incorrectAns;
    ImageView correctAns;
    Button timeup;
    ProgressBar pg;
    final int leagueSerieA = 3;
    private boolean serieATotalScore = false;
    SoundPool correctSnd;
    SoundPool incorrectSnd;
    DbProvider db;
    CountDownTimer timeHandler;
    Button next;
    boolean isNextBtn = false;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay);

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        correctSnd = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        incorrectSnd = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);

        Intent bgMusic=new Intent(this, BackgroundMusicService.class);
        startService(bgMusic);

        final int correctsnd1 = correctSnd.load(SerieaActivity.this, R.raw.correct,1);
        final int incorrectsnd1 = incorrectSnd.load(SerieaActivity.this, R.raw.incorrect,1);


        db=new DbProvider(this);
        questionList=db.getAllQuestions(leagueSerieA);
        Collections.shuffle(questionList);
        currentQuestion=questionList.get(questionId);

        txtQuestion=(TextView)findViewById(R.id.textView1);
        radio1Btn=(RadioButton)findViewById(R.id.radio0);
        radio2Btn=(RadioButton)findViewById(R.id.radio1);
        radio3Btn=(RadioButton)findViewById(R.id.radio2);
        radio4Btn=(RadioButton)findViewById(R.id.radio3);
        scores = (TextView) findViewById(R.id.gamescore);
        iv = (ImageView) findViewById(R.id.imageView);
        pg = (ProgressBar) findViewById(R.id.pgBar);
        correctAns = (ImageView) findViewById(R.id.correctanswer);
        incorrectAns = (ImageView) findViewById(R.id.incorrectanswer);
        highScores = (TextView) findViewById(R.id.hs);
        game_time = (TextView) findViewById(R.id.game_time);
        timeup = (Button) findViewById(R.id.resultpage);
        next = (Button) findViewById(R.id.button1);
        nrOfQ = (TextView) findViewById(R.id.nrOfQ);

        int color = 0xFF00FF00;
        //set color to progressbar
        pg.getIndeterminateDrawable().setColorFilter(color, PorterDuff.Mode.SRC_IN);
        pg.getProgressDrawable().setColorFilter(color, PorterDuff.Mode.SRC_IN);

        newQuestion();

        timeHandler = new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {

                game_time.setText(getString(R.string.timer) + millisUntilFinished/1000);

                RadioGroup radioGroupBtns = (RadioGroup) findViewById(R.id.radioGroup1);

                radioGroupBtns.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        switch (checkedId) {
                            case R.id.radio0:
                                if (currentQuestion.getAnswer().equals(radio1Btn.getText())) {
                                    score++;
                                    correctAns.setVisibility(View.VISIBLE);
                                    correctSnd.play(correctsnd1, 1, 1, 0, 0, 1);
                                    radio1Btn.setChecked(false);
                                } else {

                                    incorrectAns.setVisibility(View.VISIBLE);
                                    incorrectSnd.play(incorrectsnd1, 1, 1, 0, 0, 1);
                                    radio1Btn.setChecked(false);

                                }
                                break;
                            case R.id.radio1:
                                if (currentQuestion.getAnswer().equals(radio2Btn.getText())) {
                                    score++;
                                    correctAns.setVisibility(View.VISIBLE);
                                    correctSnd.play(correctsnd1, 1, 1, 0, 0, 1);
                                    radio2Btn.setChecked(false);
                                } else {

                                    incorrectAns.setVisibility(View.VISIBLE);
                                    incorrectSnd.play(incorrectsnd1, 1, 1, 0, 0, 1);
                                    radio2Btn.setChecked(false);

                                }
                                break;
                            case R.id.radio2:
                                if (currentQuestion.getAnswer().equals(radio3Btn.getText())) {
                                    score++;
                                    correctAns.setVisibility(View.VISIBLE);
                                    correctSnd.play(correctsnd1, 1, 1, 0, 0, 1);
                                    radio3Btn.setChecked(false);
                                } else {

                                    incorrectAns.setVisibility(View.VISIBLE);
                                    incorrectSnd.play(incorrectsnd1, 1, 1, 0, 0, 1);
                                    radio3Btn.setChecked(false);

                                }
                                break;
                            case R.id.radio3:
                                if (currentQuestion.getAnswer().equals(radio4Btn.getText())) {
                                    score++;
                                    correctAns.setVisibility(View.VISIBLE);
                                    correctSnd.play(correctsnd1, 1, 1, 0, 0, 1);
                                    radio4Btn.setChecked(false);
                                } else {

                                    incorrectAns.setVisibility(View.VISIBLE);
                                    incorrectSnd.play(incorrectsnd1, 1, 1, 0, 0, 1);
                                    radio4Btn.setChecked(false);

                                }
                                break;
                        }

                        if (questionId < questionList.size()) {
                            cancel();
                            radio1Btn.setEnabled(false);
                            radio2Btn.setEnabled(false);
                            radio3Btn.setEnabled(false);
                            radio4Btn.setEnabled(false);

                            next.setVisibility(View.VISIBLE);
                            isNextBtn = true;
                            next.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    incorrectAns.setVisibility(View.INVISIBLE);
                                    correctAns.setVisibility(View.INVISIBLE);
                                    currentQuestion = questionList.get(questionId);
                                    start();
                                    newQuestion();
                                    radio1Btn.setEnabled(true);
                                    radio2Btn.setEnabled(true);
                                    radio3Btn.setEnabled(true);
                                    radio4Btn.setEnabled(true);
                                    next.setVisibility(View.INVISIBLE);
                                    isNextBtn = false;

                                }
                            });
                        } else {
                            long row = db.insertHighScores(score, leagueSerieA);
                            if (row > 0) {
                                Toast.makeText(getApplicationContext(), "You have set a new high score!", Toast.LENGTH_LONG).show();
                            }

                            timeup.setVisibility(View.VISIBLE);
                            radio1Btn.setEnabled(false);
                            radio2Btn.setEnabled(false);
                            radio3Btn.setEnabled(false);
                            radio4Btn.setEnabled(false);
                        }

                    }

                });

            }
            public void onFinish() {
                if (questionId < questionList.size()) {
                    cancel();
                    radio1Btn.setEnabled(false);
                    radio2Btn.setEnabled(false);
                    radio3Btn.setEnabled(false);
                    radio4Btn.setEnabled(false);

                    next.setVisibility(View.VISIBLE);
                    isNextBtn = true;
                    next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            incorrectAns.setVisibility(View.INVISIBLE);
                            correctAns.setVisibility(View.INVISIBLE);
                            currentQuestion = questionList.get(questionId);
                            start();
                            newQuestion();
                            radio1Btn.setEnabled(true);
                            radio2Btn.setEnabled(true);
                            radio3Btn.setEnabled(true);
                            radio4Btn.setEnabled(true);
                            next.setVisibility(View.INVISIBLE);
                            isNextBtn = false;

                        }
                    });


                } else {
                    this.cancel();
                    timeup.setVisibility(View.VISIBLE);
                    radio1Btn.setEnabled(false);
                    radio2Btn.setEnabled(false);
                    radio3Btn.setEnabled(false);
                    radio4Btn.setEnabled(false);

                }
            }
        }.start();

    }


    @Override
    protected void onRestart() {
        super.onRestart();
        BackgroundMusicService.onRestart();

    }

    @Override
    protected void onPause() {
        super.onPause();
        BackgroundMusicService.onPause();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent bgMusic=new Intent(this, BackgroundMusicService.class);
        stopService(bgMusic);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(isNextBtn == true)
        {
            timeHandler.cancel();

        }
    }




    public void btnResultClicked(View view) {
        Intent intent = new Intent(SerieaActivity.this, ResultActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("serieAScore", score);
        intent.putExtras(bundle);
        intent.putExtra("serieATotalScore", true);
        startActivity(intent);
        finish();
    }

    private void newQuestion() {
        txtQuestion.setText(currentQuestion.getQuestion());
        radio1Btn.setText(currentQuestion.getOption1());
        radio2Btn.setText(currentQuestion.getOption2());
        radio3Btn.setText(currentQuestion.getOption3());
        radio4Btn.setText(currentQuestion.getOption4());
        iv.setImageResource(getResources().getIdentifier("image_" + currentQuestion.getqImage(), "drawable", getPackageName()));
        scores.setText(String.valueOf(getString(R.string.score) + score));
        pg.setProgress(progress);
        highScores.setText(String.valueOf(getString(R.string.highscore) + db.getHighScores(3)));
        nrOfQ.setText(progress + " Of 10");
        progress++;
        questionId++;

    }

}
