package com.myhome.demo.utils;

import android.support.annotation.DrawableRes;
import android.text.TextUtils;
import android.view.View;

import com.myhome.demo.utils.Layout;
import com.qmuiteam.qmui.alpha.QMUIAlphaImageButton;
import com.qmuiteam.qmui.widget.QMUITopBar;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 创建时间:2017/11/28
 * 描述:
 *
 * @author ql
 */

public class LayoutBind {

    private static int NOR_NORMAL_BACK;

    /**
     * 设置 默认状态下 显示 返回按键 资源图片
     *
     * @param backRes
     */
    public static void setNormalBackRes(@DrawableRes int backRes) {
        NOR_NORMAL_BACK = backRes;
    }

    public static void bind(Object object) {
        Class<?> aClass = object.getClass();
        boolean isImport = aClass.isAnnotationPresent(Layout.class);
        if (!isImport) {
            return;
        }
        Layout annotation = aClass.getAnnotation(Layout.class);


        /*
        设置资源id,
         */
        int layoutRes = annotation.layoutRes();
        if (layoutRes != -1) {
            try {
                Method setContentView = aClass.getMethod("setContentView", new Class[]{int.class});
                if (setContentView != null) {
                    setContentView.invoke(object, layoutRes);
                }

            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        QMUITopBar topBar = null;

        /*
        布局中必须引用QMINUi
        为BaseActivity中 mTopbar进行赋值
         */
        try {
            Field mTopbarField = aClass.getField("mTopbar");
            if (mTopbarField == null) {
                return;
            }
            Method findViewById = aClass.getMethod("findViewById", int.class);
            Object invoke = findViewById.invoke(object, annotation.topbarId());
            topBar = (QMUITopBar) invoke;
            mTopbarField.set(object, invoke);
        } catch (Exception e) {
            //throw new NullPointerException("绑定TopBar失败，请检查布局中是否拥有Topbar资源id");
            e.printStackTrace();
            return;
        }
        String title = annotation.title();
        if (!TextUtils.isEmpty(title)) {
            topBar.setTitle(title);
        }

        int backRes = annotation.backRes();
        if ((NOR_NORMAL_BACK != 0) && (Layout.NOT_SHOW != backRes)) {
            QMUIAlphaImageButton backImageButton = topBar.addLeftBackImageButton();
            backImageButton.setImageResource(NOR_NORMAL_BACK);
            /*
             * 为返回键设置 返回监听，
             * R.id.qmui_topbar_item_left_back
             */
            backImageButton.setOnClickListener((View.OnClickListener) object);
        }


    }
}
