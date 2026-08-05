package android.a.a.c;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class ap extends View.BaseSavedState {
    public static final Parcelable.Creator CREATOR = android.a.a.a.a.a(new aq());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f15a;
    Parcelable b;
    ClassLoader c;

    ap(Parcel parcel, ClassLoader classLoader) {
        super(parcel);
        classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
        this.f15a = parcel.readInt();
        this.b = parcel.readParcelable(classLoader);
        this.c = classLoader;
    }

    public ap(Parcelable parcelable) {
        super(parcelable);
    }

    public String toString() {
        return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f15a + "}";
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f15a);
        parcel.writeParcelable(this.b, i);
    }
}
