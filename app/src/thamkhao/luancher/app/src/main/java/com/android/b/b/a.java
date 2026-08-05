package com.android.b.b;

import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
class a extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f44a;
    private int b;
    private final byte[] c;
    private final ByteBuffer d;

    static {
        f44a = !a.class.desiredAssertionStatus();
    }

    protected a(InputStream inputStream) {
        super(inputStream);
        this.b = 0;
        this.c = new byte[8];
        this.d = ByteBuffer.wrap(this.c);
    }

    public int a() {
        return this.b;
    }

    public String a(int i, Charset charset) throws EOFException {
        byte[] bArr = new byte[i];
        a(bArr);
        return new String(bArr, charset);
    }

    public void a(long j) throws EOFException {
        if (skip(j) != j) {
            throw new EOFException();
        }
    }

    public void a(ByteOrder byteOrder) {
        this.d.order(byteOrder);
    }

    public void a(byte[] bArr) throws EOFException {
        a(bArr, 0, bArr.length);
    }

    public void a(byte[] bArr, int i, int i2) throws EOFException {
        if (read(bArr, i, i2) != i2) {
            throw new EOFException();
        }
    }

    public ByteOrder b() {
        return this.d.order();
    }

    public void b(long j) throws EOFException {
        long j2 = j - ((long) this.b);
        if (!f44a && j2 < 0) {
            throw new AssertionError();
        }
        a(j2);
    }

    public short c() throws EOFException {
        a(this.c, 0, 2);
        this.d.rewind();
        return this.d.getShort();
    }

    public int d() {
        return c() & 65535;
    }

    public int e() throws EOFException {
        a(this.c, 0, 4);
        this.d.rewind();
        return this.d.getInt();
    }

    public long f() {
        return ((long) e()) & 4294967295L;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i = this.in.read();
        this.b = (i >= 0 ? 1 : 0) + this.b;
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        int i = this.in.read(bArr);
        this.b = (i >= 0 ? i : 0) + this.b;
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.in.read(bArr, i, i2);
        this.b = (i3 >= 0 ? i3 : 0) + this.b;
        return i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long jSkip = this.in.skip(j);
        this.b = (int) (((long) this.b) + jSkip);
        return jSkip;
    }
}
