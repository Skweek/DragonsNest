package com.mrskweek.testapp;

import android.app.ActionBar;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.PopupWindow;

public class DragonScreen extends Activity {

    private PopupWindow feedDragon;
    private LinearLayout feedDragonLayout;

    public GameLoop updateLoop;
    public Timer gameTimer;

    public Dragon[] dragonsList = new Dragon[6];
    public Dragon currentDragon = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dragon_screen);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        //set up feed dragon popup window
        feedDragonPopupInit();
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

    protected void feedDragonPopupInit(){
        View.OnClickListener feedDragonClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getTag().toString()) {
                    case "food1":
                        currentDragon.Feed(5);
                        break;
                    case "food2":
                        currentDragon.Feed(10);
                        break;
                    case "food3":
                        currentDragon.Feed(15);
                        break;
                }
                feedDragon.dismiss();
            }
        };

        //init objects
        Button food1 = new Button(this); food1.setGravity(Gravity.LEFT); food1.setWidth(25); food1.setHeight(25); food1.setText("Food1"); food1.setClickable(true); food1.setTag("food1"); food1.setOnClickListener(feedDragonClick);
        Button food2 = new Button(this); food2.setGravity(Gravity.CENTER); food2.setWidth(25); food2.setHeight(25); food2.setText("Food2"); food2.setClickable(true); food2.setTag("food2"); food2.setOnClickListener(feedDragonClick);
        Button food3 = new Button(this); food3.setGravity(Gravity.RIGHT); food3.setWidth(25); food3.setHeight(25); food3.setText("Food3"); food3.setClickable(true); food3.setTag("food3"); food3.setOnClickListener(feedDragonClick);
        //init layout
        feedDragonLayout = new LinearLayout(this);
        feedDragonLayout.setOrientation(LinearLayout.HORIZONTAL);
        feedDragonLayout.setBackgroundColor(getResources().getColor(R.color.material_blue_grey_900));
        //add objects
        feedDragonLayout.addView(food1);
        feedDragonLayout.addView(food2);
        feedDragonLayout.addView(food3);
        //init window
        feedDragon = new PopupWindow(feedDragonLayout, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        feedDragon.setContentView(feedDragonLayout);
        feedDragon.setTouchable(true);
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
        switch(v.getTag().toString()){
            case "feedMenu":
                feedDragon.showAsDropDown(findViewById(R.id.dragonName));
                break;
            default:
                break;
        }
    }
    public void TrainDragon(View v){
        //train dragon code TODO
    }
}
