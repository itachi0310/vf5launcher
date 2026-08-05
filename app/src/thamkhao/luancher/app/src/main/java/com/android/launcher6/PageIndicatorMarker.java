package com.android.launcher6;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public class PageIndicatorMarker extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ImageView f92a;
    private ImageView b;
    private boolean c;

    public PageIndicatorMarker(Context context) {
        this(context, null);
    }

    public PageIndicatorMarker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PageIndicatorMarker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = false;
    }

    void a(int i, int i2) {
        Resources resources = getResources();
        this.f92a.setImageDrawable(resources.getDrawable(i));
        this.b.setImageDrawable(resources.getDrawable(i2));
    }

    void a(boolean z) {
        if (z) {
            this.f92a.animate().cancel();
            this.f92a.setAlpha(1.0f);
            this.f92a.setScaleX(1.0f);
            this.f92a.setScaleY(1.0f);
            this.b.animate().cancel();
            this.b.setAlpha(0.0f);
        } else {
            this.f92a.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(175L).start();
            this.b.animate().alpha(0.0f).setDuration(175L).start();
        }
        this.c = true;
    }

    void b(boolean z) {
        if (z) {
            this.b.animate().cancel();
            this.b.setAlpha(1.0f);
            this.f92a.animate().cancel();
            this.f92a.setAlpha(0.0f);
            this.f92a.setScaleX(0.5f);
            this.f92a.setScaleY(0.5f);
        } else {
            this.b.animate().alpha(1.0f).setDuration(175L).start();
            this.f92a.animate().alpha(0.0f).scaleX(0.5f).scaleY(0.5f).setDuration(175L).start();
        }
        this.c = false;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        this.f92a = (ImageView) findViewById(R.id.active);
        this.b = (ImageView) findViewById(R.id.inactive);
    }
}
