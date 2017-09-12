package com.sales.tevin.firstapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CurrencyConverter extends AppCompatActivity {

    public void convertToYen(View view){
        EditText currencyEditText = (EditText) findViewById(R.id.currency_edit_text);

        TextView currencyText = (TextView) findViewById(R.id.currency_text);

        String currencyString = currencyEditText.getText().toString();
        Double amountInYen = Double.parseDouble(currencyString) * 109.36;

        currencyText.setText("Amount in dollars: " + currencyString + "\n" + "Amount in Yen: "+ String.format("%.2f", amountInYen));
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_converter);
    }
}
