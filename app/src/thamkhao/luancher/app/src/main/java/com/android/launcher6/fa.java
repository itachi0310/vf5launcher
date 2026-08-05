package com.android.launcher6;

import cn.kuwo.autosdk.api.OnPlayerStatusListener;
import cn.kuwo.autosdk.api.PlayerStatus;
import cn.kuwo.autosdk.bean.Music;

/* JADX INFO: loaded from: classes.dex */
class fa implements OnPlayerStatusListener {
    private static /* synthetic */ int[] b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f219a;

    fa(Launcher launcher) {
        this.f219a = launcher;
    }

    static /* synthetic */ int[] a() {
        int[] iArr = b;
        if (iArr == null) {
            iArr = new int[PlayerStatus.valuesCustom().length];
            try {
                iArr[PlayerStatus.BUFFERING.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[PlayerStatus.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[PlayerStatus.PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[PlayerStatus.PLAYING.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[PlayerStatus.STOP.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            b = iArr;
        }
        return iArr;
    }

    @Override // cn.kuwo.autosdk.api.OnPlayerStatusListener
    public void onPlayerStatus(PlayerStatus playerStatus, Music music) {
        if (playerStatus != null) {
            switch (a()[playerStatus.ordinal()]) {
                case 2:
                    this.f219a.D = true;
                    this.f219a.E = true;
                    break;
                case 3:
                default:
                    this.f219a.D = false;
                    this.f219a.E = false;
                    break;
                case 4:
                    this.f219a.D = false;
                    this.f219a.E = true;
                    break;
            }
        }
        if (this.f219a.dz != null) {
            if (this.f219a.D) {
                this.f219a.dz.setBackgroundResource(a.b.a().ae);
            } else {
                this.f219a.dz.setBackgroundResource(a.b.a().ad);
            }
        }
        if (music != null) {
            if (this.f219a.dl != null) {
                if (this.f219a.E) {
                    this.f219a.dl.setText(music.name);
                } else {
                    this.f219a.dl.setText(R.string.car_kuwo);
                }
            }
            if (this.f219a.dm != null) {
                if (this.f219a.E) {
                    this.f219a.dm.setText(music.artist);
                } else {
                    this.f219a.dm.setText(R.string.music_author);
                }
            }
        }
    }
}
