package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
public enum q {
    Applications,
    Widgets;

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static q[] valuesCustom() {
        q[] qVarArrValuesCustom = values();
        int length = qVarArrValuesCustom.length;
        q[] qVarArr = new q[length];
        System.arraycopy(qVarArrValuesCustom, 0, qVarArr, 0, length);
        return qVarArr;
    }
}
