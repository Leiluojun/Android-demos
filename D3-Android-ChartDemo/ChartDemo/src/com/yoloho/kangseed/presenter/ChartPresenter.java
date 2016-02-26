package com.yoloho.kangseed.presenter;

import java.util.ArrayList;

import com.yoloho.kangseed.model.interfaces.IChartModelBase;
import com.yoloho.kangseed.presenter.interfaces.IChartPresenter;
import com.yoloho.kangseed.view.interfaces.IChartViewBase;

public class ChartPresenter implements IChartPresenter {
	ArrayList<IChartViewBase> mChartViews = new ArrayList<IChartViewBase>();
	ArrayList<IChartModelBase> mChartModels = new ArrayList<IChartModelBase>();
	private static ChartPresenter mChartPresenter;

	public static synchronized ChartPresenter getInstance() {
		if (mChartPresenter == null) {
			mChartPresenter = new ChartPresenter();
		}
		return mChartPresenter;
	}

	@Override
	public void update(int id) {
		// TODO Auto-generated method stub
		IChartModelBase chartModelBase = getModel(id);
		if (chartModelBase != null) {
			chartModelBase.updateData();
		}
		for (IChartViewBase chartViewBase : mChartViews) {
			chartViewBase.updateUI();
		}
	}

	@Override
	public void updateAll() {
		// TODO Auto-generated method stub
		for (IChartModelBase chartModelBase : mChartModels) {
			chartModelBase.updateData();
		}
		for (IChartViewBase chartViewBase : mChartViews) {
			chartViewBase.updateUI();
		}
	}

	@Override
	public void registModel(IChartModelBase chartModelBase) {
		// TODO Auto-generated method stub
		mChartModels.add(chartModelBase);
	}

	@Override
	public void registView(IChartViewBase chartViewBase) {
		// TODO Auto-generated method stub
		mChartViews.add(chartViewBase);
	}

	@Override
	public void unRegistModel(IChartModelBase chartModelBase) {
		// TODO Auto-generated method stub
		mChartModels.remove(chartModelBase);
	}

	@Override
	public void unRegistView(IChartViewBase chartViewBase) {
		// TODO Auto-generated method stub
		mChartViews.remove(chartViewBase);
	}

	@Override
	public void unRegistAll() {
		// TODO Auto-generated method stub
		mChartViews.clear();
		mChartModels.clear();
	}

	@Override
	public IChartModelBase getModel(int id) {
		// TODO Auto-generated method stub
		for (IChartModelBase chartModelBase : mChartModels) {
			if (id == chartModelBase.getId()) {
				return chartModelBase;
			}
		}
		return null;
	}

}
