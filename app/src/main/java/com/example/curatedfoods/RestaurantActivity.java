package com.example.curatedfoods;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RestaurantActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView btnRest1,btnRest2,btnRest3;

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
            case R.id.action_cart:
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent i=new Intent(getApplicationContext(),Cart.class);
                        startActivity(i);
                    }
                },3000);
                return true;
            case android.R.id.home:
                this.finish();
                return true;
        }
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        // calling the action bar
        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("LogOut");
        getSupportActionBar().setSubtitle("admin");


        btnRest1=(ImageView) findViewById(R.id.btnRest1);
        btnRest2=(ImageView) findViewById(R.id.btnRest2);
        btnRest3=(ImageView) findViewById(R.id.btnRest3);

        btnRest1.setOnClickListener(this);
        btnRest2.setOnClickListener(this);
        btnRest3.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnRest1:
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent i=new Intent(getApplicationContext(),Restaurant1Activity.class);
                        startActivity(i);
                    }
                },3000);

                break;
            case R.id.btnRest2:
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent i=new Intent(getApplicationContext(),Restaurant2Activity.class);
                        startActivity(i);
                    }
                },3000);

                break;
            case R.id.btnRest3:
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent i=new Intent(getApplicationContext(),Restaurant3Activity.class);
                        startActivity(i);
                    }
                },3000);

                break;
        }
    }
}