package android.support.v4.media;

import android.media.browse.MediaBrowser;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/media/ParceledListSliceAdapterApi21.class */
class ParceledListSliceAdapterApi21 {
    private static Constructor sConstructor;

    ParceledListSliceAdapterApi21() {
    }

    static {
        try {
            sConstructor = Class.forName("android.content.pm.ParceledListSlice").getConstructor(List.class);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    static Object newInstance(List<MediaBrowser.MediaItem> itemList) {
        Object result = null;
        try {
            result = sConstructor.newInstance(itemList);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return result;
    }
}
