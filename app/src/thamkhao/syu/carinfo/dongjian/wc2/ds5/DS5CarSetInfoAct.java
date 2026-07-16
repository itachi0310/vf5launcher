package com.syu.carinfo.dongjian.wc2.ds5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class DS5CarSetInfoAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dongjian.wc2.ds5.DS5CarSetInfoAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 104:
                    DS5CarSetInfoAct.this.updaterAutozhuche();
                    break;
                case 105:
                    DS5CarSetInfoAct.this.updaterRearYugua();
                    break;
                case 106:
                    DS5CarSetInfoAct.this.updaterzhucheHelp();
                    break;
                case 107:
                    DS5CarSetInfoAct.this.updaterdoorautolock();
                    break;
                case 108:
                    DS5CarSetInfoAct.this.updaterdoorlock();
                    break;
                case 109:
                    DS5CarSetInfoAct.this.updaterdoorUnlock();
                    break;
                case 110:
                    DS5CarSetInfoAct.this.updaterdaylight();
                    break;
                case 111:
                    DS5CarSetInfoAct.this.updaterdadenglater();
                    break;
                case 112:
                    DS5CarSetInfoAct.this.updatersuidongdadeng();
                    break;
                case 113:
                    DS5CarSetInfoAct.this.updaterzhucheHelpSystem();
                    break;
                case 114:
                    DS5CarSetInfoAct.this.updateryingbinLight();
                    break;
                case 115:
                    DS5CarSetInfoAct.this.updatercarspeedsaveState();
                    break;
                case 116:
                    DS5CarSetInfoAct.this.updatercarspeedM1saveState();
                    break;
                case 117:
                    DS5CarSetInfoAct.this.updatercarspeedM2saveState();
                    break;
                case 118:
                    DS5CarSetInfoAct.this.updatercarspeedM3saveState();
                    break;
                case 119:
                    DS5CarSetInfoAct.this.updatercarspeedM4saveState();
                    break;
                case 120:
                    DS5CarSetInfoAct.this.updatercarspeedM5saveState();
                    break;
                case 121:
                    DS5CarSetInfoAct.this.updatercarspeedM1();
                    break;
                case 122:
                    DS5CarSetInfoAct.this.updatercarspeedM2();
                    break;
                case 123:
                    DS5CarSetInfoAct.this.updatercarspeedM3();
                    break;
                case 124:
                    DS5CarSetInfoAct.this.updatercarspeedM4();
                    break;
                case 125:
                    DS5CarSetInfoAct.this.updatercarspeedM5();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_302_dongjian_wc2_ds5_car_set_info);
        init();
        setUI();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    public void setUI() {
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_auto_zhuche_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_rear_yugua_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_zhuche_help_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_door_auto_lock_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_door_lock_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_door_unlock_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_rijian_xingchedeng_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_suidong_dadeng_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_zhuche_help_system_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_car_speed_save_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_car_speed_save_m1_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_car_speed_save_m2_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_car_speed_save_m3_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_car_speed_save_m4_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_car_speed_save_m5_check)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_dadeng_later_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_dadeng_later_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_yingbin_dadeng_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_yingbin_dadeng_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_car_speed_M1_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_car_speed_M1_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_car_speed_M2_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_car_speed_M2_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_car_speed_M3_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_car_speed_M3_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_car_speed_M4_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_car_speed_M4_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_car_speed_M5_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_car_speed_M5_next)).setOnClickListener(this);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAutozhuche() {
        int autozhucheValue = DataCanbus.DATA[104];
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_auto_zhuche_check)).setChecked(autozhucheValue != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRearYugua() {
        int rearYuguaValue = DataCanbus.DATA[105];
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_rear_yugua_check)).setChecked(rearYuguaValue != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterzhucheHelp() {
        int zhucheHelpValue = DataCanbus.DATA[106];
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_zhuche_help_check)).setChecked(zhucheHelpValue != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterdoorautolock() {
        int doorAutoLockValue = DataCanbus.DATA[107];
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_door_auto_lock_check)).setChecked(doorAutoLockValue != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterdoorlock() {
        int doorLockValue = DataCanbus.DATA[108];
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_door_lock_check)).setChecked(doorLockValue != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterdoorUnlock() {
        int doorUnlockValue = DataCanbus.DATA[109];
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_door_unlock_check)).setChecked(doorUnlockValue != 0);
        if (doorUnlockValue == 0) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_door_unlock_tv)).setText(R.string.wc_ruiteng_string_unlock_mode_0);
        } else if (doorUnlockValue == 1) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_door_unlock_tv)).setText(R.string.wc_ruiteng_string_unlock_mode_1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterdaylight() {
        int dayLightValue = DataCanbus.DATA[110];
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_rijian_xingchedeng_check)).setChecked(dayLightValue != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterdadenglater() {
        int dadengLaterValue = DataCanbus.DATA[111];
        if (dadengLaterValue == 0) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_dadeng_later_TV)).setText(R.string.off);
            return;
        }
        if (dadengLaterValue == 1) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_dadeng_later_TV)).setText(R.string.str_dongjian_wc2_dadeng_later_15s);
        } else if (dadengLaterValue == 2) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_dadeng_later_TV)).setText(R.string.klc_light_Lasuo_headlight_delay_1);
        } else if (dadengLaterValue == 3) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_dadeng_later_TV)).setText(R.string.klc_light_Lasuo_headlight_delay_2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatersuidongdadeng() {
        int suidongdadengValue = DataCanbus.DATA[112];
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_suidong_dadeng_check)).setChecked(suidongdadengValue != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterzhucheHelpSystem() {
        int zhucheHelpSystemValue = DataCanbus.DATA[113];
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_zhuche_help_system_check)).setChecked(zhucheHelpSystemValue != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateryingbinLight() {
        int yingbindadengValue = DataCanbus.DATA[114];
        if (yingbindadengValue == 0) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_yingbin_dadeng_TV)).setText(R.string.off);
            return;
        }
        if (yingbindadengValue == 1) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_yingbin_dadeng_TV)).setText(R.string.str_dongjian_wc2_dadeng_later_15s);
        } else if (yingbindadengValue == 2) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_yingbin_dadeng_TV)).setText(R.string.klc_light_Lasuo_headlight_delay_1);
        } else if (yingbindadengValue == 3) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_yingbin_dadeng_TV)).setText(R.string.klc_light_Lasuo_headlight_delay_2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatercarspeedsaveState() {
        int carSpeedStatevalue = DataCanbus.DATA[115];
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_car_speed_save_check)).setChecked(carSpeedStatevalue != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatercarspeedM1saveState() {
        int carSpeedM1StateValue = DataCanbus.DATA[116];
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_car_speed_save_m1_check)).setChecked(carSpeedM1StateValue != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatercarspeedM2saveState() {
        int carSpeedM2StateValue = DataCanbus.DATA[117];
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_car_speed_save_m2_check)).setChecked(carSpeedM2StateValue != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatercarspeedM3saveState() {
        int carSpeedM3StateValue = DataCanbus.DATA[118];
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_car_speed_save_m3_check)).setChecked(carSpeedM3StateValue != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatercarspeedM4saveState() {
        int carSpeedM4StateValue = DataCanbus.DATA[119];
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_car_speed_save_m4_check)).setChecked(carSpeedM4StateValue != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatercarspeedM5saveState() {
        int carSpeedM5StateValue = DataCanbus.DATA[120];
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_car_speed_save_m5_check)).setChecked(carSpeedM5StateValue != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatercarspeedM1() {
        int carSpeedM1Value = DataCanbus.DATA[121];
        ((TextView) findViewById(R.id.dongjian_wc2_ds5_car_speed_M1_TV)).setText(carSpeedM1Value + "km/h");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatercarspeedM2() {
        int carSpeedM2Value = DataCanbus.DATA[122];
        ((TextView) findViewById(R.id.dongjian_wc2_ds5_car_speed_M2_TV)).setText(carSpeedM2Value + "km/h");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatercarspeedM3() {
        int carSpeedM3Value = DataCanbus.DATA[123];
        ((TextView) findViewById(R.id.dongjian_wc2_ds5_car_speed_M3_TV)).setText(carSpeedM3Value + "km/h");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatercarspeedM4() {
        int carSpeedM4Value = DataCanbus.DATA[124];
        ((TextView) findViewById(R.id.dongjian_wc2_ds5_car_speed_M4_TV)).setText(carSpeedM4Value + "km/h");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatercarspeedM5() {
        int carSpeedM5Value = DataCanbus.DATA[125];
        ((TextView) findViewById(R.id.dongjian_wc2_ds5_car_speed_M5_TV)).setText(carSpeedM5Value + "km/h");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dongjian_wc2_ds5_auto_zhuche_check /* 2131429188 */:
                DS5Func.C_CAR_COMPUTER_SET(8, DataCanbus.DATA[104] != 0 ? 0 : 1);
                break;
            case R.id.dongjian_wc2_ds5_rear_yugua_check /* 2131429189 */:
                DS5Func.C_CAR_COMPUTER_SET(1, DataCanbus.DATA[105] == 0 ? 1 : 0);
                break;
            case R.id.dongjian_wc2_ds5_zhuche_help_check /* 2131429190 */:
                DS5Func.C_CAR_COMPUTER_SET(2, DataCanbus.DATA[106] != 0 ? 0 : 1);
                break;
            case R.id.dongjian_wc2_ds5_door_unlock_check /* 2131429193 */:
                DS5Func.C_CAR_COMPUTER_SET(4, DataCanbus.DATA[109] != 0 ? 0 : 1);
                break;
            case R.id.dongjian_wc2_ds5_rijian_xingchedeng_check /* 2131429195 */:
                DS5Func.C_CAR_COMPUTER_SET(5, DataCanbus.DATA[110] != 0 ? 0 : 1);
                break;
            case R.id.dongjian_wc2_ds5_dadeng_later_pre /* 2131429196 */:
                if (DataCanbus.DATA[111] == 0) {
                    DS5Func.C_CAR_COMPUTER_SET(6, 3);
                } else if (DataCanbus.DATA[111] == 1) {
                    DS5Func.C_CAR_COMPUTER_SET(6, 0);
                } else if (DataCanbus.DATA[111] == 2) {
                    DS5Func.C_CAR_COMPUTER_SET(6, 1);
                } else if (DataCanbus.DATA[111] == 3) {
                    DS5Func.C_CAR_COMPUTER_SET(6, 2);
                }
                break;
            case R.id.dongjian_wc2_ds5_dadeng_later_next /* 2131429198 */:
                if (DataCanbus.DATA[111] == 0) {
                    DS5Func.C_CAR_COMPUTER_SET(6, 1);
                } else if (DataCanbus.DATA[111] == 1) {
                    DS5Func.C_CAR_COMPUTER_SET(6, 2);
                } else if (DataCanbus.DATA[111] == 2) {
                    DS5Func.C_CAR_COMPUTER_SET(6, 3);
                } else if (DataCanbus.DATA[111] == 3) {
                    DS5Func.C_CAR_COMPUTER_SET(6, 0);
                }
                break;
            case R.id.dongjian_wc2_ds5_suidong_dadeng_check /* 2131429199 */:
                DS5Func.C_CAR_COMPUTER_SET(128, DataCanbus.DATA[112] != 0 ? 0 : 1);
                break;
            case R.id.dongjian_wc2_zhuche_help_system_check /* 2131429200 */:
                DS5Func.C_CAR_COMPUTER_SET(130, DataCanbus.DATA[113] != 0 ? 0 : 1);
                break;
            case R.id.dongjian_wc2_ds5_yingbin_dadeng_pre /* 2131429201 */:
                if (DataCanbus.DATA[114] == 0) {
                    DS5Func.C_CAR_COMPUTER_SET(129, 3);
                } else if (DataCanbus.DATA[114] == 1) {
                    DS5Func.C_CAR_COMPUTER_SET(129, 0);
                } else if (DataCanbus.DATA[114] == 2) {
                    DS5Func.C_CAR_COMPUTER_SET(129, 1);
                } else if (DataCanbus.DATA[114] == 3) {
                    DS5Func.C_CAR_COMPUTER_SET(129, 2);
                }
                break;
            case R.id.dongjian_wc2_ds5_yingbin_dadeng_next /* 2131429203 */:
                if (DataCanbus.DATA[114] == 0) {
                    DS5Func.C_CAR_COMPUTER_SET(129, 1);
                } else if (DataCanbus.DATA[114] == 1) {
                    DS5Func.C_CAR_COMPUTER_SET(129, 2);
                } else if (DataCanbus.DATA[114] == 2) {
                    DS5Func.C_CAR_COMPUTER_SET(129, 3);
                } else if (DataCanbus.DATA[114] == 3) {
                    DS5Func.C_CAR_COMPUTER_SET(129, 0);
                }
                break;
            case R.id.dongjian_wc2_car_speed_save_check /* 2131429204 */:
                DS5Func.C_CAR_COMPUTER_SET(144, DataCanbus.DATA[115] != 0 ? 0 : 1);
                break;
            case R.id.dongjian_wc2_car_speed_save_m1_check /* 2131429205 */:
                DS5Func.C_CAR_COMPUTER_SET(145, DataCanbus.DATA[116] != 0 ? 0 : 1);
                break;
            case R.id.dongjian_wc2_car_speed_save_m2_check /* 2131429206 */:
                DS5Func.C_CAR_COMPUTER_SET(146, DataCanbus.DATA[117] != 0 ? 0 : 1);
                break;
            case R.id.dongjian_wc2_car_speed_save_m3_check /* 2131429207 */:
                DS5Func.C_CAR_COMPUTER_SET(147, DataCanbus.DATA[118] != 0 ? 0 : 1);
                break;
            case R.id.dongjian_wc2_car_speed_save_m4_check /* 2131429208 */:
                DS5Func.C_CAR_COMPUTER_SET(148, DataCanbus.DATA[119] != 0 ? 0 : 1);
                break;
            case R.id.dongjian_wc2_car_speed_save_m5_check /* 2131429209 */:
                DS5Func.C_CAR_COMPUTER_SET(149, DataCanbus.DATA[120] != 0 ? 0 : 1);
                break;
            case R.id.dongjian_wc2_ds5_car_speed_M1_pre /* 2131429210 */:
                if (DataCanbus.DATA[121] - 1 > 40) {
                    DS5Func.C_CAR_COMPUTER_SET(161, DataCanbus.DATA[121] - 1);
                }
                break;
            case R.id.dongjian_wc2_ds5_car_speed_M1_next /* 2131429212 */:
                if (DataCanbus.DATA[121] + 1 < 180) {
                    DS5Func.C_CAR_COMPUTER_SET(161, DataCanbus.DATA[121] + 1);
                }
                break;
            case R.id.dongjian_wc2_ds5_car_speed_M2_pre /* 2131429213 */:
                if (DataCanbus.DATA[122] - 1 > 40) {
                    DS5Func.C_CAR_COMPUTER_SET(162, DataCanbus.DATA[122] - 1);
                }
                break;
            case R.id.dongjian_wc2_ds5_car_speed_M2_next /* 2131429215 */:
                if (DataCanbus.DATA[122] + 1 < 180) {
                    DS5Func.C_CAR_COMPUTER_SET(162, DataCanbus.DATA[122] + 1);
                }
                break;
            case R.id.dongjian_wc2_ds5_car_speed_M3_pre /* 2131429216 */:
                if (DataCanbus.DATA[123] - 1 > 40) {
                    DS5Func.C_CAR_COMPUTER_SET(163, DataCanbus.DATA[123] - 1);
                }
                break;
            case R.id.dongjian_wc2_ds5_car_speed_M3_next /* 2131429218 */:
                if (DataCanbus.DATA[123] + 1 < 180) {
                    DS5Func.C_CAR_COMPUTER_SET(163, DataCanbus.DATA[123] + 1);
                }
                break;
            case R.id.dongjian_wc2_ds5_car_speed_M4_pre /* 2131429219 */:
                if (DataCanbus.DATA[124] - 1 > 40) {
                    DS5Func.C_CAR_COMPUTER_SET(164, DataCanbus.DATA[124] - 1);
                }
                break;
            case R.id.dongjian_wc2_ds5_car_speed_M4_next /* 2131429221 */:
                if (DataCanbus.DATA[124] + 1 < 180) {
                    DS5Func.C_CAR_COMPUTER_SET(164, DataCanbus.DATA[124] + 1);
                }
                break;
            case R.id.dongjian_wc2_ds5_car_speed_M5_pre /* 2131429222 */:
                if (DataCanbus.DATA[125] - 1 > 40) {
                    DS5Func.C_CAR_COMPUTER_SET(165, DataCanbus.DATA[125] - 1);
                }
                break;
            case R.id.dongjian_wc2_ds5_car_speed_M5_next /* 2131429224 */:
                if (DataCanbus.DATA[125] + 1 < 180) {
                    DS5Func.C_CAR_COMPUTER_SET(165, DataCanbus.DATA[125] + 1);
                }
                break;
        }
    }
}
