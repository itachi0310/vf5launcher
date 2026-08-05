package android.support.v4.app;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/app/FragmentManager.class */
public abstract class FragmentManager {
    public static final int POP_BACK_STACK_INCLUSIVE = 1;

    /* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/app/FragmentManager$BackStackEntry.class */
    public interface BackStackEntry {
        int getId();

        String getName();

        @StringRes
        int getBreadCrumbTitleRes();

        @StringRes
        int getBreadCrumbShortTitleRes();

        CharSequence getBreadCrumbTitle();

        CharSequence getBreadCrumbShortTitle();
    }

    /* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/app/FragmentManager$OnBackStackChangedListener.class */
    public interface OnBackStackChangedListener {
        void onBackStackChanged();
    }

    public abstract FragmentTransaction beginTransaction();

    public abstract boolean executePendingTransactions();

    public abstract Fragment findFragmentById(@IdRes int i);

    public abstract Fragment findFragmentByTag(String str);

    public abstract void popBackStack();

    public abstract boolean popBackStackImmediate();

    public abstract void popBackStack(String str, int i);

    public abstract boolean popBackStackImmediate(String str, int i);

    public abstract void popBackStack(int i, int i2);

    public abstract boolean popBackStackImmediate(int i, int i2);

    public abstract int getBackStackEntryCount();

    public abstract BackStackEntry getBackStackEntryAt(int i);

    public abstract void addOnBackStackChangedListener(OnBackStackChangedListener onBackStackChangedListener);

    public abstract void removeOnBackStackChangedListener(OnBackStackChangedListener onBackStackChangedListener);

    public abstract void putFragment(Bundle bundle, String str, Fragment fragment);

    public abstract Fragment getFragment(Bundle bundle, String str);

    public abstract List<Fragment> getFragments();

    public abstract Fragment.SavedState saveFragmentInstanceState(Fragment fragment);

    public abstract boolean isDestroyed();

    public abstract void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    @Deprecated
    public FragmentTransaction openTransaction() {
        return beginTransaction();
    }

    public static void enableDebugLogging(boolean enabled) {
        FragmentManagerImpl.DEBUG = enabled;
    }
}
