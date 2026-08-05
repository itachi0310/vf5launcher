package com.android.launcher6;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Hotseat extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CellLayout f84a;
    private Launcher b;
    private int c;
    private boolean d;

    public Hotseat(Context context) {
        this(context, null);
    }

    public Hotseat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Hotseat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = context.getResources().getBoolean(R.bool.hotseat_landscape_layout);
        com.syu.g.i.a().a("Hotseat orientation mIsLandscape == " + this.d);
    }

    private boolean b() {
        return !this.d;
    }

    int a(int i) {
        if (b()) {
            return 0;
        }
        return i;
    }

    Intent a(String str) {
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(str);
        List<ResolveInfo> listQueryIntentActivities = getContext().getPackageManager().queryIntentActivities(intent, 0);
        if (listQueryIntentActivities.size() <= 0) {
            return null;
        }
        ResolveInfo resolveInfo = listQueryIntentActivities.get(0);
        Intent intent2 = new Intent("android.intent.action.MAIN");
        intent2.addCategory("android.intent.category.LAUNCHER");
        intent2.setFlags(270532608);
        intent2.setComponent(new ComponentName(str, resolveInfo.activityInfo.name));
        return intent2;
    }

    Rect a(int i, int i2) {
        Rect rect = new Rect();
        this.f84a.b(i, i2, 1, 1, rect);
        int[] iArr = new int[2];
        my.a(this, this.b.f(), iArr, false);
        rect.offset(iArr[0], iArr[1]);
        rect.offset((int) Math.max(0.0f, (rect.width() - this.f84a.getShortcutsAndWidgets().getCellContentWidth()) / 2.0f), (int) Math.max(0.0f, (rect.height() - this.f84a.getShortcutsAndWidgets().getCellContentHeight()) / 2.0f));
        return rect;
    }

    void a() {
        this.f84a.removeAllViewsInLayout();
        if (AppsCustomizePagedView.b) {
            return;
        }
        a(a.b.a().aM, R.string.all_apps_button_label, this.c);
        if (getResources().getBoolean(R.bool.hotseat_load_defualt_workspace)) {
            return;
        }
        bl blVarA = ip.a().i().a();
        int size = blVarA.O.size();
        if (size > 0) {
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                a(blVarA.Q[i2], blVarA.P[i2], i < this.c ? i : i + 1);
                i++;
            }
        }
    }

    void a(int i, int i2, int i3) {
        Context context = getContext();
        TextView textView = (TextView) LayoutInflater.from(context).inflate(R.layout.all_apps_button, (ViewGroup) this.f84a, false);
        Drawable drawable = context.getResources().getDrawable(i);
        my.a(drawable);
        textView.setCompoundDrawables(null, drawable, null, null);
        textView.setContentDescription(context.getString(i2));
        if (this.b != null) {
            textView.setOnTouchListener(this.b.y());
        }
        textView.setOnClickListener(new dt(this));
        al alVar = new al(a(i3), b(i3), 1, 1);
        alVar.j = false;
        this.f84a.a((View) textView, -1, 0, alVar, true);
    }

    void a(int i, String str, int i2) {
        Context context = getContext();
        TextView textView = (TextView) LayoutInflater.from(context).inflate(R.layout.all_apps_button, (ViewGroup) this.f84a, false);
        Drawable drawable = context.getResources().getDrawable(i);
        my.b(drawable);
        textView.setCompoundDrawables(null, drawable, null, null);
        textView.setTag(a(str));
        if (str.equals("navi")) {
            textView.setText(getResources().getString(R.string.car_navi));
        } else if (str.equals("com.syu.radio")) {
            textView.setText(getResources().getString(R.string.car_radio));
        } else if (str.equals("com.syu.music")) {
            textView.setText(getResources().getString(R.string.car_music));
        } else if (str.equals("com.syu.video")) {
            textView.setText(getResources().getString(R.string.car_video));
        } else if (str.equals("com.syu.bt")) {
            textView.setText(getResources().getString(R.string.car_bt));
        } else if (str.equals("com.syu.settings")) {
            textView.setText(getResources().getString(R.string.car_settings));
        }
        textView.setTextSize(16.0f);
        if (this.b != null) {
            textView.setOnTouchListener(this.b.y());
        }
        textView.setOnClickListener(new ds(this, str, textView));
        al alVar = new al(a(i2), b(i2), 1, 1);
        alVar.j = false;
        this.f84a.a((View) textView, -1, 0, alVar, true);
    }

    int b(int i) {
        if (b()) {
            return this.f84a.getCountY() - (i + 1);
        }
        return 0;
    }

    CellLayout getLayout() {
        return this.f84a;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        bl blVarA = ip.a().i().a();
        this.c = blVarA.G;
        this.f84a = (CellLayout) findViewById(R.id.layout);
        if (this.d) {
            this.f84a.b((int) blVarA.h, 1);
        } else {
            this.f84a.b(1, (int) blVarA.h);
        }
        this.f84a.setIsHotseat(true);
        com.syu.g.i.a().a("Cell width = " + this.f84a.getCellWidth() + " Cell Height = " + this.f84a.getHeight());
        a();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.b.I().ak();
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f84a.setOnLongClickListener(onLongClickListener);
    }

    public void setup(Launcher launcher) {
        this.b = launcher;
        setOnKeyListener(new du());
    }
}
