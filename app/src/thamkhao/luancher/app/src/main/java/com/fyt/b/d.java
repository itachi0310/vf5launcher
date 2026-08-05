package com.fyt.b;

import android.app.Application;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Observable;
import java.util.Observer;

/* JADX INFO: loaded from: classes.dex */
public class d extends Observable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Application f477a;
    private static f b;
    private String c;
    private Resources d;
    private c e;

    private d() {
    }

    /* synthetic */ d(d dVar) {
        this();
    }

    public static Application a() {
        return f477a;
    }

    public static void a(Application application) {
        f477a = application;
        application.registerActivityLifecycleCallbacks(new a());
        com.fyt.b.a.a.a(application);
        b = new f(application);
    }

    static d f() {
        return e.f478a;
    }

    Drawable a(int i) {
        return b.d(i);
    }

    boolean a(String str) {
        File file = new File(str);
        if (TextUtils.isEmpty(str) || !file.exists()) {
            return false;
        }
        try {
            AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
            Method method = assetManager.getClass().getMethod("addAssetPath", String.class);
            method.setAccessible(true);
            method.invoke(assetManager, str);
            Resources resources = f477a.getResources();
            this.d = new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            this.c = f477a.getPackageManager().getPackageArchiveInfo(str, 1).packageName;
            b.a(this.d, this.c);
            setChanged();
            notifyObservers();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // java.util.Observable
    public synchronized void addObserver(Observer observer) {
        super.addObserver(observer);
        if (observer instanceof c) {
            this.e = (c) observer;
        }
    }

    void b() {
        com.fyt.b.a.a.a().a((String) null);
        b.a();
        this.d = f477a.getResources();
        this.c = f477a.getPackageName();
        setChanged();
        notifyObservers();
    }

    Resources c() {
        return this.d;
    }

    f d() {
        return b;
    }

    b e() {
        return this.e.a();
    }
}
