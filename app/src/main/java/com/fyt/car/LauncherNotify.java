package com.fyt.car;

/**
 * Global repository for DataNotifier instances.
 */
public class LauncherNotify {
    public static final DataNotifier NOTIFIER_MUSIC = new DataNotifier();
    public static final DataNotifier NOTIFIER_VIDEO = new DataNotifier();
    public static final DataNotifier NOTIFY_MAINSTATE = new DataNotifier();
    public static final DataNotifier NOTIFY_RADIO_BAND = new DataNotifier();
    public static final DataNotifier NOTIFY_RADIO_FREQ = new DataNotifier();
    public static final DataNotifier NOTIFIER_BTAV = new DataNotifier();
    public static final DataNotifier NOTIFIER_DVR = new DataNotifier();
    public static final DataNotifier NOTIFIER_NAVIVIEW = new DataNotifier();
    public static final DataNotifier NOTIFIER_NAVISTATE = new DataNotifier();
    
    // Custom notifier for VF5 Regen data
    public static final DataNotifier NOTIFIER_REGEN_DATA = new DataNotifier();
}
