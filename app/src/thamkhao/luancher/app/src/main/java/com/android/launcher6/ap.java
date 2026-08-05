package com.android.launcher6;

import android.graphics.Rect;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class ap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ArrayList f113a;
    ak b;
    int[] d;
    int[] e;
    int[] f;
    int[] g;
    boolean h;
    boolean i;
    boolean j;
    boolean k;
    boolean l;
    final /* synthetic */ CellLayout n;
    Rect c = new Rect();
    aq m = new aq(this);

    public ap(CellLayout cellLayout, ArrayList arrayList, ak akVar) {
        this.n = cellLayout;
        this.d = new int[cellLayout.l];
        this.e = new int[cellLayout.l];
        this.f = new int[cellLayout.k];
        this.g = new int[cellLayout.k];
        this.f113a = (ArrayList) arrayList.clone();
        this.b = akVar;
        a();
    }

    void a() {
        for (int i = 0; i < this.n.k; i++) {
            this.f[i] = -1;
            this.g[i] = -1;
        }
        for (int i2 = 0; i2 < this.n.l; i2++) {
            this.d[i2] = -1;
            this.e[i2] = -1;
        }
        this.h = true;
        this.i = true;
        this.k = true;
        this.j = true;
        this.l = true;
    }

    void a(int i, int i2) {
        Iterator it = this.f113a.iterator();
        while (it.hasNext()) {
            ai aiVar = (ai) this.b.f108a.get((View) it.next());
            switch (i) {
                case 0:
                    aiVar.f106a -= i2;
                    break;
                case 1:
                    aiVar.b -= i2;
                    break;
                case 2:
                    aiVar.f106a += i2;
                    break;
                default:
                    aiVar.b += i2;
                    break;
            }
        }
        a();
    }

    void a(int i, int[] iArr) {
        int size = this.f113a.size();
        for (int i2 = 0; i2 < size; i2++) {
            ai aiVar = (ai) this.b.f108a.get(this.f113a.get(i2));
            switch (i) {
                case 0:
                    int i3 = aiVar.f106a;
                    for (int i4 = aiVar.b; i4 < aiVar.b + aiVar.d; i4++) {
                        if (i3 < iArr[i4] || iArr[i4] < 0) {
                            iArr[i4] = i3;
                        }
                    }
                    break;
                case 1:
                    int i5 = aiVar.b;
                    for (int i6 = aiVar.f106a; i6 < aiVar.f106a + aiVar.c; i6++) {
                        if (i5 < iArr[i6] || iArr[i6] < 0) {
                            iArr[i6] = i5;
                        }
                    }
                    break;
                case 2:
                    int i7 = aiVar.c + aiVar.f106a;
                    for (int i8 = aiVar.b; i8 < aiVar.b + aiVar.d; i8++) {
                        if (i7 > iArr[i8]) {
                            iArr[i8] = i7;
                        }
                    }
                    break;
                case 3:
                    int i9 = aiVar.d + aiVar.b;
                    for (int i10 = aiVar.f106a; i10 < aiVar.f106a + aiVar.c; i10++) {
                        if (i9 > iArr[i10]) {
                            iArr[i10] = i9;
                        }
                    }
                    break;
            }
        }
    }

    public void a(View view) {
        this.f113a.add(view);
        a();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    boolean a(View view, int i) {
        ai aiVar = (ai) this.b.f108a.get(view);
        int[] iArrA = a(i);
        switch (i) {
            case 0:
                for (int i2 = aiVar.b; i2 < aiVar.b + aiVar.d; i2++) {
                    if (iArrA[i2] == aiVar.f106a + aiVar.c) {
                        return true;
                    }
                }
                return false;
            case 1:
                for (int i3 = aiVar.f106a; i3 < aiVar.f106a + aiVar.c; i3++) {
                    if (iArrA[i3] == aiVar.b + aiVar.d) {
                        return true;
                    }
                }
                return false;
            case 2:
                for (int i4 = aiVar.b; i4 < aiVar.b + aiVar.d; i4++) {
                    if (iArrA[i4] == aiVar.f106a) {
                        return true;
                    }
                }
                return false;
            case 3:
                for (int i5 = aiVar.f106a; i5 < aiVar.f106a + aiVar.c; i5++) {
                    if (iArrA[i5] == aiVar.b) {
                        return true;
                    }
                }
                return false;
            default:
                return false;
        }
    }

    public int[] a(int i) {
        switch (i) {
            case 0:
                return c();
            case 1:
                return e();
            case 2:
                return d();
            default:
                return f();
        }
    }

    public Rect b() {
        if (this.l) {
            Iterator it = this.f113a.iterator();
            boolean z = true;
            while (it.hasNext()) {
                ai aiVar = (ai) this.b.f108a.get((View) it.next());
                if (z) {
                    this.c.set(aiVar.f106a, aiVar.b, aiVar.f106a + aiVar.c, aiVar.d + aiVar.b);
                    z = false;
                } else {
                    this.c.union(aiVar.f106a, aiVar.b, aiVar.f106a + aiVar.c, aiVar.d + aiVar.b);
                }
            }
        }
        return this.c;
    }

    public void b(int i) {
        this.m.f114a = i;
        Collections.sort(this.b.b, this.m);
    }

    public int[] c() {
        if (this.h) {
            a(0, this.d);
        }
        return this.d;
    }

    public int[] d() {
        if (this.i) {
            a(2, this.e);
        }
        return this.e;
    }

    public int[] e() {
        if (this.j) {
            a(1, this.f);
        }
        return this.f;
    }

    public int[] f() {
        if (this.k) {
            a(3, this.g);
        }
        return this.g;
    }
}
