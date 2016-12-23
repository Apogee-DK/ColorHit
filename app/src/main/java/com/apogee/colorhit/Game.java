package com.apogee.colorhit;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class Game extends AppCompatActivity {

    private ImageView imageview;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        // context gives access to app-specific resources and classes, launching activities, broadcasting and receiving intents
        context = getApplicationContext();

        setContentView(R.layout.activity_game);
        imageview = (ImageView) findViewById(R.id.imageView);

        imageview.setOnTouchListener(new View.OnTouchListener(){

            Resources r = getResources();
            int [] blockColors = r.getIntArray(R.array.blockColors);

           @Override
            public boolean onTouch(View view, MotionEvent event){
               // get the event being triggered
               switch(event.getActionMasked()){
                   case MotionEvent.ACTION_DOWN:
                       int temp = (int)(Math.random() * blockColors.length);
                       imageview.setColorFilter(blockColors[temp], Mode.SRC_ATOP);
                       break;
                   default:
                       return false;
               }

               return true;
           }
        });

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        hideTitleBar();
    }

    private void hideTitleBar() {
        // Hide UI first
        ActionBar actionBar = getSupportActionBar(); // returns the title bar
        if (actionBar != null) {
            actionBar.hide();
        }
    }
}
