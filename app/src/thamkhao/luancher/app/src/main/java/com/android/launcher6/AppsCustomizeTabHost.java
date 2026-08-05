package com.android.launcher6;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class AppsCustomizeTabHost extends TabHost implements TabHost.OnTabChangeListener, dy, ks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LayoutInflater f71a;
    private ViewGroup b;
    private ViewGroup c;
    private AppsCustomizePagedView d;
    private FrameLayout e;
    private LinearLayout f;
    private boolean g;
    private boolean h;
    private boolean i;
    private Runnable j;
    private final Rect k;

    public AppsCustomizeTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = new Rect();
        this.f71a = LayoutInflater.from(context);
        this.j = new RunnableC0002r(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(q qVar) {
        com.syu.g.i.a().a("onTabChangedEnd");
        this.d.setContentType(qVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.d.p(this.d.getCurrentPage());
        this.d.requestFocus();
    }

    private void g() {
        if (isHardwareAccelerated()) {
            setLayerType(2, null);
            buildLayer();
        }
    }

    private void setVisibilityOfSiblingsWithLowerZOrder(int i) {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup == null) {
            return;
        }
        View viewE = ((Launcher) getContext()).E();
        int childCount = viewGroup.getChildCount();
        if (isChildrenDrawingOrderEnabled()) {
            throw new RuntimeException("Failed; can't get z-order of views");
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt == this) {
                return;
            }
            if (Launcher.G().r == childAt && !LauncherApplication.f88a.getResources().getBoolean(R.bool.apps_hotseat_hide)) {
                return;
            }
            if (childAt.getVisibility() != 8 && childAt != viewE) {
                childAt.setVisibility(i);
            }
        }
    }

    public q a(String str) {
        if (!str.equals("APPS") && str.equals("WIDGETS")) {
            return q.Widgets;
        }
        return q.Applications;
    }

    public String a(q qVar) {
        return (qVar != q.Applications && qVar == q.Widgets) ? "WIDGETS" : "APPS";
    }

    void a() {
        if (this.g) {
            return;
        }
        this.d.h();
    }

    @Override // com.android.launcher6.ks
    public void a(Launcher launcher, float f) {
    }

    @Override // com.android.launcher6.ks
    public void a(Launcher launcher, boolean z, boolean z2) {
        this.d.a(launcher, z, z2);
        this.g = true;
        this.h = z2;
        if (z2) {
            setVisibilityOfSiblingsWithLowerZOrder(0);
        } else {
            this.f.setVisibility(0);
            this.d.d(this.d.getCurrentPage(), true);
        }
        if (this.i) {
            this.d.h();
            this.i = false;
        }
    }

    public void b() {
        if (getVisibility() == 0) {
            this.f.setVisibility(0);
            this.d.d(this.d.getCurrentPage(), true);
            this.d.p(this.d.getCurrentPage());
        }
    }

    @Override // com.android.launcher6.ks
    public void b(Launcher launcher, boolean z, boolean z2) {
        if (z) {
            g();
        }
        launcher.dismissWorkspaceCling(null);
    }

    public void c() {
        this.f.setVisibility(8);
        this.d.e();
    }

    @Override // com.android.launcher6.ks
    public void c(Launcher launcher, boolean z, boolean z2) {
        this.d.c(launcher, z, z2);
        this.g = false;
        if (z) {
            setLayerType(0, null);
        }
        if (z2) {
            return;
        }
        this.d.b();
        this.d.p(this.d.getCurrentPage());
        setVisibilityOfSiblingsWithLowerZOrder(4);
    }

    boolean d() {
        return this.g;
    }

    @Override // com.android.launcher6.ks
    public View getContent() {
        return this.f;
    }

    @Override // android.view.ViewGroup
    public int getDescendantFocusability() {
        if (getVisibility() != 0) {
            return 393216;
        }
        return super.getDescendantFocusability();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        setup();
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.tabs_container);
        TabWidget tabWidget = getTabWidget();
        AppsCustomizePagedView appsCustomizePagedView = (AppsCustomizePagedView) findViewById(R.id.apps_customize_pane_content);
        this.b = tabWidget;
        this.c = viewGroup;
        this.d = appsCustomizePagedView;
        this.e = (FrameLayout) findViewById(R.id.animation_buffer);
        this.f = (LinearLayout) findViewById(R.id.apps_customize_content);
        if (tabWidget == null || this.d == null) {
            throw new Resources.NotFoundException();
        }
        s sVar = new s(this, appsCustomizePagedView);
        String string = getContext().getString(R.string.all_apps_button_label);
        TextView textView = (TextView) this.f71a.inflate(R.layout.tab_widget_indicator, (ViewGroup) tabWidget, false);
        textView.setText(string);
        textView.setContentDescription(string);
        textView.setWidth(150);
        textView.setTextSize(20.0f);
        addTab(newTabSpec("APPS").setIndicator(textView).setContent(sVar));
        String string2 = getContext().getString(R.string.widgets_tab_label);
        TextView textView2 = (TextView) this.f71a.inflate(R.layout.tab_widget_indicator, (ViewGroup) tabWidget, false);
        textView2.setWidth(150);
        textView2.setText(string2);
        textView2.setTextSize(20.0f);
        textView2.setContentDescription(string2);
        addTab(newTabSpec("WIDGETS").setIndicator(textView2).setContent(sVar));
        setOnTabChangedListener(this);
        w wVar = new w();
        tabWidget.getChildTabViewAt(tabWidget.getTabCount() - 1).setOnKeyListener(wVar);
        findViewById(R.id.market_button).setOnKeyListener(wVar);
        this.c.setAlpha(0.0f);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.g && this.h) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        boolean z = this.b.getLayoutParams().width <= 0;
        super.onMeasure(i, i2);
        if (z) {
            int pageContentWidth = this.d.getPageContentWidth();
            if (pageContentWidth > 0 && this.b.getLayoutParams().width != pageContentWidth) {
                this.b.getLayoutParams().width = pageContentWidth;
                this.j.run();
            }
            super.onMeasure(i, i2);
        }
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    public void onTabChanged(String str) {
        com.syu.g.i.a().a("onTabChanged");
        post(new t(this, a(str), getResources().getInteger(R.integer.config_tabTransitionDuration)));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!(this.g && this.h) && motionEvent.getY() < this.d.getBottom()) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    void setContentTypeImmediate(q qVar) {
        setOnTabChangedListener(null);
        e();
        b(qVar);
        setCurrentTabByTag(a(qVar));
        setOnTabChangedListener(this);
    }

    public void setCurrentTabFromContent(q qVar) {
        setOnTabChangedListener(null);
        setCurrentTabByTag(a(qVar));
        setOnTabChangedListener(this);
    }

    @Override // com.android.launcher6.dy
    public void setInsets(Rect rect) {
        this.k.set(rect);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f.getLayoutParams();
        layoutParams.topMargin = rect.top;
        layoutParams.bottomMargin = rect.bottom;
        layoutParams.leftMargin = rect.left;
        layoutParams.rightMargin = rect.right;
        this.f.setLayoutParams(layoutParams);
    }
}
