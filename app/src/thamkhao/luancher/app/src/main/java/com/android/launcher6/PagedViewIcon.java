package com.android.launcher6;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class PagedViewIcon extends TextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ly f93a;
    private boolean b;
    private Bitmap c;
    private AttributeSet d;

    public PagedViewIcon(Context context) {
        this(context, null);
    }

    public PagedViewIcon(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagedViewIcon(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = false;
        a(attributeSet);
    }

    private String a(int i, String str) {
        String string = "";
        try {
            string = getResources().getString(i);
        } catch (Exception e) {
        }
        return TextUtils.isEmpty(string) ? str : string;
    }

    private void a(AttributeSet attributeSet) {
        this.d = attributeSet;
    }

    private void a(View view, int i) {
        for (com.fyt.b.c.b bVar : com.fyt.b.g.d().a()) {
            if (bVar.b() == view) {
                for (com.fyt.b.c.a aVar : bVar.a()) {
                    if (aVar.a().equals("drawableTop")) {
                        aVar.a(i);
                    }
                    if (aVar.a().equals("tag")) {
                        aVar.a(R.id.str_tag);
                    }
                }
                return;
            }
        }
    }

    public void a() {
        this.b = true;
    }

    public void a(d dVar, boolean z, ly lyVar) {
        this.c = dVar.b;
        this.f93a = lyVar;
        switch (LauncherApplication.f88a.getResources().getInteger(R.integer.appNameAlign)) {
            case 0:
                setCompoundDrawables(my.a(this.c), null, null, null);
                break;
            case 1:
                setCompoundDrawables(null, my.a(this.c), null, null);
                break;
            case 2:
                setCompoundDrawables(null, null, my.a(this.c), null);
                break;
            case 3:
                setCompoundDrawables(null, null, null, my.a(this.c));
                break;
        }
        setCompoundDrawablePadding(LauncherApplication.f88a.getResources().getInteger(R.integer.pagetextview_padding));
        if ("com.syu.voice.VoiceLaunch".equals(dVar.d.getClassName()) || "com.syu.voice.Launch".equals(dVar.d.getClassName())) {
            String str = SystemProperties.get("syu.voicename");
            String str2 = SystemProperties.get("persist.syu.voice.newname");
            if (str2 != null && !str2.equals("")) {
                setText("车助理·" + str2);
            } else if (str == null || str.equals("")) {
                setText(dVar.q);
            } else {
                setText("车助理·" + str);
            }
        } else if ("com.syu.music.MAct".equals(dVar.f170a.getComponent().getClassName())) {
            setText(getResources().getString(R.string.car_music));
        } else if ("com.syu.video.main.VideoListActivity".equals(dVar.f170a.getComponent().getClassName())) {
            setText(getResources().getString(R.string.car_video));
        } else if ("com.syu.eq".equals(dVar.f170a.getComponent().getPackageName())) {
            setText(a(a.b.a().fW, dVar.q.toString()));
        } else {
            setText(dVar.q);
        }
        if (LauncherApplication.f88a.getResources().getBoolean(R.bool.apps_shortname) && getText().length() > 4) {
            setText(String.valueOf(getText().toString().substring(0, 3)) + "...");
        }
        setTag(dVar);
        setTag(R.id.str_tag, dVar.d());
        a(this, dVar.a());
    }

    public void b() {
        this.b = false;
        post(new lx(this));
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (getCurrentTextColor() == getResources().getColor(android.R.color.transparent)) {
            getPaint().clearShadowLayer();
            super.draw(canvas);
            return;
        }
        getPaint().setShadowLayer(BubbleTextView.f72a, 0.0f, 2.0f, -587202560);
        super.draw(canvas);
        canvas.save(2);
        getPaint().setShadowLayer(BubbleTextView.b, 0.0f, 0.0f, -872415232);
        super.draw(canvas);
        canvas.restore();
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        setFocusable(false);
        if (!isPressed()) {
            if (this.b) {
                return;
            }
            setAlpha(1.0f);
        } else {
            setAlpha(0.4f);
            if (this.f93a != null) {
                this.f93a.a(this);
            }
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        setTextSize(2, ip.a().i().a().g);
    }
}
