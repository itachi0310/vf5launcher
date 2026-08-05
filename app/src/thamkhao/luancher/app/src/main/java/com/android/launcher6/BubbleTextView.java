package com.android.launcher6;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class BubbleTextView extends TextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static float f72a = LauncherApplication.d;
    static float b = LauncherApplication.e;
    private int c;
    private dq d;
    private final Canvas e;
    private final Rect f;
    private boolean g;
    private Bitmap h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private boolean n;
    private boolean o;
    private boolean p;
    private Drawable q;
    private boolean r;
    private ar s;
    private AttributeSet t;

    public BubbleTextView(Context context) {
        this(context, null);
    }

    public BubbleTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BubbleTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = -1;
        this.e = new Canvas();
        this.f = new Rect();
        this.n = true;
        a(attributeSet);
    }

    private Bitmap a(Canvas canvas, int i, int i2) {
        int i3 = this.d.f185a;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(getWidth() + i3, getHeight() + i3, Bitmap.Config.ARGB_8888);
        canvas.setBitmap(bitmapCreateBitmap);
        a(canvas, i3);
        this.d.a(bitmapCreateBitmap, canvas, i2, i);
        canvas.setBitmap(null);
        return bitmapCreateBitmap;
    }

    private String a(int i, String str) {
        String string = "";
        try {
            string = getResources().getString(i);
        } catch (Exception e) {
        }
        return TextUtils.isEmpty(string) ? str : string;
    }

    private void a(Canvas canvas, int i) {
        Rect rect = this.f;
        getDrawingRect(rect);
        rect.bottom = (getExtendedPaddingTop() - 3) + getLayout().getLineTop(0);
        canvas.save();
        canvas.scale(getScaleX(), getScaleY(), (getWidth() + i) / 2, (getHeight() + i) / 2);
        canvas.translate((-getScrollX()) + (i / 2), (-getScrollY()) + (i / 2));
        canvas.clipRect(rect, Region.Op.REPLACE);
        draw(canvas);
        canvas.restore();
    }

    private void a(AttributeSet attributeSet) {
        this.t = attributeSet;
        this.s = new ar(this);
        this.q = getBackground();
        this.d = dq.a(getContext());
        int color = getContext().getResources().getColor(R.color.outline_color);
        this.l = color;
        this.k = color;
        this.j = color;
        this.i = color;
        setShadowLayer(f72a, 0.0f, 2.0f, -587202560);
    }

    private void a(View view, int i) {
        for (com.fyt.b.c.b bVar : com.fyt.b.g.d().a()) {
            if (bVar.b() == view) {
                for (com.fyt.b.c.a aVar : bVar.a()) {
                    if (aVar.a().equals("drawableTop")) {
                        aVar.a(i);
                    }
                    if (aVar.a().equals("tag")) {
                        aVar.a(R.id.str_tag);
                    }
                }
                return;
            }
        }
    }

    void a() {
        mo moVar;
        if (!(getParent() instanceof mo) || (moVar = (mo) getParent()) == null) {
            return;
        }
        CellLayout cellLayout = (CellLayout) moVar.getParent();
        if (this.h == null) {
            this = null;
        }
        cellLayout.setPressedOrFocusedIcon(this);
    }

    public void a(mp mpVar, dv dvVar) {
        Bitmap bitmapA = mpVar.a(dvVar);
        ip.a().i().a();
        switch (LauncherApplication.f88a.getResources().getInteger(R.integer.appNameAlign)) {
            case 0:
                setCompoundDrawables(my.a(bitmapA), null, null, null);
                break;
            case 1:
                setCompoundDrawables(null, my.a(bitmapA), null, null);
                break;
            case 2:
                setCompoundDrawables(null, null, my.a(bitmapA), null);
                break;
            case 3:
                setCompoundDrawables(null, null, null, my.a(bitmapA));
                break;
        }
        setCompoundDrawablePadding(LauncherApplication.f88a.getResources().getInteger(R.integer.bubbletextview_padding));
        if ("com.syu.voice.VoiceLaunch".equals(mpVar.f396a.getComponent().getClassName()) || "com.syu.voice.Launch".equals(mpVar.f396a.getComponent().getClassName())) {
            String str = SystemProperties.get("syu.voicename");
            String str2 = SystemProperties.get("persist.syu.voice.newname");
            Log.d("LZP", "voicename:" + str);
            Log.d("LZP", "voicenewname:" + str2);
            if (!TextUtils.isEmpty(str2)) {
                setText("车助理·" + str2);
            } else if (TextUtils.isEmpty(str)) {
                setText(mpVar.q);
            } else {
                setText("车助理·" + str);
            }
        } else if ("com.syu.music.MAct".equals(mpVar.f396a.getComponent().getClassName())) {
            setText(getResources().getString(R.string.car_music));
        } else if ("com.syu.video.main.VideoListActivity".equals(mpVar.f396a.getComponent().getClassName())) {
            setText(getResources().getString(R.string.car_video));
        } else if ("com.syu.eq".equals(mpVar.f396a.getComponent().getPackageName())) {
            setText(a(a.b.a().fW, mpVar.q.toString()));
        } else {
            setText(mpVar.q);
        }
        if (LauncherApplication.f88a.getResources().getBoolean(R.bool.apps_shortname) && getText().length() > 6) {
            setText(String.valueOf(getText().toString().substring(0, 3)) + "...");
        }
        setTag(mpVar);
        setTag(R.id.str_tag, mpVar.b().getComponent().getPackageName());
        a(this, mpVar.a());
    }

    void b() {
        this.h = null;
        a();
    }

    @Override // android.widget.TextView, android.view.View
    public void cancelLongPress() {
        super.cancelLongPress();
        this.s.b();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (!this.n) {
            super.draw(canvas);
            return;
        }
        Drawable drawable = this.q;
        if (drawable != null) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            if (this.p) {
                drawable.setBounds(0, 0, getRight() - getLeft(), getBottom() - getTop());
                this.p = false;
            }
            if ((scrollX | scrollY) == 0) {
                drawable.draw(canvas);
            } else {
                canvas.translate(scrollX, scrollY);
                drawable.draw(canvas);
                canvas.translate(-scrollX, -scrollY);
            }
        }
        if (getCurrentTextColor() == getResources().getColor(android.R.color.transparent)) {
            getPaint().clearShadowLayer();
            super.draw(canvas);
            return;
        }
        getPaint().setShadowLayer(f72a, 0.0f, 2.0f, -587202560);
        super.draw(canvas);
        canvas.save(2);
        canvas.clipRect(getScrollX(), getScrollY() + getExtendedPaddingTop(), getScrollX() + getWidth(), getScrollY() + getHeight(), Region.Op.REVERSE_DIFFERENCE);
        getPaint().setShadowLayer(b, 0.0f, 0.0f, -872415232);
        super.draw(canvas);
        canvas.restore();
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        if (!isPressed()) {
            boolean z = this.h == null;
            if (!this.r) {
                this.h = null;
            }
            setFocusable(false);
            if (isFocused()) {
                if (getLayout() == null) {
                    this.h = null;
                } else {
                    this.h = a(this.e, this.j, this.i);
                }
                this.r = false;
                a();
            }
            boolean z2 = this.h == null;
            if (!z && z2) {
                a();
            }
        } else if (!this.g) {
            a();
        }
        Drawable drawable = this.q;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
        super.drawableStateChanged();
    }

    Bitmap getPressedOrFocusedBackground() {
        return this.h;
    }

    int getPressedOrFocusedBackgroundPadding() {
        return this.d.f185a / 2;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.q != null) {
            this.q.setCallback(this);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.q != null) {
            this.q.setCallback(null);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        setTextSize(2, ip.a().i().a().g);
    }

    @Override // android.view.View
    protected boolean onSetAlpha(int i) {
        if (this.c == i) {
            return true;
        }
        this.c = i;
        super.onSetAlpha(i);
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (this.h == null) {
                    this.h = a(this.e, this.l, this.k);
                }
                if (isPressed()) {
                    this.g = true;
                    a();
                } else {
                    this.g = false;
                }
                this.s.a();
                return zOnTouchEvent;
            case 1:
            case 3:
                if (!isPressed()) {
                    this.h = null;
                }
                this.s.b();
                return zOnTouchEvent;
            case 2:
            default:
                return zOnTouchEvent;
        }
    }

    @Override // android.widget.TextView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        if (getLeft() != i || getRight() != i3 || getTop() != i2 || getBottom() != i4) {
            this.p = true;
        }
        return super.setFrame(i, i2, i3, i4);
    }

    public void setShadowsEnabled(boolean z) {
        this.n = z;
        getPaint().clearShadowLayer();
        invalidate();
    }

    void setStayPressed(boolean z) {
        this.r = z;
        if (!z) {
            this.h = null;
        }
        a();
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null) {
            iv.a((ec) obj);
        }
        super.setTag(obj);
    }

    @Override // android.widget.TextView
    public void setTextColor(int i) {
        this.m = i;
    }

    public void setTextVisibility(boolean z) {
        getResources();
        this.o = z;
    }

    @Override // android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return drawable == this.q || super.verifyDrawable(drawable);
    }
}
