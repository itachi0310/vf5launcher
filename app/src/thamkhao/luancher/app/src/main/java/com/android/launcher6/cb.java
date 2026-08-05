package com.android.launcher6;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes.dex */
class cb implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ca f147a;
    private final /* synthetic */ float b;
    private final /* synthetic */ float c;
    private final /* synthetic */ float d;
    private final /* synthetic */ float e;

    cb(ca caVar, float f, float f2, float f3, float f4) {
        this.f147a = caVar;
        this.b = f;
        this.c = f2;
        this.d = f3;
        this.e = f4;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        int i = (int) ((this.b * fFloatValue) - this.f147a.m);
        int i2 = (int) ((this.c * fFloatValue) - this.f147a.n);
        this.f147a.m += i;
        this.f147a.n += i2;
        this.f147a.setScaleX(this.d + ((this.e - this.d) * fFloatValue));
        this.f147a.setScaleY(this.d + ((this.e - this.d) * fFloatValue));
        if (ca.b != 1.0f) {
            this.f147a.setAlpha((1.0f - fFloatValue) + (ca.b * fFloatValue));
        }
        if (this.f147a.getParent() == null) {
            valueAnimator.cancel();
            return;
        }
        this.f147a.setTranslationX(i + this.f147a.getTranslationX());
        this.f147a.setTranslationY(this.f147a.getTranslationY() + i2);
    }
}
