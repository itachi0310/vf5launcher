package org.apache.http.impl.auth;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/auth/NTLMEngine.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface NTLMEngine {
    String generateType1Msg(String str, String str2);

    String generateType3Msg(String str, String str2, String str3, String str4, String str5);
}
