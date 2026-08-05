package android.support.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/annotation/Size.class */
@Target({ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface Size {
    long value() default -1;

    long min() default Long.MIN_VALUE;

    long max() default Long.MAX_VALUE;

    long multiple() default 1;
}
