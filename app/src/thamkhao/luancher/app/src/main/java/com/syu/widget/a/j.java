package com.syu.widget.a;

import com.fyt.widget.Date;
import com.fyt.widget.WeekDay;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f559a;

    j(i iVar) {
        this.f559a = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator it = new ArrayList(h.f557a).iterator();
        while (it.hasNext()) {
            ((l) it.next()).d();
        }
        if (com.fyt.widget.b.getClock() != null) {
            com.fyt.widget.b.getClock().a();
        }
        if (Date.getDate() != null) {
            Date.getDate().b();
        }
        if (com.fyt.widget.c.getDate() != null) {
            com.fyt.widget.c.getDate().a();
        }
        if (com.fyt.widget.i.getModulation() != null) {
            com.fyt.widget.i.getModulation().a();
        }
        if (WeekDay.getWeekDay() != null) {
            WeekDay.getWeekDay().b();
        }
        if (com.fyt.widget.m.getWeekDay() != null) {
            com.fyt.widget.m.getWeekDay().a();
        }
        if (WeekDay.getWeekDay() != null) {
            WeekDay.getWeekDay().b();
        }
        if (com.fyt.widget.n.getYear() != null) {
            com.fyt.widget.n.getYear().a();
        }
        if (com.fyt.widget.j.getMonth() != null) {
            com.fyt.widget.j.getMonth().a();
        }
        if (com.fyt.widget.d.getDay() != null) {
            com.fyt.widget.d.getDay().a();
        }
    }
}
