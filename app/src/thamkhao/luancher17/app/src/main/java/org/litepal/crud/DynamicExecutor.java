package org.litepal.crud;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.litepal.exceptions.LitePalSupportException;

/* JADX INFO: loaded from: classes.dex */
class DynamicExecutor {
    private DynamicExecutor() {
    }

    static Object send(Object object, String methodName, Object[] parameters, Class<?> objectClass, Class<?>[] clsArr) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (parameters == null) {
            try {
                parameters = new Object[0];
            } catch (NoSuchMethodException e) {
                throw new LitePalSupportException(LitePalSupportException.noSuchMethodException(objectClass.getSimpleName(), methodName), e);
            }
        }
        if (clsArr == null) {
            clsArr = new Class[0];
        }
        Method method = objectClass.getDeclaredMethod(methodName, clsArr);
        method.setAccessible(true);
        return method.invoke(object, parameters);
    }

    static void set(Object object, String fieldName, Object value, Class<?> objectClass) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        Field objectField = objectClass.getDeclaredField(fieldName);
        objectField.setAccessible(true);
        objectField.set(object, value);
    }

    static void setField(Object object, String fieldName, Object value, Class<?> objectClass) throws IllegalAccessException, SecurityException, IllegalArgumentException {
        if (objectClass == LitePalSupport.class || objectClass == Object.class) {
            throw new LitePalSupportException(LitePalSupportException.noSuchFieldExceptioin(objectClass.getSimpleName(), fieldName));
        }
        try {
            set(object, fieldName, value, objectClass);
        } catch (NoSuchFieldException e) {
            setField(object, fieldName, value, objectClass.getSuperclass());
        }
    }

    static Object getField(Object object, String fieldName, Class<?> objectClass) throws IllegalAccessException, IllegalArgumentException {
        if (objectClass == LitePalSupport.class || objectClass == Object.class) {
            throw new LitePalSupportException(LitePalSupportException.noSuchFieldExceptioin(objectClass.getSimpleName(), fieldName));
        }
        try {
            Field objectField = objectClass.getDeclaredField(fieldName);
            objectField.setAccessible(true);
            return objectField.get(object);
        } catch (NoSuchFieldException e) {
            return getField(object, fieldName, objectClass.getSuperclass());
        }
    }
}
