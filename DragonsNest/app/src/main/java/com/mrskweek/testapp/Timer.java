package com.mrskweek.testapp;

import android.provider.Settings;

/**
 * Created by Skweek on 18/12/2014.
 */
public class Timer {
    private float currentTime;
    private float totalTime;
    private float deltaTime;

    public Timer() {
        currentTime = System.currentTimeMillis();
        totalTime = 0.f;
        deltaTime = 0.f;
    }

    public void Run() {
        deltaTime = System.currentTimeMillis() - currentTime;
        currentTime = System.currentTimeMillis();
        totalTime += deltaTime;
    }

    public float GetDelta(){ return deltaTime; }
    public float GetTotal(){ return totalTime; }
    public float GetCurrent(){ return currentTime; }
}
