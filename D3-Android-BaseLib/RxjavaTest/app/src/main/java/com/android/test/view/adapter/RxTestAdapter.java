package com.android.test.view.adapter;

import android.content.Context;

import com.android.rxjavatest.R;
import com.android.test.lib.adapter.MultiItemCommonAdapter;
import com.android.test.lib.adapter.MultiItemTypeSupport;
import com.android.test.lib.adapter.ViewHolder;
import com.android.test.model.bean.RxBean;

import java.util.List;

/**
 * 搜索页list适配器
 *
 * @author yezi
 * @version 1.0 16/2/2
 */
public class RxTestAdapter extends MultiItemCommonAdapter<RxBean> {
    public RxTestAdapter(Context context, List<RxBean> datas) {
        super(context, datas, new MultiItemTypeSupport<RxBean>() {
            @Override
            public int getLayoutId(int position, RxBean rxBean) {
                if (rxBean.getType() == 0) {
                    return R.layout.item_rx_type_1;
                } else {
                    return R.layout.item_rx_type_2;
                }
            }

            @Override
            public int getViewTypeCount() {
                return 2;
            }

            @Override
            public int getItemViewType(int postion, RxBean rxBean) {
                return rxBean.getType();
            }
        });
    }

    @Override
    public void convert(ViewHolder holder, RxBean rxBean) {
        switch (holder.getLayoutId()) {
            case R.layout.item_rx_type_2:
                holder.setText(R.id.tvTitle, rxBean.getTitle());
                holder.setText(R.id.tvContent, rxBean.getContent());
                holder.setText(R.id.tvTime, rxBean.getTime());
                break;
            case R.layout.item_rx_type_1:
                holder.setText(R.id.tvTitle, rxBean.getTitle());
                holder.setText(R.id.tvContent, rxBean.getContent());
                holder.setText(R.id.tvTime, rxBean.getTime());
                break;
        }
    }
}
