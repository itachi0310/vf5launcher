package android.support.v4.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.OperationCanceledException;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/content/ContentResolverCompatJellybean.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class ContentResolverCompatJellybean {
    ContentResolverCompatJellybean() {
    }

    public static Cursor query(ContentResolver resolver, Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder, Object cancellationSignalObj) {
        return resolver.query(uri, projection, selection, selectionArgs, sortOrder, (CancellationSignal) cancellationSignalObj);
    }

    static boolean isFrameworkOperationCanceledException(Exception e) {
        return e instanceof OperationCanceledException;
    }
}
