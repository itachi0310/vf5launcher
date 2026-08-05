package com.android.launcher6;

import android.accounts.AccountManager;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.app.SearchManager;
import android.app.WallpaperManager;
import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.TextKeyListener;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.Advanceable;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import cn.kuwo.autosdk.api.KWAPI;
import cn.kuwo.autosdk.api.OnPlayerStatusListener;
import com.fyt.car.MusicService;
import com.fyt.car.SetWallpaperReceiver;
import com.fyt.widget.DvrService;
import com.fyt.widget.HorizontalListView;
import com.syu.jni.SyuJniNative;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import org.apache.http.HttpStatus;

/* JADX INFO: loaded from: classes.dex */
public class Launcher extends Activity implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener, jn, Observer {
    public static boolean L;
    private static Workspace as;
    private static KWAPI bo;
    public static View i;
    public static View j;
    public static View k;
    public static Launcher o;
    public static iv u;
    public boolean D;
    public boolean E;
    com.syu.f.g H;
    public int J;
    public ImageView N;
    public ImageView O;
    public ImageView P;
    private Button aA;
    private Button aB;
    private Button aC;
    private Button aD;
    private Button aE;
    private Button aF;
    private Button aG;
    private Button aH;
    private Button aI;
    private Button aJ;
    private View aK;
    private View aL;
    private View aM;
    private View aN;
    private View aO;
    private View aP;
    private ImageView aQ;
    private ImageView aR;
    private ImageView aS;
    private ImageView aT;
    private ImageView aU;
    private ImageView aV;
    private TextView aW;
    private TextView aX;
    private TextView aY;
    private TextView aZ;
    private String ag;
    private AnimatorSet ai;
    private LayoutInflater ar;
    private View at;
    private DragLayer au;
    private bo av;
    private View aw;
    private TextView ax;
    private TextView ay;
    private TextView az;
    private AppsCustomizePagedView bA;
    private View bC;
    private Bundle bD;
    private boolean bJ;
    private boolean bK;
    private boolean bL;
    private Bundle bP;
    private dv bQ;
    private View.OnTouchListener bX;
    private TextView ba;
    private TextView bb;
    private TextView bc;
    private TextView bd;
    private TextView be;
    private TextView bf;
    private ImageView bg;
    private ImageView bh;
    private ImageView bi;
    private ImageView bj;
    private View bk;
    private View bl;
    private View bm;
    private View bn;
    private AppWidgetManager bq;
    private ir br;
    private AppWidgetProviderInfo bt;
    private dg bv;
    private View bw;
    private SearchDropTargetBar by;
    private AppsCustomizeTabHost bz;
    private TextView cA;
    private TextView cB;
    private TextView cC;
    private TextView cD;
    private TextView cE;
    private TextView cF;
    private TextView cG;
    private TextView cH;
    private int cO;
    private TextView cQ;
    private TextView cR;
    private TextView cS;
    private TextView cT;
    private TextView cU;
    private TextView cV;
    private TextView cW;
    private TextView cX;
    private TextView cY;
    private TextView cZ;
    private long cb;
    private SharedPreferences ck;
    private SharedPreferences.Editor cl;

    /* JADX INFO: renamed from: cn, reason: collision with root package name */
    private ImageView f87cn;
    private Bitmap co;
    private Canvas cp;
    private BubbleTextView cr;
    private mu cv;
    private le cw;
    private ImageView cx;
    private ImageView cy;
    private TextView cz;
    private Button dA;
    private Button dB;
    private Button dC;
    private Button dD;
    private Button dE;
    private String dF;
    private com.fyt.widget.k dG;
    private SeekBar dH;
    private ProgressBar dI;
    private ProgressBar dJ;
    private MediaPlayer dK;
    private View dL;
    private View dM;
    private View dN;
    private View dO;
    private View dP;
    private View dQ;
    private View dR;
    private View dS;
    private View dT;
    private android.a.a.c.af dU;
    private HorizontalListView dV;
    private dk dW;
    private ArrayList dX;
    private TextView da;
    private TextView db;
    private TextView dc;
    private TextView dd;
    private TextView de;
    private TextView df;
    private TextView dg;
    private TextView dh;
    private TextView di;
    private TextView dj;
    private TextView dk;
    private TextView dl;
    private TextView dm;
    private TextView dn;

    /* JADX INFO: renamed from: do, reason: not valid java name */
    private TextView f1do;
    private TextView dp;
    private TextView dq;
    private TextView dr;
    private TextView ds;
    private TextView dt;
    private TextView du;
    private TextView dv;
    private TextView dw;
    private Button dx;
    private Button dy;
    private Button dz;
    private ArrayList ef;
    LauncherApplication h;
    SetWallpaperReceiver n;
    public com.syu.i.e p;
    public com.syu.i.d q;
    public View r;
    View s;
    RelativeLayout t;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f86a = "";
    public static String b = "";
    public static int c = 0;
    public static int d = 0;
    public static int e = 0;
    public static int f = 0;
    static final int m = LauncherApplication.f;
    private static final Object aj = new Object();
    private static int ak = 0;
    private static int al = HttpStatus.SC_INTERNAL_SERVER_ERROR;
    private static int am = 5;
    private static int an = HttpStatus.SC_INTERNAL_SERVER_ERROR;
    private static boolean bO = false;
    private static ie bV = null;
    private static HashMap bW = new HashMap();
    private static Drawable.ConstantState[] cf = new Drawable.ConstantState[2];
    private static Drawable.ConstantState[] cg = new Drawable.ConstantState[2];
    private static Drawable.ConstantState[] ch = new Drawable.ConstantState[2];
    static final ArrayList v = new ArrayList();
    static Date w = new Date();
    static DateFormat x = DateFormat.getDateTimeInstance(3, 3);
    static long y = System.currentTimeMillis();
    private static ArrayList cm = null;
    private static ArrayList cu = new ArrayList();
    public static boolean B = d("launcher_force_rotate");
    public static int K = 0;
    private static int dY = 0;
    public static String S = "87.50";
    public static int U = 0;
    public static String V = "87.50";
    public static int X = 0;
    public static int Y = 0;
    public static String aa = null;
    public static String ab = null;
    public static int ac = 0;
    public static int ad = 0;
    public boolean g = true;
    boolean l = false;
    private ii ah = ii.WORKSPACE;
    private final BroadcastReceiver ao = new ib(this, null);
    private final String ap = "com.lsec.tyz.action.voice.launcher";
    private final ContentObserver aq = new ia(this);
    private Handler bp = new Handler(Looper.getMainLooper());
    private ec bs = new ec();
    private int[] bu = new int[2];
    private HashMap bx = new HashMap();
    private boolean bB = false;
    private ii bE = ii.NONE;
    private SpannableStringBuilder bF = null;
    private boolean bG = true;
    private boolean bH = LauncherApplication.f88a.getResources().getBoolean(R.bool.close_popwindow);
    private boolean bI = true;
    private ArrayList bM = new ArrayList();
    private ArrayList bN = new ArrayList();
    private boolean bR = true;
    private boolean bS = false;
    private boolean bT = false;
    private boolean bU = false;
    private final int bY = 1;
    private final int bZ = 20000;
    private final int ca = 250;
    private long cc = -1;
    private HashMap cd = new HashMap();
    private final int ce = HttpStatus.SC_INTERNAL_SERVER_ERROR;
    private Intent ci = null;
    private final ArrayList cj = new ArrayList();
    private Rect cq = new Rect();
    public final String z = "launcherdefAppKey";
    public List A = new ArrayList();
    private dj cs = new dj();
    private Runnable ct = new ed(this);
    Runnable C = new ep(this);
    private OnPlayerStatusListener cI = new fa(this);
    public String F = "";
    Runnable G = new fl(this);
    private BroadcastReceiver cJ = new fw(this);
    private com.fyt.car.b cK = new gj(this);
    com.fyt.car.b I = new gx(this);
    private com.fyt.car.b cL = new hi(this);
    private com.fyt.car.b cM = new hv(this);
    private int cN = -1;
    private com.syu.f.e cP = new ee(this);
    ih M = new ef(this);
    private int[] dZ = {a.b.a().fo, a.b.a().fp, a.b.a().fq, a.b.a().fr, a.b.a().fs, a.b.a().ft, a.b.a().fu, a.b.a().fv, a.b.a().fw, a.b.a().fx};
    String Q = null;
    String R = "";
    private com.fyt.car.b ea = new eg(this);
    private int eb = -1;
    com.syu.f.e T = new eh(this);
    com.syu.f.e W = new ei(this);
    private com.fyt.car.b ec = new ej(this);
    boolean Z = false;
    com.syu.f.e ae = new ek(this);
    private final BroadcastReceiver ed = new el(this);
    private final Handler ee = new em(this);
    boolean af = false;
    private Runnable eg = new eo(this);

    public static Workspace F() {
        return as;
    }

    public static Launcher G() {
        return o;
    }

    private ValueAnimator a(View view, int i2) {
        ObjectAnimator objectAnimatorA = ik.a(view, PropertyValuesHolder.ofFloat("alpha", 1.0f), PropertyValuesHolder.ofFloat("scaleX", 1.0f), PropertyValuesHolder.ofFloat("scaleY", 1.0f));
        objectAnimatorA.setDuration(450L);
        objectAnimatorA.setStartDelay(i2 * 85);
        objectAnimatorA.setInterpolator(new mr());
        return objectAnimatorA;
    }

