package com.android.launcher6;

import android.app.SearchManager;
import android.appwidget.AppWidgetHost;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
class kk extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f355a;
    private final AppWidgetHost b;
    private long c;
    private long d;

    kk(Context context) {
        super(context, "launcher3.db", (SQLiteDatabase.CursorFactory) null, 15);
        this.c = -1L;
        this.d = -1L;
        this.f355a = context;
        this.b = new AppWidgetHost(context, Launcher.m);
        if (this.c == -1) {
            this.c = d(getWritableDatabase());
        }
        if (this.d == -1) {
            this.d = e(getWritableDatabase());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(SQLiteDatabase sQLiteDatabase, int i) throws PackageManager.NameNotFoundException {
        int i2;
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        ContentValues contentValues = new ContentValues();
        PackageManager packageManager = this.f355a.getPackageManager();
        int iA = 0;
        try {
            XmlResourceParser xml = this.f355a.getResources().getXml(i);
            AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
            a(xml, "favorites");
            int depth = xml.getDepth();
            while (true) {
                int next = xml.next();
                if (next == 3 && xml.getDepth() <= depth) {
                    i2 = iA;
                    break;
                }
                if (next == 1) {
                    i2 = iA;
                    break;
                }
                if (next == 2) {
                    boolean zA = false;
                    String name = xml.getName();
                    if ("include".equals(name)) {
                        TypedArray typedArrayObtainStyledAttributes = this.f355a.obtainStyledAttributes(attributeSetAsAttributeSet, mi.Include);
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
                        if (resourceId == 0 || resourceId == i) {
                            Log.w("Launcher.LauncherProvider", String.format("Skipping <include workspace=0x%08x>", Integer.valueOf(resourceId)));
                        } else {
                            iA += a(sQLiteDatabase, resourceId);
                            this.c = -1L;
                        }
                        typedArrayObtainStyledAttributes.recycle();
                    } else {
                        TypedArray typedArrayObtainStyledAttributes2 = this.f355a.obtainStyledAttributes(attributeSetAsAttributeSet, mi.Favorite);
                        long jLongValue = typedArrayObtainStyledAttributes2.hasValue(2) ? Long.valueOf(typedArrayObtainStyledAttributes2.getString(2)).longValue() : -100L;
                        String string = typedArrayObtainStyledAttributes2.getString(3);
                        String string2 = typedArrayObtainStyledAttributes2.getString(4);
                        String string3 = typedArrayObtainStyledAttributes2.getString(5);
                        contentValues.clear();
                        contentValues.put("container", Long.valueOf(jLongValue));
                        contentValues.put("screen", string);
                        contentValues.put("cellX", string2);
                        contentValues.put("cellY", string3);
                        if (!"favorite".equals(name)) {
                            if (!"search".equals(name)) {
                                if (!"clock".equals(name)) {
                                    if (!"appwidget".equals(name)) {
                                        if (!"shortcut".equals(name)) {
                                            if ("folder".equals(name)) {
                                                int resourceId2 = typedArrayObtainStyledAttributes2.getResourceId(9, -1);
                                                contentValues.put("title", resourceId2 != -1 ? this.f355a.getResources().getString(resourceId2) : this.f355a.getResources().getString(R.string.folder_name));
                                                long jA = a(sQLiteDatabase, contentValues);
                                                zA = jA >= 0;
                                                ArrayList arrayList = new ArrayList();
                                                int depth2 = xml.getDepth();
                                                while (true) {
                                                    int next2 = xml.next();
                                                    if (next2 == 3 && xml.getDepth() <= depth2) {
                                                        if (arrayList.size() >= 2 || jA < 0) {
                                                            break;
                                                            break;
                                                        }
                                                        LauncherProvider.b(sQLiteDatabase, jA);
                                                        if (arrayList.size() > 0) {
                                                            LauncherProvider.b(sQLiteDatabase, ((Long) arrayList.get(0)).longValue());
                                                        }
                                                        zA = false;
                                                        break;
                                                    }
                                                    if (next2 == 2) {
                                                        String name2 = xml.getName();
                                                        TypedArray typedArrayObtainStyledAttributes3 = this.f355a.obtainStyledAttributes(attributeSetAsAttributeSet, mi.Favorite);
                                                        contentValues.clear();
                                                        contentValues.put("container", Long.valueOf(jA));
                                                        if ("favorite".equals(name2) && jA >= 0) {
                                                            long jA2 = a(sQLiteDatabase, contentValues, typedArrayObtainStyledAttributes3, packageManager, intent);
                                                            if (jA2 >= 0) {
                                                                arrayList.add(Long.valueOf(jA2));
                                                            }
                                                        } else {
                                                            if (!"shortcut".equals(name2) || jA < 0) {
                                                                throw new RuntimeException("Folders can contain only shortcuts");
                                                            }
                                                            long jA3 = a(sQLiteDatabase, contentValues, typedArrayObtainStyledAttributes3);
                                                            if (jA3 >= 0) {
                                                                arrayList.add(Long.valueOf(jA3));
                                                            }
                                                        }
                                                        typedArrayObtainStyledAttributes3.recycle();
                                                    }
                                                }
                                            }
                                        } else {
                                            zA = a(sQLiteDatabase, contentValues, typedArrayObtainStyledAttributes2) >= 0;
                                        }
                                    } else {
                                        zA = a(xml, attributeSetAsAttributeSet, next, sQLiteDatabase, contentValues, typedArrayObtainStyledAttributes2, packageManager);
                                    }
                                } else {
                                    zA = c(sQLiteDatabase, contentValues);
                                }
                            } else {
                                zA = b(sQLiteDatabase, contentValues);
                            }
                        } else {
                            zA = a(sQLiteDatabase, contentValues, typedArrayObtainStyledAttributes2, packageManager, intent) >= 0;
                        }
                        if (zA) {
                            iA++;
                        }
                        typedArrayObtainStyledAttributes2.recycle();
                    }
                }
            }
        } catch (IOException e) {
            i2 = iA;
            Log.w("Launcher.LauncherProvider", "Got exception parsing favorites.", e);
        } catch (RuntimeException e2) {
            i2 = iA;
            Log.w("Launcher.LauncherProvider", "Got exception parsing favorites.", e2);
        } catch (XmlPullParserException e3) {
            i2 = iA;
            Log.w("Launcher.LauncherProvider", "Got exception parsing favorites.", e3);
        }
        if (this.c == -1) {
            this.c = d(sQLiteDatabase);
        }
        return i2;
    }

    private int a(SQLiteDatabase sQLiteDatabase, Cursor cursor, kj kjVar) {
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow("_id");
        int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow("intent");
        int columnIndexOrThrow3 = cursor.getColumnIndexOrThrow("title");
        int columnIndexOrThrow4 = cursor.getColumnIndexOrThrow("iconType");
        int columnIndexOrThrow5 = cursor.getColumnIndexOrThrow("icon");
        int columnIndexOrThrow6 = cursor.getColumnIndexOrThrow("iconPackage");
        int columnIndexOrThrow7 = cursor.getColumnIndexOrThrow("iconResource");
        int columnIndexOrThrow8 = cursor.getColumnIndexOrThrow("container");
        int columnIndexOrThrow9 = cursor.getColumnIndexOrThrow("itemType");
        int columnIndexOrThrow10 = cursor.getColumnIndexOrThrow("screen");
        int columnIndexOrThrow11 = cursor.getColumnIndexOrThrow("cellX");
        int columnIndexOrThrow12 = cursor.getColumnIndexOrThrow("cellY");
        int columnIndexOrThrow13 = cursor.getColumnIndexOrThrow("uri");
        int columnIndexOrThrow14 = cursor.getColumnIndexOrThrow("displayMode");
        ContentValues[] contentValuesArr = new ContentValues[cursor.getCount()];
        int i = 0;
        while (cursor.moveToNext()) {
            ContentValues contentValues = new ContentValues(cursor.getColumnCount());
            contentValues.put("_id", Long.valueOf(cursor.getLong(columnIndexOrThrow)));
            contentValues.put("intent", cursor.getString(columnIndexOrThrow2));
            contentValues.put("title", cursor.getString(columnIndexOrThrow3));
            contentValues.put("iconType", Integer.valueOf(cursor.getInt(columnIndexOrThrow4)));
            contentValues.put("icon", cursor.getBlob(columnIndexOrThrow5));
            contentValues.put("iconPackage", cursor.getString(columnIndexOrThrow6));
            contentValues.put("iconResource", cursor.getString(columnIndexOrThrow7));
            contentValues.put("container", Integer.valueOf(cursor.getInt(columnIndexOrThrow8)));
            contentValues.put("itemType", Integer.valueOf(cursor.getInt(columnIndexOrThrow9)));
            contentValues.put("appWidgetId", (Integer) (-1));
            contentValues.put("screen", Integer.valueOf(cursor.getInt(columnIndexOrThrow10)));
            contentValues.put("cellX", Integer.valueOf(cursor.getInt(columnIndexOrThrow11)));
            contentValues.put("cellY", Integer.valueOf(cursor.getInt(columnIndexOrThrow12)));
            contentValues.put("uri", cursor.getString(columnIndexOrThrow13));
            contentValues.put("displayMode", Integer.valueOf(cursor.getInt(columnIndexOrThrow14)));
            if (kjVar != null) {
                kjVar.a(contentValues);
            }
            contentValuesArr[i] = contentValues;
            i++;
        }
        if (i <= 0) {
            return 0;
        }
        sQLiteDatabase.beginTransaction();
        try {
            int i2 = 0;
            for (ContentValues contentValues2 : contentValuesArr) {
                if (LauncherProvider.b(this, sQLiteDatabase, "favorites", null, contentValues2) < 0) {
                    return 0;
                }
                i2++;
            }
            sQLiteDatabase.setTransactionSuccessful();
            return i2;
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    private long a(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        contentValues.put("itemType", (Integer) 2);
        contentValues.put("spanX", (Integer) 1);
        contentValues.put("spanY", (Integer) 1);
        long jA = a();
        contentValues.put("_id", Long.valueOf(jA));
        if (LauncherProvider.b(this, sQLiteDatabase, "favorites", null, contentValues) <= 0) {
            return -1L;
        }
        return jA;
    }

    private long a(SQLiteDatabase sQLiteDatabase, ContentValues contentValues, TypedArray typedArray) {
        String string;
        Resources resources = this.f355a.getResources();
        int resourceId = typedArray.getResourceId(8, 0);
        int resourceId2 = typedArray.getResourceId(9, 0);
        try {
            string = typedArray.getString(10);
            try {
                Intent uri = Intent.parseUri(string, 0);
                if (resourceId == 0 || resourceId2 == 0) {
                    Log.w("Launcher.LauncherProvider", "Shortcut is missing title or icon resource ID");
                    return -1L;
                }
                long jA = a();
                uri.setFlags(268435456);
                contentValues.put("intent", uri.toUri(0));
                contentValues.put("title", resources.getString(resourceId2));
                contentValues.put("itemType", (Integer) 1);
                contentValues.put("spanX", (Integer) 1);
                contentValues.put("spanY", (Integer) 1);
                contentValues.put("iconType", (Integer) 0);
                contentValues.put("iconPackage", this.f355a.getPackageName());
                contentValues.put("iconResource", resources.getResourceName(resourceId));
                contentValues.put("_id", Long.valueOf(jA));
                if (LauncherProvider.b(this, sQLiteDatabase, "favorites", null, contentValues) >= 0) {
                    return jA;
                }
                return -1L;
            } catch (URISyntaxException e) {
                Log.w("Launcher.LauncherProvider", "Shortcut has malformed uri: " + string);
                return -1L;
            }
        } catch (URISyntaxException e2) {
            string = null;
        }
    }

    private long a(SQLiteDatabase sQLiteDatabase, ContentValues contentValues, TypedArray typedArray, PackageManager packageManager, Intent intent) throws PackageManager.NameNotFoundException {
        long jA;
        PackageManager.NameNotFoundException e;
        ComponentName componentName;
        ActivityInfo activityInfo;
        String string = typedArray.getString(1);
        String string2 = typedArray.getString(0);
        try {
            try {
                ComponentName componentName2 = new ComponentName(string, string2);
                componentName = componentName2;
                activityInfo = packageManager.getActivityInfo(componentName2, 0);
            } catch (PackageManager.NameNotFoundException e2) {
                jA = -1;
                e = e2;
                Log.w("Launcher.LauncherProvider", "Unable to add favorite: " + string + "/" + string2, e);
                return jA;
            }
        } catch (PackageManager.NameNotFoundException e3) {
            ComponentName componentName3 = new ComponentName(packageManager.currentToCanonicalPackageNames(new String[]{string})[0], string2);
            componentName = componentName3;
            activityInfo = packageManager.getActivityInfo(componentName3, 0);
        }
        jA = a();
        try {
            intent.setComponent(componentName);
            intent.setFlags(270532608);
            contentValues.put("intent", intent.toUri(0));
            contentValues.put("title", activityInfo.loadLabel(packageManager).toString());
            contentValues.put("itemType", (Integer) 0);
            contentValues.put("spanX", (Integer) 1);
            contentValues.put("spanY", (Integer) 1);
            contentValues.put("_id", Long.valueOf(a()));
            if (LauncherProvider.b(this, sQLiteDatabase, "favorites", null, contentValues) < 0) {
                return -1L;
            }
            return jA;
        } catch (PackageManager.NameNotFoundException e4) {
            e = e4;
            Log.w("Launcher.LauncherProvider", "Unable to add favorite: " + string + "/" + string2, e);
            return jA;
        }
    }

    private ComponentName a(String str) {
        List<AppWidgetProviderInfo> installedProviders = AppWidgetManager.getInstance(this.f355a).getInstalledProviders();
        if (installedProviders == null) {
            return null;
        }
        int size = installedProviders.size();
        for (int i = 0; i < size; i++) {
            ComponentName componentName = installedProviders.get(i).provider;
            if (componentName != null && componentName.getPackageName().equals(str)) {
                return componentName;
            }
        }
        return null;
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE workspaceScreens (_id INTEGER,screenRank INTEGER,modified INTEGER NOT NULL DEFAULT 0);");
    }

    private static final void a(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        if (!xmlPullParser.getName().equals(str)) {
            throw new XmlPullParserException("Unexpected start tag: found " + xmlPullParser.getName() + ", expected " + str);
        }
    }

    private boolean a(XmlResourceParser xmlResourceParser, AttributeSet attributeSet, int i, SQLiteDatabase sQLiteDatabase, ContentValues contentValues, TypedArray typedArray, PackageManager packageManager) {
        String string = typedArray.getString(1);
        String string2 = typedArray.getString(0);
        if (string == null || string2 == null) {
            return false;
        }
        boolean z = true;
        ComponentName componentName = new ComponentName(string, string2);
        try {
            packageManager.getReceiverInfo(componentName, 0);
        } catch (Exception e) {
            componentName = new ComponentName(packageManager.currentToCanonicalPackageNames(new String[]{string})[0], string2);
            try {
                packageManager.getReceiverInfo(componentName, 0);
            } catch (Exception e2) {
                z = false;
            }
        }
        if (!z) {
            return false;
        }
        int i2 = typedArray.getInt(6, 0);
        int i3 = typedArray.getInt(7, 0);
        Bundle bundle = new Bundle();
        int depth = xmlResourceParser.getDepth();
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 3 && xmlResourceParser.getDepth() <= depth) {
                return a(sQLiteDatabase, contentValues, componentName, i2, i3, bundle);
            }
            if (next == 2) {
                TypedArray typedArrayObtainStyledAttributes = this.f355a.obtainStyledAttributes(attributeSet, mi.Extra);
                if (!"extra".equals(xmlResourceParser.getName())) {
                    throw new RuntimeException("Widgets can contain only extras");
                }
                String string3 = typedArrayObtainStyledAttributes.getString(0);
                String string4 = typedArrayObtainStyledAttributes.getString(1);
                if (string3 == null || string4 == null) {
                    throw new RuntimeException("Widget extras must have a key and value");
                }
                bundle.putString(string3, string4);
                typedArrayObtainStyledAttributes.recycle();
            }
        }
    }

    private boolean a(SQLiteDatabase sQLiteDatabase, ContentValues contentValues, ComponentName componentName, int i, int i2, Bundle bundle) {
        boolean z;
        RuntimeException e;
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this.f355a);
        try {
            int iAllocateAppWidgetId = this.b.allocateAppWidgetId();
            contentValues.put("itemType", (Integer) 4);
            contentValues.put("spanX", Integer.valueOf(i));
            contentValues.put("spanY", Integer.valueOf(i2));
            contentValues.put("appWidgetId", Integer.valueOf(iAllocateAppWidgetId));
            contentValues.put("appWidgetProvider", componentName.flattenToString());
            contentValues.put("_id", Long.valueOf(a()));
            LauncherProvider.b(this, sQLiteDatabase, "favorites", null, contentValues);
            z = true;
            try {
                appWidgetManager.bindAppWidgetIdIfAllowed(iAllocateAppWidgetId, componentName);
                if (bundle != null && !bundle.isEmpty()) {
                    Intent intent = new Intent("com.android.launcher.action.APPWIDGET_DEFAULT_WORKSPACE_CONFIGURE");
                    intent.setComponent(componentName);
                    intent.putExtras(bundle);
                    intent.putExtra("appWidgetId", iAllocateAppWidgetId);
                    this.f355a.sendBroadcast(intent);
                }
            } catch (RuntimeException e2) {
                e = e2;
                Log.e("Launcher.LauncherProvider", "Problem allocating appWidgetId", e);
            }
        } catch (RuntimeException e3) {
            z = false;
            e = e3;
        }
        return z;
    }

    private boolean a(SQLiteDatabase sQLiteDatabase, Uri uri, kj kjVar, boolean z) throws Throwable {
        Cursor cursorQuery;
        boolean z2;
        ContentResolver contentResolver = this.f355a.getContentResolver();
        try {
            cursorQuery = contentResolver.query(uri, null, null, null, null);
        } catch (Exception e) {
            cursorQuery = null;
        }
        if (cursorQuery != null) {
            try {
                if (cursorQuery.getCount() > 0) {
                    boolean z3 = a(sQLiteDatabase, cursorQuery, kjVar) > 0;
                    if (z3 && z) {
                        contentResolver.delete(uri, null, null);
                        z2 = z3;
                    } else {
                        z2 = z3;
                    }
                } else {
                    z2 = false;
                }
            } finally {
                cursorQuery.close();
            }
        } else {
            z2 = false;
        }
        if (z2) {
            f(sQLiteDatabase);
            this.c = d(sQLiteDatabase);
        }
        return z2;
    }

    /* JADX WARN: Code duplicated, block: B:48:0x0111  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int[]] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.database.Cursor] */
    private boolean b(SQLiteDatabase sQLiteDatabase) throws Throwable {
        Cursor cursorQuery;
        ?? r1 = {1};
        String strA = LauncherProvider.a("itemType", (int[]) r1);
        sQLiteDatabase.beginTransaction();
        try {
            try {
                cursorQuery = sQLiteDatabase.query("favorites", new String[]{"_id", "intent"}, strA, null, null, null, null);
                if (cursorQuery == null) {
                    sQLiteDatabase.endTransaction();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return false;
                }
                try {
                    int columnIndex = cursorQuery.getColumnIndex("_id");
                    int columnIndex2 = cursorQuery.getColumnIndex("intent");
                    while (cursorQuery.moveToNext()) {
                        long j = cursorQuery.getLong(columnIndex);
                        String string = cursorQuery.getString(columnIndex2);
                        if (string != null) {
                            try {
                                Intent uri = Intent.parseUri(string, 0);
                                Log.d("Home", uri.toString());
                                Uri data = uri.getData();
                                if (data != null) {
                                    String string2 = data.toString();
                                    if ("android.intent.action.VIEW".equals(uri.getAction()) || "com.android.contacts.action.QUICK_CONTACT".equals(uri.getAction())) {
                                        if (string2.startsWith("content://contacts/people/") || string2.startsWith("content://com.android.contacts/contacts/lookup/")) {
                                            Intent intent = new Intent("com.android.contacts.action.QUICK_CONTACT");
                                            intent.addFlags(268468224);
                                            intent.putExtra("com.android.launcher6.intent.extra.shortcut.INGORE_LAUNCH_ANIMATION", true);
                                            intent.setData(data);
                                            intent.setDataAndType(data, intent.resolveType(this.f355a));
                                            ContentValues contentValues = new ContentValues();
                                            contentValues.put("intent", intent.toUri(0));
                                            sQLiteDatabase.update("favorites", contentValues, "_id=" + j, null);
                                        }
                                    }
                                }
                            } catch (RuntimeException e) {
                                Log.e("Launcher.LauncherProvider", "Problem upgrading shortcut", e);
                            } catch (URISyntaxException e2) {
                                Log.e("Launcher.LauncherProvider", "Problem upgrading shortcut", e2);
                            }
                        }
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                    sQLiteDatabase.endTransaction();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return true;
                } catch (SQLException e3) {
                    e = e3;
                    Log.w("Launcher.LauncherProvider", "Problem while upgrading contacts", e);
                    sQLiteDatabase.endTransaction();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return false;
                }
            } catch (SQLException e4) {
                e = e4;
                cursorQuery = null;
            } catch (Throwable th) {
                th = th;
                r1 = 0;
                sQLiteDatabase.endTransaction();
                if (r1 != 0) {
                    r1.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase.endTransaction();
            if (r1 != 0) {
                r1.close();
            }
            throw th;
        }
    }

    private boolean b(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        return a(sQLiteDatabase, contentValues, f(), 4, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long c(long j) {
        return j >= 2 ? j - 2 : 3 + j;
    }

    private void c() {
        this.f355a.getContentResolver().notifyChange(LauncherProvider.f89a, null);
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:42:0x00b9  */
    private void c(SQLiteDatabase sQLiteDatabase) throws Throwable {
        SQLiteStatement sQLiteStatementCompileStatement;
        Cursor cursorRawQuery = null;
        Log.d("Launcher.LauncherProvider", "normalizing icons");
        sQLiteDatabase.beginTransaction();
        try {
            sQLiteStatementCompileStatement = sQLiteDatabase.compileStatement("UPDATE favorites SET icon=? WHERE _id=?");
            try {
                try {
                    cursorRawQuery = sQLiteDatabase.rawQuery("SELECT _id, icon FROM favorites WHERE iconType=1", null);
                    int columnIndexOrThrow = cursorRawQuery.getColumnIndexOrThrow("_id");
                    int columnIndexOrThrow2 = cursorRawQuery.getColumnIndexOrThrow("icon");
                    boolean z = false;
                    while (cursorRawQuery.moveToNext()) {
                        long j = cursorRawQuery.getLong(columnIndexOrThrow);
                        byte[] blob = cursorRawQuery.getBlob(columnIndexOrThrow2);
                        try {
                            Bitmap bitmapB = my.b(BitmapFactory.decodeByteArray(blob, 0, blob.length), this.f355a);
                            if (bitmapB != null) {
                                sQLiteStatementCompileStatement.bindLong(1, j);
                                byte[] bArrA = ec.a(bitmapB);
                                if (bArrA != null) {
                                    sQLiteStatementCompileStatement.bindBlob(2, bArrA);
                                    sQLiteStatementCompileStatement.execute();
                                }
                                bitmapB.recycle();
                            }
                        } catch (Exception e) {
                            if (z) {
                                Log.e("Launcher.LauncherProvider", "Also failed normalizing icon " + j);
                            } else {
                                Log.e("Launcher.LauncherProvider", "Failed normalizing icon " + j, e);
                            }
                            z = true;
                        }
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                    sQLiteDatabase.endTransaction();
                    if (sQLiteStatementCompileStatement != null) {
                        sQLiteStatementCompileStatement.close();
                    }
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    sQLiteDatabase.endTransaction();
                    if (sQLiteStatementCompileStatement != null) {
                        sQLiteStatementCompileStatement.close();
                    }
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    throw th;
                }
            } catch (SQLException e2) {
                e = e2;
                Log.w("Launcher.LauncherProvider", "Problem while allocating appWidgetIds for existing widgets", e);
                sQLiteDatabase.endTransaction();
                if (sQLiteStatementCompileStatement != null) {
                    sQLiteStatementCompileStatement.close();
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            }
        } catch (SQLException e3) {
            e = e3;
            sQLiteStatementCompileStatement = null;
        } catch (Throwable th2) {
            th = th2;
            sQLiteStatementCompileStatement = null;
            sQLiteDatabase.endTransaction();
            if (sQLiteStatementCompileStatement != null) {
                sQLiteStatementCompileStatement.close();
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    private boolean c(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        return a(sQLiteDatabase, contentValues, new ComponentName("com.android.alarmclock", "com.android.alarmclock.AnalogAppWidgetProvider"), 2, 2, null);
    }

    private long d(SQLiteDatabase sQLiteDatabase) {
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT MAX(_id) FROM favorites", null);
        long j = (cursorRawQuery == null || !cursorRawQuery.moveToNext()) ? -1L : cursorRawQuery.getLong(0);
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        if (j == -1) {
            throw new RuntimeException("Error: could not query max item id");
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        SharedPreferences.Editor editorEdit = this.f355a.getSharedPreferences(ip.h(), 0).edit();
        editorEdit.putBoolean("UPGRADED_FROM_OLD_DATABASE", true);
        editorEdit.putBoolean("EMPTY_DATABASE_CREATED", false);
        editorEdit.commit();
    }

    private long e(SQLiteDatabase sQLiteDatabase) {
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT MAX(_id) FROM workspaceScreens", null);
        long j = (cursorRawQuery == null || !cursorRawQuery.moveToNext()) ? -1L : cursorRawQuery.getLong(0);
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        if (j == -1) {
            throw new RuntimeException("Error: could not query max screen id");
        }
        return j;
    }

    private void e() {
        SharedPreferences.Editor editorEdit = this.f355a.getSharedPreferences(ip.h(), 0).edit();
        editorEdit.putBoolean("EMPTY_DATABASE_CREATED", true);
        editorEdit.putBoolean("UPGRADED_FROM_OLD_DATABASE", false);
        editorEdit.commit();
    }

    private ComponentName f() {
        ComponentName globalSearchActivity = ((SearchManager) this.f355a.getSystemService("search")).getGlobalSearchActivity();
        if (globalSearchActivity == null) {
            return null;
        }
        return a(globalSearchActivity.getPackageName());
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00e8  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.database.Cursor] */
    private void f(SQLiteDatabase sQLiteDatabase) throws Throwable {
        Cursor cursorQuery;
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this.f355a);
        ?? r1 = "itemType";
        String strA = LauncherProvider.a("itemType", new int[]{1000, 1002, 1001});
        sQLiteDatabase.beginTransaction();
        try {
            try {
                cursorQuery = sQLiteDatabase.query("favorites", new String[]{"_id", "itemType"}, strA, null, null, null, null);
                try {
                    ContentValues contentValues = new ContentValues();
                    while (cursorQuery != null && cursorQuery.moveToNext()) {
                        long j = cursorQuery.getLong(0);
                        int i = cursorQuery.getInt(1);
                        try {
                            int iAllocateAppWidgetId = this.b.allocateAppWidgetId();
                            contentValues.clear();
                            contentValues.put("itemType", (Integer) 4);
                            contentValues.put("appWidgetId", Integer.valueOf(iAllocateAppWidgetId));
                            if (i == 1001) {
                                contentValues.put("spanX", (Integer) 4);
                                contentValues.put("spanY", (Integer) 1);
                            } else {
                                contentValues.put("spanX", (Integer) 2);
                                contentValues.put("spanY", (Integer) 2);
                            }
                            sQLiteDatabase.update("favorites", contentValues, "_id=" + j, null);
                            if (i == 1000) {
                                appWidgetManager.bindAppWidgetIdIfAllowed(iAllocateAppWidgetId, new ComponentName("com.android.alarmclock", "com.android.alarmclock.AnalogAppWidgetProvider"));
                            } else if (i == 1002) {
                                appWidgetManager.bindAppWidgetIdIfAllowed(iAllocateAppWidgetId, new ComponentName("com.android.camera", "com.android.camera.PhotoAppWidgetProvider"));
                            } else if (i == 1001) {
                                appWidgetManager.bindAppWidgetIdIfAllowed(iAllocateAppWidgetId, f());
                            }
                        } catch (RuntimeException e) {
                            Log.e("Launcher.LauncherProvider", "Problem allocating appWidgetId", e);
                        }
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                    sQLiteDatabase.endTransaction();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } catch (SQLException e2) {
                    e = e2;
                    Log.w("Launcher.LauncherProvider", "Problem while allocating appWidgetIds for existing widgets", e);
                    sQLiteDatabase.endTransaction();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            } catch (SQLException e3) {
                e = e3;
                cursorQuery = null;
            } catch (Throwable th) {
                th = th;
                r1 = 0;
                sQLiteDatabase.endTransaction();
                if (r1 != 0) {
                    r1.close();
                }
                throw th;
            }
            this.c = d(sQLiteDatabase);
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase.endTransaction();
            if (r1 != 0) {
                r1.close();
            }
            throw th;
        }
    }

    public long a() {
        if (this.c < 0) {
            throw new RuntimeException("Error: max item id was not initialized");
        }
        this.c++;
        return this.c;
    }

    public void a(long j) {
        this.c = 1 + j;
    }

    public long b() {
        if (this.d < 0) {
            throw new RuntimeException("Error: max screen id was not initialized");
        }
        this.d++;
        return this.d;
    }

    public void b(long j) {
        this.d = j;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.c = 1L;
        this.d = 0L;
        sQLiteDatabase.execSQL("CREATE TABLE favorites (_id INTEGER PRIMARY KEY,title TEXT,intent TEXT,container INTEGER,screen INTEGER,cellX INTEGER,cellY INTEGER,spanX INTEGER,spanY INTEGER,itemType INTEGER,appWidgetId INTEGER NOT NULL DEFAULT -1,isShortcut INTEGER,iconType INTEGER,iconPackage TEXT,iconResource TEXT,icon BLOB,uri TEXT,displayMode INTEGER,appWidgetProvider TEXT,modified INTEGER NOT NULL DEFAULT 0);");
        a(sQLiteDatabase);
        if (this.b != null) {
            this.b.deleteHost();
            c();
        }
        kl klVar = new kl(this);
        if (a(sQLiteDatabase, Uri.parse("content://settings/old_favorites?notify=true"), klVar, true) || a(sQLiteDatabase, kq.b, klVar, false)) {
            d();
        } else {
            e();
        }
    }

    /* JADX WARN: Code duplicated, block: B:72:0x010d  */
    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) throws Throwable {
        int i3;
        int i4;
        int i5;
        int i6 = 7;
        if (i < 3) {
            sQLiteDatabase.beginTransaction();
            try {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE favorites ADD COLUMN appWidgetId INTEGER NOT NULL DEFAULT -1;");
                    sQLiteDatabase.setTransactionSuccessful();
                    sQLiteDatabase.endTransaction();
                    i3 = 3;
                } catch (SQLException e) {
                    Log.e("Launcher.LauncherProvider", e.getMessage(), e);
                    sQLiteDatabase.endTransaction();
                    i3 = i;
                }
                if (i3 == 3) {
                    f(sQLiteDatabase);
                }
            } catch (Throwable th) {
                sQLiteDatabase.endTransaction();
                throw th;
            }
        } else {
            i3 = i;
        }
        int i7 = i3 >= 4 ? i3 : 4;
        if (i7 < 6) {
            sQLiteDatabase.beginTransaction();
            try {
                try {
                    sQLiteDatabase.execSQL("UPDATE favorites SET screen=(screen + 1);");
                    sQLiteDatabase.setTransactionSuccessful();
                    sQLiteDatabase.endTransaction();
                } catch (SQLException e2) {
                    Log.e("Launcher.LauncherProvider", e2.getMessage(), e2);
                    sQLiteDatabase.endTransaction();
                }
                if (b(sQLiteDatabase)) {
                    i4 = 6;
                } else {
                    i4 = i7;
                }
            } catch (Throwable th2) {
                sQLiteDatabase.endTransaction();
                throw th2;
            }
        } else {
            i4 = i7;
        }
        if (i4 < 7) {
            f(sQLiteDatabase);
        } else {
            i6 = i4;
        }
        if (i6 < 8) {
            c(sQLiteDatabase);
            i6 = 8;
        }
        if (i6 < 9) {
            if (this.c == -1) {
                this.c = d(sQLiteDatabase);
            }
            a(sQLiteDatabase, R.xml.update_workspace);
            i6 = 9;
        }
        if (i6 < 12) {
            b(sQLiteDatabase);
            i6 = 12;
        }
        if (i6 < 13) {
            this.d = 0L;
            LauncherProvider.c = true;
            a(sQLiteDatabase);
            i6 = 13;
        }
        if (i6 < 14) {
            sQLiteDatabase.beginTransaction();
            try {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE favorites ADD COLUMN appWidgetProvider TEXT;");
                    sQLiteDatabase.setTransactionSuccessful();
                    i6 = 14;
                    sQLiteDatabase.endTransaction();
                } catch (SQLException e3) {
                    Log.e("Launcher.LauncherProvider", e3.getMessage(), e3);
                    sQLiteDatabase.endTransaction();
                }
            } catch (Throwable th3) {
                sQLiteDatabase.endTransaction();
                throw th3;
            }
        }
        if (i6 < 15) {
            sQLiteDatabase.beginTransaction();
            try {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE favorites ADD COLUMN modified INTEGER NOT NULL DEFAULT 0;");
                    sQLiteDatabase.execSQL("ALTER TABLE workspaceScreens ADD COLUMN modified INTEGER NOT NULL DEFAULT 0;");
                    sQLiteDatabase.setTransactionSuccessful();
                    sQLiteDatabase.endTransaction();
                    i5 = 15;
                } catch (SQLException e4) {
                    Log.e("Launcher.LauncherProvider", e4.getMessage(), e4);
                    sQLiteDatabase.endTransaction();
                    i5 = i6;
                }
            } catch (Throwable th4) {
                sQLiteDatabase.endTransaction();
                throw th4;
            }
        } else {
            i5 = i6;
        }
        if (i5 != 15) {
            Log.w("Launcher.LauncherProvider", "Destroying all old data.");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS favorites");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS workspaceScreens");
            onCreate(sQLiteDatabase);
        }
    }
}
