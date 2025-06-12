package com.saloko.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText weightInput, heightInput;
    Button calculateButton;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightInput = findViewById(R.id.weightInput);
        heightInput = findViewById(R.id.heightInput);
        calculateButton = findViewById(R.id.calculateButton);
        resultText = findViewById(R.id.resultText);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String weightStr = weightInput.getText().toString();
                String heightStr = heightInput.getText().toString();

                if (!weightStr.isEmpty() && !heightStr.isEmpty()) {
                    double weight = Double.parseDouble(weightStr);
                    double heightCm = Double.parseDouble(heightStr);
                    double heightM = heightCm / 100;

                    double bmi = weight / (heightM * heightM);
                    String category;

                    if (bmi < 18.5) {
                        category = "Underweight";
                    } else if (bmi < 25) {
                        category = "Normal";
                    } else if (bmi < 30) {
                        category = "Overweight";
                    } else {
                        category = "Obese";
                    }

                    String result = String.format("BMI: %.2f\nCategory: %s", bmi, category);
                    resultText.setText(result);
                } else {
                    resultText.setText("Please enter valid weight and height.");
                }
            }
        });
    }
}
