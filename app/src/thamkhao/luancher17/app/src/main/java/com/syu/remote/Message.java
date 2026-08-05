package com.syu.remote;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:bin/autolib.jar:com/syu/remote/Message.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
public class Message {
    public int code;
    public float[] flts;
    public int[] ints;
    public int module;
    public String[] strs;

    public Message(int module, int code, int[] ints, float[] flts, String[] strs) {
        this.module = module;
        this.code = code;
        this.ints = ints;
        this.flts = flts;
        this.strs = strs;
    }
}
