package com.myhome.demo.utils;

import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;

import com.myhome.demo.R;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 创建时间:2017/11/28
 * 描述:
 *
 * @author ql
 */
@Documented
@Inherited
//该注解可以作用于方法,类与接口
@Target({ElementType.TYPE})
//JVM会读取注解,所以利用反射可以获得注解
@Retention(RetentionPolicy.RUNTIME)
public @interface Layout {
    public static final int NOT_SHOW = Integer.MAX_VALUE;

    /**
     * 用于显示当前布局引用的资源id
     *
     * @return
     */
    @LayoutRes int layoutRes() default -1;

    /**
     * 当前显示布局title
     *
     * @return
     */
    String title();

    /**
     * 布局中 QMUITopBar 的id
     *
     * @return
     */
    @IdRes int topbarId() default R.id.topbar;

    /**
     * 显示返回按键的 图片Id
     * 如果不需要显示返回键,那么需要 将该值 更改为 NOT_SHOW;
     *
     * @return
     */
    @DrawableRes int backRes() default R.mipmap.topbar_back_gray;

}
