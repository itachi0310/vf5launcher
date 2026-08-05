package org.apache.http.message;

import java.util.List;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/message/BasicListHeaderIterator.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class BasicListHeaderIterator implements HeaderIterator {
    protected final List allHeaders;
    protected int currentIndex;
    protected String headerName;
    protected int lastIndex;

    public BasicListHeaderIterator(List list, String str) {
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
