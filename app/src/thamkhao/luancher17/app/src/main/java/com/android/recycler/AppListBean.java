package com.android.recycler;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes.dex */
public class AppListBean {
    public Bitmap appIcon;
    public String className;
    public Bitmap icon;
    public String name;
    public String packageName;
    public int resid;

    public AppListBean() {
    }

    public AppListBean(String name, Bitmap icon, String packageName, String className) {
        this.name = name;
        this.icon = icon;
        this.packageName = packageName;
        this.className = className;
        this.resid = 0;
    }

    public AppListBean(String name, Bitmap icon, Bitmap appIcon, String packageName, String className, int resid) {
        this.name = name;
        this.icon = icon;
        this.appIcon = appIcon;
        this.packageName = packageName;
        this.className = className;
        this.resid = resid;
    }

    public AppListBean(String name, Bitmap icon) {
        this.name = name;
        this.icon = icon;
    }
}
