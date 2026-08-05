package android.support.v4.text;

import android.os.Build;
import java.util.Locale;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/text/ICUCompat.class */
public final class ICUCompat {
    private static final ICUCompatImpl IMPL;

    /* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/text/ICUCompat$ICUCompatImpl.class */
    interface ICUCompatImpl {
        String maximizeAndGetScript(Locale locale);
    }

    /* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/text/ICUCompat$ICUCompatImplBase.class */
    static class ICUCompatImplBase implements ICUCompatImpl {
        ICUCompatImplBase() {
        }

        @Override // android.support.v4.text.ICUCompat.ICUCompatImpl
        public String maximizeAndGetScript(Locale locale) {
            return null;
        }
    }

    /* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/text/ICUCompat$ICUCompatImplIcs.class */
    static class ICUCompatImplIcs implements ICUCompatImpl {
        ICUCompatImplIcs() {
        }

        @Override // android.support.v4.text.ICUCompat.ICUCompatImpl
        public String maximizeAndGetScript(Locale locale) {
            return ICUCompatIcs.maximizeAndGetScript(locale);
        }
    }

    /* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/text/ICUCompat$ICUCompatImplLollipop.class */
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
