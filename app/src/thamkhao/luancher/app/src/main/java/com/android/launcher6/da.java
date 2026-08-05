package com.android.launcher6;

import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public class da {
    public static Drawable f = null;
    public static Drawable g = null;
    public static int h = -1;
    public static int i = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f171a;
    public int b;
    public float c;
    public float d;
    public FolderIcon e;
    private CellLayout j;
    private ValueAnimator k;
    private ValueAnimator l;

    public da(Launcher launcher, FolderIcon folderIcon) {
        this.e = null;
        this.e = folderIcon;
        Resources resources = launcher.getResources();
        if (FolderIcon.g) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                throw new RuntimeException("FolderRingAnimator loading drawables on non-UI thread " + Thread.currentThread());
            }
            h = ip.a().i().a().z;
            i = resources.getDimensionPixelSize(R.dimen.folder_preview_padding);
            f = resources.getDrawable(R.drawable.portal_ring_outer_holo);
            g = resources.getDrawable(R.drawable.portal_ring_inner_nolip_holo);
            FolderIcon.f81a = resources.getDrawable(R.drawable.portal_ring_rest);
            FolderIcon.g = false;
        }
    }

    public void a() {
        if (this.l != null) {
            this.l.cancel();
        }
        this.k = ik.a(this.j, 0.0f, 1.0f);
        this.k.setDuration(100L);
        this.k.addUpdateListener(new db(this, h));
        this.k.addListener(new dc(this));
        this.k.start();
    }

    public void a(int i2, int i3) {
        this.f171a = i2;
        this.b = i3;
    }

    public void a(CellLayout cellLayout) {
        this.j = cellLayout;
    }

    public void b() {
        if (this.k != null) {
            this.k.cancel();
        }
        this.l = ik.a(this.j, 0.0f, 1.0f);
        this.l.setDuration(100L);
        this.l.addUpdateListener(new dd(this, h));
        this.l.addListener(new de(this));
        this.l.start();
    }

    public float c() {
        return this.c;
    }

    public float d() {
        return this.d;
    }
}
