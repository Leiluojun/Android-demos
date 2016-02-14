package com.android.test.model;


import com.android.test.model.bean.RxBean;
import com.android.test.model.interfaces.IRxModel;

import java.util.ArrayList;

/**
 * 搜索页model 接口
 *
 * @author yezi
 * @version 1.0 16/2/2
 */
public class RxModel implements IRxModel {
    private ArrayList<RxBean> mRxBeans = new ArrayList<>();

    @Override
    public ArrayList<RxBean> searchByName(String name) {
        mRxBeans.clear();
        if (name.equals(""))
            name = "xxxxxx";
        for (int i = 0; i < 100; i++) {
            RxBean rxBean = new RxBean(name, "a library for composing asynchronous and " +
                    "event-based programs using observable sequences for the Java VM",
                    System.currentTimeMillis() + "", i % 2 == 0 ? RxBean.TYPE_MODE_1 : RxBean.TYPE_MODE_2);
            mRxBeans.add(rxBean);
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return mRxBeans;
    }

    @Override
    public ArrayList<RxBean> getBeans() {
        return mRxBeans;
    }
}
