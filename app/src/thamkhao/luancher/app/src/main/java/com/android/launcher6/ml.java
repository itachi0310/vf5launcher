package com.android.launcher6;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
class ml extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f393a;

    public ml(Context context) {
        super(context, new File(context.getCacheDir(), "saved_wallpaper_images.db").getPath(), (SQLiteDatabase.CursorFactory) null, 1);
        this.f393a = context;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS saved_wallpaper_images (id INTEGER NOT NULL, image_thumbnail TEXT NOT NULL, image TEXT NOT NULL, PRIMARY KEY (id ASC) );");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i != i2) {
            sQLiteDatabase.execSQL("DELETE FROM saved_wallpaper_images");
        }
    }
}
