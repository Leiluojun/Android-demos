package com.android.test.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.rxjavatest.R;
import com.android.test.view.interfaces.ITitleBar;
import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.view.ViewClickEvent;

import java.util.concurrent.TimeUnit;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.functions.Action1;

/**
 * 标题栏
 *
 * @author yezi
 * @version 1.0 16/2/2
 */
public class CustomTitleBar extends FrameLayout implements ITitleBar {
    @Bind(R.id.tvLeftText)
    TextView tvLeftText;
    @Bind(R.id.ivLeftImage)
    ImageView ivLeftImage;
    @Bind(R.id.flLeftRoot)
    FrameLayout flLeftRoot;
    @Bind(R.id.tvRightText)
    TextView tvRightText;
    @Bind(R.id.ivRightImage)
    ImageView ivRightImage;
    @Bind(R.id.flRighttRoot)
    FrameLayout flRighttRoot;
    @Bind(R.id.flTitleRoot)
    FrameLayout flTitleRoot;
    @Bind(R.id.tvTitle)
    TextView tvTitle;

    public CustomTitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.view_titlebar, this);
        ButterKnife.bind(this);
    }

    @Override
    public void showBack() {
        ivLeftImage.setVisibility(View.VISIBLE);
        RxView
                .clickEvents(ivLeftImage)
                .throttleFirst(500, TimeUnit.MILLISECONDS)
                .subscribe(new Action1<ViewClickEvent>() {
                    @Override
                    public void call(ViewClickEvent viewClickEvent) {
                        if (getContext() instanceof Activity) {
                            ((Activity) getContext()).finish();
                        }
                    }
                });
    }

    @Override
    public void setTitle(String title) {
        tvTitle.setText(title);
        tvTitle.setVisibility(View.VISIBLE);
    }

    @Override
    public TextView getLeftText() {
        return tvLeftText;
    }

    @Override
    public TextView getRightText() {
        return tvRightText;
    }

    @Override
    public ImageView getLeftImage() {
        return ivLeftImage;
    }

    @Override
    public ImageView getRightImage() {
        return ivRightImage;
    }

    @Override
    public void replaceTitleView(View view) {
        flTitleRoot.removeAllViews();
        flTitleRoot.addView(view);
    }

    @Override
    public void replaceRightView(View view) {
        flRighttRoot.removeAllViews();
        flRighttRoot.addView(view);
    }

    @Override
    public void replaceLeftView(View view) {
        flLeftRoot.removeAllViews();
        flLeftRoot.addView(view);
    }
}
