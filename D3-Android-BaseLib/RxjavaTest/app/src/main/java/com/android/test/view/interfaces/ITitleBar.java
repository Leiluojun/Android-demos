package com.android.test.view.interfaces;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 标题栏View接口
 *
 * @author yezi
 * @version 1.0 16/2/2
 */
public interface ITitleBar {
    /**
     * 显示返回按钮
     */
    void showBack();

    /**
     * 设置标题栏
     */
    void setTitle(String title);

    /**
     * 获取左侧文字Textview
     *
     * @return TextView
     */
    TextView getLeftText();

    /**
     * 获取右侧文字Textview
     *
     * @return TextView
     */
    TextView getRightText();

    /**
     * 获取左侧图片按钮控件
     *
     * @return ImageView
     */
    ImageView getLeftImage();

    /**
     * 获取右侧图片按钮控件
     *
     * @return ImageView
     */
    ImageView getRightImage();

    /**
     * 替换标题栏区域view
     */
    void replaceTitleView(View view);

    /**
     * 替换右侧按钮区域view
     */
    void replaceRightView(View view);

    /**
     * 替换左侧按钮区域view
     */
    void replaceLeftView(View view);
}
