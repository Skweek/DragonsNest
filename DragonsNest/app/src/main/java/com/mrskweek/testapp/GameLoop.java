package com.mrskweek.testapp;

import android.app.Activity;
import android.widget.Button;
import android.widget.ProgressBar;

/**
 * Created by Skweek on 18/12/2014.
 */
public class GameLoop extends Thread {

    public GameLoop(DragonScreen view){
           mainScreen = view;
    }

    private boolean running;
    private DragonScreen mainScreen;

    public void Start(){
        running = true; start();
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
                mainScreen.dragonsList[i].Update(mainScreen.gameTimer.GetDelta());
            }


            //update the UI
            mainScreen.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    //dragon hunger
                    ProgressBar dragonHunger = (ProgressBar) mainScreen.findViewById(R.id.dragon_hunger);
                    dragonHunger.setProgress(mainScreen.currentDragon.GetHunger());

                    //training button
                    Button dragonTraining = (Button) mainScreen.findViewById(R.id.button_train);
                    if(mainScreen.currentDragon.GetTrainable()) dragonTraining.setEnabled(true);
                    else dragonTraining.setEnabled(false);
                }
            });


        }
    }
}
