package com.syu.g;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import com.android.launcher6.mi;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static d f533a = null;
    public static List b;

    static {
        b = null;
        b = new ArrayList();
    }

    public static int a(ActivityInfo activityInfo) {
        int iIndexOf;
        e eVar = new e(activityInfo.packageName, activityInfo.name, 0);
        if (!b.contains(eVar) || (iIndexOf = b.indexOf(eVar)) < 0) {
            return 0;
        }
        e eVar2 = (e) b.get(iIndexOf);
        Log.e("lunch", String.format("pkg:%s, clazz:%s, icon:%d", eVar2.f534a, eVar2.b, Integer.valueOf(eVar2.c)));
        return eVar2.c;
    }

    public static void a(Context context, int i) {
        try {
            XmlResourceParser xml = context.getResources().getXml(i);
            AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
            a(xml, "customicons");
            int depth = xml.getDepth();
            while (true) {
                int next = xml.next();
                if ((next == 3 && xml.getDepth() <= depth) || next == 1) {
                    return;
                }
                if (next == 2) {
                    String name = xml.getName();
                    TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSetAsAttributeSet, mi.Entry);
                    if ("entry".equals(name)) {
                        a(typedArrayObtainStyledAttributes.getString(0), typedArrayObtainStyledAttributes.getString(1), typedArrayObtainStyledAttributes.getResourceId(2, 0));
                    }
                    typedArrayObtainStyledAttributes.recycle();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(String str, String str2, int i) {
        e eVar = new e(str, str2, i);
        if (b.contains(eVar)) {
            return;
        }
        b.add(eVar);
    }

    private static void a(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        if (!xmlPullParser.getName().equals(str)) {
            throw new XmlPullParserException("Unexpected start tag: found " + xmlPullParser.getName() + ", expected " + str);
        }
    }
}
