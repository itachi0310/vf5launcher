package com.fyt.b;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.android.launcher6.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List f473a = new ArrayList();
    private static String c = "";
    private ArrayList b = new ArrayList();

    static {
        f473a.add("background");
        f473a.add("src");
        f473a.add("textColor");
        f473a.add("drawableLeft");
        f473a.add("drawableTop");
        f473a.add("drawableRight");
        f473a.add("drawableBottom");
    }

    public b() {
        for (String str : d.a().getResources().getStringArray(R.array.filter)) {
            c = String.valueOf(c) + str;
        }
    }

    private String a(Context context, int i) {
        return context.getString(i);
    }

    public ArrayList a() {
        return this.b;
    }

    public void a(View view, AttributeSet attributeSet) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < attributeSet.getAttributeCount(); i++) {
            String attributeName = attributeSet.getAttributeName(i);
            if (attributeName.equals("tag") && c.contains(a(view.getContext(), Integer.parseInt(attributeSet.getAttributeValue(i).substring(1))))) {
                return;
            }
            if (f473a.contains(attributeName)) {
                String attributeValue = attributeSet.getAttributeValue(i);
                if (!attributeValue.startsWith("#")) {
                    int i2 = attributeValue.startsWith("?") ? com.fyt.b.b.b.a(view.getContext(), new int[]{Integer.parseInt(attributeValue.substring(1))})[0] : Integer.parseInt(attributeValue.substring(1));
                    if (i2 != 0) {
                        view.getContext().getResources().getResourceEntryName(i2);
                        arrayList.add(new com.fyt.b.c.a(attributeName, i2));
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        com.fyt.b.c.b bVar = new com.fyt.b.c.b(view, arrayList);
        bVar.c();
        this.b.add(bVar);
    }

    public void b() {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((com.fyt.b.c.b) it.next()).c();
        }
    }
}
