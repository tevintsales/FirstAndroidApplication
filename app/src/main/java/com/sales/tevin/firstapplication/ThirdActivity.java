package com.sales.tevin.firstapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        TextView name_text = (TextView) findViewById(R.id.name_text);
        Intent intent = getIntent();
        Toast.makeText(this, intent.getStringExtra("name"), Toast.LENGTH_SHORT).show();
    }
}
