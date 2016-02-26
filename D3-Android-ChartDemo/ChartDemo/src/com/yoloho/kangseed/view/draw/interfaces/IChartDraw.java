package com.yoloho.kangseed.view.draw.interfaces;

import java.util.ArrayList;

import android.graphics.Canvas;

public interface IChartDraw<T> {
	/**
	 * 绘制大图
	 * 
	 * @param canvas
	 *            画布
	 * @param modes
	 *            数据源
	 * @param startX
	 *            起始X
	 * @param startY
	 *            起始Y
	 */
	public void drawChart(Canvas canvas, ArrayList<T> modes, int startX,
			int startY);
}
