package com.android.launcher6;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class Cling extends FrameLayout implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener, dy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f75a = "first_run_portrait";
    private static String b = "first_run_landscape";
    private static String c = "workspace_portrait";
    private static String d = "workspace_landscape";
    private static String e = "workspace_large";
    private static String f = "workspace_custom";
    private static String g = "folder_portrait";
    private static String h = "folder_landscape";
    private static String i = "folder_large";
    private static float j = 60.0f;
    private static float k = 50.0f;
    private static float l = 60.0f;
    private static float m = 30.0f;
    private final Rect A;
    private Launcher n;
    private boolean o;
    private String p;
    private Drawable q;
    private int[] r;
    private Drawable s;
    private ComponentName t;
    private Rect u;
    private Paint v;
    private Paint w;
    private Paint x;
    private View y;
    private int z;

    public Cling(Context context) {
        this(context, null, 0);
    }

    public Cling(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Cling(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.r = new int[2];
        this.A = new Rect();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, mi.Cling, i2, 0);
        this.p = typedArrayObtainStyledAttributes.getString(0);
        typedArrayObtainStyledAttributes.recycle();
        setClickable(true);
    }

    void a() {
        this.q = null;
        this.o = false;
    }

    void a(int i2, int i3, ComponentName componentName, String str, String str2) {
        getResources();
        Hotseat hotseat = null;
        if (0 == 0 || i2 <= -1 || i3 <= -1 || str.isEmpty() || str2.isEmpty()) {
            return;
        }
        Rect rectA = hotseat.a(hotseat.a(i3), hotseat.b(i3));
        bl blVarA = ip.a().i().a();
        this.s = getResources().getDrawable(i2);
        this.t = componentName;
        this.u = new Rect(rectA.left, rectA.top, rectA.left + my.f404a, rectA.top + my.b);
        my.b(this.u, blVarA.i / blVarA.f);
        TextView textView = (TextView) findViewById(R.id.focused_hotseat_app_title);
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = (TextView) findViewById(R.id.focused_hotseat_app_description);
        if (textView2 != null) {
            textView2.setText(str2);
        }
        findViewById(R.id.focused_hotseat_app_bubble).setVisibility(0);
    }

    void a(int i2, Runnable runnable) {
        if (this.p.equals(f75a) || this.p.equals(b)) {
            getContent().animate().alpha(0.0f).setDuration(i2).setListener(new au(this, runnable)).start();
        } else {
            animate().alpha(0.0f).setDuration(i2).setListener(new av(this, runnable)).start();
        }
        if (this.y != null) {
            this.y.animate().alpha(0.0f).setDuration(i2).setListener(new aw(this)).start();
        }
    }

    void a(Launcher launcher, View view) {
        if (this.o) {
            return;
        }
        this.n = launcher;
        this.y = view;
        this.z = -587202560;
        setOnLongClickListener(this);
        setOnClickListener(this);
        setOnTouchListener(this);
        this.v = new Paint();
        this.v.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
        this.v.setColor(ViewCompat.MEASURED_SIZE_MASK);
        this.v.setAlpha(0);
        this.v.setAntiAlias(true);
        int color = getResources().getColor(R.color.first_run_cling_circle_background_color);
        this.w = new Paint();
        this.w.setColor(color);
        this.w.setAntiAlias(true);
        this.x = new Paint();
        this.x.setColor(7519213);
        this.x.setAntiAlias(true);
        this.o = true;
    }

    void a(boolean z, int i2) {
        setVisibility(0);
        setLayerType(2, null);
        if (this.p.equals(c) || this.p.equals(d) || this.p.equals(e) || this.p.equals(f)) {
            View content = getContent();
            content.setAlpha(0.0f);
            content.animate().alpha(1.0f).setDuration(i2).setListener(null).start();
            setAlpha(1.0f);
        } else if (z) {
            buildLayer();
            setAlpha(0.0f);
            animate().alpha(1.0f).setInterpolator(new AccelerateInterpolator()).setDuration(i2).setListener(null).start();
        } else {
            setAlpha(1.0f);
        }
        if (this.y != null) {
            this.y.setVisibility(0);
            this.y.setAlpha(0.0f);
            this.y.animate().alpha(1.0f).setDuration(i2).setListener(null).start();
        }
        setFocusableInTouchMode(true);
        post(new at(this));
    }

    void b() {
        if (this.y != null) {
            this.y.bringToFront();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Bitmap bitmapCreateBitmap;
        Canvas canvas2;
        if (this.o) {
            canvas.save();
            if (this.q == null && this.p.equals(f)) {
                this.q = getResources().getDrawable(R.drawable.bg_cling5);
            }
            if (this.y != null) {
                this.y.setBackgroundColor(this.z);
                canvas2 = null;
                bitmapCreateBitmap = null;
            } else if (this.q != null) {
                this.q.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
                this.q.draw(canvas);
                canvas2 = null;
                bitmapCreateBitmap = null;
            } else if (this.p.equals(c) || this.p.equals(d) || this.p.equals(e)) {
                bitmapCreateBitmap = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
                canvas2 = new Canvas(bitmapCreateBitmap);
                canvas2.drawColor(this.z);
            } else {
                canvas.drawColor(this.z);
                canvas2 = null;
                bitmapCreateBitmap = null;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.n.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            float alpha = getAlpha();
            View content = getContent();
            if (content != null) {
                alpha *= content.getAlpha();
            }
            if (this.p.equals(f75a) || this.p.equals(b)) {
                View viewFindViewById = findViewById(R.id.bubble_content);
                Rect rect = new Rect();
                viewFindViewById.getGlobalVisibleRect(rect);
                this.w.setAlpha((int) (alpha * 255.0f));
                canvas.drawCircle(displayMetrics.widthPixels / 2, rect.centerY(), (viewFindViewById.getMeasuredWidth() + ch.a(j, displayMetrics)) / 2.0f, this.w);
            } else if (this.p.equals(c) || this.p.equals(d) || this.p.equals(e)) {
                int iA = ch.a(m, displayMetrics);
                this.v.setAlpha(128);
                canvas2.drawCircle(displayMetrics.widthPixels / 2, (displayMetrics.heightPixels / 2) - iA, 0.0f, this.v);
                this.v.setAlpha(0);
                canvas2.drawCircle(displayMetrics.widthPixels / 2, (displayMetrics.heightPixels / 2) - iA, 0.0f, this.v);
                canvas.drawBitmap(bitmapCreateBitmap, 0.0f, 0.0f, (Paint) null);
                canvas2.setBitmap(null);
                if (this.u != null && this.s != null) {
                    this.s.setBounds(this.u.left, this.u.top, this.u.right, this.u.bottom);
                    this.s.setAlpha((int) (255.0f * alpha));
                    this.s.draw(canvas);
                }
            }
            canvas.restore();
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.View
    public View focusSearch(int i2) {
        return focusSearch(this, i2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i2) {
        return FocusFinder.getInstance().findNextFocus(this, view, i2);
    }

    View getContent() {
        return findViewById(R.id.content);
    }

    String getDrawIdentifier() {
        return this.p;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((this.p.equals(c) || this.p.equals(d) || this.p.equals(e)) && this.u != null && this.u.contains(this.r[0], this.r[1])) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setComponent(this.t);
            intent.addCategory("android.intent.category.LAUNCHER");
            this.n.startActivity(intent, null);
            this.n.dismissWorkspaceCling(this);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        return this.p.equals(c) || this.p.equals(d) || this.p.equals(e) || this.p.equals(f);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.p.equals(c) && !this.p.equals(d) && !this.p.equals(e)) {
            return false;
        }
        this.n.dismissWorkspaceCling(null);
        return true;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.r[0] = (int) motionEvent.getX();
            this.r[1] = (int) motionEvent.getY();
        }
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Folder openFolder;
        if ((this.p.equals(g) || this.p.equals(h) || this.p.equals(i)) && (openFolder = this.n.I().getOpenFolder()) != null) {
            Rect rect = new Rect();
            openFolder.getHitRect(rect);
            if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.android.launcher6.dy
    public void setInsets(Rect rect) {
        this.A.set(rect);
        setPadding(rect.left, rect.top, rect.right, rect.bottom);
    }
}
