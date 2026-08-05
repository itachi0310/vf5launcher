package com.android.launcher17;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.fyt.skin.SkinUtils;
import com.fyt.skin.view.SkinAttrParms;
import com.fyt.skin.view.SkinView;
import com.fyt.widget.AppIconTextView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class BubbleTextView extends AppIconTextView {
    static final float PADDING_H = 8.0f;
    static final float PADDING_V = 3.0f;
    static final int SHADOW_LARGE_COLOUR = -587202560;
    static final int SHADOW_SMALL_COLOUR = -872415232;
    static final float SHADOW_Y_OFFSET = 2.0f;
    private AttributeSet mAttributeSet;
    private Drawable mBackground;
    private boolean mBackgroundSizeChanged;
    private boolean mDidInvalidateForPressedState;
    private int mFocusedGlowColor;
    private int mFocusedOutlineColor;
    private boolean mIsTextVisible;
    private CheckLongPressHelper mLongPressHelper;
    private HolographicOutlineHelper mOutlineHelper;
    private int mPressedGlowColor;
    private Bitmap mPressedOrFocusedBackground;
    private int mPressedOutlineColor;
    private int mPrevAlpha;
    private boolean mShadowsEnabled;
    private boolean mStayPressed;
    private final Canvas mTempCanvas;
    private final Rect mTempRect;
    private int mTextColor;
    static float SHADOW_LARGE_RADIUS = LauncherApplication.shadow_Large_Radius;
    static float SHADOW_SMALL_RADIUS = LauncherApplication.shadow_Small_Radius;

    public BubbleTextView(Context context) {
        this(context, null);
    }

    public BubbleTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BubbleTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mPrevAlpha = -1;
        this.mTempCanvas = new Canvas();
        this.mTempRect = new Rect();
        this.mShadowsEnabled = true;
        init(attrs);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        LauncherAppState app = LauncherAppState.getInstance();
        DeviceProfile grid = app.getDynamicGrid().getDeviceProfile();
        setTextSize(2, grid.iconTextSize);
    }

    private void init(AttributeSet attrs) {
        this.mAttributeSet = attrs;
        this.mLongPressHelper = new CheckLongPressHelper(this);
        this.mBackground = getBackground();
        this.mOutlineHelper = HolographicOutlineHelper.obtain(getContext());
        Resources res = getContext().getResources();
        int color = res.getColor(R.color.outline_color);
        this.mPressedGlowColor = color;
        this.mPressedOutlineColor = color;
        this.mFocusedGlowColor = color;
        this.mFocusedOutlineColor = color;
        setShadowLayer(SHADOW_LARGE_RADIUS, 0.0f, SHADOW_Y_OFFSET, SHADOW_LARGE_COLOUR);
    }

    public void applyFromShortcutInfo(ShortcutInfo info, IconCache iconCache) {
        setAppIcon(info.getAppIcon());
        Bitmap b = info.getIcon(iconCache);
        LauncherAppState app = LauncherAppState.getInstance();
        app.getDynamicGrid().getDeviceProfile();
        switch (LauncherApplication.sApp.getResources().getInteger(R.integer.appNameAlign)) {
            case 0:
                setCompoundDrawables(Utilities.createIconDrawable(b), null, null, null);
                break;
            case 1:
                setCompoundDrawables(null, Utilities.createIconDrawable(b), null, null);
                break;
            case 2:
                setCompoundDrawables(null, null, Utilities.createIconDrawable(b), null);
                break;
            case 3:
                setCompoundDrawables(null, null, null, Utilities.createIconDrawable(b));
                break;
        }
        int padding = LauncherApplication.sApp.getResources().getInteger(R.integer.bubbletextview_padding);
        setCompoundDrawablePadding(padding);
        if ("com.syu.voice.VoiceLaunch".equals(info.intent.getComponent().getClassName()) || "com.syu.voice.Launch".equals(info.intent.getComponent().getClassName())) {
            String voicename = SystemProperties.get("syu.voicename");
            String voicenewname = SystemProperties.get("persist.syu.voice.newname");
            if (!TextUtils.isEmpty(voicenewname)) {
                setText("车助理·" + voicenewname);
            } else if (!TextUtils.isEmpty(voicename)) {
                setText("车助理·" + voicename);
            } else {
                setText(info.title);
            }
        } else if ("net.easyconn".equals(info.intent.getComponent().getPackageName())) {
            setText(getResources().getString(R.string.car_easyconn));
        } else {
            setText(info.title);
        }
        if (LauncherApplication.sApp.getResources().getBoolean(R.bool.apps_shortname) && getText().length() > 6) {
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

    @Override // android.widget.TextView
    protected boolean setFrame(int left, int top, int right, int bottom) {
        if (getLeft() != left || getRight() != right || getTop() != top || getBottom() != bottom) {
            this.mBackgroundSizeChanged = true;
        }
        return super.setFrame(left, top, right, bottom);
    }

    @Override // android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable who) {
        return who == this.mBackground || super.verifyDrawable(who);
    }

    @Override // android.view.View
    public void setTag(Object tag) {
        if (tag != null) {
            LauncherModel.checkItemInfo((ItemInfo) tag);
        }
        super.setTag(tag);
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        if (isPressed()) {
            if (!this.mDidInvalidateForPressedState) {
                setCellLayoutPressedOrFocusedIcon();
            }
        } else {
            boolean backgroundEmptyBefore = this.mPressedOrFocusedBackground == null;
            if (!this.mStayPressed) {
                this.mPressedOrFocusedBackground = null;
            }
            setFocusable(false);
            if (isFocused()) {
                if (getLayout() == null) {
                    this.mPressedOrFocusedBackground = null;
                } else {
                    this.mPressedOrFocusedBackground = createGlowingOutline(this.mTempCanvas, this.mFocusedGlowColor, this.mFocusedOutlineColor);
                }
                this.mStayPressed = false;
                setCellLayoutPressedOrFocusedIcon();
            }
            boolean backgroundEmptyNow = this.mPressedOrFocusedBackground == null;
            if (!backgroundEmptyBefore && backgroundEmptyNow) {
                setCellLayoutPressedOrFocusedIcon();
            }
        }
        Drawable d = this.mBackground;
        if (d != null && d.isStateful()) {
            d.setState(getDrawableState());
        }
        super.drawableStateChanged();
    }

    private void drawWithPadding(Canvas destCanvas, int padding) {
        Rect clipRect = this.mTempRect;
        getDrawingRect(clipRect);
        clipRect.bottom = (getExtendedPaddingTop() - 3) + getLayout().getLineTop(0);
        destCanvas.save();
        destCanvas.scale(getScaleX(), getScaleY(), (getWidth() + padding) / 2, (getHeight() + padding) / 2);
        destCanvas.translate((-getScrollX()) + (padding / 2), (-getScrollY()) + (padding / 2));
        destCanvas.clipRect(clipRect, Region.Op.REPLACE);
        draw(destCanvas);
        destCanvas.restore();
    }

    private Bitmap createGlowingOutline(Canvas canvas, int outlineColor, int glowColor) {
        int padding = this.mOutlineHelper.mMaxOuterBlurRadius;
        Bitmap b = Bitmap.createBitmap(getWidth() + padding, getHeight() + padding, Bitmap.Config.ARGB_8888);
        canvas.setBitmap(b);
        drawWithPadding(canvas, padding);
        this.mOutlineHelper.applyExtraThickExpensiveOutlineWithBlur(b, canvas, glowColor, outlineColor);
        canvas.setBitmap(null);
        return b;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        boolean result = super.onTouchEvent(event);
        switch (event.getAction()) {
            case 0:
                if (this.mPressedOrFocusedBackground == null) {
                    this.mPressedOrFocusedBackground = createGlowingOutline(this.mTempCanvas, this.mPressedGlowColor, this.mPressedOutlineColor);
                }
                if (isPressed()) {
                    this.mDidInvalidateForPressedState = true;
                    setCellLayoutPressedOrFocusedIcon();
                } else {
                    this.mDidInvalidateForPressedState = false;
                }
                this.mLongPressHelper.postCheckForLongPress();
                return result;
            case 1:
            case 3:
                if (!isPressed()) {
                    this.mPressedOrFocusedBackground = null;
                }
                this.mLongPressHelper.cancelLongPress();
                return result;
            case 2:
            default:
                return result;
        }
    }

    void setStayPressed(boolean stayPressed) {
        this.mStayPressed = stayPressed;
        if (!stayPressed) {
            this.mPressedOrFocusedBackground = null;
        }
        setCellLayoutPressedOrFocusedIcon();
    }

    void setCellLayoutPressedOrFocusedIcon() {
        ShortcutAndWidgetContainer parent;
        if ((getParent() instanceof ShortcutAndWidgetContainer) && (parent = (ShortcutAndWidgetContainer) getParent()) != null) {
            CellLayout layout = (CellLayout) parent.getParent();
            if (this.mPressedOrFocusedBackground == null) {
                this = null;
            }
            layout.setPressedOrFocusedIcon(this);
        }
    }

    void clearPressedOrFocusedBackground() {
        this.mPressedOrFocusedBackground = null;
        setCellLayoutPressedOrFocusedIcon();
    }

    Bitmap getPressedOrFocusedBackground() {
        return this.mPressedOrFocusedBackground;
    }

    int getPressedOrFocusedBackgroundPadding() {
        return this.mOutlineHelper.mMaxOuterBlurRadius / 2;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (!this.mShadowsEnabled) {
            super.draw(canvas);
            return;
        }
        Drawable background = this.mBackground;
        if (background != null) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            if (this.mBackgroundSizeChanged) {
                background.setBounds(0, 0, getRight() - getLeft(), getBottom() - getTop());
                this.mBackgroundSizeChanged = false;
            }
            if ((scrollX | scrollY) == 0) {
                background.draw(canvas);
            } else {
                canvas.translate(scrollX, scrollY);
                background.draw(canvas);
                canvas.translate(-scrollX, -scrollY);
            }
        }
        if (getCurrentTextColor() == getResources().getColor(android.R.color.transparent)) {
            getPaint().clearShadowLayer();
            super.draw(canvas);
            return;
        }
        getPaint().setShadowLayer(SHADOW_LARGE_RADIUS, 0.0f, SHADOW_Y_OFFSET, SHADOW_LARGE_COLOUR);
        super.draw(canvas);
        canvas.save(2);
        canvas.clipRect(getScrollX(), getScrollY() + getExtendedPaddingTop(), getScrollX() + getWidth(), getScrollY() + getHeight(), Region.Op.REVERSE_DIFFERENCE);
        getPaint().setShadowLayer(SHADOW_SMALL_RADIUS, 0.0f, 0.0f, SHADOW_SMALL_COLOUR);
        super.draw(canvas);
        canvas.restore();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mBackground != null) {
            this.mBackground.setCallback(this);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mBackground != null) {
            this.mBackground.setCallback(null);
        }
    }

    @Override // android.widget.TextView
    public void setTextColor(int color) {
        this.mTextColor = color;
    }

    public void setShadowsEnabled(boolean enabled) {
        this.mShadowsEnabled = enabled;
        getPaint().clearShadowLayer();
        invalidate();
    }

    public void setTextVisibility(boolean visible) {
        getResources();
        this.mIsTextVisible = visible;
    }

    public boolean isTextVisible() {
        return this.mIsTextVisible;
    }

    @Override // android.view.View
    protected boolean onSetAlpha(int alpha) {
        if (this.mPrevAlpha != alpha) {
            this.mPrevAlpha = alpha;
            super.onSetAlpha(alpha);
            return true;
        }
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    public void cancelLongPress() {
        super.cancelLongPress();
        this.mLongPressHelper.cancelLongPress();
    }
}
