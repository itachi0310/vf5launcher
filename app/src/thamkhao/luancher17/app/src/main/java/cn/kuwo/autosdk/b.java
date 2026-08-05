package cn.kuwo.autosdk;

import android.os.Handler;
import android.support.v4.os.EnvironmentCompat;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.http.HttpVersion;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public class b implements Runnable {
    static String a = "HttpSession";
    static long b = Long.MAX_VALUE;
    static final AtomicLong c = new AtomicLong();
    static Proxy d = Proxy.NO_PROXY;
    public static int e = 8192;
    boolean i;
    byte[] j;
    String k;
    int l;
    long m;
    Proxy o;
    volatile boolean p;
    volatile boolean q;
    int r;
    HttpURLConnection t;
    InputStream u;
    OutputStream v;
    ByteArrayOutputStream w;
    f x;
    d f = new d(this);
    String g = "";
    Map h = new HashMap();
    boolean n = true;
    Handler y = null;
    a z = new a();
    long s = Thread.currentThread().getId();

    public b() {
        a("Accept", "*/*");
        a(HTTP.CONN_DIRECTIVE, HTTP.CONN_CLOSE);
    }

    private void a(Handler handler, Runnable runnable) {
        if (handler == null) {
            return;
        }
        if (handler.getLooper().getThread().getId() == Thread.currentThread().getId()) {
            runnable.run();
        } else {
            handler.post(runnable);
        }
    }

    public a a(String str) {
        this.g = str;
        return d();
    }

    void a(int i, int i2, byte[] bArr, int i3) {
        if (this.x == null || this.y == null) {
            return;
        }
        a(this.y, this.f.a(i, i2, bArr, i3));
    }

    public void a(long j) {
        this.m = j;
    }

    void a(e eVar, int i) {
        if (this.x == null || this.y == null) {
            return;
        }
        a(this.y, new c(this, eVar, i));
    }

    public void a(String str, String str2) {
        this.h.put(str, str2);
    }

    boolean a() {
        if (TextUtils.isEmpty(this.g) || this.g.length() > e) {
            return false;
        }
        if ((this.i && this.j == null) || Thread.currentThread().getId() != this.s) {
            return false;
        }
        this.r++;
        return 1 == this.r;
    }

    boolean a(byte[] bArr, int i, int i2) throws Throwable {
        RandomAccessFile randomAccessFile;
        if (this.k != null) {
            RandomAccessFile randomAccessFile2 = null;
            try {
                randomAccessFile = new RandomAccessFile(this.k, "rw");
                try {
                    randomAccessFile.seek(i2);
                    randomAccessFile.write(bArr, 0, i);
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e2) {
                        }
                    }
                } catch (IOException e3) {
                    if (randomAccessFile == null) {
                        return false;
                    }
                    try {
                        randomAccessFile.close();
                        return false;
                    } catch (IOException e4) {
                        return false;
                    }
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile2 = randomAccessFile;
                    if (randomAccessFile2 != null) {
                        try {
                            randomAccessFile2.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e6) {
                randomAccessFile = null;
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return true;
    }

    boolean b() {
        String str = this.g;
        if (!this.g.toUpperCase().startsWith(HttpVersion.HTTP)) {
            str = "http://" + this.g;
        }
        try {
            try {
                try {
                    this.t = (HttpURLConnection) new URL(str).openConnection(this.o == null ? d : this.o);
                    this.t.setInstanceFollowRedirects(true);
                    if (this.h != null) {
                        for (String str2 : this.h.keySet()) {
                            this.t.setRequestProperty(str2, (String) this.h.get(str2));
                        }
                    }
                    if (((int) this.m) != 0) {
                        if (((int) this.m) <= 0) {
                            this.z.g = "connect timeout";
                            return false;
                        }
                        this.t.setConnectTimeout((int) this.m);
                    }
                    if (!this.i) {
                        try {
                            this.t.connect();
                            this.z.m = System.currentTimeMillis() - this.z.e;
                        } catch (IOException e2) {
                            this.z.g = "connect failed";
                            return false;
                        }
                    } else if (this.j != null) {
                        this.t.setDoOutput(true);
                        this.t.setDoInput(true);
                        try {
                            this.v = new BufferedOutputStream(this.t.getOutputStream());
                            this.v.write(this.j);
                            this.v.flush();
                        } catch (IOException e3) {
                            this.z.g = "post write failed";
                            return false;
                        }
                    }
                    return true;
                } catch (IOException e4) {
                    e4.printStackTrace();
                    this.z.g = "connect error";
                    return false;
                }
            } catch (Exception e5) {
                if (!this.p) {
                    this.z.g = EnvironmentCompat.MEDIA_UNKNOWN;
                }
                return false;
            }
        } catch (MalformedURLException e6) {
            e6.printStackTrace();
            this.z.g = "url error";
            return false;
        }
    }

    synchronized void c() {
        try {
            if (this.w != null) {
                this.w.close();
            }
        } catch (IOException e2) {
        }
        try {
            if (this.v != null) {
                this.v.close();
            }
        } catch (IOException e3) {
        }
        try {
            if (this.u != null) {
                this.u.close();
            }
        } catch (IOException e4) {
        }
        try {
            if (this.t != null) {
                this.t.disconnect();
            }
        } catch (Throwable th) {
            this.t = null;
        }
    }

    a d() {
        if (!a()) {
            this.z.b = -1;
            return this.z;
        }
        this.z.k = this.g;
        if (this.p) {
            this.z.g = "user cancel";
            this.z.b = -3;
            return this.z;
        }
        if (this.n && c.get() > b) {
            this.z.g = "flow limit";
            this.z.b = -4;
            return this.z;
        }
        if (!b()) {
            return this.z;
        }
        try {
            if (this.p) {
                this.z.g = "user cancel";
                this.z.b = -3;
                return this.z;
            }
            try {
                this.z.b = this.t.getResponseCode();
                if (this.z.b != 200 && this.z.b != 201 && this.z.b != 206) {
                    this.z.g = "resqonse code error ";
                    a aVar = this.z;
                    this.z.f = System.currentTimeMillis() - this.z.d;
                    this.q = true;
                    c();
                    return aVar;
                }
                this.u = new BufferedInputStream(this.t.getInputStream());
                this.w = new ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[4096];
                    if (((int) this.m) > 0) {
                        this.t.setReadTimeout((int) this.m);
                    }
                    while (true) {
                        int i = this.u.read(bArr, 0, 4096);
                        if (i <= 0 || this.p) {
                            break;
                        }
                        if (this.n) {
                            c.set(c.get() + ((long) i));
                        }
                        try {
                            this.w.write(bArr, 0, i);
                        } catch (OutOfMemoryError e2) {
                            this.z.b = -5;
                            this.z.g = "write data failed";
                            a aVar2 = this.z;
                            this.z.f = System.currentTimeMillis() - this.z.d;
                            this.q = true;
                            c();
                            return aVar2;
                        }
                    }
                    if (this.p) {
                        this.z.g = "user cancel";
                        this.z.b = -3;
                        a aVar3 = this.z;
                        this.z.f = System.currentTimeMillis() - this.z.d;
                        this.q = true;
                        c();
                        return aVar3;
                    }
                    this.z.n = (System.currentTimeMillis() - this.z.e) - this.z.m;
                    try {
                        this.z.c = this.w.toByteArray();
                        this.z.a = true;
                        this.z.f = System.currentTimeMillis() - this.z.d;
                        this.q = true;
                        c();
                        return this.z;
                    } catch (OutOfMemoryError e3) {
                        this.z.b = -5;
                        this.z.g = "OutOfMemoryError";
                        a aVar4 = this.z;
                        this.z.f = System.currentTimeMillis() - this.z.d;
                        this.q = true;
                        c();
                        return aVar4;
                    }
                } catch (OutOfMemoryError e4) {
                    this.z.b = -5;
                    this.z.g = "OutOfMemoryError";
                    a aVar5 = this.z;
                    this.z.f = System.currentTimeMillis() - this.z.d;
                    this.q = true;
                    c();
                    return aVar5;
                }
            } catch (IOException e5) {
                this.z.b = -1;
                this.z.g = "read data failed";
                this.z.f = System.currentTimeMillis() - this.z.d;
                this.q = true;
                c();
            } catch (Exception e6) {
                this.z.b = -1;
                this.z.g = EnvironmentCompat.MEDIA_UNKNOWN;
                this.z.f = System.currentTimeMillis() - this.z.d;
                this.q = true;
                c();
            }
        } catch (Throwable th) {
            this.z.f = System.currentTimeMillis() - this.z.d;
            this.q = true;
            c();
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    boolean e() throws Throwable {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = 0;
        randomAccessFile = null;
        RandomAccessFile randomAccessFile3 = null;
        if (TextUtils.isEmpty(this.k)) {
            return true;
        }
        try {
            File file = new File(this.k);
            if (!file.exists()) {
                file.createNewFile();
            }
            try {
                if (file.length() > this.l) {
                    try {
                        randomAccessFile = new RandomAccessFile(this.k, "rw");
                        try {
                            randomAccessFile.setLength(this.l);
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                } catch (IOException e2) {
                                }
                            }
                            if (this.l > 0) {
                                a("Range", "bytes=" + this.l + "-");
                            }
                        } catch (IOException e3) {
                            e = e3;
                            e.printStackTrace();
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                } catch (IOException e4) {
                                }
                            }
                            return false;
                        }
                    } catch (IOException e5) {
                        e = e5;
                        randomAccessFile = null;
                    } catch (Throwable th) {
                        th = th;
                        if (randomAccessFile2 != 0) {
                            try {
                                randomAccessFile2.close();
                            } catch (IOException e6) {
                            }
                        }
                        throw th;
                    }
                } else if (file.length() < this.l) {
                    try {
                        try {
                            RandomAccessFile randomAccessFile4 = new RandomAccessFile(this.k, "rw");
                            try {
                                randomAccessFile4.setLength(0L);
                                if (randomAccessFile4 != null) {
                                    try {
                                        randomAccessFile4.close();
                                    } catch (IOException e7) {
                                    }
                                }
                                this.l = 0;
                            } catch (IOException e8) {
                                e = e8;
                                randomAccessFile3 = randomAccessFile4;
                                e.printStackTrace();
                                if (randomAccessFile3 != null) {
                                    try {
                                        randomAccessFile3.close();
                                    } catch (IOException e9) {
                                    }
                                }
                                return false;
                            } catch (Throwable th2) {
                                th = th2;
                                randomAccessFile3 = randomAccessFile4;
                                if (randomAccessFile3 != null) {
                                    try {
                                        randomAccessFile3.close();
                                    } catch (IOException e10) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (IOException e11) {
                        e = e11;
                    }
                } else if (this.l > 0) {
                    a("Range", "bytes=" + this.l + "-");
                }
                a("Accept-Encoding", HTTP.IDENTITY_CODING);
                return true;
            } catch (Throwable th4) {
                th = th4;
                randomAccessFile2 = file;
            }
        } catch (IOException e12) {
            return false;
        }
    }

    int f() {
        try {
            String host = this.t.getURL().getHost();
            this.z.b = this.t.getResponseCode();
            if (!this.t.getURL().getHost().equalsIgnoreCase(host)) {
                this.z.l = this.t.getURL().toString();
            }
            if (this.z.b != 200 && this.z.b != 201 && this.z.b != 206) {
                this.z.g = "response code error" + this.z.b;
                return -2;
            }
            int contentLength = this.t.getContentLength();
            if (this.h == null ? false : HTTP.IDENTITY_CODING.equals(this.h.get("Accept-Encoding"))) {
                return contentLength;
            }
            return -1;
        } catch (IOException e2) {
            this.z.g = "get response code exception";
            return -2;
        } catch (Exception e3) {
            if (!this.p) {
                this.z.g = EnvironmentCompat.MEDIA_UNKNOWN;
            }
            return -2;
        }
    }

    boolean g() {
        try {
            if (((int) this.m) > 0) {
                this.t.setReadTimeout((int) this.m);
            }
            return true;
        } catch (Exception e2) {
            if (!this.p) {
                this.z.g = EnvironmentCompat.MEDIA_UNKNOWN;
            }
            return false;
        }
    }

    void h() {
        c();
        this.q = true;
        this.z.f = System.currentTimeMillis() - this.z.d;
        if (this.z.a()) {
            a(e.NOTIFY_FINISH, 0);
        } else {
            if (this.p) {
                return;
            }
            a(e.NOTIFY_FAILED, 0);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        int i = 0;
        this.z.e = System.currentTimeMillis();
        this.z.k = this.g;
        if (this.n && c.get() > b) {
            this.z.g = "flow limit";
            h();
            return;
        }
        if (!e()) {
            this.z.g = "file error";
            h();
            return;
        }
        if (this.p) {
            this.z.g = "user cancel";
            h();
            return;
        }
        if (!b()) {
            h();
            return;
        }
        int iF = f();
        if (-2 == iF) {
            h();
            return;
        }
        if (iF != -1 || this.k == null) {
            a(e.NOTIFY_START, this.l + iF);
        }
        try {
            this.u = new BufferedInputStream(this.t.getInputStream());
            this.w = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[16384];
                if (this.w == null) {
                    h();
                    return;
                }
                if (!g()) {
                    h();
                    return;
                }
                while (!this.p) {
                    try {
                        int i2 = this.u.read(bArr, 0, bArr.length);
                        if (i2 < 0) {
                            if (this.k == null) {
                                break;
                            }
                            if (i != iF && iF != -1) {
                                this.z.g = "ContentLength error";
                                h();
                                return;
                            }
                            if (i + this.l == new File(this.k).length()) {
                                break;
                            }
                            this.z.g = "io error (file lenght error) ";
                            h();
                            return;
                        }
                        if (!g()) {
                            h();
                            return;
                        }
                        if (i2 != 0) {
                            if (this.n) {
                                c.set(c.get() + ((long) i2));
                            }
                            if (this.k == null) {
                                try {
                                    this.w.write(bArr, 0, i2);
                                } catch (OutOfMemoryError e2) {
                                    this.z.g = "out of memory error";
                                    h();
                                    return;
                                }
                            }
                            if (this.k != null) {
                                if (this.l + i != new File(this.k).length()) {
                                    this.z.g = "io error (check file length error)";
                                    h();
                                    return;
                                }
                            }
                            if (!a(bArr, i2, this.l + i)) {
                                this.z.g = "write file error";
                                h();
                                return;
                            } else {
                                i += i2;
                                if (iF != -1 || this.k == null) {
                                    a(this.l + iF, this.l + i, bArr, i2);
                                }
                            }
                        }
                    } catch (IOException e3) {
                        this.z.g = "read error";
                        h();
                        return;
                    } catch (Exception e4) {
                        if (!this.p) {
                            this.z.g = EnvironmentCompat.MEDIA_UNKNOWN;
                        }
                        h();
                        return;
                    }
                }
                if (this.p) {
                    this.z.g = "user cancel";
                    h();
                    return;
                }
                this.z.n = (System.currentTimeMillis() - this.z.e) - this.z.m;
                try {
                    this.z.c = this.w.toByteArray();
                    this.z.a = true;
                    if (iF == -1 && this.k != null) {
                        a(e.NOTIFY_START, iF + this.l);
                    }
                    h();
                } catch (OutOfMemoryError e5) {
                    this.z.g = "OutOfMemoryError";
                    h();
                }
            } catch (OutOfMemoryError e6) {
                this.z.g = "OutOfMemoryError";
            }
        } catch (IOException e7) {
            e7.printStackTrace();
            this.z.g = "read data failed";
            h();
        }
    }
}
