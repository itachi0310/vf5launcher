package com.fyt.skin;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class SkinResources {
    private Resources appResources;
    protected boolean isDefaultSkin = true;
    private Context mContext;
    private String mSkinPkgName;
    private Resources skinResources;

    protected SkinResources(Context context) {
        this.mContext = context;
        this.appResources = context.getResources();
    }

    public void applySkin(Resources resources, String pkgName) {
        this.skinResources = resources;
        this.mSkinPkgName = pkgName;
        this.isDefaultSkin = TextUtils.isEmpty(pkgName) || resources == null;
    }

    public int getIdentifier(int resid) {
        if (!this.isDefaultSkin) {
            String resName = this.appResources.getResourceEntryName(resid);
            String resType = this.appResources.getResourceTypeName(resid);
            int skinid = this.skinResources.getIdentifier(resName, resType, this.mSkinPkgName);
            return skinid;
        }
        return resid;
    }

    public void reset() {
        this.mSkinPkgName = "";
        this.skinResources = null;
        this.isDefaultSkin = true;
    }

    public int getColor(int resid) {
        if (this.isDefaultSkin) {
            return this.appResources.getColor(resid);
        }
        int skinid = getIdentifier(resid);
        if (skinid == 0) {
            return this.appResources.getColor(resid);
        }
        return this.skinResources.getColor(skinid);
    }

    public ColorStateList getColorStateList(int resid) {
        if (this.isDefaultSkin) {
            return this.appResources.getColorStateList(resid);
        }
        int skinid = getIdentifier(resid);
        if (skinid == 0) {
            return this.appResources.getColorStateList(resid);
        }
        return this.skinResources.getColorStateList(skinid);
    }

    public Drawable getDrawable(int resid) {
        int skinid;
        Drawable drawable;
        try {
            if (this.isDefaultSkin || (skinid = getIdentifier(resid)) == 0) {
                drawable = this.appResources.getDrawable(resid);
            } else {
                drawable = this.skinResources.getDrawable(skinid);
            }
            return drawable;
        } catch (Exception e) {
            return this.appResources.getDrawable(resid);
        }
    }

    public Bitmap getBitmap(int resid) {
        if (this.isDefaultSkin) {
            return BitmapFactory.decodeResource(this.appResources, resid);
        }
        int skinid = getIdentifier(resid);
        if (skinid == 0) {
            return BitmapFactory.decodeResource(this.appResources, resid);
        }
        return BitmapFactory.decodeResource(this.skinResources, skinid);
    }

    public Object getBackground(int resid) {
        String resourceTypeName = "";
        try {
            resourceTypeName = this.appResources.getResourceTypeName(resid);
        } catch (Resources.NotFoundException e) {
            Log.d("LZP", "resid:" + resid);
        }
        if (resourceTypeName.equals("color")) {
            return Integer.valueOf(getColor(resid));
        }
        return getDrawable(resid);
    }

    public String getString(int resid) {
        String string;
        try {
            if (this.isDefaultSkin) {
                string = this.appResources.getString(resid);
            } else {
                int skinid = getIdentifier(resid);
                if (skinid == 0) {
                    string = this.appResources.getString(skinid);
                } else {
                    string = this.skinResources.getString(skinid);
                }
            }
            return string;
        } catch (Resources.NotFoundException e) {
            return null;
        }
    }

    public boolean isDefaultRes() {
        return this.isDefaultSkin;
    }

    public Typeface getTypeface(int resid) {
        Typeface typefaceCreateFromAsset;
        String skinTypefacePath = getString(resid);
        if (TextUtils.isEmpty(skinTypefacePath)) {
            return Typeface.DEFAULT;
        }
        try {
            if (this.isDefaultSkin) {
                typefaceCreateFromAsset = Typeface.createFromAsset(this.appResources.getAssets(), skinTypefacePath);
            } else {
                typefaceCreateFromAsset = Typeface.createFromAsset(this.skinResources.getAssets(), skinTypefacePath);
            }
            return typefaceCreateFromAsset;
        } catch (RuntimeException e) {
            return Typeface.DEFAULT;
        }
    }
}
