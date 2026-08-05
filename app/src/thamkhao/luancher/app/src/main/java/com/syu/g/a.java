package com.syu.g;

import android.app.ActivityOptions;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static boolean a(Context context, View view, Intent intent, Object obj) {
        boolean zB;
        if (intent == null) {
            Toast.makeText(context, "2131492876intent= null", 0).show();
            return false;
        }
        try {
            zB = b(context, view, intent, obj);
            if (zB) {
                return zB;
            }
            try {
                Toast.makeText(context, "2131492876:success", 0).show();
                return zB;
            } catch (ActivityNotFoundException e) {
                Toast.makeText(context, "2131492876-ActivityNotFound", 0).show();
                i.a().a("Unable to launch. tag=" + obj + " intent=" + intent);
                return zB;
            }
        } catch (ActivityNotFoundException e2) {
            zB = false;
        }
    }

    static boolean b(Context context, View view, Intent intent, Object obj) {
        try {
            intent.addFlags(268435456);
            if ((view == null || intent.hasExtra("com.android.launcher6.intent.extra.shortcut.INGORE_LAUNCH_ANIMATION")) ? false : true) {
                context.startActivity(intent, ActivityOptions.makeScaleUpAnimation(view, 0, 0, view.getMeasuredWidth(), view.getMeasuredHeight()).toBundle());
                return true;
            }
            context.startActivity(intent);
            return true;
        } catch (SecurityException e) {
            Toast.makeText(context, "2131492876---startActivity", 0).show();
            return false;
        }
    }
}
