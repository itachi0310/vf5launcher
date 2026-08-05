package com.syu.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: Launcher3.apk:bin/autolib.jar:com/syu/utils/Tools.class */
public class Tools {
    public static final Method getMethod(String clazzName, String methodName, Class<?>... clsArr) {
        try {
            Class<?> clazz = Class.forName(clazzName);
            if (clazz != null) {
                return getMethod(clazz, methodName, clsArr);
            }
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static final Method getMethod(Class clazz, String methodName, Class<?>... clsArr) {
        Method method = null;
        try {
            method = clazz.getMethod(methodName, clsArr);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return method;
    }

    public static final Object callMethod(Object obj, Method method, Object... params) {
        Object ret = null;
        if (method == null) {
            return null;
        }
        try {
            ret = method.invoke(obj, params);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
        return ret;
    }
}
