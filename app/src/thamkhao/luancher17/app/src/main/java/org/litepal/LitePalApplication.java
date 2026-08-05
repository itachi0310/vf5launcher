package org.litepal;

import android.app.Application;
import android.content.Context;
import org.litepal.exceptions.GlobalException;

/* JADX INFO: loaded from: classes.dex */
public class LitePalApplication extends Application {
    static Context sContext;

    public LitePalApplication() {
        sContext = this;
    }

    @Deprecated
    public static void initialize(Context context) {
        sContext = context;
    }

    public static Context getContext() {
        if (sContext == null) {
            throw new GlobalException(GlobalException.APPLICATION_CONTEXT_IS_NULL);
        }
        return sContext;
    }
}
