package com.myhome.demo;

import android.app.Application;

import com.myhome.demo.utils.LayoutBind;

/**
 * @author ql
 *         创建时间:2017/11/28
 *         描述:
 */

public class MyApp  extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        LayoutBind.setNormalBackRes(R.mipmap.topbar_back_gray);
    }
}
