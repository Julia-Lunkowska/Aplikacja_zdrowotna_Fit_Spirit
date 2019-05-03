package com.android.example.aplikacjazdrowotna;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class Calculators extends AppCompatActivity {

    SectionPageAdapter mSectionPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculators);

        mSectionPageAdapter = new SectionPageAdapter(getSupportFragmentManager());

        ViewPager mViewPager = findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        SectionPageAdapter adapter = new SectionPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new BMI_fragment(), "Body Mass Index");
        adapter.addFragment(new WHR_fragment(), "Waist/Hip Ratio");
        viewPager.setAdapter(adapter);
    }
}