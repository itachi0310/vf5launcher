package com.fyt.b;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

/* JADX INFO: loaded from: classes.dex */
public class c implements LayoutInflater.Factory2, Observer {
    private static final HashMap d = new HashMap();
    static final Class[] b = {Context.class, AttributeSet.class};
    public final String[] c = {"android.widget.", "android.view.", "android.webkit."};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    b f474a = new b();

    private View a(String str, Context context, AttributeSet attributeSet) {
        View viewB = null;
        if (-1 == str.indexOf(46)) {
            for (int i = 0; i < this.c.length && (viewB = b(String.valueOf(this.c[i]) + str, context, attributeSet)) == null; i++) {
            }
        }
        return viewB;
    }

    private Constructor a(Context context, String str) {
        Constructor constructor = (Constructor) d.get(str);
        if (constructor != null) {
            return constructor;
        }
        try {
            constructor = context.getClassLoader().loadClass(str).asSubclass(View.class).getConstructor(b);
            d.put(str, constructor);
            return constructor;
        } catch (Exception e) {
            e.printStackTrace();
            return constructor;
        }
    }

    private View b(String str, Context context, AttributeSet attributeSet) {
        try {
            return (View) a(context, str).newInstance(context, attributeSet);
        } catch (Exception e) {
            return null;
        }
    }

    public b a() {
        return this.f474a;
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View viewA = a(str, context, attributeSet);
        if (viewA == null) {
            viewA = b(str, context, attributeSet);
        }
        if (viewA != null) {
            this.f474a.a(viewA, attributeSet);
        }
        return viewA;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return null;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        this.f474a.b();
    }
}
