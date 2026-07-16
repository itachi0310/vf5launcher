package com.syu.carinfo.wc2.ruiqi;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class WCNissanRuiqi6CarInfo extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc2.ruiqi.WCNissanRuiqi6CarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 95:
                    ((TextView) WCNissanRuiqi6CarInfo.this.findViewById(R.id.avg_fuel)).setText(String.valueOf(value / 10) + "." + (value % 10) + "L/100km");
                    break;
                case 96:
                    if (value == 16777215) {
                        ((TextView) WCNissanRuiqi6CarInfo.this.findViewById(R.id.mileage)).setText("----km");
                    } else {
                        ((TextView) WCNissanRuiqi6CarInfo.this.findViewById(R.id.mileage)).setText(String.valueOf(value / 10) + "." + (value % 10) + "km");
                    }
                    break;
                case 97:
                    ((TextView) WCNissanRuiqi6CarInfo.this.findViewById(R.id.avg_speed)).setText(String.valueOf(value) + "km/h");
                    break;
                case 98:
                    ((TextView) WCNissanRuiqi6CarInfo.this.findViewById(R.id.voltage)).setText(String.valueOf(value / 10) + "." + (value % 10) + " V");
                    break;
                case 99:
                    ((TextView) WCNissanRuiqi6CarInfo.this.findViewById(R.id.current)).setText(String.valueOf(value / 10) + "." + (value % 10) + " A");
                    break;
                case 100:
                    ((TextView) WCNissanRuiqi6CarInfo.this.findViewById(R.id.soc_value)).setText(String.valueOf(value) + "%");
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0443_wc_ruiqi_carinfo);
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
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
    }
}
