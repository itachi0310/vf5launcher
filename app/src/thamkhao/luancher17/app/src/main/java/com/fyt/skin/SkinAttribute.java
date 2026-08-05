package com.fyt.skin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.android.launcher17.R;
import com.fyt.skin.util.SkinThemeUitls;
import com.fyt.skin.view.SkinAttrParms;
import com.fyt.skin.view.SkinView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SkinAttribute {
    private static final String SKIN_TAG = "tag";
    private ArrayList<SkinView> skinViews = new ArrayList<>();
    public static final List<String> list = new ArrayList();
    private static String filter = "";

    static {
        list.add("background");
        list.add("src");
        list.add("textColor");
        list.add("drawableLeft");
        list.add("drawableTop");
        list.add("drawableRight");
        list.add("drawableBottom");
    }

    public ArrayList<SkinView> getSkinViews() {
        return this.skinViews;
    }

    public SkinAttribute() {
        String[] str = SkinManager.getContext().getResources().getStringArray(R.array.filter);
        for (String str2 : str) {
            filter = String.valueOf(filter) + str2;
        }
    }

    private String ResToString(Context context, int resid) {
        return context.getString(resid);
    }

    public void loadView(View view, AttributeSet attrs) {
        int id;
        ArrayList<SkinAttrParms> skinAttrParms = new ArrayList<>();
        for (int i = 0; i < attrs.getAttributeCount(); i++) {
            String attributeName = attrs.getAttributeName(i);
            if (attributeName.equals(SKIN_TAG)) {
                try {
                    int tagid = Integer.parseInt(attrs.getAttributeValue(i).substring(1));
                    String tag = ResToString(view.getContext(), tagid);
                    if (filter.contains(tag)) {
                        return;
                    }
                } catch (Exception e) {
                }
            }
            if (list.contains(attributeName)) {
                String attributeValue = attrs.getAttributeValue(i);
                if (!attributeValue.startsWith("#")) {
                    if (attributeValue.startsWith("?")) {
                        int attrid = Integer.parseInt(attributeValue.substring(1));
                        id = SkinThemeUitls.getThemeResid(view.getContext(), new int[]{attrid})[0];
                    } else {
                        id = Integer.parseInt(attributeValue.substring(1));
                    }
                    if (id != 0) {
                        view.getContext().getResources().getResourceEntryName(id);
                        SkinAttrParms attrParms = new SkinAttrParms(attributeName, id);
                        skinAttrParms.add(attrParms);
                    }
                }
            }
        }
        if (!skinAttrParms.isEmpty()) {
            SkinView skinView = new SkinView(view, skinAttrParms);
            skinView.applySkin();
            this.skinViews.add(skinView);
        }
    }

    public void loadView(View view, ArrayList<SkinAttrParms> attrParms) {
        if (!attrParms.isEmpty()) {
            SkinView skinView = new SkinView(view, attrParms);
            skinView.applySkin();
            this.skinViews.add(skinView);
        }
    }

    public void applySkin() {
        for (SkinView skinView : this.skinViews) {
            skinView.applySkin();
        }
    }
}
