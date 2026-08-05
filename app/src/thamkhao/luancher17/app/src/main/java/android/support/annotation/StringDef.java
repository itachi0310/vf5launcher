package android.support.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/annotation/StringDef.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.SOURCE)
public @interface StringDef {
    String[] value() default {};
}
