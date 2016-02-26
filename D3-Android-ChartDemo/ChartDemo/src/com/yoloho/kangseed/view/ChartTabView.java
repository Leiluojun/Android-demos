package com.yoloho.kangseed.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.LinearLayout;

public class ChartTabView extends LinearLayout implements OnPageChangeListener {
	private ViewPager mViewPager;

	public ChartTabView(Context context, ViewPager viewPager) {
		super(context);
		this.mViewPager = viewPager;
		initView();
	}



	/**
	 * 初始化tabview的布局
	 */
	private void initView() {
		// 绑定viewpager
		mViewPager.setOnPageChangeListener(this);
	}

	/**
	 * tab的点击事件处理
	 */
	private void setEvent() {

	}

	@Override
	public void onPageScrollStateChanged(int arg0) {

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {

	}

	@Override
	public void onPageSelected(int arg0) {
		mViewPager.setCurrentItem(arg0);
	}

}
