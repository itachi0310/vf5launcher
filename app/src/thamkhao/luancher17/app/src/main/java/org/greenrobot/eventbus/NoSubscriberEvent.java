package org.greenrobot.eventbus;

/* JADX INFO: loaded from: 190001025_com.android.launcher17.apk:libs/eventbus-3.1.1.jar:org/greenrobot/eventbus/NoSubscriberEvent.class */
public final class NoSubscriberEvent {
    public final EventBus eventBus;
    public final Object originalEvent;

    public NoSubscriberEvent(EventBus eventBus, Object originalEvent) {
        this.eventBus = eventBus;
        this.originalEvent = originalEvent;
    }
}
