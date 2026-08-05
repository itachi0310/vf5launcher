package org.greenrobot.eventbus;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: Launcher3.apk:libs/eventbus-3.1.1.jar:org/greenrobot/eventbus/Subscribe.class */
@Target({ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Subscribe {
    ThreadMode threadMode() default ThreadMode.POSTING;

    boolean sticky() default false;

    int priority() default 0;
}
