package com.android.test.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.android.rxjavatest.R;
import com.android.test.presenter.BasePresenter;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

import butterknife.ButterKnife;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Activity基类
 * <br/>initVariables()初始化变量;
 * <br/>initViews()初始化views;
 * <br/>loadData()初始化数据;
 *
 * @author yezi
 * @version 1.0 16/2/2
 */
public abstract class BaseActivity<ViewInterface, T extends BasePresenter<ViewInterface>> extends Activity {
    protected static final String TAG_RX = "tag_rx";
    /**
     * 和页面绑定的Presenter
     */
    protected T mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachToView((ViewInterface) this);
        }
        setContentView(R.layout.base);
        setContent();
        ButterKnife.bind(this);
        initVariables();
        initViews();
        loadData();
    }

    /**
     * 更具类名来绑定布局
     */
    private View getContentView() {
        Class<?> clazz = this.getClass();
        View view = null;
        while (true) {
            try {
                view = (View) LayoutInflater.from(this).inflate(
                        R.layout.class.getField(clazz.getSimpleName().toLowerCase(Locale.getDefault()))
                                .getInt(R.layout.class), null);
                break;
            } catch (Exception e) {
                e.printStackTrace();
                if (clazz.getClass().equals(Activity.class))
                    break;
                else
                    clazz = clazz.getSuperclass();
            }
        }
        return view;
    }

    /**
     * 创建一个presenter
     *
     * @return a Presenter
     */
    protected abstract T createPresenter();

    @Override
    public void finish() {
        if (mPresenter != null) {
            mPresenter.detachFromView();
            mPresenter = null;
        }
        super.finish();
    }

    /**
     * @param runnable
     */
    public void postRunnable(Runnable runnable) {
        postRunnable(runnable, 0);
    }

    /**
     * 延迟执行一个任务
     *
     * @param runnable
     * @param delayMillis
     */
    public void postRunnable(final Runnable runnable, long delayMillis) {
        Observable.timer(delayMillis, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Long>() {
            @Override
            public void call(Long aLong) {
                runnable.run();
            }
        });
    }

    /**
     * 添加布局
     */
    private void setContent() {
        ((FrameLayout) findViewById(R.id.flRoot)).addView(getContentView());
    }

    /**
     * 初始化参数
     */
    protected abstract void initVariables();

    /**
     * 初始化view
     */
    protected abstract void initViews();

    /**
     * 初始化数据
     */
    protected abstract void loadData();
}
