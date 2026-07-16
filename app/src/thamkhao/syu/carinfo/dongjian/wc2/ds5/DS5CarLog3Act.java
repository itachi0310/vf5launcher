package com.syu.carinfo.dongjian.wc2.ds5;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class DS5CarLog3Act extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dongjian.wc2.ds5.DS5CarLog3Act.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 101:
                    DS5CarLog3Act.this.updaterpingjunOil3();
                    break;
                case 102:
                    DS5CarLog3Act.this.updaterpingjunSpeed3();
                    break;
                case 103:
                    DS5CarLog3Act.this.updaterleijiLicheng3();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_302_dongjian_wc2_ds5_car_log_page3);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterpingjunOil3() {
        int pingjunOil3Value = DataCanbus.DATA[101];
        if (pingjunOil3Value < 65535) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_pingjun_oil_page3_tv)).setText(((pingjunOil3Value >> 8) & 255) + "." + (pingjunOil3Value & 255) + "L/100Km");
        } else if (pingjunOil3Value == 65535) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_pingjun_oil_page3_tv)).setText("-- L/100Km");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterpingjunSpeed3() {
        int pingjunSpeed3Value = DataCanbus.DATA[102];
        if (pingjunSpeed3Value < 65535) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_pingjun_speed_page3_tv)).setText(pingjunSpeed3Value + "Km/h");
        } else if (pingjunSpeed3Value == 65535) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_pingjun_speed_page3_tv)).setText("-- Km/h");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterleijiLicheng3() {
        int allLicheng3Value = DataCanbus.DATA[103];
        if (allLicheng3Value < 65535) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_all_licheng_page3_tv)).setText(allLicheng3Value + "Km");
        } else if (allLicheng3Value == 65535) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_all_licheng_page3_tv)).setText("-- Km");
        }
    }
}
