package android.support.v4.app;

import android.content.Context;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/app/NoSaveStateFrameLayout.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class NoSaveStateFrameLayout extends FrameLayout {
    static ViewGroup wrap(View child) {
        NoSaveStateFrameLayout wrapper = new NoSaveStateFrameLayout(child.getContext());
        ViewGroup.LayoutParams childParams = child.getLayoutParams();
        if (childParams != null) {
            wrapper.setLayoutParams(childParams);
        }
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(-1, -1);
        child.setLayoutParams(lp);
        wrapper.addView(child);
        return wrapper;
    }

    public NoSaveStateFrameLayout(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> container) {
        dispatchFreezeSelfOnly(container);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        dispatchThawSelfOnly(container);
    }
}
