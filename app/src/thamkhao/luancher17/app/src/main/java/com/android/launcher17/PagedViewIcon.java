package com.android.launcher17;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.fyt.skin.SkinUtils;
import com.fyt.skin.view.SkinAttrParms;
import com.fyt.skin.view.SkinView;
import com.fyt.widget.AppIconTextView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class PagedViewIcon extends AppIconTextView {
    private static final float PRESS_ALPHA = 0.4f;
    private static final String TAG = "PagedViewIcon";
    private AttributeSet mAttributeSet;
    private Bitmap mIcon;
    private boolean mLockDrawableState;
    private PressedCallback mPressedCallback;

    public interface PressedCallback {
        void iconPressed(PagedViewIcon pagedViewIcon);
    }

    public PagedViewIcon(Context context) {
        this(context, null);
    }

    public PagedViewIcon(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PagedViewIcon(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mLockDrawableState = false;
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        this.mAttributeSet = attrs;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        LauncherAppState app = LauncherAppState.getInstance();
        DeviceProfile grid = app.getDynamicGrid().getDeviceProfile();
        setTextSize(2, grid.iconTextSize);
    }

    public void applyFromApplicationInfo(AppInfo info, boolean scaleUp, PressedCallback cb) {
        setAppIcon(info.appIcon);
        this.mIcon = info.iconBitmap;
        this.mPressedCallback = cb;
        switch (LauncherApplication.sApp.getResources().getInteger(R.integer.appNameAlign)) {
            case 0:
                setCompoundDrawables(Utilities.createIconDrawable(this.mIcon), null, null, null);
                break;
            case 1:
                setCompoundDrawables(null, Utilities.createIconDrawable(this.mIcon), null, null);
                break;
            case 2:
                setCompoundDrawables(null, null, Utilities.createIconDrawable(this.mIcon), null);
                break;
            case 3:
                setCompoundDrawables(null, null, null, Utilities.createIconDrawable(this.mIcon));
                break;
        }
        int padding = LauncherApplication.sApp.getResources().getInteger(R.integer.pagetextview_padding);
        setCompoundDrawablePadding(padding);
        if ("com.syu.voice.VoiceLaunch".equals(info.componentName.getClassName()) || "com.syu.voice.Launch".equals(info.componentName.getClassName())) {
            String voicename = SystemProperties.get("syu.voicename");
            String voicenewname = SystemProperties.get("persist.syu.voice.newname");
            if (voicenewname != null && !voicenewname.equals("")) {
                setText("车助理·" + voicenewname);
            } else if (voicename != null && !voicename.equals("")) {
                setText("车助理·" + voicename);
            } else {
                setText(info.title);
            }
        } else if ("net.easyconn".equals(info.intent.getComponent().getPackageName())) {
            setText(getResources().getString(R.string.car_easyconn));
        } else {
            setText(info.title);
        }
        if (LauncherApplication.sApp.getResources().getBoolean(R.bool.apps_shortname) && getText().length() > 4) {
            setText(String.valueOf(getText().toString().substring(0, 3)) + "...");
        }
        setTag(info);
        addResourceId(this, info.getIconResid());
    }

    private void addResourceId(View view, int resid) {
        ArrayList<SkinView> skinViews = SkinUtils.getSkinAttr().getSkinViews();
        for (SkinView skinView : skinViews) {
            if (skinView.getView() == view) {
                for (SkinAttrParms sap : skinView.getParms()) {
                    if (sap.getAttrName().equals("drawableTop")) {
                        sap.setId(resid);
                    }
                }
                return;
            }
        }
    }

    private String getStr(int resid, String title) {
        String appName = "";
        try {
            appName = getResources().getString(resid);
        } catch (Exception e) {
        }
        if (TextUtils.isEmpty(appName)) {
            return title;
        }
        String title2 = appName;
        return title2;
    }

    public void lockDrawableState() {
        this.mLockDrawableState = true;
    }

    public void resetDrawableState() {
        this.mLockDrawableState = false;
        post(new Runnable() { // from class: com.android.launcher17.PagedViewIcon.1
            @Override // java.lang.Runnable
            public void run() {
                PagedViewIcon.this.refreshDrawableState();
            }
        });
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        setFocusable(false);
        if (isPressed()) {
            setAlpha(PRESS_ALPHA);
            if (this.mPressedCallback != null) {
                this.mPressedCallback.iconPressed(this);
                return;
            }
            return;
        }
        if (!this.mLockDrawableState) {
            setAlpha(1.0f);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (getCurrentTextColor() == getResources().getColor(android.R.color.transparent)) {
            getPaint().clearShadowLayer();
            super.draw(canvas);
            return;
        }
        getPaint().setShadowLayer(BubbleTextView.SHADOW_LARGE_RADIUS, 0.0f, 2.0f, -587202560);
        super.draw(canvas);
        canvas.save(2);
        getPaint().setShadowLayer(BubbleTextView.SHADOW_SMALL_RADIUS, 0.0f, 0.0f, -872415232);
        super.draw(canvas);
        canvas.restore();
    }
}
