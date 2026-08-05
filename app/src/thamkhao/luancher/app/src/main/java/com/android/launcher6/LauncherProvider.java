package com.android.launcher6;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class LauncherProvider extends ContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Uri f89a = Uri.parse("content://com.android.launcher6.settings/appWidgetReset");
    private static boolean c;
    private kk b;

    static String a(String str, int[] iArr) {
        StringBuilder sb = new StringBuilder();
        for (int length = iArr.length - 1; length >= 0; length--) {
            sb.append(str).append("=").append(iArr[length]);
            if (length > 0) {
                sb.append(" OR ");
            }
        }
        return sb.toString();
    }

    private void a(ContentValues contentValues) {
        contentValues.put("modified", Long.valueOf(System.currentTimeMillis()));
    }

    private void a(Uri uri) {
        String queryParameter = uri.getQueryParameter("notify");
        if (queryParameter == null || "true".equals(queryParameter)) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long b(kk kkVar, SQLiteDatabase sQLiteDatabase, String str, String str2, ContentValues contentValues) {
        if (contentValues.containsKey("_id")) {
            return sQLiteDatabase.insert(str, str2, contentValues);
        }
        throw new RuntimeException("Error: attempting to add item without specifying an id");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(SQLiteDatabase sQLiteDatabase, long j) {
        km kmVar = new km(kq.a(j, false), null, null);
        sQLiteDatabase.delete(kmVar.f357a, kmVar.b, kmVar.c);
    }

    public long a() {
        return this.b.a();
    }

    public synchronized void a(int i) {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(ip.h(), 0);
        if (sharedPreferences.getBoolean("EMPTY_DATABASE_CREATED", false)) {
            int i2 = i == 0 ? sharedPreferences.getInt("DEFAULT_WORKSPACE_RESOURCE_ID", R.xml.default_workspace) : i;
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.remove("EMPTY_DATABASE_CREATED");
            if (i != 0) {
                editorEdit.putInt("DEFAULT_WORKSPACE_RESOURCE_ID", i);
            }
            this.b.a(this.b.getWritableDatabase(), i2);
            this.b.d();
            editorEdit.commit();
        }
    }

    public void a(long j) {
        this.b.a(j);
    }

    public long b() {
        return this.b.b();
    }

    public void b(long j) {
        this.b.b(j);
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        km kmVar = new km(uri);
        SQLiteDatabase writableDatabase = this.b.getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            int length = contentValuesArr.length;
            for (int i = 0; i < length; i++) {
                a(contentValuesArr[i]);
                if (b(this.b, writableDatabase, kmVar.f357a, null, contentValuesArr[i]) < 0) {
                    writableDatabase.endTransaction();
                    return 0;
                }
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            a(uri);
            return contentValuesArr.length;
        } catch (Throwable th) {
            writableDatabase.endTransaction();
            throw th;
        }
    }

    public synchronized boolean c() {
        boolean z = true;
        synchronized (this) {
            SharedPreferences sharedPreferences = getContext().getSharedPreferences(ip.h(), 0);
            boolean z2 = c;
            c = false;
            if (sharedPreferences.getBoolean("UPGRADED_FROM_OLD_DATABASE", false)) {
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.remove("UPGRADED_FROM_OLD_DATABASE");
                editorEdit.commit();
            } else {
                z = z2;
            }
        }
        return z;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        com.syu.d.a.b("delete");
        km kmVar = new km(uri, str, strArr);
        int iDelete = this.b.getWritableDatabase().delete(kmVar.f357a, kmVar.b, kmVar.c);
        if (iDelete > 0) {
            a(uri);
        }
        return iDelete;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        km kmVar = new km(uri, null, null);
        return TextUtils.isEmpty(kmVar.b) ? "vnd.android.cursor.dir/" + kmVar.f357a : "vnd.android.cursor.item/" + kmVar.f357a;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        km kmVar = new km(uri);
        SQLiteDatabase writableDatabase = this.b.getWritableDatabase();
        a(contentValues);
        long jB = b(this.b, writableDatabase, kmVar.f357a, null, contentValues);
        if (jB <= 0) {
            return null;
        }
        Uri uriWithAppendedId = ContentUris.withAppendedId(uri, jB);
        a(uriWithAppendedId);
        return uriWithAppendedId;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.b = new kk(getContext());
        ip.a(this);
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        km kmVar = new km(uri, str, strArr2);
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables(kmVar.f357a);
        Cursor cursorQuery = sQLiteQueryBuilder.query(this.b.getWritableDatabase(), strArr, kmVar.b, kmVar.c, null, null, str2);
        cursorQuery.setNotificationUri(getContext().getContentResolver(), uri);
        return cursorQuery;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        com.syu.d.a.b("update");
        km kmVar = new km(uri, str, strArr);
        a(contentValues);
        int iUpdate = this.b.getWritableDatabase().update(kmVar.f357a, contentValues, kmVar.b, kmVar.c);
        if (iUpdate > 0) {
            a(uri);
        }
        return iUpdate;
    }
}
