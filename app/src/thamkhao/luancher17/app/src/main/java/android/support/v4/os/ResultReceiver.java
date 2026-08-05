package android.support.v4.os;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/os/ResultReceiver.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
public class ResultReceiver implements Parcelable {
    public static final Parcelable.Creator<ResultReceiver> CREATOR = new Parcelable.Creator<ResultReceiver>() { // from class: android.support.v4.os.ResultReceiver.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ResultReceiver createFromParcel(Parcel in) {
            return new ResultReceiver(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ResultReceiver[] newArray(int size) {
            return new ResultReceiver[size];
        }
    };
    final Handler mHandler;
    final boolean mLocal;
    IResultReceiver mReceiver;

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/os/ResultReceiver$MyRunnable.class
  classes.dex
 */
    class MyRunnable implements Runnable {
        final int mResultCode;
        final Bundle mResultData;

        MyRunnable(int resultCode, Bundle resultData) {
            this.mResultCode = resultCode;
            this.mResultData = resultData;
        }

        @Override // java.lang.Runnable
        public void run() {
            ResultReceiver.this.onReceiveResult(this.mResultCode, this.mResultData);
        }
    }

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/os/ResultReceiver$MyResultReceiver.class
  classes.dex
 */
    class MyResultReceiver extends IResultReceiver.Stub {
        MyResultReceiver() {
        }

        @Override // android.support.v4.os.IResultReceiver
        public void send(int resultCode, Bundle resultData) {
            if (ResultReceiver.this.mHandler != null) {
                ResultReceiver.this.mHandler.post(ResultReceiver.this.new MyRunnable(resultCode, resultData));
            } else {
                ResultReceiver.this.onReceiveResult(resultCode, resultData);
            }
        }
    }

    public ResultReceiver(Handler handler) {
        this.mLocal = true;
        this.mHandler = handler;
    }

    public void send(int resultCode, Bundle resultData) {
        if (this.mLocal) {
            if (this.mHandler != null) {
                this.mHandler.post(new MyRunnable(resultCode, resultData));
                return;
            } else {
                onReceiveResult(resultCode, resultData);
                return;
            }
        }
        if (this.mReceiver != null) {
            try {
                this.mReceiver.send(resultCode, resultData);
            } catch (RemoteException e) {
            }
        }
    }

    protected void onReceiveResult(int resultCode, Bundle resultData) {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        synchronized (this) {
            if (this.mReceiver == null) {
                this.mReceiver = new MyResultReceiver();
            }
            out.writeStrongBinder(this.mReceiver.asBinder());
        }
    }

    ResultReceiver(Parcel in) {
        this.mLocal = false;
        this.mHandler = null;
        this.mReceiver = IResultReceiver.Stub.asInterface(in.readStrongBinder());
    }
}
