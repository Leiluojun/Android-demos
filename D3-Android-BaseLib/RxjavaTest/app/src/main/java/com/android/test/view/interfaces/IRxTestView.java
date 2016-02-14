package com.android.test.view.interfaces;

/**
 * 搜索页view 接口
 *
 * @author yezi
 * @version 1.0 16/2/2
 */
public interface IRxTestView {
    /**
     * 获取输入搜索内容
     *
     * @return string
     */
    String getSearchName();

    /**
     * 显示搜索结果
     */
    void showSearchResults();

    /**
     * 显示加载进度
     */
    void showProgress();

    /**
     * 隐藏加载进度
     */
    void hideProgress();
}
