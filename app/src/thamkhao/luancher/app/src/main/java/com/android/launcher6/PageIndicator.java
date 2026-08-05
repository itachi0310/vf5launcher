package com.android.launcher6;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class PageIndicator extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LayoutInflater f91a;
    private int[] b;
    private int c;
    private ArrayList d;
    private int e;

    public PageIndicator(Context context) {
        this(context, null);
    }

    public PageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new int[2];
        this.d = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, mi.PageIndicator, i, 0);
        this.c = typedArrayObtainStyledAttributes.getInteger(0, 15);
        this.b[0] = 0;
        this.b[1] = 0;
        this.f91a = LayoutInflater.from(context);
        typedArrayObtainStyledAttributes.recycle();
        getLayoutTransition().setDuration(175L);
    }

    private void a() {
        LayoutTransition layoutTransition = getLayoutTransition();
        layoutTransition.enableTransitionType(2);
        layoutTransition.enableTransitionType(3);
        layoutTransition.enableTransitionType(0);
        layoutTransition.enableTransitionType(1);
    }

    private void b() {
        LayoutTransition layoutTransition = getLayoutTransition();
        layoutTransition.disableTransitionType(2);
        layoutTransition.disableTransitionType(3);
        layoutTransition.disableTransitionType(0);
        layoutTransition.disableTransitionType(1);
    }

    void a(int i, lh lhVar) {
        ((PageIndicatorMarker) this.d.get(i)).a(lhVar.f372a, lhVar.b);
    }

    void a(int i, lh lhVar, boolean z) {
        int iMax = Math.max(0, Math.min(i, this.d.size()));
        PageIndicatorMarker pageIndicatorMarker = (PageIndicatorMarker) this.f91a.inflate(R.layout.page_indicator_marker, (ViewGroup) this, false);
        pageIndicatorMarker.a(lhVar.f372a, lhVar.b);
        this.d.add(iMax, pageIndicatorMarker);
        a(this.e, z);
    }

    void a(int i, boolean z) {
        if (i < 0) {
            new Throwable().printStackTrace();
        }
        int iMin = Math.min(this.d.size(), this.c);
        float f = iMin / 2.0f;
        int iMin2 = Math.min(this.d.size(), Math.max(0, i - (iMin / 2)) + this.c);
        int iMin3 = iMin2 - Math.min(this.d.size(), iMin);
        int i2 = ((iMin2 - iMin3) / 2) + iMin3;
        if (iMin3 == 0) {
        }
        if (iMin2 == this.d.size()) {
        }
        boolean z2 = (this.b[0] == iMin3 && this.b[1] == iMin2) ? false : true;
        if (!z) {
            b();
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View view = (PageIndicatorMarker) getChildAt(childCount);
            int iIndexOf = this.d.indexOf(view);
            if (iIndexOf < iMin3 || iIndexOf >= iMin2) {
                removeView(view);
            }
        }
        for (int i3 = 0; i3 < this.d.size(); i3++) {
            PageIndicatorMarker pageIndicatorMarker = (PageIndicatorMarker) this.d.get(i3);
            if (iMin3 > i3 || i3 >= iMin2) {
                pageIndicatorMarker.b(true);
            } else {
                if (indexOfChild(pageIndicatorMarker) < 0) {
                    addView(pageIndicatorMarker, i3 - iMin3);
                }
                if (i3 == i) {
                    pageIndicatorMarker.a(z2);
                } else {
                    pageIndicatorMarker.b(z2);
                }
            }
        }
        if (!z) {
            a();
        }
        this.b[0] = iMin3;
        this.b[1] = iMin2;
    }

    void a(ArrayList arrayList, boolean z) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                return;
            }
            a(Integer.MAX_VALUE, (lh) arrayList.get(i2), z);
            i = i2 + 1;
        }
    }

    void a(boolean z) {
        while (this.d.size() > 0) {
            b(Integer.MAX_VALUE, z);
        }
    }

    void b(int i, boolean z) {
        if (this.d.size() > 0) {
            this.d.remove(Math.max(0, Math.min(this.d.size() - 1, i)));
            a(this.e, z);
        }
    }

    void setActiveMarker(int i) {
        this.e = i;
        a(i, false);
    }
}
