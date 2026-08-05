package com.syu.a;

import android.content.Context;
import com.syu.f.g;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpStatus;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static int g = 0;
    public static int h = 0;
    public static int i = 0;
    static a j;
    public static int o;
    public g k;
    Context l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int[] f505a = {0, 28, 39, 50, 4, HttpStatus.SC_SWITCHING_PROTOCOLS};
    final int[] b = new int[0];
    final int[] c = {1000, 1016};
    final int[] d = {0, 1, 2, 20, 23, 21};
    final int[] e = {0, 1, 2, 28, 26, 13, 9};
    final int[] f = {2, 3};
    String m = "";
    int n = 0;
    List p = new ArrayList();
    List q = new ArrayList();

    private a(Context context) {
        this.l = context;
        this.k = new g(this.l);
        a(this.k);
        c(this.k);
        b(this.k);
        d(this.k);
        e(this.k);
        this.k.a();
    }

    public static a a(Context context) {
        if (j == null) {
            j = new a(context);
        }
        return j;
    }

    public g a() {
        return this.k;
    }

    void a(g gVar) {
        if (gVar == null) {
            return;
        }
        gVar.b(0, this.f505a);
        gVar.b(4, this.f);
        gVar.a(0, new b(this), 0, 28, 39, 50);
    }

    void b(g gVar) {
        if (gVar == null) {
            return;
        }
        gVar.b(7, this.c);
        gVar.a(7, new c(this), 1000, 1016);
    }

    void c(g gVar) {
        if (gVar == null) {
            return;
        }
        gVar.b(6, this.b);
    }

    void d(g gVar) {
        if (gVar == null) {
            return;
        }
        gVar.b(1, this.d);
    }

    void e(g gVar) {
        if (gVar == null) {
            return;
        }
        gVar.b(2, this.e);
    }
}
