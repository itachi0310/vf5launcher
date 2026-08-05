package com.android.launcher6;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class AccessibleTabView extends TextView {
    public AccessibleTabView(Context context) {
        super(context);
    }

    public AccessibleTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AccessibleTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return cm.a(this, i, keyEvent) || super.onKeyDown(i, keyEvent);
    }

    @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return cm.a(this, i, keyEvent) || super.onKeyUp(i, keyEvent);
    }
}
