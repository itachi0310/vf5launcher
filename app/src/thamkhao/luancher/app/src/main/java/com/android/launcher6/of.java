package com.android.launcher6;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
class of extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f433a;

    public of(Context context) {
        super(context, new File(context.getCacheDir(), "widgetpreviews.db").getPath(), (SQLiteDatabase.CursorFactory) null, 2);
        this.f433a = context;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS shortcut_and_widget_previews (name TEXT NOT NULL, size TEXT NOT NULL, preview_bitmap BLOB NOT NULL, PRIMARY KEY (name, size) );");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i != i2) {
            sQLiteDatabase.execSQL("DELETE FROM shortcut_and_widget_previews");
        }
    }
}
