package android.support.v4.widget;

import android.database.Cursor;
import android.widget.Filter;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/widget/CursorFilter.class */
class CursorFilter extends Filter {
    CursorFilterClient mClient;

    /* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/widget/CursorFilter$CursorFilterClient.class */
    interface CursorFilterClient {
        CharSequence convertToString(Cursor cursor);

        Cursor runQueryOnBackgroundThread(CharSequence charSequence);

        Cursor getCursor();

        void changeCursor(Cursor cursor);
    }

    CursorFilter(CursorFilterClient client) {
        this.mClient = client;
    }

    @Override // android.widget.Filter
    public CharSequence convertResultToString(Object resultValue) {
        return this.mClient.convertToString((Cursor) resultValue);
    }

    @Override // android.widget.Filter
    protected Filter.FilterResults performFiltering(CharSequence constraint) {
        Cursor cursor = this.mClient.runQueryOnBackgroundThread(constraint);
        Filter.FilterResults results = new Filter.FilterResults();
        if (cursor != null) {
            results.count = cursor.getCount();
            results.values = cursor;
        } else {
            results.count = 0;
            results.values = null;
        }
        return results;
    }

    @Override // android.widget.Filter
    protected void publishResults(CharSequence constraint, Filter.FilterResults results) {
        Cursor oldCursor = this.mClient.getCursor();
        if (results.values != null && results.values != oldCursor) {
            this.mClient.changeCursor((Cursor) results.values);
        }
    }
}
