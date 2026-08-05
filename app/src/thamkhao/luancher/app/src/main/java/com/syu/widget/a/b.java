package com.syu.widget.a;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.widget.RemoteViews;
import com.android.launcher6.Launcher;
import com.android.launcher6.LauncherApplication;
import com.android.launcher6.R;
import com.fyt.car.MusicService;

/* JADX INFO: loaded from: classes.dex */
public class b extends l {
    private static final int[] i = {a.b.a().fz, a.b.a().fA, a.b.a().fB, a.b.a().fC, a.b.a().fD, a.b.a().fE, a.b.a().fF, a.b.a().fG, a.b.a().fH, a.b.a().fI};
    private static final int[] j = {a.b.a().fb, a.b.a().fa, a.b.a().fc, a.b.a().fd};
    private String h;
    private int k;
    private boolean l;
    private Runnable m;

    public b(Context context, int i2) {
        super(context, i2);
        this.h = "";
        this.k = 0;
        this.l = false;
        this.m = new c(this);
    }

    public static Bitmap a(Bitmap bitmap) {
        int i2;
        int i3;
        int i4;
        int i5;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = height / 2;
        if (width > height) {
            int i6 = (width - height) / 2;
            i4 = 0;
            i5 = i6;
            i3 = i6 + height;
            i2 = height;
        } else if (height > width) {
            int i7 = (height - width) / 2;
            i2 = i7 + width;
            f = width / 2;
            i4 = i7;
            i5 = 0;
            i3 = width;
        } else {
            i2 = height;
            i3 = width;
            i4 = 0;
            i5 = 0;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(i5, i4, i3, i2);
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return bitmapCreateBitmap;
    }

    private void a(RemoteViews remoteViews, com.syu.i.d dVar) {
        if (dVar == null || !dVar.f()) {
            return;
        }
        remoteViews.setTextViewText(a.b.a().dN, dVar.a());
        remoteViews.setTextViewText(a.b.a().dQ, dVar.e());
        remoteViews.setTextViewText(a.b.a().dP, dVar.d());
        remoteViews.setTextViewText(a.b.a().dO, String.valueOf(dVar.b()) + dVar.d());
        remoteViews.setImageViewResource(a.b.a().dM, com.syu.g.m.a(this.f560a, dVar.b()));
    }

    private void d(RemoteViews remoteViews) {
        if (Launcher.G() != null) {
            a(remoteViews, Launcher.G().q);
        }
    }

    private void e(RemoteViews remoteViews) {
        remoteViews.setTextViewText(a.b.a().eT, this.f560a.getResources().getString(R.string.music_name));
        remoteViews.setTextViewText(a.b.a().eU, this.f560a.getResources().getString(R.string.music_author));
        remoteViews.setImageViewResource(a.b.a().eV, a.b.a().eW);
        remoteViews.setTextViewText(a.b.a().am, "00:00");
        remoteViews.setTextViewText(a.b.a().an, "00:00");
        remoteViews.setProgressBar(a.b.a().ap, 1000, 0, false);
    }

    public PendingIntent a(Context context, String str) {
        return PendingIntent.getService(context, 0, new Intent(str), 0);
    }

    public String a(long j2) {
        long j3 = j2 / 60000;
        long jRound = Math.round((j2 % 60000) / 1000.0f);
        String str = String.valueOf(j3 < 10 ? String.valueOf("") + "0" : "") + j3 + ":";
        if (jRound < 10) {
            str = String.valueOf(str) + "0";
        }
        return String.valueOf(str) + jRound;
    }

    @Override // com.syu.widget.a.l
    void a() {
        this.d = a.b.a().fQ;
    }

    @Override // com.syu.widget.a.l
    void a(RemoteViews remoteViews) {
        int iMax;
        com.syu.d.a.b("updateViews");
        if (Launcher.K == 8) {
            if (MusicService.d.booleanValue()) {
                int i2 = a.b.a().fT;
                int i3 = a.b.a().fV;
                int i4 = this.k;
                this.k = i4 + 1;
                remoteViews.setImageViewResource(i2, i3 + i4);
                if (this.k == 10) {
                    this.k = 0;
                }
                if (!this.l) {
                    LauncherApplication.b.post(this.m);
                    this.l = true;
                }
            } else {
                LauncherApplication.b.removeCallbacks(this.m);
                this.l = false;
            }
        } else if (Launcher.K == 3 && Launcher.ac == 1) {
            int i5 = a.b.a().fU;
            int i6 = a.b.a().fV;
            int i7 = this.k;
            this.k = i7 + 1;
            remoteViews.setImageViewResource(i5, i6 + i7);
            if (this.k == 10) {
                this.k = 0;
            }
            if (!this.l) {
                LauncherApplication.b.post(this.m);
                this.l = true;
            }
        } else {
            LauncherApplication.b.removeCallbacks(this.m);
            this.l = false;
        }
        if (MusicService.c != null) {
            if (MusicService.c.equals("") || MusicService.c.lastIndexOf("/") < 0) {
                com.syu.d.a.b("MusicService.music_path" + MusicService.c);
                remoteViews.setTextViewText(a.b.a().eT, this.f560a.getResources().getString(R.string.music_name));
            } else {
                remoteViews.setTextViewText(a.b.a().eT, MusicService.c.substring(MusicService.c.lastIndexOf("/") + 1));
            }
        }
        if (MusicService.c != null && !MusicService.c.equals(this.h)) {
            this.h = MusicService.c;
            byte[] bArr = new com.syu.g.k().a(MusicService.c).d;
            if (bArr == null || bArr.length <= 0) {
                remoteViews.setImageViewResource(a.b.a().eV, a.b.a().ag);
            } else {
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                if (bitmapDecodeByteArray != null) {
                    if (LauncherApplication.f88a.getResources().getBoolean(R.bool.music_bitmap_circular)) {
                        bitmapDecodeByteArray = a(bitmapDecodeByteArray);
                    }
                    remoteViews.setImageViewBitmap(a.b.a().eV, bitmapDecodeByteArray);
                }
            }
        }
        if (MusicService.b != null) {
            if (MusicService.b.equals("")) {
                remoteViews.setTextViewText(a.b.a().eU, this.f560a.getResources().getString(R.string.music_author));
            } else {
                remoteViews.setTextViewText(a.b.a().eU, MusicService.b);
            }
        }
        if (MusicService.d.booleanValue()) {
            remoteViews.setImageViewResource(a.b.a().aw, a.b.a().ae);
        } else {
            remoteViews.setImageViewResource(a.b.a().aw, a.b.a().ad);
        }
        if (MusicService.h >= 0) {
            long j2 = MusicService.h;
            long j3 = MusicService.g;
            if (j3 > 0) {
                if (j2 < 0) {
                    j2 = 0;
                }
                remoteViews.setProgressBar(a.b.a().ap, 1000, (int) ((1000 * j2) / j3), false);
            } else {
                remoteViews.setProgressBar(a.b.a().ap, 1000, 0, false);
            }
            String strA = a(j2);
            String strA2 = a(j3);
            remoteViews.setTextViewText(a.b.a().am, strA);
            remoteViews.setTextViewText(a.b.a().an, strA2);
        }
        if (Launcher.U > 5000) {
            remoteViews.setTextViewText(a.b.a().bh, "FM");
            remoteViews.setTextViewText(a.b.a().bj, "MHz");
        } else if (Launcher.U < 5000 && Launcher.U > 500) {
            remoteViews.setTextViewText(a.b.a().bh, "AM");
            remoteViews.setTextViewText(a.b.a().bj, "KHz");
        }
        remoteViews.setTextViewText(a.b.a().bk, Launcher.V);
        if (Launcher.aa != null) {
            remoteViews.setTextViewText(a.b.a().by, Launcher.aa);
        } else {
            remoteViews.setTextViewText(a.b.a().by, this.f560a.getResources().getString(R.string.music_name));
        }
        if (Launcher.ab != null) {
            remoteViews.setTextViewText(a.b.a().bz, Launcher.ab);
        } else {
            remoteViews.setTextViewText(a.b.a().bz, this.f560a.getResources().getString(R.string.music_author));
        }
        if (Launcher.ac == 1) {
            remoteViews.setImageViewResource(a.b.a().bG, a.b.a().ae);
        } else {
            remoteViews.setImageViewResource(a.b.a().bG, a.b.a().ad);
        }
        if (Launcher.ad == 0) {
            remoteViews.setTextViewText(a.b.a().by, this.f560a.getResources().getString(R.string.music_name));
            remoteViews.setTextViewText(a.b.a().bz, this.f560a.getResources().getString(R.string.music_author));
        }
        if (com.syu.a.a.g == 0) {
            e(remoteViews);
        } else if (com.syu.a.a.g != 8 && (com.syu.a.a.g == 1 || com.syu.a.a.g == 3)) {
            e(remoteViews);
        }
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
            remoteViews.setViewVisibility(j[0], 8);
            remoteViews.setImageViewResource(j[0], 0);
        } else if (length > 3) {
            remoteViews.setViewVisibility(j[0], 0);
        }
        for (int i8 = 0; i8 < length; i8++) {
            try {
                if (charArray[i8] != ':' && (iMax = Math.max(0, Math.min(Integer.parseInt(new String(new char[]{charArray[i8]})), i.length - 1))) >= 0) {
                    remoteViews.setImageViewResource(j[Math.max(0, Math.min(length > 3 ? i8 : i8 + 1, j.length - 1))], i[iMax]);
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
        Intent intent = new Intent("syu.widget.start");
        intent.setComponent(new ComponentName("com.syu.music", "com.syu.music.MAct"));
        remoteViews.setOnClickPendingIntent(a.b.a().eX, PendingIntent.getActivity(this.f560a, 0, intent, 0));
        Intent intent2 = new Intent("syu.widget.start");
        intent2.setComponent(new ComponentName("com.syu.radio", "com.syu.radio.Launch"));
        remoteViews.setOnClickPendingIntent(a.b.a().eY, PendingIntent.getActivity(this.f560a, 0, intent2, 0));
        Intent intent3 = new Intent("syu.widget.start");
        intent3.setComponent(new ComponentName("com.syu.bt", "com.syu.bt.act.ActBtAvStart"));
        remoteViews.setOnClickPendingIntent(a.b.a().eZ, PendingIntent.getActivity(this.f560a, 0, intent3, 0));
        remoteViews.setOnClickPendingIntent(a.b.a().ff, PendingIntent.getActivity(this.f560a, 0, new Intent("android.settings.DATE_SETTINGS"), 0));
        remoteViews.setOnClickPendingIntent(a.b.a().as, a(this.f560a, "com.syu.music.prev"));
        remoteViews.setOnClickPendingIntent(a.b.a().aw, a(this.f560a, "com.syu.music.playpause"));
        remoteViews.setOnClickPendingIntent(a.b.a().au, a(this.f560a, "com.syu.music.next"));
        remoteViews.setOnClickPendingIntent(a.b.a().bl, a(this.f560a, "com.syu.radio.prevservice"));
        remoteViews.setOnClickPendingIntent(a.b.a().bn, a(this.f560a, "com.syu.radio.nextservice"));
        remoteViews.setOnClickPendingIntent(a.b.a().bE, a(this.f560a, "com.syu.bt.byav.widgetPrev"));
        remoteViews.setOnClickPendingIntent(a.b.a().bG, a(this.f560a, "com.syu.bt.byav.widgetPlayPause"));
        remoteViews.setOnClickPendingIntent(a.b.a().bF, a(this.f560a, "com.syu.bt.byav.widgetNext"));
    }

    @Override // com.syu.widget.a.l
    public void c() {
        h.b(this);
        super.c();
    }
}
