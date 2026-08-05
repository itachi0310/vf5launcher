package com.android.launcher17;

import android.graphics.PointF;

/* JADX INFO: compiled from: DynamicGrid.java */
/* JADX INFO: loaded from: classes.dex */
class DeviceProfileQuery {
    PointF dimens;
    float heightDps;
    float value;
    float widthDps;

    DeviceProfileQuery(float w, float h, float v) {
        this.widthDps = w;
        this.heightDps = h;
        this.value = v;
        this.dimens = new PointF(w, h);
    }
}
