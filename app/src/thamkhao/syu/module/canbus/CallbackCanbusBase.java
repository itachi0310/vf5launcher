package com.syu.module.canbus;

import com.syu.ipc.IModuleCallback;

/* JADX INFO: loaded from: classes.dex */
public abstract class CallbackCanbusBase extends IModuleCallback.Stub {
    public abstract void in();

    public abstract void out();
}
