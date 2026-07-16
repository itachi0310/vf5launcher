package com.syu.carinfo.jili;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes.dex */
public class YuanjingX3TireAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.jili.YuanjingX3TireAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 114:
                    if (((value >> 1) & 1) != 0) {
                        ((TextView) YuanjingX3TireAct.this.findViewById(R.id.oudi_changan_tire1_temp)).setTextColor(-65536);
                    } else {
                        ((TextView) YuanjingX3TireAct.this.findViewById(R.id.oudi_changan_tire1_temp)).setTextColor(-1);
                    }
                    YuanjingX3TireAct.this.updaterFLWalm();
                    break;
                case 115:
                    if (((value >> 1) & 1) != 0) {
                        ((TextView) YuanjingX3TireAct.this.findViewById(R.id.oudi_changan_tire2_temp)).setTextColor(-65536);
                    } else {
                        ((TextView) YuanjingX3TireAct.this.findViewById(R.id.oudi_changan_tire2_temp)).setTextColor(-1);
                    }
                    YuanjingX3TireAct.this.updaterFRWalm();
                    break;
                case 116:
                    if (((value >> 1) & 1) != 0) {
                        ((TextView) YuanjingX3TireAct.this.findViewById(R.id.oudi_changan_tire3_temp)).setTextColor(-65536);
                    } else {
                        ((TextView) YuanjingX3TireAct.this.findViewById(R.id.oudi_changan_tire3_temp)).setTextColor(-1);
                    }
                    YuanjingX3TireAct.this.updaterRLWalm();
                    break;
                case 117:
                    if (((value >> 1) & 1) != 0) {
                        ((TextView) YuanjingX3TireAct.this.findViewById(R.id.oudi_changan_tire4_temp)).setTextColor(-65536);
                    } else {
                        ((TextView) YuanjingX3TireAct.this.findViewById(R.id.oudi_changan_tire4_temp)).setTextColor(-1);
                    }
                    YuanjingX3TireAct.this.updaterRRWalm();
                    break;
                case 118:
                    YuanjingX3TireAct.this.mUpdaterTireFL();
                    break;
                case 119:
                    YuanjingX3TireAct.this.mUpdaterTireFR();
                    break;
                case 120:
                    YuanjingX3TireAct.this.mUpdaterTireRL();
                    break;
                case 121:
                    YuanjingX3TireAct.this.mUpdaterTireRR();
                    break;
                case 122:
                    YuanjingX3TireAct.this.updaterTempFL();
                    break;
                case 123:
                    YuanjingX3TireAct.this.updaterTempFR();
                    break;
                case 124:
                    YuanjingX3TireAct.this.updaterTempRL();
                    break;
                case 125:
                    YuanjingX3TireAct.this.updaterTempRR();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (TheApp.getConfiguration() == 1) {
            setContentView(R.layout.layout_xbs_tule_tire);
        } else {
            setContentView(R.layout.layout_oudi_zt_t600_tire);
        }
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.notifyCanbus);
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempFL() {
        int value = DataCanbus.DATA[122];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 50)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempFR() {
        int value = DataCanbus.DATA[123];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 50)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempRL() {
        int value = DataCanbus.DATA[124];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 50)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempRR() {
        int value = DataCanbus.DATA[125];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 50)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[118];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("--.--");
            return;
        }
        int value2 = (int) (((double) value) * 1.373d * 100.0d);
        if (((TextView) findViewById(R.id.oudi_changan_tire1)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(df.format(value2 / 100.0f)) + "Kpa");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[119];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("--.--");
            return;
        }
        int value2 = (int) (((double) value) * 1.373d * 100.0d);
        if (((TextView) findViewById(R.id.oudi_changan_tire2)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(df.format(value2 / 100.0f)) + "Kpa");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[120];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("--.--");
            return;
        }
        int value2 = (int) (((double) value) * 1.373d * 100.0d);
        if (((TextView) findViewById(R.id.oudi_changan_tire3)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(df.format(value2 / 100.0f)) + "Kpa");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[121];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("--.--");
            return;
        }
        int value2 = (int) (((double) value) * 1.373d * 100.0d);
        if (((TextView) findViewById(R.id.oudi_changan_tire4)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(df.format(value2 / 100.0f)) + "Kpa");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFLWalm() {
        int system = (DataCanbus.DATA[114] >> 0) & 1;
        int value = (DataCanbus.DATA[114] >> 2) & 3;
        int value1 = (DataCanbus.DATA[114] >> 4) & 1;
        if (system != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.str_390_sensor_failure);
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
        }
        if (value1 != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.wc_damaix5_str2);
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
            return;
        }
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.xp_yinglang_tire_str02);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
                break;
            case 2:
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.xp_yinglang_tire_str01);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
                break;
            default:
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflnormal);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-1);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFRWalm() {
        int system = (DataCanbus.DATA[115] >> 0) & 1;
        int value = (DataCanbus.DATA[115] >> 2) & 3;
        int value1 = (DataCanbus.DATA[115] >> 4) & 1;
        if (system != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.str_390_sensor_failure);
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
        }
        if (value1 != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.wc_damaix5_str2);
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
            return;
        }
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.xp_yinglang_tire_str02);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
                break;
            case 2:
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.xp_yinglang_tire_str01);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
                break;
            default:
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflnormal);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-1);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRLWalm() {
        int system = (DataCanbus.DATA[116] >> 0) & 1;
        int value = (DataCanbus.DATA[116] >> 2) & 3;
        int value1 = (DataCanbus.DATA[116] >> 4) & 1;
        if (system != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.str_390_sensor_failure);
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
        }
        if (value1 != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.wc_damaix5_str2);
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
            return;
        }
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.xp_yinglang_tire_str02);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
                break;
            case 2:
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.xp_yinglang_tire_str01);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
                break;
            default:
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflnormal);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-1);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRRWalm() {
        int system = (DataCanbus.DATA[117] >> 0) & 1;
        int value = (DataCanbus.DATA[117] >> 2) & 3;
        int value1 = (DataCanbus.DATA[117] >> 4) & 1;
        if (system != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.str_390_sensor_failure);
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
        }
        if (value1 != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.wc_damaix5_str2);
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
            return;
        }
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.xp_yinglang_tire_str02);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
                break;
            case 2:
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.xp_yinglang_tire_str01);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
                break;
            default:
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflnormal);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-1);
                break;
        }
    }
}
