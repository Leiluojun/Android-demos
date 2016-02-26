package com.yoloho.kangseed.presenter.interfaces;

import com.yoloho.kangseed.model.interfaces.IChartModelBase;
import com.yoloho.kangseed.view.interfaces.IChartViewBase;

public interface IChartPresenter {
	void update(int id);

	void updateAll();

	void registModel(IChartModelBase chartModelBase);

	void registView(IChartViewBase chartViewBase);

	void unRegistModel(IChartModelBase chartModelBase);

	void unRegistView(IChartViewBase chartViewBase);

	void unRegistAll();

	IChartModelBase getModel(int id);
}
