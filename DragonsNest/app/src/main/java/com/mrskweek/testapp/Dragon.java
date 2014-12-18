package com.mrskweek.testapp;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Skweek on 16/12/2014.
 */
public class Dragon {
    private String sDragonName;
    private int iDragonLevel;
    private int iDragonHealth;
    private int iDragonImage;
    private int iDragonHunger;
    private float hungerTimer;

    public Dragon(String sDragonName, int iDragonLevel, int iDragonHealth, int iDragonImage) {
        this.sDragonName = sDragonName;
        this.iDragonLevel = iDragonLevel;
        this.iDragonHealth = iDragonHealth;
        this.iDragonImage = iDragonImage;

        // defaults
        this.iDragonHunger = 100;
        this.hungerTimer = 0.f;
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

    public void UpdateDragon(float fDelta){
        this.hungerTimer += fDelta;

        //every 5 seconds take hunger down 1%
        if(this.hungerTimer > 5.0f){
            this.iDragonHunger--;
            if(this.iDragonHunger < 0){ this.iDragonHunger = 0; }
            this.hungerTimer = 0.f;
        }

    }

}
