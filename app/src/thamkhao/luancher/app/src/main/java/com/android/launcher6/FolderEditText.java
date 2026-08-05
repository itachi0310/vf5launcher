package com.android.launcher6;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.EditText;

/* JADX INFO: loaded from: classes.dex */
public class FolderEditText extends EditText {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Folder f80a;

    public FolderEditText(Context context) {
        super(context);
    }

    public FolderEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FolderEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            this.f80a.a(true);
        }
        return super.onKeyPreIme(i, keyEvent);
    }

    public void setFolder(Folder folder) {
        this.f80a = folder;
    }
}
