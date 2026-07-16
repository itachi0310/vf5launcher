package com.syu.carinfo.rzc.havalh6;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class BNR_Oudi_0439_HavalH9CarinfoAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.havalh6.BNR_Oudi_0439_HavalH9CarinfoAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 108:
                    ((TextView) BNR_Oudi_0439_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_pressure_value)).setText(String.valueOf(value) + "hPA");
                    break;
                case 109:
                    ((TextView) BNR_Oudi_0439_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_condensate_value)).setText(String.valueOf(value) + "℃");
                    break;
                case 110:
                    ((TextView) BNR_Oudi_0439_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_oiltemp_value)).setText(value + "℃");
                    break;
                case 111:
                    ((TextView) BNR_Oudi_0439_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_voltage_value)).setText((value / 10.0f) + "V");
                    break;
                case 112:
                    ((TextView) BNR_Oudi_0439_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_torque_value)).setText(String.valueOf(String.format("%d", Integer.valueOf(value))) + "%");
                    break;
                case 113:
                    if ((value & 128) == 128) {
                        ((TextView) BNR_Oudi_0439_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_trailer_value)).setText(R.string.str_mount_set);
                    } else {
                        ((TextView) BNR_Oudi_0439_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_trailer_value)).setText(R.string.str_nomount_set);
                    }
                    break;
                case 114:
                    if ((value & 128) == 128) {
                        ((TextView) BNR_Oudi_0439_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_inclination_value)).setText(String.valueOf(String.format("R:%d", Integer.valueOf(value & 127))) + "°");
                    } else {
                        ((TextView) BNR_Oudi_0439_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_inclination_value)).setText(String.valueOf(String.format("L:%d", Integer.valueOf(value & 127))) + "°");
                    }
                    break;
                case 115:
                    if ((value & 128) == 128) {
                        ((TextView) BNR_Oudi_0439_HavalH9CarinfoAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(String.format("R:%d", Integer.valueOf(value & 127))) + "°");
                    } else {
                        ((TextView) BNR_Oudi_0439_HavalH9CarinfoAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(String.format("L:%d", Integer.valueOf(value & 127))) + "°");
                    }
                    break;
                case 116:
                    if ((value & 128) == 128) {
                        ((TextView) BNR_Oudi_0439_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_slope_value)).setText(String.valueOf(String.format("-%d", Integer.valueOf(value & 127))) + "°");
                    } else {
                        ((TextView) BNR_Oudi_0439_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_slope_value)).setText(String.valueOf(String.format("+%d", Integer.valueOf(value & 127))) + "°");
                    }
                    break;
                case 138:
                    ((TextView) BNR_Oudi_0439_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_altitude_value)).setText(String.valueOf(value) + "m");
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
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
    }
}
