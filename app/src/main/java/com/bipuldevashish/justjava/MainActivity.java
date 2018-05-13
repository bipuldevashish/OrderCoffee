package com.bipuldevashish.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    String hasWhippedCream,name;
    int quantity = 2;
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
            Toast.makeText(MainActivity.this,"Invalid input please try again",
                    Toast.LENGTH_SHORT).show();
        }
        else {
            quantity = quantity - 1;
            display(quantity);
        }
    }

    public void submitOrder(View view){
        int price = calculatePrice();
        EditText editText = findViewById(R.id.name_edittext);
        name = editText.getText().toString();
        CheckBox checkBox = findViewById(R.id.notify_me_checkbox);
        if (checkBox.isChecked()){
            hasWhippedCream = "yes";
        }
        else{
            hasWhippedCream = "No";
        }
        orderSummary(price,quantity,name,hasWhippedCream);
    }

    public void orderSummary(int value,int quantity,String name,String cream){
        TextView textView = findViewById(R.id.orderSummary_text_view);
        textView.setText("Name = "+ name + "\n" +"Quantity = " + quantity + "\n"
                +"Wipped cream = " + cream +  "\n" + "Total = $" + value + "\n" +"Thank you!");
    }

    private int calculatePrice() {
        int price = quantity *5;
        return price;
    }

    public void display(int number){
        TextView textView = findViewById(R.id.quantity_text_view);
        textView.setText("" + number);
    }

}
