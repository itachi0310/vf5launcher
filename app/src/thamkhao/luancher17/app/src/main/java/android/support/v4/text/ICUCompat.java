package android.support.v4.text;

import android.os.Build;
import java.util.Locale;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/text/ICUCompat.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
public final class ICUCompat {
    private static final ICUCompatImpl IMPL;

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/text/ICUCompat$ICUCompatImpl.class
  classes.dex
 */
    interface ICUCompatImpl {
        String maximizeAndGetScript(Locale locale);
    }

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/text/ICUCompat$ICUCompatImplBase.class
  classes.dex
 */
    static class ICUCompatImplBase implements ICUCompatImpl {
        ICUCompatImplBase() {
        }

        @Override // android.support.v4.text.ICUCompat.ICUCompatImpl
        public String maximizeAndGetScript(Locale locale) {
            return null;
        }
    }

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/text/ICUCompat$ICUCompatImplIcs.class
  classes.dex
 */
    static class ICUCompatImplIcs implements ICUCompatImpl {
        ICUCompatImplIcs() {
        }

        @Override // android.support.v4.text.ICUCompat.ICUCompatImpl
        public String maximizeAndGetScript(Locale locale) {
            return ICUCompatIcs.maximizeAndGetScript(locale);
        }
    }

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/text/ICUCompat$ICUCompatImplLollipop.class
  classes.dex
 */
    static class ICUCompatImplLollipop implements ICUCompatImpl {
        ICUCompatImplLollipop() {
        }

        @Override // android.support.v4.text.ICUCompat.ICUCompatImpl
        public String maximizeAndGetScript(Locale locale) {
            return ICUCompatApi23.maximizeAndGetScript(locale);
        }
    }

    static {
        int version = Build.VERSION.SDK_INT;
        if (version >= 21) {
            IMPL = new ICUCompatImplLollipop();
        } else if (version >= 14) {
            IMPL = new ICUCompatImplIcs();
        } else {
            IMPL = new ICUCompatImplBase();
        }
    }

    public static String maximizeAndGetScript(Locale locale) {
        return IMPL.maximizeAndGetScript(locale);
    }

    private ICUCompat() {
    }
}