    private Intent a(String str, String str2) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setFlags(270532608);
        intent.setComponent(new ComponentName(str, str2));
        return intent;
    }

    public static Bitmap a(Bitmap bitmap) {
        int i2;
        int i3;
        int i4;
        int i5;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f2 = height / 2;
        if (width > height) {
            int i6 = (width - height) / 2;
            i4 = 0;
            i5 = i6;
            i3 = i6 + height;
            i2 = height;
        } else if (height > width) {
            int i7 = (height - width) / 2;
            i2 = i7 + width;
            f2 = width / 2;
            i4 = i7;
            i5 = 0;
            i3 = width;
        } else {
            i2 = height;
            i3 = width;
            i4 = 0;
            i5 = 0;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setFlags(1);
        paint.setColor(Color.parseColor("#ffffffff"));
        Rect rect = new Rect(i5, i4, i3, i2);
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawRoundRect(rectF, f2, f2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, (Rect) null, rect, paint);
        paint.setXfermode(null);
        return bitmapCreateBitmap;
    }

    private Drawable.ConstantState a(int i2, ComponentName componentName, int i3, String str) {
        ImageView imageView = (ImageView) findViewById(i2);
        Drawable drawableA = a(componentName, str);
        if (imageView != null) {
            if (drawableA == null) {
                imageView.setImageResource(i3);
            } else {
                imageView.setImageDrawable(drawableA);
            }
        }
        if (drawableA != null) {
            return drawableA.getConstantState();
        }
        return null;
    }

    private Drawable a(ComponentName componentName, String str) {
        int i2;
        try {
            PackageManager packageManager = getPackageManager();
            Bundle bundle = packageManager.getActivityInfo(componentName, 128).metaData;
            if (bundle != null && (i2 = bundle.getInt(str)) != 0) {
                return packageManager.getResourcesForActivity(componentName).getDrawable(i2);
            }
        } catch (PackageManager.NameNotFoundException e2) {
            Log.w("Launcher", "Failed to load toolbar icon; " + componentName.flattenToShortString() + " not found", e2);
        } catch (Resources.NotFoundException e3) {
            Log.w("Launcher", "Failed to load toolbar icon from " + componentName.flattenToShortString(), e3);
        }
        return null;
    }

    private Cling a(int i2, int i3, boolean z, boolean z2) {
        Cling cling = (Cling) findViewById(i2);
        View viewFindViewById = i3 > 0 ? findViewById(R.id.cling_scrim) : null;
        if (cling != null) {
            cling.a(this, viewFindViewById);
            cling.a(z, 250);
            if (z2) {
                cling.setSystemUiVisibility(cling.getSystemUiVisibility() | 1);
            }
        }
        return cling;
    }

    static void a(int i2) {
        synchronized (aj) {
            ak = i2;
        }
    }

    private void a(int i2, int i3) {
        Runnable evVar;
        AppWidgetHostView appWidgetHostViewCreateView = null;
        CellLayout cellLayoutC = as.c(this.bs.i);
        int i4 = 0;
        if (i2 == -1) {
            i4 = 3;
            appWidgetHostViewCreateView = this.br.createView(this, i3, this.bt);
            evVar = new eu(this, i3, appWidgetHostViewCreateView, i2);
        } else if (i2 == 0) {
            i4 = 4;
            evVar = new ev(this, i2);
        } else {
            evVar = null;
        }
        if (this.au.getAnimatedView() != null) {
            as.a(this.bs, cellLayoutC, (ca) this.au.getAnimatedView(), evVar, i4, (View) appWidgetHostViewCreateView, true);
        } else {
            evVar.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, long j2, long j3, AppWidgetHostView appWidgetHostView, AppWidgetProviderInfo appWidgetProviderInfo) {
        boolean zA;
        if (appWidgetProviderInfo == null) {
            appWidgetProviderInfo = this.bq.getAppWidgetInfo(i2);
        }
        CellLayout cellLayoutA = a(j2, j3);
        int[] iArrB = b(this, appWidgetProviderInfo);
        int[] iArrA = a(this, appWidgetProviderInfo);
        int[] iArr = this.bu;
        int[] iArr2 = this.bs.r;
        int[] iArr3 = new int[2];
        if (this.bs.j >= 0 && this.bs.k >= 0) {
            iArr[0] = this.bs.j;
            iArr[1] = this.bs.k;
            iArrA[0] = this.bs.l;
            iArrA[1] = this.bs.m;
            zA = true;
        } else if (iArr2 != null) {
            int[] iArrA2 = cellLayoutA.a(iArr2[0], iArr2[1], iArrB[0], iArrB[1], iArrA[0], iArrA[1], iArr, iArr3);
            iArrA[0] = iArr3[0];
            iArrA[1] = iArr3[1];
            zA = iArrA2 != null;
        } else {
            zA = cellLayoutA.a(iArr, iArrB[0], iArrB[1]);
        }
        if (!zA) {
            if (i2 != -1) {
                new gl(this, "deleteAppWidgetId", i2).start();
            }
            a(b(cellLayoutA));
            return;
        }
        it itVar = new it(i2, appWidgetProviderInfo.provider);
        itVar.l = iArrA[0];
        itVar.m = iArrA[1];
        itVar.n = this.bs.n;
        itVar.o = this.bs.o;
        iv.a((Context) this, (ec) itVar, j2, j3, iArr[0], iArr[1], false);
        if (!this.bJ) {
            if (appWidgetHostView == null) {
                itVar.e = this.br.createView(this, i2, appWidgetProviderInfo);
                itVar.e.setAppWidget(i2, appWidgetProviderInfo);
            } else {
                itVar.e = appWidgetHostView;
            }
            itVar.e.setTag(itVar);
            itVar.e.setVisibility(0);
            itVar.b(this);
            as.a(itVar.e, j2, j3, iArr[0], iArr[1], itVar.l, itVar.m, u());
            a(itVar.e, appWidgetProviderInfo);
        }
        aD();
    }

    private void a(int i2, Drawable.ConstantState constantState) {
        ((ImageView) findViewById(i2)).setImageDrawable(constantState.newDrawable(getResources()));
    }

    private void a(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        if (f(bundle.getInt("launcher.state", ii.WORKSPACE.ordinal())) == ii.APPS_CUSTOMIZE) {
            this.bE = ii.APPS_CUSTOMIZE;
        }
        int i2 = bundle.getInt("launcher.current_screen", -1001);
        if (i2 != -1001) {
            as.setRestorePage(i2);
        }
        long j2 = bundle.getLong("launcher.add_container", -1L);
        long j3 = bundle.getLong("launcher.add_screen", -1L);
        if (j2 != -1 && j3 > -1) {
            this.bs.h = j2;
            this.bs.i = j3;
            this.bs.j = bundle.getInt("launcher.add_cell_x");
            this.bs.k = bundle.getInt("launcher.add_cell_y");
            this.bs.l = bundle.getInt("launcher.add_span_x");
            this.bs.m = bundle.getInt("launcher.add_span_y");
            this.bt = (AppWidgetProviderInfo) bundle.getParcelable("launcher.add_widget_info");
            this.bK = true;
            this.bJ = true;
        }
        if (bundle.getBoolean("launcher.rename_folder", false)) {
            this.bv = u.a(this, bW, bundle.getLong("launcher.rename_folder_id"));
            this.bJ = true;
        }
        if (this.bz != null) {
            String string = bundle.getString("apps_customize_currentTab");
            if (string != null) {
                this.bz.setContentTypeImmediate(this.bz.a(string));
                this.bA.p(this.bA.getCurrentPage());
            }
            this.bA.b(bundle.getInt("apps_customize_currentIndex"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, float f2) {
        view.setPivotX(view.getWidth() / 2.0f);
        view.setPivotY(view.getHeight() / 2.0f);
    }

    private void a(View view, View view2) {
        if (view instanceof HolographicLinearLayout) {
            ((HolographicLinearLayout) view).a();
        } else if (view2 instanceof HolographicImageView) {
            ((HolographicImageView) view2).a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(View view, boolean z, boolean z2) {
        if (view instanceof ks) {
            ((ks) view).a(this, z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Cling cling, Runnable runnable, Intent intent, int i2, boolean z) {
        if (cling == null || cling.getVisibility() == 8) {
            return;
        }
        hr hrVar = new hr(this, cling, runnable, intent);
        if (i2 <= 0) {
            hrVar.run();
        } else {
            cling.a(i2, hrVar);
        }
        this.cs.a(this.au);
        if (z) {
            cling.setSystemUiVisibility(cling.getSystemUiVisibility() & (-2));
        }
    }

    private void a(Cling cling, Runnable runnable, String str, int i2, boolean z) {
        if (cling == null || cling.getVisibility() == 8) {
            return;
        }
        ht htVar = new ht(this, cling, runnable, str);
        if (i2 <= 0) {
            htVar.run();
        } else {
            cling.a(i2, htVar);
        }
        this.cs.a(this.au);
        if (z) {
            cling.setSystemUiVisibility(cling.getSystemUiVisibility() & (-2));
        }
    }

    private void a(Cling cling, String str, boolean z, boolean z2) {
        TextView textView = (TextView) cling.findViewById(R.id.custom_content_hint);
        if (textView != null) {
            if (!z || str.isEmpty()) {
                if (z2) {
                    textView.animate().alpha(0.0f).setDuration(250L).setListener(new hx(this, textView)).start();
                    return;
                } else {
                    textView.setAlpha(0.0f);
                    textView.setVisibility(8);
                    return;
                }
            }
            textView.setText(str);
            textView.setVisibility(0);
            if (!z2) {
                textView.setAlpha(1.0f);
            } else {
                textView.setAlpha(0.0f);
                textView.animate().alpha(1.0f).setDuration(250L).start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(pb pbVar, boolean z, boolean z2, Runnable runnable) {
        Animator animatorA;
        if (this.ai != null) {
            this.ai.setDuration(0L);
            this.ai.cancel();
            this.ai = null;
        }
        Resources resources = getResources();
        int integer = resources.getInteger(R.integer.config_appsCustomizeZoomOutTime);
        int integer2 = resources.getInteger(R.integer.config_appsCustomizeFadeOutTime);
        float integer3 = resources.getInteger(R.integer.config_appsCustomizeZoomScaleFactor);
        AppsCustomizeTabHost appsCustomizeTabHost = this.bz;
        Workspace workspace = as;
        if (pbVar == pb.NORMAL) {
            animatorA = as.a(pbVar, z, resources.getInteger(R.integer.config_appsCustomizeWorkspaceAnimationStagger), -1);
        } else {
            animatorA = (pbVar == pb.SPRING_LOADED || pbVar == pb.OVERVIEW) ? as.a(pbVar, z) : null;
        }
        a(appsCustomizeTabHost, integer3);
        g(z);
        if (!z) {
            appsCustomizeTabHost.setVisibility(8);
            a((View) appsCustomizeTabHost, z, true);
            b((View) appsCustomizeTabHost, z, true);
            c((View) appsCustomizeTabHost, z, true);
            a((View) workspace, z, true);
            b((View) workspace, z, true);
            c((View) workspace, z, true);
            return;
        }
        kt ktVar = new kt(appsCustomizeTabHost);
        ktVar.b(integer3).c(integer3).setDuration(integer).setInterpolator(new pe());
        ObjectAnimator duration = ik.a(appsCustomizeTabHost, "alpha", 1.0f, 0.0f).setDuration(integer2);
        duration.setInterpolator(new AccelerateDecelerateInterpolator());
        duration.addUpdateListener(new hc(this, appsCustomizeTabHost, workspace));
        this.ai = ik.b();
        a((View) appsCustomizeTabHost, z, true);
        a((View) workspace, z, true);
        this.bA.q();
        this.ai.addListener(new hd(this, appsCustomizeTabHost, z, workspace, runnable));
        this.ai.playTogether(ktVar, duration);
        if (animatorA != null) {
            this.ai.play(animatorA);
        }
        b((View) appsCustomizeTabHost, z, true);
        b((View) workspace, z, true);
        ik.a(this.ai, workspace);
    }

    public static void a(String str, String str2, boolean z) {
        if (z) {
            Log.d(str, str2);
        }
    }

    private void a(boolean z, boolean z2) {
        a(z, z2, this.bA.getContentType());
    }

    private void a(boolean z, boolean z2, q qVar) {
        if (this.ai != null) {
            this.ai.setDuration(0L);
            this.ai.cancel();
            this.ai = null;
        }
        Resources resources = getResources();
        int integer = resources.getInteger(R.integer.config_appsCustomizeZoomInTime);
        int integer2 = resources.getInteger(R.integer.config_appsCustomizeFadeInTime);
        float integer3 = resources.getInteger(R.integer.config_appsCustomizeZoomScaleFactor);
        View view = as;
        AppsCustomizeTabHost appsCustomizeTabHost = this.bz;
        int integer4 = resources.getInteger(R.integer.config_workspaceAppsCustomizeAnimationStagger);
        a(appsCustomizeTabHost, integer3);
        h(z);
        Animator animatorA = as.a(pb.SMALL, z, qVar);
        boolean z3 = AppsCustomizePagedView.b;
        if (z) {
            appsCustomizeTabHost.setScaleX(integer3);
            appsCustomizeTabHost.setScaleY(integer3);
            kt ktVar = new kt(appsCustomizeTabHost);
            ktVar.b(1.0f).c(1.0f).setDuration(integer).setInterpolator(new pf());
            appsCustomizeTabHost.setVisibility(0);
            appsCustomizeTabHost.setAlpha(0.0f);
            ObjectAnimator duration = ik.a(appsCustomizeTabHost, "alpha", 0.0f, 1.0f).setDuration(integer2);
            duration.setInterpolator(new DecelerateInterpolator(1.5f));
            duration.addUpdateListener(new gy(this, view, appsCustomizeTabHost));
            this.ai = ik.b();
            this.ai.play(ktVar).after(integer4);
            this.ai.play(duration).after(integer4);
            this.ai.addListener(new gz(this, appsCustomizeTabHost, view, z));
            if (animatorA != null) {
                this.ai.play(animatorA);
            }
            a(view, z, false);
            a((View) appsCustomizeTabHost, z, false);
            boolean z4 = appsCustomizeTabHost.getContent().getMeasuredWidth() == 0 || as.getMeasuredWidth() == 0 || appsCustomizeTabHost.getMeasuredWidth() == 0;
            ha haVar = new ha(this, this.ai, appsCustomizeTabHost, integer3, view, z);
            if (z4) {
                appsCustomizeTabHost.getViewTreeObserver().addOnGlobalLayoutListener(new hb(this, haVar, appsCustomizeTabHost));
            } else {
                haVar.run();
            }
        } else {
            appsCustomizeTabHost.setTranslationX(0.0f);
            appsCustomizeTabHost.setTranslationY(0.0f);
            appsCustomizeTabHost.setScaleX(1.0f);
            appsCustomizeTabHost.setScaleY(1.0f);
            appsCustomizeTabHost.setVisibility(0);
            if (!z2 && !ip.a().j() && this.by != null) {
                this.by.b(false);
            }
            a(view, z, false);
            b(view, z, false);
            c(view, z, false);
            a((View) appsCustomizeTabHost, z, false);
            b((View) appsCustomizeTabHost, z, false);
            c((View) appsCustomizeTabHost, z, false);
        }
        if (qVar == q.Widgets) {
            E().setVisibility(0);
        }
    }

    private boolean a(ig igVar) {
        boolean z;
        switch (igVar.f304a) {
            case 1:
                b(igVar.b, igVar.c, igVar.d, igVar.e, igVar.f);
                z = true;
                break;
            case 2:
            case 3:
            case 4:
            default:
                z = false;
                break;
            case 5:
                a(igVar.b.getIntExtra("appWidgetId", -1), igVar.c, igVar.d, (AppWidgetHostView) null, (AppWidgetProviderInfo) null);
                z = true;
                break;
            case 6:
                a(igVar.b, igVar.c, igVar.d, igVar.e, igVar.f);
                z = false;
                break;
            case 7:
                a(igVar.b);
                z = false;
                break;
        }
        aD();
        return z;
    }

    private boolean a(Runnable runnable, boolean z) {
        if (!this.bI) {
            return false;
        }
        Log.i("Launcher", "Deferring update until onResume");
        if (z) {
            while (this.bM.remove(runnable)) {
            }
        }
        this.bM.add(runnable);
        return true;
    }

    static int[] a(Context context, AppWidgetProviderInfo appWidgetProviderInfo) {
        return a(context, appWidgetProviderInfo.provider, appWidgetProviderInfo.minWidth, appWidgetProviderInfo.minHeight);
    }

    static int[] a(Context context, ComponentName componentName, int i2, int i3) {
        Rect defaultPaddingForWidget = AppWidgetHostView.getDefaultPaddingForWidget(context, componentName, null);
        return CellLayout.d(defaultPaddingForWidget.left + i2 + defaultPaddingForWidget.right, defaultPaddingForWidget.bottom + defaultPaddingForWidget.top + i3, null);
    }

    private void aA() {
        if (this.bb != null) {
            this.bb.setText("");
        }
        if (this.aO != null) {
            this.aO.setVisibility(0);
        }
        if (this.aP != null) {
            this.aP.setVisibility(8);
        }
        if (this.aQ != null) {
            this.aQ.setImageResource(a.b.a().d);
        }
        if (this.aW != null) {
            this.aW.setText(com.syu.g.l.b("car_distance"));
        }
        if (this.aX != null) {
            this.aX.setText("0");
        }
        if (this.be != null) {
            this.be.setText(com.syu.g.l.b("surplus_distance"));
        }
        if (this.aY != null) {
            this.aY.setText("");
        }
        if (this.aR != null) {
            this.aR.setVisibility(8);
        }
        if (this.bc != null) {
            this.bc.setText(com.syu.g.l.b("remaintime"));
        }
        if (this.ba != null) {
            this.ba.setText(com.syu.g.l.b("car_realnavi"));
        }
        if (this.aV != null) {
            this.aV.setVisibility(0);
        }
        if (this.bf != null) {
            this.bf.setText("0");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aB() {
        if (com.syu.g.b.a(getApplicationContext(), "com.autonavi.amapauto")) {
            return;
        }
        b((View) this.bx.get("WS_Gaode"), com.syu.g.g.a(this, "com.autonavi.amapauto"), "amap");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aC() {
        boolean z = this.bS && this.bR && !this.cd.isEmpty();
        if (z != this.bB) {
            this.bB = z;
            if (z) {
                c(this.cc == -1 ? 20000L : this.cc);
                return;
            }
            if (!this.cd.isEmpty()) {
                this.cc = Math.max(0L, 20000 - (System.currentTimeMillis() - this.cb));
            }
            this.ee.removeMessages(1);
            this.ee.removeMessages(0);
        }
    }

    private void aD() {
        this.bs.h = -1L;
        this.bs.i = -1L;
        ec ecVar = this.bs;
        this.bs.k = -1;
        ecVar.j = -1;
        ec ecVar2 = this.bs;
        this.bs.m = -1;
        ecVar2.l = -1;
        ec ecVar3 = this.bs;
        this.bs.o = -1;
        ecVar3.n = -1;
        this.bs.r = null;
    }

    private void aE() {
        getContentResolver().registerContentObserver(LauncherProvider.f89a, true, this.aq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aF() {
        if (this.br != null) {
            this.br.startListening();
        }
    }

    private int aG() {
        switch (getResources().getConfiguration().orientation) {
            case 2:
                return 1;
            default:
                return 0;
        }
    }

    private boolean aH() {
        return getSharedPreferences(ip.h(), 0).getBoolean("debug.show_mem", false);
    }

    private void aI() {
        SharedPreferences sharedPreferences = getSharedPreferences(ip.h(), 0);
        boolean z = sharedPreferences.getBoolean("debug.show_mem", true) ? false : true;
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putBoolean("debug.show_mem", z);
        editorEdit.commit();
        if (this.aw != null) {
            this.aw.setVisibility(z ? 0 : 8);
        }
    }

    private boolean aJ() {
        return System.currentTimeMillis() - this.av.c() > ((long) (am * 1000));
    }

    private boolean aK() {
        return false;
    }

    private boolean aL() {
        AccountManager accountManager;
        return ((Cling) findViewById(R.id.workspace_cling)).getDrawIdentifier().equals("workspace_custom") && (accountManager = AccountManager.get(this)) != null && accountManager.getAccountsByType("com.google").length == 0;
    }

    private void ao() {
        boolean zO;
        boolean z = true;
        boolean zI = false;
        int iAG = aG();
        if (cf[iAG] == null || cg[iAG] == null || ch[iAG] == null) {
            zO = O();
            zI = i(zO);
        } else {
            zO = false;
        }
        if (cf[iAG] != null) {
            a(cf[iAG]);
            zO = true;
        }
        if (cg[iAG] != null) {
            b(cg[iAG]);
        } else {
            z = zI;
        }
        if (this.by != null) {
            this.by.a(zO, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap() {
        if (bV == null) {
            new er(this).execute(new Void[0]);
            return;
        }
        Configuration configuration = getResources().getConfiguration();
        String str = bV.f302a;
        String string = configuration.locale.toString();
        int i2 = bV.b;
        int i3 = configuration.mcc;
        int i4 = bV.c;
        int i5 = configuration.mnc;
        if ((string.equals(str) && i3 == i2 && i5 == i4) ? false : true) {
            bV.f302a = string;
            bV.b = i3;
            bV.c = i5;
            this.bQ.b();
            new es(this, "WriteLocaleConfiguration", bV).start();
        }
    }

    private boolean aq() {
        return !((InputMethodManager) getSystemService("input_method")).isFullscreenMode();
    }

    private String ar() {
        return this.bF.toString();
    }

    private void as() {
        this.bF.clear();
        this.bF.clearSpans();
        Selection.setSelection(this.bF, 0);
    }

    private void at() {
        if (this.r == null) {
            return;
        }
        this.bx.put("Navi", this.r.findViewById(a.b.a().ac));
        this.bx.put("Voice", this.r.findViewById(a.b.a().f4cn));
        this.bx.put("Setting", this.r.findViewById(a.b.a().cH));
        this.bx.put("Video", this.r.findViewById(a.b.a().cP));
        this.bx.put("Bluetooth", this.r.findViewById(a.b.a().bM));
        this.bx.put("Radio", this.r.findViewById(a.b.a().br));
        this.bx.put("Music", this.r.findViewById(a.b.a().aD));
        this.bx.put("Btav", this.r.findViewById(a.b.a().bN));
        this.bx.put("ECAR", this.r.findViewById(a.b.a().du));
        this.bx.put("SOS", this.r.findViewById(a.b.a().dv));
        this.bx.put("Kuwo", this.r.findViewById(a.b.a().dl));
        this.bx.put("UNICAR", this.r.findViewById(a.b.a().cl));
        this.bx.put("Klfm", this.r.findViewById(a.b.a().ce));
        this.bx.put("HONGFANS", this.r.findViewById(a.b.a().cf));
        this.bx.put("Dvr", this.r.findViewById(a.b.a().dJ));
        this.bx.put("Light", this.r.findViewById(a.b.a().cS));
        this.bx.put("CLOLSESCREEN", this.r.findViewById(a.b.a().cU));
        this.bx.put("Wifi", this.r.findViewById(a.b.a().cV));
        this.bx.put("Sound", this.r.findViewById(a.b.a().cW));
        this.bx.put("CloseSound", this.r.findViewById(a.b.a().cX));
        this.bx.put("BRIGHT", this.r.findViewById(a.b.a().cR));
        this.bx.put("Eq", this.r.findViewById(a.b.a().cY));
        this.bx.put("Time", this.r.findViewById(a.b.a().bQ));
        this.bx.put("ALLAPP", this.r.findViewById(a.b.a().aP));
        this.bx.put("BROWSER", this.r.findViewById(a.b.a().dx));
        this.bx.put("NEWEYE", this.r.findViewById(a.b.a().dB));
        this.bx.put("CANBUS", this.r.findViewById(a.b.a().dz));
        this.bx.put("FILEMANAGER", this.r.findViewById(a.b.a().cq));
        this.ds = (TextView) this.r.findViewById(a.b.a().aT);
        if (LauncherApplication.f88a.getResources().getBoolean(R.bool.weather_show)) {
            this.cx = (ImageView) this.r.findViewById(a.b.a().dM);
            Log.i("hy", "weatherImg" + this.cx);
            this.cz = (TextView) this.r.findViewById(a.b.a().dN);
            this.cA = (TextView) this.r.findViewById(a.b.a().dO);
            this.cB = (TextView) this.r.findViewById(a.b.a().dP);
            this.cD = (TextView) this.r.findViewById(a.b.a().dQ);
            this.cy = (ImageView) this.r.findViewById(a.b.a().dR);
            this.cE = (TextView) this.r.findViewById(a.b.a().dS);
            this.cF = (TextView) this.r.findViewById(a.b.a().dT);
            this.cG = (TextView) this.r.findViewById(a.b.a().dU);
            this.cH = (TextView) this.r.findViewById(a.b.a().dV);
            this.cC = (TextView) this.r.findViewById(a.b.a().dW);
        }
        if (this.bx.get("Navi") != null) {
            ((View) this.bx.get("Navi")).setOnClickListener(this);
        }
        if (this.bx.get("Voice") != null) {
            ((View) this.bx.get("Voice")).setOnClickListener(this);
        }
        if (this.bx.get("Setting") != null) {
            ((View) this.bx.get("Setting")).setOnClickListener(this);
        }
        if (this.bx.get("Video") != null) {
            ((View) this.bx.get("Video")).setOnClickListener(this);
        }
        if (this.bx.get("BRIGHT") != null) {
            ((View) this.bx.get("BRIGHT")).setOnClickListener(this);
        }
        if (this.bx.get("Bluetooth") != null) {
            ((View) this.bx.get("Bluetooth")).setOnClickListener(this);
        }
        if (this.bx.get("Radio") != null) {
            ((View) this.bx.get("Radio")).setOnClickListener(this);
        }
        if (this.bx.get("Music") != null) {
            ((View) this.bx.get("Music")).setOnClickListener(this);
        }
        if (this.bx.get("Btav") != null) {
            ((View) this.bx.get("Btav")).setOnClickListener(this);
        }
        if (this.bx.get("ECAR") != null) {
            ((View) this.bx.get("ECAR")).setOnClickListener(this);
        }
        if (this.bx.get("SOS") != null) {
            ((View) this.bx.get("SOS")).setOnClickListener(this);
        }
        if (this.bx.get("Kuwo") != null) {
            ((View) this.bx.get("Kuwo")).setOnClickListener(this);
        }
        if (this.bx.get("UNICAR") != null) {
            ((View) this.bx.get("UNICAR")).setOnClickListener(this);
        }
        if (this.bx.get("Klfm") != null) {
            ((View) this.bx.get("Klfm")).setOnClickListener(this);
        }
        if (this.bx.get("HONGFANS") != null) {
            ((View) this.bx.get("HONGFANS")).setOnClickListener(this);
        }
        if (this.bx.get("Dvr") != null) {
            ((View) this.bx.get("Dvr")).setOnClickListener(this);
        }
        if (this.bx.get("Light") != null) {
            ((View) this.bx.get("Light")).setOnClickListener(this);
        }
        if (this.bx.get("CLOLSESCREEN") != null) {
            ((View) this.bx.get("CLOLSESCREEN")).setOnClickListener(this);
        }
        if (this.bx.get("Wifi") != null) {
            ((View) this.bx.get("Wifi")).setOnClickListener(this);
        }
        if (this.bx.get("Sound") != null) {
            ((View) this.bx.get("Sound")).setOnClickListener(this);
        }
        if (this.bx.get("CloseSound") != null) {
            ((View) this.bx.get("CloseSound")).setOnClickListener(this);
        }
        if (this.bx.get("Eq") != null) {
            ((View) this.bx.get("Eq")).setOnClickListener(this);
        }
        if (this.bx.get("Time") != null) {
            ((View) this.bx.get("Time")).setOnClickListener(this);
        }
        if (this.bx.get("ALLAPP") != null) {
            ((View) this.bx.get("ALLAPP")).setOnClickListener(this);
        }
        if (this.bx.get("BROWSER") != null) {
            ((View) this.bx.get("BROWSER")).setOnClickListener(this);
        }
        if (this.bx.get("CANBUS") != null) {
            ((View) this.bx.get("CANBUS")).setOnClickListener(this);
        }
        if (this.bx.get("FILEMANAGER") != null) {
            ((View) this.bx.get("FILEMANAGER")).setOnClickListener(this);
        }
        if (this.bx.get("NEWEYE") != null) {
            ((View) this.bx.get("NEWEYE")).setOnClickListener(this);
        }
    }

    private void au() {
        bo boVar = this.av;
        this.at = findViewById(R.id.launcher);
        this.au = (DragLayer) findViewById(R.id.drag_layer);
        as = (Workspace) this.au.findViewById(R.id.workspace);
        this.at.setSystemUiVisibility(1536);
        this.au.a(this, boVar);
        this.r = findViewById(R.id.hotseat);
        this.bw = findViewById(R.id.overview_panel);
        i = findViewById(a.b.a().aU);
        k = findViewById(a.b.a().aV);
        j = findViewById(a.b.a().aW);
        if (LauncherApplication.f88a.getResources().getBoolean(R.bool.iswidgetpages)) {
            if (i != null) {
                i.setOnTouchListener(y());
                i.setOnClickListener(new ex(this));
            }
        } else if (i != null) {
            i.setVisibility(8);
        }
        if (this.r != null) {
            this.s = this.r.findViewById(a.b.a().aR);
        }
        at();
        if (this.s != null) {
            this.s.setOnTouchListener(y());
            this.s.setOnClickListener(this);
        }
        if (j != null) {
            j.setOnClickListener(new ey(this));
            j.setOnTouchListener(y());
        }
        if (k != null) {
            k.setOnClickListener(new ez(this));
        }
        View viewFindViewById = findViewById(a.b.a().aX);
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(new fb(this));
            viewFindViewById.setOnTouchListener(y());
        }
        this.bw.setAlpha(0.0f);
        as.setHapticFeedbackEnabled(false);
        as.setOnLongClickListener(this);
        as.setup(boVar);
        boVar.a((bp) as);
        this.by = (SearchDropTargetBar) this.au.findViewById(R.id.qqsb_bar);
        this.bz = (AppsCustomizeTabHost) findViewById(R.id.apps_customize_pane);
        this.bA = (AppsCustomizePagedView) this.bz.findViewById(R.id.apps_customize_pane_content);
        this.bA.a(this, boVar);
        boVar.a((by) as);
        boVar.b(this.au);
        boVar.a((View) as);
        boVar.a((ce) as);
        if (this.by != null) {
            this.by.a(this, boVar);
        }
        if (getResources().getBoolean(R.bool.debug_memory_enabled)) {
            Log.v("Launcher", "adding WeightWatcher");
            this.aw = new nv(this);
            this.aw.setAlpha(0.5f);
            ((FrameLayout) this.at).addView(this.aw, new FrameLayout.LayoutParams(-1, -2, 80));
            this.aw.setVisibility(aH() ? 0 : 8);
        }
        this.t = (RelativeLayout) findViewById(a.b.a().eR);
        ImageView imageView = (ImageView) findViewById(a.b.a().eS);
        if (imageView != null) {
            imageView.setOnClickListener(new fc(this));
        }
        if (this.t != null) {
            this.t.setOnClickListener(new fd(this));
        }
    }

    private void av() {
        if (as != null) {
            this.ax = (TextView) as.findViewById(a.b.a().by);
            this.ay = (TextView) as.findViewById(a.b.a().bA);
            this.aA = (Button) as.findViewById(a.b.a().bl);
            this.aB = (Button) as.findViewById(a.b.a().bm);
            this.aC = (Button) as.findViewById(a.b.a().bn);
            this.aD = (Button) as.findViewById(a.b.a().as);
            this.aE = (Button) as.findViewById(a.b.a().at);
            this.aF = (Button) as.findViewById(a.b.a().au);
            this.aG = (Button) as.findViewById(a.b.a().av);
            this.aH = (Button) as.findViewById(a.b.a().bE);
            this.aI = (Button) as.findViewById(a.b.a().bF);
            this.aJ = (Button) as.findViewById(a.b.a().bG);
            this.dx = (Button) as.findViewById(a.b.a().aw);
            this.dy = (Button) as.findViewById(a.b.a().ax);
            this.dz = (Button) as.findViewById(a.b.a().dp);
            this.dA = (Button) as.findViewById(a.b.a().dq);
            this.dB = (Button) as.findViewById(a.b.a().dr);
            this.dl = (TextView) as.findViewById(a.b.a().dn);
            this.dm = (TextView) as.findViewById(a.b.a().f0do);
            this.dC = (Button) as.findViewById(a.b.a().cK);
            this.dD = (Button) as.findViewById(a.b.a().cL);
            this.dE = (Button) as.findViewById(a.b.a().cM);
            this.aK = as.findViewById(a.b.a().bL);
            this.aL = as.findViewById(a.b.a().bp);
            this.aM = as.findViewById(a.b.a().aC);
            this.aN = as.findViewById(a.b.a().bJ);
            this.aO = as.findViewById(a.b.a().y);
            this.aP = as.findViewById(a.b.a().z);
            this.aQ = (ImageView) as.findViewById(a.b.a().A);
            this.aW = (TextView) as.findViewById(a.b.a().C);
            this.aT = (ImageView) as.findViewById(a.b.a().O);
            this.aU = (ImageView) as.findViewById(a.b.a().K);
            this.aX = (TextView) as.findViewById(a.b.a().R);
            this.aY = (TextView) as.findViewById(a.b.a().S);
            this.aR = (ImageView) as.findViewById(a.b.a().T);
            this.aZ = (TextView) as.findViewById(a.b.a().U);
            this.ba = (TextView) as.findViewById(a.b.a().V);
            this.bb = (TextView) as.findViewById(a.b.a().W);
            this.bc = (TextView) as.findViewById(a.b.a().X);
            this.be = (TextView) as.findViewById(a.b.a().D);
            this.bf = (TextView) as.findViewById(a.b.a().B);
            this.aS = (ImageView) as.findViewById(a.b.a().Y);
            this.aV = (ImageView) as.findViewById(a.b.a().L);
            this.bg = (ImageView) as.findViewById(a.b.a().G);
            this.bh = (ImageView) as.findViewById(a.b.a().H);
            this.bi = (ImageView) as.findViewById(a.b.a().I);
            this.bj = (ImageView) as.findViewById(a.b.a().J);
            this.cR = (TextView) as.findViewById(a.b.a().ah);
            this.cW = (TextView) as.findViewById(a.b.a().ai);
            this.O = (ImageView) as.findViewById(a.b.a().aq);
            this.P = (ImageView) as.findViewById(a.b.a().ar);
            this.cX = (TextView) as.findViewById(a.b.a().aj);
            this.cY = (TextView) as.findViewById(a.b.a().ak);
            this.cS = (TextView) as.findViewById(a.b.a().am);
            this.cT = (TextView) as.findViewById(a.b.a().an);
            this.dH = (SeekBar) as.findViewById(a.b.a().ao);
            this.dI = (ProgressBar) as.findViewById(a.b.a().ap);
            this.dK = new MediaPlayer();
            this.db = (TextView) as.findViewById(a.b.a().ab);
            this.dc = (TextView) as.findViewById(a.b.a().cG);
            this.dd = (TextView) as.findViewById(a.b.a().cs);
            this.de = (TextView) as.findViewById(a.b.a().al);
            this.df = (TextView) as.findViewById(a.b.a().bq);
            this.dn = (TextView) as.findViewById(a.b.a().cO);
            this.dr = (TextView) as.findViewById(a.b.a().ca);
            this.dk = (TextView) as.findViewById(a.b.a().aS);
            this.dg = (TextView) as.findViewById(a.b.a().bB);
            this.dh = (TextView) as.findViewById(a.b.a().bC);
            this.di = (TextView) as.findViewById(a.b.a().bD);
            this.dj = (TextView) as.findViewById(a.b.a().cJ);
            this.f1do = (TextView) as.findViewById(a.b.a().cp);
            this.dp = (TextView) as.findViewById(a.b.a().cc);
            this.dq = (TextView) as.findViewById(a.b.a().dF);
            this.dw = (TextView) as.findViewById(a.b.a().cx);
            this.N = (ImageView) as.findViewById(a.b.a().af);
            this.dt = (TextView) as.findViewById(a.b.a().cu);
            this.du = (TextView) as.findViewById(a.b.a().cv);
            this.dv = (TextView) as.findViewById(a.b.a().cw);
            this.dT = as.findViewById(R.id.fl_media);
            this.dL = as.findViewById(a.b.a().dA);
            this.dU = (android.a.a.c.af) as.findViewById(a.b.a().dD);
            if (this.dU != null) {
                aw();
            }
            if (this.dL != null) {
                this.dL.setOnClickListener(new fe(this));
            }
            this.dM = as.findViewById(a.b.a().dC);
            if (this.dM != null) {
                this.dM.setOnClickListener(new ff(this));
            }
            this.dV = (HorizontalListView) as.findViewById(R.id.hlv);
            this.dW = new dk(this.A, o);
            this.dV.setAdapter((ListAdapter) this.dW);
            this.dN = (ImageView) as.findViewById(a.b.a().E);
            this.dO = (ImageView) as.findViewById(a.b.a().F);
            if (this.dN != null) {
                this.dN.setOnClickListener(new fg(this));
            }
            if (this.dO != null) {
                this.dO.setOnClickListener(new fh(this));
            }
            this.bd = (TextView) as.findViewById(a.b.a().db);
            this.bk = as.findViewById(a.b.a().dg);
            this.bl = as.findViewById(a.b.a().dh);
            this.bm = as.findViewById(a.b.a().di);
            this.bn = as.findViewById(a.b.a().dj);
            if (this.bl != null) {
                this.bl.setOnClickListener(new fi(this));
            }
            if (this.bm != null) {
                this.bm.setOnClickListener(new fj(this));
            }
            if (this.bn != null) {
                this.bn.setOnClickListener(new fk(this));
            }
            this.bx.put("WS_Music", as.findViewById(a.b.a().ay));
            this.bx.put("WS_Music_Two", as.findViewById(a.b.a().az));
            this.bx.put("WS_Music3", as.findViewById(a.b.a().aA));
            this.bx.put("WS_Maps", as.findViewById(a.b.a().cB));
            this.bx.put("WS_Spotify", as.findViewById(a.b.a().cC));
            this.bx.put("WS_YouTube", as.findViewById(a.b.a().cD));
            this.bx.put("WS_Chrome", as.findViewById(a.b.a().cE));
            this.bx.put("WS_MusicIV", as.findViewById(a.b.a().aB));
            this.bx.put("WS_Radio", as.findViewById(a.b.a().bo));
            this.bx.put("WS_Video", as.findViewById(a.b.a().cI));
            this.bx.put("WS_Gallery", as.findViewById(a.b.a().cb));
            this.bx.put("WS_Miudrive", as.findViewById(a.b.a().cN));
            this.bx.put("WS_Aux", as.findViewById(a.b.a().bZ));
            this.bx.put("WS_Bt", as.findViewById(a.b.a().bK));
            this.bx.put("WS_Navi", as.findViewById(a.b.a().aa));
            this.bx.put("WS_Gaode", as.findViewById(a.b.a().Z));
            this.bx.put("WS_Klfm", as.findViewById(a.b.a().cd));
            this.bx.put("WS_Kuwo", as.findViewById(a.b.a().dk));
            this.bx.put("WS_Dvr", as.findViewById(a.b.a().dE));
            this.bx.put("WS_Dvd", as.findViewById(a.b.a().cg));
            this.bx.put("WS_Steer", as.findViewById(a.b.a().ch));
            this.bx.put("WS_Easyconn", as.findViewById(a.b.a().ci));
            this.bx.put("WS_Recharge", as.findViewById(a.b.a().ck));
            this.bx.put("WS_Voice", as.findViewById(a.b.a().cm));
            this.bx.put("WS_File", as.findViewById(a.b.a().co));
            this.bx.put("WS_Car", as.findViewById(a.b.a().cr));
            this.bx.put("WS_Tire", as.findViewById(a.b.a().ct));
            this.bx.put("WS_Time", as.findViewById(a.b.a().bO));
            this.bx.put("WS_Time_Two", as.findViewById(a.b.a().bP));
            this.bx.put("WS_Settings", as.findViewById(a.b.a().cF));
            this.bx.put("WS_Allapps", as.findViewById(a.b.a().aQ));
            this.bx.put("WS_Dvr_Rec", as.findViewById(a.b.a().dG));
            this.bx.put("WS_Dvr_Lock", as.findViewById(a.b.a().dH));
            this.bx.put("WS_Dvr_Catch", as.findViewById(a.b.a().dI));
            this.bx.put("WS_BRIGHT", as.findViewById(a.b.a().cQ));
            this.bx.put("WS_BROWSER", as.findViewById(a.b.a().dw));
            this.bx.put("WS_CANBUS", as.findViewById(a.b.a().dy));
            this.bx.put("WS_EQ", as.findViewById(a.b.a().cZ));
            this.bx.put("WS_CLOLSESCREEN", as.findViewById(a.b.a().cT));
            this.bx.put("CALCULATOR", as.findViewById(a.b.a().cz));
            this.bx.put("WS_GUIDE", as.findViewById(a.b.a().cy));
            this.bx.put("WS360", as.findViewById(a.b.a().cA));
            this.bx.put("WS_SOUND", as.findViewById(a.b.a().dc));
            this.bx.put("WS_CLOLSESOUND", as.findViewById(a.b.a().dd));
            if (this.bd != null) {
                this.bd.setText(String.valueOf(LauncherApplication.f88a.getResources().getString(R.string.car_speed)) + this.J);
            }
            if (!LauncherApplication.f88a.getResources().getBoolean(R.bool.weather_show)) {
                this.cx = (ImageView) as.findViewById(a.b.a().dM);
                this.cz = (TextView) as.findViewById(a.b.a().dN);
                this.cA = (TextView) as.findViewById(a.b.a().dO);
                this.cB = (TextView) as.findViewById(a.b.a().dP);
                this.cD = (TextView) as.findViewById(a.b.a().dQ);
                this.cy = (ImageView) as.findViewById(a.b.a().dR);
                this.cE = (TextView) as.findViewById(a.b.a().dS);
                this.cF = (TextView) as.findViewById(a.b.a().dT);
                this.cG = (TextView) as.findViewById(a.b.a().dU);
                this.cH = (TextView) as.findViewById(a.b.a().dV);
                this.cC = (TextView) as.findViewById(a.b.a().dW);
            }
            this.cZ = (TextView) as.findViewById(a.b.a().bh);
            this.da = (TextView) as.findViewById(a.b.a().bj);
            this.dG = (com.fyt.widget.k) as.findViewById(a.b.a().bi);
            this.cQ = (TextView) as.findViewById(a.b.a().bk);
        }
        if (this.cR != null) {
            if (MusicService.c == null || MusicService.c.equals("") || MusicService.c.lastIndexOf("/") < 0) {
                this.cR.setText(R.string.music_name);
            } else {
                this.cR.setText(MusicService.c.substring(MusicService.c.lastIndexOf("/") + 1));
            }
        }
        if (this.cW != null) {
            if (MusicService.c == null || MusicService.c.equals("") || MusicService.c.lastIndexOf("/") < 0) {
                this.cW.setText(R.string.music_name);
            } else {
                this.cW.setText(MusicService.c.substring(MusicService.c.lastIndexOf("/") + 1));
            }
        }
        if (this.cS != null) {
            this.cS.setText("00:00");
        }
        if (this.cT != null) {
            this.cT.setText("00:00");
        }
        if (this.dH != null) {
            this.dH.setOnSeekBarChangeListener(new Cif(this, null));
        }
        if (this.dx != null) {
            if (MusicService.d.booleanValue()) {
                this.dx.setBackground(com.fyt.b.g.a(a.b.a().ae));
            } else {
                this.dx.setBackground(com.fyt.b.g.a(a.b.a().ad));
            }
        }
        if (this.bx.get("WS_Dvr_Rec") != null) {
            if (DvrService.c == 1) {
                if (this.bx.get("WS_Dvr_Rec") != null) {
                    ((View) this.bx.get("WS_Dvr_Rec")).setBackgroundResource(a.b.a().dK);
                }
            } else if (this.bx.get("WS_Dvr_Rec") != null) {
                ((View) this.bx.get("WS_Dvr_Rec")).setBackgroundResource(a.b.a().dL);
            }
        }
        if (this.dy != null) {
            if (MusicService.d.booleanValue()) {
                this.dy.setBackgroundResource(a.b.a().ae);
            } else {
                this.dy.setBackgroundResource(a.b.a().ad);
            }
        }
        if (this.cX != null) {
            this.cX.setText(R.string.music_author);
        }
        if (this.cY != null) {
            this.cY.setText(R.string.music_album);
        }
        if (this.aN != null) {
            this.aN.setOnClickListener(this);
        }
        if (this.ax != null) {
            this.ax.setText(R.string.car_bt_music);
        }
        if (this.ay != null) {
            this.ay.setText(R.string.music_unknown);
        }
        if (this.cQ != null) {
            this.cQ.setText("87.50");
        }
        if (this.da != null) {
            this.da.setText("MHz");
        }
        if (this.cZ != null) {
            if (this.cZ.getBackground() != null) {
                this.cZ.setBackgroundResource(a.b.a().be);
            } else {
                this.cZ.setText("FM");
            }
        }
        if (this.bx.get("WS_Navi") != null) {
            this.dP = (View) this.bx.get("WS_Navi");
            this.dP.setOnClickListener(this);
            this.dP.setOnLongClickListener(this);
        }
        if (this.bx.get("WS_Music") != null) {
            this.dQ = (View) this.bx.get("WS_Music");
            this.dQ.setOnClickListener(this);
            this.dQ.setOnLongClickListener(this);
        }
        if (this.bx.get("WS_Radio") != null) {
            this.dR = (View) this.bx.get("WS_Radio");
            this.dR.setOnClickListener(this);
            this.dR.setOnLongClickListener(this);
        }
        if (this.bx.get("WS_Time") != null) {
            this.dS = (View) this.bx.get("WS_Time");
            this.dS.setOnClickListener(this);
            this.dS.setOnLongClickListener(this);
        }
        if (this.bx.get("WS_Music_Two") != null) {
            ((View) this.bx.get("WS_Music_Two")).setOnClickListener(this);
        }
        if (this.bx.get("WS_Music3") != null) {
            ((View) this.bx.get("WS_Music3")).setOnClickListener(this);
        }
        if (this.bx.get("WS_Maps") != null) {
            ((View) this.bx.get("WS_Maps")).setOnClickListener(this);
        }
        if (this.bx.get("WS_Spotify") != null) {
            ((View) this.bx.get("WS_Spotify")).setOnClickListener(this);
        }
        if (this.bx.get("WS_YouTube") != null) {
            ((View) this.bx.get("WS_YouTube")).setOnClickListener(this);
        }
        if (this.bx.get("WS_Chrome") != null) {
            ((View) this.bx.get("WS_Chrome")).setOnClickListener(this);
        }
        if (this.bx.get("WS_MusicIV") != null) {
            ((View) this.bx.get("WS_MusicIV")).setOnClickListener(this);
        }
        if (this.bx.get("WS_Video") != null) {
            ((View) this.bx.get("WS_Video")).setOnClickListener(this);
        }
        if (this.bx.get("WS_BRIGHT") != null) {
            ((View) this.bx.get("WS_BRIGHT")).setOnClickListener(this);
        }
        if (this.bx.get("WS_Gallery") != null) {
            ((View) this.bx.get("WS_Gallery")).setOnClickListener(this);
        }
        if (this.bx.get("WS_Miudrive") != null) {
            ((View) this.bx.get("WS_Miudrive")).setOnClickListener(this);
        }
        if (this.bx.get("WS_Aux") != null) {
            ((View) this.bx.get("WS_Aux")).setOnClickListener(this);
        }
        if (this.bx.get("WS_Bt") != null) {
            ((View) this.bx.get("WS_Bt")).setOnClickListener(this);
            ((View) this.bx.get("WS_Bt")).setOnLongClickListener(this);
        }
        if (this.bx.get("WS_Gaode") != null) {
            ((View) this.bx.get("WS_Gaode")).setOnClickListener(this);
        }
        if (this.bx.get("WS_Klfm") != null) {
            ((View) this.bx.get("WS_Klfm")).setOnClickListener(this);
        }
        if (this.bx.get("WS_Kuwo") != null) {
            ((View) this.bx.get("WS_Kuwo")).setOnClickListener(this);
        }
        if (this.bx.get("WS_Dvr") != null) {
            ((View) this.bx.get("WS_Dvr")).setOnClickListener(this);
        }
        if (this.bx.get("WS_Dvd") != null) {
            ((View) this.bx.get("WS_Dvd")).setOnClickListener(this);
        }
        if (this.bx.get("WS_Steer") != null) {
            ((View) this.bx.get("WS_Steer")).setOnClickListener(this);
        }
        if (this.bx.get("WS_Easyconn") != null) {
            ((View) this.bx.get("WS_Easyconn")).setOnClickListener(this);
        }
        if (this.bx.get("WS_Recharge") != null) {
            ((View) this.bx.get("WS_Recharge")).setOnClickListener(this);
        }
        if (this.bx.get("WS_Voice") != null) {
            ((View) this.bx.get("WS_Voice")).setOnClickListener(this);
        }
        if (this.bx.get("WS_File") != null) {
            ((View) this.bx.get("WS_File")).setOnClickListener(this);
        }
        if (this.bx.get("WS_Car") != null) {
            ((View) this.bx.get("WS_Car")).setOnClickListener(this);
        }
        if (this.bx.get("WS_Tire") != null) {
            ((View) this.bx.get("WS_Tire")).setOnClickListener(this);
        }
        if (this.bx.get("WS_Time_Two") != null) {
            ((View) this.bx.get("WS_Time_Two")).setOnClickListener(this);
        }
        if (this.bx.get("WS_Settings") != null) {
            ((View) this.bx.get("WS_Settings")).setOnClickListener(this);
        }
        if (this.bx.get("WS_Allapps") != null) {
            ((View) this.bx.get("WS_Allapps")).setOnClickListener(this);
        }
        if (this.bx.get("WS_Dvr_Rec") != null) {
            ((View) this.bx.get("WS_Dvr_Rec")).setOnClickListener(this);
        }
        if (this.bx.get("WS_Dvr_Lock") != null) {
            ((View) this.bx.get("WS_Dvr_Lock")).setOnClickListener(this);
        }
        if (this.bx.get("WS_Dvr_Catch") != null) {
            ((View) this.bx.get("WS_Dvr_Catch")).setOnClickListener(this);
        }
        if (this.bx.get("WS_BROWSER") != null) {
            ((View) this.bx.get("WS_BROWSER")).setOnClickListener(this);
        }
        if (this.bx.get("WS_CANBUS") != null) {
            ((View) this.bx.get("WS_CANBUS")).setOnClickListener(this);
        }
        if (this.bx.get("WS_EQ") != null) {
            ((View) this.bx.get("WS_EQ")).setOnClickListener(this);
        }
        if (this.bx.get("WS_CLOLSESCREEN") != null) {
            ((View) this.bx.get("WS_CLOLSESCREEN")).setOnClickListener(this);
        }
        if (this.bx.get("WS_CLOLSESOUND") != null) {
            ((View) this.bx.get("WS_CLOLSESOUND")).setOnClickListener(this);
        }
        if (this.bx.get("Sound") != null) {
            ((View) this.bx.get("Sound")).setOnClickListener(this);
        }
        if (this.bx.get("CALCULATOR") != null) {
            ((View) this.bx.get("CALCULATOR")).setOnClickListener(this);
        }
        if (this.bx.get("WS_GUIDE") != null) {
            ((View) this.bx.get("WS_GUIDE")).setOnClickListener(this);
        }
        if (this.bx.get("WS360") != null) {
            ((View) this.bx.get("WS360")).setOnClickListener(this);
        }
        a();
        i();
    }

    private void aw() {
        this.dX = new ArrayList();
        View viewInflate = View.inflate(this, a.b.a().de, null);
        View viewInflate2 = View.inflate(this, a.b.a().df, null);
        this.dX.add(viewInflate);
        this.dX.add(viewInflate2);
        this.dU.setAdapter(new com.fyt.a.a(this, this.dX));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ax() {
        if (!com.syu.g.b.a(getApplicationContext(), "cn.kuwo.kwmusiccar")) {
            b((View) this.bx.get("WS_Kuwo"), com.syu.g.g.a(this, "cn.kuwo.kwmusiccar"), "music");
        }
        ay();
    }

    private void ay() {
        if (com.syu.a.a.a(getApplicationContext()).a().a(0, 0, 0, 0) != 10) {
            com.syu.a.a.a(getApplicationContext()).a().a(0, 0, 10);
        }
    }

    private void az() {
        if (this.aA != null) {
            this.aA.setOnClickListener(new fm(this));
        }
        if (this.aB != null) {
            this.aB.setOnClickListener(new fn(this));
        }
        if (this.aC != null) {
            this.aC.setOnClickListener(new fo(this));
        }
        if (this.aD != null) {
            this.aD.setOnClickListener(new fp(this));
        }
        if (this.aE != null) {
            this.aE.setOnClickListener(new fq(this));
        }
        if (this.aF != null) {
            this.aF.setOnClickListener(new fr(this));
        }
        if (this.aG != null) {
            this.aG.setOnClickListener(new fs(this));
        }
        if (this.dx != null) {
            this.dx.setOnClickListener(new ft(this));
        }
        if (this.dy != null) {
            this.dy.setOnClickListener(new fu(this));
        }
        if (this.dz != null) {
            this.dz.setOnClickListener(new fv(this));
        }
        if (this.dA != null) {
            this.dA.setOnClickListener(new fz(this));
        }
        if (this.dB != null) {
            this.dB.setOnClickListener(new ga(this));
        }
        if (this.aH != null) {
            this.aH.setOnClickListener(new gb(this));
        }
        if (this.aI != null) {
            this.aI.setOnClickListener(new gc(this));
        }
        if (this.aJ != null) {
            this.aJ.setOnClickListener(new gd(this));
        }
        if (this.aK != null) {
            this.aK.setOnClickListener(new ge(this));
        }
        if (this.aL != null) {
            this.aL.setOnClickListener(new gf(this));
        }
        if (this.aM != null) {
            this.aM.setOnClickListener(new gg(this));
        }
        if (this.dC != null) {
            this.dC.setOnClickListener(new gh(this));
        }
        if (this.dD != null) {
            this.dD.setOnClickListener(new gi(this));
        }
        if (this.dE != null) {
            this.dE.setOnClickListener(new gk(this));
        }
    }

    public static Bitmap b(Bitmap bitmap) {
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            Paint paint = new Paint();
            Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            RectF rectF = new RectF(new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()));
            paint.setAntiAlias(true);
            paint.setFilterBitmap(true);
            canvas.drawARGB(0, 0, 0, 0);
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            paint.setColor(ViewCompat.MEASURED_STATE_MASK);
            canvas.drawRoundRect(rectF, 35.0f, 35.0f, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), rect, paint);
            return bitmapCreateBitmap;
        } catch (Exception e2) {
            return bitmap;
        }
    }

    public static String b(int i2) {
        if (i2 <= 0) {
            return "0";
        }
        int i3 = (i2 / 60) / 60;
        int i4 = i2 % 60;
        return String.format("%2d", Integer.valueOf(i2 / 60));
    }

    private void b(Intent intent, long j2, long j3, int i2, int i3) {
        boolean zA;
        int[] iArr = this.bu;
        int[] iArr2 = this.bs.r;
        CellLayout cellLayoutA = a(j2, j3);
        mp mpVarA = u.a(this, intent, (Bitmap) null);
        if (mpVarA == null) {
            return;
        }
        View viewA = a(mpVarA);
        if (i2 >= 0 && i3 >= 0) {
            iArr[0] = i2;
            iArr[1] = i3;
            if (as.a(viewA, j2, cellLayoutA, iArr, 0.0f, true, (ca) null, (Runnable) null)) {
                return;
            }
            cg cgVar = new cg();
            cgVar.g = mpVarA;
            if (as.a(viewA, cellLayoutA, iArr, 0.0f, cgVar, true)) {
                return;
            } else {
                zA = true;
            }
        } else if (iArr2 != null) {
            zA = cellLayoutA.b(iArr2[0], iArr2[1], 1, 1, iArr) != null;
        } else {
            zA = cellLayoutA.a(iArr, 1, 1);
        }
        if (!zA) {
            a(b(cellLayoutA));
            return;
        }
        iv.a((Context) this, (ec) mpVarA, j2, j3, iArr[0], iArr[1], false);
        if (this.bJ) {
            return;
        }
        as.a(viewA, j2, j3, iArr[0], iArr[1], 1, 1, u());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(View view, float f2) {
        if (view instanceof ks) {
            ((ks) view).a(this, f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(View view, boolean z, boolean z2) {
        if (view instanceof ks) {
            ((ks) view).b(this, z, z2);
        }
        b(view, 0.0f);
    }

    private void b(FolderIcon folderIcon) {
        dg folderInfo = folderIcon.getFolderInfo();
        Folder folderA = as.a(folderInfo);
        if (folderInfo.f177a && folderA == null) {
            Log.d("Launcher", "Folder info marked as open, but associated folder is not open. Screen: " + folderInfo.i + " (" + folderInfo.j + ", " + folderInfo.k + ")");
            folderInfo.f177a = false;
        }
        if (!folderInfo.f177a && !folderIcon.getFolder().n()) {
            C();
            a(folderIcon);
        } else if (folderA != null) {
            int iF = as.f(folderA);
            a(folderA);
            if (iF != as.getCurrentPage()) {
                C();
                a(folderIcon);
            }
        }
    }

    private void b(String str, boolean z, Bundle bundle, Rect rect) {
        ComponentName globalSearchActivity = ((SearchManager) getSystemService("search")).getGlobalSearchActivity();
        if (globalSearchActivity == null) {
            Log.w("Launcher", "No global search activity found.");
            return;
        }
        Intent intent = new Intent("android.search.action.GLOBAL_SEARCH");
        intent.addFlags(268435456);
        intent.setComponent(globalSearchActivity);
        Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        if (!bundle2.containsKey("source")) {
            bundle2.putString("source", getPackageName());
        }
        intent.putExtra("app_data", bundle2);
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("query", str);
        }
        if (z) {
            intent.putExtra("select_query", z);
        }
        intent.setSourceBounds(rect);
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e2) {
            Log.e("Launcher", "Global search activity not found: " + globalSearchActivity);
        }
    }

    private boolean b(Runnable runnable) {
        return a(runnable, false);
    }

    static int[] b(Context context, AppWidgetProviderInfo appWidgetProviderInfo) {
        return a(context, appWidgetProviderInfo.provider, appWidgetProviderInfo.minResizeWidth, appWidgetProviderInfo.minResizeHeight);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j2) {
        this.ee.removeMessages(1);
        this.ee.sendMessageDelayed(this.ee.obtainMessage(1), j2);
        this.cb = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, ie ieVar) throws Throwable {
        DataInputStream dataInputStream;
        DataInputStream dataInputStream2 = null;
        try {
            dataInputStream = new DataInputStream(context.openFileInput("launcher.preferences"));
            try {
                ieVar.f302a = dataInputStream.readUTF();
                ieVar.b = dataInputStream.readInt();
                ieVar.c = dataInputStream.readInt();
                if (dataInputStream != null) {
                    try {
                        dataInputStream.close();
                    } catch (IOException e2) {
                    }
                }
            } catch (FileNotFoundException e3) {
                if (dataInputStream != null) {
                    try {
                        dataInputStream.close();
                    } catch (IOException e4) {
                    }
                }
            } catch (IOException e5) {
                if (dataInputStream != null) {
                    try {
                        dataInputStream.close();
                    } catch (IOException e6) {
                    }
                }
            } catch (Throwable th) {
                dataInputStream2 = dataInputStream;
                th = th;
                if (dataInputStream2 != null) {
                    try {
                        dataInputStream2.close();
                    } catch (IOException e7) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e8) {
            dataInputStream = null;
        } catch (IOException e9) {
            dataInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void c(View view, boolean z, boolean z2) {
        if (view instanceof ks) {
            ((ks) view).c(this, z, z2);
        }
        b(view, 1.0f);
    }

    private void c(FolderIcon folderIcon) {
        int measuredWidth = folderIcon.getMeasuredWidth();
        int measuredHeight = folderIcon.getMeasuredHeight();
        if (this.f87cn == null) {
            this.f87cn = new ImageView(this);
        }
        if (this.co == null || this.co.getWidth() != measuredWidth || this.co.getHeight() != measuredHeight) {
            this.co = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
            this.cp = new Canvas(this.co);
        }
        bw bwVar = this.f87cn.getLayoutParams() instanceof bw ? (bw) this.f87cn.getLayoutParams() : new bw(measuredWidth, measuredHeight);
        float fA = this.au.a(folderIcon, this.cq);
        bwVar.c = true;
        bwVar.f145a = this.cq.left;
        bwVar.b = this.cq.top;
        bwVar.width = (int) (measuredWidth * fA);
        bwVar.height = (int) (measuredHeight * fA);
        this.cp.drawColor(0, PorterDuff.Mode.CLEAR);
        folderIcon.draw(this.cp);
        this.f87cn.setImageBitmap(this.co);
        if (folderIcon.getFolder() != null) {
            this.f87cn.setPivotX(folderIcon.getFolder().getPivotXForIconAnimation());
            this.f87cn.setPivotY(folderIcon.getFolder().getPivotYForIconAnimation());
        }
        if (this.au.indexOfChild(this.f87cn) != -1) {
            this.au.removeView(this.f87cn);
        }
        this.au.addView(this.f87cn, bwVar);
        if (folderIcon.getFolder() != null) {
            folderIcon.getFolder().bringToFront();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:37:0x0045 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.io.DataOutputStream] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.io.DataOutputStream] */
    /* JADX WARN: Type inference failed for: r0v14, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.io.DataOutputStream] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.DataOutputStream] */
    /* JADX WARN: Type inference failed for: r1v4 */
    public static void d(Context context, ie ieVar) throws Throwable {
        ?? e2;
        ?? r1 = 0;
        try {
            try {
                e2 = new DataOutputStream(context.openFileOutput("launcher.preferences", 0));
                try {
                    e2.writeUTF(ieVar.f302a);
                    e2.writeInt(ieVar.b);
                    e2.writeInt(ieVar.c);
                    e2.flush();
                    if (e2 != 0) {
                        try {
                            e2.close();
                        } catch (IOException e3) {
                            e2 = e3;
                        }
                    }
                } catch (FileNotFoundException e4) {
                    if (e2 != 0) {
                        try {
                            e2.close();
                        } catch (IOException e5) {
                        }
                    }
                } catch (IOException e6) {
                    context.getFileStreamPath("launcher.preferences").delete();
                    if (e2 != 0) {
                        try {
                            e2.close();
                        } catch (IOException e7) {
                            e2 = e7;
                        }
                    }
                }
            } catch (FileNotFoundException e8) {
                e2 = 0;
            } catch (IOException e9) {
                e2 = 0;
            } catch (Throwable th) {
                th = th;
                if (r1 != 0) {
                    try {
                        r1.close();
                    } catch (IOException e10) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            r1 = e2;
            th = th2;
            if (r1 != 0) {
                r1.close();
            }
            throw th;
        }
    }

    private void d(FolderIcon folderIcon) {
        if (folderIcon == null) {
            return;
        }
        PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat("alpha", 0.0f);
        PropertyValuesHolder propertyValuesHolderOfFloat2 = PropertyValuesHolder.ofFloat("scaleX", 1.5f);
        PropertyValuesHolder propertyValuesHolderOfFloat3 = PropertyValuesHolder.ofFloat("scaleY", 1.5f);
        if (((dg) folderIcon.getTag()).h == -101) {
            CellLayout cellLayout = (CellLayout) folderIcon.getParent().getParent();
            al alVar = (al) folderIcon.getLayoutParams();
            cellLayout.c(alVar.f109a, alVar.b);
        }
        c(folderIcon);
        folderIcon.setVisibility(4);
        ObjectAnimator objectAnimatorA = ik.a(this.f87cn, propertyValuesHolderOfFloat, propertyValuesHolderOfFloat2, propertyValuesHolderOfFloat3);
        objectAnimatorA.setDuration(getResources().getInteger(R.integer.config_folderAnimDuration));
        objectAnimatorA.start();
    }

    private static boolean d(String str) {
        return Log.isLoggable(str, 2);
    }

    private void e(FolderIcon folderIcon) {
        if (folderIcon == null) {
            return;
        }
        PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat("alpha", 1.0f);
        PropertyValuesHolder propertyValuesHolderOfFloat2 = PropertyValuesHolder.ofFloat("scaleX", 1.0f);
        PropertyValuesHolder propertyValuesHolderOfFloat3 = PropertyValuesHolder.ofFloat("scaleY", 1.0f);
        CellLayout cellLayout = (CellLayout) folderIcon.getParent().getParent();
        this.au.removeView(this.f87cn);
        c(folderIcon);
        ObjectAnimator objectAnimatorA = ik.a(this.f87cn, propertyValuesHolderOfFloat, propertyValuesHolderOfFloat2, propertyValuesHolderOfFloat3);
        objectAnimatorA.setDuration(getResources().getInteger(R.integer.config_folderAnimDuration));
        objectAnimatorA.addListener(new gv(this, cellLayout, folderIcon));
        objectAnimatorA.start();
    }

    private void e(String str) {
        ActivityManager activityManager = (ActivityManager) getSystemService("activity");
        for (ActivityManager.RunningTaskInfo runningTaskInfo : activityManager.getRunningTasks(32)) {
            Log.i("test", "RunningTaskInfo " + runningTaskInfo.baseActivity);
            if (runningTaskInfo.baseActivity.getPackageName().startsWith(str)) {
                Log.i("hy", "amTask.id" + runningTaskInfo.id);
                activityManager.removeTask(runningTaskInfo.id);
            }
        }
    }

    private static ii f(int i2) {
        ii iiVar = ii.WORKSPACE;
        ii[] iiVarArrValues = ii.valuesCustom();
        for (int i3 = 0; i3 < iiVarArrValues.length; i3++) {
            if (iiVarArrValues[i3].ordinal() == i2) {
                return iiVarArrValues[i3];
            }
        }
        return iiVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String g(int i2) {
        return new BigDecimal(i2 / 1.0f).setScale(0, 4).toString();
    }

    private int h(int i2) {
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        switch (defaultDisplay.getRotation()) {
            case 0:
            case 2:
                break;
            case 1:
            case 3:
                i2 = i2 == 2 ? 1 : 2;
                break;
            default:
                i2 = 2;
                break;
        }
        return new int[]{1, 0, 9, 8}[((i2 != 2 ? 0 : 1) + defaultDisplay.getRotation()) % 4];
    }

    private void i(int i2) {
        View viewFindViewById = findViewById(i2);
        if (viewFindViewById != null) {
            ViewGroup viewGroup = (ViewGroup) viewFindViewById.getParent();
            viewGroup.post(new hw(this, viewGroup, viewFindViewById));
            this.cs.a(this.au);
        }
    }

    private void n(boolean z) {
    }

    public static iv r() {
        return u;
    }

    protected void A() {
    }

    public void B() {
        Intent intent = new Intent("com.syu.cancle_tts");
        intent.setPackage("com.syu.voice");
        startService(intent);
    }

    public void C() {
        Folder openFolder = as.getOpenFolder();
        if (openFolder != null) {
            if (openFolder.b()) {
                openFolder.f();
            }
            a(openFolder);
            dismissFolderCling(null);
        }
    }

    View D() {
        return this.r;
    }

    View E() {
        return this.bw;
    }

    SearchDropTargetBar H() {
        return this.by;
    }

    Workspace I() {
        return as;
    }

    public boolean J() {
        return this.ah == ii.APPS_CUSTOMIZE || this.bE == ii.APPS_CUSTOMIZE;
    }

    void K() {
        if (J()) {
            a(pb.SPRING_LOADED, false, true, (Runnable) null);
            this.ah = ii.APPS_CUSTOMIZE_SPRING_LOADED;
            g(true);
        }
    }

    void L() {
        if (this.ah == ii.APPS_CUSTOMIZE_SPRING_LOADED) {
            a(false, true);
            this.ah = ii.APPS_CUSTOMIZE;
        }
    }

    void M() {
    }

    public View N() {
        if (this.bC == null) {
            this.bC = this.ar.inflate(R.layout.search_bar, (ViewGroup) this.by, false);
            if (this.by != null) {
                this.by.addView(this.bC);
            }
        }
        return this.bC;
    }

    protected boolean O() {
        View viewFindViewById = findViewById(R.id.search_button_container);
        ImageView imageView = (ImageView) findViewById(R.id.search_button);
        View viewFindViewById2 = findViewById(R.id.voice_button_container);
        View viewFindViewById3 = findViewById(R.id.voice_button);
        ((SearchManager) getSystemService("search")).getGlobalSearchActivity();
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(8);
        }
        if (viewFindViewById2 != null) {
            viewFindViewById2.setVisibility(8);
        }
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        if (viewFindViewById3 != null) {
            viewFindViewById3.setVisibility(8);
        }
        j(false);
        return false;
    }

    @Override // com.android.launcher6.jn
    public boolean P() {
        if (!this.bI) {
            return false;
        }
        Log.i("Launcher", "setLoadOnResume");
        this.bL = true;
        return true;
    }

    @Override // com.android.launcher6.jn
    public int Q() {
        if (as != null) {
            return as.getCurrentPage();
        }
        return 2;
    }

    @Override // com.android.launcher6.jn
    public void R() {
        this.bM.clear();
        as.ay();
        as.O();
        this.cd.clear();
    }

    @Override // com.android.launcher6.jn
    public void S() {
        boolean zO = O();
        boolean zI = i(zO);
        if (this.by != null) {
            this.by.a(zO, zI);
        }
    }

    public boolean T() {
        return B || getResources().getBoolean(R.bool.allow_rotation);
    }

    public void U() {
        if (T()) {
            setRequestedOrientation(h(getResources().getConfiguration().orientation));
        }
    }

    public void V() {
        Cling cling = (Cling) findViewById(R.id.first_run_cling);
        String strY = Y();
        if (as.af()) {
            if (cling != null) {
                a(cling, strY, true, true);
            }
        } else if (cling != null) {
            a(cling, strY, false, true);
        }
    }

    public void W() {
        if (!aK() || this.ck.getBoolean("cling_gel.first_run.dismissed", false) || aL()) {
            i(R.id.first_run_cling);
            return;
        }
        if (LauncherApplication.f88a.getResources().getBoolean(R.bool.isdefaultwallpaper)) {
            ag();
        }
        Cling cling = (Cling) findViewById(R.id.first_run_cling);
        if (cling != null) {
            String strX = X();
            String strY = Y();
            if (!strX.isEmpty()) {
                TextView textView = (TextView) cling.findViewById(R.id.search_bar_hint);
                textView.setText(strX);
                textView.setVisibility(0);
            }
            a(cling, strY, true, false);
        }
        a(R.id.first_run_cling, 0, false, true);
    }

    protected String X() {
        return "";
    }

    protected String Y() {
        return "";
    }

    protected int Z() {
        return -1;
    }

    View a(int i2, ViewGroup viewGroup, mp mpVar) {
        BubbleTextView bubbleTextView = (BubbleTextView) this.ar.inflate(i2, viewGroup, false);
        bubbleTextView.a(mpVar, this.bQ);
        bubbleTextView.setOnClickListener(this);
        return bubbleTextView;
    }

    View a(mp mpVar) {
        return a(R.layout.application, (ViewGroup) as.getChildAt(as.getCurrentPage()), mpVar);
    }

    CellLayout a(long j2, long j3) {
        if (j2 != -101) {
            return as.c(j3);
        }
        if (this.r != null) {
        }
        return null;
    }

    FolderIcon a(CellLayout cellLayout, long j2, long j3, int i2, int i3) {
        dg dgVar = new dg();
        dgVar.q = getText(R.string.folder_name);
        iv.a((Context) this, (ec) dgVar, j2, j3, i2, i3, false);
        bW.put(Long.valueOf(dgVar.f), dgVar);
        FolderIcon folderIconA = FolderIcon.a(R.layout.folder_icon, this, cellLayout, dgVar, this.bQ);
        as.a(folderIconA, j2, j3, i2, i3, 1, 1, u());
        as.b((View) folderIconA).getShortcutsAndWidgets().a(folderIconA);
        return folderIconA;
    }

    public String a(long j2) {
        long j3 = j2 / 60000;
        long jRound = Math.round((j2 % 60000) / 1000.0f);
        String str = String.valueOf(j3 < 10 ? String.valueOf("") + "0" : "") + j3 + ":";
        if (jRound < 10) {
            str = String.valueOf(str) + "0";
        }
        return String.valueOf(str) + jRound;
    }

    public void a() {
        if (this.dc != null) {
            this.dc.setText(R.string.car_settings);
        }
        if (this.dd != null) {
            this.dd.setText(R.string.car_car);
        }
        if (this.db != null) {
            this.db.setText(R.string.car_navi);
        }
        if (this.de != null) {
            this.de.setText(R.string.car_music);
        }
        if (this.df != null) {
            this.df.setText(R.string.car_radio);
        }
        if (this.dn != null) {
            this.dn.setText(R.string.car_miu_drive);
        }
        if (this.dr != null) {
            this.dr.setText(R.string.car_aux);
        }
        if (this.dg != null) {
            this.dg.setText(R.string.car_bt);
        }
        if (this.dj != null) {
            this.dj.setText(R.string.car_video);
        }
        if (this.f1do != null) {
            this.f1do.setText(R.string.car_file);
        }
        if (this.dp != null) {
            this.dp.setText(R.string.car_gallery);
        }
        if (this.dq != null) {
            this.dq.setText(R.string.car_dvr);
        }
        if (this.dk != null) {
            this.dk.setText(R.string.car_app);
        }
        if (this.dl != null) {
            this.dl.setText(R.string.car_kuwo);
        }
        if (this.dm != null) {
            this.dm.setText(R.string.music_author);
        }
        if (this.dh != null) {
            this.dh.setText(R.string.car_bt_notconnect);
        }
        if (this.di != null) {
            this.di.setText(R.string.car_canbus);
        }
        if (this.dt != null) {
            this.dt.setText(com.syu.g.l.b("car_guide"));
        }
        if (this.du != null) {
            this.du.setText(com.syu.g.l.b("car_calculator"));
        }
        if (this.dv != null) {
            this.dv.setText(R.string.car_eq);
        }
    }

    void a(int i2, ec ecVar, AppWidgetHostView appWidgetHostView, AppWidgetProviderInfo appWidgetProviderInfo) {
        if (appWidgetProviderInfo.configure == null) {
            Log.e("LauncherModel", "appwdigetId:====" + i2);
            a(i2, ecVar.h, ecVar.i, appWidgetHostView, appWidgetProviderInfo);
            a(true, false, (Runnable) null);
        } else {
            this.bt = appWidgetProviderInfo;
            Log.e("LauncherModel", "appWidgetInfo:====" + appWidgetProviderInfo);
            Intent intent = new Intent("android.appwidget.action.APPWIDGET_CONFIGURE");
            intent.setComponent(appWidgetProviderInfo.configure);
            intent.putExtra("appWidgetId", i2);
            my.a(this, intent, 5);
        }
    }

    void a(ComponentName componentName, long j2, long j3, int[] iArr, int[] iArr2) {
        aD();
        this.bs.h = j2;
        this.bs.i = j3;
        this.bs.r = iArr2;
        if (iArr != null) {
            this.bs.j = iArr[0];
            this.bs.k = iArr[1];
        }
        Intent intent = new Intent("android.intent.action.CREATE_SHORTCUT");
        intent.setComponent(componentName);
        a(intent);
    }

    void a(Intent intent) {
        String string = getResources().getString(R.string.group_applications);
        String stringExtra = intent.getStringExtra("android.intent.extra.shortcut.NAME");
        if (string == null || !string.equals(stringExtra)) {
            my.a(this, intent, 1);
            return;
        }
        Intent intent2 = new Intent("android.intent.action.MAIN", (Uri) null);
        intent2.addCategory("android.intent.category.LAUNCHER");
        Intent intent3 = new Intent("android.intent.action.PICK_ACTIVITY");
        intent3.putExtra("android.intent.extra.INTENT", intent2);
        intent3.putExtra("android.intent.extra.TITLE", getText(R.string.title_select_application));
        my.a(this, intent3, 6);
    }

    void a(Intent intent, long j2, long j3, int i2, int i3) {
        int[] iArr = this.bu;
        CellLayout cellLayoutA = a(j2, j3);
        if (i2 >= 0 && i3 >= 0) {
            iArr[0] = i2;
            iArr[1] = i3;
        } else if (!cellLayoutA.a(iArr, 1, 1)) {
            a(b(cellLayoutA));
            return;
        }
        mp mpVarA = u.a(getPackageManager(), intent, this);
        if (mpVarA == null) {
            Log.e("Launcher", "Couldn't find ActivityInfo for selected application: " + intent);
            return;
        }
        mpVarA.a(this, intent.getComponent(), 270532608);
        mpVarA.h = -1L;
        as.a(mpVarA, cellLayoutA, j2, j3, iArr[0], iArr[1], u(), i2, i3);
    }

    protected void a(Drawable.ConstantState constantState) {
        View viewFindViewById = findViewById(R.id.search_button_container);
        ImageView imageView = (ImageView) findViewById(R.id.search_button);
        a(R.id.search_button, constantState);
        a(viewFindViewById, imageView);
    }

    void a(View view) {
        if (this.cd.containsKey(view)) {
            this.cd.remove(view);
            aC();
        }
    }

    void a(View view, AppWidgetProviderInfo appWidgetProviderInfo) {
        if (appWidgetProviderInfo == null || appWidgetProviderInfo.autoAdvanceViewId == -1) {
            return;
        }
        KeyEvent.Callback callbackFindViewById = view.findViewById(appWidgetProviderInfo.autoAdvanceViewId);
        if (callbackFindViewById instanceof Advanceable) {
            this.cd.put(view, appWidgetProviderInfo);
            ((Advanceable) callbackFindViewById).fyiWillBeAdvancedByHostKThx();
            aC();
        }
    }

    void a(Folder folder) {
        folder.getInfo().f177a = false;
        if (((ViewGroup) folder.getParent().getParent()) != null) {
            e((FolderIcon) as.b(folder.c));
        }
        folder.h();
        f().sendAccessibilityEvent(32);
    }

    public void a(FolderIcon folderIcon) {
        Folder folder = folderIcon.getFolder();
        folder.c.f177a = true;
        if (folder.getParent() == null) {
            this.au.addView(folder);
            this.av.a((ce) folder);
        } else {
            Log.w("Launcher", "Opening folder (" + folder + ") which already has a parent (" + folder.getParent() + ").");
        }
        folder.g();
        d(folderIcon);
        folder.sendAccessibilityEvent(32);
        f().sendAccessibilityEvent(2048);
    }

    void a(dg dgVar) {
        bW.remove(Long.valueOf(dgVar.f));
    }

    public void a(it itVar) {
        a(itVar.e);
        itVar.e = null;
    }

    void a(mf mfVar, long j2, long j3, int[] iArr, int[] iArr2, int[] iArr3) {
        aD();
        ec ecVar = this.bs;
        mfVar.h = j2;
        ecVar.h = j2;
        ec ecVar2 = this.bs;
        mfVar.i = j3;
        ecVar2.i = j3;
        this.bs.r = iArr3;
        this.bs.n = mfVar.n;
        this.bs.o = mfVar.o;
        if (iArr != null) {
            this.bs.j = iArr[0];
            this.bs.k = iArr[1];
        }
        if (iArr2 != null) {
            this.bs.l = iArr2[0];
            this.bs.m = iArr2[1];
        }
        AppWidgetHostView appWidgetHostView = mfVar.v;
        if (appWidgetHostView != null) {
            a(appWidgetHostView.getAppWidgetId(), mfVar, appWidgetHostView, mfVar.u);
            return;
        }
        int iAllocateAppWidgetId = q().allocateAppWidgetId();
        Bundle bundle = mfVar.w;
        if (bundle != null ? this.bq.bindAppWidgetIdIfAllowed(iAllocateAppWidgetId, mfVar.f390a, bundle) : this.bq.bindAppWidgetIdIfAllowed(iAllocateAppWidgetId, mfVar.f390a)) {
            a(iAllocateAppWidgetId, mfVar, (AppWidgetHostView) null, mfVar.u);
            return;
        }
        this.bt = mfVar.u;
        Intent intent = new Intent("android.appwidget.action.APPWIDGET_BIND");
        intent.putExtra("appWidgetId", iAllocateAppWidgetId);
        intent.putExtra("appWidgetProvider", mfVar.f390a);
        startActivityForResult(intent, 11);
    }

    public void a(Runnable runnable) {
        this.bN.add(runnable);
    }

    public void a(String str, boolean z, Bundle bundle, Rect rect) {
        b(str, z, bundle, rect);
    }

    @Override // com.android.launcher6.jn
    public void a(ArrayList arrayList) {
        b(arrayList);
        if (arrayList.size() == 0 && LauncherApplication.f88a.getResources().getBoolean(R.bool.apps_add_extarscreen)) {
            as.T();
        }
        if (LauncherApplication.f88a.getResources().getBoolean(R.bool.apps_custom_page) && !as.ag()) {
            as.P();
            av();
            az();
        }
        if (as.af() || !c()) {
            return;
        }
        as.Q();
    }

    @Override // com.android.launcher6.jn
    public void a(ArrayList arrayList, int i2, int i3, boolean z) {
        long j2;
        CellLayout cellLayoutC;
        hg hgVar = new hg(this, arrayList, i2, i3, z);
        com.syu.g.i.a().a("Launcher bindItems");
        if (b(hgVar)) {
            return;
        }
        AnimatorSet animatorSetB = ik.b();
        ArrayList arrayList2 = new ArrayList();
        boolean z2 = z && aJ();
        Workspace workspace = as;
        long j3 = -1;
        while (i2 < i3) {
            ec ecVar = (ec) arrayList.get(i2);
            if (ecVar.h == -101 && !getResources().getBoolean(R.bool.hotseat_load_defualt_workspace)) {
                j2 = j3;
            } else if (ecVar.h == -101 && this.r == null) {
                j2 = j3;
            } else {
                switch (ecVar.g) {
                    case 0:
                    case 1:
                        View viewA = a((mp) ecVar);
                        if (ecVar.h == -100 && (cellLayoutC = as.c(ecVar.i)) != null && cellLayoutC.g(ecVar.j, ecVar.k)) {
                            throw new RuntimeException("OCCUPIED");
                        }
                        workspace.b(viewA, ecVar.h, ecVar.i, ecVar.j, ecVar.k, 1, 1);
                        if (!z2) {
                            j2 = j3;
                        } else {
                            viewA.setAlpha(0.0f);
                            viewA.setScaleX(0.0f);
                            viewA.setScaleY(0.0f);
                            arrayList2.add(a(viewA, i2));
                            j2 = ecVar.i;
                        }
                        break;
                    case 2:
                        workspace.b(FolderIcon.a(R.layout.folder_icon, this, (ViewGroup) workspace.getChildAt(workspace.getCurrentPage()), (dg) ecVar, this.bQ), ecVar.h, ecVar.i, ecVar.j, ecVar.k, 1, 1);
                        j2 = j3;
                        break;
                    default:
                        throw new RuntimeException("Invalid Item Type");
                }
            }
            i2++;
            j3 = j2;
        }
        if (z2 && j3 > -1) {
            long jA = as.a(as.getNextPage());
            int iD = as.d(j3);
            hh hhVar = new hh(this, animatorSetB, arrayList2);
            if (j3 != jA) {
                as.postDelayed(new hj(this, iD, hhVar), al);
            } else {
                as.postDelayed(hhVar, an);
            }
        }
        workspace.requestLayout();
    }

    @Override // com.android.launcher6.jn
    public void a(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
        if (b(new hf(this, arrayList, arrayList2, arrayList3, arrayList4))) {
            return;
        }
        b(arrayList);
        if (!arrayList2.isEmpty()) {
            a(arrayList2, 0, arrayList2.size(), false);
        }
        if (!arrayList3.isEmpty()) {
            a(arrayList3, 0, arrayList3.size(), true);
        }
        as.U();
        if (AppsCustomizePagedView.b || arrayList4 == null || this.bA == null) {
            return;
        }
        this.bA.b(arrayList4);
    }

    @Override // com.android.launcher6.jn
    public void a(ArrayList arrayList, ArrayList arrayList2, boolean z) {
        if (b(new hp(this, arrayList, arrayList2, z))) {
            return;
        }
        if (z) {
            as.a(arrayList);
        } else {
            as.b(arrayList2);
        }
        this.av.a(arrayList2, this);
        if (AppsCustomizePagedView.b || this.bA == null) {
            return;
        }
        this.bA.c(arrayList2);
    }

    @Override // com.android.launcher6.jn
    public void a(HashMap map) {
        if (b(new hk(this, map))) {
            return;
        }
        bW.clear();
        bW.putAll(map);
    }

    void a(boolean z) {
        Toast.makeText(this, getString(z ? R.string.hotseat_out_of_space : R.string.out_of_space), 0).show();
    }

    void a(boolean z, q qVar, boolean z2) {
        if (this.ah != ii.WORKSPACE) {
            return;
        }
        com.syu.g.n.b(null);
        if (z2) {
            this.bz.a();
        }
        h(true);
        if (!LauncherApplication.f88a.getResources().getBoolean(R.bool.apps_hotseat_hide)) {
            this.s.setBackgroundResource(a.b.a().aO);
        }
        a(false, false, qVar);
        this.bz.requestFocus();
        this.ah = ii.APPS_CUSTOMIZE;
        this.bR = false;
        aC();
        C();
        getWindow().getDecorView().sendAccessibilityEvent(32);
    }

    void a(boolean z, Runnable runnable) {
        boolean z2 = false;
        com.syu.g.n.a((View) null);
        if (as.ao()) {
            as.b(z);
        }
        g(z);
        if (!LauncherApplication.f88a.getResources().getBoolean(R.bool.apps_hotseat_hide)) {
            this.s.setBackgroundResource(a.b.a().aN);
        }
        if (this.ah != ii.WORKSPACE) {
            boolean z3 = this.ah != ii.WORKSPACE;
            as.setVisibility(0);
            a(pb.NORMAL, false, false, runnable);
            if (this.by != null) {
                SearchDropTargetBar searchDropTargetBar = this.by;
                if (z && z3) {
                    z2 = true;
                }
                searchDropTargetBar.a(z2);
            }
            if (this.s != null) {
                this.s.requestFocus();
            }
        }
        this.ah = ii.WORKSPACE;
        this.bR = true;
        aC();
        getWindow().getDecorView().sendAccessibilityEvent(32);
        f(z);
    }

    void a(boolean z, boolean z2, Runnable runnable) {
        if (this.ah != ii.APPS_CUSTOMIZE_SPRING_LOADED) {
            return;
        }
        this.ee.postDelayed(new he(this, z, runnable), z2 ? 600 : HttpStatus.SC_MULTIPLE_CHOICES);
    }

    boolean a(ComponentName componentName, int i2) {
        if ((i2 & 1) == 0) {
            Toast.makeText(this, R.string.uninstall_system_app_text, 0).show();
            return false;
        }
        Intent intent = new Intent("android.intent.action.DELETE", Uri.fromParts("package", componentName.getPackageName(), componentName.getClassName()));
        intent.setFlags(276824064);
        startActivity(intent);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002b  */
    boolean a(View view, Intent intent, Object obj) {
        boolean z;
        intent.addFlags(268435456);
        if (view != null) {
            try {
                if (intent.hasExtra("com.android.launcher6.intent.extra.shortcut.INGORE_LAUNCH_ANIMATION")) {
                    z = false;
                } else {
                    z = true;
                }
            } catch (SecurityException e2) {
                Toast.makeText(this, R.string.activity_not_found, 0).show();
                Log.e("Launcher", "Launcher does not have the permission to launch " + intent + ". Make sure to create a MAIN intent-filter for the corresponding activity or use the exported attribute for this activity. tag=" + obj + " intent=" + intent, e2);
                return false;
            }
        } else {
            z = false;
        }
        if (z) {
            startActivity(intent, ActivityOptions.makeScaleUpAnimation(view, 0, 0, view.getMeasuredWidth(), view.getMeasuredHeight()).toBundle());
        } else {
            startActivity(intent);
        }
        return true;
    }

    public byte[] a(String str) {
        byte[] bArr = new byte[32];
        for (int i2 = 0; i2 < str.length(); i2++) {
            bArr[i2] = (byte) str.charAt(i2);
        }
        String str2 = "";
        for (int i3 = 0; i3 < f86a.length(); i3++) {
            str2 = String.valueOf(str2) + "*" + ((int) bArr[i3]);
        }
        return bArr;
    }

    protected ComponentName aa() {
        return null;
    }

    protected int ab() {
        return -1;
    }

    protected String ac() {
        return "";
    }

    protected String ad() {
        return "";
    }

    public void ae() {
        if (a.b.a().ec <= 0) {
            return;
        }
        a(a.b.a().ec, 0, false, true).a(Z(), ab(), aa(), ac(), ad());
    }

    public void af() {
        if (!aK() || this.ck.getBoolean("cling_gel.workspace.dismissed", false)) {
            i(R.id.workspace_cling);
        } else {
            a(R.id.workspace_cling, 0, false, true).a(Z(), ab(), aa(), ac(), ad());
        }
    }

    public void ag() {
        WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
        LauncherApplication.l = true;
        SharedPreferences.Editor editorEdit = com.syu.g.l.c().edit();
        editorEdit.putBoolean("mAppWallPaper", LauncherApplication.l);
        editorEdit.commit();
        try {
            if (a.b.a().aE != 0) {
                wallpaperManager.setResource(a.b.a().aE);
            } else if (a.b.a().aF != 0) {
                wallpaperManager.setResource(a.b.a().aF);
            } else if (a.b.a().aG != 0) {
                wallpaperManager.setResource(a.b.a().aG);
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public Cling ah() {
        if (aK() && !this.ck.getBoolean("cling_gel.folder.dismissed", false)) {
            return a(R.id.folder_cling, R.id.cling_scrim, true, true);
        }
        i(R.id.folder_cling);
        return null;
    }

    public boolean ai() {
        Cling cling = (Cling) findViewById(R.id.folder_cling);
        return cling != null && cling.getVisibility() == 0;
    }

    public void aj() {
        Log.d("Launcher", "BEGIN launcher3 dump state for launcher " + this);
        Log.d("Launcher", "mSavedState=" + this.bD);
        Log.d("Launcher", "mWorkspaceLoading=" + this.bG);
        Log.d("Launcher", "mRestoring=" + this.bJ);
        Log.d("Launcher", "mWaitingForResult=" + this.bK);
        Log.d("Launcher", "mSavedInstanceState=" + this.bP);
        Log.d("Launcher", "sFolders.size=" + bW.size());
        u.j();
        if (this.bA != null) {
            this.bA.i();
        }
        Log.d("Launcher", "END launcher3 dump state");
    }

    @Override // com.android.launcher6.jn
    public void ak() {
    }

    public String b(long j2) {
        return String.format("%02d:%02d:%02d", Long.valueOf(j2 / 3600), Long.valueOf((j2 / 60) % 60), Long.valueOf(j2 % 60));
    }

    public void b() {
        Log.i("hy", "showWeatherInfo" + this.p);
        com.syu.d.a.b("showWeatherInfo");
        if (this.p == null) {
            com.syu.d.a.b("manager == null");
        } else {
            this.p.a(new eq(this));
        }
    }

    protected void b(Drawable.ConstantState constantState) {
        View viewFindViewById = findViewById(R.id.voice_button_container);
        View viewFindViewById2 = findViewById(R.id.voice_button);
        a(R.id.voice_button, constantState);
        a(viewFindViewById, viewFindViewById2);
    }

    @Override // com.android.launcher6.jn
    public void b(it itVar) {
        if (b(new hl(this, itVar))) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        Log.d("Launcher", "bindAppWidget: " + itVar);
        Workspace workspace = as;
        int i2 = itVar.f314a;
        AppWidgetProviderInfo appWidgetInfo = this.bq.getAppWidgetInfo(i2);
        Log.d("Launcher", "bindAppWidget: id=" + itVar.f314a + " belongs to component " + appWidgetInfo.provider);
        itVar.e = this.br.createView(this, i2, appWidgetInfo);
        itVar.e.setTag(itVar);
        itVar.a(this);
        workspace.a((View) itVar.e, itVar.h, itVar.i, itVar.j, itVar.k, itVar.l, itVar.m, false);
        a(itVar.e, appWidgetInfo);
        workspace.requestLayout();
        Log.d("Launcher", "bound widget id=" + itVar.f314a + " in " + (SystemClock.uptimeMillis() - jUptimeMillis) + "ms");
    }

    protected void b(String str) {
        String str2 = "软件激活";
        String str3 = "激活";
        if (f == -1) {
            str2 = "警告";
            str3 = "确定";
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(str);
        builder.setTitle(str2);
        builder.setCancelable(false);
        builder.setPositiveButton(str3, new et(this));
        builder.create().show();
    }

    public void b(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            as.a(((Long) arrayList.get(i2)).longValue());
        }
    }

    public void b(boolean z) {
        if (i == null || j == null || k == null) {
            i = findViewById(a.b.a().aU);
            j = findViewById(a.b.a().aW);
            k = findViewById(a.b.a().aV);
        }
        if (!z) {
            if (i != null) {
                i.setVisibility(8);
            }
            j.setVisibility(8);
            k.setVisibility(8);
            return;
        }
        if (i != null && LauncherApplication.f88a.getResources().getBoolean(R.bool.iswidgetpages)) {
            i.setVisibility(0);
        }
        j.setVisibility(0);
        k.setVisibility(0);
    }

    boolean b(View view) {
        return false;
    }

    public boolean b(View view, Intent intent, Object obj) {
        Log.i("hy", "intent" + intent + "intentgetComponent" + intent.getComponent());
        if (intent == null) {
            Toast.makeText(getApplicationContext(), R.string.activity_not_found, 1).show();
            return this.af;
        }
        if (intent.getComponent() == null && ((view == this.bx.get("WS_Dvr") || view == this.bx.get("Dvr")) && !com.syu.g.l.a("iscamera360"))) {
            Toast.makeText(getApplicationContext(), R.string.dvr_switch, 1).show();
            return this.af;
        }
        Log.i("hy", "startActivitySafely");
        if (intent != null && intent.getComponent() != null) {
            if ("net.easyconn".equals(intent.getComponent().getPackageName())) {
                if (SystemProperties.get("sys.bdcl.enable").equals("0") && SystemProperties.get("service.adbec.enable").equals("1")) {
                    boolean zC = c(view, intent, obj);
                    this.af = zC;
                    return zC;
                }
                e("com.baidu.carlifevehicle");
                SystemProperties.set("sys.bdcl.enable", "0");
                this.bp.postDelayed(new gp(this, view, intent, obj), 500L);
                SystemProperties.set("service.adbec.enable", "1");
            } else if ("com.baidu.carlifevehicle".equals(intent.getComponent().getPackageName())) {
                if (SystemProperties.get("sys.bdcl.enable").equals("1") && SystemProperties.get("service.adbec.enable").equals("0")) {
                    boolean zC2 = c(view, intent, obj);
                    this.af = zC2;
                    return zC2;
                }
                e("net.easyconn");
                SystemProperties.set("service.adbec.enable", "0");
                this.bp.postDelayed(new gq(this, view, intent, obj), 500L);
                SystemProperties.set("sys.bdcl.enable", "1");
            }
        }
        TextView textView = (TextView) findViewById(a.b.a().dZ);
        TextView textView2 = (TextView) findViewById(a.b.a().ea);
        if (SystemProperties.get("ro.client.foreign", "false").equals("true") || a.b.a().ec <= 0 || intent.getComponent() == null || !a.a.f || !this.bH) {
            this.af = c(view, intent, obj);
        } else {
            if (findViewById(a.b.a().eb) != null) {
                findViewById(a.b.a().eb).setOnClickListener(new gr(this, intent, view, obj));
            }
            findViewById(a.b.a().ed).setOnClickListener(new gt(this, intent));
            if (intent.getComponent().getPackageName().equals("com.syu.music")) {
                if (SystemProperties.getInt("persist.sys.clingmusic", 0) < 3) {
                    ae();
                    String string = getApplicationContext().getResources().getString(a.b.a().a("clingmusictitle", "string"));
                    String string2 = getApplicationContext().getResources().getString(a.b.a().a("clingmusictext", "string"));
                    textView.setText(string);
                    textView2.setText(string2);
                    c(String.valueOf(string) + string2);
                } else {
                    this.af = c(view, intent, obj);
                }
            } else if (intent.getComponent().getPackageName().equals("com.syu.video")) {
                if (SystemProperties.getInt("persist.sys.clingvideo", 0) < 3) {
                    ae();
                    String string3 = getApplicationContext().getResources().getString(a.b.a().a("clingvideotitle", "string"));
                    String string4 = getApplicationContext().getResources().getString(a.b.a().a("clingvideotext", "string"));
                    textView.setText(string3);
                    textView2.setText(string4);
                    c(String.valueOf(string3) + string4);
                } else {
                    this.af = c(view, intent, obj);
                }
            } else if (intent.getComponent().getPackageName().equals("com.autonavi.amapauto")) {
                if (SystemProperties.getInt("persist.sys.clinggaode", 0) < 3) {
                    ae();
                    String string5 = getApplicationContext().getResources().getString(a.b.a().a("clingnavetitle", "string"));
                    String string6 = getApplicationContext().getResources().getString(a.b.a().a("clingnavetext", "string"));
                    textView.setText(string5);
                    textView2.setText(string6);
                    c(String.valueOf(string5) + string6);
                } else {
                    this.af = c(view, intent, obj);
                }
            } else if (intent.getComponent().getPackageName().equals("com.syu.radio")) {
                if (SystemProperties.getInt("persist.sys.clingradio", 0) < 3) {
                    ae();
                    String string7 = getApplicationContext().getResources().getString(a.b.a().a("clingradiotitle", "string"));
                    String string8 = getApplicationContext().getResources().getString(a.b.a().a("clingradiotext", "string"));
                    textView.setText(string7);
                    textView2.setText(string8);
                    c(String.valueOf(string7) + string8);
                } else {
                    this.af = c(view, intent, obj);
                }
            } else if (intent.getComponent().getPackageName().equals("com.syu.bt")) {
                if (SystemProperties.getInt("persist.sys.clingbt", 0) < 3) {
                    ae();
                    String string9 = getApplicationContext().getResources().getString(a.b.a().a("clingbttitle", "string"));
                    String string10 = getApplicationContext().getResources().getString(a.b.a().a("clingbttext", "string"));
                    textView.setText(string9);
                    textView2.setText(string10);
                    c(String.valueOf(string9) + string10);
                } else {
                    this.af = c(view, intent, obj);
                }
            } else if (intent.getComponent().getPackageName().equals("cn.kuwo.kwmusiccar")) {
                if (SystemProperties.getInt("persist.sys.clingkuwo", 0) < 3) {
                    ae();
                    String string11 = getApplicationContext().getResources().getString(a.b.a().a("clingkuwotitle", "string"));
                    String string12 = getApplicationContext().getResources().getString(a.b.a().a("clingkuwotext", "string"));
                    textView.setText(string11);
                    textView2.setText(string12);
                    c(String.valueOf(string11) + string12);
                } else {
                    this.af = c(view, intent, obj);
                }
            } else if (!intent.getComponent().getPackageName().equals("com.edog.car") || SystemProperties.getInt("persist.sys.clingkaola", 0) >= 3) {
                this.af = c(view, intent, obj);
            } else {
                ae();
                String string13 = getApplicationContext().getResources().getString(a.b.a().a("clingkaolatitle", "string"));
                String string14 = getApplicationContext().getResources().getString(a.b.a().a("clingkaolatext", "string"));
                textView.setText(string13);
                textView2.setText(string14);
                c(String.valueOf(string13) + string14);
            }
        }
        return this.af;
    }

    public void c(int i2) {
        this.bS = i2 == 0;
        aC();
        if (this.bS) {
            this.bz.b();
            if (!this.bG) {
                as.getViewTreeObserver().addOnDrawListener(new gm(this));
            }
            as();
        }
    }

    public void c(String str) {
        Intent intent = new Intent("com.syu.execute_tts");
        intent.putExtra("raw_text", str);
        intent.setPackage("com.syu.voice");
        startService(intent);
    }

    @Override // com.android.launcher6.jn
    public void c(ArrayList arrayList) {
        if (AppsCustomizePagedView.b) {
            if (cm != null) {
                cm = null;
            }
        } else if (this.bA != null) {
            this.bA.setApps(arrayList);
        }
    }

    void c(boolean z) {
        int i2 = z ? 1048576 : 0;
        if (i2 != (getWindow().getAttributes().flags & 1048576)) {
            getWindow().setFlags(i2, 1048576);
        }
        n(z);
    }

    protected boolean c() {
        return false;
    }

    boolean c(View view, Intent intent, Object obj) {
        try {
            return a(view, intent, obj);
        } catch (ActivityNotFoundException e2) {
            Toast.makeText(this, R.string.activity_not_found, 0).show();
            Log.e("Launcher", "Unable to launch. tag=" + obj + " intent=" + intent, e2);
            return false;
        }
    }

    protected void d() {
    }

    @Override // com.android.launcher6.jn
    public void d(int i2) {
        this.cj.add(Integer.valueOf(i2));
    }

    @Override // com.android.launcher6.jn
    public void d(ArrayList arrayList) {
        if (b(new ho(this, arrayList))) {
            return;
        }
        if (as != null) {
            as.c(arrayList);
        }
        if (AppsCustomizePagedView.b || this.bA == null) {
            return;
        }
        this.bA.d(arrayList);
    }

    public void d(boolean z) {
        a(z, (Runnable) null);
        g(true);
        c(true);
    }

    public void dismissFirstRunCling(View view) {
        a((Cling) findViewById(R.id.first_run_cling), (Runnable) new hy(this), "cling_gel.first_run.dismissed", HttpStatus.SC_OK, false);
        this.by.b(true);
    }

    public void dismissFolderCling(View view) {
        a((Cling) findViewById(R.id.folder_cling), (Runnable) null, "cling_gel.folder.dismissed", HttpStatus.SC_OK, true);
    }

    public void dismissWorkspaceCling(View view) {
        a((Cling) findViewById(R.id.workspace_cling), (Runnable) (view == null ? new hz(this) : null), "cling_gel.workspace.dismissed", HttpStatus.SC_OK, true);
        this.by.a(true);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            switch (keyEvent.getKeyCode()) {
                case 3:
                    return true;
                case MotionEventCompat.AXIS_TILT /* 25 */:
                    if (d("launcher_dump_state")) {
                        aj();
                        return true;
                    }
                    break;
            }
        } else if (keyEvent.getAction() == 1) {
            switch (keyEvent.getKeyCode()) {
                case 3:
                    return true;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        boolean zDispatchPopulateAccessibilityEvent = super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        List<CharSequence> text = accessibilityEvent.getText();
        text.clear();
        if (this.ah == ii.APPS_CUSTOMIZE) {
            text.add(this.bz.getCurrentTabView().getContentDescription());
        } else {
            text.add(getString(R.string.all_apps_home_button_label));
        }
        return zDispatchPopulateAccessibilityEvent;
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        synchronized (v) {
            printWriter.println(" ");
            printWriter.println("Debug logs: ");
            for (int i2 = 0; i2 < v.size(); i2++) {
                printWriter.println("  " + ((String) v.get(i2)));
            }
        }
    }

    public mu e() {
        return this.cv;
    }

    @Override // com.android.launcher6.jn
    public void e(ArrayList arrayList) {
        if (a(this.eg, true)) {
            this.ef = arrayList;
        } else {
            if (AppsCustomizePagedView.b || this.bA == null) {
                return;
            }
            this.bA.a(arrayList);
        }
    }

    void e(boolean z) {
        as.setVisibility(0);
        a(pb.OVERVIEW, false, false, (Runnable) null);
        this.ah = ii.WORKSPACE;
        f(z);
    }

    @Override // com.android.launcher6.jn
    public boolean e(int i2) {
        if (this.r != null) {
        }
        return false;
    }

    public DragLayer f() {
        return this.au;
    }

    public void f(boolean z) {
    }

    void g(boolean z) {
        if (LauncherApplication.f88a.getResources().getBoolean(R.bool.apps_hotseat_hide)) {
            if (!ip.a().j()) {
                if (z) {
                    this.r.animate().alpha(1.0f).setDuration(this.by != null ? this.by.getTransitionInDuration() : 0);
                    this.r.setVisibility(0);
                } else {
                    this.r.setAlpha(1.0f);
                }
            }
            if (this.r.getAlpha() == 1.0f && this.r.getVisibility() == 0) {
                return;
            }
            this.r.setAlpha(1.0f);
            this.r.setVisibility(0);
        }
    }

    boolean g() {
        return !u.h();
    }

    public void h() {
        if (c != 1) {
            String str = "软件未激活，请点击激活按钮，激活软件！";
            if (f == -1 || !SyuJniNative.bLoadLibOk) {
                str = "系统版本不匹配，请升级新的系统";
            } else if (e == 0) {
                str = "软件未激活，请联系厂家！ 设备ID:" + f86a;
            }
            if (this.g) {
                b(str);
                this.g = false;
                this.ee.postDelayed(new ew(this), 5000L);
            }
        }
    }

    void h(boolean z) {
        if (LauncherApplication.f88a.getResources().getBoolean(R.bool.apps_hotseat_hide)) {
            if (!ip.a().j()) {
                if (z) {
                    if (this.r.getAlpha() != 0.0f) {
                        this.r.animate().alpha(0.0f).setDuration(this.by != null ? this.by.getTransitionOutDuration() : 0);
                    }
                    this.r.setVisibility(8);
                } else {
                    this.r.setAlpha(0.0f);
                }
            }
            this.r.setVisibility(8);
        }
    }

    public void i() {
        if (this.dQ != null) {
            this.dQ.setBackground(com.fyt.b.g.a(R.drawable.music_bg));
        }
        if (this.dS != null) {
            this.dS.setBackground(com.fyt.b.g.a(R.drawable.time_bg));
        }
        if (this.dR != null) {
            this.dR.setBackground(com.fyt.b.g.a(R.drawable.radio_bg));
        }
        if (this.dW == null || this.dV == null) {
            return;
        }
        this.dW = new dk(this.A, o);
        this.dV.setAdapter((ListAdapter) this.dW);
    }

    protected boolean i(boolean z) {
        View viewFindViewById = findViewById(R.id.voice_button_container);
        View viewFindViewById2 = findViewById(R.id.voice_button);
        ComponentName globalSearchActivity = ((SearchManager) getSystemService("search")).getGlobalSearchActivity();
        ComponentName componentNameResolveActivity = null;
        if (globalSearchActivity != null) {
            Intent intent = new Intent("android.speech.action.WEB_SEARCH");
            intent.setPackage(globalSearchActivity.getPackageName());
            componentNameResolveActivity = intent.resolveActivity(getPackageManager());
        }
        if (componentNameResolveActivity == null) {
            componentNameResolveActivity = new Intent("android.speech.action.WEB_SEARCH").resolveActivity(getPackageManager());
        }
        if (!z || componentNameResolveActivity == null) {
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(8);
            }
            if (viewFindViewById2 != null) {
                viewFindViewById2.setVisibility(8);
            }
            j(false);
            return false;
        }
        int iAG = aG();
        cg[iAG] = a(R.id.voice_button, componentNameResolveActivity, R.drawable.ic_home_voice_search_holo, "com.android.launcher.toolbar_voice_search_icon");
        if (cg[iAG] == null) {
            cg[iAG] = a(R.id.voice_button, componentNameResolveActivity, R.drawable.ic_home_voice_search_holo, "com.android.launcher.toolbar_icon");
        }
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(0);
        }
        viewFindViewById2.setVisibility(0);
        j(false);
        a(viewFindViewById, viewFindViewById2);
        return true;
    }

    protected void j() {
        if (as != null && c() && as.af()) {
            d();
        }
    }

    public void j(boolean z) {
        View viewFindViewById = findViewById(R.id.voice_button_proxy);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(!z && as.aq() ? 0 : 8);
            viewFindViewById.bringToFront();
        }
    }

    public void k() {
        this.by.animate().translationY(0.0f).start();
        N().animate().translationY(0.0f).start();
    }

    @Override // com.android.launcher6.jn
    public void k(boolean z) {
        if (b(new hm(this, z))) {
            return;
        }
        if (this.bD != null) {
            if (!as.hasFocus()) {
                as.getChildAt(as.getCurrentPage()).requestFocus();
            }
            this.bD = null;
        }
        as.ax();
        for (int i2 = 0; i2 < cu.size(); i2++) {
            a((ig) cu.get(i2));
        }
        cu.clear();
        this.bG = false;
        if (z) {
            as.a(true, (ArrayList) null);
            cm = as.a(true, (ArrayList) null);
        }
        as.post(new hn(this));
    }

    protected void l() {
    }

    public void l(boolean z) {
        if (T()) {
            if (z) {
                setRequestedOrientation(-1);
            } else {
                this.ee.postDelayed(new hq(this), 500L);
            }
        }
    }

    public void m() {
        if (com.syu.a.a.h == 0) {
            return;
        }
        switch (le.h) {
            case 2:
            case 12:
                aA();
                return;
            case 3:
            case 5:
            case 6:
            case 7:
            case 11:
            default:
                return;
            case 4:
                le.g = 0;
                break;
            case 8:
            case 10:
                if (this.aO != null) {
                    this.aO.setVisibility(8);
                }
                if (this.aP != null) {
                    this.aP.setVisibility(0);
                    return;
                }
                return;
            case 9:
                break;
        }
        le.g = 0;
    }

    public void m(boolean z) {
        if (this.ds != null) {
            this.ds.setVisibility(z ? 0 : 4);
        }
    }

    public void n() {
        if (this.aS == null) {
            return;
        }
        if (le.g < 10) {
            this.aS.setImageResource(a.b.a().fN);
            return;
        }
        this.aS.setImageResource(a.b.a().fN + dY);
        dY++;
        if (dY == getResources().getInteger(R.integer.apps_widget_pic_sum)) {
            dY = 0;
        }
    }

    public void o() {
        String string;
        if (com.syu.a.a.h == 0) {
            return;
        }
        if (this.aO != null && this.aP != null) {
            this.aO.setVisibility(8);
            this.aP.setVisibility(0);
        }
        if (le.d <= 0) {
            aA();
            return;
        }
        if (this.aQ != null) {
            switch (le.d) {
                case 2:
                    this.aQ.setImageResource(a.b.a().e);
                    break;
                case 3:
                    this.aQ.setImageResource(a.b.a().f);
                    break;
                case 4:
                    this.aQ.setImageResource(a.b.a().g);
                    break;
                case 5:
                    this.aQ.setImageResource(a.b.a().h);
                    break;
                case 6:
                    this.aQ.setImageResource(a.b.a().i);
                    break;
                case 7:
                    this.aQ.setImageResource(a.b.a().j);
                    break;
                case 8:
                    this.aQ.setImageResource(a.b.a().k);
                    break;
                case 9:
                    this.aQ.setImageResource(a.b.a().m);
                    break;
                case 10:
                    this.aQ.setImageResource(a.b.a().o);
                    break;
                case 11:
                    this.aQ.setImageResource(a.b.a().p);
                    break;
                case 12:
                    this.aQ.setImageResource(a.b.a().q);
                    break;
                case 13:
                    this.aQ.setImageResource(a.b.a().r);
                    break;
                case 14:
                    this.aQ.setImageResource(a.b.a().s);
                    break;
                case 15:
                    this.aQ.setImageResource(a.b.a().t);
                    break;
                case 16:
                    this.aQ.setImageResource(a.b.a().n);
                    break;
                case 17:
                    this.aQ.setImageResource(a.b.a().u);
                    break;
                case MotionEventCompat.AXIS_RTRIGGER /* 18 */:
                    this.aQ.setImageResource(a.b.a().v);
                    break;
                case 19:
                    this.aQ.setImageResource(a.b.a().l);
                    break;
                case 20:
                    this.aQ.setImageResource(a.b.a().w);
                    break;
            }
        }
        if (this.aT != null) {
            if (le.e > 1500) {
                this.aT.setImageResource(a.b.a().Q);
            } else {
                this.aT.setImageResource(a.b.a().P);
            }
        }
        if (this.aW != null) {
            if (le.e > 1500) {
                string = String.format("%1$.1f", Float.valueOf(le.e / 1000.0f));
                if (this.aT == null) {
                    string = String.valueOf(string) + "KM";
                }
            } else {
                string = new StringBuilder(String.valueOf(le.e)).toString();
                if (this.aT == null) {
                    string = String.valueOf(string) + "M";
                }
            }
            this.aW.setText(string);
        }
        if (this.bf != null) {
            this.bf.setText(new StringBuilder(String.valueOf(le.g)).toString());
        }
        if (this.aX != null) {
            this.aX.setText(String.valueOf(String.format("%1$.1f", Float.valueOf(le.f / 1000.0f))) + "km");
        }
        if (this.be != null) {
            this.be.setText(String.valueOf(String.format("%1$.1f", Float.valueOf(le.k / 1000.0f))) + "公里");
        }
        if (this.aY != null) {
            if (le.c == -1) {
                this.aY.setText("");
            } else {
                this.aY.setText(String.valueOf(le.c) + "m");
            }
        }
        if (this.aR != null) {
            if (le.c == -1) {
                this.aR.setVisibility(8);
            } else {
                this.aR.setVisibility(0);
            }
        }
        if (this.bc != null) {
            this.bc.setText("剩余" + b(le.j) + "分钟");
        }
        if (this.aZ != null) {
            this.aZ.setText(le.f371a);
            this.aZ.setVisibility(0);
        }
        if (this.ba != null) {
            this.ba.setText("进入  " + le.b);
            this.ba.setVisibility(0);
        }
        if (this.aV != null) {
            this.aV.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        boolean zA;
        ig igVar = null;
        this.bK = false;
        if (i2 == 11) {
            int intExtra = intent != null ? intent.getIntExtra("appWidgetId", -1) : -1;
            if (i3 == 0) {
                a(0, intExtra);
                return;
            } else {
                if (i3 == -1) {
                    a(intExtra, this.bs, (AppWidgetHostView) null, this.bt);
                    return;
                }
                return;
            }
        }
        if (i2 == 10) {
            if (i3 == 202 && as.ao()) {
                g(true);
                c(true);
                as.b(false);
            }
            if (i3 != 202 || intent == null) {
                return;
            }
            this.ag = intent.getStringExtra("wallpaperRes");
            SharedPreferences.Editor editorEdit = this.ck.edit();
            editorEdit.putString("sp_wallpaper", this.ag);
            editorEdit.commit();
            return;
        }
        if (i2 == 9 || i2 == 5) {
            int intExtra2 = intent != null ? intent.getIntExtra("appWidgetId", -1) : -1;
            if (intExtra2 >= 0) {
                a(i3, intExtra2);
                return;
            }
            Log.e("Launcher", "Error: appWidgetId (EXTRA_APPWIDGET_ID) was not returned from the \\widget configuration activity.");
            a(0, intExtra2);
            as.X();
            return;
        }
        if (i3 != -1 || this.bs.h == -1) {
            if (i3 == 0) {
                as.X();
            }
            zA = false;
        } else {
            ig igVar2 = new ig(igVar);
            igVar2.f304a = i2;
            igVar2.b = intent;
            igVar2.c = this.bs.h;
            igVar2.d = this.bs.i;
            igVar2.e = this.bs.j;
            igVar2.f = this.bs.k;
            if (u()) {
                cu.add(igVar2);
                zA = false;
            } else {
                zA = a(igVar2);
            }
        }
        this.au.b();
        a(i3 != 0, zA, (Runnable) null);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        registerReceiver(this.ed, intentFilter);
        cj.a(getWindow().getDecorView());
        this.bU = true;
        this.bS = true;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (J()) {
            if (this.bA.getContentType() == q.Applications || this.bA.getContentType() == q.Widgets) {
                d(true);
            } else {
                b(true);
                this.s.setVisibility(0);
                e(true);
            }
        } else if (as.ao()) {
            g(true);
            as.b(true);
            c(true);
        } else if (as.getOpenFolder() != null) {
            Folder openFolder = as.getOpenFolder();
            if (openFolder.b()) {
                openFolder.f();
            } else {
                C();
            }
        } else {
            as.an();
            as.ae();
        }
        if (a.b.a().ec > 0) {
            ((Cling) findViewById(a.b.a().ec)).setVisibility(8);
            B();
            if (this.cr != null) {
                this.cr.setStayPressed(false);
            }
            if (this.bA != null) {
                this.bA.k();
            }
        }
        Log.i("hy", "onBackPressed");
        if (this.t != null) {
            this.t.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getWindowToken() != null && as.Z()) {
            if (view instanceof Workspace) {
                g(true);
                c(true);
                if (as.ao()) {
                    as.b(true);
                    return;
                }
                return;
            }
            Log.i("hy", "WorkspaceonClick");
            if (view instanceof CellLayout) {
                if (as.ao()) {
                    as.a(as.indexOfChild(view), true);
                }
                g(true);
                c(true);
            }
            Object tag = view.getTag();
            if (tag instanceof mp) {
                mp mpVar = (mp) tag;
                Intent intent = mpVar.f396a;
                if (intent.getComponent() != null) {
                    String className = intent.getComponent().getClassName();
                    if (className.equals(oa.class.getName())) {
                        a(true, q.Widgets, true);
                        return;
                    } else if (className.equals(MemoryDumpActivity.class.getName())) {
                        MemoryDumpActivity.a(this);
                        return;
                    } else if (className.equals(ToggleWeightWatcher.class.getName())) {
                        aI();
                        return;
                    }
                }
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                intent.setSourceBounds(new Rect(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight()));
                boolean zB = b(view, intent, tag);
                this.cv.a(intent, mpVar);
                if (zB && (view instanceof BubbleTextView)) {
                    this.cr = (BubbleTextView) view;
                    this.cr.setStayPressed(true);
                    return;
                }
                return;
            }
            if (tag instanceof dg) {
                if (view instanceof FolderIcon) {
                    b((FolderIcon) view);
                    return;
                }
                return;
            }
            if (view == this.s || view == this.bx.get("WS_Allapps") || view == this.bx.get("ALLAPP")) {
                if (J()) {
                    d(true);
                    return;
                } else {
                    onClickAllAppsButton(view);
                    return;
                }
            }
            if (view == this.bx.get("Navi")) {
                com.syu.a.a.a(getApplicationContext()).k.a(0, 24, 0);
                return;
            }
            if (view == this.bx.get("Voice")) {
                b(view, com.syu.g.g.a(this, "com.syu.voice"), "bt");
                return;
            }
            if (view == this.bx.get("Bluetooth")) {
                b(view, a("com.syu.bt", "com.syu.bt.BtAct"), "bt");
                return;
            }
            if (view == this.bx.get("Radio")) {
                if (com.syu.a.a.i == 1) {
                    b(view, com.syu.g.g.a(this, "com.syu.carradio"), "bt");
                    return;
                } else {
                    b(view, com.syu.g.g.a(this, "com.syu.radio"), "bt");
                    return;
                }
            }
            if (view == this.bx.get("WS_Radio")) {
                if (com.syu.a.a.i == 1) {
                    b(view, com.syu.g.g.a(this, "com.syu.carradio"), "bt");
                    return;
                } else {
                    b(view, com.syu.g.g.a(this, "com.syu.radio"), "music");
                    return;
                }
            }
            if (view == this.bx.get("WS_Music") || view == this.bx.get("WS_Music_Two") || view == this.bx.get("WS_Music3")) {
                b(view, com.syu.g.g.a(this, "com.syu.music"), "music");
                return;
            }
            if (view == this.bx.get("WS_Maps")) {
                b(view, com.syu.g.g.a(this, "com.google.android.apps.maps"), "maps");
                return;
            }
            if (view == this.bx.get("WS_Spotify")) {
                b(view, com.syu.g.g.a(this, "com.spotify.music"), "spotify");
                return;
            }
            if (view == this.bx.get("WS_YouTube")) {
                b(view, com.syu.g.g.a(this, "com.google.android.youtube"), "youtube");
                return;
            }
            if (view == this.bx.get("WS_Chrome")) {
                b(view, com.syu.g.g.a(this, "com.android.chrome"), "chrome");
                return;
            }
            if (view == this.bx.get("WS_MusicIV")) {
                b(view, com.syu.g.g.a(this, "com.syu.music"), "music");
                return;
            }
            if (view == this.bx.get("WS_Video")) {
                b(view, com.syu.g.g.a(this, "com.syu.video"), "music");
                return;
            }
            if (view == this.bx.get("WS_Gallery")) {
                b(view, com.syu.g.g.a(this, "com.syu.gallery"), "galleryAction");
                return;
            }
            if (view == this.bx.get("WS_Miudrive")) {
                b(view, com.syu.g.g.a(this, "com.didi365.miudrive.navi"), "miudriveAction");
                return;
            }
            if (view == this.bx.get("WS_Aux")) {
                b(view, com.syu.g.g.a(this, "com.syu.av"), "auxAction");
                return;
            }
            if (view == this.bx.get("WS_Bt") || view == this.aN) {
                b(view, a("com.syu.bt", "com.syu.bt.BtAct"), "bt");
                return;
            }
            if (view == this.bx.get("WS_Navi")) {
                com.syu.a.a.a(getApplicationContext()).k.a(0, 24, 0);
                return;
            }
            if (view == this.bx.get("WS_Gaode")) {
                b(view, com.syu.g.g.a(this, "com.autonavi.amapauto"), "music");
                return;
            }
            if (view == this.bx.get("WS_Klfm")) {
                b(view, com.syu.g.g.a(this, "com.edog.car"), "music");
                return;
            }
            if (view == this.bx.get("WS_Kuwo")) {
                b(view, com.syu.g.g.a(this, "cn.kuwo.kwmusiccar"), "music");
                return;
            }
            if (view == this.bx.get("WS_Dvr")) {
                if (com.syu.g.l.a("iscamera360")) {
                    b(view, com.syu.g.g.a(this, "com.syu.camera360"), "camera360");
                    return;
                } else {
                    b(view, com.syu.g.g.a(this, "com.syu.dvr"), "music");
                    return;
                }
            }
            if (view == this.bx.get("WS_Dvd")) {
                b(view, com.syu.g.g.a(this, "com.syu.dvd"), "music");
                return;
            }
            if (view == this.bx.get("WS_Steer")) {
                b(view, com.syu.g.g.a(this, "com.syu.steer"), "music");
                return;
            }
            if (view == this.bx.get("WS_Easyconn")) {
                b(view, com.syu.g.g.a(this, "net.easyconn"), "music");
                return;
            }
            if (view == this.bx.get("WS_Recharge")) {
                b(view, com.syu.g.g.a(this, "com.syu.unicar"), "music");
                return;
            }
            if (view == this.bx.get("WS_Voice")) {
                b(view, com.syu.g.g.a(this, "com.syu.voice"), "music");
                return;
            }
            if (view == this.bx.get("WS_File") || view == this.bx.get("FILEMANAGER")) {
                b(view, com.syu.g.g.a(this, "com.syu.filemanager"), "music");
                return;
            }
            if (view == this.bx.get("WS_Car")) {
                b(view, com.syu.g.g.a(this, "com.syu.car"), "music");
                return;
            }
            if (view == this.bx.get("WS_Tire")) {
                b(view, com.syu.g.g.a(this, "com.cz.usbserial.tpms"), "music");
                return;
            }
            if (view == this.bx.get("WS_Time") || view == this.bx.get("WS_Time_Two")) {
                b(view, new Intent("android.settings.DATE_SETTINGS"), "date");
                return;
            }
            if (view == this.bx.get("Setting") || view == this.bx.get("WS_Settings")) {
                b(view, com.syu.g.g.a(this, "com.syu.settings"), "music");
                return;
            }
            if (view == this.bx.get("Video")) {
                b(view, com.syu.g.g.a(this, "com.syu.video"), "music");
                return;
            }
            if (view == this.bx.get("Btav")) {
                Intent intent2 = new Intent();
                intent2.setComponent(new ComponentName("com.syu.bt", "com.syu.bt.act.ActBtAvStart"));
                startActivity(intent2);
                return;
            }
            if (view == this.bx.get("ECAR")) {
                Intent intent3 = new Intent();
                intent3.setComponent(new ComponentName("com.coagent.ecar", "com.coagent.ecarnet.car.activity.WelcomeActivity"));
                intent3.addCategory("android.intent.category.MAIN");
                intent3.setFlags(270532608);
                startActivity(intent3);
                return;
            }
            if (view == this.bx.get("SOS")) {
                b(view, com.syu.g.g.a(this, "com.ecar.assistantnew"), "music");
                return;
            }
            if (view == this.bx.get("Kuwo")) {
                b(view, com.syu.g.g.a(this, "cn.kuwo.kwmusiccar"), "music");
                return;
            }
            if (view == this.bx.get("UNICAR")) {
                b(view, com.syu.g.g.a(this, "com.syu.unicar"), "unicar");
                return;
            }
            if (view == this.bx.get("Music")) {
                b(view, com.syu.g.g.a(this, "com.syu.music"), "music");
                return;
            }
            if (view == this.bx.get("Klfm")) {
                b(view, com.syu.g.g.a(this, "com.edog.car"), "music");
                return;
            }
            if (view == this.bx.get("HONGFANS")) {
                b(view, com.syu.g.g.a(this, "com.hongfans.rearview"), "hongfansAction");
                return;
            }
            if (view == this.bx.get("Dvr")) {
                if (com.syu.g.l.a("iscamera360")) {
                    b(view, com.syu.g.g.a(this, "com.syu.camera360"), "camera360");
                    return;
                } else {
                    b(view, com.syu.g.g.a(this, "com.syu.dvr"), "INNER_DVR");
                    return;
                }
            }
            if (view == this.bx.get("Light")) {
                com.syu.a.a.a(getApplicationContext()).a().a(0, 10, -3);
                return;
            }
            if (view == this.bx.get("CLOLSESCREEN") || view == this.bx.get("WS_CLOLSESCREEN")) {
                com.syu.a.a.a(getApplicationContext()).a().a(0, 18, 1);
                return;
            }
            if (view == this.bx.get("Wifi")) {
                b(view, new Intent("android.settings.WIFI_SETTINGS"), "settings");
                return;
            }
            if (view == this.bx.get("Sound") || view == this.bx.get("WS_SOUND")) {
                com.syu.a.a.a(getApplicationContext()).a().a(4, 0, -6);
                return;
            }
            if (view == this.bx.get("CloseSound") || view == this.bx.get("WS_CLOLSESOUND")) {
                com.syu.a.a.a(getApplicationContext()).a().a(4, 0, -6);
                com.syu.a.a.a(getApplicationContext()).a().a(4, 0, -5);
                return;
            }
            if (view == this.bx.get("Eq") || view == this.bx.get("WS_EQ")) {
                if (!getResources().getBoolean(R.bool.is_tablet)) {
                    b(view, com.syu.g.g.a(this, "com.syu.eq"), "eq");
                    return;
                }
                Intent intent4 = new Intent();
                intent4.setComponent(new ComponentName("com.hzh.eqer", "com.hzh.eqer.ui.MainActivity"));
                intent4.addCategory("android.intent.category.MAIN");
                intent4.setFlags(270532608);
                startActivity(intent4);
                return;
            }
            if (view == this.bx.get("Time")) {
                b(view, new Intent("android.settings.DATE_SETTINGS"), "date");
                return;
            }
            if (view == this.bx.get("WS_Dvr_Rec")) {
                Intent intent5 = new Intent("com.syu.dvr.server.CollisionVideoService");
                intent5.setAction("android.com.syu.dvr.action.RECORD");
                intent5.setPackage("com.syu.dvr");
                startService(intent5);
                return;
            }
            if (view == this.bx.get("WS_Dvr_Lock")) {
                Intent intent6 = new Intent("com.syu.dvr.server.CollisionVideoService");
                intent6.setAction("android.com.syu.dvr.action.LOCKE");
                intent6.setPackage("com.syu.dvr");
                startService(intent6);
                return;
            }
            if (view == this.bx.get("WS_Dvr_Catch")) {
                Intent intent7 = new Intent("com.syu.dvr.server.CollisionVideoService");
                intent7.setAction("android.com.syu.dvr.action.PHOTO");
                intent7.setPackage("com.syu.dvr");
                startService(intent7);
                return;
            }
            if (view == this.bx.get("WS_BRIGHT") || view == this.bx.get("BRIGHT")) {
                new com.syu.e.a(o, this.cO).a(this.au);
                return;
            }
            if (view == this.bx.get("WS_BROWSER") || view == this.bx.get("BROWSER")) {
                b(view, com.syu.g.g.a(this, "com.android.browser"), "music");
                return;
            }
            if (view == this.bx.get("WS_GUIDE")) {
                b(view, com.syu.g.g.a(this, "com.syu.guide"), "music");
                return;
            }
            if (view == this.bx.get("CALCULATOR")) {
                b(view, com.syu.g.g.a(this, "com.android.calculator2"), "music");
                return;
            }
            if (view == this.bx.get("NEWEYE")) {
                b(view, com.syu.g.g.a(this, "com.newsmy.ncarmanagerclient"), "newsmy");
                return;
            }
            if (view == this.bx.get("WS_CANBUS") || view == this.bx.get("CANBUS")) {
                b(view, com.syu.g.g.a(this, "com.syu.canbus"), "canbus");
            } else if (view == this.bx.get("WS360")) {
                if (SystemProperties.getInt("persist.sys.inner360", 0) == 0) {
                    b(view, com.syu.g.g.a(this, "com.syu.panoramic"), "360");
                } else {
                    b(view, com.syu.g.g.a(this, "com.syu.camera360"), "360");
                }
            }
        }
    }

    public void onClickAllAppsButton(View view) {
        a(true, q.Applications, true);
    }

    public void onClickAppMarketButton(View view) {
    }

    public void onClickSearchButton(View view) {
        view.performHapticFeedback(1);
        onSearchRequested();
    }

    public void onClickVoiceButton(View view) {
        view.performHapticFeedback(1);
        x();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        if (getResources().getBoolean(R.bool.isTransparent)) {
            getWindow().addFlags(ExploreByTouchHelper.INVALID_ID);
            getWindow().clearFlags(67108864);
            getWindow().setStatusBarColor(0);
        }
        Log.i("hy", "onCreate");
        super.onCreate(bundle);
        if (getResources().getBoolean(R.bool.apps_hidetitle)) {
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
            getWindow().setFlags(2048, 2048);
        }
        this.h = LauncherApplication.f88a;
        o = this;
        com.syu.h.b.a("com.android.browser");
        ip.a(getApplicationContext());
        ip ipVarA = ip.a();
        ContentResolver contentResolver = getApplicationContext().getContentResolver();
        a.a.f2a = a.c.a(contentResolver, 10, 0);
        a.a.b = a.c.a(contentResolver, 9, 0);
        a.a.c = a.c.a(contentResolver, 11, 0);
        a.a.d = a.c.a(contentResolver, 13, 0);
        f86a = SystemProperties.get("serialno");
        Boolean bool = false;
        switch (a.a.d) {
            case 5:
                if (LauncherApplication.j != null) {
                    LauncherApplication.j.equals("true");
                }
                break;
            case 6:
                bool = true;
                break;
        }
        if (getResources().getBoolean(R.bool.window_isactivation) || bool.booleanValue()) {
            SystemProperties.set("sys.fyt.launcher.warn", "warning");
            d = getResources().getInteger(R.integer.config_areaindex);
            switch (a.a.d) {
                case 5:
                    if (LauncherApplication.j != null && LauncherApplication.j.equals("true")) {
                        d = 255;
                    }
                    break;
                case 6:
                    d = 254;
                    break;
            }
            Bundle bundle2 = new Bundle();
            Bundle bundle3 = new Bundle();
            bundle2.putInt("areaindex", d);
            if (SyuJniNative.bLoadLibOk) {
                f = SyuJniNative.getInstance().syu_jni_command(SyuJniNative.JNI_EXE_CMD_112_IS_AREAACTIVED, bundle2, bundle3);
                if (bundle2 != null && f == 0) {
                    c = bundle3.getInt("isactived", 0);
                }
            }
        } else {
            c = 1;
        }
        Point point = new Point();
        Point point2 = new Point();
        Point point3 = new Point();
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        defaultDisplay.getCurrentSizeRange(point, point2);
        defaultDisplay.getRealSize(point3);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        bl blVarA = ipVarA.a(this, displayMetrics.widthPixels, displayMetrics.heightPixels, point3.x, point3.y, displayMetrics.widthPixels, displayMetrics.heightPixels);
        this.ck = com.syu.g.l.c();
        u = ipVarA.a(this);
        this.bQ = ipVarA.d();
        this.bQ.a(blVarA);
        this.av = new bo(this);
        this.ar = getLayoutInflater();
        this.cv = new mu(this);
        this.ag = this.ck.getString("sp_wallpaper", "");
        if (TextUtils.isEmpty(this.ag)) {
            this.ag = "def_bg";
        }
        this.bq = AppWidgetManager.getInstance(this);
        this.br = new ir(this, m);
        this.br.startListening();
        this.p = com.syu.i.e.a(this);
        bo = KWAPI.createKWAPI(this, "fangyitong");
        if (bo != null) {
            bo.registerPlayerStatusListener(this, this.cI);
        }
        this.bI = false;
        ap();
        setContentView(R.layout.launcher);
        au();
        blVarA.a(this);
        aE();
        M();
        this.bD = bundle;
        a(this.bD);
        if (this.bA != null) {
            Log.e("mAppsCustomizeContent", "mAppsCustomizeContent != null");
            this.bA.a(iv.b(this));
        }
        if (!this.bJ) {
            if (bO) {
                u.a(true, -1);
            } else {
                u.a(true, as.getCurrentPage());
            }
        }
        this.bF = new SpannableStringBuilder();
        Selection.setSelection(this.bF, 0);
        IntentFilter intentFilter = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        intentFilter.addAction("com.lsec.pipdie");
        intentFilter.addAction("com.lsec.tyz.action.voice.launcher");
        registerReceiver(this.ao, intentFilter);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("android.intent.action.WALLPAPER_CHANGED");
        intentFilter2.addAction("android.intent.LAUNCHER.LauncherChoose");
        this.n = new SetWallpaperReceiver();
        registerReceiver(this.n, intentFilter2);
        this.ee.post(this.C);
        ao();
        String string = this.ck.getString("launcherdefAppKey", "");
        if (TextUtils.isEmpty(string)) {
            this.A.add("com.syu.carlink");
            if (LauncherApplication.j.equals("true")) {
                this.A.add("com.google.android.apps.maps");
                this.A.add("com.android.vending");
                this.A.add("com.google.android.googlequicksearchbox");
            } else {
                this.A.add("com.autonavi.amapauto");
                this.A.add("com.syu.video");
                this.A.add("cn.kuwo.kwmusiccar");
            }
            this.A.add("com.syu.music");
            this.A.add("com.syu.radio");
            this.A.add("com.syu.filemanager");
            this.cl = this.ck.edit();
            this.cl.putString("launcherdefAppKey", this.A.toString());
            this.cl.commit();
        } else {
            if (string.contains(" ")) {
                string = string.replaceAll(" ", "");
            }
            this.A = new ArrayList(Arrays.asList(string.substring(1, string.length() - 1).split(",")));
        }
        l(true);
        W();
        if (!this.ck.getBoolean("cling_gel.first_run.dismissed", false)) {
            if (LauncherApplication.f88a.getResources().getBoolean(R.bool.isdefaultwallpaper)) {
                ag();
            }
            SharedPreferences.Editor editorEdit = this.ck.edit();
            editorEdit.putBoolean("cling_gel.first_run.dismissed", true);
            editorEdit.commit();
        }
        IntentFilter intentFilter3 = new IntentFilter();
        intentFilter3.addAction("com.fyt.systemui.remove");
        registerReceiver(this.cJ, intentFilter3);
        this.cw = new le();
        IntentFilter intentFilter4 = new IntentFilter();
        intentFilter4.addAction("AUTONAVI_STANDARD_BROADCAST_SEND");
        registerReceiver(this.cw, intentFilter4);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Log.d("LZP", "onDestroy");
        this.H.a(0, this.cP);
        this.H.a(4, this.cP);
        this.H.a(7, this.cP);
        this.H.a(2, this.ae);
        unregisterReceiver(this.cJ);
        unregisterReceiver(this.cw);
        this.ee.removeMessages(1);
        this.ee.removeMessages(0);
        as.removeCallbacks(this.ct);
        ip ipVarA = ip.a();
        u.g();
        ipVarA.a((Launcher) null);
        try {
            this.br.stopListening();
        } catch (NullPointerException e2) {
            Log.w("Launcher", "problem while stopping AppWidgetHost during Launcher destruction", e2);
        }
        this.br = null;
        this.cd.clear();
        TextKeyListener.getInstance().release();
        if (u != null) {
            u.b();
        }
        getContentResolver().unregisterContentObserver(this.aq);
        unregisterReceiver(this.ao);
        this.au.a();
        ((ViewGroup) as.getParent()).removeAllViews();
        as.removeAllViews();
        as = null;
        this.av = null;
        ik.a();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.bS = false;
        if (this.bU) {
            unregisterReceiver(this.ed);
            this.bU = false;
        }
        aC();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        int unicodeChar = keyEvent.getUnicodeChar();
        boolean zOnKeyDown = super.onKeyDown(i2, keyEvent);
        boolean z = unicodeChar > 0 && !Character.isWhitespace(unicodeChar);
        if (!zOnKeyDown && aq() && z && TextKeyListener.getInstance().onKeyDown(as, this.bF, i2, keyEvent) && this.bF != null && this.bF.length() > 0) {
            return onSearchRequested();
        }
        if (i2 == 82 && keyEvent.isLongPress()) {
            return true;
        }
        return zOnKeyDown;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        Log.i("hy", "onLongClick");
        if (g() && !u() && this.ah == ii.WORKSPACE) {
            if ((view instanceof Workspace) && !as.ao()) {
                if (as.ap()) {
                    h(true);
                    as.performHapticFeedback(0, 1);
                    return true;
                }
                g(true);
                c(true);
                return false;
            }
            if (!(view instanceof CellLayout)) {
                view = (View) view.getParent().getParent();
            } else if (!as.ao()) {
                if (as.ap()) {
                    h(true);
                    as.performHapticFeedback(0, 1);
                    return true;
                }
                g(true);
                c(true);
                return false;
            }
            aD();
            aj ajVar = (aj) view.getTag();
            if (ajVar == null) {
                return true;
            }
            if (LauncherApplication.f88a.getResources().getBoolean(R.bool.widget_isfix) && ajVar.f107a != null && ajVar.f107a.toString().contains("com.android.launcher6.LauncherAppWidgetHost")) {
                return false;
            }
            View view2 = ajVar.f107a;
            if ((b(view) || as.G()) && !this.av.a()) {
                if (view2 == null) {
                    as.performHapticFeedback(0, 1);
                    if (as.ao()) {
                        as.g(view);
                    } else {
                        as.ap();
                    }
                } else {
                    if (!(view2 instanceof Folder)) {
                        as.a(ajVar);
                    }
                    new Handler().postDelayed(new gw(this), 150L);
                }
            }
            return true;
        }
        return false;
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (!"android.intent.action.MAIN".equals(intent.getAction())) {
            if ("ChangeDefApp".equals(intent.getAction())) {
                com.syu.d.a.b("ChangeDefApp -------" + intent.getStringExtra("pkg") + "," + intent.getBooleanExtra("Remove", true));
                String stringExtra = intent.getStringExtra("pkg");
                if (intent.getBooleanExtra("Remove", true)) {
                    for (int i2 = 0; i2 < this.A.size(); i2++) {
                        if (((String) this.A.get(i2)).equals(stringExtra)) {
                            this.A.remove(i2);
                            break;
                        }
                    }
                } else {
                    this.A.add(stringExtra);
                }
                com.syu.d.a.b("onNewIntent " + this.A.size());
                this.cl = this.ck.edit();
                this.cl.putString("launcherdefAppKey", this.A.toString());
                this.cl.commit();
                this.dW = new dk(this.A, o);
                this.dV.setAdapter((ListAdapter) this.dW);
                return;
            }
            return;
        }
        s();
        boolean z = this.bT && (intent.getFlags() & 4194304) != 4194304;
        if (as == null) {
            return;
        }
        Folder openFolder = as.getOpenFolder();
        as.an();
        if (z && this.ah == ii.WORKSPACE && !as.N() && openFolder == null) {
            as.d(true);
        }
        C();
        L();
        if (z) {
            d(true);
        } else {
            this.bE = ii.WORKSPACE;
        }
        View viewPeekDecorView = getWindow().peekDecorView();
        if (viewPeekDecorView != null && viewPeekDecorView.getWindowToken() != null) {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(viewPeekDecorView.getWindowToken(), 0);
        }
        if (this.bz != null) {
            this.bz.a();
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        InstallShortcutReceiver.a();
        Log.d("LZP", "onPause");
        super.onPause();
        this.bI = true;
        this.av.b();
        this.av.d();
        com.fyt.car.c.f485a.a(this.ea);
        com.fyt.car.c.b.a(this.ec);
        com.fyt.car.c.f.a(this.cK);
        com.fyt.car.c.g.a(this.I);
        com.fyt.car.c.h.a(this.cM);
        com.fyt.car.c.i.a(this.cL);
        aA();
        if (as.getCustomContentCallbacks() != null) {
            as.getCustomContentCallbacks().b();
        }
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        if (as.ao()) {
            return false;
        }
        as.ap();
        return false;
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        Iterator it = this.cj.iterator();
        while (it.hasNext()) {
            as.r(((Integer) it.next()).intValue());
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        o();
        boolean z = a.a.d != 6 || LauncherApplication.k;
        if (z) {
            h();
        }
        if (this.bE == ii.WORKSPACE) {
            d(true);
        } else if (this.bE == ii.APPS_CUSTOMIZE) {
            a(true, q.Applications, false);
        }
        this.bE = ii.NONE;
        Log.i("hy", "onResume");
        n(this.ah == ii.WORKSPACE);
        this.bI = false;
        bO = false;
        if (this.bJ || this.bL) {
            this.bG = true;
            u.a(true, -1);
            this.bJ = false;
            this.bL = false;
        }
        if (this.bM.size() > 0) {
            if (this.bA != null) {
                this.bA.setBulkBind(true);
            }
            for (int i2 = 0; i2 < this.bM.size(); i2++) {
                ((Runnable) this.bM.get(i2)).run();
            }
            if (this.bA != null) {
                this.bA.setBulkBind(false);
            }
            this.bM.clear();
        }
        if (this.bN.size() > 0) {
            for (int i3 = 0; i3 < this.bN.size(); i3++) {
                ((Runnable) this.bN.get(i3)).run();
            }
            this.bN.clear();
        }
        if (this.cr != null) {
            this.cr.setStayPressed(false);
        }
        if (this.bA != null) {
            this.bA.k();
        }
        I().aa();
        InstallShortcutReceiver.a(this);
        j(false);
        ao();
        if (as.getCustomContentCallbacks() != null && as.ai()) {
            as.getCustomContentCallbacks().a();
        }
        as.ar();
        as.aj();
        com.fyt.car.c.f485a.a(this.ea, true);
        com.fyt.car.c.b.a(this.ec, true);
        com.fyt.car.c.f.a(this.cK, true);
        com.fyt.car.c.g.a(this.I, true);
        com.fyt.car.c.h.a(this.cM, false);
        com.fyt.car.c.i.a(this.cL, false);
        this.H = com.syu.a.a.a(this.h).a();
        this.H.a(1, this.T, 0);
        this.H.a(1, this.W, 1, 2);
        this.H.a(0, this.cP, 0, 50, 60, HttpStatus.SC_SWITCHING_PROTOCOLS, 31, 4);
        this.H.a(4, this.cP, 2, 3);
        this.H.a(7, this.cP, 1000);
        this.H.a(2, this.ae, 0, 1, 2, 28, 26, 13, 9, 7);
        this.H.a(0, 0, 50, 60, HttpStatus.SC_SWITCHING_PROTOCOLS, 31, 4);
        this.H.a(1, 0);
        this.H.a(1, 1);
        this.H.a(7, 1000);
        this.H.a(2, 0, 1, 2, 28, 26, 13, 9, 7);
        if (this.t != null && !this.l) {
            this.t.setVisibility(0);
        }
        this.l = false;
        b();
        this.Q = null;
        if (com.syu.a.a.g != 8) {
            com.syu.g.l.a(this.cR, R.string.music_name);
            com.syu.g.l.a(this.cX, R.string.music_author);
            com.syu.g.l.a(this.cW, R.string.music_name);
            com.syu.g.l.a(this.cS, "00:00");
            com.syu.g.l.a(this.cT, "00:00");
            if (this.dI != null) {
                this.dI.setProgress(0);
            }
            if (this.dx != null) {
                this.dx.setBackground(com.fyt.b.g.a(a.b.a().ad));
            }
        }
        if (this.E && !com.syu.g.b.a(getApplicationContext(), "cn.kuwo.kwmusiccar")) {
            this.E = false;
            if (this.dz != null) {
                this.dz.setBackgroundResource(a.b.a().ad);
            }
            if (this.dl != null) {
                this.dl.setText(R.string.car_kuwo);
            }
            if (this.dm != null) {
                this.dm.setText(R.string.music_author);
            }
        }
        if (J()) {
            Log.i("hy", "onResume removePip");
            com.syu.d.a.b("onResume----->removePip");
            com.syu.g.n.b(null);
        } else {
            Log.i("hy", "onResume startMapPip");
            com.syu.d.a.b("onResume----->startMapPip");
            com.syu.g.n.a((View) null);
        }
    }

    @Override // android.app.Activity
    public Object onRetainNonConfigurationInstance() {
        if (SystemClock.elapsedRealtime() > (u.k ? 300000 : 0)) {
            u.g();
        }
        if (this.bA != null) {
            this.bA.j();
        }
        return Boolean.TRUE;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (as.getChildCount() > 0) {
            bundle.putInt("launcher.current_screen", as.getRestorePage());
        }
        super.onSaveInstanceState(bundle);
        bundle.putInt("launcher.state", this.ah.ordinal());
        C();
        if (this.bs.h != -1 && this.bs.i > -1 && this.bK) {
            bundle.putLong("launcher.add_container", this.bs.h);
            bundle.putLong("launcher.add_screen", this.bs.i);
            bundle.putInt("launcher.add_cell_x", this.bs.j);
            bundle.putInt("launcher.add_cell_y", this.bs.k);
            bundle.putInt("launcher.add_span_x", this.bs.l);
            bundle.putInt("launcher.add_span_y", this.bs.m);
            bundle.putParcelable("launcher.add_widget_info", this.bt);
        }
        if (this.bv != null && this.bK) {
            bundle.putBoolean("launcher.rename_folder", true);
            bundle.putLong("launcher.rename_folder_id", this.bv.f);
        }
        if (this.bz != null) {
            String currentTabTag = this.bz.getCurrentTabTag();
            if (currentTabTag != null) {
                bundle.putString("apps_customize_currentTab", currentTabTag);
            }
            bundle.putInt("apps_customize_currentIndex", this.bA.getSaveInstanceStateIndex());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested() {
        startSearch(null, false, null, true);
        return true;
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        Log.i("hy", "onStart");
        com.syu.g.n.a();
        cj.a(true);
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        Log.i("hy", "onStop");
        com.syu.g.n.b(null);
        this.l = true;
        cj.a(false);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    public void onTouchDownAllAppsButton(View view) {
        view.performHapticFeedback(1);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        super.onTrimMemory(i2);
        if (i2 >= 60) {
            this.bz.c();
        }
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        bO = true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.bT = z;
    }

    protected void p() {
        Intent intent = new Intent("android.intent.action.SET_WALLPAPER");
        intent.setComponent(w());
        intent.putExtra("live_wallpaper", 1);
        startActivityForResult(intent, 10);
    }

    public void performHapticFeedbackOnTouchDown(View view) {
        view.performHapticFeedback(1);
    }

    public ir q() {
        return this.br;
    }

    public void s() {
        getWindow().closeAllPanels();
        this.bK = false;
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i2) {
        if (i2 >= 0) {
            this.bK = true;
        }
        super.startActivityForResult(intent, i2);
    }

    @Override // android.app.Activity
    public void startSearch(String str, boolean z, Bundle bundle, boolean z2) {
        d(true);
        if (str == null) {
            str = ar();
        }
        if (bundle == null) {
            bundle = new Bundle();
            bundle.putString("source", "launcher-search");
        }
        Rect rect = new Rect();
        if (this.by != null) {
            rect = this.by.getSearchBarBounds();
        }
        a(str, z, bundle, rect);
    }

    public bo t() {
        return this.av;
    }

    public boolean u() {
        return this.bG || this.bK;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
    }

    protected void v() {
        Intent intent = new Intent("android.intent.action.SET_WALLPAPER");
        intent.setComponent(w());
        intent.putExtra("night_mode", L);
        startActivityForResult(intent, 10);
    }

    protected ComponentName w() {
        return new ComponentName(getPackageName(), WallpaperPickerActivity.class.getName());
    }

    public void x() {
        try {
            ComponentName globalSearchActivity = ((SearchManager) getSystemService("search")).getGlobalSearchActivity();
            Intent intent = new Intent("android.speech.action.WEB_SEARCH");
            intent.setFlags(268435456);
            if (globalSearchActivity != null) {
                intent.setPackage(globalSearchActivity.getPackageName());
            }
            a((View) null, intent, "onClickVoiceButton");
        } catch (ActivityNotFoundException e2) {
            Intent intent2 = new Intent("android.speech.action.WEB_SEARCH");
            intent2.setFlags(268435456);
            b((View) null, intent2, "onClickVoiceButton");
        }
    }

    public View.OnTouchListener y() {
        if (this.bX == null) {
            this.bX = new go(this);
        }
        return this.bX;
    }

    protected void z() {
    }
}
