package android.a.a.c;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes.dex */
class h implements j {
    h() {
    }

    @Override // android.a.a.c.j
    public int a(MotionEvent motionEvent, int i) {
        return i == 0 ? 0 : -1;
    }

    @Override // android.a.a.c.j
    public int b(MotionEvent motionEvent, int i) {
        if (i == 0) {
            return 0;
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }

    @Override // android.a.a.c.j
    public float c(MotionEvent motionEvent, int i) {
        if (i == 0) {
            return motionEvent.getX();
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }

    @Override // android.a.a.c.j
    public float d(MotionEvent motionEvent, int i) {
        if (i == 0) {
            return motionEvent.getY();
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }
}
