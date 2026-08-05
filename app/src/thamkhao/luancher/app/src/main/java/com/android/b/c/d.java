package com.android.b.c;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.util.Log;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class d implements c {
    private int m;
    private int n;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private static final String e = d.class.getSimpleName();
    private static final float[] f = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f};
    private static final float[] g = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f};
    private static final i K = new h();
    private float[] h = new float[128];
    private float[] i = new float[8];
    private com.android.b.d.a j = new com.android.b.d.a();
    private int k = 0;
    private int l = 0;
    private float[] o = new float[16];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    f[] f56a = {new e("aPosition"), new g("uMatrix"), new g("uColor")};
    f[] b = {new e("aPosition"), new g("uMatrix"), new g("uTextureMatrix"), new g("uTextureSampler"), new g("uAlpha")};
    f[] c = {new e("aPosition"), new g("uMatrix"), new g("uTextureMatrix"), new g("uTextureSampler"), new g("uAlpha")};
    f[] d = {new e("aPosition"), new g("uMatrix"), new e("aTextureCoordinate"), new g("uTextureSampler"), new g("uAlpha")};
    private final com.android.b.d.a w = new com.android.b.d.a();
    private final com.android.b.d.a x = new com.android.b.d.a();
    private int y = 0;
    private int z = 0;
    private int A = 0;
    private int B = 0;
    private int[] C = new int[1];
    private ArrayList D = new ArrayList();
    private final float[] E = new float[32];
    private final float[] F = new float[4];
    private final RectF G = new RectF();
    private final RectF H = new RectF();
    private final float[] I = new float[16];
    private final int[] J = new int[1];

    public d() {
        Matrix.setIdentityM(this.I, 0);
        Matrix.setIdentityM(this.h, this.l);
        this.i[this.k] = 1.0f;
        this.D.add(null);
        this.v = a(a(f));
        int iA = a(35633, "uniform mat4 uMatrix;\nattribute vec2 aPosition;\nvoid main() {\n  vec4 pos = vec4(aPosition, 0.0, 1.0);\n  gl_Position = uMatrix * pos;\n}\n");
        int iA2 = a(35633, "uniform mat4 uMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec2 aPosition;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec4 pos = vec4(aPosition, 0.0, 1.0);\n  gl_Position = uMatrix * pos;\n  vTextureCoord = (uTextureMatrix * pos).xy;\n}\n");
        int iA3 = a(35633, "uniform mat4 uMatrix;\nattribute vec2 aPosition;\nattribute vec2 aTextureCoordinate;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec4 pos = vec4(aPosition, 0.0, 1.0);\n  gl_Position = uMatrix * pos;\n  vTextureCoord = aTextureCoordinate;\n}\n");
        int iA4 = a(35632, "precision mediump float;\nuniform vec4 uColor;\nvoid main() {\n  gl_FragColor = uColor;\n}\n");
        int iA5 = a(35632, "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform float uAlpha;\nuniform sampler2D uTextureSampler;\nvoid main() {\n  gl_FragColor = texture2D(uTextureSampler, vTextureCoord);\n  gl_FragColor *= uAlpha;\n}\n");
        int iA6 = a(35632, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform float uAlpha;\nuniform samplerExternalOES uTextureSampler;\nvoid main() {\n  gl_FragColor = texture2D(uTextureSampler, vTextureCoord);\n  gl_FragColor *= uAlpha;\n}\n");
        this.r = a(iA, iA4, this.f56a);
        this.s = a(iA2, iA5, this.b);
        this.t = a(iA2, iA6, this.c);
        this.u = a(iA3, iA5, this.d);
        GLES20.glBlendFunc(1, 771);
        e();
    }

    private int a(int i, int i2, f[] fVarArr) {
        int iGlCreateProgram = GLES20.glCreateProgram();
        e();
        if (iGlCreateProgram == 0) {
            throw new RuntimeException("Cannot create GL program: " + GLES20.glGetError());
        }
        GLES20.glAttachShader(iGlCreateProgram, i);
        e();
        GLES20.glAttachShader(iGlCreateProgram, i2);
        e();
        GLES20.glLinkProgram(iGlCreateProgram);
        e();
        int[] iArr = this.J;
        GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        if (iArr[0] != 1) {
            Log.e(e, "Could not link program: ");
            Log.e(e, GLES20.glGetProgramInfoLog(iGlCreateProgram));
            GLES20.glDeleteProgram(iGlCreateProgram);
            iGlCreateProgram = 0;
        }
        for (f fVar : fVarArr) {
            fVar.a(iGlCreateProgram);
        }
        return iGlCreateProgram;
    }

    private static int a(int i, String str) {
        int iGlCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(iGlCreateShader, str);
        e();
        GLES20.glCompileShader(iGlCreateShader);
        e();
        return iGlCreateShader;
    }

    private int a(Buffer buffer, int i) {
        K.a(1, this.J, 0);
        e();
        int i2 = this.J[0];
        GLES20.glBindBuffer(34962, i2);
        e();
        GLES20.glBufferData(34962, buffer.capacity() * i, buffer, 35044);
        e();
        return i2;
    }

    private static FloatBuffer a(float[] fArr) {
        FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr, 0, fArr.length).position(0);
        return floatBufferAsFloatBuffer;
    }

    private void a(RectF rectF) {
        this.I[0] = rectF.width();
        this.I[5] = rectF.height();
        this.I[12] = rectF.left;
        this.I[13] = rectF.top;
    }

    private static void a(RectF rectF, RectF rectF2, a aVar) {
        int iC = aVar.c();
        int iD = aVar.d();
        int iE = aVar.e();
        int iF = aVar.f();
        rectF.left /= iE;
        rectF.right /= iE;
        rectF.top /= iF;
        rectF.bottom /= iF;
        float f2 = iC / iE;
        if (rectF.right > f2) {
            rectF2.right = rectF2.left + ((rectF2.width() * (f2 - rectF.left)) / rectF.width());
            rectF.right = f2;
        }
        float f3 = iD / iF;
        if (rectF.bottom > f3) {
            rectF2.bottom = rectF2.top + ((rectF2.height() * (f3 - rectF.top)) / rectF.height());
            rectF.bottom = f3;
        }
    }

    private void a(a aVar, int i, f[] fVarArr) {
        GLES20.glUseProgram(i);
        e();
        a(!aVar.l() || d() < 0.95f);
        GLES20.glActiveTexture(33984);
        e();
        aVar.b(this);
        GLES20.glBindTexture(aVar.h(), aVar.b());
        e();
        GLES20.glUniform1i(fVarArr[3].f57a, 0);
        e();
        GLES20.glUniform1f(fVarArr[4].f57a, d());
        e();
    }

    private static void a(a aVar, RectF rectF) {
        int i = 1;
        int i2 = 0;
        int iC = aVar.c();
        int iD = aVar.d();
        if (aVar.g()) {
            iC--;
            iD--;
            i2 = 1;
        } else {
            i = 0;
        }
        rectF.set(i2, i, iC, iD);
    }

    private void a(a aVar, float[] fArr, RectF rectF) {
        f[] fVarArrC = c(aVar);
        a(fVarArrC, 0);
        GLES20.glUniformMatrix4fv(fVarArrC[2].f57a, 1, false, fArr, 0);
        e();
        if (aVar.a()) {
            a(2);
            a(0.0f, rectF.centerY());
            a(1.0f, -1.0f, 1.0f);
            a(0.0f, -rectF.centerY());
        }
        a(fVarArrC, 5, 4, rectF.left, rectF.top, rectF.width(), rectF.height());
        if (aVar.a()) {
            b();
        }
        this.z++;
    }

    private void a(boolean z) {
        if (z) {
            GLES20.glEnable(3042);
            e();
        } else {
            GLES20.glDisable(3042);
            e();
        }
    }

    private void a(f[] fVarArr, float f2, float f3, float f4, float f5) {
        Matrix.translateM(this.E, 0, this.h, this.l, f2, f3, 0.0f);
        Matrix.scaleM(this.E, 0, f4, f5, 1.0f);
        Matrix.multiplyMM(this.E, 16, this.o, 0, this.E, 0);
        GLES20.glUniformMatrix4fv(fVarArr[1].f57a, 1, false, this.E, 16);
        e();
    }

    private void a(f[] fVarArr, int i) {
        GLES20.glBindBuffer(34962, this.v);
        e();
        GLES20.glVertexAttribPointer(fVarArr[0].f57a, 2, 5126, false, 8, i * 8);
        e();
        GLES20.glBindBuffer(34962, 0);
        e();
    }

    private void a(f[] fVarArr, int i, int i2, float f2, float f3, float f4, float f5) {
        a(fVarArr, f2, f3, f4, f5);
        int i3 = fVarArr[0].f57a;
        GLES20.glEnableVertexAttribArray(i3);
        e();
        GLES20.glDrawArrays(i, 0, i2);
        e();
        GLES20.glDisableVertexAttribArray(i3);
        e();
    }

    private void b(a aVar, RectF rectF, RectF rectF2) {
        a(rectF);
        a(aVar, this.I, rectF2);
    }

    private f[] c(a aVar) {
        f[] fVarArr;
        int i;
        if (aVar.h() == 3553) {
            fVarArr = this.b;
            i = this.s;
        } else {
            fVarArr = this.c;
            i = this.t;
        }
        a(aVar, i, fVarArr);
        return fVarArr;
    }

    public static void e() {
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError != 0) {
            Log.e(e, "GL error: " + iGlGetError, new Throwable());
        }
    }

    private j f() {
        return (j) this.D.get(this.D.size() - 1);
    }

    public int a(FloatBuffer floatBuffer) {
        return a(floatBuffer, 4);
    }

    @Override // com.android.b.c.c
    public i a() {
        return K;
    }

    @Override // com.android.b.c.c
    public void a(float f2, float f3) {
        int i = this.l;
        float[] fArr = this.h;
        int i2 = i + 12;
        fArr[i2] = fArr[i2] + (fArr[i + 0] * f2) + (fArr[i + 4] * f3);
        int i3 = i + 13;
        fArr[i3] = fArr[i3] + (fArr[i + 1] * f2) + (fArr[i + 5] * f3);
        int i4 = i + 14;
        fArr[i4] = fArr[i4] + (fArr[i + 2] * f2) + (fArr[i + 6] * f3);
        int i5 = i + 15;
        fArr[i5] = (fArr[i + 7] * f3) + (fArr[i + 3] * f2) + fArr[i5];
    }

    public void a(float f2, float f3, float f4) {
        Matrix.scaleM(this.h, this.l, f2, f3, f4);
    }

    @Override // com.android.b.c.c
    public void a(float f2, float f3, float f4, float f5) {
        if (f2 == 0.0f) {
            return;
        }
        float[] fArr = this.E;
        Matrix.setRotateM(fArr, 0, f2, f3, f4, f5);
        float[] fArr2 = this.h;
        int i = this.l;
        Matrix.multiplyMM(fArr, 16, fArr2, i, fArr, 0);
        System.arraycopy(fArr, 16, fArr2, i, 16);
    }

    @Override // com.android.b.c.c
    public void a(int i) {
        if ((i & 1) == 1) {
            float fD = d();
            this.k++;
            if (this.i.length <= this.k) {
                this.i = Arrays.copyOf(this.i, this.i.length * 2);
            }
            this.i[this.k] = fD;
        }
        if ((i & 2) == 2) {
            int i2 = this.l;
            this.l += 16;
            if (this.h.length <= this.l) {
                this.h = Arrays.copyOf(this.h, this.h.length * 2);
            }
            System.arraycopy(this.h, i2, this.h, this.l, 16);
        }
        this.j.a(i);
    }

    public void a(int i, int i2) {
        this.m = i;
        this.n = i2;
        GLES20.glViewport(0, 0, this.m, this.n);
        e();
        Matrix.setIdentityM(this.h, this.l);
        Matrix.orthoM(this.o, 0, 0.0f, i, 0.0f, i2, -1.0f, 1.0f);
        if (f() == null) {
            this.p = i;
            this.q = i2;
            Matrix.translateM(this.h, this.l, 0.0f, i2, 0.0f);
            Matrix.scaleM(this.h, this.l, 1.0f, -1.0f, 1.0f);
        }
    }

    @Override // com.android.b.c.c
    public void a(a aVar, int i, int i2) {
        int iH = aVar.h();
        GLES20.glBindTexture(iH, aVar.b());
        e();
        GLES20.glTexImage2D(iH, 0, i, aVar.e(), aVar.f(), 0, i, i2, null);
    }

    @Override // com.android.b.c.c
    public void a(a aVar, int i, int i2, int i3, int i4) {
        if (i3 <= 0 || i4 <= 0) {
            return;
        }
        a(aVar, this.G);
        this.H.set(i, i2, i + i3, i2 + i4);
        a(this.G, this.H, aVar);
        b(aVar, this.G, this.H);
    }

    @Override // com.android.b.c.c
    public void a(a aVar, int i, int i2, Bitmap bitmap, int i3, int i4) {
        int iH = aVar.h();
        GLES20.glBindTexture(iH, aVar.b());
        e();
        GLUtils.texSubImage2D(iH, 0, i, i2, bitmap, i3, i4);
    }

    @Override // com.android.b.c.c
    public void a(a aVar, Bitmap bitmap) {
        int iH = aVar.h();
        GLES20.glBindTexture(iH, aVar.b());
        e();
        GLUtils.texImage2D(iH, 0, bitmap, 0);
    }

    @Override // com.android.b.c.c
    public void a(a aVar, RectF rectF, RectF rectF2) {
        if (rectF2.width() <= 0.0f || rectF2.height() <= 0.0f) {
            return;
        }
        this.G.set(rectF);
        this.H.set(rectF2);
        a(this.G, this.H, aVar);
        b(aVar, this.G, this.H);
    }

    @Override // com.android.b.c.c
    public boolean a(a aVar) {
        boolean zI = aVar.i();
        if (zI) {
            synchronized (this.w) {
                this.w.a(aVar.b());
            }
        }
        return zI;
    }

    @Override // com.android.b.c.c
    public void b() {
        int iA = this.j.a();
        if ((iA & 1) == 1) {
            this.k--;
        }
        if ((iA & 2) == 2) {
            this.l -= 16;
        }
    }

    @Override // com.android.b.c.c
    public void b(a aVar) {
        int iH = aVar.h();
        GLES20.glBindTexture(iH, aVar.b());
        e();
        GLES20.glTexParameteri(iH, 10242, 33071);
        GLES20.glTexParameteri(iH, 10243, 33071);
        GLES20.glTexParameterf(iH, 10241, 9729.0f);
        GLES20.glTexParameterf(iH, 10240, 9729.0f);
    }

    public void c() {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        e();
        GLES20.glClear(16384);
        e();
    }

    public float d() {
        return this.i[this.k];
    }
}
