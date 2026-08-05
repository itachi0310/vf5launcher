package com.fyt.b.b;

import android.content.Context;
import android.content.res.TypedArray;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static int[] a(Context context, int[] iArr) {
        int[] iArr2 = new int[1];
        iArr2[0] = iArr.length;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        for (int i = 0; i < typedArrayObtainStyledAttributes.length(); i++) {
            iArr2[i] = typedArrayObtainStyledAttributes.getResourceId(i, 0);
        }
        typedArrayObtainStyledAttributes.recycle();
        return iArr2;
    }
}
