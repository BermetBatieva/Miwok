package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new NumbersFragment()).commit();
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        MiwokFragmentPagerAdapter miwokFragmentPagerAdapter = new MiwokFragmentPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(miwokFragmentPagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}

