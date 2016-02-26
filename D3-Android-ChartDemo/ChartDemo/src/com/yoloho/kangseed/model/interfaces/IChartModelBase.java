package com.yoloho.kangseed.model.interfaces;

import java.util.ArrayList;

public interface IChartModelBase<T> {
	int getId();

	ArrayList<T> updateData();
	
	ArrayList<T> getModes();
}
