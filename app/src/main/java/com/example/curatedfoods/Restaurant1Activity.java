package com.example.curatedfoods;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Restaurant1Activity extends AppCompatActivity implements View.OnClickListener {
    Button btnPizza, btnWings, btnCheese, btnPanzerotti;
    TextView testEDT;
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
        setContentView(R.layout.activity_restaurant1);

        // calling the action bar
        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Top Notch Pizza");

        btnPanzerotti =  findViewById(R.id.btnPanzerotti);
        btnWings = findViewById(R.id.btnWings);
        btnCheese = findViewById(R.id.btnCheese);
        btnPizza = findViewById(R.id.btnPizza);
        testEDT = findViewById(R.id.testEDT);

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
                Toast.makeText(this, "Pizza Added", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnWings:
                dbHelper.addItem("Wings", 14.99);
                Toast.makeText(this, "Wings Added", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnCheese:
                dbHelper.addItem("Garlic Cheese", 9.99);
//                testEDT.setText(dbHelper.deleteItem("Pizza"));
                //dbHelper.displayItems();
                Toast.makeText(this, "Garlic Cheese Added", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnPanzerotti:
                dbHelper.addItem("Panzerotti", 9.99);
//                testEDT.setText(dbHelper.deleteItem("Pizza"));
                //dbHelper.displayItems();
                Toast.makeText(this, "Panzerottie Added", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}