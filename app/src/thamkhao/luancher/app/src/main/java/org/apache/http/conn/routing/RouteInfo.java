package org.apache.http.conn.routing;

import java.net.InetAddress;
import org.apache.http.HttpHost;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/conn/routing/RouteInfo.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface RouteInfo {

    /* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/conn/routing/RouteInfo$LayerType.class
  classes.dex
 */
    public enum LayerType {
        LAYERED,
        PLAIN
    }

    /* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/conn/routing/RouteInfo$TunnelType.class
  classes.dex
 */
    public enum TunnelType {
        PLAIN,
        TUNNELLED
    }

    int getHopCount();

    HttpHost getHopTarget(int i);

    LayerType getLayerType();

    InetAddress getLocalAddress();

    HttpHost getProxyHost();

    HttpHost getTargetHost();

    TunnelType getTunnelType();

    boolean isLayered();

    boolean isSecure();

    boolean isTunnelled();
}
