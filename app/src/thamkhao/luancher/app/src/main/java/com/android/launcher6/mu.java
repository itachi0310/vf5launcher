package com.android.launcher6;

import android.content.Intent;
import android.util.Log;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class mu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    DataOutputStream f401a;
    ArrayList b;
    ArrayList c;
    private final Launcher d;

    public mu(Launcher launcher) throws Throwable {
        this.d = launcher;
        b();
        try {
            this.f401a = new DataOutputStream(this.d.openFileOutput("launches.log", 32768));
            this.f401a.writeInt(1);
            this.f401a.writeInt(1);
        } catch (FileNotFoundException e) {
            Log.e("Launcher3/Stats", "unable to create stats log: " + e);
            this.f401a = null;
        } catch (IOException e2) {
            Log.e("Launcher3/Stats", "unable to write to stats log: " + e2);
            this.f401a = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:53:0x009b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private void a() throws Throwable {
        DataOutputStream dataOutputStream;
        DataOutputStream dataOutputStream2 = null;
        try {
            try {
                dataOutputStream = new DataOutputStream(this.d.openFileOutput("stats.log.tmp", 0));
                try {
                    dataOutputStream.writeInt(1);
                    int size = this.c.size();
                    dataOutputStream.writeInt(size);
                    for (int i = 0; i < size; i++) {
                        dataOutputStream.writeUTF((String) this.b.get(i));
                        dataOutputStream.writeInt(((Integer) this.c.get(i)).intValue());
                    }
                    dataOutputStream.close();
                    DataOutputStream dataOutputStream3 = null;
                    this.d.getFileStreamPath("stats.log.tmp").renameTo(this.d.getFileStreamPath("stats.log"));
                    if (0 != 0) {
                        try {
                            dataOutputStream3.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (FileNotFoundException e2) {
                    e = e2;
                    Log.e("Launcher3/Stats", "unable to create stats data: " + e);
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                } catch (IOException e4) {
                    e = e4;
                    Log.e("Launcher3/Stats", "unable to write to stats data: " + e);
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                }
            } catch (FileNotFoundException e6) {
                e = e6;
                dataOutputStream = null;
            } catch (IOException e7) {
                e = e7;
                dataOutputStream = null;
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        dataOutputStream2.close();
                    } catch (IOException e8) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
                dataOutputStream2.close();
            }
            throw th;
        }
    }

    private void b() throws Throwable {
        DataInputStream dataInputStream;
        this.b = new ArrayList(100);
        this.c = new ArrayList(100);
        DataInputStream dataInputStream2 = null;
        try {
            dataInputStream = new DataInputStream(this.d.openFileInput("stats.log"));
            try {
                if (dataInputStream.readInt() == 1) {
                    int i = dataInputStream.readInt();
                    for (int i2 = 0; i2 < i; i2++) {
                        String utf = dataInputStream.readUTF();
                        int i3 = dataInputStream.readInt();
                        this.b.add(utf);
                        this.c.add(Integer.valueOf(i3));
                    }
                }
                if (dataInputStream != null) {
                    try {
                        dataInputStream.close();
                    } catch (IOException e) {
                    }
                }
            } catch (FileNotFoundException e2) {
                if (dataInputStream != null) {
                    try {
                        dataInputStream.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (IOException e4) {
                if (dataInputStream != null) {
                    try {
                        dataInputStream.close();
                    } catch (IOException e5) {
                    }
                }
            } catch (Throwable th) {
                dataInputStream2 = dataInputStream;
                th = th;
                if (dataInputStream2 != null) {
                    try {
                        dataInputStream2.close();
                    } catch (IOException e6) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e7) {
            dataInputStream = null;
        } catch (IOException e8) {
            dataInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void a(Intent intent) {
        a(intent, null);
    }

    public void a(Intent intent, mp mpVar) {
        Intent intent2 = new Intent(intent);
        intent2.setSourceBounds(null);
        String uri = intent2.toUri(0);
        Intent intentPutExtra = new Intent("com.android.launcher6.action.LAUNCH").putExtra("intent", uri);
        if (mpVar != null) {
            intentPutExtra.putExtra("container", mpVar.h).putExtra("screen", mpVar.i).putExtra("cellX", mpVar.j).putExtra("cellY", mpVar.k);
        }
        this.d.sendBroadcast(intentPutExtra, "com.android.launcher6.permission.RECEIVE_LAUNCH_BROADCASTS");
        a(uri);
        a();
        if (this.f401a != null) {
            try {
                this.f401a.writeInt(4096);
                this.f401a.writeLong(System.currentTimeMillis());
                if (mpVar == null) {
                    this.f401a.writeShort(0);
                    this.f401a.writeShort(0);
                    this.f401a.writeShort(0);
                    this.f401a.writeShort(0);
                } else {
                    this.f401a.writeShort((short) mpVar.h);
                    this.f401a.writeShort((short) mpVar.i);
                    this.f401a.writeShort((short) mpVar.j);
                    this.f401a.writeShort((short) mpVar.k);
                }
                this.f401a.writeUTF(uri);
                this.f401a.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void a(String str) {
        int iIndexOf = this.b.indexOf(str);
        if (iIndexOf >= 0) {
            this.c.set(iIndexOf, Integer.valueOf(((Integer) this.c.get(iIndexOf)).intValue() + 1));
        } else {
            this.b.add(str);
            this.c.add(1);
        }
    }
}
