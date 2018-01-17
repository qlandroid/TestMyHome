package com.myhome.demo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.myhome.demo.R;

/**
 * 创建时间:2017/11/28
 * 描述:Activity基类
 *
 * @author ql
 */

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createView();
        bindView();
        initData();
        initWidget();
    }

    public void bindView() {

    }

    public abstract void createView();

    public void initWidget() {

    }

    public void initData() {

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.qmui_topbar_item_left_back) {
            onBackPressed();
        } else {
            widgetClick(v);
        }
    }

    /**
     * 点击事件
     *
     * @param v
     */
    public void widgetClick(View v) {

    }

}
