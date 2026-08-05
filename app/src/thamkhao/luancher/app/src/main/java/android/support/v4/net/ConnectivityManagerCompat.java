package android.support.v4.net;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/net/ConnectivityManagerCompat.class */
public final class ConnectivityManagerCompat {
    private static final ConnectivityManagerCompatImpl IMPL;

    /* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/net/ConnectivityManagerCompat$ConnectivityManagerCompatImpl.class */
    interface ConnectivityManagerCompatImpl {
        boolean isActiveNetworkMetered(ConnectivityManager connectivityManager);
    }

    /* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/net/ConnectivityManagerCompat$BaseConnectivityManagerCompatImpl.class */
    static class BaseConnectivityManagerCompatImpl implements ConnectivityManagerCompatImpl {
        BaseConnectivityManagerCompatImpl() {
        }

        @Override // android.support.v4.net.ConnectivityManagerCompat.ConnectivityManagerCompatImpl
        public boolean isActiveNetworkMetered(ConnectivityManager cm) {
            NetworkInfo info = cm.getActiveNetworkInfo();
            if (info == null) {
                return true;
            }
            int type = info.getType();
            switch (type) {
                case 0:
                    return true;
                case 1:
                    return false;
                default:
                    return true;
            }
        }
    }

    /* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/net/ConnectivityManagerCompat$GingerbreadConnectivityManagerCompatImpl.class */
    static class GingerbreadConnectivityManagerCompatImpl implements ConnectivityManagerCompatImpl {
        GingerbreadConnectivityManagerCompatImpl() {
        }

        @Override // android.support.v4.net.ConnectivityManagerCompat.ConnectivityManagerCompatImpl
        public boolean isActiveNetworkMetered(ConnectivityManager cm) {
            return ConnectivityManagerCompatGingerbread.isActiveNetworkMetered(cm);
        }
    }

    /* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/net/ConnectivityManagerCompat$HoneycombMR2ConnectivityManagerCompatImpl.class */
    static class HoneycombMR2ConnectivityManagerCompatImpl implements ConnectivityManagerCompatImpl {
        HoneycombMR2ConnectivityManagerCompatImpl() {
        }

        @Override // android.support.v4.net.ConnectivityManagerCompat.ConnectivityManagerCompatImpl
        public boolean isActiveNetworkMetered(ConnectivityManager cm) {
            return ConnectivityManagerCompatHoneycombMR2.isActiveNetworkMetered(cm);
        }
    }

    /* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/net/ConnectivityManagerCompat$JellyBeanConnectivityManagerCompatImpl.class */
    static class JellyBeanConnectivityManagerCompatImpl implements ConnectivityManagerCompatImpl {
        JellyBeanConnectivityManagerCompatImpl() {
        }

        @Override // android.support.v4.net.ConnectivityManagerCompat.ConnectivityManagerCompatImpl
        public boolean isActiveNetworkMetered(ConnectivityManager cm) {
            return ConnectivityManagerCompatJellyBean.isActiveNetworkMetered(cm);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            IMPL = new JellyBeanConnectivityManagerCompatImpl();
            return;
        }
        if (Build.VERSION.SDK_INT >= 13) {
            IMPL = new HoneycombMR2ConnectivityManagerCompatImpl();
        } else if (Build.VERSION.SDK_INT >= 8) {
            IMPL = new GingerbreadConnectivityManagerCompatImpl();
        } else {
            IMPL = new BaseConnectivityManagerCompatImpl();
        }
    }

    public static boolean isActiveNetworkMetered(ConnectivityManager cm) {
        return IMPL.isActiveNetworkMetered(cm);
    }

    public static NetworkInfo getNetworkInfoFromBroadcast(ConnectivityManager cm, Intent intent) {
        NetworkInfo info = (NetworkInfo) intent.getParcelableExtra("networkInfo");
        if (info != null) {
            return cm.getNetworkInfo(info.getType());
        }
        return null;
    }

    private ConnectivityManagerCompat() {
    }
}
