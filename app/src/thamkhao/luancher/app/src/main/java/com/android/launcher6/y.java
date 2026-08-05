package com.android.launcher6;

import android.graphics.Bitmap;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f467a;
    ArrayList b;
    ArrayList c = new ArrayList();
    int d;
    int e;
    x f;
    x g;
    ob h;

    y(int i, ArrayList arrayList, int i2, int i3, x xVar, x xVar2, ob obVar) {
        this.f467a = i;
        this.b = arrayList;
        this.d = i2;
        this.e = i3;
        this.f = xVar;
        this.g = xVar2;
        this.h = obVar;
    }

    void a(boolean z) {
        if (this.c != null) {
            if (z) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.c.size()) {
                        break;
                    }
                    this.h.a(this.b.get(i2), (Bitmap) this.c.get(i2));
                    i = i2 + 1;
                }
            }
            this.c.clear();
        }
    }
}
