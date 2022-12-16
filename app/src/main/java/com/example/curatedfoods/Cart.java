package com.example.curatedfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Cart extends AppCompatActivity {

    TextView cartValuesTV, itemQuantityTV, itemNamesTV;
    String itemName, itemQuantity;
    GridLayout gridLayout;
    DBHelper dbHelper = new DBHelper(this);

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        UpdateCart();
//


//        itemQuantityTV.setText(data);
        //itemQuantityTV.setText("Name" + arrOfStr[1]);

    }


    @SuppressLint("ResourceType")
    public void UpdateCart(){
        gridLayout = (GridLayout) findViewById(R.id.grLayout);
//        GridLayout.LayoutParams params = new GridLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        //gridLayout.setRowCount(row + 1)


//        cartValuesTV = findViewById(R.id.cartValuesTV);
//        itemQuantityTV = findViewById(R.id.itemQuantityTV);
//        itemNamesTV = findViewById(R.id.itemNamesTV);

        gridLayout.removeAllViews();
        //gridLayout.invalidate();



        String data = dbHelper.displayItems();

        String[] arrOfStr = data.split("\n");
        int x = 1;
        for (int i = 0; i < arrOfStr.length; i++) {
            String [] itemRow = arrOfStr[i].split(",");
            for (int j = 0; j < itemRow.length; j++) {
                TextView valueTV1 = new TextView(this);
                valueTV1.setText(itemRow[j]);
                valueTV1.setId(4);
                valueTV1.setPadding(20, 10, 0, 0);
                valueTV1.setTextColor(Color.BLACK);
                valueTV1.setTextSize(13);


                ;
                valueTV1.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
                gridLayout.addView(valueTV1);
            }
            Button btn = new Button(this);
            btn.setText("Delete");
            btn.setTag(itemRow[0].toString());
            //btn.setId(4);
            btn.setOnClickListener(click);
//            btn.setPadding(20, 10, 0, 0);
//            btn.setTextColor(Color.BLACK);
//            btn.setTextSize(13);
            gridLayout.addView(btn);

//            itemName = itemRow[0];
//            itemQuantity = itemRow[1];




//            TextView valueTV2 = new TextView(this);
//            valueTV2.setText(itemRow[1]);
//            valueTV2.setId(x);
//            valueTV2.setLayoutParams(test);
//
//            TextView valueTV3 = new TextView(this);
//            valueTV3.setText(itemRow[2]);
//            valueTV3.setId(x);
//            valueTV3.setLayoutParams(test);



//            linearLayout.addView(valueTV2);
//            linearLayout.addView(valueTV3);


            x++;
        }
    }

    View.OnClickListener click = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            Toast.makeText(Cart.this, view.getTag().toString().trim(), Toast.LENGTH_SHORT).show();

            switch(view.getTag().toString().trim()) {
                case "Pizza":
//                    Toast.makeText(Cart.this, view.getTag().toString(), Toast.LENGTH_SHORT).show();
                    dbHelper.deleteItem("Pizza");
                    UpdateCart();
                    //first button click
                    //Second button click
                    break;
                case "Wings":
                    Toast.makeText(Cart.this, view.getTag().toString(), Toast.LENGTH_SHORT).show();
                    dbHelper.deleteItem("Wings");
                    UpdateCart();
                    break;
                case "Garlic Cheese":
                    Toast.makeText(Cart.this, view.getTag().toString(), Toast.LENGTH_SHORT).show();
                    dbHelper.deleteItem("Garlic Cheese");
                    UpdateCart();
                    break;
                    //third button click
                case "Panzerotti":
                    Toast.makeText(Cart.this, view.getTag().toString(), Toast.LENGTH_SHORT).show();
                    dbHelper.deleteItem("Panzerotti");
                    UpdateCart();
                    break;
                    //fourth button click

//                default:
            }
        }
    };
}