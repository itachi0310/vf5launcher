package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class cx implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ FolderIcon f167a;
    private final /* synthetic */ mp b;

    cx(FolderIcon folderIcon, mp mpVar) {
        this.f167a = folderIcon;
        this.b = mpVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f167a.v.remove(this.b);
        this.f167a.e.d(this.b);
        this.f167a.invalidate();
    }
}
