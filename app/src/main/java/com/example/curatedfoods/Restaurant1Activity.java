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

public class Restaurant1Activity extends AppCompatActivity implements View.OnClickListener {
    Button btnPizza, btnWings, btnCheese, btnPanzerotti;
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
        setContentView(R.layout.activity_restaurant1);
        btnPanzerotti =  findViewById(R.id.btnPanzerotti);
        btnWings = findViewById(R.id.btnWings);
        btnCheese = findViewById(R.id.btnCheese);
        btnPizza = findViewById(R.id.btnPizza);

        btnPanzerotti.setOnClickListener(this);
        btnCheese.setOnClickListener(this);
        btnWings.setOnClickListener(this);
        btnPizza.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        DBHelper dbHelper = new DBHelper(this);

        switch (view.getId())
        {
            case R.id.btnPizza:
                dbHelper.addItem("Pizza", 25.99);
                Toast.makeText(this, "Pizza Added to Cart", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnWings:
                break;
            case R.id.btnCheese:
                break;
            case R.id.btnPanzerotti:
                break;
        }
    }
}