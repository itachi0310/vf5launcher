package com.syu.i;

import android.content.res.AssetManager;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class n extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ e f553a;

    public n(e eVar) {
        this.f553a = eVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws Throwable {
        InputStream inputStreamOpen;
        InputStream inputStreamOpen2;
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        byteArrayOutputStream2 = null;
        inputStream = null;
        byteArrayOutputStream2 = null;
        InputStream inputStream2 = null;
        try {
            AssetManager assets = this.f553a.b.getResources().getAssets();
            inputStreamOpen2 = assets.open("CHN_adm2.shx");
            try {
                com.syu.b.d dVarA = com.syu.b.e.a(new DataInputStream(inputStreamOpen2));
                inputStreamOpen = assets.open("CHN_adm2.shp");
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int i = inputStreamOpen.read(bArr);
                            if (i == -1) {
                                com.syu.b.b.f510a = new com.syu.b.c(byteArrayOutputStream.toByteArray(), dVarA);
                                try {
                                    inputStreamOpen2.close();
                                    inputStreamOpen.close();
                                    byteArrayOutputStream.close();
                                    return;
                                } catch (IOException e) {
                                    e.printStackTrace();
                                    return;
                                }
                            }
                            byteArrayOutputStream.write(bArr, 0, i);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        inputStream2 = inputStreamOpen;
                        inputStream = inputStreamOpen2;
                        try {
                            Log.i("hzq", Log.getStackTraceString(e));
                            try {
                                inputStream.close();
                                inputStream2.close();
                                byteArrayOutputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStreamOpen2 = inputStream;
                            inputStreamOpen = inputStream2;
                            byteArrayOutputStream2 = byteArrayOutputStream;
                            try {
                                inputStreamOpen2.close();
                                inputStreamOpen.close();
                                byteArrayOutputStream2.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        inputStreamOpen2.close();
                        inputStreamOpen.close();
                        byteArrayOutputStream2.close();
                        throw th;
                    }
                } catch (Exception e5) {
                    e = e5;
                    byteArrayOutputStream = null;
                    inputStream2 = inputStreamOpen;
                    inputStream = inputStreamOpen2;
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Exception e6) {
                e = e6;
                byteArrayOutputStream = null;
                inputStream = inputStreamOpen2;
            } catch (Throwable th4) {
                th = th4;
                inputStreamOpen = null;
            }
        } catch (Exception e7) {
            e = e7;
            byteArrayOutputStream = null;
            inputStream = null;
        } catch (Throwable th5) {
            th = th5;
            inputStreamOpen = null;
            inputStreamOpen2 = null;
        }
    }
}
