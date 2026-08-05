package android.support.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/annotation/RequiresPermission.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD})
@Retention(RetentionPolicy.CLASS)
public @interface RequiresPermission {

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/annotation/RequiresPermission$Read.class
  classes.dex
 */
    @Target({ElementType.FIELD})
    public @interface Read {
        RequiresPermission value();
    }

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/annotation/RequiresPermission$Write.class
  classes.dex
 */
    @Target({ElementType.FIELD})
    public @interface Write {
        RequiresPermission value();
    }

    String[] allOf() default {};

    String[] anyOf() default {};

    boolean conditional() default false;

    String value() default "";
}
