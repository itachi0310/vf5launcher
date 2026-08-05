package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
enum pb {
    NORMAL,
    SPRING_LOADED,
    SMALL,
    OVERVIEW;

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static pb[] valuesCustom() {
        pb[] pbVarArrValuesCustom = values();
        int length = pbVarArrValuesCustom.length;
        pb[] pbVarArr = new pb[length];
        System.arraycopy(pbVarArrValuesCustom, 0, pbVarArr, 0, length);
        return pbVarArr;
    }
}
