package org.apache.http.impl.io;

import java.io.IOException;
import java.net.Socket;
import org.apache.http.params.HttpParams;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/io/SocketOutputBuffer.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class SocketOutputBuffer extends AbstractSessionOutputBuffer {
    public SocketOutputBuffer(Socket socket, int buffersize, HttpParams params) throws IOException {
        throw new RuntimeException("Stub!");
    }
}
