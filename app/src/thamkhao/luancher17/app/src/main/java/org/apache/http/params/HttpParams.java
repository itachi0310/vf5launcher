package org.apache.http.params;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/params/HttpParams.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface HttpParams {
    HttpParams copy();

    boolean getBooleanParameter(String str, boolean z);

    double getDoubleParameter(String str, double d);

    int getIntParameter(String str, int i);

    long getLongParameter(String str, long j);

    Object getParameter(String str);

    boolean isParameterFalse(String str);

    boolean isParameterTrue(String str);

    boolean removeParameter(String str);

    HttpParams setBooleanParameter(String str, boolean z);

    HttpParams setDoubleParameter(String str, double d);

    HttpParams setIntParameter(String str, int i);

    HttpParams setLongParameter(String str, long j);

    HttpParams setParameter(String str, Object obj);
}
