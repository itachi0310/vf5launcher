package android.support.v4.speech.tts;

import android.content.Context;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.util.Log;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/speech/tts/TextToSpeechICS.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class TextToSpeechICS {
    private static final String TAG = "android.support.v4.speech.tts";

    TextToSpeechICS() {
    }

    static TextToSpeech construct(Context context, TextToSpeech.OnInitListener onInitListener, String engineName) {
        if (Build.VERSION.SDK_INT < 14) {
            if (engineName == null) {
                return new TextToSpeech(context, onInitListener);
            }
            Log.w(TAG, "Can't specify tts engine on this device");
            return new TextToSpeech(context, onInitListener);
        }
        return new TextToSpeech(context, onInitListener, engineName);
    }
}
