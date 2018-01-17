package com.myhome.demo.base;

import com.myhome.demo.utils.Layout;
import com.myhome.demo.utils.LayoutBind;
import com.qmuiteam.qmui.widget.QMUITopBar;

/**
 * 创建时间:2017/11/28
 * 描述:绑定Layout 注解，使用@Layout 进行绑定 布局资源，设置title
 *
 * @author ql
 * @see Layout
 * @see LayoutBind
 */

public class BaseBindLayoutActivity extends BaseActivity {

    public QMUITopBar mTopbar;

    @Override
    public void createView() {
        LayoutBind.bind(this);
    }

}
