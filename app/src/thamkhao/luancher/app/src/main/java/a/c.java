package a;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Uri f5a = Uri.parse("content://com.syu.ms.provider");

    public static int a(ContentResolver contentResolver, int i, int i2) {
        Cursor cursorQuery;
        if (contentResolver != null && (cursorQuery = contentResolver.query(f5a, null, Integer.toString(i), null, null)) != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    i2 = cursorQuery.getInt(0);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            cursorQuery.close();
        }
        return i2;
    }
}
