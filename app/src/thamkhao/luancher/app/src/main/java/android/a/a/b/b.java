package android.a.a.b;

/* JADX INFO: loaded from: classes.dex */
public class b implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f9a = new Object();
    private boolean b;
    private long[] c;
    private Object[] d;
    private int e;

    public b() {
        this(10);
    }

    public b(int i) {
        this.b = false;
        if (i == 0) {
            this.c = a.b;
            this.d = a.c;
        } else {
            int iA = a.a(i);
            this.c = new long[iA];
            this.d = new Object[iA];
        }
        this.e = 0;
    }

    private void d() {
        int i = this.e;
        long[] jArr = this.c;
        Object[] objArr = this.d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f9a) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.b = false;
        this.e = i2;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public b clone() {
        try {
            b bVar = (b) super.clone();
            try {
                bVar.c = (long[]) this.c.clone();
                bVar.d = (Object[]) this.d.clone();
                return bVar;
            } catch (CloneNotSupportedException e) {
                return bVar;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public Object a(long j) {
        return a(j, null);
    }

    public Object a(long j, Object obj) {
        int iA = a.a(this.c, this.e, j);
        return (iA < 0 || this.d[iA] == f9a) ? obj : this.d[iA];
    }

    public void a(int i) {
        if (this.d[i] != f9a) {
            this.d[i] = f9a;
            this.b = true;
        }
    }

    public int b() {
        if (this.b) {
            d();
        }
        return this.e;
    }

    public long b(int i) {
        if (this.b) {
            d();
        }
        return this.c[i];
    }

    public void b(long j, Object obj) {
        int iA = a.a(this.c, this.e, j);
        if (iA >= 0) {
            this.d[iA] = obj;
            return;
        }
        int iA2 = iA ^ (-1);
        if (iA2 < this.e && this.d[iA2] == f9a) {
            this.c[iA2] = j;
            this.d[iA2] = obj;
            return;
        }
        if (this.b && this.e >= this.c.length) {
            d();
            iA2 = a.a(this.c, this.e, j) ^ (-1);
        }
        if (this.e >= this.c.length) {
            int iA3 = a.a(this.e + 1);
            long[] jArr = new long[iA3];
            Object[] objArr = new Object[iA3];
            System.arraycopy(this.c, 0, jArr, 0, this.c.length);
            System.arraycopy(this.d, 0, objArr, 0, this.d.length);
            this.c = jArr;
            this.d = objArr;
        }
        if (this.e - iA2 != 0) {
            System.arraycopy(this.c, iA2, this.c, iA2 + 1, this.e - iA2);
            System.arraycopy(this.d, iA2, this.d, iA2 + 1, this.e - iA2);
        }
        this.c[iA2] = j;
        this.d[iA2] = obj;
        this.e++;
    }

    public Object c(int i) {
        if (this.b) {
            d();
        }
        return this.d[i];
    }

    public void c() {
        int i = this.e;
        Object[] objArr = this.d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.e = 0;
        this.b = false;
    }

    public String toString() {
        if (b() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.e * 28);
        sb.append('{');
        for (int i = 0; i < this.e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(b(i));
            sb.append('=');
            Object objC = c(i);
            if (objC != this) {
                sb.append(objC);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
