package android.support.v4.util;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/util/DebugUtils.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
public class DebugUtils {
    public static void buildShortClassTag(Object cls, StringBuilder out) {
        int end;
        if (cls == null) {
            out.append("null");
            return;
        }
        String simpleName = cls.getClass().getSimpleName();
        if ((simpleName == null || simpleName.length() <= 0) && (end = (simpleName = cls.getClass().getName()).lastIndexOf(46)) > 0) {
            simpleName = simpleName.substring(end + 1);
        }
        out.append(simpleName);
        out.append('{');
        out.append(Integer.toHexString(System.identityHashCode(cls)));
    }
}
