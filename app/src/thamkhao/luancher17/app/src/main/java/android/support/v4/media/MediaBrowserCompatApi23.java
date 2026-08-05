package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.os.Parcel;
import android.support.annotation.NonNull;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/media/MediaBrowserCompatApi23.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class MediaBrowserCompatApi23 {

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/media/MediaBrowserCompatApi23$ItemCallback.class
  classes.dex
 */
    interface ItemCallback {
        void onError(@NonNull String str);

        void onItemLoaded(Parcel parcel);
    }

    MediaBrowserCompatApi23() {
    }

    public static Object createItemCallback(ItemCallback callback) {
        return new ItemCallbackProxy(callback);
    }

    public static void getItem(Object browserObj, String mediaId, Object itemCallbackObj) {
        ((MediaBrowser) browserObj).getItem(mediaId, (MediaBrowser.ItemCallback) itemCallbackObj);
    }

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/media/MediaBrowserCompatApi23$ItemCallbackProxy.class
  classes.dex
 */
    static class ItemCallbackProxy<T extends ItemCallback> extends MediaBrowser.ItemCallback {
        protected final T mItemCallback;

        public ItemCallbackProxy(T callback) {
            this.mItemCallback = callback;
        }

        @Override // android.media.browse.MediaBrowser.ItemCallback
        public void onItemLoaded(MediaBrowser.MediaItem item) {
            Parcel parcel = Parcel.obtain();
            item.writeToParcel(parcel, 0);
            this.mItemCallback.onItemLoaded(parcel);
        }

        @Override // android.media.browse.MediaBrowser.ItemCallback
        public void onError(@NonNull String itemId) {
            this.mItemCallback.onError(itemId);
        }
    }
}
