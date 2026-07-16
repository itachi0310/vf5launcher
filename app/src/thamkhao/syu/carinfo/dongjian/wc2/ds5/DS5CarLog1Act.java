package com.syu.carinfo.dongjian.wc2.ds5;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class DS5CarLog1Act extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dongjian.wc2.ds5.DS5CarLog1Act.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 96:
                    DS5CarLog1Act.this.updaterpingjunOil();
                    break;
                case 97:
                    DS5CarLog1Act.this.updaterlastoilLicheng();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_302_dongjian_wc2_ds5_car_log_page1);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterpingjunOil() {
        int pingjunOilValue = DataCanbus.DATA[96];
        if (pingjunOilValue < 65535) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_pingjun_oil_tv)).setText(((pingjunOilValue >> 8) & 255) + "." + (pingjunOilValue & 255) + "L/100Km");
        } else if (pingjunOilValue == 65535) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_pingjun_oil_tv)).setText("-- L/100Km");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterlastoilLicheng() {
        int lastOilLichengValue = DataCanbus.DATA[97];
        if (lastOilLichengValue < 65535) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_last_oil_licheng_tv)).setText(lastOilLichengValue + "Km");
        } else if (lastOilLichengValue == 65535) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_last_oil_licheng_tv)).setText("-- Km");
        }
    }
}
