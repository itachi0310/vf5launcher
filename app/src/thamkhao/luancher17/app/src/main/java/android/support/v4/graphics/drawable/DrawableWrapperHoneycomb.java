package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/graphics/drawable/DrawableWrapperHoneycomb.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class DrawableWrapperHoneycomb extends DrawableWrapperDonut {
    DrawableWrapperHoneycomb(Drawable drawable) {
        super(drawable);
    }

    DrawableWrapperHoneycomb(DrawableWrapperDonut.DrawableWrapperState state, Resources resources) {
        super(state, resources);
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.mDrawable.jumpToCurrentState();
    }

    @Override // android.support.v4.graphics.drawable.DrawableWrapperDonut
    @NonNull
    DrawableWrapperDonut.DrawableWrapperState mutateConstantState() {
        return new DrawableWrapperStateHoneycomb(this.mState, null);
    }

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/graphics/drawable/DrawableWrapperHoneycomb$DrawableWrapperStateHoneycomb.class
  classes.dex
 */
    private static class DrawableWrapperStateHoneycomb extends DrawableWrapperDonut.DrawableWrapperState {
        DrawableWrapperStateHoneycomb(@Nullable DrawableWrapperDonut.DrawableWrapperState orig, @Nullable Resources res) {
            super(orig, res);
        }

        @Override // android.support.v4.graphics.drawable.DrawableWrapperDonut.DrawableWrapperState, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(@Nullable Resources res) {
            return new DrawableWrapperHoneycomb(this, res);
        }
    }
}
