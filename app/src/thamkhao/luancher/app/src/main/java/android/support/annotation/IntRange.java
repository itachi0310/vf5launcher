package android.support.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/annotation/IntRange.class */
@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.LOCAL_VARIABLE})
@Retention(RetentionPolicy.CLASS)
public @interface IntRange {
    long from() default Long.MIN_VALUE;

    long to() default Long.MAX_VALUE;
}
