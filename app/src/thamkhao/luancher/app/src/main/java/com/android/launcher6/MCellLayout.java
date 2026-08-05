package com.android.launcher6;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class MCellLayout extends CellLayout implements View.OnLongClickListener {
    public MCellLayout(Context context) {
        super(context);
        setOnLongClickListener(this);
    }

    public MCellLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnLongClickListener(this);
    }

    public MCellLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOnLongClickListener(this);
    }

    @Override // com.android.launcher6.CellLayout
    public boolean a(View view, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        return false;
    }

    @Override // com.android.launcher6.CellLayout
    public boolean a(View view, int i, int i2, al alVar, boolean z) {
        if (alVar.f109a < 0 || alVar.f109a > getCountX() || alVar.b < 0 || alVar.b > getCountY()) {
            return false;
        }
        if (alVar.f < 0) {
            alVar.f = getCountX();
        }
        if (alVar.g < 0) {
            alVar.g = getCountY();
        }
        view.setId(i2);
        if (z) {
            c(view);
        }
        return true;
    }

    @Override // com.android.launcher6.CellLayout
    int[] a(int i, int i2, int i3, int i4, int i5, int i6, View view, int[] iArr, int[] iArr2, int i7) {
        return new int[]{-1, -1};
    }

    @Override // com.android.launcher6.CellLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!(view instanceof MCellLayout) || Launcher.F().ao()) {
            return true;
        }
        if (!Launcher.F().ap()) {
            if (Launcher.G() != null) {
                Launcher.G().g(true);
            }
            return false;
        }
        if (Launcher.G() != null) {
            Launcher.G().h(true);
        }
        Launcher.F().performHapticFeedback(0, 1);
        return true;
    }
}
