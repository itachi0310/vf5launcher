package com.android.launcher6;

import android.appwidget.AppWidgetProviderInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import java.text.Collator;
import java.util.Comparator;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class ki implements Comparator {
    private PackageManager b;
    private HashMap c = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Collator f354a = Collator.getInstance();

    ki(PackageManager packageManager) {
        this.b = packageManager;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        String str;
        String strTrim;
        if (this.c.containsKey(obj)) {
            str = (String) this.c.get(obj);
        } else {
            String strTrim2 = obj instanceof AppWidgetProviderInfo ? ((AppWidgetProviderInfo) obj).label : ((ResolveInfo) obj).loadLabel(this.b).toString().trim();
            this.c.put(obj, strTrim2);
            str = strTrim2;
        }
        if (this.c.containsKey(obj2)) {
            strTrim = (String) this.c.get(obj2);
        } else {
            strTrim = obj2 instanceof AppWidgetProviderInfo ? ((AppWidgetProviderInfo) obj2).label : ((ResolveInfo) obj2).loadLabel(this.b).toString().trim();
            this.c.put(obj2, strTrim);
        }
        return this.f354a.compare(str, strTrim);
    }
}
