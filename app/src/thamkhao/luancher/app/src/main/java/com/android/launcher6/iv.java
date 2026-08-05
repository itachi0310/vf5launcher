package com.android.launcher6;

import android.appwidget.AppWidgetManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.support.v4.content.IntentCompat;
import android.util.Log;
import android.util.Pair;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public class iv extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final ArrayList f316a;
    static final Object c;
    static final HashMap d;
    static final ArrayList e;
    static final ArrayList f;
    static final HashMap g;
    static final HashMap h;
    static final ArrayList i;
    public static final Comparator m;
    private static final HandlerThread u = new HandlerThread("launcher-loader");
    private static final Handler v;
    private Bitmap A;
    private c B;
    b b;
    protected int j;
    boolean k;
    private final boolean n;
    private final ip o;
    private jp r;
    private boolean s;
    private volatile boolean t;
    private boolean w;
    private boolean x;
    private WeakReference y;
    private dv z;
    private final Object p = new Object();
    private ba q = new ba();
    Runnable l = new iw(this);

    static {
        u.start();
        v = new Handler(u.getLooper());
        f316a = new ArrayList();
        c = new Object();
        d = new HashMap();
        e = new ArrayList();
        f = new ArrayList();
        g = new HashMap();
        h = new HashMap();
        i = new ArrayList();
        m = new je();
    }

    iv(ip ipVar, dv dvVar, c cVar) {
        this.k = true;
        Context contextB = ipVar.b();
        this.k = contextB.getSharedPreferences(ip.h(), 0).getBoolean("first_use", true);
        this.n = Environment.isExternalStorageRemovable();
        this.o = ipVar;
        this.B = cVar;
        this.b = new b(dvVar, cVar);
        this.z = dvVar;
        this.A = my.a(this.z.a(), contextB);
        this.j = contextB.getResources().getConfiguration().mcc;
        if (cVar != null) {
            cVar.a();
            if (cVar instanceof com.syu.a.d) {
                ((com.syu.a.d) cVar).a(new jf(this));
            }
        }
    }

    static int a(long j, long j2, int i2, int i3, int i4, int i5) {
        return ((((int) j) & 255) << 24) | ((((int) j2) & 255) << 16) | ((i2 & 255) << 8) | (i3 & 255);
    }

    static ComponentName a(ResolveInfo resolveInfo) {
        return resolveInfo.activityInfo != null ? new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name) : new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
    }

    static Pair a(Context context, String str, Intent intent, int i2, ArrayList arrayList) {
        ip ipVarA = ip.a();
        iv ivVarE = ipVarA.e();
        synchronized (ipVarA) {
            if (u.getThreadId() != Process.myTid()) {
                ivVarE.d();
            }
            ArrayList arrayListA = a(context);
            int iMin = Math.min(i2, arrayList.size());
            int size = arrayList.size();
            for (int i3 = iMin; i3 < size; i3++) {
                int[] iArr = new int[2];
                if (a(arrayListA, iArr, ((Long) arrayList.get(i3)).longValue())) {
                    return new Pair((Long) arrayList.get(i3), iArr);
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public mp a(Cursor cursor, Context context, int i2, int i3, int i4, int i5, int i6) {
        Bitmap bitmapA = null;
        mp mpVar = new mp();
        mpVar.g = 1;
        mpVar.q = cursor.getString(i6);
        switch (cursor.getInt(i2)) {
            case 0:
                String string = cursor.getString(i3);
                String string2 = cursor.getString(i4);
                PackageManager packageManager = context.getPackageManager();
                mpVar.b = false;
                try {
                    Resources resourcesForApplication = packageManager.getResourcesForApplication(string);
                    if (resourcesForApplication != null) {
                        bitmapA = my.a(this.z.a(resourcesForApplication, resourcesForApplication.getIdentifier(string2, null, null)), context);
                    }
                    break;
                } catch (Exception e2) {
                }
                if (bitmapA == null) {
                    bitmapA = a(cursor, i5, context);
                }
                if (bitmapA == null) {
                    bitmapA = a();
                    mpVar.c = true;
                }
                break;
            case 1:
                bitmapA = a(cursor, i5, context);
                if (bitmapA != null) {
                    mpVar.b = true;
                } else {
                    bitmapA = a();
                    mpVar.b = false;
                    mpVar.c = true;
                }
                break;
            default:
                bitmapA = a();
                mpVar.c = true;
                mpVar.b = false;
                break;
        }
        mpVar.b(bitmapA);
        return mpVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList a(ComponentName componentName) {
        return a(d.values(), new jc(this, componentName));
    }

    static ArrayList a(Context context) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = context.getContentResolver().query(kq.f358a, new String[]{"itemType", "container", "screen", "cellX", "cellY", "spanX", "spanY"}, null, null, null);
        int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("itemType");
        int columnIndexOrThrow2 = cursorQuery.getColumnIndexOrThrow("container");
        int columnIndexOrThrow3 = cursorQuery.getColumnIndexOrThrow("screen");
        int columnIndexOrThrow4 = cursorQuery.getColumnIndexOrThrow("cellX");
        int columnIndexOrThrow5 = cursorQuery.getColumnIndexOrThrow("cellY");
        int columnIndexOrThrow6 = cursorQuery.getColumnIndexOrThrow("spanX");
        int columnIndexOrThrow7 = cursorQuery.getColumnIndexOrThrow("spanY");
        while (cursorQuery.moveToNext()) {
            try {
                try {
                    ec ecVar = new ec();
                    ecVar.j = cursorQuery.getInt(columnIndexOrThrow4);
                    ecVar.k = cursorQuery.getInt(columnIndexOrThrow5);
                    ecVar.l = Math.max(1, cursorQuery.getInt(columnIndexOrThrow6));
                    ecVar.m = Math.max(1, cursorQuery.getInt(columnIndexOrThrow7));
                    ecVar.h = cursorQuery.getInt(columnIndexOrThrow2);
                    ecVar.g = cursorQuery.getInt(columnIndexOrThrow);
                    ecVar.i = cursorQuery.getInt(columnIndexOrThrow3);
                    arrayList.add(ecVar);
                } catch (Exception e2) {
                    arrayList.clear();
                    cursorQuery.close();
                }
            } catch (Throwable th) {
                cursorQuery.close();
                throw th;
            }
        }
        cursorQuery.close();
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList a(String str) {
        return a(d.values(), new jb(this, str));
    }

    static ArrayList a(Collection collection, jo joVar) {
        it itVar;
        ComponentName componentName;
        HashSet hashSet = new HashSet();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            ec ecVar = (ec) it.next();
            if (ecVar instanceof mp) {
                mp mpVar = (mp) ecVar;
                ComponentName component = mpVar.f396a.getComponent();
                if (component != null && joVar.a(null, mpVar, component)) {
                    hashSet.add(mpVar);
                }
            } else if (ecVar instanceof dg) {
                dg dgVar = (dg) ecVar;
                for (mp mpVar2 : dgVar.b) {
                    ComponentName component2 = mpVar2.f396a.getComponent();
                    if (component2 != null && joVar.a(dgVar, mpVar2, component2)) {
                        hashSet.add(mpVar2);
                    }
                }
            } else if ((ecVar instanceof it) && (componentName = (itVar = (it) ecVar).b) != null && joVar.a(null, itVar, componentName)) {
                hashSet.add(itVar);
            }
        }
        return new ArrayList(hashSet);
    }

    static void a(long j, ec ecVar, StackTraceElement[] stackTraceElementArr) {
        ec ecVar2 = (ec) d.get(Long.valueOf(j));
        if (ecVar2 == null || ecVar == ecVar2) {
            return;
        }
        if ((ecVar2 instanceof mp) && (ecVar instanceof mp)) {
            mp mpVar = (mp) ecVar2;
            mp mpVar2 = (mp) ecVar;
            if (mpVar.q.toString().equals(mpVar2.q.toString()) && mpVar.f396a.filterEquals(mpVar2.f396a) && mpVar.f == mpVar2.f && mpVar.g == mpVar2.g && mpVar.h == mpVar2.h && mpVar.i == mpVar2.i && mpVar.j == mpVar2.j && mpVar.k == mpVar2.k && mpVar.l == mpVar2.l && mpVar.m == mpVar2.m) {
                if (mpVar.r == null && mpVar2.r == null) {
                    return;
                }
                if (mpVar.r != null && mpVar2.r != null && mpVar.r[0] == mpVar2.r[0] && mpVar.r[1] == mpVar2.r[1]) {
                    return;
                }
            }
        }
        RuntimeException runtimeException = new RuntimeException("item: " + (ecVar != null ? ecVar.toString() : "null") + "modelItem: " + (ecVar2 != null ? ecVar2.toString() : "null") + "Error: ItemInfo passed to checkItemInfo doesn't match original");
        if (stackTraceElementArr != null) {
            runtimeException.setStackTrace(stackTraceElementArr);
        }
    }

    static void a(Context context, ContentValues contentValues, ec ecVar, String str) {
        long j = ecVar.f;
        b(new jk(context.getContentResolver(), kq.a(j, false), contentValues, ecVar, j, new Throwable().getStackTrace()));
    }

    static void a(Context context, dg dgVar) {
        b(new ja(context.getContentResolver(), dgVar));
    }

    static void a(Context context, ec ecVar) {
        ContentValues contentValues = new ContentValues();
        ecVar.a(contentValues);
        ecVar.a(contentValues, ecVar.j, ecVar.k);
        a(context, contentValues, ecVar, "updateItemInDatabase");
    }

    static void a(Context context, ec ecVar, long j, long j2, int i2, int i3) {
        if (ecVar.h == -1) {
            a(context, ecVar, j, j2, i2, i3, false);
        } else {
            b(context, ecVar, j, j2, i2, i3);
        }
    }

    static void a(Context context, ec ecVar, long j, long j2, int i2, int i3, int i4, int i5) {
        ecVar.h = j;
        ecVar.j = i2;
        ecVar.k = i3;
        ecVar.l = i4;
        ecVar.m = i5;
        if (!(context instanceof Launcher) || j2 >= 0 || j != -101) {
            ecVar.i = j2;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("container", Long.valueOf(ecVar.h));
        contentValues.put("cellX", Integer.valueOf(ecVar.j));
        contentValues.put("cellY", Integer.valueOf(ecVar.k));
        contentValues.put("spanX", Integer.valueOf(ecVar.l));
        contentValues.put("spanY", Integer.valueOf(ecVar.m));
        contentValues.put("screen", Long.valueOf(ecVar.i));
        a(context, contentValues, ecVar, "modifyItemInDatabase");
    }

    static void a(Context context, ec ecVar, long j, long j2, int i2, int i3, boolean z) {
        ecVar.h = j;
        ecVar.j = i2;
        ecVar.k = i3;
        if (!(context instanceof Launcher) || j2 >= 0 || j != -101) {
            ecVar.i = j2;
        }
        ContentValues contentValues = new ContentValues();
        ContentResolver contentResolver = context.getContentResolver();
        ecVar.a(contentValues);
        ecVar.f = ip.g().a();
        contentValues.put("_id", Long.valueOf(ecVar.f));
        ecVar.a(contentValues, ecVar.j, ecVar.k);
        b(new ix(contentResolver, z, contentValues, ecVar));
    }

    static void a(Context context, ArrayList arrayList, long j, int i2) {
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            ec ecVar = (ec) arrayList.get(i3);
            ecVar.h = j;
            if (!(context instanceof Launcher) || i2 >= 0 || j != -101) {
                ecVar.i = i2;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("container", Long.valueOf(ecVar.h));
            contentValues.put("cellX", Integer.valueOf(ecVar.j));
            contentValues.put("cellY", Integer.valueOf(ecVar.k));
            contentValues.put("screen", Long.valueOf(ecVar.i));
            arrayList2.add(contentValues);
        }
        a(context, arrayList2, arrayList, "moveItemInDatabase");
    }

    static void a(Context context, ArrayList arrayList, ArrayList arrayList2, String str) {
        b(new jl(arrayList2, arrayList, new Throwable().getStackTrace(), context.getContentResolver()));
    }

    static void a(ec ecVar) {
        b(new jj(ecVar.f, ecVar, new Throwable().getStackTrace()));
    }

    static void a(ec ecVar, long j, StackTraceElement[] stackTraceElementArr) {
        synchronized (c) {
            a(j, ecVar, stackTraceElementArr);
            if (ecVar.h != -100 && ecVar.h != -101 && !g.containsKey(Long.valueOf(ecVar.h))) {
                Log.e("Launcher.Model", "item: " + ecVar + " container being set to: " + ecVar.h + ", not in the list of folders");
            }
            ec ecVar2 = (ec) d.get(Long.valueOf(j));
            if (ecVar2.h == -100 || ecVar2.h == -101) {
                switch (ecVar2.g) {
                    case 0:
                    case 1:
                    case 2:
                        if (!e.contains(ecVar2)) {
                            e.add(ecVar2);
                        }
                        break;
                }
            } else {
                e.remove(ecVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Runnable runnable) {
        a(runnable, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Runnable runnable, int i2) {
        if (u.getThreadId() == Process.myTid()) {
            this.q.a(runnable);
        } else {
            runnable.run();
        }
    }

    static boolean a(Context context, String str, Intent intent) {
        Cursor cursorQuery = context.getContentResolver().query(kq.f358a, new String[]{"title", "intent"}, "title=? and intent=?", new String[]{str, intent.toUri(0)}, null);
        try {
            return cursorQuery.moveToFirst();
        } finally {
            cursorQuery.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(PackageManager packageManager, ComponentName componentName) {
        if (componentName == null) {
            return false;
        }
        try {
            return packageManager.getPackageInfo(componentName.getPackageName(), 0).applicationInfo.enabled && packageManager.getActivityInfo(componentName, 0) != null;
        } catch (PackageManager.NameNotFoundException e2) {
            return false;
        }
    }

    static boolean a(ArrayList arrayList, int[] iArr, long j) {
        bl blVarA = ip.a().i().a();
        int i2 = (int) blVarA.e;
        int i3 = (int) blVarA.d;
        boolean[][] zArr = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, i2, i3);
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= arrayList.size()) {
                return CellLayout.a(iArr, 1, 1, i2, i3, zArr);
            }
            ec ecVar = (ec) arrayList.get(i5);
            if (ecVar.h == -100 && ecVar.i == j) {
                int i6 = ecVar.j;
                int i7 = ecVar.k;
                int i8 = ecVar.l;
                int i9 = ecVar.m;
                for (int i10 = i6; i10 >= 0 && i10 < i6 + i8 && i10 < i2; i10++) {
                    for (int i11 = i7; i11 >= 0 && i11 < i7 + i9 && i11 < i3; i11++) {
                        zArr[i10][i11] = true;
                    }
                }
            }
            i4 = i5 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static dg b(HashMap map, long j) {
        dg dgVar = (dg) map.get(Long.valueOf(j));
        if (dgVar != null) {
            return dgVar;
        }
        dg dgVar2 = new dg();
        map.put(Long.valueOf(j), dgVar2);
        return dgVar2;
    }

    public static ArrayList b(Context context) {
        PackageManager packageManager = context.getPackageManager();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(AppWidgetManager.getInstance(context).getInstalledProviders());
        arrayList.addAll(packageManager.queryIntentActivities(new Intent("android.intent.action.CREATE_SHORTCUT"), 0));
        Collections.sort(arrayList, new ki(packageManager));
        return arrayList;
    }

    static void b(Context context, ec ecVar) {
        com.syu.d.a.b("deleteItemFromDatabase");
        b(new iy(context.getContentResolver(), kq.a(ecVar.f, false), ecVar));
    }

    static void b(Context context, ec ecVar, long j, long j2, int i2, int i3) {
        ecVar.h = j;
        ecVar.j = i2;
        ecVar.k = i3;
        if (!(context instanceof Launcher) || j2 >= 0 || j != -101) {
            ecVar.i = j2;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("container", Long.valueOf(ecVar.h));
        contentValues.put("cellX", Integer.valueOf(ecVar.j));
        contentValues.put("cellY", Integer.valueOf(ecVar.k));
        contentValues.put("screen", Long.valueOf(ecVar.i));
        a(context, contentValues, ecVar, "moveItemInDatabase");
    }

    private static void b(Runnable runnable) {
        if (u.getThreadId() == Process.myTid()) {
            runnable.run();
        } else {
            v.post(runnable);
        }
    }

    public static boolean b(ec ecVar) {
        if (ecVar instanceof mp) {
            mp mpVar = (mp) ecVar;
            Intent intent = mpVar.f396a;
            ComponentName component = intent.getComponent();
            if (mpVar.g == 0 && "android.intent.action.MAIN".equals(intent.getAction()) && component != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TreeMap d(Context context) {
        Cursor cursorQuery = context.getContentResolver().query(kr.f359a, null, null, null, null);
        TreeMap treeMap = new TreeMap();
        try {
            int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("_id");
            int columnIndexOrThrow2 = cursorQuery.getColumnIndexOrThrow("screenRank");
            while (cursorQuery.moveToNext()) {
                try {
                    treeMap.put(Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow2)), Long.valueOf(cursorQuery.getLong(columnIndexOrThrow)));
                } catch (Exception e2) {
                    Launcher.a("Launcher.Model", "Desktop items loading interrupted - invalid screens: " + e2, true);
                }
            }
            cursorQuery.close();
            return treeMap;
        } catch (Throwable th) {
            cursorQuery.close();
            throw th;
        }
    }

    public static final Comparator i() {
        return new jd(Collator.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        a(true, true);
        e();
    }

    private boolean n() {
        boolean z = false;
        jp jpVar = this.r;
        if (jpVar != null) {
            z = jpVar.a();
            jpVar.c();
        }
        return z;
    }

    public Bitmap a() {
        return Bitmap.createBitmap(this.A);
    }

    Bitmap a(Cursor cursor, int i2, Context context) {
        byte[] blob = cursor.getBlob(i2);
        try {
            return my.a(BitmapFactory.decodeByteArray(blob, 0, blob.length), context);
        } catch (Exception e2) {
            return null;
        }
    }

    dg a(Context context, HashMap map, long j) {
        dg dgVarB = null;
        Cursor cursorQuery = context.getContentResolver().query(kq.f358a, null, "_id=? and (itemType=? or itemType=?)", new String[]{String.valueOf(j), String.valueOf(2)}, null);
        try {
            if (cursorQuery.moveToFirst()) {
                int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("itemType");
                int columnIndexOrThrow2 = cursorQuery.getColumnIndexOrThrow("title");
                int columnIndexOrThrow3 = cursorQuery.getColumnIndexOrThrow("container");
                int columnIndexOrThrow4 = cursorQuery.getColumnIndexOrThrow("screen");
                int columnIndexOrThrow5 = cursorQuery.getColumnIndexOrThrow("cellX");
                int columnIndexOrThrow6 = cursorQuery.getColumnIndexOrThrow("cellY");
                switch (cursorQuery.getInt(columnIndexOrThrow)) {
                    case 2:
                        dgVarB = b(map, j);
                        break;
                }
                dgVarB.q = cursorQuery.getString(columnIndexOrThrow2);
                dgVarB.f = j;
                dgVarB.h = cursorQuery.getInt(columnIndexOrThrow3);
                dgVarB.i = cursorQuery.getInt(columnIndexOrThrow4);
                dgVarB.j = cursorQuery.getInt(columnIndexOrThrow5);
                dgVarB.k = cursorQuery.getInt(columnIndexOrThrow6);
            }
            return dgVarB;
        } finally {
            cursorQuery.close();
        }
    }

    mp a(Context context, Intent intent, Bitmap bitmap) {
        Intent.ShortcutIconResource shortcutIconResource;
        boolean z;
        Bitmap bitmapA = null;
        Intent intent2 = (Intent) intent.getParcelableExtra("android.intent.extra.shortcut.INTENT");
        String stringExtra = intent.getStringExtra("android.intent.extra.shortcut.NAME");
        Parcelable parcelableExtra = intent.getParcelableExtra("android.intent.extra.shortcut.ICON");
        if (intent2 == null) {
            Log.e("Launcher.Model", "Can't construct ShorcutInfo with null intent");
            return null;
        }
        if (parcelableExtra == null || !(parcelableExtra instanceof Bitmap)) {
            Parcelable parcelableExtra2 = intent.getParcelableExtra("android.intent.extra.shortcut.ICON_RESOURCE");
            if (parcelableExtra2 == null || !(parcelableExtra2 instanceof Intent.ShortcutIconResource)) {
                shortcutIconResource = null;
                z = false;
            } else {
                try {
                    shortcutIconResource = (Intent.ShortcutIconResource) parcelableExtra2;
                    try {
                        Resources resourcesForApplication = context.getPackageManager().getResourcesForApplication(shortcutIconResource.packageName);
                        bitmapA = my.a(this.z.a(resourcesForApplication, resourcesForApplication.getIdentifier(shortcutIconResource.resourceName, null, null)), context);
                        z = false;
                    } catch (Exception e2) {
                        Log.w("Launcher.Model", "Could not load shortcut icon: " + parcelableExtra2);
                        z = false;
                    }
                } catch (Exception e3) {
                    shortcutIconResource = null;
                }
            }
        } else {
            z = true;
            bitmapA = my.a(new ci((Bitmap) parcelableExtra), context);
            shortcutIconResource = null;
        }
        mp mpVar = new mp();
        if (bitmapA != null) {
            bitmap = bitmapA;
        } else if (bitmap == null) {
            bitmap = a();
            mpVar.c = true;
        }
        mpVar.b(bitmap);
        mpVar.q = stringExtra;
        mpVar.f396a = intent2;
        mpVar.b = z;
        mpVar.d = shortcutIconResource;
        return mpVar;
    }

    public mp a(PackageManager packageManager, Intent intent, Context context) {
        return a(packageManager, intent, context, (Cursor) null, -1, -1, (HashMap) null);
    }

    public mp a(PackageManager packageManager, Intent intent, Context context, Cursor cursor, int i2, int i3, HashMap map) {
        Bitmap bitmapA;
        ComponentName component = intent.getComponent();
        mp mpVar = new mp();
        if (component != null && !a(packageManager, component)) {
            Log.d("Launcher.Model", "Invalid package found in getShortcutInfo: " + component);
            return null;
        }
        try {
            mpVar.a(packageManager.getPackageInfo(component.getPackageName(), 0));
        } catch (PackageManager.NameNotFoundException e2) {
            Log.d("Launcher.Model", "getPackInfo failed for package " + component.getPackageName());
        }
        ComponentName component2 = intent.getComponent();
        Intent intent2 = new Intent(intent.getAction(), (Uri) null);
        intent2.addCategory("android.intent.category.LAUNCHER");
        intent2.setPackage(component2.getPackageName());
        ResolveInfo resolveInfoResolveActivity = null;
        for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent2, 0)) {
            if (new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name).equals(component2)) {
                resolveInfoResolveActivity = resolveInfo;
            }
        }
        if (resolveInfoResolveActivity == null) {
            resolveInfoResolveActivity = packageManager.resolveActivity(intent, 0);
        }
        if (resolveInfoResolveActivity != null) {
            bitmapA = this.z.a(component, resolveInfoResolveActivity, map);
            mpVar.a(com.syu.g.d.a(resolveInfoResolveActivity.activityInfo));
        } else {
            bitmapA = null;
        }
        if (bitmapA == null && cursor != null) {
            bitmapA = a(cursor, i2, context);
        }
        if (bitmapA == null) {
            bitmapA = a();
            mpVar.c = true;
        }
        mpVar.b(bitmapA);
        if (resolveInfoResolveActivity != null) {
            ComponentName componentNameA = a(resolveInfoResolveActivity);
            if (map == null || !map.containsKey(componentNameA)) {
                mpVar.q = resolveInfoResolveActivity.activityInfo.loadLabel(packageManager);
                if (map != null) {
                    map.put(componentNameA, mpVar.q);
                }
            } else {
                mpVar.q = (CharSequence) map.get(componentNameA);
            }
        }
        if (mpVar.q == null && cursor != null) {
            mpVar.q = cursor.getString(i3);
        }
        if (mpVar.q == null) {
            mpVar.q = component.getClassName();
        }
        mpVar.g = 0;
        return mpVar;
    }

    void a(Context context, mp mpVar, byte[] bArr) {
        boolean z = true;
        if (bArr != null) {
            try {
                z = BitmapFactory.decodeByteArray(bArr, 0, bArr.length).sameAs(mpVar.a(this.z)) ? false : true;
            } catch (Exception e2) {
            }
        }
        if (z) {
            Log.d("Launcher.Model", "going to save icon bitmap for info=" + mpVar);
            a(context, mpVar);
        }
    }

    void a(Context context, ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList(arrayList);
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = kr.f359a;
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            if (((Long) it.next()).longValue() < 0) {
                it.remove();
            }
        }
        b(new iz(this, contentResolver, uri, arrayList2));
    }

    public void a(Context context, ArrayList arrayList, jn jnVar, ArrayList arrayList2) {
        com.syu.d.a.b("addAndBindAddedApps");
        if (arrayList.isEmpty() && arrayList2.isEmpty()) {
            return;
        }
        b(new jg(this, context, arrayList, arrayList2, jnVar));
    }

    public void a(Context context, ArrayList arrayList, ArrayList arrayList2) {
        a(context, arrayList, this.y != null ? (jn) this.y.get() : null, arrayList2);
    }

    public void a(jn jnVar) {
        synchronized (this.p) {
            this.y = new WeakReference(jnVar);
        }
    }

    void a(kc kcVar) {
        v.post(kcVar);
    }

    public void a(boolean z, int i2) {
        synchronized (this.p) {
            f316a.clear();
            if (this.y != null && this.y.get() != null) {
                this.r = new jp(this, this.o.b(), z || n());
                if (i2 > -1 && this.x && this.w) {
                    this.r.a(i2);
                } else {
                    u.setPriority(5);
                    v.post(this.r);
                }
            }
        }
    }

    public void a(boolean z, boolean z2) {
        synchronized (this.p) {
            n();
            if (z) {
                this.x = false;
            }
            if (z2) {
                this.w = false;
            }
        }
    }

    boolean a(HashMap map, mp mpVar, Cursor cursor, int i2) {
        if (!this.n || mpVar.b || mpVar.c) {
            return false;
        }
        map.put(mpVar, cursor.getBlob(i2));
        return true;
    }

    public void b() {
        if (u.getThreadId() == Process.myTid()) {
            throw new RuntimeException("Expected unbindLauncherItemInfos() to be called from the main thread");
        }
        f316a.clear();
        this.q.a(1);
        c();
    }

    void c() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        synchronized (c) {
            arrayList.addAll(e);
            arrayList2.addAll(f);
        }
        a(new ji(this, arrayList, arrayList2));
    }

    public void d() {
        this.t = true;
        jm jmVar = new jm(this);
        synchronized (jmVar) {
            try {
                b(jmVar);
                if (this.r != null) {
                    synchronized (this.r) {
                        this.r.notify();
                    }
                }
                boolean z = false;
                while (!z) {
                    try {
                        jmVar.wait();
                        z = true;
                    } catch (InterruptedException e2) {
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void e() {
        jn jnVar;
        if ((this.y == null || (jnVar = (jn) this.y.get()) == null || jnVar.P()) ? false : true) {
            a(false, -1);
        }
    }

    void f() {
        if (f316a.isEmpty()) {
            return;
        }
        Iterator it = f316a.iterator();
        while (it.hasNext()) {
            this.q.a((Runnable) it.next(), 1);
        }
        f316a.clear();
    }

    public void g() {
        synchronized (this.p) {
            if (this.r != null) {
                this.r.c();
            }
        }
    }

    boolean h() {
        synchronized (this.p) {
            if (this.r == null) {
                return false;
            }
            return this.r.b();
        }
    }

    public void j() {
        Log.d("Launcher.Model", "mCallbacks=" + this.y);
        d.a("Launcher.Model", "mAllAppsList.data", b.f123a);
        d.a("Launcher.Model", "mAllAppsList.added", this.b.b);
        d.a("Launcher.Model", "mAllAppsList.removed", this.b.c);
        d.a("Launcher.Model", "mAllAppsList.modified", this.b.d);
        if (this.r != null) {
            this.r.d();
        } else {
            Log.d("Launcher.Model", "mLoaderTask=null");
        }
    }

    /* JADX WARN: Code duplicated, block: B:64:0x0158  */
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        jn jnVar;
        int i2 = 2;
        String action = intent.getAction();
        if ("android.intent.action.PACKAGE_CHANGED".equals(action) || "android.intent.action.PACKAGE_REMOVED".equals(action) || "android.intent.action.PACKAGE_ADDED".equals(action)) {
            String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
            boolean booleanExtra = intent.getBooleanExtra("android.intent.extra.REPLACING", false);
            if (schemeSpecificPart == null || schemeSpecificPart.length() == 0) {
                return;
            }
            if (!"android.intent.action.PACKAGE_CHANGED".equals(action)) {
                if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
                    if (booleanExtra) {
                        i2 = 0;
                    } else {
                        i2 = 3;
                    }
                } else if (!"android.intent.action.PACKAGE_ADDED".equals(action)) {
                    i2 = 0;
                } else if (!booleanExtra) {
                    i2 = 1;
                }
            }
            if (i2 != 0) {
                a(new kc(this, i2, new String[]{schemeSpecificPart}));
                return;
            }
            return;
        }
        if (IntentCompat.ACTION_EXTERNAL_APPLICATIONS_AVAILABLE.equals(action)) {
            a(new kc(this, 1, intent.getStringArrayExtra(IntentCompat.EXTRA_CHANGED_PACKAGE_LIST)));
            e();
            return;
        }
        if (IntentCompat.ACTION_EXTERNAL_APPLICATIONS_UNAVAILABLE.equals(action)) {
            a(new kc(this, 4, intent.getStringArrayExtra(IntentCompat.EXTRA_CHANGED_PACKAGE_LIST)));
            return;
        }
        if ("android.intent.action.LOCALE_CHANGED".equals(action)) {
            Process.killProcess(Process.myPid());
            if (Launcher.G() != null) {
                Launcher.G().a();
            }
            m();
            return;
        }
        if ("android.intent.action.CONFIGURATION_CHANGED".equals(action)) {
            Configuration configuration = context.getResources().getConfiguration();
            if (SystemClock.elapsedRealtime() > (this.k ? 300000 : 0) && this.j != configuration.mcc) {
                Log.d("Launcher.Model", "Reload apps on config change. curr_mcc:" + configuration.mcc + " prevmcc:" + this.j);
                m();
            }
            if (this.k) {
                LauncherApplication.f88a.getSharedPreferences(ip.h(), 0).edit().putBoolean("first_use", false);
                this.k = false;
            }
            this.j = configuration.mcc;
            return;
        }
        if (!"android.search.action.GLOBAL_SEARCH_ACTIVITY_CHANGED".equals(action) && !"android.search.action.SEARCHABLES_CHANGED".equals(action)) {
            if (action.equals("com.syu.launcherdisplayico")) {
                Log.i("hy", "action111111111");
            }
        } else {
            if (this.y == null || (jnVar = (jn) this.y.get()) == null) {
                return;
            }
            jnVar.S();
        }
    }
}
