package com.example.curatedfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Cart extends AppCompatActivity {

    TextView cartValuesTV, itemQuantityTV, itemNamesTV;
    String itemName, itemQuantity;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);






        setContentView(R.layout.activity_cart);


//
//
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.grLayout);
        LinearLayout.LayoutParams test = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);


        cartValuesTV = findViewById(R.id.cartValuesTV);
        itemQuantityTV = findViewById(R.id.itemQuantityTV);
        itemNamesTV = findViewById(R.id.itemNamesTV);

        DBHelper dbHelper = new DBHelper(this);
        String data = dbHelper.displayItems();
        String[] arrOfStr = data.split("\n");
//        int x = 1;
//        for (int i = 0; i < arrOfStr.length; i++) {
//            String [] itemRow = arrOfStr[i].split(",");
////            itemName = itemRow[0];
////            itemQuantity = itemRow[1];
//            TextView valueTV = new TextView(this);
//            valueTV.setText(itemRow[0] + " Price: " + itemRow[1] + " " );
//            valueTV.setId(x);
//            valueTV.setLayoutParams(test);
//            linearLayout.addView(valueTV);
//
//
//            x++;
//        }

        itemQuantityTV.setText(data);
        //itemQuantityTV.setText("Name" + arrOfStr[1]);

    }
}