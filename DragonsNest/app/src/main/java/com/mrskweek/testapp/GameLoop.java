package com.mrskweek.testapp;

import android.widget.ProgressBar;

/**
 * Created by Skweek on 18/12/2014.
 */
public class GameLoop extends Thread{

    public GameLoop(DragonScreen view){
           mainScreen = view;
    }

    private boolean running;
    private DragonScreen mainScreen;

    public void Start(){
        running = true;
    }
    public void Stop(){
        running = false;
    }

    @Override
    public void run(){
        while(running)
        {
            // run timer
            mainScreen.gameTimer.Run();

            //update all dragons
            for (int i = 0; i < 6; ++i) {
                mainScreen.dragonsList[i].UpdateDragon(0.00016f);
            }
            ProgressBar dragonHunger = (ProgressBar) mainScreen.findViewById(R.id.dragon_hunger);
            dragonHunger.setProgress(mainScreen.currentDragon.GetHunger());
        }
    }
}
