package org.apache.http.util;

import java.util.Map;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/util/VersionInfo.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class VersionInfo {
    public static final String PROPERTY_MODULE = "info.module";
    public static final String PROPERTY_RELEASE = "info.release";
    public static final String PROPERTY_TIMESTAMP = "info.timestamp";
    public static final String UNAVAILABLE = "UNAVAILABLE";
    public static final String VERSION_PROPERTY_FILE = "version.properties";

    protected VersionInfo(String pckg, String module, String release, String time, String clsldr) {
        throw new RuntimeException("Stub!");
    }

    public final String getPackage() {
        throw new RuntimeException("Stub!");
    }

    public final String getModule() {
        throw new RuntimeException("Stub!");
    }

    public final String getRelease() {
        throw new RuntimeException("Stub!");
    }

    public final String getTimestamp() {
        throw new RuntimeException("Stub!");
    }

    public final String getClassloader() {
        throw new RuntimeException("Stub!");
    }

    public String toString() {
        throw new RuntimeException("Stub!");
    }

    public static final VersionInfo[] loadVersionInfo(String[] pckgs, ClassLoader clsldr) {
        throw new RuntimeException("Stub!");
    }

    public static final VersionInfo loadVersionInfo(String pckg, ClassLoader clsldr) {
        throw new RuntimeException("Stub!");
    }

    protected static final VersionInfo fromMap(String pckg, Map info, ClassLoader clsldr) {
        throw new RuntimeException("Stub!");
    }
}
