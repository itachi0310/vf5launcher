package com.android.recycler;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.launcher17.AppInfo;
import com.android.launcher17.Launcher;
import com.android.launcher17.R;
import com.fyt.skin.SkinUtils;
import com.fyt.skin.view.SkinAttrParms;
import com.fyt.skin.view.SkinView;
import com.syu.util.FytPackage;
import com.syu.util.WindowUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AppListAdapter extends RecyclerView.Adapter<AppListHolder> implements AppListDialogFragment.ItemClickDataListener {
    private int lastClickIndex;
    private View mAddAppView;
    private List<AppListBean> mData;
    private Launcher mLauncher;
    private boolean showAddAppView;
    private int mMaxCount = 6;
    private AppListDialogFragment mDialog = new AppListDialogFragment();

    public AppListAdapter(Launcher launcher, List<AppListBean> data) {
        this.mData = data;
        this.mLauncher = launcher;
        this.mDialog.setItemClickDataListener(this);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        this.showAddAppView = this.mData.size() > this.mMaxCount;
        return this.mData.size() > this.mMaxCount ? this.mMaxCount : this.mData.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(AppListHolder holder, final int position) {
        final AppListBean bean = this.mData.get(position);
        holder.mAppName.setText(bean.name);
        addResourceId(holder.mAppIcon, bean.resid);
        holder.mAppIcon.setImageBitmap(bean.icon);
        holder.mAppIcon.setTag(R.id.str_appicon, bean.appIcon);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.android.recycler.AppListAdapter.1
            /* JADX WARN: Code duplicated, block: B:12:0x0044  */
            /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                String str = bean.packageName;
                switch (str.hashCode()) {
                    case -1958346218:
                        if (str.equals("com.google.android.googlequicksearchbox")) {
                            WindowUtil.removePip(null);
                        }
                        break;
                    case 877333343:
                        if (str.equals("net.easyconn")) {
                            WindowUtil.removePip(null);
                        }
                        break;
                    case 1489048446:
                        if (str.equals("com.nng.igo.primong.igoworld")) {
                            WindowUtil.removePip(null);
                        }
                        break;
                }
                if (TextUtils.isEmpty(bean.packageName) || TextUtils.isEmpty(bean.className)) {
                    AppListAdapter.this.mDialog.show(AppListAdapter.this.mLauncher.getFragmentManager(), "");
                    AppListAdapter.this.lastClickIndex = position;
                } else {
                    if (bean.packageName.equals(FytPackage.AppAction)) {
                        AppListAdapter.this.mLauncher.onClickAllAppsButton(v);
                        return;
                    }
                    if (bean.packageName.equals("net.easyconn")) {
                        Log.d("LZP", "easyconn:com.android.launcher17");
                        AppListAdapter.this.mLauncher.startActivitySafely(v, FytPackage.getIntent(AppListAdapter.this.mLauncher, "net.easyconn"), "music");
                        return;
                    }
                    Log.d("LZP", "onBindViewHolder onClick");
                    Intent intent = new Intent();
                    ComponentName cn2 = new ComponentName(bean.packageName, bean.className);
                    intent.setComponent(cn2);
                    AppListAdapter.this.mLauncher.startActivitySafely(v, intent, "");
                }
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.android.recycler.AppListAdapter.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View v) {
                AppListAdapter.this.mDialog.show(AppListAdapter.this.mLauncher.getFragmentManager(), "");
                AppListAdapter.this.lastClickIndex = position;
                return true;
            }
        });
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public AppListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AppListHolder(LayoutInflater.from(this.mLauncher).inflate(R.layout.item_app_list, parent, false));
    }

    public void notifyDataSetChanged(final List<AppListBean> data) {
        this.mLauncher.runOnUiThread(new Runnable() { // from class: com.android.recycler.AppListAdapter.3
            @Override // java.lang.Runnable
            public void run() {
                AppListAdapter.this.mData = data;
                AppListAdapter.this.notifyDataSetChanged();
            }
        });
    }

    private void addResourceId(View view, int resid) {
        Log.d("LZP", "addResourceId");
        ArrayList<SkinView> skinViews = SkinUtils.getSkinAttr().getSkinViews();
        for (SkinView skinView : skinViews) {
            if (skinView.getView() == view) {
                for (SkinAttrParms sap : skinView.getParms()) {
                    Log.d("LZP", "name: " + sap.getAttrName() + ",value: " + sap.getId());
                    if (sap.getAttrName().equals("src")) {
                        sap.setId(resid);
                    }
                }
                return;
            }
        }
    }

    @Override // com.android.recycler.AppListDialogFragment.ItemClickDataListener
    public void onClickData(AppInfo appInfo) {
        AppListBean info = new AppListBean(appInfo.title.toString(), appInfo.iconBitmap, appInfo.getPackageName(), appInfo.getClassName());
        this.mData.remove(this.lastClickIndex);
        this.mData.add(this.lastClickIndex, info);
        notifyDataSetChanged();
        new AppMultiple(this.lastClickIndex, info.name, info.packageName, info.className).saveOrUpdate("index = ?", new StringBuilder(String.valueOf(this.lastClickIndex)).toString());
    }
}
