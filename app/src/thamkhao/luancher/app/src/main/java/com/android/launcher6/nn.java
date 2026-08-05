package com.android.launcher6;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class nn implements ActionMode.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ WallpaperPickerActivity f419a;

    nn(WallpaperPickerActivity wallpaperPickerActivity) {
        this.f419a = wallpaperPickerActivity;
    }

    private int a() {
        int childCount = this.f419a.i.getChildCount();
        int i = 0;
        int i2 = 0;
        while (i < childCount) {
            int i3 = ((CheckableFrameLayout) this.f419a.i.getChildAt(i)).isChecked() ? i2 + 1 : i2;
            i++;
            i2 = i3;
        }
        return i2;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.menu_delete) {
            return false;
        }
        int childCount = this.f419a.i.getChildCount();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < childCount; i++) {
            CheckableFrameLayout checkableFrameLayout = (CheckableFrameLayout) this.f419a.i.getChildAt(i);
            if (checkableFrameLayout.isChecked()) {
                ((nt) checkableFrameLayout.getTag()).c(this.f419a);
                arrayList.add(checkableFrameLayout);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.f419a.i.removeView((View) it.next());
        }
        this.f419a.j();
        actionMode.finish();
        return true;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        actionMode.getMenuInflater().inflate(R.menu.cab_delete_wallpapers, menu);
        return true;
    }

    @Override // android.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode actionMode) {
        int childCount = this.f419a.i.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ((CheckableFrameLayout) this.f419a.i.getChildAt(i)).setChecked(false);
        }
        this.f419a.f.setSelected(true);
        this.f419a.l = null;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        int iA = a();
        if (iA == 0) {
            actionMode.finish();
        } else {
            actionMode.setTitle(this.f419a.getResources().getQuantityString(R.plurals.number_of_items_selected, iA, Integer.valueOf(iA)));
        }
        return true;
    }
}
