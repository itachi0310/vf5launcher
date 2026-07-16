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
public class LZMustangCarCDAct extends Activity implements View.OnTouchListener {
    public static LZMustangCarCDAct mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.ford.LZMustangCarCDAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 125:
                    if (((TextView) LZMustangCarCDAct.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) LZMustangCarCDAct.this.findViewById(R.id.tv_text6)).setText(R.string.jeep_playstate1);
                                break;
                            case 2:
                                ((TextView) LZMustangCarCDAct.this.findViewById(R.id.tv_text6)).setText(R.string.str_167_playstate2);
                                break;
                            case 3:
                                ((TextView) LZMustangCarCDAct.this.findViewById(R.id.tv_text6)).setText(R.string.jeep_playstate5);
                                break;
                            case 4:
                                ((TextView) LZMustangCarCDAct.this.findViewById(R.id.tv_text6)).setText(R.string.str_167_playstate3);
                                break;
                            case 5:
                                ((TextView) LZMustangCarCDAct.this.findViewById(R.id.tv_text6)).setText("Reading OK");
                                break;
                            case 6:
                                ((TextView) LZMustangCarCDAct.this.findViewById(R.id.tv_text6)).setText("Reading error");
                                break;
                            default:
                                ((TextView) LZMustangCarCDAct.this.findViewById(R.id.tv_text6)).setText("");
                                break;
                        }
                    }
                    break;
                case 126:
                    if (((TextView) LZMustangCarCDAct.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) LZMustangCarCDAct.this.findViewById(R.id.tv_text5)).setText(R.string.str_car_cd_ff);
                                break;
                            case 2:
                                ((TextView) LZMustangCarCDAct.this.findViewById(R.id.tv_text5)).setText(R.string.str_car_cd_fb);
                                break;
                            case 3:
                                ((TextView) LZMustangCarCDAct.this.findViewById(R.id.tv_text5)).setText(R.string.crv_state_pause);
                                break;
                            case 4:
                                ((TextView) LZMustangCarCDAct.this.findViewById(R.id.tv_text5)).setText(R.string.crv_state_stop);
                                break;
                            case 5:
                                ((TextView) LZMustangCarCDAct.this.findViewById(R.id.tv_text5)).setText(R.string.str_sbd_x80_media_state_10);
                                break;
                            default:
                                ((TextView) LZMustangCarCDAct.this.findViewById(R.id.tv_text5)).setText(R.string.jeep_playstate2);
                                break;
                        }
                    }
                    break;
                case 127:
                    LZMustangCarCDAct.this.findViewById(R.id.lexus_cd_rpt).setBackgroundResource(value == 0 ? R.drawable.ic_lexus_cd_rpt_n : R.drawable.ic_lexus_cd_rpt_p);
                    break;
                case 128:
                    LZMustangCarCDAct.this.findViewById(R.id.lexus_cd_random).setBackgroundResource(value == 0 ? R.drawable.ic_lexus_cd_random_n : R.drawable.ic_lexus_cd_random_p);
                    break;
                case 130:
                case 131:
                    LZMustangCarCDAct.this.updaterTrackInfo();
                    break;
                case 132:
                case 133:
                    LZMustangCarCDAct.this.updaterTimeInfo();
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_lz_mustang_carcd);
        mInstance = this;
        init();
    }

    public void init() {
        findViewById(R.id.lexus_cd_rpt).setOnTouchListener(this);
        findViewById(R.id.lexus_cd_random).setOnTouchListener(this);
        findViewById(R.id.lexus_cd_prev).setOnTouchListener(this);
        findViewById(R.id.lexus_cd_skipb).setOnTouchListener(this);
        findViewById(R.id.lexus_cd_skipf).setOnTouchListener(this);
        findViewById(R.id.lexus_cd_next).setOnTouchListener(this);
        findViewById(R.id.lexus_cd_eject).setOnTouchListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
        FuncMain.setChannel(13);
        if (DataCanbus.DATA[134] != 2) {
            DataCanbus.PROXY.cmd(1, new int[]{176, 2}, null, null);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.lexus_cd_rpt /* 2131427680 */:
                    if (DataCanbus.DATA[127] == 1) {
                        DataCanbus.PROXY.cmd(2, new int[]{14, 1}, null, null);
                    } else {
                        DataCanbus.PROXY.cmd(2, new int[]{14, 0}, null, null);
                    }
                    break;
                case R.id.lexus_cd_random /* 2131427681 */:
                    if (DataCanbus.DATA[128] == 1) {
                        DataCanbus.PROXY.cmd(2, new int[]{14, 3}, null, null);
                    } else {
                        DataCanbus.PROXY.cmd(2, new int[]{14, 2}, null, null);
                    }
                    break;
                case R.id.lexus_cd_prev /* 2131427861 */:
                    DataCanbus.PROXY.cmd(2, new int[]{14, 7}, null, null);
                    break;
                case R.id.lexus_cd_skipb /* 2131427862 */:
                    DataCanbus.PROXY.cmd(2, new int[]{14, 9}, null, null);
                    break;
                case R.id.lexus_cd_skipf /* 2131427865 */:
                    DataCanbus.PROXY.cmd(2, new int[]{14, 8}, null, null);
                    break;
                case R.id.lexus_cd_next /* 2131427866 */:
                    DataCanbus.PROXY.cmd(2, new int[]{14, 6}, null, null);
                    break;
                case R.id.lexus_cd_eject /* 2131427867 */:
                    DataCanbus.PROXY.cmd(2, new int[]{14, 11}, null, null);
                    break;
            }
        } else if (event.getAction() == 1) {
            switch (v.getId()) {
                case R.id.lexus_cd_skipb /* 2131427862 */:
                    DataCanbus.PROXY.cmd(2, new int[]{14, 10}, null, null);
                    break;
                case R.id.lexus_cd_skipf /* 2131427865 */:
                    DataCanbus.PROXY.cmd(2, new int[]{14, 10}, null, null);
                    break;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTimeInfo() {
        int Minute = DataCanbus.DATA[132] & 255;
        int Sec = DataCanbus.DATA[133] & 255;
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(Minute / 10) + (Minute % 10) + ":" + (Sec / 10) + (Sec % 10));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTrackInfo() {
        int value = DataCanbus.DATA[130];
        int value1 = DataCanbus.DATA[131];
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            ((TextView) findViewById(R.id.tv_text1)).setText("Track: " + value + "/" + value1);
        }
    }
}
