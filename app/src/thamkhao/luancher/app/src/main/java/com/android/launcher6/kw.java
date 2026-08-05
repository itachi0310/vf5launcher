package com.android.launcher6;

import android.app.WallpaperInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
class kw extends AsyncTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ kv f363a;
    private Context b;
    private int c = 0;

    public kw(kv kvVar, Context context) {
        this.f363a = kvVar;
        this.b = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(List... listArr) {
        PackageManager packageManager = this.b.getPackageManager();
        List<ResolveInfo> list = listArr[0];
        Collections.sort(list, new kx(this, packageManager));
        for (ResolveInfo resolveInfo : list) {
            try {
                WallpaperInfo wallpaperInfo = new WallpaperInfo(this.b, resolveInfo);
                Drawable drawableLoadThumbnail = wallpaperInfo.loadThumbnail(packageManager);
                Intent intent = new Intent("android.service.wallpaper.WallpaperService");
                intent.setClassName(wallpaperInfo.getPackageName(), wallpaperInfo.getServiceName());
                publishProgress(new ky(drawableLoadThumbnail, wallpaperInfo, intent));
            } catch (IOException e) {
                Log.w("LiveWallpaperListAdapter", "Skipping wallpaper " + resolveInfo.serviceInfo, e);
            } catch (XmlPullParserException e2) {
                Log.w("LiveWallpaperListAdapter", "Skipping wallpaper " + resolveInfo.serviceInfo, e2);
            }
        }
        publishProgress(null);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(ky... kyVarArr) {
        for (ky kyVar : kyVarArr) {
            if (kyVar == null) {
                this.f363a.notifyDataSetChanged();
                return;
            }
            kyVar.b.setDither(true);
            if (this.c < this.f363a.c.size()) {
                this.f363a.c.set(this.c, kyVar);
            } else {
                this.f363a.c.add(kyVar);
            }
            this.c++;
        }
    }
}
