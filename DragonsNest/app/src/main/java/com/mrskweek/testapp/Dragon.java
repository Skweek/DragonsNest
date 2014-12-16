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
    private float fDragonHealth;
    private int iDragonImage;

    public Dragon(String sDragonName, int iDragonLevel, float fDragonHealth, int iDragonImage) {
        this.sDragonName = sDragonName;
        this.iDragonLevel = iDragonLevel;
        this.fDragonHealth = fDragonHealth;
        this.iDragonImage = iDragonImage;
    }

    public void SetName(String sName){ this.sDragonName = sName; }
    public String GetName(){ return this.sDragonName; }
    public void SetLevel(int iLevel){ this.iDragonLevel = iLevel; }
    public int GetLevel(){ return this.iDragonLevel; }
    public void SetHealth(float fHealth){ this.fDragonHealth = fHealth; }
    public float GetHealth(){ return this.fDragonHealth; }
    public void SetImage(int iImage){ this.iDragonImage = iImage; }
    public int GetImage(){ return this.iDragonImage; }
}
