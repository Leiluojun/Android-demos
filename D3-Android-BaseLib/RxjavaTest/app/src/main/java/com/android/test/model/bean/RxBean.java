package com.android.test.model.bean;

/**
 * 搜索结果bean
 *
 * @author yezi
 * @version 1.0 16/2/2
 */
public class RxBean {
    /**
     * 模版1
     */
    public static final int TYPE_MODE_1 = 0;
    /**
     * 模版2
     */
    public static final int TYPE_MODE_2 = 1;
    /**
     * 标题
     */
    private String mTitle;
    /**
     * 内容
     */
    private String mContent;
    /**
     * 时间
     */
    private String mTime;

    /**
     * 布局类型
     */

    private int mType;

    public RxBean(String title, String content, String time, int type) {
        setTitle(title);
        setContent(content);
        setTime(time);
        setType(type);
    }

    public void setType(int mType) {
        this.mType = mType;
    }

    public int getType() {
        return mType;

    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public void setContent(String mContent) {
        this.mContent = mContent;
    }

    public void setTime(String mTime) {
        this.mTime = mTime;
    }

    public String getTitle() {
        return mTitle;

    }

    public String getContent() {
        return mContent;
    }

    public String getTime() {
        return mTime;
    }

    @Override
    public String toString() {
        return "title:" + mTitle + "  content:" + mContent + "  time:" + mTime;
    }
}
