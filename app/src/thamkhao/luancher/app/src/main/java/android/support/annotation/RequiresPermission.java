package android.support.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/annotation/RequiresPermission.class */
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD})
@Retention(RetentionPolicy.CLASS)
public @interface RequiresPermission {

    /* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/annotation/RequiresPermission$Read.class */
    @Target({ElementType.FIELD})
    public @interface Read {
        RequiresPermission value();
    }

    /* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/annotation/RequiresPermission$Write.class */
    @Target({ElementType.FIELD})
    public @interface Write {
        RequiresPermission value();
    }

    String value() default "";

    String[] allOf() default {};

    String[] anyOf() default {};

    boolean conditional() default false;
}
