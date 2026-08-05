package android.net.http;

import android.content.Context;
import java.io.File;
import org.apache.http.HttpHost;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:android/net/http/HttpsConnection.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
public class HttpsConnection extends Connection {
    protected SslCertificate mCertificate;
    protected AndroidHttpClientConnection mHttpClientConnection;

    @Override // android.net.http.Connection
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    HttpsConnection() {
        super((Context) null, (HttpHost) null, (RequestFeeder) null);
        throw new RuntimeException("Stub!");
    }

    public static void initializeEngine(File sessionDir) {
        throw new RuntimeException("Stub!");
    }
}
