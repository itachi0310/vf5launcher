package com.syu.h;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static final Object a(Object obj, Method method, Object... objArr) {
        if (method == null) {
            return null;
        }
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return null;
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static final Method a(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static final Method a(String str, String str2, Class... clsArr) {
        try {
            Class<?> cls = Class.forName(str);
            if (cls != null) {
                return a(cls, str2, clsArr);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
