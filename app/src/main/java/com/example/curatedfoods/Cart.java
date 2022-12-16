package com.example.curatedfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Cart extends AppCompatActivity {

    TextView cartValuesTV, itemQuantityTV, itemNamesTV;
    TextView totalTV, taxTV, finalTotalTV;
    String itemName, itemQuantity;
    GridLayout gridLayout;
    LinearLayout linearLayout;
    Button btnCheckout;
    DBHelper dbHelper = new DBHelper(this);

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        totalTV = new TextView(this);
        taxTV = new TextView(this);
        finalTotalTV = new TextView(this);
        btnCheckout = new Button(this);

        UpdateCart();
//


//        itemQuantityTV.setText(data);
        //itemQuantityTV.setText("Name" + arrOfStr[1]);

    }


    @SuppressLint("ResourceType")
    public void UpdateCart(){
        gridLayout = (GridLayout) findViewById(R.id.grLayout);
        gridLayout.removeAllViews();
        totalTV.setText("");
        taxTV.setText("");
        finalTotalTV.setText("");
        btnCheckout.setVisibility(View.GONE);;

        String data = dbHelper.displayItems();
        if(data.trim() != "No data found"){
            String[] arrOfStr = data.split("\n");
            int x = 1;
            for (int i = 0; i < arrOfStr.length; i++) {
                String [] itemRow = arrOfStr[i].split(",");
                for (int j = 0; j < itemRow.length; j++) {
                    TextView valueTV1 = new TextView(this);
                    valueTV1.setText(itemRow[j]);
                    valueTV1.setId(4);
                    valueTV1.setPadding(0, 10, 20, 0);
                    valueTV1.setTextColor(Color.BLACK);
                    valueTV1.setTextSize(13);
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
                btn.setPadding(20, 10, 0, 0);
                btn.setTextColor(Color.BLACK);
                btn.setTextSize(13);
                gridLayout.addView(btn);
                x++;
            }
            linearLayout = findViewById(R.id.linerLayout);



            if(linearLayout.getChildCount() < 3){
                totalTV.setId(4);
                totalTV.setPadding(20, 50, 0, 0);
                totalTV.setTextColor(Color.BLACK);
                totalTV.setTextSize(22);
                totalTV.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));

                taxTV.setId(4);
                taxTV.setPadding(20, 50, 0, 0);
                taxTV.setTextColor(Color.BLACK);
                taxTV.setTextSize(22);
                taxTV.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));

                finalTotalTV.setId(4);
                finalTotalTV.setPadding(20, 50, 0, 0);
                finalTotalTV.setTextColor(Color.BLACK);
                finalTotalTV.setTextSize(22);
                finalTotalTV.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));


                //Button btnCheckout = new Button(this);
                btnCheckout.setText("Checkout");
                btnCheckout.setTag("Checkout");
                //btn.setId(4);
                btnCheckout.setOnClickListener(click);
                btnCheckout.setPadding(20, 10, 0, 0);
                btnCheckout.setTextColor(Color.BLACK);
                btnCheckout.setTextSize(13);


                linearLayout.addView(totalTV);
                linearLayout.addView(taxTV);
                linearLayout.addView(finalTotalTV);
                linearLayout.addView(btnCheckout);
            }
            Double tax = Double.parseDouble(dbHelper.getCartTotal()) * .13;
            tax = Double.valueOf(Math.round(tax * 100));
            tax = tax/100;
            Double finalTotal = tax + Double.parseDouble(dbHelper.getCartTotal());
            finalTotal = Double.valueOf(Math.round(finalTotal * 100));
            finalTotal = finalTotal/100;
            totalTV.setText("Sub Total: $" + dbHelper.getCartTotal());
            taxTV.setText("Tax: $" + tax);
            finalTotalTV.setText("Total: $" + finalTotal);
            btnCheckout.setVisibility(View.VISIBLE);;





        }
        else{
            TextView valueTV1 = new TextView(this);
            valueTV1.setText("No items added");
            valueTV1.setPadding(0, 10, 0, 0);
            valueTV1.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            gridLayout.addView(valueTV1);
        }


    }

    View.OnClickListener click = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            Toast.makeText(Cart.this, view.getTag().toString().trim(), Toast.LENGTH_SHORT).show();

            switch(view.getTag().toString().trim()) {


                case "Burger":
                    Toast.makeText(Cart.this, view.getTag().toString() + " Deleted", Toast.LENGTH_SHORT).show();
                    dbHelper.deleteItem("Burger");
                    UpdateCart();
                    break;

                case "Croissant":
                    Toast.makeText(Cart.this, view.getTag().toString()+ " Deleted", Toast.LENGTH_SHORT).show();
                    dbHelper.deleteItem("Croissant");
                    UpdateCart();
                    break;


                case "Eggs":
                    Toast.makeText(Cart.this, view.getTag().toString()+ " Deleted", Toast.LENGTH_SHORT).show();
                    dbHelper.deleteItem("Eggs");
                    UpdateCart();
                    break;

                case "Salad":
                    Toast.makeText(Cart.this, view.getTag().toString()+ " Deleted", Toast.LENGTH_SHORT).show();
                    dbHelper.deleteItem("Salad");
                    UpdateCart();
                    break;

                case "Sandwich":
                    Toast.makeText(Cart.this, view.getTag().toString()+ " Deleted", Toast.LENGTH_SHORT).show();
                    dbHelper.deleteItem("Sandwich");
                    UpdateCart();
                    break;

                case "Waffle":
                    Toast.makeText(Cart.this, view.getTag().toString()+ " Deleted", Toast.LENGTH_SHORT).show();
                    dbHelper.deleteItem("Waffle");
                    UpdateCart();
                    break;

                case "Tacos":
                    Toast.makeText(Cart.this, view.getTag().toString()+ " Deleted", Toast.LENGTH_SHORT).show();
                    dbHelper.deleteItem("Tacos");
                    UpdateCart();
                    break;

                case "Sushi":
                    Toast.makeText(Cart.this, view.getTag().toString()+ " Deleted", Toast.LENGTH_SHORT).show();
                    dbHelper.deleteItem("Sushi");
                    UpdateCart();
                    break;


                case "Pizza":
                    Toast.makeText(Cart.this, view.getTag().toString()+ " Deleted", Toast.LENGTH_SHORT).show();
                    dbHelper.deleteItem("Pizza");
                    UpdateCart();

                    break;
                case "Wings":
                    Toast.makeText(Cart.this, view.getTag().toString()+ " Deleted", Toast.LENGTH_SHORT).show();
                    dbHelper.deleteItem("Wings");
                    UpdateCart();
                    break;
                case "Garlic Cheese":
                    Toast.makeText(Cart.this, view.getTag().toString()+ " Deleted", Toast.LENGTH_SHORT).show();
                    dbHelper.deleteItem("Garlic Cheese");
                    UpdateCart();
                    break;
                    //third button click
                case "Panzerotti":
                    Toast.makeText(Cart.this, view.getTag().toString()+ " Deleted", Toast.LENGTH_SHORT).show();
                    dbHelper.deleteItem("Panzerotti");
                    UpdateCart();
                    break;
                case "Checkout":
                    dbHelper.clearCart();
                    Toast.makeText(Cart.this, "Order Submitted", Toast.LENGTH_LONG).show();
                    UpdateCart();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent i=new Intent(getApplicationContext(),RestaurantActivity.class);
                            startActivity(i);
                        }
                    },3000);
                    break;
                default:
            }
        }
    };
}