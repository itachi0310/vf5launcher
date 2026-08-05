package com.android.launcher6;

import android.widget.SeekBar;

/* JADX INFO: renamed from: com.android.launcher6.if, reason: invalid class name */
/* JADX INFO: loaded from: classes.dex */
class Cif implements SeekBar.OnSeekBarChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f303a;

    private Cif(Launcher launcher) {
        this.f303a = launcher;
    }

    /* synthetic */ Cif(Launcher launcher, Cif cif) {
        this(launcher);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (z) {
            this.f303a.dK.seekTo(i);
            this.f303a.dH.setProgress(i);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}
