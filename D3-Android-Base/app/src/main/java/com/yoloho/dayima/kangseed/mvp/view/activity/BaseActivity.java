package com.yoloho.dayima.kangseed.mvp.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;

import com.google.common.base.CaseFormat;
import com.yoloho.dayima.kangseed.mvp.presenter.BasePresenter;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * @author Yuhj
 * @Description activity的基类 所有的activity都需要继承这个activity
 * @Date: 16-2-5  上午10:39
 * @Version
 */


public abstract class BaseActivity<ViewInterface, T extends BasePresenter<ViewInterface>> extends Activity {
    /**
     * 和页面绑定的Presenter
     */
    protected T mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView();
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachToView((ViewInterface) this);
        }
    }


    /**
     * 更具类名来绑定布局
     */
    protected void setContentView() {
        Class<?> clazz = this.getClass();

        while (true) {
            int layoutId = getResources().getIdentifier(CaseFormat.UPPER_CAMEL.to(CaseFormat
                    .LOWER_UNDERSCORE, getClassName()), "layout", getPackageName());

            if (layoutId != 0) {
                setContentView(layoutId);
                break;
            } else {
                clazz = clazz.getSuperclass();
                if (clazz.getClass().getSimpleName().equals(BaseActivity.class.getSimpleName())) {
                    throw new IllegalStateException(
                            "there is no layout for this activity");
                }
            }
        }
    }


    /**
     * @return 根据类名得到规范的布局文件命名   例：acticity_mainactivity
     */
    private String getClassName() {
        Class<?> clazz = this.getClass();

        String oldname = clazz.getSimpleName();
        String newname = null;
        if (!TextUtils.isEmpty(oldname)) {
            try {
                newname = "activity_" + oldname.substring(0, oldname.length() - 8);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return newname;

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

}
