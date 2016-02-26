package com.yoloho.kangseed.model;

import java.util.ArrayList;

import com.yoloho.kangseed.model.bean.PeriodBean;
import com.yoloho.kangseed.model.interfaces.IChartPeriodModel;

public class ChartPeriodModel implements IChartPeriodModel {
	ArrayList<PeriodBean> beans = new ArrayList<PeriodBean>();

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<PeriodBean> updateData() {
		// TODO Auto-generated method stub
		// beans =;
		return null;
	}

	@Override
	public int getAvgPeriod() {
		return 0;
	}

	@Override
	public ArrayList<PeriodBean> getModes() {
		return beans;
	}

}
