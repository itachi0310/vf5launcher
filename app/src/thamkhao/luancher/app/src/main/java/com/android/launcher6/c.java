package com.android.launcher6;

import android.content.ComponentName;
import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    public static c a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (c) Class.forName(str).newInstance();
        } catch (ClassCastException e) {
            Log.e("AppFilter", "Bad AppFilter class", e);
            return null;
        } catch (ClassNotFoundException e2) {
            Log.e("AppFilter", "Bad AppFilter class", e2);
            return null;
        } catch (IllegalAccessException e3) {
            Log.e("AppFilter", "Bad AppFilter class", e3);
            return null;
        } catch (InstantiationException e4) {
            Log.e("AppFilter", "Bad AppFilter class", e4);
            return null;
        }
    }

    public abstract void a();

    public abstract boolean a(ComponentName componentName);
}
