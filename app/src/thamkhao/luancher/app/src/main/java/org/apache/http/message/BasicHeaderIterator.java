package org.apache.http.message;

import org.apache.http.Header;
import org.apache.http.HeaderIterator;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/message/BasicHeaderIterator.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class BasicHeaderIterator implements HeaderIterator {
    protected final Header[] allHeaders = null;
    protected int currentIndex;
    protected String headerName;

    public BasicHeaderIterator(Header[] headerArr, String str) {
        throw new RuntimeException("Stub!");
    }

    protected boolean filterHeader(int i) {
        throw new RuntimeException("Stub!");
    }

    protected int findNext(int i) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HeaderIterator, java.util.Iterator
    public boolean hasNext() {
        throw new RuntimeException("Stub!");
    }

    @Override // java.util.Iterator
    public final Object next() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HeaderIterator
    public Header nextHeader() {
        throw new RuntimeException("Stub!");
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new RuntimeException("Stub!");
    }
}
