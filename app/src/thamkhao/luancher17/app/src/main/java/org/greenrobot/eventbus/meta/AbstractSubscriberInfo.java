package org.greenrobot.eventbus.meta;

import java.lang.reflect.Method;
import org.greenrobot.eventbus.EventBusException;
import org.greenrobot.eventbus.SubscriberMethod;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: 190001025_com.android.launcher17.apk:libs/eventbus-3.1.1.jar:org/greenrobot/eventbus/meta/AbstractSubscriberInfo.class */
public abstract class AbstractSubscriberInfo implements SubscriberInfo {
    private final Class subscriberClass;
    private final Class<? extends SubscriberInfo> superSubscriberInfoClass;
    private final boolean shouldCheckSuperclass;

    protected AbstractSubscriberInfo(Class subscriberClass, Class<? extends SubscriberInfo> superSubscriberInfoClass, boolean shouldCheckSuperclass) {
        this.subscriberClass = subscriberClass;
        this.superSubscriberInfoClass = superSubscriberInfoClass;
        this.shouldCheckSuperclass = shouldCheckSuperclass;
    }

    @Override // org.greenrobot.eventbus.meta.SubscriberInfo
    public Class getSubscriberClass() {
        return this.subscriberClass;
    }

    @Override // org.greenrobot.eventbus.meta.SubscriberInfo
    public SubscriberInfo getSuperSubscriberInfo() {
        if (this.superSubscriberInfoClass == null) {
            return null;
        }
        try {
            return this.superSubscriberInfoClass.newInstance();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // org.greenrobot.eventbus.meta.SubscriberInfo
    public boolean shouldCheckSuperclass() {
        return this.shouldCheckSuperclass;
    }

    protected SubscriberMethod createSubscriberMethod(String methodName, Class<?> eventType) {
        return createSubscriberMethod(methodName, eventType, ThreadMode.POSTING, 0, false);
    }

    protected SubscriberMethod createSubscriberMethod(String methodName, Class<?> eventType, ThreadMode threadMode) {
        return createSubscriberMethod(methodName, eventType, threadMode, 0, false);
    }

    protected SubscriberMethod createSubscriberMethod(String methodName, Class<?> eventType, ThreadMode threadMode, int priority, boolean sticky) {
        try {
            Method method = this.subscriberClass.getDeclaredMethod(methodName, eventType);
            return new SubscriberMethod(method, eventType, threadMode, priority, sticky);
        } catch (NoSuchMethodException e) {
            throw new EventBusException("Could not find subscriber method in " + this.subscriberClass + ". Maybe a missing ProGuard rule?", e);
        }
    }
}
