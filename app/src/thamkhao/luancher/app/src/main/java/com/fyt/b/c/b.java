package com.fyt.b.c;

import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.launcher6.R;
import com.android.launcher6.my;
import com.fyt.b.d;
import com.fyt.b.f;
import com.fyt.b.g;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    View f476a;
    List b;

    public b(View view, List list) {
        this.f476a = view;
        this.b = list;
    }

    public List a() {
        return this.b;
    }

    public View b() {
        return this.f476a;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void c() {
        Drawable drawableD;
        Drawable drawableD2;
        BitmapDrawable bitmapDrawable;
        Drawable drawableD3;
        Bitmap bitmapD;
        f fVarB = g.b();
        for (a aVar : this.b) {
            String strA = aVar.a();
            switch (strA.hashCode()) {
                case -2056911842:
                    if (strA.equals("drawableRight")) {
                        drawableD = null;
                        drawableD2 = fVarB.d(aVar.b());
                        bitmapDrawable = null;
                        drawableD3 = null;
                    } else {
                        drawableD = null;
                        drawableD2 = null;
                        bitmapDrawable = null;
                        drawableD3 = null;
                    }
                    break;
                case -1332194002:
                    if (strA.equals("background")) {
                        Object objE = fVarB.e(aVar.b());
                        if (objE instanceof Integer) {
                            this.f476a.setBackgroundColor(((Integer) objE).intValue());
                            drawableD = null;
                            drawableD2 = null;
                            bitmapDrawable = null;
                            drawableD3 = null;
                        } else {
                            this.f476a.setBackground((Drawable) objE);
                            drawableD = null;
                            drawableD2 = null;
                            bitmapDrawable = null;
                            drawableD3 = null;
                        }
                    } else {
                        drawableD = null;
                        drawableD2 = null;
                        bitmapDrawable = null;
                        drawableD3 = null;
                    }
                    break;
                case -1063571914:
                    if (strA.equals("textColor")) {
                        ((TextView) this.f476a).setTextColor(fVarB.c(aVar.b()));
                        drawableD = null;
                        drawableD2 = null;
                        bitmapDrawable = null;
                        drawableD3 = null;
                    } else {
                        drawableD = null;
                        drawableD2 = null;
                        bitmapDrawable = null;
                        drawableD3 = null;
                    }
                    break;
                case 114148:
                    if (strA.equals("src")) {
                        Object objE2 = fVarB.e(aVar.b());
                        if (objE2 instanceof Integer) {
                            ((ImageView) this.f476a).setImageDrawable(new ColorDrawable(((Integer) objE2).intValue()));
                            drawableD = null;
                            drawableD2 = null;
                            bitmapDrawable = null;
                            drawableD3 = null;
                        } else {
                            ((ImageView) this.f476a).setImageDrawable((Drawable) objE2);
                            drawableD = null;
                            drawableD2 = null;
                            bitmapDrawable = null;
                            drawableD3 = null;
                        }
                    } else {
                        drawableD = null;
                        drawableD2 = null;
                        bitmapDrawable = null;
                        drawableD3 = null;
                    }
                    break;
                case 208115817:
                    if (strA.equals("drawableBottom")) {
                        drawableD = fVarB.d(aVar.b());
                        drawableD2 = null;
                        bitmapDrawable = null;
                        drawableD3 = null;
                    } else {
                        drawableD = null;
                        drawableD2 = null;
                        bitmapDrawable = null;
                        drawableD3 = null;
                    }
                    break;
                case 574397399:
                    if (!strA.equals("drawableTop")) {
                        drawableD = null;
                        drawableD2 = null;
                        bitmapDrawable = null;
                        drawableD3 = null;
                    } else if (aVar.b() != 0) {
                        drawableD = null;
                        drawableD2 = null;
                        bitmapDrawable = new BitmapDrawable(my.c(fVarB.d(aVar.b())));
                        drawableD3 = null;
                    } else {
                        PackageManager packageManager = d.a().getPackageManager();
                        try {
                            String str = (String) this.f476a.getTag(R.id.str_tag);
                            bitmapD = str != null ? my.d(packageManager.getApplicationIcon(str)) : null;
                        } catch (PackageManager.NameNotFoundException e) {
                            e.printStackTrace();
                        }
                        drawableD2 = null;
                        bitmapDrawable = new BitmapDrawable(bitmapD);
                        drawableD3 = null;
                        drawableD = null;
                    }
                    break;
                case 626202053:
                    if (strA.equals("drawableLeft")) {
                        drawableD = null;
                        drawableD2 = null;
                        bitmapDrawable = null;
                        drawableD3 = fVarB.d(aVar.b());
                    } else {
                        drawableD = null;
                        drawableD2 = null;
                        bitmapDrawable = null;
                        drawableD3 = null;
                    }
                    break;
                default:
                    drawableD = null;
                    drawableD2 = null;
                    bitmapDrawable = null;
                    drawableD3 = null;
                    break;
            }
            if (drawableD3 != null || drawableD2 != null || bitmapDrawable != null || drawableD != null) {
                ((TextView) this.f476a).setCompoundDrawablesWithIntrinsicBounds(drawableD3, bitmapDrawable, drawableD2, drawableD);
            }
        }
    }
}
