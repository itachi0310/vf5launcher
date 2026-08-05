package org.apache.commons.logging.impl;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Properties;
import org.apache.commons.logging.Log;

/* JADX INFO: loaded from: Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/commons/logging/impl/SimpleLog.class */
@Deprecated
public class SimpleLog implements Log, Serializable {
    protected static final String DEFAULT_DATE_TIME_FORMAT = "yyyy/MM/dd HH:mm:ss:SSS zzz";
    public static final int LOG_LEVEL_ALL = 0;
    public static final int LOG_LEVEL_DEBUG = 2;
    public static final int LOG_LEVEL_ERROR = 5;
    public static final int LOG_LEVEL_FATAL = 6;
    public static final int LOG_LEVEL_INFO = 3;
    public static final int LOG_LEVEL_OFF = 7;
    public static final int LOG_LEVEL_TRACE = 1;
    public static final int LOG_LEVEL_WARN = 4;
    protected int currentLogLevel;
    protected static DateFormat dateFormatter;
    protected static String dateTimeFormat;
    protected String logName;
    protected static boolean showDateTime;
    protected static boolean showLogName;
    protected static boolean showShortName;
    protected static final Properties simpleLogProps = null;
    protected static final String systemPrefix = "org.apache.commons.logging.simplelog.";

    public SimpleLog(String name) {
        throw new RuntimeException("Stub!");
    }

    public void setLevel(int currentLogLevel) {
        throw new RuntimeException("Stub!");
    }

    public int getLevel() {
        throw new RuntimeException("Stub!");
    }

    protected void log(int type, Object message, Throwable t) {
        throw new RuntimeException("Stub!");
    }

    protected void write(StringBuffer buffer) {
        throw new RuntimeException("Stub!");
    }

    protected boolean isLevelEnabled(int logLevel) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public final void debug(Object message) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public final void debug(Object message, Throwable t) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public final void trace(Object message) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public final void trace(Object message, Throwable t) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public final void info(Object message) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public final void info(Object message, Throwable t) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public final void warn(Object message) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public final void warn(Object message, Throwable t) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public final void error(Object message) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public final void error(Object message, Throwable t) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public final void fatal(Object message) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public final void fatal(Object message, Throwable t) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public final boolean isDebugEnabled() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public final boolean isErrorEnabled() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public final boolean isFatalEnabled() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public final boolean isInfoEnabled() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public final boolean isTraceEnabled() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public final boolean isWarnEnabled() {
        throw new RuntimeException("Stub!");
    }
}
