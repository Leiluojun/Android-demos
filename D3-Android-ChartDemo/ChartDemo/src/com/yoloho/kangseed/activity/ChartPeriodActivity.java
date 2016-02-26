package com.yoloho.kangseed.activity;

import com.yoloho.kangseed.model.ChartPeriodModel;
import com.yoloho.kangseed.presenter.ChartPresenter;
import com.yoloho.kangseed.view.interfaces.IChartPeriodView;

import android.app.Activity;
import android.os.Bundle;

public class ChartPeriodActivity extends Activity implements IChartPeriodView{
	ChartPeriodModel chartPeriodModel = new ChartPeriodModel();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ChartPresenter.getInstance().registView(this);
	}
	@Override
	public void updateUI() {
		// TODO Auto-generated method stub
	}

	@Override
	public void setTip(String title, String content) {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
}
