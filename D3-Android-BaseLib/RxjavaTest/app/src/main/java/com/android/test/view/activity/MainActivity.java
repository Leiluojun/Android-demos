package com.android.test.view.activity;

import android.app.ProgressDialog;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.android.rxjavatest.R;
import com.android.test.presenter.RxTestPresenter;
import com.android.test.view.CustomTitleBar;
import com.android.test.view.adapter.RxTestAdapter;
import com.android.test.view.interfaces.IRxTestView;
import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.view.ViewClickEvent;

import java.util.concurrent.TimeUnit;

import butterknife.Bind;
import rx.functions.Action1;

/**
 * 搜索页
 *
 * @author yezi
 * @version 1.0 16/2/2
 */
public class MainActivity extends BaseActivity<IRxTestView, RxTestPresenter> implements IRxTestView {
    @Bind(R.id.lvRxData)
    ListView lvRxData;
    @Bind(R.id.etSearch)
    EditText etSearch;
    @Bind(R.id.btnSearch)
    Button btnSearch;
    @Bind(R.id.ctbTitleBar)
    CustomTitleBar ctbTitleBar;
    /**
     * 搜索结果适配器
     */
    RxTestAdapter mRxTestAdapter;
    /**
     * 加载进度
     */
    ProgressDialog pdLoading;

    @Override
    protected RxTestPresenter createPresenter() {
        mPresenter = new RxTestPresenter(this);
        return mPresenter;
    }

    @Override
    protected void initVariables() {
        pdLoading = new ProgressDialog(this);
        mRxTestAdapter = mPresenter.setAdapter(this);
    }

    @Override
    protected void initViews() {
        lvRxData.setAdapter(mRxTestAdapter);
        ctbTitleBar.showBack();
        ctbTitleBar.setTitle("搜索");
        RxView
                .clickEvents(btnSearch)
                .throttleFirst(500, TimeUnit.MILLISECONDS)
                .subscribe(new Action1<ViewClickEvent>() {
                    @Override
                    public void call(ViewClickEvent viewClickEvent) {
                        mPresenter.searchByName();
                    }
                });
    }

    @Override
    protected void loadData() {
        mPresenter.searchByName();
    }

    @Override
    public String getSearchName() {
        return etSearch.getText().toString();
    }

    @Override
    public void showSearchResults() {
        mRxTestAdapter.notifyDataSetChanged();
    }

    @Override
    public void showProgress() {
        pdLoading.show();
    }

    @Override
    public void hideProgress() {
        pdLoading.dismiss();
    }
}
