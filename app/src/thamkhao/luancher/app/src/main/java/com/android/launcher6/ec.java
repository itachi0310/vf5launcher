package com.android.launcher6;

import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
class ec {
    long f;
    int g;
    long h;
    long i;
    int j;
    int k;
    int l;
    int m;
    int n;
    int o;
    boolean p;
    CharSequence q;
    int[] r;

    ec() {
        this.f = -1L;
        this.h = -1L;
        this.i = -1L;
        this.j = -1;
        this.k = -1;
        this.l = 1;
        this.m = 1;
        this.n = 1;
        this.o = 1;
        this.p = false;
        this.r = null;
    }

    ec(ec ecVar) {
        this.f = -1L;
        this.h = -1L;
        this.i = -1L;
        this.j = -1;
        this.k = -1;
        this.l = 1;
        this.m = 1;
        this.n = 1;
        this.o = 1;
        this.p = false;
        this.r = null;
        this.f = ecVar.f;
        this.j = ecVar.j;
        this.k = ecVar.k;
        this.l = ecVar.l;
        this.m = ecVar.m;
        this.i = ecVar.i;
        this.g = ecVar.g;
        this.h = ecVar.h;
        iv.a(this);
    }

    static void a(ContentValues contentValues, Bitmap bitmap) {
        if (bitmap != null) {
            contentValues.put("icon", a(bitmap));
        }
    }

    static byte[] a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bitmap.getWidth() * bitmap.getHeight() * 4);
        try {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            Log.w("Favorite", "Could not write icon");
            return null;
        }
    }

    void a(ContentValues contentValues) {
        contentValues.put("itemType", Integer.valueOf(this.g));
        contentValues.put("container", Long.valueOf(this.h));
        contentValues.put("screen", Long.valueOf(this.i));
        contentValues.put("cellX", Integer.valueOf(this.j));
        contentValues.put("cellY", Integer.valueOf(this.k));
        contentValues.put("spanX", Integer.valueOf(this.l));
        contentValues.put("spanY", Integer.valueOf(this.m));
    }

    void a(ContentValues contentValues, int i, int i2) {
        contentValues.put("cellX", Integer.valueOf(i));
        contentValues.put("cellY", Integer.valueOf(i2));
    }

    protected Intent b() {
        throw new RuntimeException("Unexpected Intent");
    }

    void b_() {
    }

    public String toString() {
        return "Item(id=" + this.f + " type=" + this.g + " container=" + this.h + " screen=" + this.i + " cellX=" + this.j + " cellY=" + this.k + " spanX=" + this.l + " spanY=" + this.m + " dropPos=" + this.r + ")";
    }
}
