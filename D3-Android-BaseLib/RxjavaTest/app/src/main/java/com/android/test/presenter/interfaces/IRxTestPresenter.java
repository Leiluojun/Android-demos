package com.android.test.presenter.interfaces;

import android.content.Context;

import com.android.test.view.adapter.RxTestAdapter;


/**
 * 搜索页Presenter  接口
 *
 * @author yezi
 * @version 1.0 16/2/2
 */
public interface IRxTestPresenter {
    /**
     * 通过输入内容搜索
     */
    void searchByName();

    /**
     * 初始化搜索结果列表adapter
     *
     * @param context
     * @return RxTestAdapter
     */
    RxTestAdapter setAdapter(Context context);
}
