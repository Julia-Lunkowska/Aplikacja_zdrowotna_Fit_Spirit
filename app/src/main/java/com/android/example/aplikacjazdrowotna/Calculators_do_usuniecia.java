package com.android.example.aplikacjazdrowotna;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;

public class Calculators_do_usuniecia extends AppCompatActivity {

    TextView text_bmi_weight, text_bmi_height, text_your_BMI, text_show_bmi;
    EditText edit_bmi_weight, edit_bmi_height;
    Button button_calculate_bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculators);

        text_bmi_weight = findViewById(R.id.text_weight_bmi);
        text_bmi_height = findViewById(R.id.text_height_bmi);
        text_your_BMI = findViewById(R.id.text_your_BMI);
        text_show_bmi = findViewById(R.id.text_show_bmi);
        edit_bmi_height = findViewById(R.id.edit_height_bmi);
        edit_bmi_weight = findViewById(R.id.edit_weight_bmi);
        button_calculate_bmi = findViewById(R.id.button_calculate_bmi);
        button_calculate_bmi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                calculateBMI();
            }

        });

    }

    public void calculateBMI (){
        float height = Float.parseFloat(edit_bmi_height.getText().toString())/100;
        float weight = Float.parseFloat(edit_bmi_weight.getText().toString());
        float BMI = weight / (height*height);
        BMI = Math.round(BMI);
        String description;

        if (BMI<16) {
            description = "Twoje BMI wynosi: "+BMI+". \nOznacza to wygłodzenie.";
            text_show_bmi.setText(description);
        }
        else if (BMI>=16 && BMI<=16.99) {
            description = "Twoje BMI wynosi: "+BMI+". \nOznacza to wychudzenie.";
            text_show_bmi.setText(description);
        }
        else if (BMI>=17 && BMI<=18.49) {
            description = "Twoje BMI wynosi: "+BMI+". \nOznacza to niedowagę.";
            text_show_bmi.setText(description);
        }
        else if (BMI>=18.50 && BMI<=24.99) {
            description = "Twoje BMI wynosi: "+BMI+". \nOznacza to prawidłową wagę.";
            text_show_bmi.setText(description);
        }
        else if (BMI>=25 && BMI<=29.99) {
            description = "Twoje BMI wynosi: "+BMI+". \nOznacza to nadwagę.";
            text_show_bmi.setText(description);
        }
        else if (BMI>=30 && BMI<=34.99) {
            description = "Twoje BMI wynosi: "+BMI+". \nOznacza to otyłość I stopnia.";
            text_show_bmi.setText(description);
        }
        else if (BMI>=35 && BMI<=39.99) {
            description = "Twoje BMI wynosi: "+BMI+". \nOznacza to otyłość II stopnia.";
            text_show_bmi.setText(description);
        }
        else if (BMI>=40) {
            description = "Twoje BMI wynosi: "+BMI+". \nOznacza to skrajną otyłość.";
            text_show_bmi.setText(description);
        }

    }
}
