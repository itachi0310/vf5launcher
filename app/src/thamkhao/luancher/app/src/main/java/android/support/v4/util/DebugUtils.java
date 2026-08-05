package android.support.v4.util;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/util/DebugUtils.class */
public class DebugUtils {
    public static void buildShortClassTag(Object cls, StringBuilder out) {
        if (cls == null) {
            out.append("null");
            return;
        }
        String simpleName = cls.getClass().getSimpleName();
        if (simpleName == null || simpleName.length() <= 0) {
            simpleName = cls.getClass().getName();
            int end = simpleName.lastIndexOf(46);
            if (end > 0) {
                simpleName = simpleName.substring(end + 1);
            }
        }
        out.append(simpleName);
        out.append('{');
        out.append(Integer.toHexString(System.identityHashCode(cls)));
    }
}
