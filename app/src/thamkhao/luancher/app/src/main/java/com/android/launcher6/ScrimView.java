package com.android.launcher6;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class ScrimView extends FrameLayout implements dy {
    public ScrimView(Context context) {
        this(context, null, 0);
    }

    public ScrimView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.android.launcher6.dy
    public void setInsets(Rect rect) {
    }
}
