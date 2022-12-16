package com.example.curatedfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Restaurant2Activity extends AppCompatActivity implements View.OnClickListener {
    Button btnBurger, btnCroissant, btnEggs, btnSalad;

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
        btnBurger = findViewById(R.id.btnBurger);
        btnCroissant = findViewById(R.id.btnCroissant);
        btnEggs = findViewById(R.id.btnEggs);
        btnSalad = findViewById(R.id.btnSalad);



        btnBurger.setOnClickListener(this);
        btnCroissant.setOnClickListener(this);
        btnEggs.setOnClickListener(this);
        btnSalad.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        DBHelper dbHelper = new DBHelper(this);

        switch (view.getId()) {
            case R.id.btnBurger:
                dbHelper.addItem("Burger", 9.99);
                Toast.makeText(this, "Burger Added", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnCroissant:
                dbHelper.addItem("Croissant", 14.99);
                Toast.makeText(this, "Croissant Added", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnEggs:
                Toast.makeText(this, "Eggs", Toast.LENGTH_SHORT).show();
                dbHelper.addItem("Eggs", 19.99);
                break;
            case R.id.btnSalad:
                Toast.makeText(this, "Salad", Toast.LENGTH_SHORT).show();
                dbHelper.addItem("Salad", 15.99);
                break;

        }
    }
}