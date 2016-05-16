package com.footyquizleagues;
import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DbProvider extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 17;
    // Database Name
    private static final String DATABASE_NAME = "quizDB.db";

    // Tables name
    private static final String TABLE_QUESTION = "questions";
    private static final String TABLE_HIGHSCORE = "high_score";

    // Question Table Columns names
    private static final String QUESTION_COLUMN_ID = "id";
    private static final String QUESTION_COLUMN_LEAGUE_ID = "league_id";
    private static final String QUESTION_COLUMN_IMG_ID = "img_id";
    private static final String QUESTION_COLUMN_QUESTION = "question";
    private static final String QUESTION_COLUMN_ANSWER = "answer";
    private static final String QUESTION_COLUMN_OPTION1= "option1";
    private static final String QUESTION_COLUMN_OPTION2= "option2";
    private static final String QUESTION_COLUMN_OPTION3= "option3";
    private static final String QUESTION_COLUMN_OPTION4= "option4";

    //High Score column names
    private static final String HIGHSCORE_COLUMN_ID = "id";
    private static final String HIGHSCORE_COLUMN_HS = "high_score";
    private static final String HIGHSCORE_COLUMN_LEAGUE_ID = "leagues_id";

    //Create Tables
    private static final String CREATE_TABLE_HIGHSCORE = "CREATE TABLE IF NOT EXISTS " + TABLE_HIGHSCORE + " ( "
            + HIGHSCORE_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + HIGHSCORE_COLUMN_HS + " INTEGER, " + HIGHSCORE_COLUMN_LEAGUE_ID + " INTEGER)";

    private static final String CREATE_TABLE_QUESTION =  "CREATE TABLE IF NOT EXISTS " + TABLE_QUESTION + " ( "
            + QUESTION_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + QUESTION_COLUMN_LEAGUE_ID + " INTEGER, " + QUESTION_COLUMN_IMG_ID + " INTEGER, " + QUESTION_COLUMN_QUESTION
            + " TEXT, " + QUESTION_COLUMN_ANSWER+ " TEXT, "+QUESTION_COLUMN_OPTION1 +" TEXT, "
            +QUESTION_COLUMN_OPTION2 +" TEXT, "+QUESTION_COLUMN_OPTION3+" TEXT," +QUESTION_COLUMN_OPTION4+" TEXT)";

    private SQLiteDatabase database;
    public DbProvider(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        database=db;

        //Create tables
        db.execSQL(CREATE_TABLE_QUESTION);
        db.execSQL(CREATE_TABLE_HIGHSCORE);

        //Add Premiere League Questions
        this.addQuestion(new Question(1,1,"Which club did Sergio Aguero score five goals against?","Arsenal","Man United", "Everton", "Newcastle", "Newcastle"));
        this.addQuestion(new Question(1,2,"Liverpool sacked Brendan Rodgers after a 1-1 draw with which club?","Bournemouth", "Manchester City", "Aston Villa", "Everton", "Everton"));
        this.addQuestion(new Question(1,3,"Which player has won the most Premier League" +
                " player of the month awards?","Luis Suarez", "Steven Gerrad","Cristiano Ronaldo","Gareth Bale","Steven Gerrad"));
        this.addQuestion(new Question(1,4,"Ryan Giggs played 672 EPL matches for Manchester United. " +
                "How many EPL goals did he score?","100", "200", "150", "114","114"));
        this.addQuestion(new Question(1,5,"What number did Thierry Henry famously wear" +
                " during his first spell at Arsenal?","10","14","9","7","14"));
        this.addQuestion(new Question(1,6,"Which team plays at the Liberty Stadium?","West Bromwich Albion","Stoke City","Swansea City","Watford","Swansea City"));
        this.addQuestion(new Question(1,7,"Newcastle were famously relegated on the last day of the 2008/09 season, but who went down with them?","Middlesbrough and West Bromwich Albion","Bolton Wanderers and Middlesbrough","Bolton Wanderers and Blackburn Rovers","Blackburn Rovers and West Bromwich Albion","Middlesbrough and West Bromwich Albion"));
        this.addQuestion(new Question(1,8,"In 2004-05, Chelsea won their first Premier League title. Which Premiership team let in the most goals that same season?","Fulham","Southampton","Norwich City","Crystal Palace","Norwich City"));
        this.addQuestion(new Question(1,9,"Which Premier League team lost the fewest games in 2008-09?","Arsenal","Liverpool","Manchester United","Chelsea","Liverpool"));
        this.addQuestion(new Question(1,10,"What was the first trophy Sir Alex Ferguson won as United boss?","Premier League","FA Cup","League Cup","Champions League","FA Cup"));

        //Add La Liga Questions
        this.addQuestion(new Question(2,11,"Which club won the league title in successive years in 1983 and 1984?","Real Madrid","Barcelona","Atletico Madrid","Sevilla", "Atletico Madrid"));
        this.addQuestion(new Question(2,12,"Which club in Spain has finished runners-up in La Liga the most number of times?","Real Madrid","Barcelona","Atletico Madrid", "Valencia","Barcelona"));
        this.addQuestion(new Question(2,13,"With which club did Xabi Alonso's father win the league in the 1980s two years in a row?","Sevilla","Real Madrid","Barcelona","Valencia","Barcelona"));
        this.addQuestion(new Question(2,14,"In which year did Las Palmas finish second in La Liga?","1969","1962","1959","1979","1969"));
        this.addQuestion(new Question(2,15,"Who coached Deportivo La Coruña when they won La Liga in 2000?","Javier Irureta","Carlo Ancelotti","Rafael Benítez","Gregorio Manzano","Javier Irureta"));
        this.addQuestion(new Question(2,16,"During Barcelona's title triumphs between 1991 and 1994, in which year did the title race not go down to the wire?","1993","1991","1992","1994","1991"));
        this.addQuestion(new Question(2,17,"Along with Real Madrid and Barcelona, which is the only other club never to have played outside the Spanish top flight?","Valencia","Sevilla","Atletico Madrid","Athletic Bilbao","Athletic Bilbao"));
        this.addQuestion(new Question(2,18,"How many times have Barcelona and Real Madrid both failed to finish in the top-two in La Liga?","0","11","8","9","11"));
        this.addQuestion(new Question(2,19,"Who is the all-time top scorer in La Liga history still playing in Spain or elsewhere?","Raul","David Villa","Cristiano Ronaldo","Messi","Messi"));
        this.addQuestion(new Question(2,20,"Who among these players has won the league with both Barcelona and Real Madrid?","Samuel Eto'o","Albert Celades","Ronaldo","Javier Saviola","Albert Celades"));

        //Add Serie A Questions
        this.addQuestion(new Question(3,21,"Which club has won most Serie A titles?","Napoli","Juventus","Ac Milan","Inter Milan","Juventus"));
        this.addQuestion(new Question(3,22,"When was the last time AC Milan won the scudetto (Serie A title)?","2001","2002","2004","2005","2004"));
        this.addQuestion(new Question(3,23,"Who is this former Juventus and Italian international player?","Alessandro del Piero","Buffon","Paolo Rossi","Fabbio Cappello","Alessandro del Piero"));
        this.addQuestion(new Question(3,24,"Which team lifted the Serie A title in 2005?","Roma","Juventus","Ac Milan","Nobody","Nobody"));
        this.addQuestion(new Question(3,25,"Italian teams have appeared in more European Cups / Champions League finals than teams from any other country. How many times?","22","15","20","25","25"));
        this.addQuestion(new Question(3,26,"Which of the following teams has won more Italian titles?","Roma","Genoa","Carpi","Torino","Genoa"));
        this.addQuestion(new Question(3,27,"How many league titles did Paolo Maldini win in his career?","6","9","7","5","7"));
        this.addQuestion(new Question(3,28,"Which of these players has scored more goals in Serie A?","Roberto Baggio","Zinedine Zidane","Gabriel Batistuta ","Francesco Totti","Roberto Baggio"));
        this.addQuestion(new Question(3,29,"How many Irish players have played in Serie A?","5","1","2","3","3"));
        this.addQuestion(new Question(3,30,"For which Italian club Diego Maradona has played?","Juventus","Genoa","Napoli","Ac Milan","Napoli"));
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older tables if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTION);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HIGHSCORE);
        // Create tables again
        onCreate(db);
    }
    // Adding new question
    public void addQuestion(Question question) {

        ContentValues values = new ContentValues();
        values.put(QUESTION_COLUMN_LEAGUE_ID, question.getLevel());
        values.put(QUESTION_COLUMN_IMG_ID, question.getqImage());
        values.put(QUESTION_COLUMN_QUESTION, question.getQuestion());
        values.put(QUESTION_COLUMN_ANSWER, question.getAnswer());
        values.put(QUESTION_COLUMN_OPTION1, question.getOption1());
        values.put(QUESTION_COLUMN_OPTION2, question.getOption2());
        values.put(QUESTION_COLUMN_OPTION3, question.getOption3());
        values.put(QUESTION_COLUMN_OPTION4, question.getOption4());

        database.insert(TABLE_QUESTION, null, values);
    }
    //Show all questions
    public List<Question> getAllQuestions(int leagueID) {
        List<Question> questionList = new ArrayList<Question>();

        String query = "SELECT  * FROM " + TABLE_QUESTION + " WHERE " + QUESTION_COLUMN_LEAGUE_ID + "=\"" + leagueID + "\";";
        database=this.getReadableDatabase();
        Cursor cursor = database.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                Question question = new Question();
                question.setID(cursor.getInt(0));
                question.setLevel(cursor.getInt(1));
                question.setqImage(cursor.getInt(2));
                question.setQuestion(cursor.getString(3));
                question.setAnswer(cursor.getString(4));
                question.setOption1(cursor.getString(5));
                question.setOption2(cursor.getString(6));
                question.setOption3(cursor.getString(7));
                question.setOption4(cursor.getString(8));
                questionList.add(question);
            } while (cursor.moveToNext());
        }

        return questionList;
    }
    //Get high score
    public int getHighScores(int leagueID)
    {
        int highScore = 0;
        String query = "SELECT * FROM " + TABLE_HIGHSCORE + " WHERE " + HIGHSCORE_COLUMN_LEAGUE_ID + "=\"" + leagueID + "\"";
        database=this.getReadableDatabase();
        Cursor c = database.rawQuery(query, null);

        //get high scores
        if(c != null && c.getCount() > 0)
        {
            c.moveToFirst();
            //get value from the column and return as highscore
            highScore = c.getInt(c.getColumnIndex(HIGHSCORE_COLUMN_HS));

            return highScore;
        }
        else {
            return highScore;

        }

    }
    //insert high score
    public long insertHighScores(int score, int leagueID) {
        long row = 0;
        int dbHighScore = 0;
        ContentValues values = new ContentValues();

        String query = "SELECT * FROM " + TABLE_HIGHSCORE + " WHERE " + HIGHSCORE_COLUMN_LEAGUE_ID + "=\"" + leagueID + "\"";
        database=this.getReadableDatabase();
        Cursor c = database.rawQuery(query, null);

        if(c != null) {

            if (c.getCount() == 0) {
                Log.d("msg", "setting highscore first time");
                values.put(HIGHSCORE_COLUMN_LEAGUE_ID, leagueID);
                values.put(HIGHSCORE_COLUMN_HS, score);
                database.insert(TABLE_HIGHSCORE, null, values);

            } else {
                c.moveToFirst();
                dbHighScore = c.getInt(c.getColumnIndex(HIGHSCORE_COLUMN_HS));
                if (score > dbHighScore) {
                    values.put(HIGHSCORE_COLUMN_LEAGUE_ID, leagueID);
                    values.put(HIGHSCORE_COLUMN_HS, score);
                    database.delete(TABLE_HIGHSCORE, HIGHSCORE_COLUMN_LEAGUE_ID + "=\"" + leagueID + "\"", null);
                    row = database.insert(TABLE_HIGHSCORE, null, values);
                }
            }
        }
        return row;

    }


}

