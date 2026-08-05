package com.syu.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Standard SYU Reflection Tools.
 */
public class Tools {
    public static Method getMethod(String clazzName, String methodName, Class<?>... clsArr) {
        try {
            Class<?> clazz = Class.forName(clazzName);
            return getMethod(clazz, methodName, clsArr);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public static Method getMethod(Class<?> clazz, String methodName, Class<?>... clsArr) {
        try {
            return clazz.getMethod(methodName, clsArr);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    public static Object callMethod(Object obj, Method method, Object... params) {
        if (method == null) return null;
        try {
            return method.invoke(obj, params);
        } catch (Exception e) {
            return null;
        }
    }
}
