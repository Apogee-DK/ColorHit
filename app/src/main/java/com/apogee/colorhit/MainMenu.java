package com.apogee.colorhit;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainMenu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_menu);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        hideTitleBar();
    }

    public void startApplication(View view){
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);
    }

    private void hideTitleBar() {
        // Hide UI first
        ActionBar actionBar = getSupportActionBar(); // returns the title bar
        if (actionBar != null) {
            actionBar.hide();
        }
    }
}
