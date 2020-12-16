package com.example.wallpaper;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class RandomBackgroundService extends Service {


    @Override
    public void onCreate() {
        new Thread(new BackgroundChanger()).start();
    }


//    @Override
//    public int onStartCommand(Intent intent, int flags, int startId) {
//        return super.onStartCommand(intent, flags, startId);
//        return START_NOT_STICKY;
//        return START_STICKY;
//        return START_REDELIVER_INTENT;
//    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
