package com.android.launcher6;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class dv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bitmap f189a;
    private final Context b;
    private final PackageManager c;
    private final HashMap d = new HashMap(50);
    private int e;

    public dv(Context context) {
        this.b = context;
        this.c = context.getPackageManager();
        this.e = 320;
        this.f189a = c();
    }

    private Bitmap a(String str, dw dwVar, ResolveInfo resolveInfo) {
        int iA = com.syu.g.d.a(resolveInfo.activityInfo);
        return iA != 0 ? my.c(com.fyt.b.g.a(iA)) : my.d(new BitmapDrawable(dwVar.f190a));
    }

    private dw b(ComponentName componentName, ResolveInfo resolveInfo, HashMap map) {
        dw dwVar = (dw) this.d.get(componentName);
        if (dwVar != null) {
            return dwVar;
        }
        dw dwVar2 = new dw(null);
        this.d.put(componentName, dwVar2);
        ComponentName componentNameA = iv.a(resolveInfo);
        if (map == null || !map.containsKey(componentNameA)) {
            dwVar2.b = resolveInfo.loadLabel(this.c).toString();
            if (map != null) {
                map.put(componentNameA, dwVar2.b);
            }
        } else {
            dwVar2.b = ((CharSequence) map.get(componentNameA)).toString();
        }
        if (dwVar2.b == null) {
            dwVar2.b = resolveInfo.activityInfo.name;
        }
        dwVar2.f190a = my.a(a(resolveInfo), this.b);
        return dwVar2;
    }

    private Bitmap c() {
        Drawable drawableA = a();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(Math.max(drawableA.getIntrinsicWidth(), 1), Math.max(drawableA.getIntrinsicHeight(), 1), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawableA.setBounds(0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight());
        drawableA.draw(canvas);
        canvas.setBitmap(null);
        return bitmapCreateBitmap;
    }

    public Bitmap a(ComponentName componentName, ResolveInfo resolveInfo, HashMap map) {
        Bitmap bitmapA;
        synchronized (this.d) {
            try {
                if (resolveInfo == null || componentName == null) {
                    bitmapA = null;
                } else {
                    bitmapA = a(componentName.getPackageName(), b(componentName, resolveInfo, map), resolveInfo);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bitmapA;
    }

    public Bitmap a(Intent intent) {
        Bitmap bitmapA;
        synchronized (this.d) {
            ResolveInfo resolveInfoB = b(intent);
            ComponentName component = intent.getComponent();
            if (resolveInfoB == null || component == null) {
                bitmapA = this.f189a;
            } else {
                bitmapA = a(component.getPackageName(), b(component, resolveInfoB, null), resolveInfoB);
            }
        }
        return bitmapA;
    }

    public Drawable a() {
        return a(Resources.getSystem(), android.R.mipmap.sym_def_app_icon);
    }

    public Drawable a(ActivityInfo activityInfo) {
        Resources resourcesForApplication;
        int iconResource;
        int iA = com.syu.g.d.a(activityInfo);
        if (iA > 0) {
            return com.fyt.b.g.a(iA);
        }
        try {
            resourcesForApplication = this.c.getResourcesForApplication(activityInfo.applicationInfo);
        } catch (PackageManager.NameNotFoundException e) {
            resourcesForApplication = null;
        }
        return (resourcesForApplication == null || (iconResource = activityInfo.getIconResource()) == 0) ? a() : a(resourcesForApplication, iconResource);
    }

    public Drawable a(ResolveInfo resolveInfo) {
        return a(resolveInfo.activityInfo);
    }

    public Drawable a(Resources resources, int i) {
        Drawable drawableForDensity;
        try {
            drawableForDensity = resources.getDrawableForDensity(i, this.e);
        } catch (Resources.NotFoundException e) {
            drawableForDensity = null;
        }
        return drawableForDensity != null ? drawableForDensity : a();
    }

    public Drawable a(String str, int i) {
        Resources resourcesForApplication;
        try {
            resourcesForApplication = this.c.getResourcesForApplication(str);
        } catch (PackageManager.NameNotFoundException e) {
            resourcesForApplication = null;
        }
        return (resourcesForApplication == null || i == 0) ? a() : a(resourcesForApplication, i);
    }

    public void a(ComponentName componentName) {
        synchronized (this.d) {
            this.d.remove(componentName);
        }
    }

    public void a(bl blVar) {
        synchronized (this.d) {
            Iterator it = this.d.entrySet().iterator();
            while (it.hasNext()) {
                dw dwVar = (dw) ((Map.Entry) it.next()).getValue();
                if (dwVar.f190a.getWidth() != blVar.u || dwVar.f190a.getHeight() != blVar.u) {
                    it.remove();
                }
            }
        }
    }

    public void a(d dVar, ResolveInfo resolveInfo, HashMap map) {
        synchronized (this.d) {
            dw dwVarB = b(dVar.d, resolveInfo, map);
            dVar.q = dwVarB.b;
            dVar.b = a(dVar.d(), dwVarB, resolveInfo);
        }
    }

    public boolean a(Bitmap bitmap) {
        return this.f189a == bitmap;
    }

    public ResolveInfo b(Intent intent) {
        return this.c.resolveActivity(intent, 0);
    }

    public void b() {
        synchronized (this.d) {
            this.d.clear();
        }
    }
}
