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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class WHR_fragment extends Fragment {

    TextView text_whr_waist, text_whr_hip, text_your_WHR, text_show_whr, text_whr_sex, text_description;
    EditText edit_whr_waist, edit_whr_hip;
    Button button_calculate_whr;
    RadioButton radio_whr_woman, radio_whr_man;
    RadioGroup radioGroup_whr;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.whr_fragment, container, false);
        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        text_whr_waist = view.findViewById(R.id.text_waist_whr);
        text_whr_hip = view.findViewById(R.id.text_hip_whr);
        text_your_WHR = view.findViewById(R.id.text_your_WHR);
        text_show_whr = view.findViewById(R.id.text_show_whr);
        text_whr_sex = view.findViewById(R.id.text_whr_sex);
        text_description = view.findViewById(R.id.text_description_whr);
        edit_whr_hip = view.findViewById(R.id.edit_hip_whr);
        edit_whr_waist = view.findViewById(R.id.edit_waist_whr);
        button_calculate_whr = view.findViewById(R.id.button_calculate_whr);
        radio_whr_man = view.findViewById(R.id.radioButton_whr_man);
        radio_whr_woman = view.findViewById(R.id.radioButton_whr_woman);
        radioGroup_whr = view.findViewById(R.id.radioGroup_whr);

        button_calculate_whr.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View view) {
                                                        calculate_WHR();
                                                    }
                                                }
        );
        return view;
    }

    public void calculate_WHR() {
        Float hip = Float.parseFloat(edit_whr_hip.getText().toString());
        Float waist = Float.parseFloat(edit_whr_waist.getText().toString());

        Float WHR = waist / hip;
        String description;

        if ((radio_whr_woman.isChecked() && WHR >= 0.8) || (!radio_whr_man.isChecked() && WHR >= 1.0)) {
            description = "Twój wskaźnik WHR wynosi: " + WHR + "." + System.lineSeparator() + "Wskazuje " +
                    "to na otyłość typu jabłko. ";
            text_show_whr.setText(description);
        } else if ((radio_whr_woman.isChecked() && WHR < 0.8) || (radio_whr_man.isChecked() && WHR < 1.0)) {
            description = "Twój wskaźnik WHR wynosi: " + WHR + "." + System.lineSeparator() + "Wskazuje " +
                    "to na otyłość typu gruszka. ";
            text_show_whr.setText(description);
        }
    }


}


