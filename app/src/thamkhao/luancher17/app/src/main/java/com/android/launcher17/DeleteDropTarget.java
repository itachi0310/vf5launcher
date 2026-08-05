package com.android.launcher17;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.util.AttributeSet;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.syu.ipc.data.FinalCanbus;
import com.syu.util.JLog;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class DeleteDropTarget extends ButtonDropTarget {
    private TransitionDrawable mCurrentDrawable;
    private final int mFlingDeleteMode;
    private ColorStateList mOriginalTextColor;
    private TransitionDrawable mRemoveDrawable;
    private TransitionDrawable mUninstallDrawable;
    private boolean mWaitingForUninstall;
    private static int DELETE_ANIMATION_DURATION = FinalCanbus.CAR_AY1_BMW_MINI;
    private static int FLING_DELETE_ANIMATION_DURATION = FinalCanbus.CAR_HAOZHENG_XP1_BmwSeries;
    private static float FLING_TO_DELETE_FRICTION = 0.035f;
    private static int MODE_FLING_DELETE_TO_TRASH = 0;
    private static int MODE_FLING_DELETE_ALONG_VECTOR = 1;

    public DeleteDropTarget(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DeleteDropTarget(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mFlingDeleteMode = MODE_FLING_DELETE_ALONG_VECTOR;
        this.mWaitingForUninstall = false;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mOriginalTextColor = getTextColors();
        Resources r = getResources();
        this.mHoverColor = r.getColor(R.color.delete_target_hover_tint);
        this.mUninstallDrawable = (TransitionDrawable) r.getDrawable(R.drawable.uninstall_target_selector);
        this.mRemoveDrawable = (TransitionDrawable) r.getDrawable(R.drawable.remove_target_selector);
        this.mRemoveDrawable.setCrossFadeEnabled(true);
        this.mUninstallDrawable.setCrossFadeEnabled(true);
        this.mCurrentDrawable = (TransitionDrawable) getCurrentDrawable();
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == 2 && !LauncherAppState.getInstance().isScreenLarge()) {
            setText("");
        }
    }

    private boolean isAllAppsApplication(DragSource source, Object info) {
        return (source instanceof AppsCustomizePagedView) && (info instanceof AppInfo);
    }

    private boolean isAllAppsWidget(DragSource source, Object info) {
        if ((source instanceof AppsCustomizePagedView) && (info instanceof PendingAddItemInfo)) {
            PendingAddItemInfo addInfo = (PendingAddItemInfo) info;
            switch (addInfo.itemType) {
                case 1:
                case 4:
                    return true;
            }
        }
        return false;
    }

    private boolean isDragSourceWorkspaceOrFolder(DropTarget.DragObject d) {
        return (d.dragSource instanceof Workspace) || (d.dragSource instanceof Folder);
    }

    private boolean isWorkspaceOrFolderApplication(DropTarget.DragObject d) {
        return isDragSourceWorkspaceOrFolder(d) && (d.dragInfo instanceof ShortcutInfo);
    }

    private boolean isWorkspaceOrFolderWidget(DropTarget.DragObject d) {
        return isDragSourceWorkspaceOrFolder(d) && (d.dragInfo instanceof LauncherAppWidgetInfo);
    }

    private boolean isWorkspaceFolder(DropTarget.DragObject d) {
        return (d.dragSource instanceof Workspace) && (d.dragInfo instanceof FolderInfo);
    }

    private void setHoverColor() {
        this.mCurrentDrawable.startTransition(this.mTransitionDuration);
        setTextColor(this.mHoverColor);
    }

    private void resetHoverColor() {
        this.mCurrentDrawable.resetTransition();
        setTextColor(this.mOriginalTextColor);
    }

    @Override // com.android.launcher17.ButtonDropTarget, com.android.launcher17.DropTarget
    public boolean acceptDrop(DropTarget.DragObject d) {
        return willAcceptDrop(d.dragInfo);
    }

    public static boolean willAcceptDrop(Object info) {
        if (info instanceof ShortcutInfo) {
            ShortcutInfo si = (ShortcutInfo) info;
            if (si.title.equals(Launcher.mLauncher.getResources().getString(R.string.apps))) {
                return false;
            }
        }
        if (info instanceof ItemInfo) {
            ItemInfo item = (ItemInfo) info;
            if (item.itemType == 4) {
                return info.toString().substring(0, 9).contains("AppWidget");
            }
            if (item.itemType == 1) {
                return true;
            }
            if (!AppsCustomizePagedView.DISABLE_ALL_APPS && item.itemType == 2) {
                return true;
            }
            if (!AppsCustomizePagedView.DISABLE_ALL_APPS && item.itemType == 0 && (item instanceof AppInfo)) {
                AppInfo appInfo = (AppInfo) info;
                return (appInfo.flags & 1) != 0;
            }
            if (item.itemType == 0 && (item instanceof ShortcutInfo)) {
                if (!AppsCustomizePagedView.DISABLE_ALL_APPS) {
                    return true;
                }
                ShortcutInfo shortcutInfo = (ShortcutInfo) info;
                return (shortcutInfo.flags & 1) != 0;
            }
        }
        JLog.getInstance().e("DeleteDropTarget willAcceptDrop false");
        return false;
    }

    @Override // com.android.launcher17.ButtonDropTarget, com.android.launcher17.DragController.DragListener
    public void onDragStart(DragSource source, Object info, int dragAction) {
        boolean isVisible = true;
        boolean useUninstallLabel = !AppsCustomizePagedView.DISABLE_ALL_APPS && isAllAppsApplication(source, info);
        if (!willAcceptDrop(info) || isAllAppsWidget(source, info)) {
            isVisible = false;
        }
        this.mLauncher.appTextVisible(false);
        if (useUninstallLabel) {
            setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, this.mUninstallDrawable, (Drawable) null, (Drawable) null);
        } else {
            setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, this.mRemoveDrawable, (Drawable) null, (Drawable) null);
        }
        this.mCurrentDrawable = (TransitionDrawable) getCurrentDrawable();
        this.mActive = isVisible;
        resetHoverColor();
        ((ViewGroup) getParent()).setVisibility(isVisible ? 0 : 8);
        if (getText().length() > 0) {
            setText(useUninstallLabel ? R.string.delete_target_uninstall_label : R.string.delete_target_label);
        }
        JLog.getInstance().e("DeleteDropTarget onDragStart isVisible = " + isVisible + "width = " + getWidth() + " height = " + getHeight());
    }

    @Override // com.android.launcher17.ButtonDropTarget, com.android.launcher17.DragController.DragListener
    public void onDragEnd() {
        super.onDragEnd();
        this.mLauncher.appTextVisible(true);
        this.mActive = false;
    }

    @Override // com.android.launcher17.ButtonDropTarget, com.android.launcher17.DropTarget
    public void onDragEnter(DropTarget.DragObject d) {
        super.onDragEnter(d);
        setHoverColor();
    }

    @Override // com.android.launcher17.ButtonDropTarget, com.android.launcher17.DropTarget
    public void onDragExit(DropTarget.DragObject d) {
        super.onDragExit(d);
        if (!d.dragComplete) {
            resetHoverColor();
        } else {
            d.dragView.setColor(this.mHoverColor);
        }
    }

    private void animateToTrashAndCompleteDrop(final DropTarget.DragObject d) {
        DragLayer dragLayer = this.mLauncher.getDragLayer();
        Rect from = new Rect();
        dragLayer.getViewRectRelativeToSelf(d.dragView, from);
        Rect to = getIconRect(d.dragView.getMeasuredWidth(), d.dragView.getMeasuredHeight(), this.mCurrentDrawable.getIntrinsicWidth(), this.mCurrentDrawable.getIntrinsicHeight());
        float scale = to.width() / from.width();
        this.mSearchDropTargetBar.deferOnDragEnd();
        deferCompleteDropIfUninstalling(d);
        Runnable onAnimationEndRunnable = new Runnable() { // from class: com.android.launcher17.DeleteDropTarget.1
            @Override // java.lang.Runnable
            public void run() {
                DeleteDropTarget.this.completeDrop(d);
                DeleteDropTarget.this.mSearchDropTargetBar.onDragEnd();
                if (!LauncherApplication.sApp.getResources().getBoolean(R.bool.apps_all_disable)) {
                    DeleteDropTarget.this.mLauncher.exitSpringLoadedDragMode();
                }
            }
        };
        dragLayer.animateView(d.dragView, from, to, scale, 1.0f, 1.0f, 0.1f, 0.1f, DELETE_ANIMATION_DURATION, new DecelerateInterpolator(2.0f), new LinearInterpolator(), onAnimationEndRunnable, 0, null);
    }

    private void deferCompleteDropIfUninstalling(DropTarget.DragObject d) {
        this.mWaitingForUninstall = false;
        if (isUninstallFromWorkspace(d)) {
            if (d.dragSource instanceof Folder) {
                ((Folder) d.dragSource).deferCompleteDropAfterUninstallActivity();
            } else if (d.dragSource instanceof Workspace) {
                ((Workspace) d.dragSource).deferCompleteDropAfterUninstallActivity();
            }
            this.mWaitingForUninstall = true;
        }
    }

    private boolean isUninstallFromWorkspace(DropTarget.DragObject d) {
        Set<String> categories;
        if (AppsCustomizePagedView.DISABLE_ALL_APPS && isWorkspaceOrFolderApplication(d)) {
            ShortcutInfo shortcut = (ShortcutInfo) d.dragInfo;
            if (shortcut.intent == null || shortcut.intent.getComponent() == null || (categories = shortcut.intent.getCategories()) == null) {
                return false;
            }
            for (String category : categories) {
                if (category.equals("android.intent.category.LAUNCHER")) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r11v11, types: [com.android.launcher17.DeleteDropTarget$3] */
    public void completeDrop(DropTarget.DragObject d) {
        ItemInfo item = (ItemInfo) d.dragInfo;
        boolean wasWaitingForUninstall = this.mWaitingForUninstall;
        this.mWaitingForUninstall = false;
        if (isAllAppsApplication(d.dragSource, item)) {
            AppInfo appInfo = (AppInfo) item;
            this.mLauncher.startApplicationUninstallActivity(appInfo.componentName, appInfo.flags);
        } else if (isUninstallFromWorkspace(d)) {
            ShortcutInfo shortcut = (ShortcutInfo) item;
            if (shortcut.intent != null && shortcut.intent.getComponent() != null) {
                final ComponentName componentName = shortcut.intent.getComponent();
                final DragSource dragSource = d.dragSource;
                int flags = AppInfo.initFlags(ShortcutInfo.getPackageInfo(getContext(), componentName.getPackageName()));
                this.mWaitingForUninstall = this.mLauncher.startApplicationUninstallActivity(componentName, flags);
                if (this.mWaitingForUninstall) {
                    Runnable checkIfUninstallWasSuccess = new Runnable() { // from class: com.android.launcher17.DeleteDropTarget.2
                        @Override // java.lang.Runnable
                        public void run() {
                            DeleteDropTarget.this.mWaitingForUninstall = false;
                            String packageName = componentName.getPackageName();
                            List<ResolveInfo> activities = AllAppsList.findActivitiesForPackage(DeleteDropTarget.this.getContext(), packageName);
                            boolean uninstallSuccessful = activities.size() == 0;
                            if (dragSource instanceof Folder) {
                                ((Folder) dragSource).onUninstallActivityReturned(uninstallSuccessful);
                            } else if (dragSource instanceof Workspace) {
                                ((Workspace) dragSource).onUninstallActivityReturned(uninstallSuccessful);
                            }
                        }
                    };
                    this.mLauncher.addOnResumeCallback(checkIfUninstallWasSuccess);
                }
            }
        } else if (isWorkspaceOrFolderApplication(d)) {
            LauncherModel.deleteItemFromDatabase(this.mLauncher, item);
        } else if (isWorkspaceFolder(d)) {
            FolderInfo folderInfo = (FolderInfo) item;
            this.mLauncher.removeFolder(folderInfo);
            LauncherModel.deleteFolderContentsFromDatabase(this.mLauncher, folderInfo);
        } else if (isWorkspaceOrFolderWidget(d)) {
            this.mLauncher.removeAppWidget((LauncherAppWidgetInfo) item);
            LauncherModel.deleteItemFromDatabase(this.mLauncher, item);
            final LauncherAppWidgetInfo launcherAppWidgetInfo = (LauncherAppWidgetInfo) item;
            final LauncherAppWidgetHost appWidgetHost = this.mLauncher.getAppWidgetHost();
            if (appWidgetHost != null) {
                new Thread("deleteAppWidgetId") { // from class: com.android.launcher17.DeleteDropTarget.3
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        appWidgetHost.deleteAppWidgetId(launcherAppWidgetInfo.appWidgetId);
                    }
                }.start();
            }
        }
        if (wasWaitingForUninstall && !this.mWaitingForUninstall) {
            if (d.dragSource instanceof Folder) {
                ((Folder) d.dragSource).onUninstallActivityReturned(false);
            } else if (d.dragSource instanceof Workspace) {
                ((Workspace) d.dragSource).onUninstallActivityReturned(false);
            }
        }
    }

    @Override // com.android.launcher17.ButtonDropTarget, com.android.launcher17.DropTarget
    public void onDrop(DropTarget.DragObject d) {
        animateToTrashAndCompleteDrop(d);
    }

    private ValueAnimator.AnimatorUpdateListener createFlingToTrashAnimatorListener(final DragLayer dragLayer, DropTarget.DragObject d, PointF vel, ViewConfiguration config) {
        Rect to = getIconRect(d.dragView.getMeasuredWidth(), d.dragView.getMeasuredHeight(), this.mCurrentDrawable.getIntrinsicWidth(), this.mCurrentDrawable.getIntrinsicHeight());
        Rect from = new Rect();
        dragLayer.getViewRectRelativeToSelf(d.dragView, from);
        float velocity = Math.abs(vel.length());
        float vp = Math.min(1.0f, velocity / (config.getScaledMaximumFlingVelocity() / 2.0f));
        int offsetY = (int) ((-from.top) * vp);
        int offsetX = (int) (offsetY / (vel.y / vel.x));
        final float y2 = from.top + offsetY;
        final float x2 = from.left + offsetX;
        final float x1 = from.left;
        final float y1 = from.top;
        final float x3 = to.left;
        final float y3 = to.top;
        final TimeInterpolator scaleAlphaInterpolator = new TimeInterpolator() { // from class: com.android.launcher17.DeleteDropTarget.4
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float t) {
                return t * t * t * t * t * t * t * t;
            }
        };
        return new ValueAnimator.AnimatorUpdateListener() { // from class: com.android.launcher17.DeleteDropTarget.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                DragView dragView = (DragView) dragLayer.getAnimatedView();
                float t = ((Float) animation.getAnimatedValue()).floatValue();
                float tp = scaleAlphaInterpolator.getInterpolation(t);
                float initialScale = dragView.getInitialScale();
                float scale = dragView.getScaleX();
                float x1o = ((1.0f - scale) * dragView.getMeasuredWidth()) / 2.0f;
                float y1o = ((1.0f - scale) * dragView.getMeasuredHeight()) / 2.0f;
                float x = ((1.0f - t) * (1.0f - t) * (x1 - x1o)) + (2.0f * (1.0f - t) * t * (x2 - x1o)) + (t * t * x3);
                float y = ((1.0f - t) * (1.0f - t) * (y1 - y1o)) + (2.0f * (1.0f - t) * t * (y2 - x1o)) + (t * t * y3);
                dragView.setTranslationX(x);
                dragView.setTranslationY(y);
                dragView.setScaleX((1.0f - tp) * initialScale);
                dragView.setScaleY((1.0f - tp) * initialScale);
                dragView.setAlpha(((1.0f - 0.5f) * (1.0f - tp)) + 0.5f);
            }
        };
    }

    private static class FlingAlongVectorAnimatorUpdateListener implements ValueAnimator.AnimatorUpdateListener {
        private final TimeInterpolator mAlphaInterpolator = new DecelerateInterpolator(0.75f);
        private DragLayer mDragLayer;
        private float mFriction;
        private Rect mFrom;
        private boolean mHasOffsetForScale;
        private long mPrevTime;
        private PointF mVelocity;

        public FlingAlongVectorAnimatorUpdateListener(DragLayer dragLayer, PointF vel, Rect from, long startTime, float friction) {
            this.mDragLayer = dragLayer;
            this.mVelocity = vel;
            this.mFrom = from;
            this.mPrevTime = startTime;
            this.mFriction = 1.0f - (dragLayer.getResources().getDisplayMetrics().density * friction);
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator animation) {
            DragView dragView = (DragView) this.mDragLayer.getAnimatedView();
            float t = ((Float) animation.getAnimatedValue()).floatValue();
            long curTime = AnimationUtils.currentAnimationTimeMillis();
            if (!this.mHasOffsetForScale) {
                this.mHasOffsetForScale = true;
                float scale = dragView.getScaleX();
                float xOffset = ((scale - 1.0f) * dragView.getMeasuredWidth()) / 2.0f;
                float yOffset = ((scale - 1.0f) * dragView.getMeasuredHeight()) / 2.0f;
                Rect rect = this.mFrom;
                rect.left = (int) (rect.left + xOffset);
                Rect rect2 = this.mFrom;
                rect2.top = (int) (rect2.top + yOffset);
            }
            Rect rect3 = this.mFrom;
            rect3.left = (int) (rect3.left + ((this.mVelocity.x * (curTime - this.mPrevTime)) / 1000.0f));
            Rect rect4 = this.mFrom;
            rect4.top = (int) (rect4.top + ((this.mVelocity.y * (curTime - this.mPrevTime)) / 1000.0f));
            dragView.setTranslationX(this.mFrom.left);
            dragView.setTranslationY(this.mFrom.top);
            dragView.setAlpha(1.0f - this.mAlphaInterpolator.getInterpolation(t));
            this.mVelocity.x *= this.mFriction;
            this.mVelocity.y *= this.mFriction;
            this.mPrevTime = curTime;
        }
    }

    private ValueAnimator.AnimatorUpdateListener createFlingAlongVectorAnimatorListener(DragLayer dragLayer, DropTarget.DragObject d, PointF vel, long startTime, int duration, ViewConfiguration config) {
        Rect from = new Rect();
        dragLayer.getViewRectRelativeToSelf(d.dragView, from);
        return new FlingAlongVectorAnimatorUpdateListener(dragLayer, vel, from, startTime, FLING_TO_DELETE_FRICTION);
    }

    @Override // com.android.launcher17.ButtonDropTarget, com.android.launcher17.DropTarget
    public void onFlingToDelete(final DropTarget.DragObject d, int x, int y, PointF vel) {
        final boolean isAllApps = d.dragSource instanceof AppsCustomizePagedView;
        d.dragView.setColor(0);
        d.dragView.updateInitialScaleToCurrentScale();
        if (isAllApps) {
            resetHoverColor();
        }
        if (this.mFlingDeleteMode == MODE_FLING_DELETE_TO_TRASH) {
            this.mSearchDropTargetBar.deferOnDragEnd();
            this.mSearchDropTargetBar.finishAnimations();
        }
        ViewConfiguration config = ViewConfiguration.get(this.mLauncher);
        DragLayer dragLayer = this.mLauncher.getDragLayer();
        final int duration = FLING_DELETE_ANIMATION_DURATION;
        final long startTime = AnimationUtils.currentAnimationTimeMillis();
        TimeInterpolator tInterpolator = new TimeInterpolator() { // from class: com.android.launcher17.DeleteDropTarget.6
            private int mCount = -1;
            private float mOffset = 0.0f;

            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float t) {
                if (this.mCount < 0) {
                    this.mCount++;
                } else if (this.mCount == 0) {
                    this.mOffset = Math.min(0.5f, (AnimationUtils.currentAnimationTimeMillis() - startTime) / duration);
                    this.mCount++;
                }
                return Math.min(1.0f, this.mOffset + t);
            }
        };
        ValueAnimator.AnimatorUpdateListener updateCb = null;
        if (this.mFlingDeleteMode == MODE_FLING_DELETE_TO_TRASH) {
            updateCb = createFlingToTrashAnimatorListener(dragLayer, d, vel, config);
        } else if (this.mFlingDeleteMode == MODE_FLING_DELETE_ALONG_VECTOR) {
            updateCb = createFlingAlongVectorAnimatorListener(dragLayer, d, vel, startTime, duration, config);
        }
        deferCompleteDropIfUninstalling(d);
        Runnable onAnimationEndRunnable = new Runnable() { // from class: com.android.launcher17.DeleteDropTarget.7
            @Override // java.lang.Runnable
            public void run() {
                if (!isAllApps) {
                    DeleteDropTarget.this.mLauncher.exitSpringLoadedDragMode();
                    DeleteDropTarget.this.completeDrop(d);
                }
                DeleteDropTarget.this.mLauncher.getDragController().onDeferredEndFling(d);
            }
        };
        dragLayer.animateView(d.dragView, updateCb, duration, tInterpolator, onAnimationEndRunnable, 0, null);
    }
}
