package com.android.launcher6;

import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class dj implements ViewGroup.OnHierarchyChangeListener {
    boolean b;
    private HashMap c = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f178a = false;

    private boolean a(View view, Class cls) {
        return view != null && (view.getClass().equals(cls) || ((view.getParent() instanceof ViewGroup) && a((ViewGroup) view.getParent(), cls)));
    }

    private void b(View view) {
        this.c.put(view, Integer.valueOf(view.getImportantForAccessibility()));
        view.setImportantForAccessibility(2);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            viewGroup.setOnHierarchyChangeListener(this);
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (d(childAt)) {
                    b(childAt);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void c(View view) {
        view.setImportantForAccessibility(((Integer) this.c.get(view)).intValue());
        this.c.remove(view);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup instanceof ViewGroup.OnHierarchyChangeListener) {
                viewGroup.setOnHierarchyChangeListener((ViewGroup.OnHierarchyChangeListener) viewGroup);
            } else {
                viewGroup.setOnHierarchyChangeListener(null);
            }
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (d(childAt)) {
                    c(childAt);
                }
            }
        }
    }

    private boolean d(View view) {
        return !a(view, Cling.class) && (!this.b || a(view, AppsCustomizeTabHost.class));
    }

    public void a(View view) {
        if (this.f178a) {
            c(view);
        }
        this.f178a = false;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
        if (this.f178a && d(view2)) {
            b(view2);
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        if (this.f178a && d(view2)) {
            c(view2);
        }
    }
}
