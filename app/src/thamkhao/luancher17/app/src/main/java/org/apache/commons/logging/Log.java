package org.apache.commons.logging;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/commons/logging/Log.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface Log {
    void debug(Object obj);

    void debug(Object obj, Throwable th);

    void error(Object obj);

    void error(Object obj, Throwable th);

    void fatal(Object obj);

    void fatal(Object obj, Throwable th);

    void info(Object obj);

    void info(Object obj, Throwable th);

    boolean isDebugEnabled();

    boolean isErrorEnabled();

    boolean isFatalEnabled();

    boolean isInfoEnabled();

    boolean isTraceEnabled();

    boolean isWarnEnabled();

    void trace(Object obj);

    void trace(Object obj, Throwable th);

    void warn(Object obj);

    void warn(Object obj, Throwable th);
}
