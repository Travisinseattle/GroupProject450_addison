package com.example.totes_rewards.totesrewards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    //declare varibles
    ProgressBar spinner;
    String email = "blank";
    String password = "blank";
    private static final String TAG_USER_NAME = "username";
    private static final String TAG_PW = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //create a spinner that will spin while loading.
        spinner = (ProgressBar) findViewById(R.id.progressBar);
        open(findViewById(R.id.progressBar));
    }

    public void open(View view) {
        //start the spinner
        spinner.setIndeterminate(true);

        //load password and email from preferences.
        try {
            password = PrefUtils.getFromPrefs(MainActivity.this, TAG_PW, "null");
            email = PrefUtils.getFromPrefs(MainActivity.this, TAG_USER_NAME, "null");
        } catch (Exception e) {
        }

        //if account is set, go to main menu.
        if (email .equals("null")) {
            StartLogin();
        } else {  // If not successful or doesn't exist, go to login.
            StartMenu();
        }
    }

    public void StartMenu() {
        final Intent menuIntent = new Intent(this, MenuActivity.class);
        startActivity(menuIntent);
    }

    public void StartLogin() {
        final Intent loginIntent = new Intent(this, LoginActivity.class);
        startActivity(loginIntent);
    }
}
