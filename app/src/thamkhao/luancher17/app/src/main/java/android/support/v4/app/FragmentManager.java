package android.support.v4.app;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/app/FragmentManager.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentManager {
    public static final int POP_BACK_STACK_INCLUSIVE = 1;

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/app/FragmentManager$BackStackEntry.class
  classes.dex
 */
    public interface BackStackEntry {
        CharSequence getBreadCrumbShortTitle();

        @StringRes
        int getBreadCrumbShortTitleRes();

        CharSequence getBreadCrumbTitle();

        @StringRes
        int getBreadCrumbTitleRes();

        int getId();

        String getName();
    }

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/app/FragmentManager$OnBackStackChangedListener.class
  classes.dex
 */
    public interface OnBackStackChangedListener {
        void onBackStackChanged();
    }

    public abstract void addOnBackStackChangedListener(OnBackStackChangedListener onBackStackChangedListener);

    public abstract FragmentTransaction beginTransaction();

    public abstract void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract boolean executePendingTransactions();

    public abstract Fragment findFragmentById(@IdRes int i);

    public abstract Fragment findFragmentByTag(String str);

    public abstract BackStackEntry getBackStackEntryAt(int i);

    public abstract int getBackStackEntryCount();

    public abstract Fragment getFragment(Bundle bundle, String str);

    public abstract List<Fragment> getFragments();

    public abstract boolean isDestroyed();

    public abstract void popBackStack();

    public abstract void popBackStack(int i, int i2);

    public abstract void popBackStack(String str, int i);

    public abstract boolean popBackStackImmediate();

    public abstract boolean popBackStackImmediate(int i, int i2);

    public abstract boolean popBackStackImmediate(String str, int i);

    public abstract void putFragment(Bundle bundle, String str, Fragment fragment);

    public abstract void removeOnBackStackChangedListener(OnBackStackChangedListener onBackStackChangedListener);

    public abstract Fragment.SavedState saveFragmentInstanceState(Fragment fragment);

    @Deprecated
    public FragmentTransaction openTransaction() {
        return beginTransaction();
    }

    public static void enableDebugLogging(boolean enabled) {
        FragmentManagerImpl.DEBUG = enabled;
    }
}
