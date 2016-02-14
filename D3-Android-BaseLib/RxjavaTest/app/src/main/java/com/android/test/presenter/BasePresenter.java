package com.android.test.presenter;

import java.lang.ref.WeakReference;

import rx.subscriptions.CompositeSubscription;

/**
 * 所有Presenter的基类
 */
public class BasePresenter<T> {
    /**
     * 页面的弱引用
     */
    protected WeakReference<T> mReference;
    /**
     * add所有的{@link },以便在detach的时候unSubscribe
     */
    protected CompositeSubscription mCompositeSubscription = new CompositeSubscription();

    /**
     * 绑定页面
     *
     * @param view 页面(Activity, Fragment or View)
     */
    public void attachToView(T view) {
        mReference = new WeakReference<>(view);
    }

    /**
     * 解除绑定
     */
    public void detachFromView() {
        mCompositeSubscription.unsubscribe();

        if (mReference != null) {
            mReference.clear();
            mReference = null;
        }
    }
}
