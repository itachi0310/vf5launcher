package com.fyt.skin.view;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.launcher17.R;
import com.android.launcher17.Utilities;
import com.fyt.skin.SkinResources;
import com.fyt.skin.SkinUtils;
import com.fyt.widget.AppIconTextView;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SkinView {
    List<SkinAttrParms> parms;
    View view;

    public List<SkinAttrParms> getParms() {
        return this.parms;
    }

    public SkinView(View view, List<SkinAttrParms> parms) {
        this.view = view;
        this.parms = parms;
    }

    public View getView() {
        return this.view;
    }

    public void setView(View view) {
        this.view = view;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void applySkin() {
        SkinResources skinResources = SkinUtils.getSkinResources();
        for (SkinAttrParms parms : this.parms) {
            Drawable left = null;
            Drawable top = null;
            Drawable right = null;
            Drawable bottom = null;
            String attrName = parms.getAttrName();
            switch (attrName.hashCode()) {
                case -2056911842:
                    if (attrName.equals("drawableRight")) {
                        right = skinResources.getDrawable(parms.getId());
                    }
                    break;
                case -1332194002:
                    if (attrName.equals("background")) {
                        Object background = skinResources.getBackground(parms.getId());
                        if (background instanceof Integer) {
                            this.view.setBackgroundColor(((Integer) background).intValue());
                        } else {
                            this.view.setBackground((Drawable) background);
                        }
                    }
                    break;
                case -1063571914:
                    if (attrName.equals("textColor")) {
                        ((TextView) this.view).setTextColor(skinResources.getColorStateList(parms.getId()));
                    }
                    break;
                case 114148:
                    if (attrName.equals("src")) {
                        if (this.view.getTag() != null && this.view.getTag().equals("appicon")) {
                            Bitmap bitmap = null;
                            if (parms.getId() != 0) {
                                bitmap = Utilities.createIconBitmap_enlarge(skinResources.getDrawable(parms.getId()));
                            } else {
                                ImageView v = (ImageView) this.view;
                                if (v.getTag(R.id.str_appicon) != null) {
                                    Bitmap appInfo = (Bitmap) v.getTag(R.id.str_appicon);
                                    bitmap = Utilities.createIconBitmap_minify(new BitmapDrawable(appInfo));
                                }
                            }
                            if (bitmap != null) {
                                ((ImageView) this.view).setImageBitmap(bitmap);
                                return;
                            }
                        }
                        Object src = skinResources.getBackground(parms.getId());
                        if (src instanceof Integer) {
                            ((ImageView) this.view).setImageDrawable(new ColorDrawable(((Integer) src).intValue()));
                        } else {
                            ((ImageView) this.view).setImageDrawable((Drawable) src);
                        }
                    }
                    break;
                case 208115817:
                    if (attrName.equals("drawableBottom")) {
                        bottom = skinResources.getDrawable(parms.getId());
                    }
                    break;
                case 574397399:
                    if (attrName.equals("drawableTop")) {
                        Log.d("LZP", "drawableTop:" + this.view.getTag());
                        Bitmap bitmap2 = parms.getId() != 0 ? Utilities.createIconBitmap_enlarge(skinResources.getDrawable(parms.getId())) : Utilities.createIconBitmap_minify(new BitmapDrawable(((AppIconTextView) this.view).getAppIcon()));
                        top = new BitmapDrawable(bitmap2);
                    }
                    break;
                case 626202053:
                    if (attrName.equals("drawableLeft")) {
                        left = skinResources.getDrawable(parms.getId());
                    }
                    break;
            }
            if (left != null || right != null || top != null || bottom != null) {
                ((TextView) this.view).setCompoundDrawablesWithIntrinsicBounds(left, top, right, bottom);
            }
        }
    }
}
