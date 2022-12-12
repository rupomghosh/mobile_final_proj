package com.example.curatedfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;

public class Restaurant2Activity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_menu, menu);
        return true;

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.feedbackMenu:
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent i=new Intent(getApplicationContext(),FeedbackActivity.class);
                        startActivity(i);
                    }
                },3000);
                return true;
            case R.id.restaurantsMenu:
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent i=new Intent(getApplicationContext(),RestaurantActivity.class);
                        startActivity(i);
                    }
                },3000);
                return true;
            case R.id.aboutMenu:
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent i=new Intent(getApplicationContext(),AboutActivity.class);
                        startActivity(i);
                    }
                },3000);
                return true;
            case R.id.contactMenu:
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent i=new Intent(getApplicationContext(),Contact.class);
                        startActivity(i);
                    }
                },3000);
                return true;
        }
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant2);
    }
}