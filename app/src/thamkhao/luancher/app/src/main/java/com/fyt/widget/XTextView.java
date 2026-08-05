package com.fyt.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class XTextView extends TextView {
    public XTextView(Context context) {
        this(context, null);
    }

    public XTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        setTypeface(com.syu.g.l.a().b());
    }
}
