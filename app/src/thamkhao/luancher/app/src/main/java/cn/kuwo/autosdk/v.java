package cn.kuwo.autosdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;

/* JADX INFO: loaded from: classes.dex */
public class v implements Parcelable {
    public static final Parcelable.Creator f = new w();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f40a;
    public final int b;
    public final int c;
    public final int d;
    public final String e;

    private v(Parcel parcel) {
        this.f40a = parcel.readString();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.e = parcel.readString();
    }

    /* synthetic */ v(Parcel parcel, v vVar) {
        this(parcel);
    }

    private v(String str) {
        String[] strArrSplit = str.split("\\s+");
        this.f40a = strArrSplit[0];
        this.b = Process.getUidForName(this.f40a);
        this.c = Integer.parseInt(strArrSplit[1]);
        this.d = Integer.parseInt(strArrSplit[2]);
        if (strArrSplit.length == 16) {
            this.e = strArrSplit[13];
        } else {
            this.e = strArrSplit[14];
        }
    }

    /* synthetic */ v(String str, v vVar) {
        this(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f40a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeString(this.e);
    }
}
