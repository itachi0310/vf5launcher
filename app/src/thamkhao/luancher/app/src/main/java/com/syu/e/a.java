package com.syu.e;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.SeekBar;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class a extends PopupWindow implements SeekBar.OnSeekBarChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f520a;
    private int b;
    private View c;
    private SeekBar d;
    private TextView e;
    private CountDownTimer f = new b(this, 5000, 1000);

    public a(Context context, int i) {
        this.f520a = context;
        this.b = i;
        a();
    }

    private void a() {
        setContentView(this.c);
        setWidth(479);
        setHeight(80);
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new BitmapDrawable());
        setTouchInterceptor(new c(this));
        b();
    }

    private void b() {
        this.d.setProgress(this.b);
    }

    public void a(View view) {
        if (isShowing()) {
            dismiss();
        } else {
            showAtLocation(view, 17, 0, 0);
            this.f.start();
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        this.e.setText(new StringBuilder().append(i).toString());
        com.syu.a.a.a(this.f520a).a().a(0, 10, i);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}
