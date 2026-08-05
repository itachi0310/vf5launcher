package com.android.launcher6;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.View;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class ik {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static HashSet f307a = new HashSet();
    static Animator.AnimatorListener b = new il();

    public static ObjectAnimator a(View view, String str, float... fArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        objectAnimator.setTarget(view);
        objectAnimator.setPropertyName(str);
        objectAnimator.setFloatValues(fArr);
        a(objectAnimator);
        new cj(objectAnimator, view);
        return objectAnimator;
    }

    public static ObjectAnimator a(View view, PropertyValuesHolder... propertyValuesHolderArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        objectAnimator.setTarget(view);
        objectAnimator.setValues(propertyValuesHolderArr);
        a(objectAnimator);
        new cj(objectAnimator, view);
        return objectAnimator;
    }

    public static ObjectAnimator a(Object obj, View view, PropertyValuesHolder... propertyValuesHolderArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        objectAnimator.setTarget(obj);
        objectAnimator.setValues(propertyValuesHolderArr);
        a(objectAnimator);
        new cj(objectAnimator, view);
        return objectAnimator;
    }

    public static ValueAnimator a(View view, float... fArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setFloatValues(fArr);
        a(valueAnimator);
        return valueAnimator;
    }

    public static void a() {
        for (Animator animator : new HashSet(f307a)) {
            if (animator.isRunning()) {
                animator.cancel();
            } else {
                f307a.remove(animator);
            }
        }
    }

    public static void a(Animator animator) {
        animator.addListener(b);
    }

    public static void a(Animator animator, View view) {
        view.getViewTreeObserver().addOnDrawListener(new im(animator, view));
    }

    public static AnimatorSet b() {
        AnimatorSet animatorSet = new AnimatorSet();
        a(animatorSet);
        return animatorSet;
    }
}
