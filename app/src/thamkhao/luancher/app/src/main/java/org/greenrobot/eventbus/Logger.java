package org.greenrobot.eventbus;

import android.util.Log;
import java.util.logging.Level;

/* JADX INFO: loaded from: Launcher3.apk:libs/eventbus-3.1.1.jar:org/greenrobot/eventbus/Logger.class */
public interface Logger {
    void log(Level level, String str);

    void log(Level level, String str, Throwable th);

    /* JADX INFO: loaded from: Launcher3.apk:libs/eventbus-3.1.1.jar:org/greenrobot/eventbus/Logger$AndroidLogger.class */
    public static class AndroidLogger implements Logger {
        static final boolean ANDROID_LOG_AVAILABLE;
        private final String tag;

        static {
            boolean android2 = false;
            try {
                android2 = Class.forName("android.util.Log") != null;
            } catch (ClassNotFoundException e) {
            }
            ANDROID_LOG_AVAILABLE = android2;
        }

        public static boolean isAndroidLogAvailable() {
            return ANDROID_LOG_AVAILABLE;
        }

        public AndroidLogger(String tag) {
            this.tag = tag;
        }

        @Override // org.greenrobot.eventbus.Logger
        public void log(Level level, String msg) {
            if (level != Level.OFF) {
                Log.println(mapLevel(level), this.tag, msg);
            }
        }

        @Override // org.greenrobot.eventbus.Logger
        public void log(Level level, String msg, Throwable th) {
            if (level != Level.OFF) {
                Log.println(mapLevel(level), this.tag, msg + "\n" + Log.getStackTraceString(th));
            }
        }

        protected int mapLevel(Level level) {
            int value = level.intValue();
            if (value < 800) {
                if (value < 500) {
                    return 2;
                }
                return 3;
            }
            if (value < 900) {
                return 4;
            }
            if (value < 1000) {
                return 5;
            }
            return 6;
        }
    }

    /* JADX INFO: loaded from: Launcher3.apk:libs/eventbus-3.1.1.jar:org/greenrobot/eventbus/Logger$JavaLogger.class */
    public static class JavaLogger implements Logger {
        protected final java.util.logging.Logger logger;

        public JavaLogger(String tag) {
            this.logger = java.util.logging.Logger.getLogger(tag);
        }

        @Override // org.greenrobot.eventbus.Logger
        public void log(Level level, String msg) {
            this.logger.log(level, msg);
        }

        @Override // org.greenrobot.eventbus.Logger
        public void log(Level level, String msg, Throwable th) {
            this.logger.log(level, msg, th);
        }
    }

    /* JADX INFO: loaded from: Launcher3.apk:libs/eventbus-3.1.1.jar:org/greenrobot/eventbus/Logger$SystemOutLogger.class */
    public static class SystemOutLogger implements Logger {
        @Override // org.greenrobot.eventbus.Logger
        public void log(Level level, String msg) {
            System.out.println("[" + level + "] " + msg);
        }

        @Override // org.greenrobot.eventbus.Logger
        public void log(Level level, String msg, Throwable th) {
            System.out.println("[" + level + "] " + msg);
            th.printStackTrace(System.out);
        }
    }
}
