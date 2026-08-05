package com.syu.remote;

/**
 * Standard SYU Connection Event for EventBus.
 */
public class ConnEvent {
    public boolean success;
    public String type;

    public ConnEvent(String type, boolean success) {
        this.type = type;
        this.success = success;
    }
}
