package com.syu.carinfo.ford;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class MustangCarCDAct extends Activity implements View.OnTouchListener {
    public static MustangCarCDAct mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.ford.MustangCarCDAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 185:
                case 186:
                    MustangCarCDAct.this.updaterTrackInfo();
                    break;
                case 187:
                case 188:
                    MustangCarCDAct.this.updaterTimeInfo();
                    break;
                case 189:
                    if (((TextView) MustangCarCDAct.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) MustangCarCDAct.this.findViewById(R.id.tv_text6)).setText(R.string.jeep_playstate1);
                                break;
                            case 2:
                                ((TextView) MustangCarCDAct.this.findViewById(R.id.tv_text6)).setText(R.string.str_sbd_x80_media_state_10);
                                break;
                            case 3:
                                ((TextView) MustangCarCDAct.this.findViewById(R.id.tv_text6)).setText(R.string.jeep_playstate5);
                                break;
                            case 255:
                                ((TextView) MustangCarCDAct.this.findViewById(R.id.tv_text6)).setText(R.string.jeep_playstate9);
                                break;
                            default:
                                ((TextView) MustangCarCDAct.this.findViewById(R.id.tv_text6)).setText("");
                                break;
                        }
                    }
                    break;
                case 190:
                    if (((TextView) MustangCarCDAct.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) MustangCarCDAct.this.findViewById(R.id.tv_text5)).setText(R.string.jeep_playstate2);
                                break;
                            default:
                                ((TextView) MustangCarCDAct.this.findViewById(R.id.tv_text5)).setText(R.string.jeep_playstate6);
                                break;
                        }
                    }
                    break;
                case 191:
                    MustangCarCDAct.this.findViewById(R.id.lexus_cd_rpt).setBackgroundResource(value == 0 ? R.drawable.ic_lexus_cd_rpt_n : R.drawable.ic_lexus_cd_rpt_p);
                    break;
                case 192:
                    MustangCarCDAct.this.findViewById(R.id.lexus_cd_random).setBackgroundResource(value == 0 ? R.drawable.ic_lexus_cd_random_n : R.drawable.ic_lexus_cd_random_p);
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0334_rzc_mustang_carcd);
        mInstance = this;
        init();
    }

    public void init() {
        findViewById(R.id.lexus_cd_rpt).setOnTouchListener(this);
        findViewById(R.id.lexus_cd_random).setOnTouchListener(this);
        findViewById(R.id.lexus_cd_prev).setOnTouchListener(this);
        findViewById(R.id.lexus_cd_skipb).setOnTouchListener(this);
        findViewById(R.id.lexus_cd_play).setOnTouchListener(this);
        findViewById(R.id.lexus_cd_pause).setOnTouchListener(this);
        findViewById(R.id.lexus_cd_skipf).setOnTouchListener(this);
        findViewById(R.id.lexus_cd_next).setOnTouchListener(this);
        findViewById(R.id.lexus_cd_eject).setOnTouchListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
        FuncMain.setChannel(11);
        DataCanbus.PROXY.cmd(6, new int[1], null, null);
        DataCanbus.PROXY.cmd(9, new int[]{169, 32}, null, null);
        DataCanbus.PROXY.cmd(9, new int[]{169, 0}, null, null);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[185].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[186].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[187].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[188].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[189].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[190].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[191].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[192].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[185].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[186].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[187].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[189].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[190].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[191].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[192].removeNotify(this.mNotifyCanbus);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.lexus_cd_rpt /* 2131427680 */:
                    if (DataCanbus.DATA[191] == 1) {
                        DataCanbus.PROXY.cmd(9, new int[]{169, 39}, null, null);
                    } else {
                        DataCanbus.PROXY.cmd(9, new int[]{169, 40}, null, null);
                    }
                    break;
                case R.id.lexus_cd_random /* 2131427681 */:
                    if (DataCanbus.DATA[192] == 1) {
                        DataCanbus.PROXY.cmd(9, new int[]{169, 37}, null, null);
                    } else {
                        DataCanbus.PROXY.cmd(9, new int[]{169, 38}, null, null);
                    }
                    break;
                case R.id.lexus_cd_prev /* 2131427861 */:
                    DataCanbus.PROXY.cmd(9, new int[]{169, 33}, null, null);
                    break;
                case R.id.lexus_cd_skipb /* 2131427862 */:
                    DataCanbus.PROXY.cmd(9, new int[]{169, 42}, null, null);
                    break;
                case R.id.lexus_cd_play /* 2131427863 */:
                    DataCanbus.PROXY.cmd(9, new int[]{169, 36}, null, null);
                    break;
                case R.id.lexus_cd_pause /* 2131427864 */:
                    DataCanbus.PROXY.cmd(9, new int[]{169, 35}, null, null);
                    break;
                case R.id.lexus_cd_skipf /* 2131427865 */:
                    DataCanbus.PROXY.cmd(9, new int[]{169, 43}, null, null);
                    break;
                case R.id.lexus_cd_next /* 2131427866 */:
                    DataCanbus.PROXY.cmd(9, new int[]{169, 34}, null, null);
                    break;
                case R.id.lexus_cd_eject /* 2131427867 */:
                    DataCanbus.PROXY.cmd(9, new int[]{169, 44}, null, null);
                    break;
            }
        } else if (event.getAction() == 1) {
            switch (v.getId()) {
                case R.id.lexus_cd_skipb /* 2131427862 */:
                    DataCanbus.PROXY.cmd(9, new int[]{169, 0}, null, null);
                    break;
                case R.id.lexus_cd_play /* 2131427863 */:
                case R.id.lexus_cd_pause /* 2131427864 */:
                default:
                    DataCanbus.PROXY.cmd(9, new int[]{169, 0}, null, null);
                    break;
                case R.id.lexus_cd_skipf /* 2131427865 */:
                    DataCanbus.PROXY.cmd(9, new int[]{169, 0}, null, null);
                    break;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTimeInfo() {
        int Hour = (DataCanbus.DATA[187] >> 16) & 255;
        int Minute = (DataCanbus.DATA[187] >> 8) & 255;
        int Sec = DataCanbus.DATA[187] & 255;
        int Hour1 = (DataCanbus.DATA[188] >> 16) & 255;
        int Minute1 = (DataCanbus.DATA[188] >> 8) & 255;
        int Sec1 = DataCanbus.DATA[188] & 255;
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            ((TextView) findViewById(R.id.tv_text2)).setText((Hour / 10) + (Hour % 10) + ":" + (Minute / 10) + (Minute % 10) + ":" + (Sec / 10) + (Sec % 10) + " / " + (Hour1 / 10) + (Hour1 % 10) + ":" + (Minute1 / 10) + (Minute1 % 10) + ":" + (Sec1 / 10) + (Sec1 % 10));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTrackInfo() {
        int value = DataCanbus.DATA[185];
        int value1 = DataCanbus.DATA[186];
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            ((TextView) findViewById(R.id.tv_text1)).setText("Track:" + value + "/" + value1);
        }
    }
}
