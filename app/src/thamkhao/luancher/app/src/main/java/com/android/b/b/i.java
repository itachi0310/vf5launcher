package com.android.b.b;

import android.util.Log;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f51a;

    i(c cVar) {
        this.f51a = cVar;
    }

    protected b a(InputStream inputStream) {
        e eVarA = e.a(inputStream, this.f51a);
        b bVar = new b(eVarA.m());
        for (int iA = eVarA.a(); iA != 5; iA = eVarA.a()) {
            switch (iA) {
                case 0:
                    bVar.a(new k(eVarA.d()));
                    break;
                case 1:
                    j jVarC = eVarA.c();
                    if (jVarC.f()) {
                        bVar.a(jVarC.a()).a(jVarC);
                    } else {
                        eVarA.a(jVarC);
                    }
                    break;
                case 2:
                    j jVarC2 = eVarA.c();
                    if (jVarC2.c() == 7) {
                        eVarA.b(jVarC2);
                    }
                    bVar.a(jVarC2.a()).a(jVarC2);
                    break;
                case 3:
                    byte[] bArr = new byte[eVarA.g()];
                    if (bArr.length == eVarA.a(bArr)) {
                        bVar.a(bArr);
                    } else {
                        Log.w("ExifReader", "Failed to read the compressed thumbnail");
                    }
                    break;
                case 4:
                    byte[] bArr2 = new byte[eVarA.f()];
                    if (bArr2.length == eVarA.a(bArr2)) {
                        bVar.a(eVarA.e(), bArr2);
                    } else {
                        Log.w("ExifReader", "Failed to read the strip bytes");
                    }
                    break;
            }
        }
        return bVar;
    }
}
