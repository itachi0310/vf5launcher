package android.support.v4.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.support.v4.os.CancellationSignal;
import android.support.v4.os.OperationCanceledException;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/content/ContentResolverCompat.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
public final class ContentResolverCompat {
    private static final ContentResolverCompatImpl IMPL;

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/content/ContentResolverCompat$ContentResolverCompatImpl.class
  classes.dex
 */
    interface ContentResolverCompatImpl {
        Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal);
    }

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/content/ContentResolverCompat$ContentResolverCompatImplBase.class
  classes.dex
 */
    static class ContentResolverCompatImplBase implements ContentResolverCompatImpl {
        ContentResolverCompatImplBase() {
        }

        @Override // android.support.v4.content.ContentResolverCompat.ContentResolverCompatImpl
        public Cursor query(ContentResolver resolver, Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder, CancellationSignal cancellationSignal) {
            if (cancellationSignal != null) {
                cancellationSignal.throwIfCanceled();
            }
            return resolver.query(uri, projection, selection, selectionArgs, sortOrder);
        }
    }

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/content/ContentResolverCompat$ContentResolverCompatImplJB.class
  classes.dex
 */
    static class ContentResolverCompatImplJB extends ContentResolverCompatImplBase {
        ContentResolverCompatImplJB() {
        }

        @Override // android.support.v4.content.ContentResolverCompat.ContentResolverCompatImplBase, android.support.v4.content.ContentResolverCompat.ContentResolverCompatImpl
        public Cursor query(ContentResolver resolver, Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder, CancellationSignal cancellationSignal) throws Exception {
            Object cancellationSignalObject;
            if (cancellationSignal != null) {
                try {
                    cancellationSignalObject = cancellationSignal.getCancellationSignalObject();
                } catch (Exception e) {
                    if (ContentResolverCompatJellybean.isFrameworkOperationCanceledException(e)) {
                        throw new OperationCanceledException();
                    }
                    throw e;
                }
            } else {
                cancellationSignalObject = null;
            }
            return ContentResolverCompatJellybean.query(resolver, uri, projection, selection, selectionArgs, sortOrder, cancellationSignalObject);
        }
    }

    static {
        int version = Build.VERSION.SDK_INT;
        if (version >= 16) {
            IMPL = new ContentResolverCompatImplJB();
        } else {
            IMPL = new ContentResolverCompatImplBase();
        }
    }

    private ContentResolverCompat() {
    }

    public static Cursor query(ContentResolver resolver, Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder, CancellationSignal cancellationSignal) {
        return IMPL.query(resolver, uri, projection, selection, selectionArgs, sortOrder, cancellationSignal);
    }
}
