package com.android.launcher6;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes.dex */
public class kt extends Animator implements Animator.AnimatorListener {
    ViewPropertyAnimator b;
    View c;
    float d;
    float e;
    float f;
    float g;
    float h;
    float i;
    long j;
    long k;
    TimeInterpolator l;
    cj o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    EnumSet f360a = EnumSet.noneOf(ku.class);
    boolean n = false;
    ArrayList m = new ArrayList();

    public kt(View view) {
        this.c = view;
    }

    public kt a(float f) {
        this.f360a.add(ku.TRANSLATION_Y);
        this.e = f;
        return this;
    }

    @Override // android.animation.Animator
    public void addListener(Animator.AnimatorListener animatorListener) {
        this.m.add(animatorListener);
    }

    public kt b(float f) {
        this.f360a.add(ku.SCALE_X);
        this.f = f;
        return this;
    }

    public kt c(float f) {
        this.f360a.add(ku.SCALE_Y);
        this.g = f;
        return this;
    }

    @Override // android.animation.Animator
    public void cancel() {
        if (this.b != null) {
            this.b.cancel();
        }
    }

    @Override // android.animation.Animator
    public Animator clone() {
        throw new RuntimeException("Not implemented");
    }

    public kt d(float f) {
        this.f360a.add(ku.ALPHA);
        this.i = f;
        return this;
    }

    @Override // android.animation.Animator
    public void end() {
        throw new RuntimeException("Not implemented");
    }

    @Override // android.animation.Animator
    public long getDuration() {
        return this.k;
    }

    @Override // android.animation.Animator
    public ArrayList getListeners() {
        return this.m;
    }

    @Override // android.animation.Animator
    public long getStartDelay() {
        return this.j;
    }

    @Override // android.animation.Animator
    public boolean isRunning() {
        return this.n;
    }

    @Override // android.animation.Animator
    public boolean isStarted() {
        return this.b != null;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        for (int i = 0; i < this.m.size(); i++) {
            ((Animator.AnimatorListener) this.m.get(i)).onAnimationCancel(this);
        }
        this.n = false;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        for (int i = 0; i < this.m.size(); i++) {
            ((Animator.AnimatorListener) this.m.get(i)).onAnimationEnd(this);
        }
        this.n = false;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.m.size()) {
                return;
            }
            ((Animator.AnimatorListener) this.m.get(i2)).onAnimationRepeat(this);
            i = i2 + 1;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.o.onAnimationStart(animator);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.m.size()) {
                this.n = true;
                return;
            } else {
                ((Animator.AnimatorListener) this.m.get(i2)).onAnimationStart(this);
                i = i2 + 1;
            }
        }
    }

    @Override // android.animation.Animator
    public void removeAllListeners() {
        this.m.clear();
    }

    @Override // android.animation.Animator
    public void removeListener(Animator.AnimatorListener animatorListener) {
        this.m.remove(animatorListener);
    }

    @Override // android.animation.Animator
    public Animator setDuration(long j) {
        this.f360a.add(ku.DURATION);
        this.k = j;
        return this;
    }

    @Override // android.animation.Animator
    public void setInterpolator(TimeInterpolator timeInterpolator) {
        this.f360a.add(ku.INTERPOLATOR);
        this.l = timeInterpolator;
    }

    @Override // android.animation.Animator
    public void setStartDelay(long j) {
        this.f360a.add(ku.START_DELAY);
        this.j = j;
    }

    @Override // android.animation.Animator
    public void setTarget(Object obj) {
        throw new RuntimeException("Not implemented");
    }

    @Override // android.animation.Animator
    public void setupEndValues() {
    }

    @Override // android.animation.Animator
    public void setupStartValues() {
    }

    @Override // android.animation.Animator
    public void start() {
        this.b = this.c.animate();
        this.o = new cj(this.b, this.c);
        if (this.f360a.contains(ku.TRANSLATION_X)) {
            this.b.translationX(this.d);
        }
        if (this.f360a.contains(ku.TRANSLATION_Y)) {
            this.b.translationY(this.e);
        }
        if (this.f360a.contains(ku.SCALE_X)) {
            this.b.scaleX(this.f);
        }
        if (this.f360a.contains(ku.ROTATION_Y)) {
            this.b.rotationY(this.h);
        }
        if (this.f360a.contains(ku.SCALE_Y)) {
            this.b.scaleY(this.g);
        }
        if (this.f360a.contains(ku.ALPHA)) {
            this.b.alpha(this.i);
        }
        if (this.f360a.contains(ku.START_DELAY)) {
            this.b.setStartDelay(this.j);
        }
        if (this.f360a.contains(ku.DURATION)) {
            this.b.setDuration(this.k);
        }
        if (this.f360a.contains(ku.INTERPOLATOR)) {
            this.b.setInterpolator(this.l);
        }
        if (this.f360a.contains(ku.WITH_LAYER)) {
            this.b.withLayer();
        }
        this.b.setListener(this);
        this.b.start();
        ik.a(this);
    }
}
