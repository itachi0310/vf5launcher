package org.greenrobot.eventbus.util;

import android.content.res.Resources;
import android.util.Log;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: Launcher3.apk:libs/eventbus-3.1.1.jar:org/greenrobot/eventbus/util/ErrorDialogConfig.class */
public class ErrorDialogConfig {
    final Resources resources;
    final int defaultTitleId;
    final int defaultErrorMsgId;
    EventBus eventBus;
    String tagForLoggingExceptions;
    int defaultDialogIconId;
    Class<?> defaultEventTypeOnDialogClosed;
    boolean logExceptions = true;
    final ExceptionToResourceMapping mapping = new ExceptionToResourceMapping();

    public ErrorDialogConfig(Resources resources, int defaultTitleId, int defaultMsgId) {
        this.resources = resources;
        this.defaultTitleId = defaultTitleId;
        this.defaultErrorMsgId = defaultMsgId;
    }

    public ErrorDialogConfig addMapping(Class<? extends Throwable> clazz, int msgId) {
        this.mapping.addMapping(clazz, msgId);
        return this;
    }

    public int getMessageIdForThrowable(Throwable throwable) {
        Integer resId = this.mapping.mapThrowable(throwable);
        if (resId != null) {
            return resId.intValue();
        }
        Log.d(EventBus.TAG, "No specific message ressource ID found for " + throwable);
        return this.defaultErrorMsgId;
    }

    public void setDefaultDialogIconId(int defaultDialogIconId) {
        this.defaultDialogIconId = defaultDialogIconId;
    }

    public void setDefaultEventTypeOnDialogClosed(Class<?> defaultEventTypeOnDialogClosed) {
        this.defaultEventTypeOnDialogClosed = defaultEventTypeOnDialogClosed;
    }

    public void disableExceptionLogging() {
        this.logExceptions = false;
    }

    public void setTagForLoggingExceptions(String tagForLoggingExceptions) {
        this.tagForLoggingExceptions = tagForLoggingExceptions;
    }

    public void setEventBus(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    EventBus getEventBus() {
        return this.eventBus != null ? this.eventBus : EventBus.getDefault();
    }
}
