package com.bipuldevashish.justjava;

import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    String hasWhippedCream,hasChocolate;
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
        String name;
        EditText editText = findViewById(R.id.name_edittext);
        name = editText.getText().toString();
        CheckBox checkBox = findViewById(R.id.notify_me_checkbox);
        CheckBox checkBox_chocolate = findViewById(R.id.notify_me_checkbox_chocolate);
        if (checkBox.isChecked()){
            hasWhippedCream = "yes";
        }
        else{
            hasWhippedCream = "No";
        }

        if (checkBox_chocolate.isChecked()){
            hasChocolate = "yes";
        }
        else{
            hasChocolate = "No";
        }


        int price = calculatePrice(hasChocolate,hasWhippedCream);
        orderSummary(price,quantity,name,hasWhippedCream,hasChocolate);
    }

    public void orderSummary(int value,int quantity,String name,String cream,String choco){
             String Data = "Name - "+ name + "\n" + "Quantity - " + quantity + "\n" +
            "Wipped cream - " + cream + "\n" + "Chocolate -" + choco +
                "\n" + "Total - $" + value + "\n" +"Thank you!";
        TextView textView = findViewById(R.id.orderSummary_text_view);
        textView.setText(Data);
        String subject = "CoFFee order for " + name;
        String address[] = new String[]{"aryanbipul@gmail.com"};
        composeEmail(address,subject,Data);
    }

    public void composeEmail(String[] addresses, String subject, String data) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:" )); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, data);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private int calculatePrice(String whipped, String chocolate) {
        int price = 0;
        if (hasWhippedCream == "yes"){
            price = price + (quantity*1);
        }
        if (hasChocolate == "yes"){
            price = price + (quantity*2);
        }
        price = price +(quantity *5);
        return price;
    }

    public void display(int number){
        TextView textView = findViewById(R.id.quantity_text_view);
        textView.setText("" + number);
    }

}
