package android.support.v4.view;

import android.view.LayoutInflater;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/view/LayoutInflaterCompatLollipop.class */
class LayoutInflaterCompatLollipop {
    LayoutInflaterCompatLollipop() {
    }

    static void setFactory(LayoutInflater inflater, LayoutInflaterFactory factory) {
        inflater.setFactory2(factory != null ? new LayoutInflaterCompatHC.FactoryWrapperHC(factory) : null);
    }
}
