package com.syu.carinfo.sbd.ruifengs5;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes.dex */
public class ActivityTireRuiFengS5 extends BaseActivity {
    String mWarnStrs;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.sbd.ruifengs5.ActivityTireRuiFengS5.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 95:
                    ActivityTireRuiFengS5.this.updaterTempFL(value);
                    break;
                case 96:
                    ActivityTireRuiFengS5.this.updaterTempFR(value);
                    break;
                case 97:
                    ActivityTireRuiFengS5.this.updaterTempRL(value);
                    break;
                case 98:
                    ActivityTireRuiFengS5.this.updaterTempRR(value);
                    break;
                case 99:
                    ActivityTireRuiFengS5.this.mUpdaterTireFL(value);
                    break;
                case 100:
                    ActivityTireRuiFengS5.this.mUpdaterTireFR(value);
                    break;
                case 101:
                    ActivityTireRuiFengS5.this.mUpdaterTireRL(value);
                    break;
                case 102:
                    ActivityTireRuiFengS5.this.mUpdaterTireRR(value);
                    break;
                case 103:
                case 104:
                    ActivityTireRuiFengS5.this.updaterFlTipWalm();
                    break;
                case 105:
                case 106:
                    ActivityTireRuiFengS5.this.updaterFRTipWalm();
                    break;
                case 107:
                case 108:
                    ActivityTireRuiFengS5.this.updaterRLTipWalm();
                    break;
                case 109:
                case 110:
                    ActivityTireRuiFengS5.this.updaterRRTipWalm();
                    break;
            }
        }
    };
    int tempWarnState;
    int tireState;

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_376_ruifeng_s5_tire);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        for (int i = 95; i <= 110; i++) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(this.notifyCanbus, 1);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        for (int i = 95; i <= 110; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(this.notifyCanbus);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempFL(int value) {
        if (((TextView) findViewById(R.id.zt_tv_car_tire_temp_0)) != null) {
            if (value > 165) {
                ((TextView) findViewById(R.id.zt_tv_car_tire_temp_0)).setText("--");
            } else {
                ((TextView) findViewById(R.id.zt_tv_car_tire_temp_0)).setText(String.valueOf(value - 40) + " ℃");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempFR(int value) {
        if (((TextView) findViewById(R.id.zt_tv_car_tire_temp_1)) != null) {
            if (value > 165) {
                ((TextView) findViewById(R.id.zt_tv_car_tire_temp_1)).setText("--");
            } else {
                ((TextView) findViewById(R.id.zt_tv_car_tire_temp_1)).setText(String.valueOf(value - 40) + " ℃");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempRL(int value) {
        if (((TextView) findViewById(R.id.zt_tv_car_tire_temp_2)) != null) {
            if (value > 165) {
                ((TextView) findViewById(R.id.zt_tv_car_tire_temp_2)).setText("--");
            } else {
                ((TextView) findViewById(R.id.zt_tv_car_tire_temp_2)).setText(String.valueOf(value - 40) + " ℃");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempRR(int value) {
        if (((TextView) findViewById(R.id.zt_tv_car_tire_temp_3)) != null) {
            if (value > 165) {
                ((TextView) findViewById(R.id.zt_tv_car_tire_temp_3)).setText("--");
            } else {
                ((TextView) findViewById(R.id.zt_tv_car_tire_temp_3)).setText(String.valueOf(value - 40) + " ℃");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFL(int value) {
        if (((TextView) findViewById(R.id.zt_tv_car_tire_press_0)) != null) {
            if (value > 163) {
                ((TextView) findViewById(R.id.zt_tv_car_tire_press_0)).setText("--.--");
            } else {
                DecimalFormat df = new DecimalFormat("####0.00");
                ((TextView) findViewById(R.id.zt_tv_car_tire_press_0)).setText(String.valueOf(df.format(value * 2.75f)) + "Kpa");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFR(int value) {
        if (((TextView) findViewById(R.id.zt_tv_car_tire_press_1)) != null) {
            if (value > 163) {
                ((TextView) findViewById(R.id.zt_tv_car_tire_press_1)).setText("--.--");
            } else {
                DecimalFormat df = new DecimalFormat("####0.00");
                ((TextView) findViewById(R.id.zt_tv_car_tire_press_1)).setText(String.valueOf(df.format(value * 2.75f)) + "Kpa");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRL(int value) {
        if (((TextView) findViewById(R.id.zt_tv_car_tire_press_2)) != null) {
            if (value > 163) {
                ((TextView) findViewById(R.id.zt_tv_car_tire_press_2)).setText("--.--");
            } else {
                DecimalFormat df = new DecimalFormat("####0.00");
                ((TextView) findViewById(R.id.zt_tv_car_tire_press_2)).setText(String.valueOf(df.format(value * 2.75f)) + "Kpa");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRR(int value) {
        if (((TextView) findViewById(R.id.zt_tv_car_tire_press_3)) != null) {
            if (value > 163) {
                ((TextView) findViewById(R.id.zt_tv_car_tire_press_3)).setText("--.--");
            } else {
                DecimalFormat df = new DecimalFormat("####0.00");
                ((TextView) findViewById(R.id.zt_tv_car_tire_press_3)).setText(String.valueOf(df.format(value * 2.75f)) + "Kpa");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFlTipWalm() {
        if (((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)) != null) {
            this.tempWarnState = DataCanbus.DATA[103];
            this.tireState = DataCanbus.DATA[104];
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText(setTempWalmState("fl", this.tempWarnState, this.tireState));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFRTipWalm() {
        if (((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)) != null) {
            this.tempWarnState = DataCanbus.DATA[105];
            this.tireState = DataCanbus.DATA[106];
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText(setTempWalmState("fl", this.tempWarnState, this.tireState));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRLTipWalm() {
        if (((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)) != null) {
            this.tempWarnState = DataCanbus.DATA[107];
            this.tireState = DataCanbus.DATA[108];
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText(setTempWalmState("fl", this.tempWarnState, this.tireState));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRRTipWalm() {
        if (((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)) != null) {
            this.tempWarnState = DataCanbus.DATA[109];
            this.tireState = DataCanbus.DATA[110];
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText(setTempWalmState("fl", this.tempWarnState, this.tireState));
        }
    }

    private String setTempWalmState(String type, int tempState, int tireState) {
        String str;
        if (tempState == 1) {
            if (tireState == 0) {
                str = getString(R.string.wc_damaix5_str7);
            } else {
                str = String.valueOf(getString(R.string.wc_damaix5_str7)) + "  ";
            }
        } else {
            str = "";
        }
        switch (tireState) {
            case 1:
                String str2 = getString(R.string.str_376_no_sensor);
                return str2;
            case 2:
                String str3 = getString(R.string.wc_damaix5_str2);
                return str3;
            case 3:
                String str4 = getString(R.string.wc_damaix5_str4);
                return str4;
            case 4:
                String str5 = getString(R.string.wc_damaix5_str5);
                return str5;
            case 5:
                String str6 = getString(R.string.str_376_sensor_battery_low);
                return str6;
            case 6:
                String str7 = getString(R.string.zt_t600_car_chuanganqi);
                return str7;
            case 7:
                String str8 = getString(R.string.str_376_high_or_low_press_micro);
                return str8;
            default:
                return str;
        }
    }
}
