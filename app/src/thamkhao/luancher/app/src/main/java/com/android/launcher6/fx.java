package com.android.launcher6;

import com.fyt.car.MusicService;

/* JADX INFO: loaded from: classes.dex */
class fx implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ fw f242a;

    fx(fw fwVar) {
        this.f242a = fwVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String[] strArr = new String[5];
        strArr[0] = LauncherApplication.f88a.getResources().getString(R.string.music_name);
        strArr[1] = LauncherApplication.f88a.getResources().getString(R.string.music_author);
        strArr[2] = MusicService.d.toString();
        strArr[4] = "/" + LauncherApplication.f88a.getResources().getString(R.string.music_name);
        com.fyt.car.c.f485a.a(null, new long[2], new float[]{0.0f, 0.0f}, strArr, MusicService.f);
    }
}
