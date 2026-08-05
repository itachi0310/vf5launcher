package com.android.launcher6;

import android.appwidget.AppWidgetProviderInfo;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class PagedViewWidget extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    lz f94a;
    ma b;
    boolean c;
    boolean e;
    private String h;
    private final Rect i;
    private Object j;
    private ob k;
    private static boolean f = true;
    private static boolean g = true;
    static PagedViewWidget d = null;

    public PagedViewWidget(Context context) {
        this(context, null);
    }

    public PagedViewWidget(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagedViewWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f94a = null;
        this.b = null;
        this.c = false;
        this.i = new Rect();
        this.h = context.getResources().getString(R.string.widget_dims_format);
        setWillNotDraw(false);
        setClipToPadding(false);
    }

    static void a() {
        d = null;
    }

    private void b() {
        if (d != null) {
            return;
        }
        if (this.f94a == null) {
            this.f94a = new lz(this);
        }
        postDelayed(this.f94a, 120L);
    }

    private void c() {
        if (this.f94a != null) {
            removeCallbacks(this.f94a);
        }
    }

    private void d() {
        c();
        if (this.c) {
            if (this.b != null) {
                this.b.b(this);
            }
            this.c = false;
        }
    }

    public static void setDeletePreviewsWhenDetachedFromWindow(boolean z) {
        f = z;
    }

    public static void setRecyclePreviewsWhenDetachedFromWindow(boolean z) {
        g = z;
    }

    public void a(AppWidgetProviderInfo appWidgetProviderInfo, int i, int[] iArr, ob obVar) {
        bl blVarA = ip.a().i().a();
        this.e = true;
        this.j = appWidgetProviderInfo;
        ImageView imageView = (ImageView) findViewById(R.id.widget_preview);
        if (i > -1) {
            imageView.setMaxWidth(i);
        }
        ((TextView) findViewById(R.id.widget_name)).setText(appWidgetProviderInfo.label);
        TextView textView = (TextView) findViewById(R.id.widget_dims);
        if (textView != null) {
            textView.setText(String.format(this.h, Integer.valueOf(Math.min(iArr[0], (int) blVarA.e)), Integer.valueOf(Math.min(iArr[1], (int) blVarA.d))));
        }
        this.k = obVar;
    }

    public void a(PackageManager packageManager, ResolveInfo resolveInfo, ob obVar) {
        this.e = false;
        this.j = resolveInfo;
        ((TextView) findViewById(R.id.widget_name)).setText(resolveInfo.loadLabel(packageManager));
        TextView textView = (TextView) findViewById(R.id.widget_dims);
        if (textView != null) {
            textView.setText(String.format(this.h, 1, 1));
        }
        this.k = obVar;
    }

    void a(ci ciVar, int i) {
        PagedViewWidgetImageView pagedViewWidgetImageView = (PagedViewWidgetImageView) findViewById(R.id.widget_preview);
        if (ciVar != null) {
            pagedViewWidgetImageView.f95a = false;
            pagedViewWidgetImageView.setImageDrawable(ciVar);
            if (this.e) {
                pagedViewWidgetImageView.setPadding(((getPreviewSize()[0] - ciVar.getIntrinsicWidth()) / 2) + this.i.left, this.i.top, this.i.right, this.i.bottom);
            }
            pagedViewWidgetImageView.setAlpha(1.0f);
            pagedViewWidgetImageView.f95a = true;
        }
    }

    public int[] getPreviewSize() {
        ImageView imageView = (ImageView) findViewById(R.id.widget_preview);
        return new int[]{(imageView.getWidth() - this.i.left) - this.i.right, imageView.getHeight() - this.i.top};
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        ImageView imageView;
        super.onDetachedFromWindow();
        if (!f || (imageView = (ImageView) findViewById(R.id.widget_preview)) == null) {
            return;
        }
        ci ciVar = (ci) imageView.getDrawable();
        if (g && this.j != null && ciVar != null && ciVar.a() != null) {
            this.k.a(this.j, ciVar.a());
        }
        imageView.setImageDrawable(null);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        ImageView imageView = (ImageView) findViewById(R.id.widget_preview);
        this.i.left = imageView.getPaddingLeft();
        this.i.top = imageView.getPaddingTop();
        this.i.right = imageView.getPaddingRight();
        this.i.bottom = imageView.getPaddingBottom();
        bl blVarA = ip.a().i().a();
        TextView textView = (TextView) findViewById(R.id.widget_name);
        if (textView != null) {
            textView.setTextSize(2, blVarA.g);
        }
        TextView textView2 = (TextView) findViewById(R.id.widget_dims);
        if (textView2 != null) {
            textView2.setTextSize(2, blVarA.g);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                b();
                break;
            case 1:
                d();
                break;
            case 3:
                d();
                break;
        }
        return true;
    }

    void setShortPressListener(ma maVar) {
        this.b = maVar;
    }
}
