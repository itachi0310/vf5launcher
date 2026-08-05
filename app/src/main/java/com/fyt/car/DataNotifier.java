package com.fyt.car;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Standard SYU DataNotifier.
 * Implements observer pattern for UI components.
 */
public class DataNotifier implements Runnable {
    private static final Handler HANDLER = new Handler(Looper.getMainLooper());
    private final ArrayList<IUiRefresher> REFRESHERS = new ArrayList<>();
    private byte[] mByts;
    private float[] mFlts;
    private int[] mInts;
    private long[] mLngs;
    private String[] mStrs;

    public synchronized void set(int[] ints, long[] lngs, float[] flts, String[] strs, byte[] byts) {
        boolean equal = true;
        if (!Arrays.equals(this.mInts, ints)) equal = false;
        if (equal && !Arrays.equals(this.mFlts, flts)) equal = false;
        if (equal && !Arrays.equals(this.mStrs, strs)) equal = false;
        if (equal && !Arrays.equals(this.mByts, byts)) equal = false;
        if (equal && !Arrays.equals(this.mLngs, lngs)) equal = false;

        this.mInts = ints;
        this.mFlts = flts;
        this.mStrs = strs;
        this.mByts = byts;
        this.mLngs = lngs;

        if (!equal) {
            HANDLER.post(this);
        }
    }

    public synchronized void addUiRefresher(IUiRefresher refresher, boolean refresh) {
        if (refresher != null && !this.REFRESHERS.contains(refresher)) {
            this.REFRESHERS.add(refresher);
            if (refresh) {
                refresher.onRefresh(this.mInts, this.mLngs, this.mFlts, this.mStrs, this.mByts);
            }
        }
    }

    public synchronized void removeUiRefresher(IUiRefresher refresher) {
        if (refresher != null) {
            this.REFRESHERS.remove(refresher);
        }
    }

    @Override
    public synchronized void run() {
        for (IUiRefresher refresher : this.REFRESHERS) {
            refresher.onRefresh(this.mInts, this.mLngs, this.mFlts, this.mStrs, this.mByts);
        }
    }
}
