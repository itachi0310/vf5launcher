package com.android.launcher6;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import java.text.Collator;
import java.util.Comparator;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class kh implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Collator f353a = Collator.getInstance();
    private PackageManager b;
    private HashMap c;

    kh(PackageManager packageManager, HashMap map) {
        this.b = packageManager;
        this.c = map;
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compare(ResolveInfo resolveInfo, ResolveInfo resolveInfo2) {
        CharSequence charSequence;
        Object objTrim;
        ComponentName componentNameA = iv.a(resolveInfo);
        ComponentName componentNameA2 = iv.a(resolveInfo2);
        if (this.c.containsKey(componentNameA)) {
            charSequence = (CharSequence) this.c.get(componentNameA);
        } else {
            String strTrim = resolveInfo.loadLabel(this.b).toString().trim();
            this.c.put(componentNameA, strTrim);
            charSequence = strTrim;
        }
        if (this.c.containsKey(componentNameA2)) {
            objTrim = (CharSequence) this.c.get(componentNameA2);
        } else {
            objTrim = resolveInfo2.loadLabel(this.b).toString().trim();
            this.c.put(componentNameA2, objTrim);
        }
        return this.f353a.compare(charSequence, objTrim);
    }
}
