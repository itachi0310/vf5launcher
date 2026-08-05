package com.syu.util;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.android.launcher17.LauncherApplication;

/* JADX INFO: loaded from: classes.dex */
public class Utils {
    public static LauncherApplication getCtx() {
        return LauncherApplication.sApp;
    }

    public static Resources getRes() {
        return getCtx().getResources();
    }

    public static boolean getNameToBool(String name) {
        try {
            Resources res = getCtx().getResources();
            return res.getBoolean(res.getIdentifier(name, "bool", getCtx().getPackageName()));
        } catch (Exception e) {
            return false;
        }
    }

    public static String getNameToStr(String name) {
        try {
            Resources res = getCtx().getResources();
            return res.getString(res.getIdentifier(name, "string", getCtx().getPackageName()));
        } catch (Exception e) {
            return "";
        }
    }

    public static int getNameToInteger(String name) {
        try {
            Resources res = getCtx().getResources();
            return res.getInteger(res.getIdentifier(name, "integer", getCtx().getPackageName()));
        } catch (Exception e) {
            return 0;
        }
    }

    public static void setTextId(TextView v, int id) {
        if (v != null) {
            v.setText(id);
        }
    }

    public static void setTextStr(TextView v, String str) {
        if (v != null) {
            v.setText(str);
        }
    }

    public static void setGone(View v) {
        if (v != null) {
            v.setVisibility(8);
        }
    }

    public static void setVisible(View v) {
        if (v != null) {
            v.setVisibility(0);
        }
    }
}
