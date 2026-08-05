package android.support.v4.app;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/app/RemoteInput.class */
public final class RemoteInput extends RemoteInputCompatBase.RemoteInput {
    private static final String TAG = "RemoteInput";
    public static final String RESULTS_CLIP_LABEL = "android.remoteinput.results";
    public static final String EXTRA_RESULTS_DATA = "android.remoteinput.resultsData";
    private final String mResultKey;
    private final CharSequence mLabel;
    private final CharSequence[] mChoices;
    private final boolean mAllowFreeFormInput;
    private final Bundle mExtras;
    private static final Impl IMPL;
    public static final RemoteInputCompatBase.RemoteInput.Factory FACTORY;

    /* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/app/RemoteInput$Impl.class */
    interface Impl {
        Bundle getResultsFromIntent(Intent intent);

        void addResultsToIntent(RemoteInput[] remoteInputArr, Intent intent, Bundle bundle);
    }

    private RemoteInput(String resultKey, CharSequence label, CharSequence[] choices, boolean allowFreeFormInput, Bundle extras) {
        this.mResultKey = resultKey;
        this.mLabel = label;
        this.mChoices = choices;
        this.mAllowFreeFormInput = allowFreeFormInput;
        this.mExtras = extras;
    }

    @Override // android.support.v4.app.RemoteInputCompatBase.RemoteInput
    public String getResultKey() {
        return this.mResultKey;
    }

    @Override // android.support.v4.app.RemoteInputCompatBase.RemoteInput
    public CharSequence getLabel() {
        return this.mLabel;
    }

    @Override // android.support.v4.app.RemoteInputCompatBase.RemoteInput
    public CharSequence[] getChoices() {
        return this.mChoices;
    }

    @Override // android.support.v4.app.RemoteInputCompatBase.RemoteInput
    public boolean getAllowFreeFormInput() {
        return this.mAllowFreeFormInput;
    }

    @Override // android.support.v4.app.RemoteInputCompatBase.RemoteInput
    public Bundle getExtras() {
        return this.mExtras;
    }

    /* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/app/RemoteInput$Builder.class */
    public static final class Builder {
        private final String mResultKey;
        private CharSequence mLabel;
        private CharSequence[] mChoices;
        private boolean mAllowFreeFormInput = true;
        private Bundle mExtras = new Bundle();

        public Builder(String resultKey) {
            if (resultKey == null) {
                throw new IllegalArgumentException("Result key can't be null");
            }
            this.mResultKey = resultKey;
        }

        public Builder setLabel(CharSequence label) {
            this.mLabel = label;
            return this;
        }

        public Builder setChoices(CharSequence[] choices) {
            this.mChoices = choices;
            return this;
        }

        public Builder setAllowFreeFormInput(boolean allowFreeFormInput) {
            this.mAllowFreeFormInput = allowFreeFormInput;
            return this;
        }

        public Builder addExtras(Bundle extras) {
            if (extras != null) {
                this.mExtras.putAll(extras);
            }
            return this;
        }

        public Bundle getExtras() {
            return this.mExtras;
        }

        public RemoteInput build() {
            return new RemoteInput(this.mResultKey, this.mLabel, this.mChoices, this.mAllowFreeFormInput, this.mExtras);
        }
    }

    public static Bundle getResultsFromIntent(Intent intent) {
        return IMPL.getResultsFromIntent(intent);
    }

    public static void addResultsToIntent(RemoteInput[] remoteInputs, Intent intent, Bundle results) {
        IMPL.addResultsToIntent(remoteInputs, intent, results);
    }

    /* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/app/RemoteInput$ImplBase.class */
    static class ImplBase implements Impl {
        ImplBase() {
        }

        @Override // android.support.v4.app.RemoteInput.Impl
        public Bundle getResultsFromIntent(Intent intent) {
            Log.w(RemoteInput.TAG, "RemoteInput is only supported from API Level 16");
            return null;
        }

        @Override // android.support.v4.app.RemoteInput.Impl
        public void addResultsToIntent(RemoteInput[] remoteInputs, Intent intent, Bundle results) {
            Log.w(RemoteInput.TAG, "RemoteInput is only supported from API Level 16");
        }
    }

    /* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/app/RemoteInput$ImplJellybean.class */
    static class ImplJellybean implements Impl {
        ImplJellybean() {
        }

        @Override // android.support.v4.app.RemoteInput.Impl
        public Bundle getResultsFromIntent(Intent intent) {
            return RemoteInputCompatJellybean.getResultsFromIntent(intent);
        }

        @Override // android.support.v4.app.RemoteInput.Impl
        public void addResultsToIntent(RemoteInput[] remoteInputs, Intent intent, Bundle results) {
            RemoteInputCompatJellybean.addResultsToIntent(remoteInputs, intent, results);
        }
    }

    /* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/app/RemoteInput$ImplApi20.class */
    static class ImplApi20 implements Impl {
        ImplApi20() {
        }

        @Override // android.support.v4.app.RemoteInput.Impl
        public Bundle getResultsFromIntent(Intent intent) {
            return RemoteInputCompatApi20.getResultsFromIntent(intent);
        }

        @Override // android.support.v4.app.RemoteInput.Impl
        public void addResultsToIntent(RemoteInput[] remoteInputs, Intent intent, Bundle results) {
            RemoteInputCompatApi20.addResultsToIntent(remoteInputs, intent, results);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 20) {
            IMPL = new ImplApi20();
        } else if (Build.VERSION.SDK_INT >= 16) {
            IMPL = new ImplJellybean();
        } else {
            IMPL = new ImplBase();
        }
        FACTORY = new RemoteInputCompatBase.RemoteInput.Factory() { // from class: android.support.v4.app.RemoteInput.1
            @Override // android.support.v4.app.RemoteInputCompatBase.RemoteInput.Factory
            public RemoteInput build(String resultKey, CharSequence label, CharSequence[] choices, boolean allowFreeFormInput, Bundle extras) {
                return new RemoteInput(resultKey, label, choices, allowFreeFormInput, extras);
            }

            @Override // android.support.v4.app.RemoteInputCompatBase.RemoteInput.Factory
            public RemoteInput[] newArray(int size) {
                return new RemoteInput[size];
            }
        };
    }
}
