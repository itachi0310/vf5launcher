package com.android.launcher17;

import android.content.Intent;
import android.util.Log;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class Stats {
    public static final String ACTION_LAUNCH = "com.android.launcher17.action.LAUNCH";
    private static final boolean DEBUG_BROADCASTS = false;
    public static final String EXTRA_CELLX = "cellX";
    public static final String EXTRA_CELLY = "cellY";
    public static final String EXTRA_CONTAINER = "container";
    public static final String EXTRA_INTENT = "intent";
    public static final String EXTRA_SCREEN = "screen";
    private static final boolean FLUSH_IMMEDIATELY = true;
    private static final int INITIAL_STATS_SIZE = 100;
    private static final boolean LOCAL_LAUNCH_LOG = true;
    private static final String LOG_FILE_NAME = "launches.log";
    private static final int LOG_TAG_LAUNCH = 4096;
    private static final int LOG_TAG_VERSION = 1;
    private static final int LOG_VERSION = 1;
    public static final String PERM_LAUNCH = "com.android.launcher17.permission.RECEIVE_LAUNCH_BROADCASTS";
    private static final String STATS_FILE_NAME = "stats.log";
    private static final int STATS_VERSION = 1;
    private static final String TAG = "Launcher3/Stats";
    ArrayList<Integer> mHistogram;
    ArrayList<String> mIntents;
    private final Launcher mLauncher;
    DataOutputStream mLog;

    public Stats(Launcher launcher) throws Throwable {
        this.mLauncher = launcher;
        loadStats();
        try {
            this.mLog = new DataOutputStream(this.mLauncher.openFileOutput(LOG_FILE_NAME, 32768));
            this.mLog.writeInt(1);
            this.mLog.writeInt(1);
        } catch (FileNotFoundException e) {
            Log.e(TAG, "unable to create stats log: " + e);
            this.mLog = null;
        } catch (IOException e2) {
            Log.e(TAG, "unable to write to stats log: " + e2);
            this.mLog = null;
        }
    }

    public void incrementLaunch(String intentStr) {
        int pos = this.mIntents.indexOf(intentStr);
        if (pos < 0) {
            this.mIntents.add(intentStr);
            this.mHistogram.add(1);
        } else {
            this.mHistogram.set(pos, Integer.valueOf(this.mHistogram.get(pos).intValue() + 1));
        }
    }

    public void recordLaunch(Intent intent) {
        recordLaunch(intent, null);
    }

    public void recordLaunch(Intent intent, ShortcutInfo shortcut) throws Throwable {
        Intent intent2 = new Intent(intent);
        intent2.setSourceBounds(null);
        String flat = intent2.toUri(0);
        Intent broadcastIntent = new Intent(ACTION_LAUNCH).putExtra("intent", flat);
        if (shortcut != null) {
            broadcastIntent.putExtra(EXTRA_CONTAINER, shortcut.container).putExtra(EXTRA_SCREEN, shortcut.screenId).putExtra(EXTRA_CELLX, shortcut.cellX).putExtra(EXTRA_CELLY, shortcut.cellY);
        }
        this.mLauncher.sendBroadcast(broadcastIntent, "com.android.launcher17.permission.RECEIVE_LAUNCH_BROADCASTS");
        incrementLaunch(flat);
        saveStats();
        if (this.mLog != null) {
            try {
                this.mLog.writeInt(4096);
                this.mLog.writeLong(System.currentTimeMillis());
                if (shortcut == null) {
                    this.mLog.writeShort(0);
                    this.mLog.writeShort(0);
                    this.mLog.writeShort(0);
                    this.mLog.writeShort(0);
                } else {
                    this.mLog.writeShort((short) shortcut.container);
                    this.mLog.writeShort((short) shortcut.screenId);
                    this.mLog.writeShort((short) shortcut.cellX);
                    this.mLog.writeShort((short) shortcut.cellY);
                }
                this.mLog.writeUTF(flat);
                this.mLog.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveStats() throws Throwable {
        DataOutputStream stats = null;
        try {
            try {
                DataOutputStream stats2 = new DataOutputStream(this.mLauncher.openFileOutput("stats.log.tmp", 0));
                try {
                    stats2.writeInt(1);
                    int N = this.mHistogram.size();
                    stats2.writeInt(N);
                    for (int i = 0; i < N; i++) {
                        stats2.writeUTF(this.mIntents.get(i));
                        stats2.writeInt(this.mHistogram.get(i).intValue());
                    }
                    stats2.close();
                    stats = null;
                    this.mLauncher.getFileStreamPath("stats.log.tmp").renameTo(this.mLauncher.getFileStreamPath(STATS_FILE_NAME));
                    if (0 != 0) {
                        try {
                            stats.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (FileNotFoundException e2) {
                    e = e2;
                    stats = stats2;
                    Log.e(TAG, "unable to create stats data: " + e);
                    if (stats != null) {
                        try {
                            stats.close();
                        } catch (IOException e3) {
                        }
                    }
                } catch (IOException e4) {
                    e = e4;
                    stats = stats2;
                    Log.e(TAG, "unable to write to stats data: " + e);
                    if (stats != null) {
                        try {
                            stats.close();
                        } catch (IOException e5) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    stats = stats2;
                    if (stats != null) {
                        try {
                            stats.close();
                        } catch (IOException e6) {
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e7) {
                e = e7;
            } catch (IOException e8) {
                e = e8;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void loadStats() throws Throwable {
        this.mIntents = new ArrayList<>(100);
        this.mHistogram = new ArrayList<>(100);
        DataInputStream stats = null;
        try {
            DataInputStream stats2 = new DataInputStream(this.mLauncher.openFileInput(STATS_FILE_NAME));
            try {
                int version = stats2.readInt();
                if (version == 1) {
                    int N = stats2.readInt();
                    for (int i = 0; i < N; i++) {
                        String pkg = stats2.readUTF();
                        int count = stats2.readInt();
                        this.mIntents.add(pkg);
                        this.mHistogram.add(Integer.valueOf(count));
                    }
                }
                if (stats2 != null) {
                    try {
                        stats2.close();
                    } catch (IOException e) {
                    }
                }
            } catch (FileNotFoundException e2) {
                stats = stats2;
                if (stats != null) {
                    try {
                        stats.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (IOException e4) {
                stats = stats2;
                if (stats != null) {
                    try {
                        stats.close();
                    } catch (IOException e5) {
                    }
                }
            } catch (Throwable th) {
                th = th;
                stats = stats2;
                if (stats != null) {
                    try {
                        stats.close();
                    } catch (IOException e6) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e7) {
        } catch (IOException e8) {
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
