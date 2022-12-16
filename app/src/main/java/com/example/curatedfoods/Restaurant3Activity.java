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

public class Restaurant3Activity extends AppCompatActivity implements  View.OnClickListener {
    Button btnSandwich, btnWaffle, btnTacos, btnSushi;
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
        setContentView(R.layout.activity_restaurant3);
        btnSandwich = findViewById(R.id.btnSandwich);
        btnWaffle = findViewById(R.id.btnWaffle);
        btnTacos = findViewById(R.id.btnTacos);
        btnSushi = findViewById(R.id.btnSushi);
        btnSandwich.setOnClickListener(this);
        btnWaffle.setOnClickListener(this);
        btnTacos.setOnClickListener(this);
        btnSushi.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        DBHelper dbHelper = new DBHelper(this);

        switch (view.getId()) {
            case R.id.btnSandwich:
                dbHelper.addItem("Sandwich", 9.99);
                Toast.makeText(this, "Sandwich Added", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnWaffle:
                dbHelper.addItem("Waffle", 14.99);
                Toast.makeText(this, "Waffle Added", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnTacos:
                Toast.makeText(this, "Tacos", Toast.LENGTH_SHORT).show();
                dbHelper.addItem("Tacos", 19.99);
                break;
            case R.id.btnSushi:
                Toast.makeText(this, "Sushi", Toast.LENGTH_SHORT).show();
                dbHelper.addItem("Sushi", 15.99);
                break;

        }
    }
}