package android.support.v4.net;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/net/ConnectivityManagerCompatGingerbread.class */
class ConnectivityManagerCompatGingerbread {
    ConnectivityManagerCompatGingerbread() {
    }

    public static boolean isActiveNetworkMetered(ConnectivityManager cm) {
        NetworkInfo info = cm.getActiveNetworkInfo();
        if (info == null) {
            return true;
        }
        int type = info.getType();
        switch (type) {
            case 0:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return true;
            case 1:
                return false;
            default:
                return true;
        }
    }
}
