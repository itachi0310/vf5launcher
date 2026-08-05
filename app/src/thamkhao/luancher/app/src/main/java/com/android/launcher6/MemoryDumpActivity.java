package com.android.launcher6;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.os.Environment;
import android.os.Process;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes.dex */
public class MemoryDumpActivity extends Activity {
    /* JADX WARN: Code duplicated, block: B:60:0x0086 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static String a(ArrayList arrayList) throws Throwable {
        ZipOutputStream zipOutputStream;
        ZipOutputStream zipOutputStream2;
        BufferedInputStream bufferedInputStream;
        byte[] bArr = new byte[262144];
        String str = String.format("%s/hprof-%d.zip", Environment.getExternalStorageDirectory(), Long.valueOf(System.currentTimeMillis()));
        try {
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(str)));
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    try {
                        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(str2));
                        try {
                            zipOutputStream.putNextEntry(new ZipEntry(str2));
                            while (true) {
                                int i = bufferedInputStream2.read(bArr, 0, 262144);
                                if (i <= 0) {
                                    break;
                                }
                                zipOutputStream.write(bArr, 0, i);
                            }
                            zipOutputStream.closeEntry();
                            bufferedInputStream2.close();
                        } catch (Throwable th) {
                            th = th;
                            bufferedInputStream = bufferedInputStream2;
                            bufferedInputStream.close();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedInputStream = null;
                    }
                }
                if (zipOutputStream != null) {
                    try {
                        zipOutputStream.close();
                    } catch (IOException e) {
                    }
                }
                return str;
            } catch (IOException e2) {
                e = e2;
                zipOutputStream2 = zipOutputStream;
                try {
                    Log.e("MemoryDumpActivity", "error zipping up profile data", e);
                    if (zipOutputStream2 != null) {
                        try {
                            zipOutputStream2.close();
                        } catch (IOException e3) {
                        }
                    }
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    zipOutputStream = zipOutputStream2;
                    if (zipOutputStream != null) {
                        try {
                            zipOutputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                if (zipOutputStream != null) {
                    zipOutputStream.close();
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            zipOutputStream2 = null;
        } catch (Throwable th5) {
            th = th5;
            zipOutputStream = null;
        }
    }

    public static void a(Context context) {
        a(context, (Runnable) null);
    }

    public static void a(Context context, MemoryTracker memoryTracker) {
        String str;
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        int iMyPid = Process.myPid();
        int[] iArrA = memoryTracker.a();
        int[] iArrCopyOf = Arrays.copyOf(iArrA, iArrA.length);
        for (int i : iArrCopyOf) {
            ld ldVarA = memoryTracker.a(i);
            if (ldVarA != null) {
                sb.append("pid ").append(i).append(":").append(" up=").append(ldVarA.a()).append(" pss=").append(ldVarA.d).append(" uss=").append(ldVarA.e).append("\n");
            }
            if (i == iMyPid) {
                String str2 = String.format("%s/launcher-memory-%d.ahprof", Environment.getExternalStorageDirectory(), Integer.valueOf(i));
                Log.v("MemoryDumpActivity", "Dumping memory info for process " + i + " to " + str2);
                try {
                    Debug.dumpHprofData(str2);
                } catch (IOException e) {
                    Log.e("MemoryDumpActivity", "error dumping memory:", e);
                }
                arrayList.add(str2);
            }
        }
        String strA = a(arrayList);
        if (strA == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("application/zip");
        PackageManager packageManager = context.getPackageManager();
        intent.putExtra("android.intent.extra.SUBJECT", String.format("Launcher memory dump (%d)", Integer.valueOf(iMyPid)));
        try {
            str = packageManager.getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            str = "?";
        }
        sb.append("\nApp version: ").append(str).append("\nBuild: ").append(Build.DISPLAY).append("\n");
        intent.putExtra("android.intent.extra.TEXT", sb.toString());
        intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(strA)));
        context.startActivity(intent);
    }

    public static void a(Context context, Runnable runnable) {
        la laVar = new la(context, runnable);
        Log.v("MemoryDumpActivity", "attempting to bind to memory tracker");
        context.bindService(new Intent(context, (Class<?>) MemoryTracker.class), laVar, 1);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        a(this, new kz(this));
    }
}
