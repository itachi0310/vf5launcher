package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
enum ku {
    TRANSLATION_X,
    TRANSLATION_Y,
    SCALE_X,
    SCALE_Y,
    ROTATION_Y,
    ALPHA,
    START_DELAY,
    DURATION,
    INTERPOLATOR,
    WITH_LAYER;

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static ku[] valuesCustom() {
        ku[] kuVarArrValuesCustom = values();
        int length = kuVarArrValuesCustom.length;
        ku[] kuVarArr = new ku[length];
        System.arraycopy(kuVarArrValuesCustom, 0, kuVarArr, 0, length);
        return kuVarArr;
    }
}
