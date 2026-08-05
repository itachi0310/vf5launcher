package org.apache.http.conn.routing;

import java.net.InetAddress;
import org.apache.http.HttpHost;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/conn/routing/RouteTracker.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class RouteTracker implements RouteInfo {
    public RouteTracker(HttpHost target, InetAddress local) {
        throw new RuntimeException("Stub!");
    }

    public RouteTracker(HttpRoute route) {
        throw new RuntimeException("Stub!");
    }

    public final void connectTarget(boolean secure) {
        throw new RuntimeException("Stub!");
    }

    public final void connectProxy(HttpHost proxy, boolean secure) {
        throw new RuntimeException("Stub!");
    }

    public final void tunnelTarget(boolean secure) {
        throw new RuntimeException("Stub!");
    }

    public final void tunnelProxy(HttpHost proxy, boolean secure) {
        throw new RuntimeException("Stub!");
    }

    public final void layerProtocol(boolean secure) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.routing.RouteInfo
    public final HttpHost getTargetHost() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.routing.RouteInfo
    public final InetAddress getLocalAddress() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.routing.RouteInfo
    public final int getHopCount() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.routing.RouteInfo
    public final HttpHost getHopTarget(int hop) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.routing.RouteInfo
    public final HttpHost getProxyHost() {
        throw new RuntimeException("Stub!");
    }

    public final boolean isConnected() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.routing.RouteInfo
    public final RouteInfo.TunnelType getTunnelType() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.routing.RouteInfo
    public final boolean isTunnelled() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.routing.RouteInfo
    public final RouteInfo.LayerType getLayerType() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.routing.RouteInfo
    public final boolean isLayered() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.routing.RouteInfo
    public final boolean isSecure() {
        throw new RuntimeException("Stub!");
    }

    public final HttpRoute toRoute() {
        throw new RuntimeException("Stub!");
    }

    public final boolean equals(Object o) {
        throw new RuntimeException("Stub!");
    }

    public final int hashCode() {
        throw new RuntimeException("Stub!");
    }

    public final String toString() {
        throw new RuntimeException("Stub!");
    }

    public Object clone() throws CloneNotSupportedException {
        throw new RuntimeException("Stub!");
    }
}
