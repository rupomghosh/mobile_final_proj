package com.example.curatedfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Cart extends AppCompatActivity {

    TextView cartValuesTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        cartValuesTV = findViewById(R.id.cartValuesTV);
        DBHelper dbHelper = new DBHelper(this);


        cartValuesTV.setText(dbHelper.displayItems());

    }
}