package com.android.test.model.interfaces;


import com.android.test.model.bean.RxBean;

import java.util.ArrayList;

/**
 * 搜索页model 接口
 *
 * @author yezi
 * @version 1.0 16/2/2
 */
public interface IRxModel {
    /**
     * @param name 搜索内容
     * @return 搜索结果  ArrayList<RxBean>
     */
    ArrayList<RxBean> searchByName(String name);

    /**
     * @return 搜索结果数据源
     */
    ArrayList<RxBean> getBeans();
}
