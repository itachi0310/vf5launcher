package com.android.launcher6;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class mk extends BaseAdapter implements ListAdapter {
    private static String d = "Launcher3.SavedWallpaperImages";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ArrayList f392a;
    Context b;
    LayoutInflater c;
    private ml e;

    public mk(Activity activity) {
        this.e = new ml(activity);
        this.b = activity;
        this.c = activity.getLayoutInflater();
    }

    private Pair d(int i) {
        Cursor cursorQuery = this.e.getReadableDatabase().query("saved_wallpaper_images", new String[]{"image_thumbnail", "image"}, "id = ?", new String[]{Integer.toString(i)}, null, null, null, null);
        if (cursorQuery.getCount() <= 0) {
            return null;
        }
        cursorQuery.moveToFirst();
        String string = cursorQuery.getString(0);
        String string2 = cursorQuery.getString(1);
        cursorQuery.close();
        return new Pair(string, string2);
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public mm getItem(int i) {
        return (mm) this.f392a.get(i);
    }

    public void a() {
        this.f392a = new ArrayList();
        Cursor cursorQuery = this.e.getReadableDatabase().query("saved_wallpaper_images", new String[]{"id", "image_thumbnail"}, null, null, null, null, "id DESC", null);
        while (cursorQuery.moveToNext()) {
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(new File(this.b.getFilesDir(), cursorQuery.getString(1)).getAbsolutePath());
            if (bitmapDecodeFile != null) {
                this.f392a.add(new mm(cursorQuery.getInt(0), new BitmapDrawable(bitmapDecodeFile)));
            }
        }
        cursorQuery.close();
    }

    public void a(Bitmap bitmap, byte[] bArr) {
        try {
            File fileCreateTempFile = File.createTempFile("wallpaper", "", this.b.getFilesDir());
            FileOutputStream fileOutputStreamOpenFileOutput = this.b.openFileOutput(fileCreateTempFile.getName(), 0);
            fileOutputStreamOpenFileOutput.write(bArr);
            fileOutputStreamOpenFileOutput.close();
            File fileCreateTempFile2 = File.createTempFile("wallpaperthumb", "", this.b.getFilesDir());
            FileOutputStream fileOutputStreamOpenFileOutput2 = this.b.openFileOutput(fileCreateTempFile2.getName(), 0);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 95, fileOutputStreamOpenFileOutput2);
            fileOutputStreamOpenFileOutput2.close();
            SQLiteDatabase writableDatabase = this.e.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("image_thumbnail", fileCreateTempFile2.getName());
            contentValues.put("image", fileCreateTempFile.getName());
            writableDatabase.insert("saved_wallpaper_images", null, contentValues);
        } catch (IOException e) {
            Log.e(d, "Failed writing images to storage " + e);
        }
    }

    public String b(int i) {
        Pair pairD = d(i);
        if (pairD != null) {
            return (String) pairD.second;
        }
        return null;
    }

    public void c(int i) {
        Pair pairD = d(i);
        new File(this.b.getFilesDir(), (String) pairD.first).delete();
        new File(this.b.getFilesDir(), (String) pairD.second).delete();
        this.e.getWritableDatabase().delete("saved_wallpaper_images", "id = ?", new String[]{Integer.toString(i)});
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f392a.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Drawable drawable = ((mm) this.f392a.get(i)).c;
        if (drawable == null) {
            Log.e(d, "Error decoding thumbnail for wallpaper #" + i);
        }
        return WallpaperPickerActivity.a(this.c, i, view, viewGroup, drawable);
    }
}
