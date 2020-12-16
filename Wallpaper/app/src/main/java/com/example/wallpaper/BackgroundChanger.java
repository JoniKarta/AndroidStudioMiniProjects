package com.example.wallpaper;

import android.app.WallpaperManager;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class BackgroundChanger implements Runnable{

    private double startTimeCount;
    private List<Integer> imageResources;

    @Override
    public void run() {

        imageResources = getImageResources();
        startTimeCount = System.currentTimeMillis();

        while(true){

            if(isTenSecondPass()){
                changeBackground();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isTenSecondPass(){
        double currMinutes = System.currentTimeMillis();
        if(currMinutes >= startTimeCount + 10 * 1000){
            startTimeCount = currMinutes;
            return true;
        }

        return false;
    }

    private void changeBackground(){

        WallpaperManager wallpaperManager = WallpaperManager.getInstance(App.getContext());
        try {
            wallpaperManager.setResource(imageResources.get((int)(Math.random() * imageResources.size())));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Integer> getImageResources(){

        Field[] fields = R.drawable.class.getDeclaredFields();
        List<Integer> list = new ArrayList<>();
        for(Field field : fields){
            if(field.getName().startsWith("background")){
                list.add(App.getContext().getResources().getIdentifier(field.getName(), "drawable", App.getContext().getPackageName()));
            }
        }
        return list;
    }
}
