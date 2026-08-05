package com.fyt.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class AppIconTextView extends TextView {
    private Bitmap mAppIcon;

    public Bitmap getAppIcon() {
        return this.mAppIcon;
    }

    public void setAppIcon(Bitmap appIcon) {
        this.mAppIcon = appIcon;
    }

    public AppIconTextView(Context context) {
        super(context);
    }

    public AppIconTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AppIconTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
