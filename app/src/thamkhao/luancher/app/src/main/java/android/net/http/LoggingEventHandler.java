package android.net.http;

/* JADX INFO: loaded from: Launcher3.apk:libs/org.apache.http.legacy.jar:android/net/http/LoggingEventHandler.class */
public class LoggingEventHandler implements EventHandler {
    public LoggingEventHandler() {
        throw new RuntimeException("Stub!");
    }

    public void requestSent() {
        throw new RuntimeException("Stub!");
    }

    @Override // android.net.http.EventHandler
    public void status(int major_version, int minor_version, int code, String reason_phrase) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.net.http.EventHandler
    public void headers(Headers headers) {
        throw new RuntimeException("Stub!");
    }

    public void locationChanged(String newLocation, boolean permanent) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.net.http.EventHandler
    public void data(byte[] data, int len) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.net.http.EventHandler
    public void endData() {
        throw new RuntimeException("Stub!");
    }

    @Override // android.net.http.EventHandler
    public void certificate(SslCertificate certificate) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.net.http.EventHandler
    public void error(int id, String description) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.net.http.EventHandler
    public boolean handleSslErrorRequest(SslError error) {
        throw new RuntimeException("Stub!");
    }
}
