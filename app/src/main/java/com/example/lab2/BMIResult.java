package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class BMIResult extends AppCompatActivity {


    //variables
    double weight, height;
    Button Finishbutton;
    TextView TxtAns, TxtResult;
    ImageView bmiArrow;
    float Answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiresult);
        //transferring values from main to this activity
        Bundle details = getIntent().getExtras();
        weight = details.getFloat("weight");
        height = details.getFloat("height");

        //finding views
        TxtAns = findViewById(R.id.BMIAnswer);
        bmiArrow = findViewById(R.id.bmiArrow);
        TxtResult = findViewById(R.id.BmiResult);

        Answer = (float) (weight /  (height*height) * 10000);

        //Formatting to 2 decimal places
        String formattedAns = String.format("%.2f", Answer);

        TxtAns.setText((formattedAns));

        if (Answer < 18.5){
            TxtResult.setText("UnderWeight");
        } else if (Answer > 24.9) {
            TxtResult.setText("Overweight");
        }else{
            TxtResult.setText("Normal");
        }

        //Adjusting the arrow according to the answer.

        //range of the bmi
        float minBMI = 10F;
        float maxBMI = 30F;
        // locate the arrow within the range of the min max bmi
        float normalizedPosition = (Answer - minBMI) / (maxBMI - minBMI);



        // Calculate the position of the arrow
        int arrowPosition = (int) (normalizedPosition * 950);

        // Update the arrows position
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) bmiArrow.getLayoutParams();
        layoutParams.leftMargin = arrowPosition;  // Adjusts the arrow from the left
        bmiArrow.setLayoutParams(layoutParams);


        //when clicked returns to the main activity
        Finishbutton = findViewById(R.id.btnFinish);
        Finishbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                Intent Return = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(Return);

            }
        });
    }

}