package com.syu.carinfo.xp.ziyouguang;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;

/* JADX INFO: loaded from: classes.dex */
public class PAJeepGForceAct extends Activity implements View.OnTouchListener {
    int num = 0;
    Runnable mCalTime = new Runnable() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepGForceAct.1
        @Override // java.lang.Runnable
        public void run() {
            PAJeepGForceAct.this.num++;
            if (PAJeepGForceAct.this.num == 5) {
                DataCanbus.PROXY.cmd(10, new int[]{2, 0}, null, null);
                ((TextView) PAJeepGForceAct.this.findViewById(R.id.tv_text1)).setText(R.string.str_calibration);
            }
            HandlerUI.getInstance().removeCallbacks(PAJeepGForceAct.this.mCalTime);
            HandlerUI.getInstance().postDelayed(PAJeepGForceAct.this.mCalTime, 1000L);
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepGForceAct.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 223:
                    if ((value & 32768) != 0) {
                        ((TextView) PAJeepGForceAct.this.findViewById(R.id.tv_text6)).setText("L:" + (65536 - value) + "°");
                    } else if (value == 0) {
                        ((TextView) PAJeepGForceAct.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + "°");
                    } else {
                        ((TextView) PAJeepGForceAct.this.findViewById(R.id.tv_text6)).setText("R:" + value + "°");
                    }
                    break;
                case 277:
                    if ((value & 32768) != 0) {
                        int value2 = value - 65536;
                        ((PaJeepPitchView) PAJeepGForceAct.this.findViewById(R.id.infoView_pitch)).setSpeed(value2);
                        ((TextView) PAJeepGForceAct.this.findViewById(R.id.tv_text7)).setText(String.valueOf(-value2) + "°");
                    } else {
                        ((PaJeepPitchView) PAJeepGForceAct.this.findViewById(R.id.infoView_pitch)).setSpeed(value);
                        ((TextView) PAJeepGForceAct.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value) + "°");
                    }
                    break;
                case 278:
                    if ((value & 32768) != 0) {
                        int value3 = value - 65536;
                        ((PaJeepRollView) PAJeepGForceAct.this.findViewById(R.id.infoView_roll)).setSpeed(value3);
                        ((TextView) PAJeepGForceAct.this.findViewById(R.id.tv_text8)).setText(String.valueOf(-value3) + "°");
                    } else {
                        ((PaJeepRollView) PAJeepGForceAct.this.findViewById(R.id.infoView_roll)).setSpeed(value);
                        ((TextView) PAJeepGForceAct.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value) + "°");
                    }
                    break;
                case 359:
                    ((TextView) PAJeepGForceAct.this.findViewById(R.id.tv_text13)).setText(String.valueOf(value / 100) + "." + ((value % 100) / 10) + ((value % 100) % 10) + "g");
                    break;
                case 360:
                    ((TextView) PAJeepGForceAct.this.findViewById(R.id.tv_text16)).setText(String.valueOf(value / 100) + "." + ((value % 100) / 10) + ((value % 100) % 10) + "g");
                    break;
                case 361:
                    ((TextView) PAJeepGForceAct.this.findViewById(R.id.tv_text14)).setText(String.valueOf(value / 100) + "." + ((value % 100) / 10) + ((value % 100) % 10) + "g");
                    break;
                case 362:
                    ((TextView) PAJeepGForceAct.this.findViewById(R.id.tv_text15)).setText(String.valueOf(value / 100) + "." + ((value % 100) / 10) + ((value % 100) % 10) + "g");
                    break;
                case 363:
                    ((TextView) PAJeepGForceAct.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value / 100) + "." + ((value % 100) / 10) + ((value % 100) % 10) + "g");
                    break;
                case 364:
                    ((TextView) PAJeepGForceAct.this.findViewById(R.id.tv_text11)).setText(String.valueOf(value / 100) + "." + ((value % 100) / 10) + ((value % 100) % 10) + "g");
                    break;
                case 365:
                    ((TextView) PAJeepGForceAct.this.findViewById(R.id.tv_text5)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 371:
                    ((TextView) PAJeepGForceAct.this.findViewById(R.id.tv_text12)).setText(String.valueOf(value / 100) + "." + ((value % 100) / 10) + ((value % 100) % 10) + "g");
                    break;
                case 372:
                    ((TextView) PAJeepGForceAct.this.findViewById(R.id.tv_text10)).setText(String.valueOf(value / 100) + "." + ((value % 100) / 10) + ((value % 100) % 10) + "g");
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0374_pa_jeep_g_force);
        findViewById(R.id.infoView_pitch).setOnTouchListener(this);
        findViewById(R.id.infoView_roll).setOnTouchListener(this);
    }

    private void mUpdatermCalTime(boolean on) {
        if (on) {
            HandlerUI.getInstance().removeCallbacks(this.mCalTime);
            HandlerUI.getInstance().postDelayed(this.mCalTime, 1000L);
        } else {
            HandlerUI.getInstance().removeCallbacks(this.mCalTime);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x000f A[FALL_THROUGH, RETURN] */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r4, android.view.MotionEvent r5) {
        /*
            r3 = this;
            r1 = 1
            r2 = 0
            int r0 = r5.getAction()
            if (r0 != 0) goto L16
            int r0 = r4.getId()
            switch(r0) {
                case 2131428016: goto L10;
                case 2131428017: goto L10;
                default: goto Lf;
            }
        Lf:
            return r2
        L10:
            r3.num = r2
            r3.mUpdatermCalTime(r1)
            goto Lf
        L16:
            int r0 = r5.getAction()
            if (r0 != r1) goto Lf
            int r0 = r4.getId()
            switch(r0) {
                case 2131428016: goto L24;
                case 2131428017: goto L24;
                default: goto L23;
            }
        L23:
            goto Lf
        L24:
            r3.mUpdatermCalTime(r2)
            r0 = 2131427471(0x7f0b008f, float:1.847656E38)
            android.view.View r0 = r3.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = ""
            r0.setText(r1)
            r3.num = r2
            goto Lf
        */
        throw new UnsupportedOperationException("Method not decompiled: com.syu.carinfo.xp.ziyouguang.PAJeepGForceAct.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        DataCanbus.PROXY.cmd(4, new int[]{96}, null, null);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[359].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[360].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[361].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[362].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[363].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[364].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[371].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[372].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[365].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[223].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[277].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[278].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[359].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[360].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[361].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[362].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[363].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[364].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[371].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[372].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[365].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[223].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[277].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[278].removeNotify(this.mNotifyCanbus);
    }
}
