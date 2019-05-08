package com.android.example.aplikacjazdrowotna;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;


public class Calculators extends NavigationDrawer {

    SectionPageAdapter mSectionPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculators);
        super.onCreateDrawer();

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View ContentView = inflater.inflate(R.layout.activity_calculators, null, false);
        drawer.addView(ContentView, 0);

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

