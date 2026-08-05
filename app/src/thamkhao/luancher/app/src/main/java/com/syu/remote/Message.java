package com.syu.remote;

/* JADX INFO: loaded from: Launcher3.apk:bin/autolib.jar:com/syu/remote/Message.class */
public class Message {
    public int module;
    public int code;
    public int[] ints;
    public float[] flts;
    public String[] strs;

    public Message(int module, int code, int[] ints, float[] flts, String[] strs) {
        this.module = module;
        this.code = code;
        this.ints = ints;
        this.flts = flts;
        this.strs = strs;
    }
}
