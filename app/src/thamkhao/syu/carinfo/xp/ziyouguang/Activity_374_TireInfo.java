package com.syu.carinfo.xp.ziyouguang;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class Activity_374_TireInfo extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.Activity_374_TireInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 401:
                    Activity_374_TireInfo.this.mUpdaterTireFL();
                    Activity_374_TireInfo.this.mUpdaterTireFR();
                    Activity_374_TireInfo.this.mUpdaterTireRL();
                    Activity_374_TireInfo.this.mUpdaterTireRR();
                    break;
                case 402:
                    Activity_374_TireInfo.this.mUpdaterTireFL();
                    break;
                case 403:
                    Activity_374_TireInfo.this.mUpdaterTireFR();
                    break;
                case 404:
                    Activity_374_TireInfo.this.mUpdaterTireRL();
                    break;
                case 405:
                    Activity_374_TireInfo.this.mUpdaterTireRR();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xbs_tule_tire);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[401].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[402].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[403].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[404].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[405].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[401].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[402].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[403].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[404].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[405].removeNotify(this.notifyCanbus);
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[402];
        int unit = DataCanbus.DATA[401];
        if (value == 65535) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("--.--");
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire1)) != null) {
            switch (unit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value * 0.1f) + "Kpa");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value * 0.1f) + "PSI");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value * 0.1f) + "BAR");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[403];
        int unit = DataCanbus.DATA[401];
        if (value == 65535) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("--.--");
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire2)) != null) {
            switch (unit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value * 0.1f) + "Kpa");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value * 0.1f) + "PSI");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value * 0.1f) + "BAR");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[404];
        int unit = DataCanbus.DATA[401];
        if (value == 65535) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("--.--");
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire3)) != null) {
            switch (unit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value * 0.1f) + "Kpa");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value * 0.1f) + "PSI");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value * 0.1f) + "BAR");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[405];
        int unit = DataCanbus.DATA[401];
        if (value == 65535) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("--.--");
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire4)) != null) {
            switch (unit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value * 0.1f) + "Kpa");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value * 0.1f) + "PSI");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value * 0.1f) + "BAR");
                    break;
            }
        }
    }
}
