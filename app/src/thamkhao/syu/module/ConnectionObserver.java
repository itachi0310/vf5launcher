package com.syu.module;

import com.syu.ipc.IRemoteToolkit;

/* JADX INFO: loaded from: classes.dex */
public interface ConnectionObserver {
    void onConnected(IRemoteToolkit iRemoteToolkit);

    void onDisconnected();
}
