package com.android.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.launcher17.R;

/* JADX INFO: loaded from: classes.dex */
public class AppListHolder extends RecyclerView.ViewHolder {
    public ImageView mAppIcon;
    public TextView mAppName;

    public AppListHolder(View view) {
        super(view);
        this.mAppName = (TextView) view.findViewById(R.id.cycler_app_name);
        this.mAppIcon = (ImageView) view.findViewById(R.id.cycler_app_icon);
    }
}
