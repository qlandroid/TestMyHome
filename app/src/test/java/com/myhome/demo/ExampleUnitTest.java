package com.myhome.demo;

import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testClaszz() {
        MainActivity m = new MainActivity();

        Class<? extends MainActivity> aClass = m.getClass();
        Method[] methods = aClass.getMethods();
        System.out.println("getMethods");
        for (Method declaredMethod : methods) {
            System.out.println(declaredMethod.getName());
        }
        Method[] declaredMethods = aClass.getDeclaredMethods();
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("getDeclaredMethods");

        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName());
        }

    }
}