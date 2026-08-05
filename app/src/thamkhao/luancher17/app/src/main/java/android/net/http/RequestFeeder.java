package android.net.http;

import org.apache.http.HttpHost;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:android/net/http/RequestFeeder.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
interface RequestFeeder {
    Request getRequest();

    Request getRequest(HttpHost httpHost);

    boolean haveRequest(HttpHost httpHost);

    void requeueRequest(Request request);
}
