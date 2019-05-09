package com.android.example.aplikacjazdrowotna;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class GL_fragment extends Fragment {

    Spinner spinner_gl;
    TextView text_description_gl, text_portion_gl, text_calculate_GL, text_product_gl;
    EditText edit_portion_gl;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.gl_fragment, container, false);
        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        spinner_gl = view.findViewById(R.id.spinner_gl);
        text_description_gl=view.findViewById(R.id.text_description_gl);
        text_portion_gl = view.findViewById(R.id.text_portion_gl);
        text_calculate_GL = view.findViewById(R.id.text_calculate_GL);
        text_product_gl = view.findViewById(R.id.text_product_gl);
        edit_portion_gl = view.findViewById(R.id.edit_portion_gl);


        return view;
    }

    public void calculate_GL(){

    }
}
