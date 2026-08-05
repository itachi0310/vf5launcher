package org.apache.http.client.entity;

import java.io.UnsupportedEncodingException;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.entity.StringEntity;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/client/entity/UrlEncodedFormEntity.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class UrlEncodedFormEntity extends StringEntity {
    public UrlEncodedFormEntity(List<? extends NameValuePair> parameters, String encoding) throws UnsupportedEncodingException {
        super((String) null);
        throw new RuntimeException("Stub!");
    }

    public UrlEncodedFormEntity(List<? extends NameValuePair> parameters) throws UnsupportedEncodingException {
        super((String) null);
        throw new RuntimeException("Stub!");
    }
}
