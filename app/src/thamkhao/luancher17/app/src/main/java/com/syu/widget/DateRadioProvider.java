package com.syu.widget;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class DateRadioProvider extends WidgetProvider {
    @Override // com.syu.widget.WidgetProvider
    public void update(Context context, int appwidgetId) {
        Widget widget = Widget.getWidget(appwidgetId);
        if (widget == null) {
            widget = new DateRadioWidget(context, appwidgetId);
        }
        widget.update();
    }
}
