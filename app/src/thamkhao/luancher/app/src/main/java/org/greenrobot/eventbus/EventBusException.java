package org.greenrobot.eventbus;

/* JADX INFO: loaded from: Launcher3.apk:libs/eventbus-3.1.1.jar:org/greenrobot/eventbus/EventBusException.class */
public class EventBusException extends RuntimeException {
    private static final long serialVersionUID = -2912559384646531479L;

    public EventBusException(String detailMessage) {
        super(detailMessage);
    }

    public EventBusException(Throwable throwable) {
        super(throwable);
    }

    public EventBusException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }
}
