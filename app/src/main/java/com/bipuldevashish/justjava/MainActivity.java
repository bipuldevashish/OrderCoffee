package com.bipuldevashish.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void increment(View view){
        quantity = quantity + 1;
        display(quantity);
    }

    public void decrement(View view){
        if (quantity <= 0){
            Toast.makeText(MainActivity.this,"Invalid input please try again",Toast.LENGTH_SHORT).show();
        }
        else {
            quantity = quantity - 1;
            display(quantity);
        }
    }

    public void submitOrder(View view){
        String priceMessage = ("Total = $" + quantity*5 + "\n" +"Thank you!");
        displayMessage(priceMessage);
    }

    public void display(int number){
        TextView textView = findViewById(R.id.quantity_text_view);
        textView.setText("" + number);
    }

    public void displayPrice(int number){
        TextView textView = findViewById(R.id.price_text_view);
        textView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    private void displayMessage(String message) {
        TextView priceTextView = findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }
}
