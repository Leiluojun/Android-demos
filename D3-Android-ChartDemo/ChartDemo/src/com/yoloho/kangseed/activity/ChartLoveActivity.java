package com.yoloho.kangseed.activity;

import java.util.ArrayList;

import com.yoloho.kangseed.view.ChartTabView;
import com.yoloho.kangseed.view.fragmentpageadapter.FragmentPagerAdapter;
import com.yoloho.kangseed.view.interfaces.IChartActivity;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

public class ChartLoveActivity extends Activity implements IChartActivity {
	private ViewPager mViewPager;
	private ArrayList<Fragment> mFragments;

	public final static int LOVE = 1;

	public final static int PERIOD = 2;

	public final static String TYPE = "type";

	private int mType;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setTabView();
		initData();
		setAdapter();
		mType = getIntent().getIntExtra(TYPE, -1);
	}

	@Override
	public void setTabView() {
		ChartTabView tabView = new ChartTabView(ChartLoveActivity.this, mViewPager);
		// setCuctomTitleLayout(tabView);
	}

	@Override
	public void setAdapter() {
		// mViewPager.setAdapter(new FragmentPagerApdater);
	}

	@Override
	public void initData() {
		switch (mType) {
		case LOVE:
			// mFragments.add(new LoveChartFragment);
			// mFragments.add(new LoveDataFragment);
			break;
		case PERIOD:
			// mFragments.add(new PeriodChartFragment);
			// mFragments.add(new PeriodDataFragment);
			break;
		default:
			break;
		}

	}

}
