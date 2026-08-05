package com.syu.widget.a;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import com.android.launcher6.Launcher;
import com.android.launcher6.LauncherApplication;
import com.android.launcher6.R;

/* JADX INFO: loaded from: classes.dex */
public class g extends l {
    private static final int[] h = {a.b.a().fz, a.b.a().fA, a.b.a().fB, a.b.a().fC, a.b.a().fD, a.b.a().fE, a.b.a().fF, a.b.a().fG, a.b.a().fH, a.b.a().fI};
    private static final int[] i = {a.b.a().fb, a.b.a().fa, a.b.a().fc, a.b.a().fd};

    public g(Context context, int i2) {
        super(context, i2);
    }

    private void a(RemoteViews remoteViews, com.syu.i.d dVar) {
        if (dVar == null || !dVar.f()) {
            return;
        }
        remoteViews.setTextViewText(a.b.a().dN, dVar.a());
        remoteViews.setTextViewText(a.b.a().dQ, dVar.e());
        remoteViews.setTextViewText(a.b.a().dP, dVar.d());
        remoteViews.setTextViewText(a.b.a().dO, dVar.b());
        remoteViews.setImageViewResource(a.b.a().dM, com.syu.g.m.a(this.f560a, dVar.b()));
    }

    private void d(RemoteViews remoteViews) {
        if (Launcher.G() != null) {
            a(remoteViews, Launcher.G().q);
        }
    }

    @Override // com.syu.widget.a.l
    void a() {
        this.d = a.b.a().fR;
    }

    @Override // com.syu.widget.a.l
    void a(RemoteViews remoteViews) {
        int iMax;
        remoteViews.setTextViewText(a.b.a().fe, com.syu.widget.a.a.a.d(this.f560a));
        switch (LauncherApplication.f88a.getResources().getInteger(R.integer.apps_timewidget_show)) {
            case 0:
                remoteViews.setTextViewText(a.b.a().fg, com.syu.widget.a.a.a.a(this.f560a, "yyyy-MM-dd"));
                break;
            case 1:
                remoteViews.setTextViewText(a.b.a().fg, com.syu.widget.a.a.a.a(this.f560a, "yyyy/MM/dd"));
                break;
            case 2:
                remoteViews.setTextViewText(a.b.a().fg, com.syu.widget.a.a.a.a(this.f560a, "yyyy.MM.dd"));
                break;
            case 3:
                remoteViews.setTextViewText(a.b.a().fg, com.syu.widget.a.a.a.a(this.f560a, "yyyy - MM - dd"));
                break;
        }
        if (com.syu.widget.a.a.a.b(this.f560a)) {
            remoteViews.setViewVisibility(a.b.a().fh, 8);
        } else {
            remoteViews.setViewVisibility(a.b.a().fh, 0);
            if (LauncherApplication.f88a.getResources().getBoolean(R.bool.app_ampm_show)) {
                remoteViews.setTextViewText(a.b.a().fh, com.syu.widget.a.a.a.c(this.f560a));
            } else {
                remoteViews.setImageViewResource(a.b.a().fh, com.syu.widget.a.a.a.c(this.f560a).equals(this.f560a.getString(R.string.am)) ? a.b.a().fO : a.b.a().fP);
            }
        }
        char[] charArray = com.syu.widget.a.a.a.a(this.f560a).toCharArray();
        int length = charArray.length;
        if (length == 3) {
            remoteViews.setViewVisibility(i[0], 8);
            remoteViews.setImageViewResource(i[0], 0);
        } else if (length > 3) {
            remoteViews.setViewVisibility(i[0], 0);
        }
        for (int i2 = 0; i2 < length; i2++) {
            try {
                if (charArray[i2] != ':' && (iMax = Math.max(0, Math.min(Integer.parseInt(new String(new char[]{charArray[i2]})), h.length - 1))) >= 0) {
                    remoteViews.setImageViewResource(i[Math.max(0, Math.min(length > 3 ? i2 : i2 + 1, i.length - 1))], h[iMax]);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        d(remoteViews);
    }

    @Override // com.syu.widget.a.l
    protected void b() {
        h.a(this);
        super.b();
    }

    @Override // com.syu.widget.a.l
    void b(RemoteViews remoteViews) {
        remoteViews.setOnClickPendingIntent(a.b.a().ff, PendingIntent.getActivity(this.f560a, 0, new Intent("android.settings.DATE_SETTINGS"), 0));
    }

    @Override // com.syu.widget.a.l
    public void c() {
        h.b(this);
        super.c();
    }
}
