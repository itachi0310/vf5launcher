package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
enum ii {
    NONE,
    WORKSPACE,
    APPS_CUSTOMIZE,
    APPS_CUSTOMIZE_SPRING_LOADED;

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static ii[] valuesCustom() {
        ii[] iiVarArrValuesCustom = values();
        int length = iiVarArrValuesCustom.length;
        ii[] iiVarArr = new ii[length];
        System.arraycopy(iiVarArrValuesCustom, 0, iiVarArr, 0, length);
        return iiVarArr;
    }
}
