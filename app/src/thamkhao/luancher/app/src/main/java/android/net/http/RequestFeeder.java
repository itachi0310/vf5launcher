package android.net.http;

import org.apache.http.HttpHost;

/* JADX INFO: loaded from: Launcher3.apk:libs/org.apache.http.legacy.jar:android/net/http/RequestFeeder.class */
interface RequestFeeder {
    Request getRequest();

    Request getRequest(HttpHost httpHost);

    boolean haveRequest(HttpHost httpHost);

    void requeueRequest(Request request);
}
