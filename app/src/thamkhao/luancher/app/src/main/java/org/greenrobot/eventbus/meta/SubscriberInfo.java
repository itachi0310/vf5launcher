package org.greenrobot.eventbus.meta;

import org.greenrobot.eventbus.SubscriberMethod;

/* JADX INFO: loaded from: Launcher3.apk:libs/eventbus-3.1.1.jar:org/greenrobot/eventbus/meta/SubscriberInfo.class */
public interface SubscriberInfo {
    Class<?> getSubscriberClass();

    SubscriberMethod[] getSubscriberMethods();

    SubscriberInfo getSuperSubscriberInfo();

    boolean shouldCheckSuperclass();
}
