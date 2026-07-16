package com.syu.carinfo.wc.ruijie15;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

/* JADX INFO: loaded from: classes.dex */
public class LZBinliTianyueAirControlAct extends Activity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.ruijie15.LZBinliTianyueAirControlAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int i = R.drawable.ic_xts_mode_foot_n;
            int i2 = R.drawable.ic_xts_mode_body_n;
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 8:
                    LZBinliTianyueAirControlAct.this.mUpdatePowerOn();
                    break;
                case 9:
                    LZBinliTianyueAirControlAct.this.mUpdateAcOn();
                    break;
                case 10:
                    LZBinliTianyueAirControlAct.this.mUpdateCycle();
                    break;
                case 11:
                    LZBinliTianyueAirControlAct.this.mUpdateAutoOn();
                    break;
                case 12:
                    if (LZBinliTianyueAirControlAct.this.findViewById(R.id.air_xts_auto_right) != null) {
                        LZBinliTianyueAirControlAct.this.findViewById(R.id.air_xts_auto_right).setBackgroundResource(value == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
                    }
                    break;
                case 13:
                    LZBinliTianyueAirControlAct.this.mUpdateDualOn();
                    break;
                case 14:
                    LZBinliTianyueAirControlAct.this.mUpdateFrontDefrost();
                    break;
                case 15:
                    LZBinliTianyueAirControlAct.this.mUpdateRearDefrost();
                    break;
                case 16:
                    if (LZBinliTianyueAirControlAct.this.findViewById(R.id.air_xts_mode_win) != null) {
                        LZBinliTianyueAirControlAct.this.findViewById(R.id.air_xts_mode_win).setBackgroundResource(value == 0 ? R.drawable.ic_xts_mode_win_n : R.drawable.ic_xts_mode_win_p);
                    }
                    break;
                case 17:
                    if (LZBinliTianyueAirControlAct.this.findViewById(R.id.air_xts_mode_body) != null) {
                        LZBinliTianyueAirControlAct.this.findViewById(R.id.air_xts_mode_body).setBackgroundResource(value == 0 ? R.drawable.ic_xts_mode_body_n : R.drawable.ic_xts_mode_body_p);
                    }
                    break;
                case 18:
                    if (LZBinliTianyueAirControlAct.this.findViewById(R.id.air_xts_mode_foot) != null) {
                        View viewFindViewById = LZBinliTianyueAirControlAct.this.findViewById(R.id.air_xts_mode_foot);
                        if (value != 0) {
                            i = R.drawable.ic_xts_mode_foot_p;
                        }
                        viewFindViewById.setBackgroundResource(i);
                    }
                    break;
                case 20:
                    LZBinliTianyueAirControlAct.this.mUpdaterAirWindLevelLeft();
                    break;
                case 21:
                    LZBinliTianyueAirControlAct.this.mUpdateAirTempLeft();
                    break;
                case 22:
                    LZBinliTianyueAirControlAct.this.mUpdateAirTempRight();
                    break;
                case 23:
                    LZBinliTianyueAirControlAct.this.mUpdateMaxAcOn();
                    break;
                case 26:
                    LZBinliTianyueAirControlAct.this.mUpdateAirTempLeft();
                    LZBinliTianyueAirControlAct.this.mUpdateAirTempRight();
                    break;
                case 27:
                    switch (value) {
                        case 0:
                            LZBinliTianyueAirControlAct.this.findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level0);
                            break;
                        case 1:
                            LZBinliTianyueAirControlAct.this.findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level1);
                            break;
                        case 2:
                            LZBinliTianyueAirControlAct.this.findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level2);
                            break;
                        case 3:
                            LZBinliTianyueAirControlAct.this.findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level3);
                            break;
                    }
                    break;
                case 28:
                    switch (value) {
                        case 0:
                            LZBinliTianyueAirControlAct.this.findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level0);
                            break;
                        case 1:
                            LZBinliTianyueAirControlAct.this.findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level1);
                            break;
                        case 2:
                            LZBinliTianyueAirControlAct.this.findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level2);
                            break;
                        case 3:
                            LZBinliTianyueAirControlAct.this.findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level3);
                            break;
                    }
                    break;
                case 29:
                    if (LZBinliTianyueAirControlAct.this.findViewById(R.id.air_xts_mode_win_right) != null) {
                        LZBinliTianyueAirControlAct.this.findViewById(R.id.air_xts_mode_win_right).setBackgroundResource(value == 0 ? R.drawable.ic_xts_mode_win_n : R.drawable.ic_xts_mode_win_p);
                    }
                    break;
                case 30:
                    if (LZBinliTianyueAirControlAct.this.findViewById(R.id.air_xts_mode_body_right) != null) {
                        View viewFindViewById2 = LZBinliTianyueAirControlAct.this.findViewById(R.id.air_xts_mode_body_right);
                        if (value != 0) {
                            i2 = R.drawable.ic_xts_mode_body_p;
                        }
                        viewFindViewById2.setBackgroundResource(i2);
                    }
                    break;
                case 31:
                    if (LZBinliTianyueAirControlAct.this.findViewById(R.id.air_xts_mode_foot_right) != null) {
                        View viewFindViewById3 = LZBinliTianyueAirControlAct.this.findViewById(R.id.air_xts_mode_foot_right);
                        if (value != 0) {
                            i = R.drawable.ic_xts_mode_foot_p;
                        }
                        viewFindViewById3.setBackgroundResource(i);
                    }
                    break;
                case 33:
                    LZBinliTianyueAirControlAct.this.mUpdaterAirWindLevelRight();
                    break;
            }
        }
    };

    private void sendCmd(int data0, int data1) {
        DataCanbus.PROXY.cmd(0, new int[]{data0, data1}, null, null);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_lz_binli_tianyue_air_control);
        init();
    }

    private void init() {
        findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        findViewById(R.id.air_xts_cycle).setOnTouchListener(this);
        findViewById(R.id.air_xts_sync).setOnTouchListener(this);
        findViewById(R.id.air_xts_ac).setOnTouchListener(this);
        findViewById(R.id.air_xts_maxac).setOnTouchListener(this);
        findViewById(R.id.air_xts_auto_right).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_front).setOnTouchListener(this);
        findViewById(R.id.air_xts_rear).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn_right).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn_right).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_foot).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_body).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_win).setOnTouchListener(this);
        findViewById(R.id.air_xts_seathot_left).setOnTouchListener(this);
        findViewById(R.id.air_xts_seathot_right).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_foot_right).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_body_right).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_win_right).setOnTouchListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        DataCanbus.PROXY.cmd(1, new int[]{3}, null, null);
        addUpdater();
        AirHelper.disableAirWindowLocal(true);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        AirHelper.disableAirWindowLocal(false);
        removeUpdater();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int data0 = 0;
        boolean flag = false;
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                data0 = 1;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                data0 = 2;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                data0 = 15;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                data0 = 14;
                break;
            case R.id.air_xts_seathot_left /* 2131427433 */:
            case R.id.air_xts_seathot_right /* 2131427435 */:
                flag = true;
                try {
                    startActivity(new Intent(this, (Class<?>) LZBinliTianyueSeatControlAct.class));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                data0 = 11;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                data0 = 7;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                data0 = 9;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                data0 = 5;
                break;
            case R.id.air_xts_maxac /* 2131427440 */:
                data0 = 6;
                break;
            case R.id.air_xts_sync /* 2131427441 */:
                data0 = 8;
                break;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                data0 = 19;
                break;
            case R.id.air_xts_mode_body /* 2131427444 */:
                data0 = 18;
                break;
            case R.id.air_xts_mode_win /* 2131427445 */:
                data0 = 17;
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                data0 = 3;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                data0 = 4;
                break;
            case R.id.air_xts_rear /* 2131427565 */:
                data0 = 10;
                break;
            case R.id.air_xts_mode_win_right /* 2131428593 */:
                data0 = 24;
                break;
            case R.id.air_xts_mode_body_right /* 2131428594 */:
                data0 = 25;
                break;
            case R.id.air_xts_mode_foot_right /* 2131428595 */:
                data0 = 26;
                break;
            case R.id.air_xts_auto_right /* 2131428601 */:
                data0 = 12;
                break;
            case R.id.dj_xts_air_win_plus_btn_right /* 2131428635 */:
                data0 = 21;
                break;
            case R.id.dj_xts_air_win_minuts_btn_right /* 2131428637 */:
                data0 = 22;
                break;
        }
        if (event.getAction() == 0 && !flag) {
            sendCmd(20, data0);
            return false;
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateMaxAcOn() {
        int power = DataCanbus.DATA[23];
        findViewById(R.id.air_xts_maxac).setBackgroundResource(power == 0 ? R.drawable.ic_xts_maxac_n : R.drawable.ic_xts_maxac_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirTempLeft() {
        int unit = DataCanbus.DATA[26];
        int temp = DataCanbus.DATA[21];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("High");
                return;
            }
            if (temp == -1) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("None");
            } else if (unit == 0) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp * 0.5f) + "℃");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText((((temp * 9) / 10) + 32) + "℉");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirTempRight() {
        int unit = DataCanbus.DATA[26];
        int temp = DataCanbus.DATA[22];
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("High");
                return;
            }
            if (temp == -1) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("None");
            } else if (unit == 0) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp * 0.5f) + "℃");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText((((temp * 9) / 10) + 32) + "℉");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAutoOn() {
        int acOn = DataCanbus.DATA[11];
        if (findViewById(R.id.air_xts_auto) != null) {
            findViewById(R.id.air_xts_auto).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateDualOn() {
        int acOn = DataCanbus.DATA[13];
        if (findViewById(R.id.air_xts_sync) != null) {
            findViewById(R.id.air_xts_sync).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_sync_n : R.drawable.ic_xts_sync_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[9];
        if (findViewById(R.id.air_xts_ac) != null) {
            findViewById(R.id.air_xts_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatePowerOn() {
        int power = DataCanbus.DATA[8];
        if (findViewById(R.id.air_xts_power) != null) {
            findViewById(R.id.air_xts_power).setBackgroundResource(power == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[10];
        if (findViewById(R.id.air_xts_cycle) != null) {
            if (cycle == 0) {
                findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_n);
            } else if (cycle == 1) {
                findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_p);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateFrontDefrost() {
        int front = DataCanbus.DATA[14];
        if (findViewById(R.id.air_xts_front) != null) {
            findViewById(R.id.air_xts_front).setBackgroundResource(front == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateRearDefrost() {
        int rear = DataCanbus.DATA[15];
        if (findViewById(R.id.air_xts_rear) != null) {
            findViewById(R.id.air_xts_rear).setBackgroundResource(rear == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[20];
        switch (leave) {
            case 0:
                findViewById(R.id.air_xts_fan).setBackgroundResource(R.drawable.ic_xts_fan_0);
                break;
            case 1:
                findViewById(R.id.air_xts_fan).setBackgroundResource(R.drawable.ic_xts_fan_1);
                break;
            case 2:
                findViewById(R.id.air_xts_fan).setBackgroundResource(R.drawable.ic_xts_fan_2);
                break;
            case 3:
                findViewById(R.id.air_xts_fan).setBackgroundResource(R.drawable.ic_xts_fan_3);
                break;
            case 4:
                findViewById(R.id.air_xts_fan).setBackgroundResource(R.drawable.ic_xts_fan_4);
                break;
            case 5:
                findViewById(R.id.air_xts_fan).setBackgroundResource(R.drawable.ic_xts_fan_5);
                break;
            case 6:
                findViewById(R.id.air_xts_fan).setBackgroundResource(R.drawable.ic_xts_fan_6);
                break;
            case 7:
                findViewById(R.id.air_xts_fan).setBackgroundResource(R.drawable.ic_xts_fan_7);
                break;
            case 8:
                findViewById(R.id.air_xts_fan).setBackgroundResource(R.drawable.ic_xts_fan_8);
                break;
            case 9:
                findViewById(R.id.air_xts_fan).setBackgroundResource(R.drawable.ic_xts_fan_9);
                break;
            case 10:
                findViewById(R.id.air_xts_fan).setBackgroundResource(R.drawable.ic_xts_fan_10);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirWindLevelRight() {
        int leave = DataCanbus.DATA[33];
        switch (leave) {
            case 0:
                findViewById(R.id.air_xts_fan_right).setBackgroundResource(R.drawable.ic_xts_fan_0);
                break;
            case 1:
                findViewById(R.id.air_xts_fan_right).setBackgroundResource(R.drawable.ic_xts_fan_1);
                break;
            case 2:
                findViewById(R.id.air_xts_fan_right).setBackgroundResource(R.drawable.ic_xts_fan_2);
                break;
            case 3:
                findViewById(R.id.air_xts_fan_right).setBackgroundResource(R.drawable.ic_xts_fan_3);
                break;
            case 4:
                findViewById(R.id.air_xts_fan_right).setBackgroundResource(R.drawable.ic_xts_fan_4);
                break;
            case 5:
                findViewById(R.id.air_xts_fan_right).setBackgroundResource(R.drawable.ic_xts_fan_5);
                break;
            case 6:
                findViewById(R.id.air_xts_fan_right).setBackgroundResource(R.drawable.ic_xts_fan_6);
                break;
            case 7:
                findViewById(R.id.air_xts_fan_right).setBackgroundResource(R.drawable.ic_xts_fan_7);
                break;
            case 8:
                findViewById(R.id.air_xts_fan_right).setBackgroundResource(R.drawable.ic_xts_fan_8);
                break;
            case 9:
                findViewById(R.id.air_xts_fan_right).setBackgroundResource(R.drawable.ic_xts_fan_9);
                break;
            case 10:
                findViewById(R.id.air_xts_fan_right).setBackgroundResource(R.drawable.ic_xts_fan_10);
                break;
        }
    }
}
