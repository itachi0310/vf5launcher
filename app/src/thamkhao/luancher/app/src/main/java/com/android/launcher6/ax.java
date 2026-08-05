package com.android.launcher6;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ax implements Thread.UncaughtExceptionHandler {
    static ax g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f121a = "/sdcard/crash";
    final DateFormat b = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
    HashMap c;
    String d;
    Context e;
    Thread.UncaughtExceptionHandler f;

    public ax(Context context) {
        this.e = context.getApplicationContext();
        this.d = this.e.getPackageName().replace(".", "_");
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public static ax a(Context context) {
        if (g == null) {
            g = new ax(context);
        }
        return g;
    }

    private boolean b(Throwable th) {
        th.printStackTrace();
        if (th == null) {
            return false;
        }
        a();
        a(th);
        return true;
    }

    void a() {
        if (this.c == null) {
            this.c = new HashMap();
        }
        try {
            PackageInfo packageInfo = this.e.getPackageManager().getPackageInfo(this.e.getPackageName(), 1);
            if (packageInfo != null) {
                String str = packageInfo.versionName == null ? "null" : packageInfo.versionName;
                String string = new StringBuilder(String.valueOf(packageInfo.versionCode)).toString();
                this.c.put("versionName", str);
                this.c.put("versionCode", string);
            }
        } catch (PackageManager.NameNotFoundException e) {
        }
    }

    void a(Throwable th) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry entry : this.c.entrySet()) {
            stringBuffer.append(String.valueOf((String) entry.getKey()) + "=" + ((String) entry.getValue()) + "\n");
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
            cause.printStackTrace(printWriter);
        }
        printWriter.close();
        stringBuffer.append(stringWriter.toString());
        try {
            String str = "crash-" + this.b.format(new Date()) + "-" + this.d + ".txt";
            File file = new File("/sdcard/crash");
            if (!file.exists()) {
                file.mkdirs();
            }
            FileOutputStream fileOutputStream = new FileOutputStream("/sdcard/crash/" + str);
            fileOutputStream.write(stringBuffer.toString().getBytes());
            fileOutputStream.close();
        } catch (Exception e) {
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (b(th)) {
            Process.killProcess(Process.myPid());
            System.exit(1);
        } else {
            if (this.f == null) {
                this.f = Thread.getDefaultUncaughtExceptionHandler();
            }
            this.f.uncaughtException(thread, th);
        }
    }
}
