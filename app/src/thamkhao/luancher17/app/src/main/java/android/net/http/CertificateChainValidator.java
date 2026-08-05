package android.net.http;

import java.io.IOException;
import javax.net.ssl.SSLSocket;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:android/net/http/CertificateChainValidator.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
public class CertificateChainValidator {
    CertificateChainValidator() {
        throw new RuntimeException("Stub!");
    }

    public static CertificateChainValidator getInstance() {
        throw new RuntimeException("Stub!");
    }

    public SslError doHandshakeAndValidateServerCertificates(HttpsConnection connection, SSLSocket sslSocket, String domain) throws IOException {
        throw new RuntimeException("Stub!");
    }

    public static SslError verifyServerCertificates(byte[][] certChain, String domain, String authType) throws IOException {
        throw new RuntimeException("Stub!");
    }

    public static void handleTrustStorageUpdate() {
        throw new RuntimeException("Stub!");
    }
}
