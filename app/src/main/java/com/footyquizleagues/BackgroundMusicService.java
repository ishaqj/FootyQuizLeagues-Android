package com.footyquizleagues;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class BackgroundMusicService extends Service {
    private static final String TAG = null;
    static MediaPlayer player;
    static int length;
    public IBinder onBind(Intent arg0) {

        return null;
    }
    @Override
    public void onCreate() {
        super.onCreate();


        player = MediaPlayer.create(this, R.raw.bgmusic1);


    }

    public int onStartCommand(Intent intent, int flags, int startId) {

        player.start();
        player.setLooping(true);
        return 1;
    }

    public void onStart(Intent intent, int startId) {
        // TODO



    }

    public IBinder onUnBind(Intent arg0) {
        // TODO Auto-generated method stub

        return null;
    }

    public void onStop() {


    }


    public static void onPause() {
        player.pause();
        length = player.getCurrentPosition();

    }


    public static void onRestart() {
        player.seekTo(length);
        player.start();
    }



    @Override
    public void onDestroy() {

        player.stop();
    }

    @Override
    public void onLowMemory() {

    }


}