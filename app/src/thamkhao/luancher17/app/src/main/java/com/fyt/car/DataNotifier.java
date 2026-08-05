package com.fyt.car;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class DataNotifier implements Runnable {
    private static final Handler HANDLER = new Handler(Looper.getMainLooper());
    private final ArrayList<IUiRefresher> REFRESHERS = new ArrayList<>();
    private byte[] mByts;
    private float[] mFlts;
    private int[] mInts;
    private long[] mLngs;
    private String[] mStrs;

    /* JADX WARN: Code duplicated, block: B:26:0x0045 A[Catch: all -> 0x004c, TRY_LEAVE, TryCatch #0 {, blocks: (B:5:0x0004, B:9:0x000f, B:13:0x001a, B:17:0x0025, B:21:0x0030, B:24:0x0039, B:26:0x0045), top: B:32:0x0004 }] */
    public synchronized void set(int[] ints, long[] lngs, float[] flts, String[] strs, byte[] byts) {
        boolean equal = true;
        if (1 != 0) {
            if (!Arrays.equals(this.mInts, ints)) {
                equal = false;
            }
            if (equal && !Arrays.equals(this.mFlts, flts)) {
                equal = false;
            }
            if (equal && !Arrays.equals(this.mStrs, strs)) {
                equal = false;
            }
            if (equal && !Arrays.equals(this.mByts, byts)) {
                equal = false;
            }
            if (equal && !Arrays.equals(this.mLngs, lngs)) {
                equal = false;
            }
            this.mInts = ints;
            this.mFlts = flts;
            this.mStrs = strs;
            this.mByts = byts;
            this.mLngs = lngs;
            if (!equal) {
                HANDLER.post(this);
            }
        } else {
            if (equal) {
                equal = false;
            }
            if (equal) {
                equal = false;
            }
            if (equal) {
                equal = false;
            }
            if (equal) {
                equal = false;
            }
            this.mInts = ints;
            this.mFlts = flts;
            this.mStrs = strs;
            this.mByts = byts;
            this.mLngs = lngs;
            if (!equal) {
                HANDLER.post(this);
            }
        }
        throw th;
    }

    public synchronized void addUiRefresher(IUiRefresher refresher, boolean refresh) {
        if (refresher != null) {
            if (!this.REFRESHERS.contains(refresher)) {
                this.REFRESHERS.add(refresher);
                if (refresh) {
                    refresher.onRefresh(this.mInts, this.mLngs, this.mFlts, this.mStrs, this.mByts);
                }
            }
        }
    }

    public synchronized void refrseh(IUiRefresher refresher) {
        if (refresher != null) {
            refresher.onRefresh(this.mInts, this.mLngs, this.mFlts, this.mStrs, this.mByts);
        }
    }

    public synchronized void removeUiRefresher(IUiRefresher refresher) {
        if (refresher != null) {
            this.REFRESHERS.remove(refresher);
        }
    }

    public synchronized void clearUiRefresher(IUiRefresher refresher) {
        this.REFRESHERS.clear();
    }

    @Override // java.lang.Runnable
    public synchronized void run() {
        for (IUiRefresher refresher : this.REFRESHERS) {
            refresher.onRefresh(this.mInts, this.mLngs, this.mFlts, this.mStrs, this.mByts);
        }
    }
}
