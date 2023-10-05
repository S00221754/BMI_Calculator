package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //declaring variables
    EditText addWeight, addHeight;

    TextView error;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //finding views
        error = findViewById(R.id.errorMessage);
        addWeight = findViewById(R.id.enterWeight);
        addHeight = findViewById(R.id.enterHeight);



      button = findViewById(R.id.buttonCalc);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Parse weight and height as floats
                float weightValue, heightValue;

                //Checking if numbers are entered
                try {
                    weightValue = Float.parseFloat(addWeight.getText().toString());
                    heightValue = Float.parseFloat(addHeight.getText().toString());
                } catch (NumberFormatException e) {
                    error.setText("Invalid Input!");
                    return;
                }

                // Checking if values are in the suitable range
                if (weightValue < 20 || weightValue > 200 || heightValue < 80 || heightValue > 300) {
                    error.setText("Invalid Input!");
                } else {
                    Intent BMIActivity = new Intent(getApplicationContext(), BMIResult.class);
                    BMIActivity.putExtra("weight", weightValue);
                    BMIActivity.putExtra("height", heightValue);
                    startActivity(BMIActivity);
                }
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