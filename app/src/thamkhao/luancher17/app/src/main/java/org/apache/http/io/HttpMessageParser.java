package org.apache.http.io;

import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/io/HttpMessageParser.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface HttpMessageParser {
    HttpMessage parse() throws HttpException, IOException;
}
