package com.example.andela.lukaround.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.andela.lukaround.MapsActivity;
import com.example.andela.lukaround.R;
import com.example.andela.lukaround.adapters.ViewPagerAdapter;
import com.example.andela.lukaround.fragments.HomeFragment;
import com.example.andela.lukaround.fragments.Interests;
import com.example.andela.lukaround.fragments.Timeline;
import com.example.andela.lukaround.slider.SlidingTabLayout;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final Fragment[] fragments=new Fragment[]{new Interests(),new HomeFragment(),new Timeline()};
    ViewPager pager;
    ViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    private DrawerLayout mDrawerLayout;
    private NavigationView navigationView;
    private ImageView headline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    private void init() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Creating The ViewPagerAdapter and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.
        adapter =  new ViewPagerAdapter(getSupportFragmentManager(), Arrays.asList(fragments));

        // Assigning ViewPager View and setting the adapter
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);

        // Assiging the Sliding Tab Layout View
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

        // Setting Custom Color for the Scroll bar indicator of the Tab View
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.negativeButtonColor);
            }
        });

        // Setting the ViewPager For the SlidingTabsLayout
        tabs.setViewPager(pager);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        headline = (ImageView) findViewById(R.id.view_headline);
        headline.setOnClickListener(this);
        navigationView = (NavigationView) findViewById(R.id.nav_items);
        setupDrawerContent(navigationView);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.view_headline:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
        }
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    private void selectDrawerItem(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.friends:
                Intent intent = new Intent(this, MapsActivity.class);
                startActivity(intent);
                break;
        }
    }
}
