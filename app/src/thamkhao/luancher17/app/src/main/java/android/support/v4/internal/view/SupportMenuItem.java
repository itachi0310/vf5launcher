package android.support.v4.internal.view;

import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.view.MenuItem;
import android.view.View;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/internal/view/SupportMenuItem.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
public interface SupportMenuItem extends MenuItem {
    public static final int SHOW_AS_ACTION_ALWAYS = 2;
    public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;
    public static final int SHOW_AS_ACTION_IF_ROOM = 1;
    public static final int SHOW_AS_ACTION_NEVER = 0;
    public static final int SHOW_AS_ACTION_WITH_TEXT = 4;

    @Override // android.view.MenuItem
    boolean collapseActionView();

    @Override // android.view.MenuItem
    boolean expandActionView();

    @Override // android.view.MenuItem
    View getActionView();

    ActionProvider getSupportActionProvider();

    @Override // android.view.MenuItem
    boolean isActionViewExpanded();

    @Override // android.view.MenuItem
    MenuItem setActionView(int i);

    @Override // android.view.MenuItem
    MenuItem setActionView(View view);

    @Override // android.view.MenuItem
    void setShowAsAction(int i);

    @Override // android.view.MenuItem
    MenuItem setShowAsActionFlags(int i);

    SupportMenuItem setSupportActionProvider(ActionProvider actionProvider);

    SupportMenuItem setSupportOnActionExpandListener(MenuItemCompat.OnActionExpandListener onActionExpandListener);
}
