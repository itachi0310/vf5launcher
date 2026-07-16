package com.syu.carinfo.wc.ruiteng;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class RuiTengMeterAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.ruiteng.RuiTengMeterAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 119:
                    RuiTengMeterAct.this.mUpdaterValue50();
                    break;
                case 120:
                    RuiTengMeterAct.this.mUpdaterValue51();
                    break;
                case 121:
                    RuiTengMeterAct.this.mUpdaterValue52();
                    break;
                case 122:
                    RuiTengMeterAct.this.mUpdaterValue53();
                    break;
                case 123:
                    RuiTengMeterAct.this.mUpdaterValue54();
                    break;
                case 139:
                    RuiTengMeterAct.this.mUpdaterValue55();
                    break;
                case 140:
                    RuiTengMeterAct.this.mUpdaterValue56();
                    break;
                case 141:
                    RuiTengMeterAct.this.mUpdaterValue57();
                    break;
                case 142:
                    RuiTengMeterAct.this.mUpdaterValue58();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_wc_ruiteng_meter_info);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue50() {
        int value = DataCanbus.DATA[119];
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_motor_speed)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_motor_speed)).setText("--");
            } else {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_motor_speed)).setText(new StringBuilder().append(value).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue51() {
        int value = DataCanbus.DATA[120];
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_shunshi_speed)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_shunshi_speed)).setText("--");
            } else {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_shunshi_speed)).setText(new StringBuilder().append(value).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue52() {
        int value = DataCanbus.DATA[121];
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_battery_voltage)) != null) {
            ((TextView) findViewById(R.id.wc_ruiteng_func_btn_battery_voltage)).setText(String.valueOf(value / 10.0f) + "V");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue53() {
        int value = DataCanbus.DATA[122];
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_integrity_door_position)) != null) {
            if (value == 255) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_integrity_door_position)).setText("-");
            } else if (value >= 0 && value <= 100) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_integrity_door_position)).setText(String.valueOf(value) + "%");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue54() {
        int value = DataCanbus.DATA[123];
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_remaining_oil)) != null && value >= 0 && value <= 100) {
            ((TextView) findViewById(R.id.wc_ruiteng_func_btn_remaining_oil)).setText(String.valueOf(value) + "%");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue55() {
        int value = DataCanbus.DATA[139];
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_motor_speed)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_motor_speed)).setText(new StringBuilder().append(DataCanbus.DATA[119]).toString());
            } else {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_motor_speed)).setText(getResources().getString(R.string.wc_ruiteng_string_no_support));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue56() {
        int value = DataCanbus.DATA[140];
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_shunshi_speed)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_shunshi_speed)).setText(new StringBuilder().append(DataCanbus.DATA[120]).toString());
            } else {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_shunshi_speed)).setText(getResources().getString(R.string.wc_ruiteng_string_no_support));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue57() {
        int value = DataCanbus.DATA[141];
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_battery_voltage)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_battery_voltage)).setText(new StringBuilder().append(DataCanbus.DATA[121]).toString());
            } else {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_battery_voltage)).setText(getResources().getString(R.string.wc_ruiteng_string_no_support));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue58() {
        int value = DataCanbus.DATA[142];
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_integrity_door_position)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_integrity_door_position)).setText(new StringBuilder().append(DataCanbus.DATA[122]).toString());
            } else {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_integrity_door_position)).setText(getResources().getString(R.string.wc_ruiteng_string_no_support));
            }
        }
    }
}
