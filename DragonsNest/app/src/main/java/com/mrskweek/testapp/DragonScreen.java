package com.mrskweek.testapp;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.mrskweek.testapp.util.SystemUiHider;

public class DragonScreen extends Activity {

    public GameLoop updateLoop;
    public Timer gameTimer;

    public Dragon[] dragonsList = new Dragon[6];
    public Dragon currentDragon = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dragon_screen);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        getActionBar().hide();

        this.dragonsList[0] = new Dragon("Toothless", 100, 100, R.drawable.dragon1);
        this.dragonsList[1] = new Dragon("Stormfly", 100, 100, R.drawable.dragon2);
        this.dragonsList[2] = new Dragon("Meatlug", 100, 100, R.drawable.dragon3);
        this.dragonsList[3] = new Dragon("Barf", 100, 100, R.drawable.dragon4);
        this.dragonsList[4] = new Dragon("Belch", 100, 100, R.drawable.dragon5);
        this.dragonsList[5] = new Dragon("Hookfang", 100, 100, R.drawable.dragon6);

        this.SetCurrentDragon(0);

        //start timer
        gameTimer = new Timer();
        //start loop
        updateLoop = new GameLoop(this);
        updateLoop.Start();
    }

    public void SwapDragon(View v){
        switch(v.getId()){
            case R.id.dragon1:
                this.SetCurrentDragon(0);
                break;
            case R.id.dragon2:
                this.SetCurrentDragon(1);
                break;
            case R.id.dragon3:
                this.SetCurrentDragon(2);
                break;
            case R.id.dragon4:
                this.SetCurrentDragon(3);
                break;
            case R.id.dragon5:
                this.SetCurrentDragon(4);
                break;
            case R.id.dragon6:
                this.SetCurrentDragon(5);
                break;
        }
    }
    protected void SetCurrentDragon(int iDragon){
        currentDragon = dragonsList[iDragon];

        //set the info for the new current dragon
        //set image
        final View dragonView = findViewById(R.id.dragonView);
        ((ImageView)dragonView).setImageResource(currentDragon.GetImage());
        //set name
        TextView t = (TextView)findViewById(R.id.dragonName);
        t.setText(currentDragon.GetName());
        //set level
        t = (TextView)findViewById(R.id.dragonLevel);
        t.setText(Integer.toString(currentDragon.GetLevel()));
        //set power
        t = (TextView)findViewById(R.id.dragonHealth);
        t.setText(Integer.toString(currentDragon.GetHealth()));
        //set hunger
        ProgressBar dragonHunger = (ProgressBar) findViewById(R.id.dragon_hunger);
        dragonHunger.setProgress(currentDragon.GetHealth());
    }


    // button listeners
    public void FeedDragon(View v){
        currentDragon.Feed();
    }
    public void TrainDragon(View v){
        //train dragon code TODO
    }
}
