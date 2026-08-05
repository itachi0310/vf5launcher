package android.net.http;

import android.content.Context;
import org.apache.http.HttpHost;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:android/net/http/Connection.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
abstract class Connection {
    protected SslCertificate mCertificate;
    protected AndroidHttpClientConnection mHttpClientConnection;

    protected Connection(Context context, HttpHost host, RequestFeeder requestFeeder) {
        throw new RuntimeException("Stub!");
    }

    public synchronized String toString() {
        throw new RuntimeException("Stub!");
    }
}
