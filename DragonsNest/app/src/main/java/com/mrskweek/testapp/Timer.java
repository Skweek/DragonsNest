package com.mrskweek.testapp;

/**
 * Created by Skweek on 18/12/2014.
 */
public class Timer {
    private float currentTime;
    private float totalTime;
    private float deltaTime;

    public Timer() {
        currentTime = 0.f;
        totalTime = 0.f;
        deltaTime = 0.f;
    }

    public void Run() {
        deltaTime = System.nanoTime() - currentTime;
        currentTime = System.nanoTime();
        totalTime += deltaTime;
    }

    public float GetDelta(){ return deltaTime; }
    public float GetTotal(){ return totalTime; }
    public float GetCurrent(){ return currentTime; }
}
