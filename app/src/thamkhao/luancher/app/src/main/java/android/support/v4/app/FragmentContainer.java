package android.support.v4.app;

import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.view.View;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/app/FragmentContainer.class */
public abstract class FragmentContainer {
    @Nullable
    public abstract View onFindViewById(@IdRes int i);

    public abstract boolean onHasView();
}
