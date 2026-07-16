package com.syu.carinfo.havah6;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class WC_0320_HavalH9CarinfoAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.havah6.WC_0320_HavalH9CarinfoAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 95:
                    ((TextView) WC_0320_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_voltage_value)).setText(String.valueOf(value / 10.0f) + "V");
                    break;
                case 96:
                    ((TextView) WC_0320_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_condensate_value)).setText(String.valueOf(value - 40) + "℃");
                    break;
                case 97:
                    ((TextView) WC_0320_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_oiltemp_value)).setText(String.valueOf(value) + "℃");
                    break;
                case 106:
                    int temp = value * 45;
                    ((TextView) WC_0320_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_pressure_value)).setText(String.valueOf(temp / 10) + "." + (temp % 10) + "Kpa");
                    break;
                case 107:
                    if ((value & 128) == 128) {
                        ((TextView) WC_0320_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_slope_value)).setText(String.valueOf(String.format("-%d", Integer.valueOf(value & 127))) + "°");
                    } else {
                        ((TextView) WC_0320_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_slope_value)).setText(String.valueOf(String.format("%d", Integer.valueOf(value & 127))) + "°");
                    }
                    break;
                case 108:
                    ((TextView) WC_0320_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_torque_value)).setText(String.valueOf(String.format("%d", Integer.valueOf(value))) + "%");
                    break;
                case 109:
                    if ((value & 128) == 128) {
                        ((TextView) WC_0320_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_inclination_value)).setText(String.valueOf(String.format("-%d", Integer.valueOf(value & 127))) + "°");
                    } else {
                        ((TextView) WC_0320_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_inclination_value)).setText(String.valueOf(String.format("%d", Integer.valueOf(value & 127))) + "°");
                    }
                    break;
                case 110:
                    if (WC_0320_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_trailer_value) != null) {
                        if ((value & 128) == 128) {
                            ((TextView) WC_0320_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_trailer_value)).setText(R.string.str_mount_set);
                        } else {
                            ((TextView) WC_0320_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_trailer_value)).setText(R.string.str_nomount_set);
                        }
                    }
                    break;
                case 111:
                    if ((value & 32768) == 32768) {
                        ((TextView) WC_0320_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_altitude_value)).setText("-" + (value & 32767) + "m");
                    } else {
                        ((TextView) WC_0320_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_altitude_value)).setText((value & 32767) + "m");
                    }
                    break;
                case 152:
                    if ((value & 32768) == 32768) {
                        int value2 = (((65536 - value) / 2) * 33) / 54;
                        ((TextView) WC_0320_HavalH9CarinfoAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(String.format("L:%d.%d", Integer.valueOf(value2 / 10), Integer.valueOf(value2 % 10))) + "°");
                    } else {
                        int value3 = ((value / 2) * 33) / 54;
                        ((TextView) WC_0320_HavalH9CarinfoAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(String.format("R:%d.%d", Integer.valueOf(value3 / 10), Integer.valueOf(value3 % 10))) + "°");
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_od_havalh9carinfo);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
    }
}
