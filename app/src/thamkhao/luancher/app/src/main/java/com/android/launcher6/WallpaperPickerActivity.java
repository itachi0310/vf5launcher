package com.android.launcher6;

import android.animation.LayoutTransition;
import android.app.ActionBar;
import android.app.WallpaperInfo;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class WallpaperPickerActivity extends WallpaperCropActivity {
    public static String b;
    private boolean e;
    private View f;
    private boolean g;
    private View.OnClickListener h;
    private LinearLayout i;
    private View j;
    private ActionMode.Callback k;
    private ActionMode l;
    private View.OnLongClickListener m;
    private mk n;
    private WallpaperInfo o;
    private int d = 1;
    ArrayList c = new ArrayList();

    public static View a(LayoutInflater layoutInflater, int i, View view, ViewGroup viewGroup, Drawable drawable) {
        View viewInflate = view == null ? layoutInflater.inflate(R.layout.wallpaper_picker_item, viewGroup, false) : view;
        a((FrameLayout) viewInflate);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.wallpaper_image);
        if (drawable != null) {
            imageView.setImageDrawable(drawable);
            drawable.setDither(true);
        }
        return viewInflate;
    }

    private ArrayList a(Resources resources, String str, int i) {
        ArrayList arrayList = new ArrayList(24);
        for (String str2 : resources.getStringArray(i)) {
            int identifier = resources.getIdentifier(str2, "drawable", str);
            if (identifier != 0) {
                int identifier2 = this.e ? resources.getIdentifier(String.valueOf(str2) + "_small", "drawable", str) : resources.getIdentifier(String.valueOf(str2) + "_small", "drawable", str);
                if (identifier2 != 0) {
                    arrayList.add(new nq(resources, identifier, resources.getDrawable(identifier2), str2));
                }
            } else {
                Log.e("Launcher.WallpaperPickerActivity", "Couldn't find wallpaper " + str2);
            }
        }
        return arrayList;
    }

    private void a(Uri uri) {
        this.c.add(uri);
        FrameLayout frameLayout = (FrameLayout) getLayoutInflater().inflate(R.layout.wallpaper_picker_item, this.i, false);
        a(frameLayout);
        ImageView imageView = (ImageView) frameLayout.findViewById(R.id.wallpaper_image);
        Bitmap bitmapB = b(b(getResources()), this, uri, null, null, 0, WallpaperCropActivity.a(this, uri), false);
        if (bitmapB != null) {
            imageView.setImageBitmap(bitmapB);
            imageView.getDrawable().setDither(true);
        } else {
            Log.e("Launcher.WallpaperPickerActivity", "Error loading thumbnail for uri=" + uri);
        }
        this.i.addView(frameLayout, 0);
        nr nrVar = new nr(uri);
        frameLayout.setTag(nrVar);
        nrVar.a(frameLayout);
        a((View) frameLayout);
        j();
        frameLayout.setOnClickListener(this.h);
        this.h.onClick(frameLayout);
    }

    private void a(View view) {
        view.setOnLongClickListener(this.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ViewGroup viewGroup, BaseAdapter baseAdapter, boolean z, boolean z2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= baseAdapter.getCount()) {
                return;
            }
            FrameLayout frameLayout = (FrameLayout) baseAdapter.getView(i2, null, viewGroup);
            viewGroup.addView(frameLayout, i2);
            nt ntVar = (nt) baseAdapter.getItem(i2);
            frameLayout.setTag(ntVar);
            ntVar.a(frameLayout);
            if (z) {
                a((View) frameLayout);
            }
            frameLayout.setOnClickListener(this.h);
            if (i2 == 0 && z2) {
                this.h.onClick(frameLayout);
            }
            i = i2 + 1;
        }
    }

    static void a(FrameLayout frameLayout) {
        frameLayout.setPadding(0, 0, 0, 0);
        frameLayout.setForeground(new nu(frameLayout.getForeground()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bitmap b(Point point, Context context, Uri uri, byte[] bArr, Resources resources, int i, int i2, boolean z) {
        ne neVar;
        int i3 = point.x;
        int i4 = point.y;
        if (uri != null) {
            neVar = new ne(context, uri, (RectF) null, i2, i3, i4, false, true, (Runnable) null);
        } else {
            neVar = bArr != null ? new ne(bArr, null, i2, i3, i4, false, true, null) : new ne(context, resources, i, null, i2, i3, i4, false, true, null);
        }
        Point pointA = neVar.a();
        if (pointA == null || pointA.x == 0 || pointA.y == 0) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate(i2);
        float[] fArr = {pointA.x, pointA.y};
        matrix.mapPoints(fArr);
        fArr[0] = Math.abs(fArr[0]);
        fArr[1] = Math.abs(fArr[1]);
        neVar.a(WallpaperCropActivity.a((int) fArr[0], (int) fArr[1], i3, i4, z));
        if (neVar.c()) {
            return neVar.b();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Point b(Resources resources) {
        return new Point(resources.getDimensionPixelSize(R.dimen.wallpaperThumbnailWidth), resources.getDimensionPixelSize(R.dimen.wallpaperThumbnailHeight));
    }

    private void h() {
        ArrayList arrayListK = k();
        this.i = (LinearLayout) findViewById(R.id.wallpaper_list);
        a((ViewGroup) this.i, (BaseAdapter) new no(this, arrayListK), false, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        int childCount;
        LinearLayout linearLayout;
        int i;
        int i2;
        int i3;
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.master_wallpaper_list);
        int childCount2 = linearLayout2.getChildCount();
        Resources resources = getResources();
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= 2) {
                return;
            }
            int i7 = 0;
            for (int i8 = 0; i8 < childCount2; i8++) {
                View childAt = linearLayout2.getChildAt(i8);
                if (childAt.getTag() instanceof nt) {
                    childCount = i8 + 1;
                    linearLayout = linearLayout2;
                    i = i8;
                } else {
                    LinearLayout linearLayout3 = (LinearLayout) childAt;
                    childCount = linearLayout3.getChildCount();
                    linearLayout = linearLayout3;
                    i = 0;
                }
                int i9 = i;
                while (i9 < childCount) {
                    nt ntVar = (nt) linearLayout.getChildAt(i9).getTag();
                    if (!ntVar.b()) {
                        i2 = i7;
                        i3 = i4;
                    } else if (i6 == 0) {
                        int i10 = i7;
                        i3 = i4 + 1;
                        i2 = i10;
                    } else {
                        i7++;
                        ntVar.a(resources.getString(R.string.wallpaper_accessibility_name, Integer.valueOf(i7), Integer.valueOf(i4)));
                        i2 = i7;
                        i3 = i4;
                    }
                    i9++;
                    i4 = i3;
                    i7 = i2;
                }
            }
            i5 = i6 + 1;
        }
    }

    private ArrayList k() {
        ArrayList arrayList = new ArrayList(24);
        Pair pairD = d();
        if (pairD == null) {
            return arrayList;
        }
        try {
            return a(getPackageManager().getResourcesForApplication((ApplicationInfo) pairD.first), ((ApplicationInfo) pairD.first).packageName, ((Integer) pairD.second).intValue());
        } catch (PackageManager.NameNotFoundException e) {
            return arrayList;
        }
    }

    @Override // com.android.launcher6.WallpaperCropActivity
    protected void a() {
        setContentView(R.layout.wallpaper_picker);
        this.f98a = (CropView) findViewById(R.id.cropView);
        this.j = findViewById(R.id.wallpaper_strip);
        this.f98a.setTouchCallback(new ng(this));
        this.h = new ni(this);
        this.m = new nj(this);
        h();
        this.n = new mk(this);
        this.n.a();
        a((ViewGroup) this.i, (BaseAdapter) this.n, true, true);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.live_wallpaper_list);
        kv kvVar = new kv(this);
        kvVar.registerDataSetObserver(new nk(this, linearLayout, kvVar));
        Log.e("TAAA", "init mliveWallpaper == " + this.d);
        this.i.setVisibility(this.d == 1 ? 8 : 0);
        linearLayout.setVisibility(this.d != 0 ? 0 : 8);
        a((ViewGroup) findViewById(R.id.third_party_wallpaper_list), (BaseAdapter) new mv(this), false, false);
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.master_wallpaper_list);
        FrameLayout frameLayout = (FrameLayout) getLayoutInflater().inflate(R.layout.wallpaper_picker_image_picker_item, (ViewGroup) linearLayout2, false);
        a(frameLayout);
        linearLayout2.addView(frameLayout, 0);
        np npVar = new np();
        frameLayout.setTag(npVar);
        npVar.a(frameLayout);
        frameLayout.setOnClickListener(this.h);
        npVar.a(frameLayout);
        j();
        i();
        LayoutTransition layoutTransition = new LayoutTransition();
        layoutTransition.setDuration(200L);
        layoutTransition.setStartDelay(1, 0L);
        layoutTransition.setAnimator(3, null);
        this.i.setLayoutTransition(layoutTransition);
        if (LauncherApplication.f88a.getResources().getBoolean(R.bool.apps_set_wallpaper)) {
            TextView textView = (TextView) findViewById(a.b.a().aZ);
            if (textView != null) {
                textView.setOnClickListener(new nl(this));
            }
        } else {
            ActionBar actionBar = getActionBar();
            actionBar.setCustomView(R.layout.actionbar_set_wallpaper);
            if (actionBar.getCustomView() != null) {
                actionBar.getCustomView().setOnClickListener(new nm(this));
            }
        }
        this.k = new nn(this);
    }

    public void a(float f) {
        this.j.setPadding(0, 0, 0, (int) f);
    }

    @Override // com.android.launcher6.WallpaperCropActivity
    public boolean b() {
        return super.b() || Launcher.B;
    }

    public Pair d() {
        int i = R.array.wallpapers_n;
        try {
            ApplicationInfo applicationInfo = getPackageManager().getApplicationInfo(this.e ? getResources().getResourcePackageName(R.array.wallpapers_n) : getResources().getResourcePackageName(R.array.wallpapers), 0);
            if (!this.e) {
                i = R.array.wallpapers;
            }
            return new Pair(applicationInfo, Integer.valueOf(i));
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    public CropView e() {
        return this.f98a;
    }

    public mk f() {
        return this.n;
    }

    public void g() {
        this.o = WallpaperManager.getInstance(this).getWallpaperInfo();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 5 && i2 == -1) {
            if (intent == null || intent.getData() == null) {
                return;
            }
            a(intent.getData());
            return;
        }
        if (i == 6) {
            setResult(-1);
            finish();
            return;
        }
        if (i == 7) {
            WallpaperManager wallpaperManager = WallpaperManager.getInstance(this);
            WallpaperInfo wallpaperInfo = this.o;
            WallpaperInfo wallpaperInfo2 = wallpaperManager.getWallpaperInfo();
            if (wallpaperInfo2 != null) {
                if (wallpaperInfo == null || !wallpaperInfo.getComponent().equals(wallpaperInfo2.getComponent())) {
                    setResult(-1);
                    finish();
                }
            }
        }
    }

    @Override // com.android.launcher6.WallpaperCropActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        this.d = intent.getIntExtra("live_wallpaper", 0);
        this.e = intent.getBooleanExtra("night_mode", false);
        super.onCreate(bundle);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.d = intent.getIntExtra("live_wallpaper", 0);
        View viewFindViewById = findViewById(R.id.live_wallpaper_list);
        View viewFindViewById2 = findViewById(R.id.wallpaper_list);
        Log.e("TAAA", "onNewIntent mliveWallpaper == " + this.d);
        if (viewFindViewById2 != null) {
            Log.e("TAAA", "onNewIntent mliveWallpaper 11== " + this.d);
            viewFindViewById2.setVisibility(this.d == 1 ? 8 : 0);
        }
        if (viewFindViewById != null) {
            Log.e("TAAA", "onNewIntent mliveWallpaper 22== " + this.d);
            viewFindViewById.setVisibility(this.d != 0 ? 0 : 8);
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        Iterator it = bundle.getParcelableArrayList("TEMP_WALLPAPER_TILES").iterator();
        while (it.hasNext()) {
            a((Uri) it.next());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putParcelableArrayList("TEMP_WALLPAPER_TILES", this.c);
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.j = findViewById(R.id.wallpaper_strip);
        if (this.j.getAlpha() < 1.0f) {
            this.j.setAlpha(1.0f);
            this.j.setVisibility(0);
        }
    }
}
