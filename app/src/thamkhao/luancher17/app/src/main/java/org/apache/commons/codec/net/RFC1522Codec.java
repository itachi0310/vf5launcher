package org.apache.commons.codec.net;

import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/commons/codec/net/RFC1522Codec.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
abstract class RFC1522Codec {
    protected abstract byte[] doDecoding(byte[] bArr) throws DecoderException;

    protected abstract byte[] doEncoding(byte[] bArr) throws EncoderException;

    protected abstract String getEncoding();

    RFC1522Codec() {
        throw new RuntimeException("Stub!");
    }

    protected String encodeText(String text, String charset) throws EncoderException, UnsupportedEncodingException {
        throw new RuntimeException("Stub!");
    }

    protected String decodeText(String text) throws DecoderException, UnsupportedEncodingException {
        throw new RuntimeException("Stub!");
    }
}
