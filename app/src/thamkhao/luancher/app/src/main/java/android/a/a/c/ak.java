package android.a.a.c;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class ak extends ViewGroup.LayoutParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f13a;
    public int b;
    float c;
    boolean d;
    int e;
    int f;

    public ak() {
        super(-1, -1);
        this.c = 0.0f;
    }

    public ak(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = 0.0f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, af.f11a);
        this.b = typedArrayObtainStyledAttributes.getInteger(0, 48);
        typedArrayObtainStyledAttributes.recycle();
    }
}
