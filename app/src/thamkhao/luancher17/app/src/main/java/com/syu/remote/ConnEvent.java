package com.syu.remote;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:bin/autolib.jar:com/syu/remote/ConnEvent.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
public class ConnEvent {
    public boolean success;
    public String type;

    public ConnEvent(String type, boolean success) {
        this.type = type;
        this.success = success;
    }
}
