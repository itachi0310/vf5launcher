package com.syu.carinfo.wccamry;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class CamryTireActWC extends BaseActivity {
    public static CamryTireActWC mInit;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wccamry.CamryTireActWC.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 128:
                    CamryTireActWC.this.mUpdaterTireWarn();
                    break;
                case 129:
                    CamryTireActWC.this.mUpdaterTireFL();
                    break;
                case 130:
                    CamryTireActWC.this.mUpdaterTireFR();
                    break;
                case 131:
                    CamryTireActWC.this.mUpdaterTireRL();
                    break;
                case 132:
                    CamryTireActWC.this.mUpdaterTireRR();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_oudi_zt_t600_tire);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        mInit = this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[129];
        if (value == 254) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("---");
            return;
        }
        int temp = (value / 256) + (value % 256);
        Locale locale = TheApp.getInstance().getResources().getConfiguration().locale;
        String language = locale.getCountry();
        if (language.endsWith("TW")) {
            int temp2 = (temp * 145) / 100;
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(temp2 / 10) + "." + (temp2 % 10) + "Psi");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(temp) + "kPa");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[130];
        if (value == 254) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("---");
            return;
        }
        int temp = (value / 256) + (value % 256);
        Locale locale = TheApp.getInstance().getResources().getConfiguration().locale;
        String language = locale.getCountry();
        if (language.endsWith("TW")) {
            int temp2 = (temp * 145) / 100;
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(temp2 / 10) + "." + (temp2 % 10) + "Psi");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(temp) + "kPa");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[131];
        if (value == 254) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("---");
            return;
        }
        int temp = (value / 256) + (value % 256);
        Locale locale = TheApp.getInstance().getResources().getConfiguration().locale;
        String language = locale.getCountry();
        if (language.endsWith("TW")) {
            int temp2 = (temp * 145) / 100;
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(temp2 / 10) + "." + (temp2 % 10) + "Psi");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(temp) + "kPa");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[132];
        if (value == 254) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("---");
            return;
        }
        int temp = (value / 256) + (value % 256);
        Locale locale = TheApp.getInstance().getResources().getConfiguration().locale;
        String language = locale.getCountry();
        if (language.endsWith("TW")) {
            int temp2 = (temp * 145) / 100;
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(temp2 / 10) + "." + (temp2 % 10) + "Psi");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(temp) + "kPa");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireWarn() {
        int value = DataCanbus.DATA[128];
        if (value == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflalarm);
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflalarm);
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflalarm);
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflalarm);
            return;
        }
        ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tirefrnormal);
        ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tirefrnormal);
        ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tirefrnormal);
        ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tirefrnormal);
    }
}
