package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText addWeight, addHeight;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addWeight = findViewById(R.id.enterWeight);
        addHeight = findViewById(R.id.enterHeight);

      button = findViewById(R.id.buttonCalc);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                Intent BMIActivity = new Intent(getApplicationContext(), BMIResult.class);
                BMIActivity.putExtra("weight", Float.parseFloat(addWeight.getText().toString()));
                BMIActivity.putExtra("height", Float.parseFloat(addHeight.getText().toString()));
                startActivity(BMIActivity);
            }
        });

    }
    //Clears weight and height when clicked.
    public void Clear(View v)
    {
        addWeight.getText().clear();
        addHeight.getText().clear();
    }


}