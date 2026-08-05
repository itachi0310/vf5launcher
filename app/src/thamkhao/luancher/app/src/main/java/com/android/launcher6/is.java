package com.android.launcher6;

import android.appwidget.AppWidgetHostView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RemoteViews;

/* JADX INFO: loaded from: classes.dex */
public class is extends AppWidgetHostView implements bx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ar f313a;
    private LayoutInflater b;
    private Context c;
    private int d;
    private DragLayer e;

    public is(Context context) {
        super(context);
        this.c = context;
        this.f313a = new ar(this);
        this.b = (LayoutInflater) context.getSystemService("layout_inflater");
        this.e = ((Launcher) context).f();
    }

    @Override // com.android.launcher6.bx
    public void a() {
        this.f313a.b();
    }

    public boolean b() {
        return this.d != this.c.getResources().getConfiguration().orientation;
    }

    @Override // android.view.View
    public void cancelLongPress() {
        super.cancelLongPress();
        this.f313a.b();
    }

    @Override // android.view.ViewGroup
    public int getDescendantFocusability() {
        return 393216;
    }

    @Override // android.appwidget.AppWidgetHostView
    protected View getErrorView() {
        return this.b.inflate(R.layout.appwidget_error, (ViewGroup) this, false);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f313a.c()) {
            this.f313a.b();
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.f313a.a();
                this.e.setTouchCompleteListener(this);
                return false;
            case 1:
            case 3:
                this.f313a.b();
                return false;
            case 2:
            default:
                return false;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                this.f313a.b();
                break;
        }
        return false;
    }

    @Override // android.appwidget.AppWidgetHostView
    public void updateAppWidget(RemoteViews remoteViews) {
        this.d = this.c.getResources().getConfiguration().orientation;
        super.updateAppWidget(remoteViews);
    }
}
