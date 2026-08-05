package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/graphics/drawable/DrawableWrapperEclair.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class DrawableWrapperEclair extends DrawableWrapperDonut {
    DrawableWrapperEclair(Drawable drawable) {
        super(drawable);
    }

    DrawableWrapperEclair(DrawableWrapperDonut.DrawableWrapperState state, Resources resources) {
        super(state, resources);
    }

    @Override // android.support.v4.graphics.drawable.DrawableWrapperDonut
    DrawableWrapperDonut.DrawableWrapperState mutateConstantState() {
        return new DrawableWrapperStateEclair(this.mState, null);
    }

    @Override // android.support.v4.graphics.drawable.DrawableWrapperDonut
    protected Drawable newDrawableFromState(Drawable.ConstantState state, Resources res) {
        return state.newDrawable(res);
    }

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/graphics/drawable/DrawableWrapperEclair$DrawableWrapperStateEclair.class
  classes.dex
 */
    private static class DrawableWrapperStateEclair extends DrawableWrapperDonut.DrawableWrapperState {
        DrawableWrapperStateEclair(@Nullable DrawableWrapperDonut.DrawableWrapperState orig, @Nullable Resources res) {
            super(orig, res);
        }

        @Override // android.support.v4.graphics.drawable.DrawableWrapperDonut.DrawableWrapperState, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(@Nullable Resources res) {
            return new DrawableWrapperEclair(this, res);
        }
    }
}
