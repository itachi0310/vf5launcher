package android.net.http;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:android/net/http/EventHandler.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
public interface EventHandler {
    public static final int ERROR = -1;
    public static final int ERROR_AUTH = -4;
    public static final int ERROR_BAD_URL = -12;
    public static final int ERROR_CONNECT = -6;
    public static final int ERROR_FAILED_SSL_HANDSHAKE = -11;
    public static final int ERROR_IO = -7;
    public static final int ERROR_LOOKUP = -2;
    public static final int ERROR_PROXYAUTH = -5;
    public static final int ERROR_REDIRECT_LOOP = -9;
    public static final int ERROR_TIMEOUT = -8;
    public static final int ERROR_UNSUPPORTED_AUTH_SCHEME = -3;
    public static final int ERROR_UNSUPPORTED_SCHEME = -10;
    public static final int FILE_ERROR = -13;
    public static final int FILE_NOT_FOUND_ERROR = -14;
    public static final int OK = 0;
    public static final int TOO_MANY_REQUESTS_ERROR = -15;

    void certificate(SslCertificate sslCertificate);

    void data(byte[] bArr, int i);

    void endData();

    void error(int i, String str);

    boolean handleSslErrorRequest(SslError sslError);

    void headers(Headers headers);

    void status(int i, int i2, int i3, String str);
}
