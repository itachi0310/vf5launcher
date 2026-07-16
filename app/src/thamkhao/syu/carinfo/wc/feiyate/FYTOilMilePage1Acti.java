package com.syu.carinfo.wc.feiyate;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class FYTOilMilePage1Acti extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.feiyate.FYTOilMilePage1Acti.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 95:
                case 109:
                    FYTOilMilePage1Acti.this.mUpdaterOilExpend();
                case 96:
                    FYTOilMilePage1Acti.this.mUpdaterDrivingMileage();
                case 97:
                    FYTOilMilePage1Acti.this.mUpdaterDivedMile();
                case 108:
                    FYTOilMilePage1Acti.this.mUpdaterDrivingMileage();
                    FYTOilMilePage1Acti.this.mUpdaterDivedMile();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_fyt_all_oil_page1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterOilExpend() {
        int value = DataCanbus.DATA[95];
        int value1 = DataCanbus.DATA[109] & 255;
        if (((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv1)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv1)).setText("--.--");
            }
            switch (value1) {
                case 0:
                    ((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + "L/100KM");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + "km/l");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + "mpg(us)");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + "mpg(uk)");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDrivingMileage() {
        int value = DataCanbus.DATA[96];
        int unit = DataCanbus.DATA[108] & 255;
        if (((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv2)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv2)).setText("----");
            } else if (unit == 1) {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv2)).setText(String.valueOf(value) + " KM");
            } else {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv2)).setText(String.valueOf(value) + " Mil");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDivedMile() {
        int value = DataCanbus.DATA[97];
        int unit = DataCanbus.DATA[108];
        if (((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv3)) != null) {
            if (value == 16777215) {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv3)).setText("----");
            } else if (unit == 1) {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv3)).setText(String.valueOf(value) + " KM");
            } else {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv3)).setText(String.valueOf(value) + " Mil");
            }
        }
    }
}
