package com.android.example.aplikacjazdrowotna;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class BMI_fragment extends Fragment {

    TextView text_bmi_weight, text_bmi_height, text_your_BMI, text_show_bmi;
    EditText edit_bmi_weight, edit_bmi_height;
    Button button_calculate_bmi;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bmi_fragment, container, false);
        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        text_bmi_weight = view.findViewById(R.id.text_weight_bmi);
        text_bmi_height = view.findViewById(R.id.text_height_bmi);
        text_your_BMI = view.findViewById(R.id.text_your_BMI);
        text_show_bmi = view.findViewById(R.id.text_show_bmi);
        edit_bmi_height = view.findViewById(R.id.edit_height_bmi);
        edit_bmi_weight = view.findViewById(R.id.edit_weight_bmi);
        button_calculate_bmi = view.findViewById(R.id.button_calculate_bmi);
        button_calculate_bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateBMI();
            }
        }
        );

        return view;
    }

    public void calculateBMI() {
        float height = Float.parseFloat(edit_bmi_height.getText().toString()) / 100;
        float weight = Float.parseFloat(edit_bmi_weight.getText().toString());
        float BMI = weight / (height * height);
        BMI = Math.round(BMI);
        String description;

        if (BMI < 16) {
            description = "Twoje BMI wynosi: " + BMI + "."+ System.lineSeparator()+ "Oznacza to wygłodzenie.";
            text_show_bmi.setText(description);
        } else if (BMI >= 16 && BMI <= 16.99) {
            description = "Twoje BMI wynosi: " + BMI + "." + System.lineSeparator() +"Oznacza to wychudzenie.";
            text_show_bmi.setText(description);
        } else if (BMI >= 17 && BMI <= 18.49) {
            description = "Twoje BMI wynosi: " + BMI +"."+ System.lineSeparator()+ "Oznacza to niedowagę.";
            text_show_bmi.setText(description);
        } else if (BMI >= 18.50 && BMI <= 24.99) {
            description = "Twoje BMI wynosi: " + BMI + "."+System.lineSeparator() + "Oznacza to prawidłową wagę.";
            text_show_bmi.setText(description);
        } else if (BMI >= 25 && BMI <= 29.99) {
            description = "Twoje BMI wynosi: " + BMI + "."+System.lineSeparator() + "Oznacza to nadwagę.";
            text_show_bmi.setText(description);
        } else if (BMI >= 30 && BMI <= 34.99) {
            description = "Twoje BMI wynosi: " + BMI +"."+ System.lineSeparator()+ "Oznacza to otyłość I stopnia.";
            text_show_bmi.setText(description);
        } else if (BMI >= 35 && BMI <= 39.99) {
            description = "Twoje BMI wynosi: " + BMI + "."+System.lineSeparator() + "Oznacza to otyłość II stopnia.";
            text_show_bmi.setText(description);
        } else if (BMI >= 40) {
            description = "Twoje BMI wynosi: " + BMI +"."+ System.lineSeparator() +"Oznacza to skrajną otyłość.";
            text_show_bmi.setText(description);
        }

    }
}

