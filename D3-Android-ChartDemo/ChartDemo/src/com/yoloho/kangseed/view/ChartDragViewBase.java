package com.yoloho.kangseed.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import android.widget.ScrollView;

/**
 * 统计滑动viewbase
 * <p>
 * <li>如果需要支持放大需要setZoom，同时重新onzoom方法。
 * </p>
 * 
 * @author yezi
 * 
 */
public abstract class ChartDragViewBase extends View implements OnTouchListener {

	/**
	 * 左右滑动偏移量
	 */
	private float mScrollX = 0.0f;
	private float mStartX = 0.0f;
	private float mInitScrollx;
	private float mMinScrollx;
	private float mMaxScrollx;
	/**
	 * 是否支持放大，如果支持需要重写onZoom方法
	 */
	private boolean mZoom = false;
	private boolean mDoublePoint = false;
	private float mStartDiffX = 0;
	private float mStartDiffY = 0;

	public ChartDragViewBase(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	/**
	 * 托动过程回调
	 * 
	 * @param canvas
	 * @param dragX
	 */
	abstract void onDrag(Canvas canvas, float dragX);

	/**
	 * 长宽比
	 * 
	 * @return
	 */
	public abstract float getWHRatio();

	/**
	 * 获取滑动横向距离
	 * 
	 * @return
	 */
	public float getChartScrollX() {
		return mScrollX;
	}

	/**
	 * 设置横向滑动距离
	 * 
	 * @param scrollX
	 */
	public void setChartScrollX(float scrollX) {
		mScrollX = scrollX;
	}

	/**
	 * 可以滑动的范围 max > min
	 * 
	 * @param min
	 * @param max
	 */
	public void setScrollRange(float min, float max) {
		mMinScrollx = min;
		mMaxScrollx = max;
	}

	/**
	 * 设置支持放大缩小
	 */
	protected void setZoom() {
		mZoom = true;
	}

	/**
	 * 可以滑动的范围 max > min
	 * 
	 * @param diffX
	 * @param diffY
	 */
	protected void onZoom(float diffX, float diffY) {

	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			if (mStartX == 0) {
				mStartX = event.getX();
				mInitScrollx = mScrollX;
			}
			disableScrollView(true);
			break;
		case MotionEvent.ACTION_MOVE:
			if (mZoom && mDoublePoint) {
				float diffX = event.getX(0) - event.getX(1);
				float diffY = event.getY(0) - event.getY(1);
				onZoom(diffX - mStartDiffX, diffY - mStartDiffY);
				mStartDiffX = diffX;
				mStartDiffY = diffY;
			} else {
				float scrollX = event.getX() - mStartX + mInitScrollx;
				if (scrollX >= mMaxScrollx) {
					mScrollX = mMaxScrollx;
				} else if (scrollX <= mMinScrollx) {
					mScrollX = mMinScrollx;
				} else {
					mScrollX = event.getX() - mStartX + mInitScrollx;
				}
			}
			invalidate();
			break;
		case MotionEvent.ACTION_UP:
			if (mClickListener != null) {
				mClickListener.onViewClick(v);
			}
			mStartX = 0;
			invalidate();
			disableScrollView(false);
			break;
		case MotionEvent.ACTION_POINTER_DOWN:
			mDoublePoint = true;
			mStartDiffX = event.getX(0) - event.getX(1);
			mStartDiffY = event.getY(0) - event.getY(1);
			break;
		case MotionEvent.ACTION_POINTER_UP:
			mDoublePoint = false;
			mStartDiffY = 0;
			mStartDiffX = 0;
			break;
		case MotionEvent.ACTION_POINTER_2_DOWN:
			mStartDiffX = event.getX(0) - event.getX(1);
			mStartDiffY = event.getY(0) - event.getY(1);
			mDoublePoint = true;
			break;
		case MotionEvent.ACTION_POINTER_2_UP:
			mDoublePoint = false;
			mStartDiffY = 0;
			mStartDiffX = 0;
			break;
		default:
			mStartX = 0;
			invalidate();
			disableScrollView(false);
			break;
		}
		return true;
	}

	/**
	 * @param isDisable
	 */
	private void disableScrollView(boolean isDisable) {
		ViewParent parent = getParent();
		if (parent != null) {
			do {
				if (parent instanceof ScrollView) {
					parent.requestDisallowInterceptTouchEvent(isDisable);
					break;
				}
				parent = parent.getParent();
			} while (parent != null);
		}
	}

	public interface ClickListener {
		public void onViewClick(View v);
	}

	private ClickListener mClickListener;

	public void setOnClickListener(ClickListener listener) {
		this.mClickListener = listener;
	}
}
