package com.android.launcher6;

import android.os.Looper;
import android.os.MessageQueue;
import android.util.Pair;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
public class ba {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LinkedList f124a = new LinkedList();
    private MessageQueue b = Looper.myQueue();
    private bc c = new bc(this, null);

    public void a() {
        LinkedList linkedList = new LinkedList();
        synchronized (this.f124a) {
            linkedList.addAll(this.f124a);
            this.f124a.clear();
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((Runnable) ((Pair) it.next()).first).run();
        }
    }

    public void a(int i) {
        synchronized (this.f124a) {
            ListIterator listIterator = this.f124a.listIterator();
            while (listIterator.hasNext()) {
                if (((Integer) ((Pair) listIterator.next()).second).intValue() == i) {
                    listIterator.remove();
                }
            }
        }
    }

    public void a(Runnable runnable) {
        a(runnable, 0);
    }

    public void a(Runnable runnable, int i) {
        synchronized (this.f124a) {
            this.f124a.add(new Pair(runnable, Integer.valueOf(i)));
            if (this.f124a.size() == 1) {
                b();
            }
        }
    }

    void b() {
        if (this.f124a.size() > 0) {
            if (((Runnable) ((Pair) this.f124a.getFirst()).first) instanceof bb) {
                this.b.addIdleHandler(this.c);
            } else {
                this.c.sendEmptyMessage(1);
            }
        }
    }

    public void b(Runnable runnable) {
        b(runnable, 0);
    }

    public void b(Runnable runnable, int i) {
        a(new bb(this, runnable), i);
    }
}
