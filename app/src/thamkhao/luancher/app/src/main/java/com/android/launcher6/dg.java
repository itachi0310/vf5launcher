package com.android.launcher6;

import android.content.ContentValues;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class dg extends ec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f177a;
    ArrayList b = new ArrayList();
    ArrayList c = new ArrayList();

    dg() {
        this.g = 2;
    }

    void a() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.c.size()) {
                return;
            }
            ((dh) this.c.get(i2)).o();
            i = i2 + 1;
        }
    }

    @Override // com.android.launcher6.ec
    void a(ContentValues contentValues) {
        super.a(contentValues);
        contentValues.put("title", this.q.toString());
    }

    void a(dh dhVar) {
        this.c.add(dhVar);
    }

    public void a(mp mpVar) {
        this.b.add(mpVar);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.c.size()) {
                a();
                return;
            } else {
                ((dh) this.c.get(i2)).e(mpVar);
                i = i2 + 1;
            }
        }
    }

    public void a(CharSequence charSequence) {
        this.q = charSequence;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.c.size()) {
                return;
            }
            ((dh) this.c.get(i2)).a(charSequence);
            i = i2 + 1;
        }
    }

    public void b(mp mpVar) {
        this.b.remove(mpVar);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.c.size()) {
                a();
                return;
            } else {
                ((dh) this.c.get(i2)).f(mpVar);
                i = i2 + 1;
            }
        }
    }

    @Override // com.android.launcher6.ec
    void b_() {
        super.b_();
        this.c.clear();
    }

    @Override // com.android.launcher6.ec
    public String toString() {
        return "FolderInfo(id=" + this.f + " type=" + this.g + " container=" + this.h + " screen=" + this.i + " cellX=" + this.j + " cellY=" + this.k + " spanX=" + this.l + " spanY=" + this.m + " dropPos=" + this.r + ")";
    }
}
