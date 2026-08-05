package android.support.v4.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/provider/DocumentsContractApi19.class */
class DocumentsContractApi19 {
    private static final String TAG = "DocumentFile";

    DocumentsContractApi19() {
    }

    public static boolean isDocumentUri(Context context, Uri self) {
        return DocumentsContract.isDocumentUri(context, self);
    }

    public static String getName(Context context, Uri self) {
        return queryForString(context, self, "_display_name", null);
    }

    private static String getRawType(Context context, Uri self) {
        return queryForString(context, self, "mime_type", null);
    }

    public static String getType(Context context, Uri self) {
        String rawType = getRawType(context, self);
        if ("vnd.android.document/directory".equals(rawType)) {
            return null;
        }
        return rawType;
    }

    public static boolean isDirectory(Context context, Uri self) {
        return "vnd.android.document/directory".equals(getRawType(context, self));
    }

    public static boolean isFile(Context context, Uri self) {
        String type = getRawType(context, self);
        if ("vnd.android.document/directory".equals(type) || TextUtils.isEmpty(type)) {
            return false;
        }
        return true;
    }

    public static long lastModified(Context context, Uri self) {
        return queryForLong(context, self, "last_modified", 0L);
    }

    public static long length(Context context, Uri self) {
        return queryForLong(context, self, "_size", 0L);
    }

    public static boolean canRead(Context context, Uri self) {
        if (context.checkCallingOrSelfUriPermission(self, 1) != 0 || TextUtils.isEmpty(getRawType(context, self))) {
            return false;
        }
        return true;
    }

    public static boolean canWrite(Context context, Uri self) {
        if (context.checkCallingOrSelfUriPermission(self, 2) != 0) {
            return false;
        }
        String type = getRawType(context, self);
        int flags = queryForInt(context, self, "flags", 0);
        if (TextUtils.isEmpty(type)) {
            return false;
        }
        if ((flags & 4) != 0) {
            return true;
        }
        if ("vnd.android.document/directory".equals(type) && (flags & 8) != 0) {
            return true;
        }
        if (!TextUtils.isEmpty(type) && (flags & 2) != 0) {
            return true;
        }
        return false;
    }

    public static boolean delete(Context context, Uri self) {
        return DocumentsContract.deleteDocument(context.getContentResolver(), self);
    }

    public static boolean exists(Context context, Uri self) {
        ContentResolver resolver = context.getContentResolver();
        Cursor c = null;
        try {
            try {
                c = resolver.query(self, new String[]{"document_id"}, null, null, null);
                boolean z = c.getCount() > 0;
                closeQuietly(c);
                return z;
            } catch (Exception e) {
                Log.w(TAG, "Failed query: " + e);
                closeQuietly(c);
                return false;
            }
        } catch (Throwable th) {
            closeQuietly(c);
            throw th;
        }
    }

    private static String queryForString(Context context, Uri self, String column, String defaultValue) {
        ContentResolver resolver = context.getContentResolver();
        Cursor c = null;
        try {
            try {
                c = resolver.query(self, new String[]{column}, null, null, null);
                if (c.moveToFirst() && !c.isNull(0)) {
                    String string = c.getString(0);
                    closeQuietly(c);
                    return string;
                }
                closeQuietly(c);
                return defaultValue;
            } catch (Exception e) {
                Log.w(TAG, "Failed query: " + e);
                closeQuietly(c);
                return defaultValue;
            }
        } catch (Throwable th) {
            closeQuietly(c);
            throw th;
        }
        closeQuietly(c);
        throw th;
    }

    private static int queryForInt(Context context, Uri self, String column, int defaultValue) {
        return (int) queryForLong(context, self, column, defaultValue);
    }

    private static long queryForLong(Context context, Uri self, String column, long defaultValue) {
        ContentResolver resolver = context.getContentResolver();
        Cursor c = null;
        try {
            try {
                c = resolver.query(self, new String[]{column}, null, null, null);
                if (c.moveToFirst() && !c.isNull(0)) {
                    long j = c.getLong(0);
                    closeQuietly(c);
                    return j;
                }
                closeQuietly(c);
                return defaultValue;
            } catch (Exception e) {
                Log.w(TAG, "Failed query: " + e);
                closeQuietly(c);
                return defaultValue;
            }
        } catch (Throwable th) {
            closeQuietly(c);
            throw th;
        }
        closeQuietly(c);
        throw th;
    }

    private static void closeQuietly(AutoCloseable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException rethrown) {
                throw rethrown;
            } catch (Exception e) {
            }
        }
    }
}
