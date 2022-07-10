package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * Это приложение отображает форму заказа для заказа кофе.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Этот метод вызывается при нажатии кнопки заказа.
     */

    private int calculatePrice(boolean addWhippedCream, boolean addChocolate) {

        int basePrice = 5;
        if(addWhippedCream){
            basePrice = basePrice + 1 ;
        }
        if(addChocolate){
            basePrice = basePrice + 2;
        }
        return quantity * basePrice;
    }



    public void submitOrder(View view) {
        EditText nameOfCustomer = (EditText) findViewById(R.id.NameClient_view);
        String name = nameOfCustomer.getText().toString();

        CheckBox whippedCreamCheckBox= (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        Boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        CheckBox chocolateCheckBox= (CheckBox) findViewById(R.id.chocolate_checkbox);
        Boolean hasChocolate = chocolateCheckBox.isChecked();

        int price =  calculatePrice(hasWhippedCream, hasChocolate);
        String orderSummary = createOrderSummary(name,price,hasWhippedCream,hasChocolate);
        displayMessage(orderSummary);

    }

    private String createOrderSummary(String name, int price, Boolean hasWhippedCream, Boolean hasChocolate) {
        return  name+"\nAdd Whipped Cream? "+hasWhippedCream+"\nAdd Chocolate? "+hasChocolate+"\nQuantity : "+quantity+"\nTotal: $"+price+"\nThank you!";
    }

    public boolean addWhippedCream(View view) {
        CheckBox checkBox = findViewById(R.id.whipped_cream_checkbox);
        boolean isCheckBox = checkBox.isChecked();
        return isCheckBox;
    }

    public boolean addChocolate(View view) {
        CheckBox checkBoxC = findViewById(R.id.chocolate_checkbox);
        boolean isCheckBoxC = checkBoxC.isChecked();
        return isCheckBoxC;
    }

    public void increment(View view){
        if(quantity < 100) {
            quantity = quantity + 1;
        }
        display(quantity);
    }

    public void decrement(View view){
        if(quantity > 1) {
            quantity = quantity - 1;
        }
        display(quantity);
    }

    private String nameClient() {
        EditText nameClient = (EditText) findViewById(R.id.NameClient_view);
        Editable nameEditable = nameClient.getText();
        String name = nameEditable.toString();
        return name;
    }

    /**
     * Этот метод отображает заданное значение количества на экране.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * Этот метод отображает заданную цену на экране.
     */
/*    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }*/

    /**
     * Этот метод отображает заданный текст на экране.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

}