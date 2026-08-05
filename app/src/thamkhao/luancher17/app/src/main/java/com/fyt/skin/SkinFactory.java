package com.fyt.skin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

/* JADX INFO: loaded from: classes.dex */
public class SkinFactory implements LayoutInflater.Factory2, Observer {
    public final String[] a = {"android.widget.", "android.view.", "android.webkit."};
    SkinAttribute mSkinAttribute = new SkinAttribute();
    private static final HashMap<String, Constructor<? extends View>> sConstructorMap = new HashMap<>();
    static final Class<?>[] mConstructorSignature = {Context.class, AttributeSet.class};

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        name.contains("PagedViewIcon");
        View view = createViewFormTag(name, context, attrs);
        if (view == null) {
            view = createView(name, context, attrs);
        }
        if (view != null) {
            this.mSkinAttribute.loadView(view, attrs);
        }
        return view;
    }

    public SkinAttribute getSkinAttribute() {
        return this.mSkinAttribute;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object o) {
        this.mSkinAttribute.applySkin();
    }

    private View createViewFormTag(String name, Context context, AttributeSet attrs) {
        if (-1 != name.indexOf(46)) {
            return null;
        }
        View view = null;
        for (int i = 0; i < this.a.length; i++) {
            view = createView(String.valueOf(this.a[i]) + name, context, attrs);
            if (view != null) {
                return view;
            }
        }
        return view;
    }

    private View createView(String name, Context context, AttributeSet attrs) {
        Constructor<? extends View> constructor = findConstructor(context, name);
        try {
            return constructor.newInstance(context, attrs);
        } catch (Exception e) {
            return null;
        }
    }

    private Constructor<? extends View> findConstructor(Context context, String name) {
        Constructor<? extends View> constructor = sConstructorMap.get(name);
        if (constructor == null) {
            try {
                constructor = context.getClassLoader().loadClass(name).asSubclass(View.class).getConstructor(mConstructorSignature);
                sConstructorMap.put(name, constructor);
                return constructor;
            } catch (Exception e) {
                e.printStackTrace();
                return constructor;
            }
        }
        return constructor;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String s, Context context, AttributeSet attributeSet) {
        return null;
    }
}
