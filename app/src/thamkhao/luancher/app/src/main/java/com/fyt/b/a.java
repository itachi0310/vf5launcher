package com.fyt.b;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.view.LayoutInflater;
import com.android.launcher6.Launcher;
import java.lang.reflect.Field;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class a implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap f470a = new HashMap();

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(activity);
        try {
            Field declaredField = LayoutInflater.class.getDeclaredField("mFactorySet");
            declaredField.setAccessible(true);
            declaredField.setBoolean(layoutInflaterFrom, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        c cVar = new c();
        layoutInflaterFrom.setFactory2(cVar);
        g.a().addObserver(cVar);
        if (activity instanceof Launcher) {
            g.a().addObserver((Launcher) activity);
        }
        this.f470a.put(activity, cVar);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        g.a().deleteObserver((c) this.f470a.remove(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }
}
