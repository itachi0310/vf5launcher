package com.android.launcher17;

import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetProviderInfo;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RemoteViews;

/* JADX INFO: loaded from: classes.dex */
public class LauncherAppWidgetHostView extends AppWidgetHostView implements DragLayer.TouchCompleteListener {
    private Context mContext;
    private DragLayer mDragLayer;
    private LayoutInflater mInflater;
    private CheckLongPressHelper mLongPressHelper;
    private int mPreviousOrientation;

    public LauncherAppWidgetHostView(Context context) {
        super(context);
        this.mContext = context;
        this.mLongPressHelper = new CheckLongPressHelper(this);
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.mDragLayer = ((Launcher) context).getDragLayer();
    }

    @Override // android.appwidget.AppWidgetHostView
    public void setAppWidget(int appWidgetId, AppWidgetProviderInfo info) {
        super.setAppWidget(appWidgetId, info);
        setPadding(0, 0, 0, 0);
    }

    @Override // android.appwidget.AppWidgetHostView
    protected View getErrorView() {
        return this.mInflater.inflate(R.layout.appwidget_error, (ViewGroup) this, false);
    }

    @Override // android.appwidget.AppWidgetHostView
    public void updateAppWidget(RemoteViews remoteViews) {
        this.mPreviousOrientation = this.mContext.getResources().getConfiguration().orientation;
        super.updateAppWidget(remoteViews);
    }

    public boolean orientationChangedSincedInflation() {
        int orientation = this.mContext.getResources().getConfiguration().orientation;
        return this.mPreviousOrientation != orientation;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (this.mLongPressHelper.hasPerformedLongPress()) {
            this.mLongPressHelper.cancelLongPress();
            return true;
        }
        switch (ev.getAction()) {
            case 0:
                this.mLongPressHelper.postCheckForLongPress();
                this.mDragLayer.setTouchCompleteListener(this);
                return false;
            case 1:
            case 3:
                this.mLongPressHelper.cancelLongPress();
                return false;
            case 2:
            default:
                return false;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case 1:
            case 3:
                this.mLongPressHelper.cancelLongPress();
                break;
        }
        return false;
    }

    @Override // android.view.View
    public void cancelLongPress() {
        super.cancelLongPress();
        this.mLongPressHelper.cancelLongPress();
    }

    @Override // com.android.launcher17.DragLayer.TouchCompleteListener
    public void onTouchComplete() {
        this.mLongPressHelper.cancelLongPress();
    }

    @Override // android.view.ViewGroup
    public int getDescendantFocusability() {
        return 393216;
    }
}
