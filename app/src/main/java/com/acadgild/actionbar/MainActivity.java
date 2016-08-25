package com.acadgild.actionbar;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

import com.acadgild.actionbar.adapter.TabsPagerAdapter;

public class MainActivity extends FragmentActivity implements
ActionBar.TabListener, OnPageChangeListener {

	private ViewPager viewPager;
	private TabsPagerAdapter mAdapter;//Tab pager adapter
	private ActionBar actionBar;

	// Tab titles
	private String[] tabs = { "Buttons", "Colors", "Images" };//Tabs contents

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Initilization
		viewPager = (ViewPager) findViewById(R.id.pager);//pager is the widget of the activity_main
		actionBar = getActionBar();//Will get the actionbar
		mAdapter = new TabsPagerAdapter(getSupportFragmentManager());//get the fragment inside the adapter

		viewPager.setAdapter(mAdapter);//View pager as the sliding widge to show the data writtern on the fragments
		actionBar.setHomeButtonEnabled(false);//used  in returning the Views for the actionBar and its disables
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);//

		// Adding Tabs
		for (String tab_name : tabs) {
			actionBar.addTab(actionBar.newTab().setText(tab_name)
					.setTabListener(this));
		}

		/**
		 * on swiping the viewpager make respective tab selected
		 * */
		viewPager.setOnPageChangeListener(this);//returning the Sliding View Content
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction transaction) {
		// on tab selected
		// show respected fragment view
		viewPager.setCurrentItem(tab.getPosition());
    }

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
	}

	@Override
	public void onPageSelected(int position) {
		// on changing the page
		// make respected tab selected
		actionBar.setSelectedNavigationItem(position);
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
	}
}
