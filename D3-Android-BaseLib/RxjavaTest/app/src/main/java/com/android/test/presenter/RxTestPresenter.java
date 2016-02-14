package com.android.test.presenter;

import android.content.Context;
import android.util.Log;

import com.android.test.model.RxModel;
import com.android.test.model.bean.RxBean;
import com.android.test.presenter.interfaces.IRxTestPresenter;
import com.android.test.view.adapter.RxTestAdapter;
import com.android.test.view.interfaces.IRxTestView;

import java.util.ArrayList;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 搜索页Presenter  实现
 *
 * @author yezi
 * @version 1.0 16/2/2
 */
public class RxTestPresenter extends BasePresenter<IRxTestView> implements IRxTestPresenter {
    private RxModel mRxModel;
    private IRxTestView mRxTestView;

    public RxTestPresenter(IRxTestView rxTestView) {
        if (mRxModel == null)
            mRxModel = new RxModel();
        if (mRxTestView == null)
            mRxTestView = rxTestView;
    }

    @Override
    public void searchByName() {
        mRxTestView.showProgress();
        Observable
                .create(new Observable.OnSubscribe<ArrayList<RxBean>>() {
                    @Override
                    public void call(Subscriber<? super ArrayList<RxBean>> subscriber) {
                        Log.e("current_thread", Thread.currentThread().getId() + "  onsub");
                        subscriber.onNext(mRxModel.searchByName(mRxTestView.getSearchName()));
                    }
                })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ArrayList<RxBean>>() {
                    @Override
                    public void call(ArrayList<RxBean> rxBeans) {
                        mRxTestView.showSearchResults();
                        mRxTestView.hideProgress();
                        Log.e("current_thread", Thread.currentThread().getId() + "  show");
                    }
                });
    }

    @Override
    public RxTestAdapter setAdapter(Context context) {
        RxTestAdapter adapter = new RxTestAdapter(context, mRxModel.getBeans());
        return adapter;
    }

}
