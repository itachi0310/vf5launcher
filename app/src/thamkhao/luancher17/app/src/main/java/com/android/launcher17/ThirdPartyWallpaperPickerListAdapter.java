package com.android.launcher17;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ThirdPartyWallpaperPickerListAdapter extends BaseAdapter implements ListAdapter {
    private static final String LOG_TAG = "LiveWallpaperListAdapter";
    private final int mIconSize;
    private final LayoutInflater mInflater;
    private final PackageManager mPackageManager;
    private List<ThirdPartyWallpaperTile> mThirdPartyWallpaperPickers = new ArrayList();

    public static class ThirdPartyWallpaperTile extends WallpaperPickerActivity.WallpaperTileInfo {
        private ResolveInfo mResolveInfo;

        public ThirdPartyWallpaperTile(ResolveInfo resolveInfo) {
            this.mResolveInfo = resolveInfo;
        }

        @Override // com.android.launcher17.WallpaperPickerActivity.WallpaperTileInfo
        public void onClick(WallpaperPickerActivity a) {
            ComponentName itemComponentName = new ComponentName(this.mResolveInfo.activityInfo.packageName, this.mResolveInfo.activityInfo.name);
            Intent launchIntent = new Intent("android.intent.action.SET_WALLPAPER");
            launchIntent.setComponent(itemComponentName);
            Utilities.startActivityForResultSafely(a, launchIntent, 6);
        }
    }

    public ThirdPartyWallpaperPickerListAdapter(Context context) {
        ResolveInfo imagePickerActivityInfo;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.mPackageManager = context.getPackageManager();
        this.mIconSize = context.getResources().getDimensionPixelSize(R.dimen.wallpaperItemIconSize);
        PackageManager pm = this.mPackageManager;
        Intent pickWallpaperIntent = new Intent("android.intent.action.SET_WALLPAPER");
        List<ResolveInfo> apps = pm.queryIntentActivities(pickWallpaperIntent, 0);
        Intent pickImageIntent = new Intent("android.intent.action.GET_CONTENT");
        pickImageIntent.setType("image/*");
        List<ResolveInfo> imagePickerActivities = pm.queryIntentActivities(pickImageIntent, 0);
        ComponentName[] imageActivities = new ComponentName[imagePickerActivities.size()];
        for (int i = 0; i < imagePickerActivities.size(); i++) {
            ActivityInfo activityInfo = imagePickerActivities.get(i).activityInfo;
            imageActivities[i] = new ComponentName(activityInfo.packageName, activityInfo.name);
        }
        for (ResolveInfo info : apps) {
            ComponentName itemComponentName = new ComponentName(info.activityInfo.packageName, info.activityInfo.name);
            String itemPackageName = itemComponentName.getPackageName();
            if (!itemPackageName.equals(context.getPackageName()) && !itemPackageName.equals("com.android.launcher") && !itemPackageName.equals("com.android.wallpaper.livepicker")) {
                Iterator<ResolveInfo> it = imagePickerActivities.iterator();
                do {
                    if (it.hasNext()) {
                        imagePickerActivityInfo = it.next();
                    } else {
                        this.mThirdPartyWallpaperPickers.add(new ThirdPartyWallpaperTile(info));
                        break;
                    }
                } while (!itemPackageName.equals(imagePickerActivityInfo.activityInfo.packageName));
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mThirdPartyWallpaperPickers.size();
    }

    @Override // android.widget.Adapter
    public ThirdPartyWallpaperTile getItem(int position) {
        return this.mThirdPartyWallpaperPickers.get(position);
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null) {
            view = this.mInflater.inflate(R.layout.wallpaper_picker_third_party_item, parent, false);
        } else {
            view = convertView;
        }
        WallpaperPickerActivity.setWallpaperItemPaddingToZero((FrameLayout) view);
        ResolveInfo info = this.mThirdPartyWallpaperPickers.get(position).mResolveInfo;
        TextView label = (TextView) view.findViewById(R.id.wallpaper_item_label);
        label.setText(info.loadLabel(this.mPackageManager));
        Drawable icon = info.loadIcon(this.mPackageManager);
        icon.setBounds(new Rect(0, 0, this.mIconSize, this.mIconSize));
        label.setCompoundDrawables(null, icon, null, null);
        return view;
    }
}
