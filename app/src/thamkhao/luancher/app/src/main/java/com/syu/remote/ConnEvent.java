package com.syu.remote;

/* JADX INFO: loaded from: Launcher3.apk:bin/autolib.jar:com/syu/remote/ConnEvent.class */
public class ConnEvent {
    public String type;
    public boolean success;

    public ConnEvent(String type, boolean success) {
        this.type = type;
        this.success = success;
    }
}
