package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.os.Bundle;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/media/session/PlaybackStateCompatApi22.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class PlaybackStateCompatApi22 {
    PlaybackStateCompatApi22() {
    }

    public static Bundle getExtras(Object stateObj) {
        return ((PlaybackState) stateObj).getExtras();
    }

    public static Object newInstance(int state, long position, long bufferedPosition, float speed, long actions, CharSequence errorMessage, long updateTime, List<Object> customActions, long activeItemId, Bundle extras) {
        PlaybackState.Builder stateObj = new PlaybackState.Builder();
        stateObj.setState(state, position, speed, updateTime);
        stateObj.setBufferedPosition(bufferedPosition);
        stateObj.setActions(actions);
        stateObj.setErrorMessage(errorMessage);
        for (Object customAction : customActions) {
            stateObj.addCustomAction((PlaybackState.CustomAction) customAction);
        }
        stateObj.setActiveQueueItemId(activeItemId);
        stateObj.setExtras(extras);
        return stateObj.build();
    }
}
