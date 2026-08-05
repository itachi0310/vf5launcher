package com.android.launcher6;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;

/* JADX INFO: loaded from: classes.dex */
class co implements ActionMode.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Folder f158a;

    co(Folder folder) {
        this.f158a = folder;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return false;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        return false;
    }

    @Override // android.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode actionMode) {
    }

    @Override // android.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return false;
    }
}
