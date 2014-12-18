package com.mrskweek.testapp;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import java.util.*;
import java.util.Timer;

/**
 * Created by Skweek on 16/12/2014.
 */
public class Dragon {
    private java.util.Timer hungerTimer;
    private long hungerInterval;

    private String sDragonName;
    private int iDragonLevel;
    private int iDragonHealth;
    private int iDragonImage;
    private int iDragonHunger;
    private boolean bCanTrain;

    public Dragon(String sDragonName, int iDragonLevel, int iDragonHealth, int iDragonImage) {
        this.sDragonName = sDragonName;
        this.iDragonLevel = iDragonLevel;
        this.iDragonHealth = iDragonHealth;
        this.iDragonImage = iDragonImage;

        // defaults
        this.iDragonHunger = 100;
        this.bCanTrain = true;
        this.hungerInterval = 100;

        //timer task for hunger
        TimerTask hunger = new TimerTask() {
            @Override
            public void run() {
                if(iDragonHunger < 0) iDragonHunger = 0;
                else iDragonHunger--;
            }
        };
        this.hungerTimer = new Timer();
        this.hungerTimer.scheduleAtFixedRate(hunger, this.hungerInterval, this.hungerInterval);
    }

    public void SetName(String sName){ this.sDragonName = sName; }
    public String GetName(){ return this.sDragonName; }
    public void SetLevel(int iLevel){ this.iDragonLevel = iLevel; }
    public int GetLevel(){ return this.iDragonLevel; }
    public void SetHealth(int iHealth){ this.iDragonHealth = iHealth; }
    public int GetHealth(){ return this.iDragonHealth; }
    public void SetImage(int iImage){ this.iDragonImage = iImage; }
    public int GetImage(){ return this.iDragonImage; }

    public int GetHunger(){ return this.iDragonHunger; }
    public boolean GetTrainable(){ return this.bCanTrain; }

    public void Update(float fDelta){
        if(iDragonHunger == 0) bCanTrain = false;
        else bCanTrain = true;
    }

    public void Feed(){
        this.iDragonHunger = this.iDragonHunger + 5;
    }

}
